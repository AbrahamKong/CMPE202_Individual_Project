package test;

public class hasSpaceValidation implements InfoValidation{
    @Override
    public boolean validateInfo(Flight f, FlightInfo info)
    {
        boolean result = false;
        if (info.getSeatNumber() <= f.getAvailableSeats())
            result =  true;
        return result;
    }
}
