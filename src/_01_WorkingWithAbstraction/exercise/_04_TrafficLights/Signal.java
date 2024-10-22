package _01_WorkingWithAbstraction.exercise._04_TrafficLights;

public enum Signal {
    RED,
    GREEN,
    YELLOW;

    public static void update(Signal[] signals){
        for (int i = 0; i < signals.length; i++) {
            switch (signals[i]) {
                case RED -> signals[i] = GREEN;
                case GREEN -> signals[i] = YELLOW;
                case YELLOW -> signals[i] = RED;
            }
        }
    }
    public static void print(Signal[] signals){
        for (Signal signal : signals) {
            System.out.print(signal + " ");
        }
        System.out.println();
    }
}
