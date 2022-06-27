package cbr.suz.settingValues;

import cbr.suz.models.FileUntilSendQueyed;
import cbr.suz.models.Person;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Vladislav Domaniewski
 *
 *      Данный класс отвечает за устанавливаемые, изменяемые значения
 * в нашем уже новом файле JSON.
 */

public class MyProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        FileUntilSendQueyed file = exchange.getIn().getBody(FileUntilSendQueyed.class);
        System.out.println(exchange.getIn().getBody());
        file.setKeyProperties(file.getKeyProperties());
    }
}
