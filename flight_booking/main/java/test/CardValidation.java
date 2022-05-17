package test;

    /*
     * Visa card: has length either 13 or 16. It begins with a 4
     * Mastercard: has length 16. Begins with 5 and the 2nd digit begins from 1 to 5 inclusive
     * Discover: length 16, and the first 4 digits begins from 6011
     * Amex: has length 15 and starts with 3. 2nd digit must be 4 or 7
     * Any card greater than 19 or not satisfying above conditions is considered invalid
     * */

public interface CardValidation {

    void setNextCard(CardValidation nextValidation);
    boolean validate(String cardNumber);
    CardValidation getNextCard();
}

//public abstract class CardValidation {
//    private CardValidation next;
//
//    void setNextCard(CardValidation nextValidation){}
//    boolean validate(String cardNumber){}
//
//    /**
//     * Builds chains of middleware objects.
//     */
//    public CardValidation linkWith(CardValidation next) {
//        this.next = next;
//        return next;
//    }
//
//    /**
//     * Subclasses will implement this method with concrete checks.
//     */
//    public abstract boolean check(String cardNumber);
//
//    /**
//     * Runs check on the next object in chain or ends traversing if we're in
//     * last object in chain.
//     */
//    protected boolean checkNext(String cardNumber) {
//        if (next == null) {
//            return true;
//        }
//        return next.check(card);
//    }
//}