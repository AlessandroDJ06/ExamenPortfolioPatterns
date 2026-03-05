package components.oefening02_numericalsystemconverter.model;

public class ModelConverter {
    private String resultvalue;

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
                throw new IllegalArgumentException("geef een positieve waarde in");
            } else {
                switch (numericalSystem) {
                    case BINARY -> result = Integer.toBinaryString(decValue);
                    case OCTAL -> result = Integer.toOctalString(decValue);
                    case HEXA -> result = Integer.toHexString(decValue);
                    default -> result = "Something went wrong";
                }
            }
            this.resultvalue = result;
            return result;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("De waarde '" + decimalValue + "' is geen getal!");
        }

    }

    public String getResultvalue() {
        return resultvalue;
    }
}
