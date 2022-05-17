package test;

public class hasFlightNumberValidation implements InfoValidation{
    @Override
    public boolean validateInfo(Flight f, FlightInfo info)
    {
        boolean result = false;
        if (f.getFlightNumber().equals(info.getFlightNumber()))
            result =  true;
        return result;
    }
}