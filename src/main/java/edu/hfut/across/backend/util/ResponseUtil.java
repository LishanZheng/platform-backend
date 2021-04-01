package edu.hfut.across.backend.util;

import edu.hfut.across.backend.constant.GlobalResponseCode;
import edu.hfut.across.backend.entity.Response;

public class ResponseUtil {

    public static Response success(String msg, Object object){
        Response response = new Response();
        response.setCode(GlobalResponseCode.SUCCESS);
        response.setMsg(msg);
        response.setData(object);
        return response;
    }

    public static Response success(String msg) {
        Response response = new Response();
        response.setCode(GlobalResponseCode.SUCCESS);
        response.setMsg(msg);
        return response;
    }

    public static Response error(String msg) {
        Response response = new Response();
        response.setCode(GlobalResponseCode.ERROR);
        response.setMsg(msg);
        return response;
    }
}
