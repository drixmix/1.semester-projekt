package ControllerLayer;
import ModelLayer.LoanContainer;
import ModelLayer.Loan;

public class LoanController{
    private LoanContainer loanCon;
    private ProductController pController;
    private AccountController aC;
    /**
     * Constructor for objects of class LoanController
     */
    public LoanController(){
        loanCon = LoanContainer.getInstance();
        pController = new ProductController();
        aC = new AccountController();
    }

    /**
     * kalder metoden addLoan nede fra loanContainer
     * @return loan id
     */
    public int createLoan(int day, String phone){
        Loan loan = new Loan(day);
        loanCon.addLoan(loan);
        aC.addLoan(phone, loan);
        return loan.getId();
    }
    
    public void addItem(int id, int bar, int serial){
        loanCon.addItem(id, pController.saleItem(bar, serial));
    }
    
    /**
     * returnere et lån og tilføjer varen til productContaineren igen
     * @param bar barcode
     * @param serial serialNo
     * @return String 
     */
    public String returnItem(int id,int bar, int serial){
        pController.returnItem(bar, loanCon.returnItem(id,serial));
        return "item er returneret";
    }
    
    public double getPrice(int id){
        return loanCon.getPrice(id);
    }

}
