# Message router from XML to JSON

    This application can accept as input a certain file with an XML extension,
this file is on our computer. Next, we write down the required the values that
we want to write, but already in a file with the JSON extension, which we pass
it to Apache ActiveMQ.


# Роутер сообщений из формата XML в формат JSON
    
    Это приложение может принимать на вход определённый файл с расширением XML,
этот файлик находится на нашем компьютере. Далее мы прописываем нужные нам 
значения, которые хотим записать, но уже в файлик с расширением JSON, который 
передаём в Apache ActiveMQ.


## Введение

    Для того, что бы наше приложение смогло передавать сообщение в очередь, 
делаем следующее:
    1. На компьютере должен быть установлен Apache ActiveMQ Artemis, 
    Вызываем командой:  activemq start
    
![IMAGE 2022-06-26 23:27:51](https://user-images.githubusercontent.com/72036166/175832705-3104525c-8948-4668-b330-4acef5844285.jpg)
    
    2. Перед запуском в приложении, указать путь к папке, в которую будем 
добавлять файлы XML. 

![IMAGE 2022-06-26 23:29:05](https://user-images.githubusercontent.com/72036166/175832692-421fa992-6884-4fb2-b50b-97578485ed6d.jpg)


    3. 

