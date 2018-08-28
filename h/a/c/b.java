package h.a.c;

import java.io.InputStream;

public final class b {
    public int spd;
    public int vLI;
    public InputStream vLJ;

    public final int e(short[] sArr, int i) {
        short s = sArr[i];
        int i2 = (this.vLI >>> 11) * s;
        if ((this.spd ^ Integer.MIN_VALUE) < (Integer.MIN_VALUE ^ i2)) {
            this.vLI = i2;
            sArr[i] = (short) (s + ((2048 - s) >>> 5));
            if ((this.vLI & -16777216) == 0) {
                this.spd = (this.spd << 8) | this.vLJ.read();
                this.vLI <<= 8;
            }
            return 0;
        }
        this.vLI -= i2;
        this.spd -= i2;
        sArr[i] = (short) (s - (s >>> 5));
        if ((this.vLI & -16777216) == 0) {
            this.spd = (this.spd << 8) | this.vLJ.read();
            this.vLI <<= 8;
        }
        return 1;
    }

    public static void c(short[] sArr) {
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) 1024;
        }
    }
}
