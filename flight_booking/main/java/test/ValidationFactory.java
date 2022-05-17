package test;

public class ValidationFactory {
    public static InfoValidation createValidation(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        switch (channel) {
            case "hasFlightNumber":
                return new hasFlightNumberValidation();
            case "hasSeatCategory":
                return new hasSeatCategoryValidation();
            case "hasSpace":
                return new hasSpaceValidation();
            default:
                throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}