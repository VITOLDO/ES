package com.epam.tradingsystem.broker.web.converters;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Implement Converter for output decimals numbers.
 * For manage decimal size use attribute with name = "sizeDecimal" and 
 * enter size on value. 
 * Example:
 * f:attribute name="sizeDecimal" value="4" 
 * 
 * @author olexii_grachev
 *
 */
public class DecimalConverter implements Converter{
	private final int DEFAULT_SIZE_DECIMAL = 2;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		//Does it make sense?
		if (value == null) {
			return null;
		}
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Integer sizeDecimal = null;		
		try {
			sizeDecimal = Integer.parseInt(component.getAttributes().get("sizeDecimal").toString());
		} catch (Exception e) {
			sizeDecimal = DEFAULT_SIZE_DECIMAL;
		}
		
		if (value == null) {
			Logger.getLogger("file_log").
			log(Level.SEVERE, 
					DecimalConverter.class.getName() + ".getAsString(): value = null");
			return null;
		}
		
		String format = "%." + sizeDecimal + "f";
		
		return String.format(format, value);
	}

}
