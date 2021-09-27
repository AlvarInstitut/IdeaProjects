
package exemple_JAXB;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the exemple_JAXB package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: exemple_JAXB
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Oferta }
     * 
     */
    public Oferta createOferta() {
        return new Oferta();
    }

    /**
     * Create an instance of {@link Oferta.Vehiculo }
     * 
     */
    public Oferta.Vehiculo createOfertaVehiculo() {
        return new Oferta.Vehiculo();
    }

    /**
     * Create an instance of {@link Oferta.Vehiculo.Modelo }
     * 
     */
    public Oferta.Vehiculo.Modelo createOfertaVehiculoModelo() {
        return new Oferta.Vehiculo.Modelo();
    }

    /**
     * Create an instance of {@link Oferta.Vehiculo.Motor }
     * 
     */
    public Oferta.Vehiculo.Motor createOfertaVehiculoMotor() {
        return new Oferta.Vehiculo.Motor();
    }

    /**
     * Create an instance of {@link Oferta.Vehiculo.Extra }
     * 
     */
    public Oferta.Vehiculo.Extra createOfertaVehiculoExtra() {
        return new Oferta.Vehiculo.Extra();
    }

}
