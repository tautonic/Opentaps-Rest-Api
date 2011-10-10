//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.10.08 at 07:34:15 PM CEST 
//


package org.opentaps.module.ws.rest.domain.billing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentApplication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paymentApplication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paymentApplicationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.opentaps.org/module/ws/rest/domain/billing}payment"/>
 *         &lt;element ref="{http://www.opentaps.org/module/ws/rest/domain/billing}invoice"/>
 *         &lt;element name="amountApplied" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentApplication", propOrder = {
    "paymentApplicationId",
    "payment",
    "invoice",
    "amountApplied"
})
public class PaymentApplicationBean {

    @XmlElement(required = true)
    protected String paymentApplicationId;
    @XmlElement(required = true, nillable = true)
    protected PaymentBean payment;
    @XmlElement(required = true)
    protected InvoiceBean invoice;
    protected float amountApplied;

    /**
     * Gets the value of the paymentApplicationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentApplicationId() {
        return paymentApplicationId;
    }

    /**
     * Sets the value of the paymentApplicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentApplicationId(String value) {
        this.paymentApplicationId = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentBean }
     *     
     */
    public PaymentBean getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentBean }
     *     
     */
    public void setPayment(PaymentBean value) {
        this.payment = value;
    }

    /**
     * Gets the value of the invoice property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceBean }
     *     
     */
    public InvoiceBean getInvoice() {
        return invoice;
    }

    /**
     * Sets the value of the invoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceBean }
     *     
     */
    public void setInvoice(InvoiceBean value) {
        this.invoice = value;
    }

    /**
     * Gets the value of the amountApplied property.
     * 
     */
    public float getAmountApplied() {
        return amountApplied;
    }

    /**
     * Sets the value of the amountApplied property.
     * 
     */
    public void setAmountApplied(float value) {
        this.amountApplied = value;
    }

}