var userName = "";
var pass = "";

$(function() {
    if (!isLogin()) {
        window.location.replace("http://127.0.0.1:5500/html/Login.html");
    }

    $(".header").load("header.html", function() {
        document.getElementById("loginUserName").innerHTML = getCookie(KEY_USERNAME);
    });
    $(".main").load("home.html");
    $(".footer").load("footer.html");

    userName = getCookie(KEY_USERNAME);
    pass = getCookie(KEY_PASS);
});

function isLogin() {
    if (getCookie(KEY_USERNAME)) {
        return true;
    }
    return false;
}

function logout() {
    deleteCookie(KEY_USERNAME);
    deleteCookie(KEY_PASS);

    window.location.replace("http://127.0.0.1:5500/html/Login.html");
}

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListAccounts() {
    $(".main").load("ViewList.html", function() {
        buildTable();
    });
}

function refresh() {
    resetTable();
    clickNavViewListAccounts();
}

var accounts = [];
var currentPage = 1;
var size = 10;
var sortField = "createDate";
var isAsc = false;

// call API from server
function getListAccounts() {

    var urlPath = 'http://localhost:8080/api/v1/accounts';

    urlPath += "?page=" + currentPage + "&size=" + size;

    urlPath += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

    $.ajax({
        url: urlPath,
        type: 'GET',
        // data: JSON.stringify(account), // body
        contentType: "application/json", // type of body (json, xml, text)
        dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(getCookie(KEY_USERNAME) + ":" + getCookie(KEY_PASS)));
        },
        success: function(data, textStatus, xhr) {
            // reset list employees
            accounts = [];
            console.log(data);
            // success
            accounts = data.content;
            fillAccountToTable();
            pagingTable(data.totalPages);
            renderSortUI();
            resetDeleteCheckbox();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

// $.get("http://localhost:8080/api/v1/accounts", function(data, status) {

//     // reset list employees
//     accounts = [];

//     // error
//     if (status == "error") {
//         // TODO
//         alert("Error when loading data");
//         return;
//     }

//     // success
//     accounts = data;
//     fillAccountToTable();
// });


function pagingTable(pageAmount) {
    var pagingStr = "";

    if (pageAmount > 1 && currentPage > 1) {
        pagingStr += '<li class="page-item"><a class="page-link" onClick="prevPaging()">Previous</a></li>';
    }

    for (i = 0; i < pageAmount; i++) {
        pagingStr += '<li class="page-item ' + (currentPage == i + 1 ? "active" : "") + '"><a class="page-link" onClick="changePage(' + (i + 1) + ')">' + (i + 1) + '</a></li>';
    }

    if (pageAmount > 1 && currentPage < pageAmount) {
        pagingStr += '<li class="page-item"><a class="page-link" onClick="nextPaging()">Next</a></li>';
    }

    $('#pagination').empty();
    $('#pagination').append(pagingStr);
}

function changePage(page) {
    if (page == currentPage) {
        return;
    }
    currentPage = page;
    buildTable();
}

function prevPaging() {
    changePage(currentPage - 1);
}

function nextPaging() {
    changePage(currentPage + 1);
}

function resetPaging() {
    currentPage = 1;
    size = 10;
}

function changeSort(field) {
    if (field == sortField) {
        isAsc = !isAsc;
    } else {
        sortField = field;
        isAsc = true;
    }
    buildTable();
}

function resetSort() {
    sortField = "createDate";
    isAsc = false;
}

function renderSortUI() {
    var sortTypeClazz = isAsc ? "fa-sort-asc" : "fa-sort-desc";

    switch (sortField) {
        case 'userName':
            changeIconSort("heading-userName", sortTypeClazz);
            changeIconSort("heading-fullName", "fa-sort");
            changeIconSort("heading-email", "fa-sort");
            changeIconSort("heading-department", "fa-sort");
            break;
        case 'fullName':
            changeIconSort("heading-fullName", sortTypeClazz);
            changeIconSort("heading-userName", "fa-sort");
            changeIconSort("heading-email", "fa-sort");
            changeIconSort("heading-department", "fa-sort");
            break;
        case 'email':
            changeIconSort("heading-email", sortTypeClazz);
            changeIconSort("heading-userName", "fa-sort");
            changeIconSort("heading-fullName", "fa-sort");
            changeIconSort("heading-department", "fa-sort");
            break;
        case 'department':
            changeIconSort("heading-department", sortTypeClazz);
            changeIconSort("heading-userName", "fa-sort");
            changeIconSort("heading-fullName", "fa-sort");
            changeIconSort("heading-email", "fa-sort");
            break;
        default:
            changeIconSort("heading-userName", "fa-sort");
            changeIconSort("heading-fullName", "fa-sort");
            changeIconSort("heading-email", "fa-sort");
            changeIconSort("heading-department", "fa-sort");
            break;
    }
}

function changeIconSort(id, sortTypeClazz) {
    document.getElementById(id).classList.remove("fa-sort", "fa-sort-asc", "fa-sort-desc");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function resetTable() {
    resetDeleteCheckbox();
    resetPaging();
    resetSort();

}

function fillAccountToTable() {
    accounts.forEach(function(item, index) {
        $('tbody').append(
            '<tr>' +
            // '<td>' + item.id + '</td>' +
            '<td><input id="checkbox-' + index + '" type="checkbox" onclick = "onChangeCheckboxItem()"></td>' +
            '<td>' + item.userName + '</td>' +
            '<td>' + item.fullName + '</td>' +
            '<td>' + item.email + '</td>' +
            '<td>' + item.departmentName + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });

}

function buildTable() {
    $('tbody').empty();
    getListAccounts();
}

function openAddModal() {
    openModal();
    resetFormAdd();
}

function resetFormAdd() {
    document.getElementById("titleModal").innerHTML = "Add Account";
    document.getElementById("txtId").value = "";
    document.getElementById("txtFullName").value = "";
    document.getElementById("txtEmail").value = "";
    document.getElementById("txtUserName").value = "";
    document.getElementById("txtDepartment").value = "";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function addAccount() {
    // get data
    var fullName = document.getElementById("txtFullName").value;
    var email = document.getElementById("txtEmail").value;
    var userName = document.getElementById("txtUserName").value;
    var departmentName = document.getElementById("txtDepartment").value;

    // TODO validate
    // then fail validate ==> return;

    var account = {
        fullName: fullName,
        email: email,
        userName: userName,
        departmentName: departmentName
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts',
        type: 'POST',
        data: JSON.stringify(account), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(getCookie(KEY_USERNAME) + ":" + getCookie(KEY_PASS)));
        },
        success: function(data, textStatus, xhr) {
            console.log(data);
            // success
            hideModal();
            showSuccessAlert();
            resetTable();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }

    });
}

function resetFormUpdate() {
    document.getElementById("titleModal").innerHTML = "Update Account";
    document.getElementById("txtId").value = "";
    document.getElementById("txtFullName").value = "";
    document.getElementById("txtEmail").value = "";
    document.getElementById("txtUserName").value = "";
    document.getElementById("txtDepartment").value = "";
}

function openUpdateModal(id) {
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + id,
        type: 'GET',
        // data: JSON.stringify(account), // body
        contentType: "application/json", // type of body (json, xml, text)
        dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(getCookie(KEY_USERNAME) + ":" + getCookie(KEY_PASS)));
        },
        success: function(data, textStatus, xhr) {
            // error
            if (status == "error") {
                // TODO
                alert("Error when loading data");
                return;
            }

            // success
            openModal();
            resetFormUpdate();

            // fill data
            document.getElementById("txtId").value = data.id;
            document.getElementById("txtFullName").value = data.fullName;
            document.getElementById("txtEmail").value = data.email;
            document.getElementById("txtUserName").value = data.userName;
            document.getElementById("txtDepartment").value = data.departmentName;
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

    // $.get("http://localhost:8080/api/v1/accounts/" + id, function(data, status) {

    //     // error
    //     if (status == "error") {
    //         // TODO
    //         alert("Error when loading data");
    //         return;
    //     }

    //     // success
    //     openModal();
    //     resetFormUpdate();

    //     // fill data
    //     document.getElementById("txtId").value = data.id;
    //     document.getElementById("txtFullName").value = data.fullName;
    //     document.getElementById("txtEmail").value = data.email;
    //     document.getElementById("txtUserName").value = data.userName;
    //     document.getElementById("txtDepartment").value = data.departmentName;
    // });
}

function save() {
    var id = document.getElementById("txtId").value;

    if (id == null || id == "") {
        addAccount();
    } else {
        updateAccount();
    }
}

function updateAccount() {
    var id = document.getElementById("txtId").value;
    var fullName = document.getElementById("txtFullName").value;
    var email = document.getElementById("txtEmail").value;
    var userName = document.getElementById("txtUserName").value;
    var departmentName = document.getElementById("txtDepartment").value;

    // TODO validate
    // then fail validate ==> return;

    var account = {
        fullName: fullName,
        email: email,
        userName: userName,
        departmentName: departmentName
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + id,
        type: 'PUT',
        data: JSON.stringify(account), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(getCookie(KEY_USERNAME) + ":" + getCookie(KEY_PASS)));
        },
        success: function(data, textStatus, xhr) {
            console.log(data);
            // success
            hideModal();
            showSuccessAlert();
            resetTable();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function onChangeCheckboxItem() {
    var isCheckedAll = true;
    var i = 0;
    while (true) {
        var checboxItem = document.getElementById("checkbox-" + i);
        if (checboxItem !== undefined && checboxItem !== null) {
            if (!checboxItem.checked) {
                document.getElementById("checkbox-all").checked = false;
                return;
            }
            i++;
        } else {
            break;
        }
    }

    document.getElementById("checkbox-all").checked = true;
}

function onChangeCheckboxAll() {
    var i = 0;
    while (true) {
        var checboxItem = document.getElementById("checkbox-" + i);
        if (checboxItem !== undefined && checboxItem !== null) {
            checboxItem.checked = document.getElementById("checkbox-all").checked;
            // if (document.getElementById("checkbox-all").checked) {
            //     checboxItem.checked = true;
            // } else {
            //     checboxItem.checked = false;
            // }
            i++;
        } else {
            break;
        }
    }
}

function openConfirmDelete(id) {
    // get index from employee's id
    var index = accounts.findIndex(x => x.id == id);
    var name = accounts[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteAccount(id);
    }
}

function deleteAccount(id) {
    // TODO validate
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + id,
        type: 'DELETE',
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(getCookie(KEY_USERNAME) + ":" + getCookie(KEY_PASS)));
        },
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            resetTable();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

    // $.ajax({
    //     url: 'http://localhost:8080/api/v1/accounts/' + id,
    //     type: 'DELETE',
    //     success: function(result) {
    //         // error
    //         if (result == undefined || result == null) {
    //             alert("Error when loading data");
    //             return;
    //         }

    //         // success
    //         showSuccessAlert();
    //         buildTable();
    //     }
    // });
}

