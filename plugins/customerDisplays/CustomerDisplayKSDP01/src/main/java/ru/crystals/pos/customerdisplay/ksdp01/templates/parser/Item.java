//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2011.10.27 at 04:49:23 PM MSD
//


package ru.crystals.pos.customerdisplay.ksdp01.templates.parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="type" type="{http://crystals.ru/pos/customerdisplay/ksdp01/templates/parser}contentType" />
 *       &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="zOrder" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="backgroundcolor" type="{http://crystals.ru/pos/customerdisplay/ksdp01/templates/parser}color" />
 *       &lt;attribute name="textcolor" type="{http://crystals.ru/pos/customerdisplay/ksdp01/templates/parser}color" />
 *       &lt;attribute name="font" type="{http://crystals.ru/pos/customerdisplay/ksdp01/templates/parser}font" />
 *       &lt;attribute name="fontsize" type="{http://crystals.ru/pos/customerdisplay/ksdp01/templates/parser}fontSize" />
 *       &lt;attribute name="align" type="{http://crystals.ru/pos/customerdisplay/ksdp01/templates/parser}align" />
 *       &lt;attribute name="element" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "item")
public class Item {

    @XmlAttribute
    protected ContentType type;
    @XmlAttribute
    protected BigInteger x;
    @XmlAttribute
    protected BigInteger y;
    @XmlAttribute
    protected BigInteger zOrder;
    @XmlAttribute
    protected BigInteger width;
    @XmlAttribute
    protected BigInteger height;
    @XmlAttribute
    protected Integer backgroundcolor;
    @XmlAttribute
    protected Integer textcolor;
    @XmlAttribute
    protected Font font;
    @XmlAttribute
    protected FontSize fontsize;
    @XmlAttribute
    protected Align align;
    @XmlAttribute
    protected String element;

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link ContentType }
     */
    public ContentType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link ContentType }
     */
    public void setType(ContentType value) {
        this.type = value;
    }

    /**
     * Gets the value of the x property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setX(BigInteger value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setY(BigInteger value) {
        this.y = value;
    }

    /**
     * Gets the value of the zOrder property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getZOrder() {
        return zOrder;
    }

    /**
     * Sets the value of the zOrder property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setZOrder(BigInteger value) {
        this.zOrder = value;
    }

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setWidth(BigInteger value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setHeight(BigInteger value) {
        this.height = value;
    }

    /**
     * Gets the value of the backgroundcolor property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getBackgroundcolor() {
        return backgroundcolor;
    }

    /**
     * Sets the value of the backgroundcolor property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setBackgroundcolor(Integer value) {
        this.backgroundcolor = value;
    }

    /**
     * Gets the value of the textcolor property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getTextcolor() {
        return textcolor;
    }

    /**
     * Sets the value of the textcolor property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setTextcolor(Integer value) {
        this.textcolor = value;
    }

    /**
     * Gets the value of the font property.
     *
     * @return possible object is
     * {@link Font }
     */
    public Font getFont() {
        return font;
    }

    /**
     * Sets the value of the font property.
     *
     * @param value allowed object is
     *              {@link Font }
     */
    public void setFont(Font value) {
        this.font = value;
    }

    /**
     * Gets the value of the fontsize property.
     *
     * @return possible object is
     * {@link FontSize }
     */
    public FontSize getFontsize() {
        return fontsize;
    }

    /**
     * Sets the value of the fontsize property.
     *
     * @param value allowed object is
     *              {@link FontSize }
     */
    public void setFontsize(FontSize value) {
        this.fontsize = value;
    }

    /**
     * Gets the value of the align property.
     *
     * @return possible object is
     * {@link Align }
     */
    public Align getAlign() {
        return align;
    }

    /**
     * Sets the value of the align property.
     *
     * @param value allowed object is
     *              {@link Align }
     */
    public void setAlign(Align value) {
        this.align = value;
    }

    /**
     * Gets the value of the element property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getElement() {
        return element;
    }

    /**
     * Sets the value of the element property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setElement(String value) {
        this.element = value;
    }

}
