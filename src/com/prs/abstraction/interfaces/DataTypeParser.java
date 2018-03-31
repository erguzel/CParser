package com.prs.abstraction.interfaces;

import java.util.List;

public abstract class DataTypeParser {

    public void ParseDataType(String value, List<Object> targetList, Class<? extends Object> parseTo) throws Exception {

        switch (parseTo.getSimpleName()) {

            case "Integer":

                try {

                    targetList.add(Integer.parseInt(value));
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an "+ parseTo.getSimpleName() + "value");

                }


            case "int":

                try {

                    targetList.add(Integer.parseInt(value));
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an "+ parseTo.getSimpleName() + " value");

                }

            case "double":

                try {

                    targetList.add(Double.parseDouble(value));
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be a "+ parseTo.getSimpleName() +" value");

                }

            case "Double":

                try {

                    targetList.add(Double.parseDouble(value));
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be a "+ parseTo.getSimpleName() +" value");

                }

            case "Float":
                try {

                    targetList.add(Float.parseFloat(value));
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be a "+ parseTo.getSimpleName() +" value");

                }

            case "float":
                try {

                    targetList.add(Float.parseFloat(value));
                    break;

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be a "+ parseTo.getSimpleName() +" value");

                }

            case "String":

                targetList.add(value);

                break;

            default:

                throw new Exception("Error... " + parseTo.getSimpleName() + " Datatype is not supported yet.");
        }
    }

    public Object ParseDataType(Object value, Class<? extends Object> parseTo) throws Exception {

        switch (parseTo.getSimpleName()) {

            case "Integer":

                try {

                    return Integer.parseInt((String )value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an " + parseTo.getSimpleName() +"  value");

                }

            case "int":

                try {

                    return Integer.parseInt((String )value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be an "+ parseTo.getSimpleName() +"  value");

                }

            case "Double":

                try {

                    return Double.parseDouble((String )value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be a "+ parseTo.getSimpleName() +"  value");

                }

            case "double":
                try {

                    return Double.parseDouble((String )value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be a "+ parseTo.getSimpleName() +"  value");

                }


            case "Float":
                try {

                    return Float.parseFloat((String )value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be a "+ parseTo.getSimpleName() +"  value");

                }

            case "float":

                try {

                    return Float.parseFloat((String )value);

                } catch (NumberFormatException e) {

                    throw new Exception("Error:... " + value + " must be a "+ parseTo.getSimpleName() +"  value");

                }

            case "String":

                return value;

            default:

                throw new Exception("Error... " + parseTo.getSimpleName() + " Datatype is not supported yet.");
        }
    }
}