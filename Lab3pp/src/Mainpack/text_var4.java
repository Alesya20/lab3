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
			String readFile = "H:\\промыш. прог\\lab3\\s.txt";
			String wrightFile = "H:\\промыш. прог\\lab3\\file.txt";
			String x = make(readFile);
			//task2("(|)(\\w)(|)(-{0,1})(\\d+)(|)(\\+\\d+)(|)(\\w+)(@{0,1})(@)(\\w+)(.{0,1})(.)(\\w+)", "$1$2$3$5$6$7$8$10$11$12$14$15", x, wrightFile);
			//task2("(\\w+)(\\|)(-)(\\d+)(\\|)(\\+?)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\|)(\\w+)(@*)(@)(\\w+)", "$1$2$4$5$6$8\\ ($10$12$14)\\ $16$18$20-$22-$24-$26-$28$29$30$32$33", x, wrightFile);
			task2("([A-Z][a-z]*)(\\ ?)([A-Z][a-z]*)(\\|)(-)(\\d+)(\\|)(\\+?)(\\s*)(\\d)(\\s*)(\\(?)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\(?)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\|)(\\w+)(@*)(@)(\\w+)", "$1\\ $3$4$6$7$8$10\\ ($14$16$18)\\ $22$24$26-$28-$30-$32-$34$35$36$38$39", x, wrightFile);
		}
		
	}
