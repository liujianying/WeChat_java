package h.a.a;

import java.io.OutputStream;

public final class a {
    public int vIa;
    public byte[] vKZ;
    public int vLa = 0;
    public int vLb;
    public OutputStream vLc;

    public final void cKG() {
        cKH();
        this.vLc = null;
    }

    public final void cKH() {
        int i = this.vIa - this.vLb;
        if (i != 0) {
            this.vLc.write(this.vKZ, this.vLb, i);
            if (this.vIa >= this.vLa) {
                this.vIa = 0;
            }
            this.vLb = this.vIa;
        }
    }

    public final byte IG(int i) {
        int i2 = (this.vIa - i) - 1;
        if (i2 < 0) {
            i2 += this.vLa;
        }
        return this.vKZ[i2];
    }
}
