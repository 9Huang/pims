package com.huang.pims.jackson.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class DateJacksonJsonDeserializer extends JsonDeserializer<Date> {

    private static String[] patterns = new String[]{
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.S",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm:ss.S",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.S"};


    private static final String PATTERNS = StringUtils.join(patterns, ",");

    private static final String PARSE_EXCEPTION_MESSAGE =
            "'%s' can not convert to type 'java.util.Date',just support timestamp(type of long) and following date format(%s)";


    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        Date targetDate = null;
        String originDate = StringUtils.trimToEmpty(jsonParser.getText());
        if (StringUtils.isNotBlank(originDate)) {
            boolean isNotLong = false;
            try {
                targetDate = new Date(Long.valueOf(originDate));
            } catch (NumberFormatException e) {
                isNotLong = Boolean.TRUE;
                e.printStackTrace();
            } finally {
                if (isNotLong) {
                    try {
                        targetDate = DateUtils.parseDate(originDate, patterns);
                    } catch (ParseException e) {
                        throw new IOException(String.format(PARSE_EXCEPTION_MESSAGE, originDate, PATTERNS));
                    }
                }
            }
        }
        return targetDate;
    }
}
