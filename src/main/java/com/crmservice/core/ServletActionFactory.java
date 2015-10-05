package com.crmservice.core;


abstract class ServletActionFactory {
/**
* Instantiate and return the appropriate
* Action object
*/
public static ServletAction createAction(String _actionClass)
{

ServletAction action = null;
try {
//actionObj = Class.forName(_actionClass);
action = (ServletAction) (Class.forName(_actionClass)).newInstance();
}
catch (Exception e) {
            e.printStackTrace();
            
        }
return action;
}


}
