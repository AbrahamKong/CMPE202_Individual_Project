package test;

/*
 * Amex: has length 15 and starts with 3. 2nd digit must be 4 or 7
 * */

public class AmexCardValidation implements CardValidation {

    private CardValidation validation;

    @Override
    public void setNextCard(CardValidation nextValidation) {
        this.validation=nextValidation;
    }

    public CardValidation getNextCard (){return this.validation;}

    @Override
    public boolean validate(String cardNumber) {
        boolean result = false;

        //System.out.println(cardNumber + "'s length is not 13 or 16 in Amex");
        //If length is 15
        if (cardNumber.length() == 15) result = true;

        if (cardNumber.substring(0, 1).equals("3")) {
            if (cardNumber.substring(1, 2).equals("4") || cardNumber.substring(1, 2).equals("7")) {
//            System.out.println(cardNumber + "'s first digit is not 4 in Amex");
                //If first digit is 3
                //and second digit is 4 or 7
                result = true;
            }
        }

//        System.out.println(result + "3");
        return result;
    }
}