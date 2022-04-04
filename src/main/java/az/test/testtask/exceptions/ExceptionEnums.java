package az.test.testtask.exceptions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public enum ExceptionEnums {


    INTERNAL_EXCEPTION(1, "Internal error", "Daxili səhv", "Внутренняя ошибка"),
    DATA_DUPLICATING(2, "Duplicated data cannot be inserted", "Dublikat məlumat daxil edilə bilməz", "Повторяющиеся данные не могут быть вставлены"),
    INVALID_REQUEST_DATA(3, "Request data is not valid", "Sorğu məlumatları etibarlı deyil", "Данные запроса недействительны"),
    DATA_NOT_FOUND(4, "Data was not found", "Məlumat tapılmadı", "Данные не найдены"),
    USER_NOT_FOUND(5, "User was not found", "İstifadəçi tapılmadı", "Пользователь не найден"),
    ;

    private final Integer statusCode;
    private final String msg;
    private final String msgAz;
    private final String msgRu;


    ExceptionEnums(Integer statusCode, String msg, String msgAz, String msgRu) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.msgAz = msgAz;
        this.msgRu = msgRu;
    }

    public String getMsg() {
        return msg;
    }

    public String getMsgAz() {
        return msgAz;
    }

    public String getMsgRu() {
        return msgRu;
    }

    public static Map<Integer, ExceptionEnums> getIntegerKeysMap() {
        return INTEGER_KEYS_MAP;
    }

    public static Map<String, ExceptionEnums> getStringKeysMap() {
        return STRING_KEYS_MAP;
    }

    private static final Map<Integer, ExceptionEnums> INTEGER_KEYS_MAP =
            new ConcurrentHashMap<>();

    private static final Map<String, ExceptionEnums> STRING_KEYS_MAP =
            new ConcurrentHashMap<>();

    static {
        for (ExceptionEnums type : ExceptionEnums.values()) {
            INTEGER_KEYS_MAP.put(type.statusCode, type);
        }
        for (ExceptionEnums type : ExceptionEnums.values()) {
            STRING_KEYS_MAP.put(type.msg, type);
        }

    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public static ExceptionEnums getEnum(Integer value) {
        if (value == null)
            return null;
        return INTEGER_KEYS_MAP.get(value);
    }

    public static ExceptionEnums getEnum(String value) {
        if (value == null)
            return null;
        return STRING_KEYS_MAP.get(value);
    }

    public static MyRuntimeException getException(ExceptionEnums exceptionEnums) {
        return new MyRuntimeException(exceptionEnums.getStatusCode(), exceptionEnums.getMsg(), exceptionEnums.getMsgAz(), exceptionEnums.getMsgRu());
    }

    public static MyRuntimeException getException(ExceptionEnums exceptionEnums, String errMsg) {
        return new MyRuntimeException(exceptionEnums.getStatusCode(), errMsg, errMsg, errMsg);
    }

    @Override
    public String toString() {
        return "ExceptionEnums{" +
                "statusCode=" + statusCode +
                ", msg='" + msg + '\'' +
                ", msgAz='" + msgAz + '\'' +
                ", msgRu='" + msgRu + '\'' +
                '}';
    }
}
