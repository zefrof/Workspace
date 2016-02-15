public class Test {
	public static void main(String[] args) {
		double [] a = {1.00, -.52, 22.71, 4.78, -2.00, 8};
		double b = a[0];
		int i = 0;
		for(i = 1; i < a.length; i++){
			b = Math.min(a[i], b);
		}
		System.out.printf("%.2f", b + i);
	}
}