function deleteAllAccount() {
    // get checked
    var ids = [];
    var i = 0;
    var names = [];
    while (true) {
        var checboxItem = document.getElementById("checkbox-" + i);
        if (checboxItem !== undefined && checboxItem !== null) {
            if (checboxItem.checked) {
                ids.push(accounts[i].id);
                names.push(accounts[i].name);
            }
            i++;
        } else {
            break;
        }
    }

    console.log(ids);

    // open confirm
    var result = confirm("Want to delete " + names + "?");
    if (result) {
        $.ajax({
            url: 'http://localhost:8080/api/v1/accounts?ids=' + ids,
            type: 'DELETE',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(getCookie(KEY_USERNAME) + ":" + getCookie(KEY_PASS)));
            },
            success: function(result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }

                // success
                showSuccessAlert();
                resetTable();
                buildTable();
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    }


}

function resetDeleteCheckbox() {
    // reset delete all checkbox
    document.getElementById("checkbox-all").checked = false;

    // reset item
    var i = 0;
    while (true) {
        var checboxItem = document.getElementById("checkbox-" + i);
        if (checboxItem !== undefined && checboxItem !== null) {
            checboxItem.checked = false;
            i++;
        } else {
            break;
        }
    }
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}

function searchItem() {

    var dataInput = $("#input_search").val();

    var urlPath = "http://localhost:8080/api/v1/accounts?search=" + dataInput + "&email=" + dataInput + "&fullName=" + dataInput + "&departmentName=" + dataInput;

    $.ajax({
        url: urlPath,
        type: 'GET',
        // data: JSON.stringify(account), // body
        contentType: "application/json", // type of body (json, xml, text)
        dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(getCookie(KEY_USERNAME) + ":" + getCookie(KEY_PASS)));
        },
        success: function(data, textStatus, xhr) {
            // reset list employees
            accounts = [];

            // success
            accounts = data.content;
            $('tbody').empty();
            fillAccountToTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
    // $.get(urlPath, function(data, status) {

    //     // reset list employees
    //     accounts = [];

    //     // error
    //     if (status == "error") {
    //         // TODO
    //         alert("Error when loading data");
    //         return;
    //     }

    //     // success
    //     accounts = data;
    //     $('tbody').empty();
    //     fillAccountToTable();
    // });
}

function handKeyUpEventForSearching(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
        searchItem();
    }
}