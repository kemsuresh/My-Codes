package com.test.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<Integer> divBy5Filter = s -> { return s%5==0; };
		
		Predicate<String> contains_ds = s -> { return s.contains("ad"); };
		
		
		List<Integer> list = Arrays.asList(new Integer[] {2,3,4,5,6,7,8,15,10});
		List<String> list1 = Arrays.asList(new String[] {"ads","bds","bsd","ddad","tad"});
		List<String> list2 = Arrays.asList(new String[] {"1","2","3","4","5"});
		
		HashMap<Integer, String> students = new HashMap<Integer, String>();
		students.put(1,"a");
		students.put(2,"ab");
		students.put(3,"sa");
		students.put(4,"sb");
		students.put(5,"gg");
		
		Map<Object, Object> outMap = students.entrySet().stream().filter(entry -> entry.getValue().startsWith("s")).collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));
		
		List<Integer> out = list.stream().filter(divBy5Filter).collect(Collectors.toList());
		
		Integer out1 = list.stream().filter(divBy5Filter).findFirst().get();
		
		List<Integer> out2 = list.stream().filter(s -> s%5==0).map(s -> s*s).collect(Collectors.toList());
		
		List<String> out3 = list1.stream().filter(contains_ds).collect(Collectors.toList());
		
		Integer out111 = get(toPair(out1)); // Generics Sample
		
		
		List<String> out4 = list2.stream().limit(list2.size()%2==0 ? list2.size() : list2.size()-1).collect(Collectors.toList());
		
		
		
		// -----------------------------------------
		System.out.printf("Output %d = %s \n",1, out);
		System.out.printf("Output %d = %s \n",2, out1);
		System.out.printf("Output %d = %s \n",3, out2);
		System.out.printf("Output %d = %s \n",4, out3);
		System.out.printf("Output %d = %s \n",5, students);
		System.out.printf("Output %d = %s \n",5, outMap);
		System.out.printf("Output %d = %s \n",6, out111);
		System.out.printf("Output %d = %s \n",7, out4);
	}

	private static <A> Pair1<A, ?> toPair(A out1) {
		Pair1<A, ?> pair = new Pair1<>();
		
		pair.setA(out1);
		return pair;
	}
	
	public static <R, A> R get(Pair1<R,A> a) {
		
		return a.getA();
	}
	static class Pair2 extends Pair1<String,Integer>{
		
	}
	
	static class Pair1<A,B> {
		private A a;
		private B b;
		public A getA() {
			return a;
		}
		public B getB() {
			return b;
		}
		public void setA(A a) {
			this.a =a;
		}
		public void setB(B b) {
			this.b=b;
		}
	}

}
