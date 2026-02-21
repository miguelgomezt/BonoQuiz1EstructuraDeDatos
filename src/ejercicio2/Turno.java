package ejercicio2;

public class Turno {
    int[] ids = new int[50];
    char[] tipos = new char[50];
    int[] tiempos = new int[50];
    int n = 0;


    public Turno(int[] ids, char[] tipos, int[] tiempos, int n) {
        this.ids = ids;
        this.tipos = tipos;
        this.tiempos = tiempos;
        this.n = n;
    }


    public static void registrarTurno() {
    }

    public static void atenderSiguiente() {
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public char[] getTipos() {
        return tipos;
    }

    public void setTipos(char[] tipos) {
        this.tipos = tipos;
    }

    public int[] getTiempos() {
        return tiempos;
    }

    public void setTiempos(int[] tiempos) {
        this.tiempos = tiempos;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public static boolean registrarTurno(int[] ids, char[] tipos, int[] tiempos,
                                         int id, char tipo, int tiempo, int n) {

        if (n >= ids.length) {
            System.out.println("No hay espacio para más turnos.");
            return false;
        }

        if (tipo != 'P' && tipo != 'G') {
            System.out.println("Tipo inválido.");
            return false;
        }

        if (tiempo < 1 || tiempo > 60) {
            System.out.println("Tiempo inválido.");
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (ids[i] == id) {
                System.out.println("El id ya existe.");
                return false;
            }
        }

        ids[n] = id;
        tipos[n] = tipo;
        tiempos[n] = tiempo;

        return true;
    }
    public static int atenderSiguiente(int[] ids, char[] tipos, int[] tiempos, int n) {

        if (n == 0) {
            System.out.println("No hay turnos para atender.");
            return n;
        }

        int pos = -1;

        for (int i = 0; i < n; i++) {
            if (tipos[i] == 'P') {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            for (int i = 0; i < n; i++) {
                if (tipos[i] == 'G') {
                    pos = i;
                    break;
                }
            }
        }

        System.out.println("Atendiendo turno:");
        System.out.println("ID: " + ids[pos]);
        System.out.println("Tipo: " + tipos[pos]);
        System.out.println("Tiempo: " + tiempos[pos] + " minutos");

        for (int i = pos; i < n - 1; i++) {
            ids[i] = ids[i + 1];
            tipos[i] = tipos[i + 1];
            tiempos[i] = tiempos[i + 1];
        }

        n--;

        return n;
    }
    public static int cancelarTurno(int[] ids, char[] tipos, int[] tiempos,
                                    int n, int idBuscado) {

        if (n == 0) {
            System.out.println("No hay turnos registrados.");
            return n;
        }

        int pos = -1;

        for (int i = 0; i < n; i++) {
            if (ids[i] == idBuscado) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("No existe un turno con ese id.");
            return n;
        }

        System.out.println("Turno cancelado:");

        for (int i = pos; i < n - 1; i++) {
            ids[i] = ids[i + 1];
            tipos[i] = tipos[i + 1];
            tiempos[i] = tiempos[i + 1];
        }

        n--;

        return n;
    }

    public static int insertarTurnoUrgente(int[] ids, char[] tipos, int[] tiempos,
                                           int n, int id, char tipo, int tiempo, int k) {

        if (n >= ids.length) {
            System.out.println("No hay espacio disponible.");
            return n;
        }

        if (k < 0 || k > n) {
            System.out.println("Posición inválida.");
            return n;
        }

        if (tipo != 'P' && tipo != 'G') {
            System.out.println("Tipo inválido.");
            return n;
        }

        if (tiempo < 1 || tiempo > 60) {
            System.out.println("Tiempo inválido.");
            return n;
        }

        for (int i = 0; i < n; i++) {
            if (ids[i] == id) {
                System.out.println("El id ya existe.");
                return n;
            }
        }

        for (int i = n; i > k; i--) {
            ids[i] = ids[i - 1];
            tipos[i] = tipos[i - 1];
            tiempos[i] = tiempos[i - 1];
        }

        ids[k] = id;
        tipos[k] = tipo;
        tiempos[k] = tiempo;

        n++;

        System.out.println("Turno urgente insertado correctamente.");

        return n;
    }
    public static void estadisticas(int[] ids, char[] tipos, int[] tiempos, int n) {

        if (n == 0) {
            System.out.println("No hay turnos registrados.");
            return;
        }

        int sumaTiempos = 0;
        int contadorP = 0;
        int contadorG = 0;

        int mayorTiempo = tiempos[0];
        int idMayor = ids[0];
        char tipoMayor = tipos[0];

        for (int i = 0; i < n; i++) {

            sumaTiempos += tiempos[i];

            if (tipos[i] == 'P') {
                contadorP++;
            } else if (tipos[i] == 'G') {
                contadorG++;
            }

            if (tiempos[i] > mayorTiempo) {
                mayorTiempo = tiempos[i];
                idMayor = ids[i];
                tipoMayor = tipos[i];
            }
        }

        double promedio = (double) sumaTiempos / n;

        double porcentajeP = (contadorP * 100.0) / n;
        double porcentajeG = (contadorG * 100.0) / n;

        System.out.println("Promedio de tiempo: " + promedio);
        System.out.println("% Preferenciales: " + porcentajeP + "%");
        System.out.println("% Generales: " + porcentajeG + "%");
        System.out.println("Turno con mayor tiempo:");
        System.out.println("ID: " + idMayor);
        System.out.println("Tipo: " + tipoMayor);
        System.out.println("Tiempo: " + mayorTiempo + " minutos");
    }
    public static void mostrarTurnos(int[] ids, char[] tipos, int[] tiempos, int n) {
        if (n == 0) {
            System.out.println("No hay turnos registrados.");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + " | " + ids[i] + " | " + tipos[i] + " | " + tiempos[i]);
        }
    }
}
