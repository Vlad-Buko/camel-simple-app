package cbr.suz.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by Vladislav Domaniewski
 *
 *      В этом же классе, описываем тег <ФизическоеЛицо> а именно его поля.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlElement(name = "СтраховойНомерПФР")
    private String insuranceNumber;

    @XmlElement(name = "Наименование")
    private String namePerson;

    @XmlElement(name = "РТ_Организация")
    private List<Organization> organizationList;

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "insuranceNumber='" + insuranceNumber + '\'' +
                '}';
    }
}
