/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author delfi
 */
public class LocalDateTimeJsonDeserializer extends StdDeserializer<LocalDateTime>
{

    public LocalDateTimeJsonDeserializer() 
    {
        this(null);
    }
    
    public LocalDateTimeJsonDeserializer(Class<LocalDateTime>t) 
    {
        super(t);
    }
    

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException 
    {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
         return LocalDateTime.parse(jp.getText(), formatter);
    }
/*
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException 
    {
     
    }
  */  
}
