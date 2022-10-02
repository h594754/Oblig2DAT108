package oppgave1;

import java.util.function.BiFunction;

public class Oppg1b {
	public static void main(String[] args) {;
		BiFunction<Integer, Integer, Integer> summer = (t, u) -> (t + u);	
		BiFunction<Integer, Integer, Integer> storst = (t, u) -> Math.max(t, u);
		BiFunction<Integer, Integer, Integer> differanse = (t, u) -> Math.abs(t - u);
		
		int sum = beregn(5, 2, summer);
		int storre = beregn(200, 7, storst);
		int diff = beregn(50, 20, differanse);
		System.out.println(sum);
		System.out.println(storre);
		System.out.println(diff);
	}
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> function) {
		return function.apply(a, b);
	}
}
