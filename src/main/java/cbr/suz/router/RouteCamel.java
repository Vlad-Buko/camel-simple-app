package cbr.suz.router;

import cbr.suz.settingValues.MyProcessor;
import cbr.suz.models.FileUntilSendQueyed;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import javax.xml.bind.JAXBContext;

/**
 * Created by Vladislav Domaniewski
 * <p>
 * Here created router for transfer
 */

public class RouteCamel extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // XML data Format
        JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
        JAXBContext context = JAXBContext.newInstance(FileUntilSendQueyed.class);
        xmlDataFormat.setContext(context);

        // JSON data Format
        JacksonDataFormat jsonDataFormat = new JacksonDataFormat(FileUntilSendQueyed.class);
        from("file:src/main/inputFolder").doTry().unmarshal(xmlDataFormat)
                .log("fdff")
                .process(new MyProcessor()).marshal(jsonDataFormat)
                .log("dsd")
                .to("jms:DesinationQueue").doCatch(Exception.class)
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                        System.out.println(cause);
                    }
                });
    }
}
