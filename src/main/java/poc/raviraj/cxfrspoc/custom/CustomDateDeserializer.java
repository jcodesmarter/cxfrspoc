package poc.raviraj.cxfrspoc.custom;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


/**
 * Simple deserializer for handling {@link java.util.Date} values.
 * <p>
 * One way to customize Date formats accepted is to override method
 * {@link DeserializationContext#parseDate} that this basic deserializer calls.
 * 
 * @since 1.9 (moved from higher-level package)
 */
public class CustomDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public java.util.Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// get the value from the JSON
        long timeInMilliseconds = Long.parseLong(jp.getText());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMilliseconds);
        return calendar.getTime();
	}
}
