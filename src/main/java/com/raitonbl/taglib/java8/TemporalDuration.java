package com.raitonbl.taglib.java8;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class TemporalDuration extends  TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 205606909504959597L;
	private LocalDateTime begin;
        private LocalDateTime end;
        
	public TemporalDuration() 
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
           
          Duration duration;
          if(begin.isBefore(end))
            duration=Duration.between(begin, end);
          else
            duration=Duration.between(end,begin);
          
           
    	  long hours = duration.toHours();
          long minutes = duration.minusHours(hours).toMinutes();
          String value = ((hours>=0 && hours<10) ? "0"+hours :hours) + ":" + ((minutes>=0 && minutes<10) ? "0"+minutes :+minutes);
          pageContext.getOut().print(value); 
    	}
    	catch
    	(IOException e)
    	{
            throw new JspException(e.getMessage()); 
    	}
           return SKIP_BODY;
    }

    public TemporalAccessor getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    

    
	

    
}
