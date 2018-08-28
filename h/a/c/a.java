package h.a.c;

public final class a {
    public short[] vLG;
    public int vLH;

    public a(int i) {
        this.vLH = i;
        this.vLG = new short[(1 << i)];
    }

    public final int a(b bVar) {
        int i = 1;
        for (int i2 = this.vLH; i2 != 0; i2--) {
            i = bVar.e(this.vLG, i) + (i << 1);
        }
        return i - (1 << this.vLH);
    }
}
