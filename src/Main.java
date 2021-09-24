import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        // Checking requirements from Task1
        StringClass myStringClass = new StringClass();
        System.out.println(myStringClass);
        Class<?> myClass = myStringClass.getClass();
        Field[] allFields = myClass.getDeclaredFields();
        int length = allFields.length;
        if (length > 1) {
            Arrays.stream(allFields).forEach(value -> {
                System.out.println("Name : " + value.getName());
                System.out.println("Type : " + value.getType().getName());
            });
        }
        String name = allFields[0].getName();
        System.out.println("Name : " + name);
        Field field = myClass.getDeclaredField(name);
        field.set(myStringClass, "Immutable?! OMG, i`m broke it");
        System.out.println(myStringClass);

        // Checking requirements from Task2
        Class<Math> myMathClass = Math.class;
        Method[] mathMethods = myMathClass.getDeclaredMethods();
        for (Method method : mathMethods) {
            System.out.println("Name : " + method.getName());
            System.out.println("Return type : " + method.getReturnType().getName());

            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.print("Parameter types: ");
            for (Class<?> paramType : paramTypes) {
                System.out.println(" " + paramType.getName());
            }

            Constructor<?> constructor = myMathClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Math math = (Math) constructor.newInstance();

        }
    }
}
