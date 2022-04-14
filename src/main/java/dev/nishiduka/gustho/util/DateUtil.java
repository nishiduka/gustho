package dev.nishiduka.gustho.util;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
@Component
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
    
    public void logTimestamp(String route) {
        log.info(
        		String.format(
        				"%s at %s", 
        				route, 
        				this.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now())
    				)
        		);
    }
}
