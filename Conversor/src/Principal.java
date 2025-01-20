import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        int opcionUsuario = 0;
        Consulta consulta = new Consulta();
        ArrayList<Cambiador> listaDeConversiones = new ArrayList<>();
        System.out.println("**********************************************************************************\n");
        System.out.println("*** Bienvenid@ al conversor de moneda ***\n");
        while (opcionUsuario != 3) {
            Menu menu = new Menu();
            menu.mostrarMenuPrincipal();
            opcionUsuario = menu.leerOpcionPrincipal();

            switch (opcionUsuario) {
                case 1:
                    menu.mostrarMenuMonedas("inicial");
                    String monedaBase = menu.leerOpcionMoneda();
                    menu.mostrarMenuMonedas("final");
                    String monedaFinal = menu.leerOpcionMoneda();
                    Double cantidadCambiar = menu.leerCantidadACambiar();
                    Cambiar cambiar = consulta.buscaMoneda(monedaBase);
                    Double tasaDeConversion = cambiar.getConversionRate(monedaFinal.toUpperCase());
                    Double cantidadObtenida = menu.cantidadObtenida(monedaBase, cantidadCambiar, tasaDeConversion, monedaFinal);
                    Cambiador nuevaConversion = new Cambiador(monedaBase, monedaFinal, cantidadCambiar, cantidadObtenida);
                    listaDeConversiones.add(nuevaConversion);
                    break;
                case 2:
                    menu.imprimirConversiones(listaDeConversiones);
                    break;
                case 3:
                    System.out.println("Gracias por utilizar el conversor de moneda");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }

        }
    }
}
