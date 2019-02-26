// Katarina Sperduto
import java.util.*;


public class Project8 {
	static Scanner s;
	static Stack <Double> stack;

	public static void equation(){
		System.out.println("Please enter and expression in Postfix Notation ");
		String expression = s.nextLine();

		// for (int i = 0; i <expression.length() -1; i++){
			for (char ch: expression.toCharArray()){
					if(Character.isDigit(ch)){
						double num = (ch-'0');
						stack.add(num);
						// System.out.println(stack);
					}
					else{
						// System.out.println("not digit");
						// String opperand = String.valueOf(ch);
						if(ch == '+'){
							double top = stack.pop();
							double sum = (top + stack.pop());
							stack.add(sum);
							// System.out.println(stack);
						}
						else if(ch == '-'){
							double top = stack.pop();
							double difference = (top - stack.pop());
							stack.add(difference);
							// System.out.println(stack);
						}
						else if(ch == '*'){
							double top = stack.pop();
							double product = (top * stack.pop());
							stack.add(product);
							// System.out.println(stack);
						}
						else if(ch == '/'){
							double top = stack.pop();
							double ratio = (top / stack.pop());
							stack.add(ratio);
							// System.out.println(stack);
						}
					}
				}
				double total = stack.pop();
				System.out.println(total);
				System.out.println("Would you like to solve another equation? Please type yes or no");
				String yesNo = s.nextLine();
				if (yesNo.equals("yes")){
					equation();
				}
				else{

				}
			}

  public static void main(String [] args){
		s = new Scanner(System.in);
		stack = new Stack<Double>();
		equation();
	}
}
