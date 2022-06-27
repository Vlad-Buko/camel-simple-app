package cbr.suz.models;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.sun.xml.txw2.annotation.XmlValue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by Vladislav Domaniewski
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement(name = "СтраховойНомерПФР")
    private String insuranceNumber;

    @XmlElement(name = "Наименование")
    private String namePerson;

    @XmlElement(name = "РТ_Организация")
    private List<Organization> organizationList;

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "insuranceNumber='" + insuranceNumber + '\'' +
                '}';
    }
}
