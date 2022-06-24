package cbr.suz;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Vladislav Domaniewski
 */

@XmlRootElement(name = "Справочник.Сотрудники", namespace = "https://www.rostec.ru/CDM/1.3.3")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReadyFileAfterQueued {
    @XmlElement(name = "КодЗаказчика")
    private int insuranceNumberPFR;
    @XmlElement(name = "Наименование")
    private String name;
    @XmlElement(name = "Cсылка")
    private String organization;

    public int getInsuranceNumberPFR() {
        return insuranceNumberPFR;
    }

    public void setInsuranceNumberPFR(int insuranceNumberPFR) {
        this.insuranceNumberPFR = insuranceNumberPFR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
