package com.prs.abstraction.interfaces;

import java.util.List;

public abstract class DataTypeParser {

    public void ParseDataType(String value, List targetList, Class parseTo) throws Exception {

        switch (parseTo.getSimpleName()) {

            case "Integer":

                try {

                    targetList.add(Integer.parseInt(value));

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }

                break;

            case "int":

                try {

                    targetList.add(Integer.parseInt(value));

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }

            case "Double":

                try {

                    targetList.add(Double.parseDouble(value));

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }
                break;

            case "double":
                try {

                    targetList.add(Double.parseDouble(value));

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }
                break;

            case "Float":
                try {

                    targetList.add(Float.parseFloat(value));

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }
                break;

            case "float":
                try {

                    targetList.add(Float.parseFloat(value));

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }
                break;

            case "String":

                targetList.add(value);
                break;

            default:

                throw new Exception("Error... " +parseTo.getSimpleName() + " Datatype is not supported yet.");
        }
    }

    public Object ParseDataType(String value, Class parseTo) throws Exception {

        switch (parseTo.getSimpleName()) {

            case "Integer":

                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }

            case "int":

                try {

                    return Integer.parseInt(value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }

            case "Double":

                try {

                    return Double.parseDouble(value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }

            case "double":
                try {

                    return Double.parseDouble(value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }


            case "Float":
                try {

                    return Float.parseFloat(value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }

            case "float":

                try {

                    return Float.parseFloat(value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an integer value");

                }

            case "String":

                return value;

                default:

                throw new Exception("Error... " +parseTo.getSimpleName() + " Datatype is not supported yet.");
        }
    }
}