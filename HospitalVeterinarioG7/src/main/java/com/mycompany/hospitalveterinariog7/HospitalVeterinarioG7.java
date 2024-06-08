/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitalveterinariog7;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author nicol
 */
public class HospitalVeterinarioG7 {
    
   
    private static List<Veterinario> veterinarios = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Proveedor> proveedores = new ArrayList<>();
    private static List<Factura> facturas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicialización de algunos pacientes de ejemplo
        pacientes.add(new Paciente("123", "Paciente 1", "Perro", "Labrador", "Macho", LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1), "Cliente1", "Poliza1"));
        pacientes.add(new Paciente("124", "Paciente 2", "Gato", "Siames", "Hembra", LocalDate.of(2021, 5, 10), LocalDate.of(2023, 2, 1), "Cliente2", "Poliza2"));

        int opcion;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Veterinarios");
            System.out.println("2. Pacientes");
            System.out.println("3. Clientes");
            System.out.println("4. Proveedores");
            System.out.println("5. Facturas");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    menuVeterinarios(scanner);
                    break;
                case 2:
                    menuPacientes(scanner);
                    break;
                case 3:
                    menuClientes(scanner);
                    break;
                case 4:
                    menuProveedores(scanner);
                    break;
                case 5:
                    menuFacturas(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);
        scanner.close();
    }
    
    private static void menuVeterinarios(Scanner scanner) {
        // menú para veterinarios
        int opcion;
        do {
            System.out.println("Menú Veterinarios:");
            System.out.println("1. Ingresar nuevo médico");
            System.out.println("2. Mostrar lista de médicos");
            System.out.println("3. Calcular salario");
            System.out.println("4. Veterinario con más experiencia");
            System.out.println("5. Mostrar veterinarios por turno");
            System.out.println("6. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            metodosVeterinario metodosveterinario = new metodosVeterinario("", "", "", "", "", "", "", "", "", "", "");
         
            switch (opcion) {
                case 1:
                    veterinarios = metodosveterinario.ingresarVeterinario(scanner);
                    break;
                case 2:
                    metodosveterinario.mostrarListaVeterinarios(veterinarios);
                    break;
                case 3:
                    metodosveterinario.calcularSalario(scanner);
                    break;
                case 4:
                    metodosveterinario.mostrarVeterinarioMasExperiencia();
                    break;
                case 5:
                    metodosveterinario.mostrarVeterinariosPorTurno();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void menuPacientes(Scanner scanner) {
        // menú para pacientes
    }

    private static void menuClientes(Scanner scanner) {
        // menú para clientes
    }

    private static void menuProveedores(Scanner scanner) {
        // menú para proveedores
    }

    private static void menuFacturas(Scanner scanner) {
        int opcion;
        do {
            mostrarMenuFacturas();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (opcion) {
                case 1:
                    generarFactura();
                    break;
                case 2:
                    generarTodasLasFacturas();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 3);
    }

    private static void mostrarMenuFacturas() {
        System.out.println("Menú de Facturas:");
        System.out.println("1. Generar factura");
        System.out.println("2. Generar todas las facturas");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void generarFactura() {
        System.out.print("Ingrese el identificador del paciente: ");
        String id = scanner.nextLine();
        Paciente paciente = buscarPaciente(id);

        if (paciente == null) {
            System.out.println("Paciente no encontrado. Intente nuevamente.");
            return;
        }

        System.out.print("Ingrese el valor general de hospitalización por noche: ");
        double valorGeneral = Double.parseDouble(scanner.nextLine());

        long diasHospitalizacion = paciente.calcularDiasHospitalizado();
        double valorTotal = paciente.getNumeroPoliza() != null ? valorGeneral * diasHospitalizacion * 0.8 : valorGeneral * diasHospitalizacion;

        Factura factura = new Factura(paciente, valorTotal);
        facturas.add(factura);

        System.out.println("Factura generada:");
        System.out.println("Identificador: " + paciente.getIdentificacion());
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Fecha de ingreso: " + paciente.getFechaIngreso());
        System.out.println("Noches de hospitalización: " + diasHospitalizacion);
        System.out.println("Valor adeudado: " + factura.getValor());
    }

    private static void generarTodasLasFacturas() {
        System.out.println("Listado de todas las facturas:");
        for (Factura factura : facturas) {
            System.out.println("Número de factura: " + factura.getNumero());
            System.out.println("Identificador del paciente: " + factura.getPaciente().getIdentificacion());
            System.out.println("Nombre del paciente: " + factura.getPaciente().getNombre());
            System.out.println("Valor adeudado: " + factura.getValor());
            System.out.println("--------------");
        }
    }

    private static Paciente buscarPaciente(String id) {
        for (Paciente p : pacientes) {
            if (p.getIdentificacion().equals(id)) {
                return p;
            }
        }
        return null;
    } 
}