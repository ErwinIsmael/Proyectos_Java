public class C1 {
    public static void main(String[] args) {

        Postulantes p1 = new Postulantes();
        Postulantes p2 = new Postulantes();


        p1.nombre = "Erwin";
        p1.edad = 23;
        p1.genero = "M";
        p1.folio = "E1-2024";

        p2.nombre = "Lizbeth";
        p2.edad = 25;
        p2.genero = "F";
        p2.folio = "L1-2024";

        Administrativos a1 = new Administrativos();
        Administrativos a2 = new Administrativos();

        Portero portero1 = new Portero();

        a1.nombre = "Luis";
        a1.puesto = "Evaluador";
        a1.edad = 33;
        a1.numeroTrabajador = "L321";

        a2.nombre = "Sandra";
        a2.edad = 30;
        a2.puesto = "Recursos humanos";
        a2.numeroTrabajador = "S1234";

        portero1.nombre = "Marco";
        portero1.edad = 35;
        portero1.genero = "M";
        portero1.numeroTrabajador = "M321";
        portero1.sueldo = 0F;
        portero1.proteccion = true;

        Edificios e1 = new Edificios();

        e1.ubicacion = "Puebla";
        e1.metros = 50.20;
        e1.altura = 15.10;
        e1.nombre = "TR NETWORK";
        e1.numeroPisos = 3;

        Examen exm1 = new Examen();

        exm1.area = "postulacion de trabajo";
        exm1.numeroPreguntas = 50;
        exm1.tipo = "escrito";

        Lapicero l1 = new Lapicero();
        l1.marca = "BIC";
        l1.color = "Azul";
        l1.tamaño = 10.1;
        l1.peso = 1.0;

        p1.LlegarALugar(p1.nombre);
        p1.tocarPuerta();
        portero1.saludar("Bune dia, en que le puedo ayudar:  ");
        p1.solicitarAcceso("Realizare un examen para postularme en un area de este lugar",p1.edad,p1.folio);
        portero1.abrirPuerta("Puede acceder");
        portero1.registrarAcceso("Registra tu entrada, usa este lapicero de color ",l1.color);
        portero1.revisar();
        p1.entrar();
        p1.subirEscaleras();
        p1.saludar("Buen dia, aqui es recursos humanos?");
        a2.saludar("Bienvenido adelante", a2.nombre, a2.puesto);
        a2.responder("si aqui es recursos humanos");
        a2.solicitarDocumentos("Podria proporcionarme su documentacion y su folio");
        p1.entregarDocumentacion("Si aqui esta mi documentacio y el numero de folio: ",p1.folio);
        a2.permitirAcceso("a la oficina del fondo para presentar su examen junto con otra postulante");
        p1.tocarPuerta();
        a1.saludar("Adelante",a1.nombre,a1.puesto);
        a1.permitirAcceso("lo estaba esperando,ya se encuentra en espera otra postulante");
        p1.entrar();
        a1.aplicarExamen(1, exm1.tipo);
        p1.sentar();
        p1.tomarobjeto(l1);
        p1.aplicarExamen(p1.nombre,exm1.numeroPreguntas);
        p2.aplicarExamen(p2.nombre,exm1.numeroPreguntas);


    }
}
