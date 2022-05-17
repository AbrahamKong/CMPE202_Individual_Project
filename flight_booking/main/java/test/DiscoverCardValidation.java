package test;

/*
* Discover: length 16, and the first 4 digits begins from 6011
* */

public class DiscoverCardValidation implements CardValidation {

    private CardValidation validation;

    @Override
    public void setNextCard(CardValidation nextValidation) {
        this.validation=nextValidation;
    }

    public CardValidation getNextCard (){return this.validation;}

    @Override
    public boolean validate(String cardNumber) {
        boolean result = true;

        if(cardNumber.length() != 16){
            //If length is not 16
            result = false;
        }else if(String.valueOf(cardNumber).substring(0,4) != "6011"){
            //If first four digit is not 6011
            result = false;
        }

        return result;
    }
}