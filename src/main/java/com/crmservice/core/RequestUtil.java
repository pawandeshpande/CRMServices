package com.crmservice.core;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

public class RequestUtil {
    private Base64 base64codec;
    HttpServletRequest request;

    public RequestUtil(HttpServletRequest _req) throws ServletException,
                                                       IOException {
        request = _req;
    }

	public ServletAction getAction(String action) {
		String ActionClass = "";
		if (null == action)
			return ServletActionFactory
					.createAction("com.crmservice.action.IllegalAction");
        byte[] decodeAction = Base64.decodeBase64(action);
      //  System.out.println(new String(decodeAction, "UTF-8") + "\n");
      // byte[] decodedAction = base64codec.decode(action) ;
			ActionClass = new String(decodeAction);
		return ServletActionFactory.createAction(ActionClass);

    }

}
