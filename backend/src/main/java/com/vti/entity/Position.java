package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.converter.PositionEnumConverter;

@Entity
@Table(name = "`Position`")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "PositionName", nullable = false)
	@Convert(converter = PositionEnumConverter.class)
	private PositionName positionName;

	public Position() {
		super();
	}
	
	public Position(int id, PositionName positionName) {
		super();
		this.id = id;
		this.positionName = positionName;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public PositionName getPositionName() {
		return positionName;
	}


	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}


	@Override
	public String toString() {
		return "Position [id=" + id + ", positionName=" + positionName + "]";
	}
}
