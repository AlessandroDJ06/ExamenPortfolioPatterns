package components.oefening02_numericalsystemconverter.model;

public class ModelConverter {

    public enum NumericalSystems {
        BINARY, OCTAL, HEXA;
    }

    public ModelConverter() {
        // Constructor
    }

    // methods with business logic
    public String convertToNumericalSystem (String decimalValue, NumericalSystems numericalSystem) {
        int decValue;
        String result;
        try {
            decValue = Integer.parseInt(decimalValue);
            if (decValue < 0) {
                result = "Not a positive value!";
            } else {
                switch (numericalSystem) {
                    case BINARY -> result = Integer.toBinaryString(decValue);
                    case OCTAL -> result = Integer.toOctalString(decValue);
                    case HEXA -> result = Integer.toHexString(decValue);
                    default -> result = "Something went wrong";
                }
            }
        } catch (NumberFormatException exc) {
            result = "Not a decimal value!!";
        }
        return result;
    }

}
