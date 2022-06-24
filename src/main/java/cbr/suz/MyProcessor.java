package cbr.suz;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Vladislav Domaniewski
 */

public class MyProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        ReadyFileAfterQueued file = exchange.getIn().getBody(ReadyFileAfterQueued.class);
        file.setInsuranceNumberPFR(1);
        file.setName("Viktor");
        file.setOrganization("Amkodor");
    }
}
