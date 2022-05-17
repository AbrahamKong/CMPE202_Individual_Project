package test;

/*
* Visa card: has length either 13 or 16. It begins with a 4
* */

public class VISACardValidation implements CardValidation {

    private CardValidation validation;

    @Override
    public void setNextCard(CardValidation nextValidation) {
        this.validation = nextValidation;
    }

    public CardValidation getNextCard (){return this.validation;}

    @Override
    public boolean validate(String cardNumber) {
        boolean result = false;

        if (cardNumber.length() == 13 || cardNumber.length() == 16) {
//            System.out.println(cardNumber + "'s length is not 13 or 16 in VISA");
            //If length is not 13 or 16
            result = true;
        }

        if (cardNumber.substring(0, 1) == "4") {
            System.out.println(cardNumber + "'s first digit is not 4 in VISA");
            //If first digit is not 4
            result = true;
        }

//        System.out.println(result + "3");
        return result;
    }
}