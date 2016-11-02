import java.util.Objects;

public class Agenda {

    static Person[] listName = new Person[2]; // store the names
    private String name;

    public static void main(String[] args) {
        //System.out.println("Hello World!");

        int option = 0;
        String opt = "";
        int i = 1;
        while (i == 1) {
            // afisare meniu
            System.out.println("1. Add");
            System.out.println("2. Modify");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Print");
            System.out.println("6. Exit");

            //selectare optiune
            option = SkeletonJava.readIntConsole("Option:");
            switch (option) {
                case 1:
                    opt = "Add";
                    add();
                    break;
                case 2:
                    opt = "Modify";
                    modify();
                    break;
                case 3:
                    opt = "Delete";
                    delete();
                    break;
                case 4:
                    opt = "Search";
                    search();
                    break;
                case 5:
                    opt = "Print";
                    print();
                    break;
                case 6:
                    System.out.println("Bye...");
                    i = 6;
                    break;
                default:
                    System.out.println("Invalid Choice... Try Again.");
            }
        }
    }

    static void add() {

        // de optimizat cand se umple agenda

        // de optimizat daca deja exista o pers cu acel nume
        int nullElementIndex=checkForNullElement();
        System.out.println("exista element null "+nullElementIndex);
        if (nullElementIndex!=-1){
            String name = SkeletonJava.readStringConsole("Input the name:");
            if(checkForName(name)){
                System.out.println("Name already there. type another!");
                return;
            }
            String number = SkeletonJava.readStringConsole("Input the number:");

            Person p = new Person();
            p.name = name;
            p.phoneNumber = number;
            listName[nullElementIndex] = p;

            //if (listName[existaElementNull])

        } else {
            System.out.println("gata memoria, schimba telul ");
        }
    }

    static void modify() {
        String newNume;
        String newPhone;
        String stringToSearch = SkeletonJava.readStringConsole("Name to modify:");
        boolean matchFound = false;

        for (Person p : listName) {
            if (Objects.equals(p.name, stringToSearch)) {
                newNume = SkeletonJava.readStringConsole("New Name:");
                p.name = newNume;
                newPhone = SkeletonJava.readStringConsole("New Phone:");
                p.phoneNumber = newPhone;
            }
        }

        // citeste un nume
        // il cauta in array
        // daca il gaseste cere noul nume si il substituie pe cel vechi cu cel nou
    }

    static void delete() {
        String stringToSearch = SkeletonJava.readStringConsole("Name to delete:");
        for (int i=0; i<listName.length; i++) {
            Person p=listName[i];
            if (Objects.equals(p.name, stringToSearch)) {
                listName[i]=null;
            }
        }
        // citeste un nume
        // il cauta in array
        //daca il gaseste il sterge  asa listName[unde l-a gasit]=null sau "";

    }

    static boolean search() {
        String stringToSearch = SkeletonJava.readStringConsole("Name to search:");

        for (Person p : listName) {
            if (Objects.equals(p.name, stringToSearch)) {
                System.out.println("found! " + " The name is: " + p.name + "\nThe telefon is: " + p.phoneNumber);

                return true;
            }
        }
        System.out.println("NOT found! ");
        return false;
    }

    static void print() {
        for(int i=0; i<listName.length;i++){
            Person p=listName[i];
            System.out.println("Name: "+p.name+" phone: "+p.phoneNumber);
        }
        // citeste un nume
        // il cauta in array
        // daca il gaseste cere noul nume si il substituie pe cel vechi cu cel nou
    }

    public String getName() {
        return name;
    }

    static int checkForNullElement() {
        int elementNull=-1;
        for (int i = 0; i < listName.length; i++) {

            if (listName[i] == null) {
                elementNull=i;
            }
        }
        return elementNull;
    }

    static boolean checkForName(String name) {

        for (Person p : listName) {
            if (p != null) {
                if (Objects.equals(p.name, name)) {
                    return true;
                }
            }
        }
        return false;
    }
}

