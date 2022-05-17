package test;

public class CreditCardValidation {
    public CardValidation start;


    public CreditCardValidation() {
        // initialize the chain
        this.start = new VISACardValidation();
        CardValidation c2 = new AmexCardValidation();
        CardValidation c3 = new DiscoverCardValidation();
        CardValidation c4 = new MasterCardValidation();

        // set the chain of responsibility
//        start.validate(f.getCardNumber());
        start.setNextCard(c2);
//        c2.validate(f.getCardNumber());
        c2.setNextCard(c3);
//        c3.validate(f.getCardNumber());
        c2.setNextCard(c4);
//        c3.validate(f.getCardNumber());
    }

    public boolean validate(String cardNumber){
        boolean result = false;
        while (result != true && this.start.getNextCard()!= null)
            result = start.validate(cardNumber);

        return result;
    }

}