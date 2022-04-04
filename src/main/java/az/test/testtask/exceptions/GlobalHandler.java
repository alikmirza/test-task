package az.test.testtask.exceptions;

import az.test.testtask.dto.ErrorInfo;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static az.test.testtask.exceptions.ExceptionEnums.INTERNAL_EXCEPTION;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo MethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException exception) {

        String url = request.getRequestURL().toString();
        String message = exception.getMessage();

        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        String messages = allErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(" , "));


        return ErrorInfo.builder()
                .url(url)
                .message(messages)
                .messageAz(messages)
                .messageRu(messages)
                .time(new Date())
                .errorCode(400)
                .description(message)
                .build();
    }

    @ExceptionHandler(MyRuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo MyRuntimeException(HttpServletRequest request, MyRuntimeException exception) {

        String url = request.getRequestURL().toString();

        return ErrorInfo.builder()
                .url(url)
                .message(exception.getMessage())
                .messageAz(exception.getMessageAz())
                .messageRu(exception.getMessageRu())
                .time(new Date())
                .errorCode(exception.getStatus())
                .description(exception.getMessage())
                .build();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo exception(HttpServletRequest request, Exception exception) {

        String url = request.getRequestURL().toString();
        String message = exception.getMessage();

        return ErrorInfo.builder()
                .url(url)
                .message(message)
                .messageAz(INTERNAL_EXCEPTION.getMsgAz())
                .messageRu(INTERNAL_EXCEPTION.getMsgRu())
                .time(new Date())
                .errorCode(INTERNAL_EXCEPTION.getStatusCode())
                .description(INTERNAL_EXCEPTION.getMsg())
                .build();
    }

}