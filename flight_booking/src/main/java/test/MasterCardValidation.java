package test;

/*
* Mastercard: has length 16. Begins with 5 and the 2nd digit begins from 1 to 5 inclusive
* */

public class MasterCardValidation implements CardValidation {

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
        }else if(String.valueOf(cardNumber).substring(0,1) != "5"){
            //If first digit is not 5
            if (String.valueOf(cardNumber).substring(1, 2)!= "1" || String.valueOf(cardNumber).substring(1, 2)!= "5"){
                //If second digit is not 1 or 5
                result = false;
            }
        }

        return result;
    }
}


//public class MasterCardValidation extends CardValidation {
//    /**
//     * Please, not that checkNext() call can be inserted both in the beginning
//     * of this method and in the end.
//     *
//     * This gives much more flexibility than a simple loop over all middleware
//     * objects. For instance, an element of a chain can change the order of
//     * checks by running its check after all other checks.
//     */
//    public boolean check(String cardNumber) {
//        boolean result = true;
//        if(cardNumber.length() != 16){
//            //If length is not 16
//            result = false;
//        }else if(String.valueOf(cardNumber).substring(0,1) != "5"){
//            //If first digit is not 5
//            if (String.valueOf(cardNumber).substring(1, 2)!= "1" || String.valueOf(cardNumber).substring(1, 2)!= "5"){
//                //If second digit is not 1 or 5
//                result = false;
//            }
//        }
//
//        return checkNext(cardNumber);
//    }
//}