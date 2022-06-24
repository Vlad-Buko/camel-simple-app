package cbr.suz;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import javax.xml.bind.JAXBContext;

/**
 * Created by Vladislav Domaniewski
 */

public class RouteCamel extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // XML data Format
        JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
        JAXBContext context = JAXBContext.newInstance(ReadyFileAfterQueued.class);
        xmlDataFormat.setContext(context);

        // JSON data Format
        JacksonDataFormat jsonDataFormat = new JacksonDataFormat(ReadyFileAfterQueued.class);

        from("file:/Users/vladislav_domaniewski/Documents/inputFolder").doTry().unmarshal(xmlDataFormat)
                .process(new MyProcessor()).marshal(jsonDataFormat)
                .to("jms:queue:DesinationQueue").doCatch(Exception.class)
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                        System.out.println(cause);
                    }
                });
    }
}
