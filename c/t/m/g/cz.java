package c.t.m.g;

public class cz {
    private static cz e = null;
    float a = 0.0f;
    float b = 0.0f;
    float c = 100.0f;
    boolean d = false;

    public static cz a() {
        if (e == null) {
            synchronized (cz.class) {
                if (e == null) {
                    e = new cz();
                }
            }
        }
        return e;
    }

    private cz() {
    }
}
