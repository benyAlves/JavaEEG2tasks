/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author delfi
 */
public class PostRequest implements Serializable
{
    private String operation;
    private Object value;

    public String getOperation() 
    {
        return operation;
    }

    public void setOperation(String operation) 
    {
        this.operation = operation;
    }

    public Object getValue() 
    {
        return value;
    }

    public void setValue(Object value) 
    {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PostRequest{" + "operation=" + operation + ", value=" + value + '}';
    }
    
    
}
