class Test {
   public static void main (String[] args) {
      try {
         System.out.println("Welcome to Java");
         return;
      } finally {
         System.out.println("The finally clause is executed");
      }
   }
}