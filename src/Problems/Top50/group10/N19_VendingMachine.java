package Problems.Top50.group10;

import Utility.IProblem;
import Problems.Top50.group10.vendingMachine.VendingMachineImpl;

/**
 * This one of the popular OOAD (object oriented analysis and design) question from Java Interviews.
 * You will be given 3 hours to design and code a vending machine satisfying some of the business
 * requirements. You also need to write unit tests to prove your code satisfy those requirements.
 * You can see this article for more object oriented analysis questions:
 * https://www.java67.com/2016/07/top-5-object-oriented-design-interview-questions.html
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N19_VendingMachine implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        VendingMachineImpl vm = new VendingMachineImpl();
        vm.run();
    };
}