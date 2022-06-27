package cbr.suz.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Vladislav Domaniewski
 *
 *      Здесь описывается тег <РТ_Организация> и его поля.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization {
    @XmlElement(name = "КодЗаказчика")
    private String codeOrder;


    @XmlElement(name = "ИНН")
    private String inn;

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "codeOrder='" + codeOrder + '\'' +
                '}';
    }

    public String getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }
}
