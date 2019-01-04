package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

		Class<?> reflec = BlackBoxInt.class;
	    Constructor[] cons = reflec.getDeclaredConstructors();
		Constructor ctor = cons[0];
		ctor.setAccessible(true);
		Constructor c = reflec.getDeclaredConstructor();
		c.setAccessible(true);

        BlackBoxInt rf = (BlackBoxInt) c.newInstance();

		Method[] allMethods = reflec.getDeclaredMethods();
		String input = br.readLine();
		while (!input.equalsIgnoreCase("end")){
			String[] tokens = input.split("[_]");
			String command = tokens[0];
			int number = Integer.parseInt(tokens[1]);
			for (Method allMethod : allMethods) {
				if (allMethod.getName().toString().equalsIgnoreCase(command)){
                    allMethod.setAccessible(true);
					allMethod.invoke(rf, number);
					Field field = reflec.getDeclaredField("innerValue");
					field.setAccessible(true);
                    int value = (int) field.get(rf);
					System.out.println(value);
				}
			}
			input = br.readLine();
		}
	}
}
