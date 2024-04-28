/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase DesencriptadorPorFuerzaBruta - Desencripta por fuerza bruta comparando palabras contenida en cada resultado hasta
 encontrar coincidencias.
 Autor - Mario García. mariogarcia1040@gmail.com
 27-Abril-2024
*/
public class DesencriptadorPorFuerzaBruta {
    EncriptadorDesencriptador desencriptador = new EncriptadorDesencriptador();

    void desencriptadoPorFuerzaBruta(String cadenaEncriptada, int numeroDeIntentos) {
        String resultado;
        for (int i = 1; i < numeroDeIntentos + 1; i++) {
            System.out.println("Intento #" + i);
            resultado = desencriptador.procesarCadena(cadenaEncriptada, -i); // El valor es negativo para desencriptar
            if (buscarPalabrasComunes(resultado)) {
                System.out.println(resultado);
                break;
            }
            System.out.println("No se encontraron coincidencias");
        }
    }

    // Buscamos las palabras más comunes en el idioma español
    boolean buscarPalabrasComunes(String cadenaProcesada) {
        // Lista de palabras comunes en el español
        String listaDePalabras = "ante bajo con contra de desde hacia hasta para por según segun sin sobre tras " +
                "humanidad humano persona gente hombre mujer bebé niño niña adolescente adulto anciano don doña señor " +
                "señora caballero dama individuo cuerpo pierna pie talón espinilla rodilla muslo cabeza cara boca labio " +
                "diente ojo nariz barba bigote cabello oreja cerebro estómago brazo codo hombro uña mano muñeca palma " +
                "dedo trasero abdomen hígado músculo cuello corazón mente alma espíritu pecho cintura cadera espalda " +
                "sangre carne piel hueso resfriado gripe diarrea salud enfermedad familia amigo amiga conocido conocida" +
                "colega pareja esposo esposa matrimonio amor padre madre hermano hermana hijo hija abuelo abuela bisabuelo" +
                "bisabuela nieto nieta bisnieto bisnieta primo prima tío tía sobrino sobrina criatura especie ser vida" +
                "nacimiento reproducción muerte naturaleza campo bosque selva jungla desierto costa playa río laguna " +
                "lago mar océano cerro monte montaña luz energía animal perro gato vaca cerdo caballo yegua oveja mono" +
                "ratón rata tigre conejo dragón ciervo rana león jirafa elefante pájaro gallina gorrión cuervo águila" +
                "halcón pez camarón langosta sardina atún calamar pulpo insecto bicho mariposa polilla saltamontes araña" +
                "mosca mosquito cucaracha caracol babosa lombriz marisco molusco lagarto serpiente cocodrilo alimento " +
                "comida bebida vegetal planta pasto césped flor fruta semilla árbol hoja raíz tallo hongo ciruela pino " +
                "bambú nuez almendra castaña arroz avena cebada trigo verdura patatas papas judías guisantes porotos " +
                "rábano zanahoria manzana naranja plátano pera castaño durazno tomate sandía carne gaseosa tiempo " +
                "calendario edad época era fecha instante momento segundo minuto hora día semana entre semana fin semana" +
                "mes año década siglo milenio ayer hoy mañana amanecer mediodía tarde anochecer noche lunes martes " +
                "miércoles jueves viernes sábado domingo ambiente espacio entorno área superficie volumen región zona " +
                "lado mundo planeta sol luna estrella galaxia universo clima despejado nublado lluvia nieve viento " +
                "trueno rayo tormenta cielo este oeste sur norte derecha izquierda diagonal exterior interior";

        String[] palabras = listaDePalabras.split("\\s+"); // Manejamos el espacio en blanco de las palabras
        int palabrasEncontradas = 0;
        for (String palabra : palabras) {
            if (cadenaProcesada.toLowerCase().contains(palabra)) {
                palabrasEncontradas++;
            }
            if (palabrasEncontradas > 5) {
                System.out.println("Se encontraron coincidencias, posible texto desencriptado\n");
                return true;
            }
        }
        return false;
    }
}