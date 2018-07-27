package com.erg.cpaar.operate;

public class TypeParser {

    public static Object ParseDataType(Class<?> parseTo, String data) throws Exception {
        Object value = new Object();
        switch (parseTo.getSimpleName()) {

            case "Integer":

                try {

                  value = Integer.parseInt(data);

                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + data + " must be an " + parseTo.getSimpleName() + "value");

                }
            case "int":

                try {

                    value = Integer.parseInt(data);
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + data + " must be an " + parseTo.getSimpleName() + " value");

                }

            case "double":

                try {

                    value = Double.parseDouble(data);
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + data + " must be a " + parseTo.getSimpleName() + " value");

                }

            case "Double":

                try {

                    value = Double.parseDouble(data);
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + data + " must be a " + parseTo.getSimpleName() + " value");

                }

            case "Float":
                try {

                    value = Float.parseFloat(data);
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + data + " must be a " + parseTo.getSimpleName() + " value");

                }

            case "float":
                try {

                    value = Float.parseFloat(data);
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + data + " must be a " + parseTo.getSimpleName() + " value");

                }

            case "String":

                value = data.trim();

                break;

            default:

                throw new Exception("Error... " + parseTo.getSimpleName() + " Datatype is not supported yet.");
        }
        return value;
    }

    public static boolean isInteger(String argument){

        try {
            Integer.parseInt(argument);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
