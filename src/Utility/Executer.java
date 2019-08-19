package Utility;

public class Executer {
    public static void execute(IProblem p) {
        long start = System.currentTimeMillis();
        p.Execute();
        long end = System.currentTimeMillis();
        long dif = end - start;
        System.out.println("Executed " + p.GetName() + " in " + dif + "ms");
    }
}