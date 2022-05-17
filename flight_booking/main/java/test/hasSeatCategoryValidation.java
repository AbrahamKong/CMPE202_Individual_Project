package test;

public class hasSeatCategoryValidation implements InfoValidation{
    @Override
    public boolean validateInfo(Flight f, FlightInfo info)
    {
        boolean result = false;
        if (f.getSeatCategory().equals(info.getSeatCategory()))
            result =  true;
        return result;
    }
}