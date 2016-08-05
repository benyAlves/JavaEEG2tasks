package moz.dev.group.tasks.model;

import java.util.Arrays;

public enum TaskState 
{
	NOT_STARTED,EXECUTING,WAIT,CANCELED,SUCESSFUL;

    public static TaskState get(String dbData) 
    {
       return Arrays.asList(TaskState.values()).stream().filter((e)->e.name().equalsIgnoreCase(dbData))
               .findFirst().orElse(null);
    }
    
    public static boolean canChange(TaskState from,TaskState to)
    {
            switch (from) 
            {
                case NOT_STARTED:
                    return EXECUTING.equals(to) || CANCELED.equals(to);
                case EXECUTING:
                    return WAIT.equals(to) || CANCELED.equals(to) || SUCESSFUL.equals(to);
                case WAIT:
                    return EXECUTING.equals(to) || CANCELED.equals(to) || SUCESSFUL.equals(to);
                case CANCELED:
                case SUCESSFUL:
                    return false;
                default:return false;
            }
    }
}
