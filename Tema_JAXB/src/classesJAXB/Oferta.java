
package classesJAXB;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehiculo" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="modelo">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="motor">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="combustible" type="{}Combust" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="matricula" type="{}Matr"/>
 *                   &lt;element name="kilometros" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="precio_inicial" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="precio_oferta" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="extra" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="valor" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="foto" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vehiculo"
})
@XmlRootElement(name = "oferta")
public class Oferta {

    @XmlElement(required = true)
    protected List<Oferta.Vehiculo> vehiculo;

    /**
     * Gets the value of the vehiculo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehiculo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehiculo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Oferta.Vehiculo }
     * 
     * 
     */
    public List<Oferta.Vehiculo> getVehiculo() {
        if (vehiculo == null) {
            vehiculo = new ArrayList<Oferta.Vehiculo>();
        }
        return this.vehiculo;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="modelo">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="motor">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="combustible" type="{}Combust" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="matricula" type="{}Matr"/>
     *         &lt;element name="kilometros" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="precio_inicial" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="precio_oferta" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="extra" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="valor" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="foto" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "marca",
        "modelo",
        "motor",
        "matricula",
        "kilometros",
        "precioInicial",
        "precioOferta",
        "extra",
        "foto"
    })
    public static class Vehiculo {

        @XmlElement(required = true)
        protected String marca;
        @XmlElement(required = true)
        protected Oferta.Vehiculo.Modelo modelo;
        @XmlElement(required = true)
        protected Oferta.Vehiculo.Motor motor;
        @XmlElement(required = true)
        protected String matricula;
        @XmlElement(required = true)
        protected BigInteger kilometros;
        @XmlElement(name = "precio_inicial", required = true)
        protected BigInteger precioInicial;
        @XmlElement(name = "precio_oferta", required = true)
        protected BigInteger precioOferta;
        @XmlElement(required = true)
        protected List<Oferta.Vehiculo.Extra> extra;
        @XmlElement(required = true)
        protected List<String> foto;

        /**
         * Gets the value of the marca property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMarca() {
            return marca;
        }

        /**
         * Sets the value of the marca property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMarca(String value) {
            this.marca = value;
        }

        /**
         * Gets the value of the modelo property.
         * 
         * @return
         *     possible object is
         *     {@link Oferta.Vehiculo.Modelo }
         *     
         */
        public Oferta.Vehiculo.Modelo getModelo() {
            return modelo;
        }

        /**
         * Sets the value of the modelo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Oferta.Vehiculo.Modelo }
         *     
         */
        public void setModelo(Oferta.Vehiculo.Modelo value) {
            this.modelo = value;
        }

        /**
         * Gets the value of the motor property.
         * 
         * @return
         *     possible object is
         *     {@link Oferta.Vehiculo.Motor }
         *     
         */
        public Oferta.Vehiculo.Motor getMotor() {
            return motor;
        }

        /**
         * Sets the value of the motor property.
         * 
         * @param value
         *     allowed object is
         *     {@link Oferta.Vehiculo.Motor }
         *     
         */
        public void setMotor(Oferta.Vehiculo.Motor value) {
            this.motor = value;
        }

        /**
         * Gets the value of the matricula property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMatricula() {
            return matricula;
        }

        /**
         * Sets the value of the matricula property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMatricula(String value) {
            this.matricula = value;
        }

        /**
         * Gets the value of the kilometros property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getKilometros() {
            return kilometros;
        }

        /**
         * Sets the value of the kilometros property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setKilometros(BigInteger value) {
            this.kilometros = value;
        }

        /**
         * Gets the value of the precioInicial property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPrecioInicial() {
            return precioInicial;
        }

        /**
         * Sets the value of the precioInicial property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPrecioInicial(BigInteger value) {
            this.precioInicial = value;
        }

        /**
         * Gets the value of the precioOferta property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPrecioOferta() {
            return precioOferta;
        }

        /**
         * Sets the value of the precioOferta property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPrecioOferta(BigInteger value) {
            this.precioOferta = value;
        }

        /**
         * Gets the value of the extra property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the extra property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExtra().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Oferta.Vehiculo.Extra }
         * 
         * 
         */
        public List<Oferta.Vehiculo.Extra> getExtra() {
            if (extra == null) {
                extra = new ArrayList<Oferta.Vehiculo.Extra>();
            }
            return this.extra;
        }

        /**
         * Gets the value of the foto property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the foto property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFoto().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getFoto() {
            if (foto == null) {
                foto = new ArrayList<String>();
            }
            return this.foto;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="valor" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Extra {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "valor")
            protected BigInteger valor;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the valor property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getValor() {
                return valor;
            }

            /**
             * Sets the value of the valor property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setValor(BigInteger value) {
                this.valor = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Modelo {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "color")
            protected String color;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the color property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getColor() {
                return color;
            }

            /**
             * Sets the value of the color property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setColor(String value) {
                this.color = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="combustible" type="{}Combust" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Motor {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "combustible")
            protected Combust combustible;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the combustible property.
             * 
             * @return
             *     possible object is
             *     {@link Combust }
             *     
             */
            public Combust getCombustible() {
                return combustible;
            }

            /**
             * Sets the value of the combustible property.
             * 
             * @param value
             *     allowed object is
             *     {@link Combust }
             *     
             */
            public void setCombustible(Combust value) {
                this.combustible = value;
            }

        }

    }

}
