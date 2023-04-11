package com.example.cdi;

import com.example.custom.LogEvent;
import com.example.model.Event;
import org.jboss.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@LogEvent
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LogEventInterceptor {
    @AroundInvoke
    public Object logEvent(InvocationContext ctx) throws Exception {

        Logger logger = Logger.getLogger(ctx.getTarget().getClass().getName());
        // Get the log message
        String message = Arrays.deepToString(ctx.getParameters());
        // Modify the log message
        String modifiedMessage = "Cho Interceptor: " + message;
        // Log the modified message
        logger.log(Logger.Level.INFO, modifiedMessage);

        //System.out.println("Custom --->> Before method invocation: "+ Arrays.deepToString(ctx.getParameters()));
        // Proceed with the original method invocation
        return ctx.proceed();
    }
}
