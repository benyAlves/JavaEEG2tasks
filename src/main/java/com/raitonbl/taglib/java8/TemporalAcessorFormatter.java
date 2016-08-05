package com.raitonbl.taglib.java8;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class TemporalAcessorFormatter extends  TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 205606909504959597L;
	private TemporalAccessor value;
	private String pattern;
	public TemporalAcessorFormatter() 
	{
	} 
	
    /**
     * doStartTag
     *
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    public int doStartTag() throws JspException
    {
    	try
    	{
    	   if(Optional.ofNullable(pattern).orElse("").isEmpty())
    		  this. pattern="dd-MM-yyyy HH:mm";
    		   
    	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
           pageContext.getOut().print(formatter.format(value)); 
    	}
    	catch
    	(IOException e)
    	{
            throw new JspException(e.getMessage()); 
    	}
           return SKIP_BODY;
    }

	public TemporalAccessor getValue() {
		return value;
	}

	public void setValue(TemporalAccessor value) {
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

    
	

    
}
