package command;

import java.util.ArrayList;
import java.util.List;

/***************************** Command Interface *********************************/
interface Command {
    void execute(Double x, Double y);
}

/***************************** Invoker  ****************************************/
class Calculator {
    private List<Command> history = new ArrayList<>();
    public void showHistory() {
        StringBuffer buffer = new StringBuffer();
        for(Command cmd : history){buffer.append(cmd.getClass().getSimpleName()+",");}
        System.out.println(buffer.deleteCharAt(buffer.length() - 1));
    }

    public void calculate(Double x, Double y, Command cmd){
        this.history.add(cmd);
        cmd.execute(x,y);
    }
}

/***************************** Various Commands **********************************/
class Plus implements Command {
    @Override
    public void execute(Double x, Double y) {
        System.out.println( x + y);
    }
}
class Sub implements Command {
    @Override
    public void execute(Double x, Double y) {
        System.out.println( x - y);
    }
}
class Multiply implements Command {
    @Override
    public void execute(Double x, Double y) {
        System.out.println( x * y);
    }
}
class Divide implements Command {
    @Override
    public void execute(Double x, Double y) {
        if(y ==0) throw new IllegalArgumentException("requirement failed: Cannot Divide By Zero !");

        System.out.println( x / y);
    }
}
/***************************** End of Commands *********************************/


public class CommandPattern {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(2.0,3.0,new Plus());
        calculator.calculate(2.0,3.0,new Sub());
        calculator.calculate(2.0,3.0,new Multiply());
        calculator.calculate(2.0,3.0,new Divide());

        calculator.showHistory();
    }
}
