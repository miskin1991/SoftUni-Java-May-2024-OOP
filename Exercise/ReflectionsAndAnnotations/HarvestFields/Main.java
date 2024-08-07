package Exercise.ReflectionsAndAnnotations.HarvestFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> clazz = RichSoilLand.class;


		String command = scanner.nextLine();
		while (!command.equals("HARVEST")) {
			switch (command) {
				case "private":
					printFields(clazz, f -> Modifier.isPrivate(f.getModifiers()));
					break;
				case "protected":
					printFields(clazz, f -> Modifier.isProtected(f.getModifiers()));
					break;
				case "public":
					printFields(clazz, f -> Modifier.isPublic(f.getModifiers()));
					break;
				case "all": {
					Arrays.stream(clazz.getDeclaredFields()).forEach(f ->
							System.out.printf("%s %s %s%n",
								Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
					break;
				}
				default:
					break;
			}

			command = scanner.nextLine();
		}
	}

	private static void printFields(Class<RichSoilLand> clazz, Predicate<Field> isProtected) {
		Arrays.stream(clazz.getDeclaredFields())
				.filter(isProtected)
				.forEach(f -> System.out.printf("%s %s %s%n",
						Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
	}
}
