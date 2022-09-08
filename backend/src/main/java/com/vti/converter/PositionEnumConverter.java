package com.vti.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.PositionName;

@Converter(autoApply = true)
public class PositionEnumConverter implements AttributeConverter<PositionName, String>{

	@Override
	public String convertToDatabaseColumn(PositionName attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getPositionName();
	}

	@Override
	public PositionName convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return PositionName.toEnum(dbData);
	}

	
}
