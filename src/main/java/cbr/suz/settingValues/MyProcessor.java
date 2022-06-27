package cbr.suz.settingValues;

import cbr.suz.models.FileUntilSendQueyed;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Vladislav Domaniewski
 *
 *
 */

public class MyProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        FileUntilSendQueyed file = exchange.getIn().getBody(FileUntilSendQueyed.class);
        System.out.println(exchange.getIn().getBody());
        file.setKeyProperties(file.getKeyProperties());
    }
}
