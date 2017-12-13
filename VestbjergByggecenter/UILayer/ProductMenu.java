package UILayer;
import ControllerLayer.*;
import ModelLayer.*;
import java.util.Scanner;

public class ProductMenu {

    private ProductController productCtr;
    private Scanner keyboard = new Scanner(System.in);

    public ProductMenu(){
        productCtr = new ProductController(); 
    }

    public void ProductMainMenu(){
        System.out.println("\f##### Produkt Menu #####");
        System.out.println("Indtast et tal mellem 1-4 for at vælge menu");
        System.out.println("Tast 5 for at gå tilbage");
        System.out.println(" 1. Opret simpelt produkt");
        System.out.println(" 2. Opret unikt produkt");
        System.out.println(" 3. Opret produkt kopi");
        System.out.println(" 4. Find Produkt");
        System.out.println(" 5. Go Back");

        int choice = keyboard.nextInt();
        if(choice == 1){
            createMassProduct();
        } else if(choice == 2) {
            createUniqueProduct();
        } else if(choice == 3) {
            createCopyProduct();
        } else if(choice == 4) {
            findProduct();
        } else if(choice == 5) {

        }

    }

    public void createMassProduct(){
        System.out.println("Produkt barkode:" );
        int barcode = keyboard.nextInt();
        System.out.println("Produkt navn:" );
        String name = keyboard.next();
        System.out.println("Produkt description:" );
        String description = keyboard.next();
        System.out.println("Produkt pris:" );
        int price = keyboard.nextInt();
        System.out.println("Produkt antal:" );
        int amount = keyboard.nextInt();

        System.out.println("### " + productCtr.createMassProduct(barcode, name, description, price, amount) + " ###");
        vent();
    }

    public void createUniqueProduct(){
        System.out.println("Produkt barkode:" );
        int barcode = keyboard.nextInt();
        System.out.println("Produkt navn:" );
        String name = keyboard.next();
        System.out.println("Produkt description:" );
        String description = keyboard.next();
        System.out.println("Produkt pris:" );
        int price = keyboard.nextInt();
        System.out.println("Produkt antal:" );
        int amount = keyboard.nextInt();

        System.out.println("### " + productCtr.createUniqueProduct(barcode, name, description, price, amount) + " ###");
        vent();
    }

    public void createCopyProduct(){
        System.out.println("Produkt barkode:" );
        int barcode = keyboard.nextInt();
        System.out.println("Produkt navn:" );
        String name = keyboard.next();
        System.out.println("Produkt description:" );
        String description = keyboard.next();
        System.out.println("Produkt pris:" );
        int price = keyboard.nextInt();
        System.out.println("Produkt levering:" );
        boolean levering = keyboard.nextBoolean();

        System.out.println("### " + productCtr.createItem(barcode, name, description, price, levering) + " ###");
        vent();
    }

    public void findProduct(){
        try {
            System.out.println("Indtast barkode på produkt:" );
            int barcode = keyboard.nextInt();

            Product productObj = productCtr.findSpecificProduct(barcode);

            System.out.println("Produkt navn: " + productObj.getName());
            System.out.println("Produkt beskrivelse: " + productObj.getDescription());
            System.out.println("Produkt antal: " + productObj.getPrice());

            String vent = keyboard.next();
            System.out.println(" ");
        }   catch(NullPointerException e){
            System.out.println("Produkt kan ikke findes!");
            vent();
        }
    }

    public void cretedummy(){
        productCtr.createdummydata();    
    }

    public void vent(){
        String vent = keyboard.next();
        System.out.println(" "); 
    }

}
