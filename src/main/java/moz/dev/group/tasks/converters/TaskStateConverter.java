package moz.dev.group.tasks.converters;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import moz.dev.group.tasks.model.TaskState;

@Converter(autoApply = true)
public class TaskStateConverter implements AttributeConverter<TaskState,String> 
{

    @Override
    public String convertToDatabaseColumn(TaskState attribute) 
    {
       return attribute.name();
    }

    @Override
    public TaskState convertToEntityAttribute(String dbData)
    {
        return TaskState.get(dbData);
    }



}