package Mainpack;


	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class text_var4 {
		public static String make(String name) throws FileNotFoundException {
			StringBuilder builder = new StringBuilder();
			File file = new File(name);
			if (!file.exists()) {
				throw new FileNotFoundException(file.getName());
			}
			try {
				BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
				try {
					String str;
					while ((str = in.readLine()) != null) {
						//if (str == "\n"){
						builder.append(str);
						builder.append("\n");//}
						System.out.println(str);
					}
				} finally {
					in.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return builder.toString();
		}

		/*public static void task1(String str1, String str2) {
			Pattern pattern = Pattern.compile(str1);
			Matcher matcher = pattern.matcher(str2);
			int i = 0;
			while (matcher.find()) {
				System.out.println("Found constans: " + matcher.group());
				i++;
			}
			System.out.println("Count: "+ i);
		}*/
		
		public static void  task2(String oldPattern, String newPattern, String read, String wright) throws FileNotFoundException {
			Pattern pattern = Pattern.compile(oldPattern);
			Matcher matcher = pattern.matcher(read);
			File newFile = new File(wright);
			if (!newFile.exists()) {
				throw new FileNotFoundException(newFile.getName());
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(newFile.getAbsoluteFile()));
				try {
					System.out.println(newPattern);
					out.write(matcher.replaceAll(newPattern));
				} finally {
					out.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Finished");
		}
		
		public static void main(String[] args) throws IOException {
			//String readFile = "C:\\Users\\1\\Desktop\\text.txt";
			String readFile = "C:\\Users\\1\\Desktop\\s.txt";
			String wrightFile = "C:\\Users\\1\\Desktop\\file.txt";
			String x = make(readFile);
			//task2("(|)(\\w)(|)(-{0,1})(\\d+)(|)(\\+\\d+)(|)(\\w+)(@{0,1})(@)(\\w+)(.{0,1})(.)(\\w+)", "$1$2$3$5$6$7$8$10$11$12$14$15", x, wrightFile);$22-$24-$26-$28
			task2("(\\w+)(\\|)(-)(\\d+)(\\|)(\\+?)", "$1$2$4$5$6", x, wrightFile);
			//task1("\\b\\d{1,4}\\b", x);//количество числовых констант короче 4 символов
			//task1("\\b(\\d{1,2}|[123]\\d{1,2}|[4][1234]\\d)\\b", x);//количество числовых констант со значением меньше «450»
			//task1("\\b([1-9]{1,}[0]?[1-9]{0,}|[1-9]{1,}([^0])\\2)\\b", x);//количество числовых констант, неделимые без остатка на 100
			//task1("\\b(\\d)\\d*\\1\\b", x);//количество числовых констант, в котором первая и последняя цифры одинаковые.
			//task2("\\ +","\t", x, wrightFile);//заменяет один или несколько  идущих подряд пробелов символом табуляции
			//task2("\\b(\\d+)(\\s|$)\\b", "$1\\0 ", x, wrightFile);
			//task2("\\b(\\d+)(,)(\\d)(\\d{0,})([0])\\b", "$1$2$3$4 ",  make(wrightFile), wrightFile);
			//task2("\\b(\\d+)(,)(\\d)\\b", "$1$3 ",  make(wrightFile), wrightFile);
			//task2("\\b(\\d+)(,)(\\d)(\\d{1,})\\b", "$1$3$2$4 ",  make(wrightFile), wrightFile);
		}
	}
