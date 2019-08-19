package Problems.Top50.group00;


import Utility.IProblem;

public class N02_PrimeNumbers implements IProblem {
    private static final int N = 30;

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        for(int i = 0; i < N; i++) {
            System.out.println(i + ": " + IsPrime(i));
        }
    }

    public boolean IsPrime(int n) {
        if(n < 3) {
            return false;
        }
        if(n % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n) + 1;
        for(int i = 3; i < sqrt; i+=2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}