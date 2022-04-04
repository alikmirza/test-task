package az.test.testtask.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class JsonDateSerializer extends JsonSerializer<Date> {

    public static final SimpleDateFormat DATE = new SimpleDateFormat("dd.MM.yyyy");
    public static final SimpleDateFormat DATE_TIME = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {


        if (value == null) {
            gen.writeNull();
        } else {
            String dateStr = DATE_TIME.format(value);
            String subStr = dateStr.substring(11, 19);
            if (subStr.equals("00:00:00")) {
                gen.writeString(DATE.format(value));
            } else {
                gen.writeString(dateStr);
            }
        }


    }

}