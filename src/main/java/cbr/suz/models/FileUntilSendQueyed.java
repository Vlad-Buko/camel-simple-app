package cbr.suz.models;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Vladislav Domaniewski
 *
 *      В этом классе будет расписан xml файл который мы отправляем в очередь,
 * аннотация @XmlRootElement указывает на элемент XML, в котором содержится
 * другие аттрибуты, но так же может быть и один аттрибут.
 *
 *      Аннотация @XmlAccessorType указывает, что чтение будет производится
 * по полям XML документа, и конечно же @XmlElement указывает на один элемент,
 * в котором находится значение.
 */

@XmlRootElement(name = "Справочник.Сотрудники")
@XmlAccessorType(XmlAccessType.FIELD)
public class FileUntilSendQueyed {

    @XmlElement(name = "КлючевыеСвойства")
    private List<KeyProperties> keyProperties;

    public List<KeyProperties> getKeyProperties() {
        return keyProperties;
    }

    public void setKeyProperties() {
        this.keyProperties = keyProperties;
    }

    @Override
    public String toString() {
        return "ReadyFileAfterQueued{" +
                "keyProp=" + keyProperties +
                '}';
    }
}
