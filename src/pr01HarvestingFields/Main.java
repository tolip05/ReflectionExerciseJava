package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws IOException {
     Class<?> rs = RichSoilLand.class;
		Field[] allFields = rs.getDeclaredFields();

		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		while (!input.equalsIgnoreCase("harvest")){
           if (!input.equalsIgnoreCase("all")){
			   for (Field allField : allFields) {
                if (Modifier.toString(allField.getModifiers()).equalsIgnoreCase(input)){
					System.out.printf(String.format("%s %s %s"
					, Modifier.toString(allField.getModifiers())
					,allField.getType().getSimpleName(),allField.getName()));
					System.out.println();
				}
			   }
		   }else{
			   for (Field allField : allFields) {
				   System.out.printf(String.format("%s %s %s"
						   , Modifier.toString(allField.getModifiers())
						   ,allField.getType().getSimpleName(),allField.getName()));
				   System.out.println();
			   }
		   }


			input = br.readLine();
		}

	}
}
