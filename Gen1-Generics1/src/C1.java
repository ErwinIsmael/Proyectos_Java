import com.jimenez.app.generics.cargadores.*;
import com.jimenez.app.generics.celulares.CelularApple;
import com.jimenez.app.generics.celulares.CelularSamsung;
import com.jimenez.app.generics.celulares.CelularXiaomi;
import com.jimenez.app.generics.enums.Color;

public class C1 {
    public static void main(String[] args) {

/*
        Color color = Color.NEGRO;
        Color color1 = Color.AZUL;
        Color color2 = Color.BLANCO;
        //Instanciamos la clase cargador
        CelularApple Apple1 = new CelularApple("14", "AP1234586TR576", 8.0F, 256.0F, true, 6000.0F,color);
        CelularSamsung Samsung1 = new CelularSamsung("GALAXY 20", "S89689768", 12.0F, 512.0F, 6000.0F, color1);
        IAppleCargador C1= new CargadorCompactoApple();
        ISamsungCargador C2 = new CargadorInduccionSamsung();
        CelularXiaomi Xiaomi1 = new CelularXiaomi("REDMI 12 PRO", "X8748753248", 12.0F, 256.0F, 6.000F, color2);
        IXiaomiCargador C3 =new CargadorSuperXiaomi();

        //Llamada de funciones
        C1.cargar(Apple1);
        C2.cargar(Samsung1);
        C3.cargar(Xiaomi1);

 */



        CelularApple i10 = new CelularApple();
        i10.setModelo("Iphon 10");
        i10.setMemoriaRam(4F);
        i10.setMemoriaRom(64F);
        i10.setImei("12838T374S");
        i10.setCapacidadBateria(12F);
        i10.setBotonSilencioEstado(true);
        i10.setColor(Color.NEGRO);

        CelularSamsung m1 = new CelularSamsung();
        m1.setModelo("S22");
        m1.setMemoriaRam(6F);
        m1.setMemoriaRom(128F);
        m1.setImei("5786586986986YF969");
        m1.setCapacidadBateria(19F);
        m1.setColor(Color.AZUL);

        CelularXiaomi poco = new CelularXiaomi();
        poco.setModelo("Xiaomi Poco X1");
        poco.setMemoriaRam(6F);
        poco.setMemoriaRom(128F);
        poco.setImei("7654736TYF87687GJH");
        poco.setCapacidadBateria(26F);
        poco.setColor(Color.BLANCO);

        IAppleCargador cargadorNormalApple = new CargadorNormalApple();
        IAppleCargador cargadorCompactoApple = new CargadorCompactoApple();

        ISamsungCargador cargadorSuperSamsung = new CargadorSuperSamsung();
        ISamsungCargador cargadorNormalSamsung = new CargadorNormalSamsung();
        ISamsungCargador cargadorInduccionSamsung = new CargadorInduccionSamsung();

        IXiaomiCargador cargadorNormalXiaomi = new CargadorNormalXiaomi();
        IXiaomiCargador cargadorSuperXiaomi = new CargadorSuperXiaomi();

        //hoy
        cargadorNormalApple.cargar(i10);
        cargadorInduccionSamsung.cargar(m1);
        cargadorSuperXiaomi.cargar(poco);

        //mañana
        cargadorCompactoApple.cargar(i10);
        cargadorSuperSamsung.cargar(m1);
        cargadorNormalXiaomi.cargar(poco);




    }
}
