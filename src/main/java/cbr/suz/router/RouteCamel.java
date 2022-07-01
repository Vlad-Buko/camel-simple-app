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
 *
 *      This can be said to be the key class for passing messages to the queue. Here
 * as in many standard applications working with Apache Camel, we inherit
 * from the RouteBuilder class, and implement the configure() method.
 
 *      In this class, we create a JAXB object, then a JAXBContext object,
 * which we further set in xmlDataFormat, in other words, we create a JAXB context.
 
 *      In the Java serialization library - objects, add our class, model
 * describing our XML configuration. And later, we specify the path to the file, in this
 * example, I did not specify the file far, but placed it directly in the directory
 * with the project.
 *
 *      Next, we read from xmlDataFormat, and we can change the values ​​from the incoming XML
 * file. And after the program has passed, we add to the queue, and send
 * to an ActiveMQ queue named DestinationQueue.
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
                .process(new MyProcessor()).marshal(jsonDataFormat)
                .to("jms:DesinationQueue").doCatch(Exception.class)
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                        System.out.println(cause);
                    }
                });
    }
}
