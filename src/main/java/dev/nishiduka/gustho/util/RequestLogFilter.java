package dev.nishiduka.gustho.util;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Component
public class RequestLogFilter implements Filter {
	private final DateUtil dateUtil;
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long duration = System.currentTimeMillis() - startTime;
        

        log.info(
        		String.format(
        				"%s duration %s", 
        				dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()),
        				duration
    				)
        		);
    }
}
