package Menu;

import Border.Border;
import Dao.StudentDao;
import Dto.StudentDto;

import java.sql.SQLOutput;
import java.util.Scanner;

public  class DisplayMenu {
    static Border border = new Border();
    static Scanner input = new Scanner(System.in);
    static String  choices;
    static boolean insertAgain = true;
    static  StudentDao studentDao = new StudentDao();

    public  static void menuDisplay(){
        do {
            System.out.println();
            System.out.println("|------------------------------------------------|");
            System.out.println("|-------------------MENU OPTION------------------|");
            System.out.println("|------------------------------------------------|");
            System.out.println("|   1 = Insert      2 = Update   3 = DeleteById  |");
            System.out.println("|                                                |");
            System.out.println("|   4 = SearchById  5 = ShowAll  6 = Exit        |");
            System.out.println("|------------------------------------------------|");
            System.out.print("ENTER OPTION : ");
            choices =input.nextLine();

            switch (choices){
                case "1" :

                    do {
                        System.out.println();
                        System.out.println("-----------------------INSERT DATA-----------------------");
                        System.out.print("Enter Student ID : ");
                        int id = input.nextInt();
                        System.out.print("Enter Student Name : ");
                        String name = input.next();
                        System.out.print("Enter Student age :");
                        int age = input.nextInt();
                        System.out.print("Enter Student POD :");
                        String pod = input.next();
                        input.nextLine();
                        System.out.println("Student inserted successfully.");
                        System.out.print("Do you want to insert data again? (yes/no)");
                        StudentDto studentDto = new StudentDto(id,name,age,pod);
                        studentDao.insert(studentDto);

                        String answer = input.nextLine();
                        if (answer.equals("no")) {
                            insertAgain = false;
                        }
                    } while (insertAgain);
                    System.out.println("GOOD LUCK ! ");
                    break;
                case "2" :

                    do {
                        System.out.println();
                        System.out.println("-----------------------Update Data-----------------------");
                        System.out.print("Enter Student ID : ");
                        int updateIds = input.nextInt();
                        System.out.print("Enter Student New Age : ");
                        int newAges = input.nextInt();
                        studentDao.update(updateIds , newAges);
                        System.out.println("Student age updated successfully.");
                        System.out.print("Do you want to Update data again? (yes/no)");
                        String answer = input.nextLine();

                        if (answer.equals("no")) {
                            insertAgain = false;
                        }
                    } while (insertAgain);

                    break;
                case "3" :

                    do {
                        System.out.println();
                        System.out.println("-----------------------DELETEById Data-----------------------");
                        System.out.print("Enter Student ID : ");
                        int deleteId = Integer.parseInt(input.nextLine());
                        boolean isDeleted = studentDao.delete(deleteId);

                        if (isDeleted) {
                            System.out.println("Student deleted successfully.");
                        } else {
                            System.out.println("ID not found");
                        }

                        System.out.print("Do you want to Delete data again? (yes/no)");
                        String answer = input.nextLine();

                        if (answer.equals("no")) {
                            insertAgain = false;
                        }
                    } while (insertAgain);
                    break;
                case "4" :

                    do {
                        System.out.println();
                        System.out.println("-----------------------SearchById Data-----------------------");
                        System.out.println("Enter Student ID : ");
                        int SearchID = input.nextInt();
                        StudentDto  searchStudentDto= studentDao.searchById(SearchID);
                        if (searchStudentDto !=null){
                            System.out.println("Student ID Found");
                            border.printTableHeader();
                            System.out.println(searchStudentDto);
                            border.printTableFooter();

                        }
                        input.nextLine();
                        System.out.print("Do you want to Search data again? (yes/no)");
                        String answer = input.nextLine();

                        if (answer.equals("no")) {
                            insertAgain = false;
                        }
                    } while (insertAgain);
                    break;
                case "5" :

                    do {
                        System.out.println();
                        System.out.println("-------------------ShowAll Data-------------------");
                        studentDao.showAll();
                        System.out.print("Do you want to Show data again? (yes/no)");
                        String answer = input.nextLine();

                        if (answer.equals("no")) {
                            insertAgain = false;
                        }
                    } while (insertAgain);
                    break;
                case "6" :
                    System.out.println("Exiting the program...");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("INPUT ONLY [1-6]!!!");
            }

        }while (true);
    }
}
