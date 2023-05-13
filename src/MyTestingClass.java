/*
*   value -  variable types of int in the TestingClass
*   MyTestingClass - constructor
*   getValue - getter for the variable
*   setValue - setter for the variable
*   hashCode - method that hashes the value
* */

public class MyTestingClass {
    private  int value;

    public MyTestingClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result + value;
        return result;
    }
}
