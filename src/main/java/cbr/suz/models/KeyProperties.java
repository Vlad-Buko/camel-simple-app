package cbr.suz.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by Vladislav Domaniewski
 *
 *      В данном классе, мы продолжаем описывать XML.
 *      В данном классе, это тег <КлючевыеСвойства>
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class KeyProperties {

    @XmlElement(name = "ФизическоеЛицо")
    private List<Person> person;

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "KeyProperties{" +
                "name='" + person + '\'' +
                '}';
    }
}
