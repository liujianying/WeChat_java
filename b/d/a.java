package b.d;

import java.util.Iterator;

public class a implements b.c.b.a.a, Iterable<Integer> {
    public static final a vGL = new a((byte) 0);
    private final int fHo = 1;
    final int first;
    final int vGK;

    public /* synthetic */ Iterator iterator() {
        return (Iterator) ((b.a.a) new b(this.first, this.vGK, this.fHo));
    }

    public a(int i, int i2) {
        this.first = i;
        this.vGK = i2 - b.b.a.IA(b.b.a.IA(i2) - b.b.a.IA(i));
    }

    public boolean isEmpty() {
        return this.fHo > 0 ? this.first > this.vGK : this.first < this.vGK;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.first == ((a) obj).first && this.vGK == ((a) obj).vGK && this.fHo == ((a) obj).fHo));
    }

    public int hashCode() {
        return isEmpty() ? -1 : (((this.first * 31) + this.vGK) * 31) + this.fHo;
    }

    public String toString() {
        return this.fHo > 0 ? this.first + ".." + this.vGK + " step " + this.fHo : this.first + " downTo " + this.vGK + " step " + (-this.fHo);
    }
}
