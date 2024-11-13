package _07_ReflectionAndAnnotation.exercise._01_HarvestingFields.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Class richSoilLand = RichSoilLand.class;
		Field[] fields = richSoilLand.getDeclaredFields();
		String command = scanner.nextLine();

		while (!command.equals("HARVEST")){
			printFields(fields, command);

			command = scanner.nextLine();
		}

	}

	private static void printFields(Field[] fields, String command) {
		for (Field field : fields) {
			int modifiers = field.getModifiers();
			if (command.equals("private") && Modifier.isPrivate(modifiers)){
				System.out.println("private " + field.getType().getSimpleName() + " " + field.getName());
			} else if (command.equals("public") && Modifier.isPublic(modifiers)){
				System.out.println("public " + field.getType().getSimpleName() + " " + field.getName());
			} else if (command.equals("protected") && Modifier.isProtected(modifiers)){
				System.out.println("protected " + field.getType().getSimpleName() + " " + field.getName());
			} else if (command.equals("all")){
				System.out.println(Modifier.toString(modifiers) + " " + field.getType().getSimpleName() + " " + field.getName());
			}
		}
	}
}
