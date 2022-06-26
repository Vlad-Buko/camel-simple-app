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
    
![IMAGE 2022-06-26 23:21:56](https://user-images.githubusercontent.com/72036166/175832460-429fcdab-ee55-43a6-bb39-e71840dc7a83.jpg)
    
    2. Перед запуском в приложении, указать путь к папке, в которую будем 
добавлять файлы XML. 

![IMAGE 2022-06-26 23:23:29](https://user-images.githubusercontent.com/72036166/175832507-61d8fd5f-ab75-4459-80b0-e7cc4617312e.jpg)

    3. 

