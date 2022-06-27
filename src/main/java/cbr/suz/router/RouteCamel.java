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
 *
 *      Это можно сказать ключевой класс для передачи сообщений в очередь. Здесь
 * как и во многих стандартных приложениях работающих с Apache Camel, мы наследумся
 * от класса RouteBuilder, и реализуем метод configure().
 *
 *      В этом классе, мы создаём обьект JAXB, далее обьект JAXBContext,
 * который дальше сетаем в xmlDataFormat, другими словами создаём контекст JAXB.
 *
 *      В библиотеку сериализации Java - обьектов, добавляем наш класс, модельку
 * описывающий нашу конфигурацию XML. А позже, мы указываем путь к файлу, в данном
 * примере, я не стал указывать далеко файл, а расположил его прямо в директории
 * с проектом.
 *
 *      Далее мы читаем с xmlDataFormat, и можем изменить значения с входящего XML
 * файла. И после того, как программа прошла, мы добавляем в очередь, и отправляем
 * в очередь ActiveMQ, с названием DestinationQueue.
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
