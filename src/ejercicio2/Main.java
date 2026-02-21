package ejercicio2;

import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("------Ingrese la opcion------");
        System.out.println("1. Registrar turno");
        System.out.println("2. Atender turno");
        System.out.println("3. Eliminar turno");
        System.out.println("4. Turno urgente");
        System.out.println("5. Estadísticas");
        System.out.println("6. Mostrar turnos");
        System.out.println("7. Salir");
    }

    public static void main(String[] args) {
        int[] ids = new int[50];
        char[] tipos = new char[50];
        int[] tiempos = new int[50];
        int n = 0;

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {

            menu();
            int opc = Integer.parseInt(sc.nextLine());

            switch (opc) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    System.out.print("Tipo (P/G): ");
                    char tipo = sc.next().toUpperCase().charAt(0);

                    System.out.print("Tiempo: ");
                    int tiempo = sc.nextInt();

                    if (Turno.registrarTurno(ids, tipos, tiempos, id, tipo, tiempo, n)) {
                        n++;
                    }

                    sc.nextLine();
                    break;

                case 2:
                    n = Turno.atenderSiguiente(ids, tipos, tiempos, n);
                    break;

                case 3:
                    System.out.print("Ingrese el id a cancelar: ");
                    int idEliminar = sc.nextInt();
                    n = Turno.cancelarTurno(ids, tipos, tiempos, n, idEliminar);
                    sc.nextLine();
                    break;

                case 4:
                    System.out.print("Ingrese id: ");
                    id = sc.nextInt();

                    System.out.print("Ingrese tipo (P/G): ");
                    tipo = sc.next().toUpperCase().charAt(0);

                    System.out.print("Ingrese tiempo: ");
                    tiempo = sc.nextInt();

                    System.out.print("Ingrese posición k: ");
                    int k = sc.nextInt();

                    n = Turno.insertarTurnoUrgente(ids, tipos, tiempos, n, id, tipo, tiempo, k);
                    sc.nextLine();
                    break;

                case 5:
                    Turno.estadisticas(ids, tipos, tiempos, n);
                    break;

                case 6:
                    Turno.mostrarTurnos(ids, tipos, tiempos, n);
                    break;

                case 7:
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}

