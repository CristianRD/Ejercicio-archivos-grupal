/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos_estudiante;

import java.io.File;
import java.util.Scanner;
import Student.Student;

/**
 *
 * @author Alaro Niño
 */
public class Datos_estudiante {

    public static Student open() throws Exception {
        String strFilename = "";
        String strStudentIdentificationNumber;
        String strCreditsSoFar;
        String strGPA;

        Student majoring = new Student();
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        strFilename = scnr.next();

        if (!strFilename.equals("")) {
            // Indicate that you are planning to opena file
            File fleStudent = new File(strFilename);
            // Prepare a Scanner that will "scan" the document
            Scanner opnStudentInfo = new Scanner(fleStudent);

            // Read each line in the file
            while (opnStudentInfo.hasNext()) {
                // Read each line and display its value
                strStudentIdentificationNumber = opnStudentInfo.nextLine();
                majoring.StudentIdentificationNumber
                        = Integer.parseInt(strStudentIdentificationNumber);
                majoring.FirstName = opnStudentInfo.nextLine();
                majoring.LastName = opnStudentInfo.nextLine();
                strCreditsSoFar = opnStudentInfo.nextLine();
                majoring.CreditsSoFar = Integer.parseInt(strCreditsSoFar);
                strGPA = opnStudentInfo.nextLine();
                majoring.GPA = Double.parseDouble(strGPA);
            }

            // De-allocate the memory that was used by the scanner
            opnStudentInfo.close();
        }

        return majoring;
    }

    public static void show(Student std) throws Exception {
        System.out.println("Record de estudiante");
        System.out.println("ID de estudiante: " + std.StudentIdentificationNumber);
        System.out.println("Nombre: " + std.FirstName);
        System.out.println("Apellido: " + std.LastName);
        System.out.println("Numero de creditos hasta ahora: " + std.CreditsSoFar);
        System.out.println("Promedio general: " + std.GPA);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i != 1; i--) {

            String mainAnswer = "Q", answer = "N";
            Scanner scnr = new Scanner(System.in);

            System.out.println("Bienvenidos al gestor de datos");
            System.out.println("Que desea hacer?");
            System.out.println("I - Ingresar datos de estudiante");
            System.out.println("C - Cosultar datos de estudiante");
            System.out.println("E - Eliminar estudiante");
            System.out.println("S - Salir");
            System.out.print("tu respuesta? ");
            mainAnswer = scnr.next();
            try {
                if ((mainAnswer.equals("i")) || (mainAnswer.equals("I"))) {
                    //Student std = register();
                    System.out.print("¿Desea salvar esta informacion (y/n)? ");
                    answer = scnr.next();
                    if ((answer.equals("y")) || (answer.equals("Y"))) {
               // show(std);
                        // save(std);
                    }
                } else if ((mainAnswer.equals("c")) || (mainAnswer.equals("C"))) {
                    Student std = open();
                    show(std);
                } else if ((mainAnswer.equals("s")) || (mainAnswer.equals("S"))) {
                    System.out.println("¿Desea salir? (y/n)");
                    answer = scnr.next();
                    if ((answer.equals("y")) || (answer.equals("Y"))) {
                        System.exit(1);
                    } else if ((mainAnswer.equals("n")) || (mainAnswer.equals("N"))) {
                    }

                }
                   if ((mainAnswer.equals("e")) || (mainAnswer.equals("E"))) {
                    System.out.println("¿Seguro que desea eliminar?(y/n)");
                    answer = scnr.next();
                    if ((mainAnswer.equals("y")) || (mainAnswer.equals("Y"))) {
                        System.out.println("Student std = eliminar()");
                        System.out.println("Archivo eliminado");
                    } else if ((mainAnswer.equals("n")) || (mainAnswer.equals("N"))) {
                    }
                } else {
                    System.out.println("Good Bye!!!");
                }
            } catch (Exception ex) {

            }
        }
    }
}
