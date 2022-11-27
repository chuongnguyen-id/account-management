package com.vti.entity;

public enum PositionName {

	D1("DEV1"), D2("DEV2"), T("TEST"), PM("PM"), L("LEADER"), SM("SCRUM_MASTER");
	
	private String positionName;
	
	private PositionName(String positionName) {
		this.positionName = positionName;
	}
	
	public String getPositionName() {
		return positionName;
	}
	
	public static PositionName toEnum(String sqlPositionName) {
		for (PositionName item : PositionName.values()) {
			if (item.getPositionName().equals(sqlPositionName)) {
				return item;
			}
		}
		return null;
	}
}
