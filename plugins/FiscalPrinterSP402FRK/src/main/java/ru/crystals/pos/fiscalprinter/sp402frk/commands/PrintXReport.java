package ru.crystals.pos.fiscalprinter.sp402frk.commands;

import ru.crystals.pos.fiscalprinter.sp402frk.support.KKTDataType;
import ru.crystals.pos.fiscalprinter.sp402frk.transport.RequestElement;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Данные команды печати X отчёта
 */
@XmlRootElement(name = "pa")
@XmlAccessorType(XmlAccessType.NONE)
public class PrintXReport {
    @XmlAttribute(name = "n")
    private String name = "200001";
    @XmlAttribute(name = "t")
    private String type = "7";

    @XmlElement(name = "pa")
    private RequestElement userLoginName = new RequestElement("1021", KKTDataType.STRING, "");
    @XmlElement(name = "pa")
    private RequestElement footer = new RequestElement("Footer", KKTDataType.STRING, "");
    @XmlElement(name = "pa")
    private RequestElement headerText = new RequestElement("HeaderText", KKTDataType.STRING, "");


    public String getUserLoginName() {
        return userLoginName.getValue();
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName.setValue(userLoginName);
    }

    public String getHeaderText() {
        return headerText.getValue();
    }

    public void setHeaderText(String headerText) {
        this.headerText.setValue(headerText);
    }

    public String getFooter() {
        return footer.getValue();
    }

    public void setFooter(String footer) {
        this.footer.setValue(footer);
    }
}
