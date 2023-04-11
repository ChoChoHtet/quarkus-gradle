package com.example.cdi;

import com.example.custom.Quote;
import com.example.custom.SpainLocale;
import com.example.model.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;
import javax.ws.rs.Produces;
import java.util.Locale;

/**
 * Creating Factories
 * Named Qualifier
 */
@ApplicationScoped
public class LocaleProducer {
    @Produces
    public Locale getDefaultLocale(){
        return Locale.getDefault();
    }

    @Produces
    @Named("en_US")
    public Locale getEnUSLocale(){
        return Locale.US;
    }

    @Produces
    @Named("th_TH")
    public Locale getEsESLocale(){
        return new Locale("th","TH");
    }

    @Produces
    @SpainLocale
    public Locale getSpainLocale(){
        return new Locale("es","ES");
    }

    @Produces
    @Quote
    Message getQuote(InjectionPoint msg){
        Quote quote = msg.getAnnotated().getAnnotation(Quote.class);
        return new Message(quote.msg(),quote.source(),quote.date());
    }

}
