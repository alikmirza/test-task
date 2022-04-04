package az.test.testtask.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Component
public class LogUtil {

    private static LogDetail logDetail;

    public LogUtil(LogDetail logDetail) {
        LogUtil.logDetail = logDetail;
    }

    /**
     * Method works with 2 objects in list minimum ,
     * this means that it works in pair
     * First element will act as key and second element
     * will act as value. 3th elem - key 4th elem - value
     * and so till the end.
     * Sample : request("key","value");
     *
     * @param objs
     * @return String
     */
    public static String request(Object... objs) {

        StringBuilder result = new StringBuilder(
                "Ip='" + logDetail.getIp()
                        + "', key='" + logDetail.getRequestKey()
                        + "', Path='" + logDetail.getRequestPath());
        result.append("', request : ");


        Map<String, Object> map = keyVal(Arrays.asList(objs));

        map.forEach((k, v) -> result.append(k).append(" = ").append(toStr(v)).append("; "));
        return result.toString();
    }

    public static String response(String message) {
        return "Ip='" + logDetail.getIp()
                + "', key='" + logDetail.getRequestKey()
                + "', Path='" + logDetail.getRequestPath()
                + "', response: " + message;
    }

    public static String response(String message, Object o) {
        return "Ip='" + logDetail.getIp()
                + "', key='" + logDetail.getRequestKey()
                + "', Path='" + logDetail.getRequestPath()
                + "', response: " + message
                + "', obj: " + toStr(o);
    }

    private static String toStr(Object data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (isNull(data))
                return "NULL";
            return (String) mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Mapping error , message : " + e.getMessage());
        }
    }

    public static String getClientIp(HttpServletRequest request) {
        if (request != null) {
            String remoteAddr = request.getHeader("X-Forwarded-For");
            if (remoteAddr == null)
                remoteAddr = request.getRemoteAddr();
            return remoteAddr;
        } else {
            return null;
        }
    }

    public static String getRequestPath(HttpServletRequest httpServletRequest) {
        if (httpServletRequest != null) {
            String requrstUri = httpServletRequest.getRequestURI();
            String requestPath = requrstUri.substring(httpServletRequest.getContextPath().length());
            return requestPath;
        } else {
            return null;
        }

    }

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            if (requestAttributes instanceof ServletRequestAttributes) {
                return ((ServletRequestAttributes) requestAttributes).getRequest();
            }
        }
        return null;
    }

    private static Map<String, Object> keyVal(List<Object> objs) {

        Map<String, Object> map = new LinkedHashMap<>();

        for (int i = 0; i < objs.size(); i += 2) {
            map.put((String) objs.get(i), objs.get(i + 1));
        }

        return map;

    }


}
