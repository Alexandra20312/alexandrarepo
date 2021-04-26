package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import dominio.Archivo;
import dominio.Usb;


public class UsbTest {


    private Usb usb = new Usb();
    
    private Archivo archivo1 = new Archivo();
    
    private Archivo archivo2 = new Archivo();
    
    @Before
    /* Este metodo se ejecuta antes de cada uno de los metodos anotados como @Test */
    public void setUp(){


            archivo1.setNombre( "archivo1.txt" );
            archivo1.setTamanio( 1000 );
            usb.copiar( archivo1 );


            archivo2.setNombre( "archivo2.odt" );
            archivo2.setTamanio( 2000 );
            usb.copiar( archivo2 );    
    }
    
    @Test
    public void testUsbTieneTxt() {
            Assert.assertTrue( usb.tieneTxt() );
    }


    @Test
    public void testUsbTieneJpg() {
            Assert.assertFalse( usb.tieneJpg() );
    }
    
    @Test
    public void testEspacioOcupadoCorrecto(){
            Assert.assertEquals( 3000, usb.espacioOcupado() );
    }
    
    @Test
    public void testArchivo1MayorQueArchivo2(){
            Assert.assertTrue( archivo1.tamanio() < archivo2.tamanio() );
    }
}