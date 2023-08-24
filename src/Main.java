import ui.ConversionMachine;

import javax.swing.*;

import static Enums.MachineState.OFF;

public class Main {
    public static void main(String[] args) {
        ConversionMachine conversionMachine = new ConversionMachine();

        while (conversionMachine.state != OFF) {
            conversionMachine.machineStart();
        }

        JOptionPane.showMessageDialog(null, "Thanks for using our application");
    }
}
