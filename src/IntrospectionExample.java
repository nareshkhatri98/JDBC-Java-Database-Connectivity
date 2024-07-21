

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Car{
    private  String brand;
    private  int year;

    public  Car(String brand , int year)
    {
        this.brand = brand;
        this.year = year;
    }
    public  String getBrand()
    {
       return brand;
    }
    public  void  setBrand(String brand)
    {
        this.brand = brand;
    }

    public  int  getYear()
    {
        return  year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public  void DisplayInfo()
    {
        System.out.println("Car brand : "+brand +"," + "Year is :" +year);
    }
}

public class IntrospectionExample {
    public static void main(String[] args) throws Exception
    {
        // Get the  class object associated with Car
       Class<?> carClass = Class.forName("Car"); //Generic as class

        // get the constructor
        Constructor<?> constructor = carClass.getConstructor(String.class, int.class);
    //  create an instance using the constructor
        Object car = constructor.newInstance("Toyota", 2020);

//        get the fields
        Field brandField = carClass.getDeclaredField("brand");
        Field yearField = carClass.getDeclaredField("year");

//        make the Fields accessible.
        brandField.setAccessible(true);
        yearField.setAccessible(true);

//      Get orginal values
        String orignalBrand = (String) brandField.get(car);
        int orginlYear = (int) yearField.get(car);
        System.out.println("Orignal brand :" +orignalBrand);
        System.out.println("Orignal Year: " +orginlYear);

//        modify the fields
        brandField.set(car,"Honda");
        yearField.set(car,2021);

//        get the methods
        Method getBrandMethod = carClass.getMethod("getBrand");
        Method getYearMethod = carClass.getMethod("getYear");
        Method displayMethod = carClass.getMethod("DisplayInfo");

//        invoke the methods
        String  modiFieldBrand = (String)  getBrandMethod.invoke(car);
        int modiFieldYear= (int) getYearMethod.invoke(car);
        displayMethod.invoke(car);

//        output the modify values
        System.out.println("modify brand: "+ modiFieldBrand);
        System.out.println("modify year: "+ modiFieldYear);

    }
}
