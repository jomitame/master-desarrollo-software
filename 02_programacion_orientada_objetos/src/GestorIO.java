import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GestorIO {

    public int inInt() {
        int input = 0;
        try{
            input = Integer.parseInt(this.inString());
        } catch (Exception e) {
            this.getOut();
        }
        return input;
    }

    public float inFloat() {
        float input = 0;
        try{
            input = Float.parseFloat(this.inString());
        } catch (Exception e) {
            this.getOut();
        }
        return input;
    }

    public double inDouble() {
        double input = 0.0;
        try{
            input = Double.parseDouble(this.inString());
        } catch (Exception e) {
            this.getOut();
        }
        return input;
    }

    public long inLong() {
        long input = 0;
        try{
            input = Long.parseLong(this.inString());
        } catch (Exception e) {
            this.getOut();
        }
        return input;
    }

    public byte inByte() {
        byte input = 0;
        try{
            input = Byte.parseByte(this.inString());
        } catch (Exception e) {
            this.getOut();
        }
        return input;
    }

    public short inShort() {
        short input = 0;
        try{
            input = Short.parseShort(this.inString());
        } catch (Exception e) {
            this.getOut();
        }
        return input;
    }

    public char inChar() {
        char character = ' ';
        String input = this.inString();
        if (input.length() > 1) {
            this.getOut();
        } else {
            character = input.charAt(0);
        }

        return character;
    }

    public boolean inBoolean() {
        boolean logicInput = true;
        String input = this.inString();
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            logicInput = Boolean.valueOf(input).booleanValue();
        } else {
            this.getOut();
        }
        return logicInput;
    }

    public String inString() {
        String input = null;
        try{
            input = b.readLine();
        } catch (Exception e) {
            this. getOut();
        }
        return input;
    }

    public void out (int out) {
        System.out.print(out);
    }

    public void out (float out) {
        System.out.print(out);
    }

    public void out (double out) {
        System.out.print(out);
    }

    public void out (long out) {
        System.out.print(out);
    }

    public void out (byte out) {
        System.out.print(out);
    }

    public void out (short out) {
        System.out.print(out);
    }

    public void out (char out) {
        System.out.print(out);
    }

    public void out (boolean out) {
        System.out.print(out);
    }

    public void out (String out) {
        System.out.print(out);
    }

    private void getOut() {
        System.out.println("Input/Output Error");
        System.exit(0);
    }

    private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        GestorIO gestor = new GestorIO();

        System.out.println("Integer");
        gestor.out(gestor.inInt());
        System.out.println();
        System.out.println("Character");
        gestor.out(gestor.inChar());
        System.out.println();
        System.out.println("Real");
        gestor.out(gestor.inFloat());
        System.out.println();
        System.out.println("Boolean");
        gestor.out(gestor.inBoolean());
    }
}