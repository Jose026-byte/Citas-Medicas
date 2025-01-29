import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestationCitasApp {
    private static DBFileValidator dbFileValidator;

    public static void main(String[] args) {
        GestionCitas gestionCitas = new GestionCitas();
        gestionCitas.iniciar();
        DBFileValidator.verificarOCrearArchivosDB();
    }
}

class GestionCitas {
    private final List<Cita> listaCitas = new ArrayList<>();
    private final List<Doctor> listaDoctores = new ArrayList<>();
    private final List<Paciente> listaPacientes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.println("Bienvenido al sistema de gestión de citas");
        mostrarMenu();
    }

    private void mostrarMenu() {
        while (true) {
            System.out.println("\n1. Registrar Doctor");
            System.out.println("2. Registrar Paciente");
            System.out.println("3. Programar Cita");
            System.out.println("4. Ver Citas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarDoctor();
                    break;
                case 2:
                    registrarPaciente();
                    break;
                case 3:
                    programarCita();
                    break;
                case 4:
                    mostrarCitas();
                    break;
                case 5:
                    System.out.println("Hasta pronto");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void registrarDoctor() {
        System.out.print("Ingrese el nombre del doctor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la especialidad del doctor: ");
        String especialidad = scanner.nextLine();

        Doctor doctor = new Doctor(nombre, especialidad);
        listaDoctores.add(doctor);
        System.out.println("Doctor registrado exitosamente.");
    }

    private void registrarPaciente() {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Paciente paciente = new Paciente(nombre, edad);
        listaPacientes.add(paciente);
        System.out.println("Paciente registrado exitosamente.");
    }

    private void programarCita() {
        if (listaDoctores.isEmpty() || listaPacientes.isEmpty()) {
            System.out.println("Debe registrar al menos un doctor y un paciente antes de programar una cita.");
            return;
        }

        System.out.println("Seleccione un doctor:");
        for (int i = 0; i < listaDoctores.size(); i++) {
            System.out.println(i + ". " + listaDoctores.get(i).getNombre() + " - " + listaDoctores.get(i).getEspecialidad());
        }
        System.out.print("Ingrese el índice del doctor: ");
        int indiceDoctor = scanner.nextInt();
        scanner.nextLine();
        Doctor doctorSeleccionado = listaDoctores.get(indiceDoctor);

        System.out.println("Seleccione un paciente:");
        for (int i = 0; i < listaPacientes.size(); i++) {
            System.out.println(i + ". " + listaPacientes.get(i).getNombre() + ", Edad: " + listaPacientes.get(i).getEdad());
        }
        System.out.print("Ingrese el índice del paciente: ");
        int indicePaciente = scanner.nextInt();
        scanner.nextLine();
        Paciente pacienteSeleccionado = listaPacientes.get(indicePaciente);

        System.out.print("Ingrese la fecha y hora de la cita (YYYY-MM-DDTHH:MM): ");
        String fechaHora = scanner.nextLine();

        Cita cita = new Cita(doctorSeleccionado, pacienteSeleccionado, fechaHora);
        listaCitas.add(cita);
        System.out.println("Cita programada exitosamente.");
    }

    private void mostrarCitas() {
        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas programadas.");
        } else {
            for (Cita cita : listaCitas) {
                System.out.println(cita.getDetalles());
            }
        }
    }
}

class Doctor {
    private final String nombre;
    private final String especialidad;

    public Doctor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

class Paciente {
    private final String nombre;
    private final int edad;

    public Paciente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

class Cita {
    private final Doctor doctor;
    private final Paciente paciente;
    private final String fechaHora;

    public Cita(Doctor doctor, Paciente paciente, String fechaHora) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
    }

    public String getDetalles() {
        return "Cita con " + doctor.getNombre() + " para " + paciente.getNombre() + " el " + fechaHora;
    }
}

