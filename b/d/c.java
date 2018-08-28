package b.d;

public final class c extends a {
    private static final c vGP = new c(1, 0);
    public static final a vGQ = new a((byte) 0);

    public c(int i, int i2) {
        super(i, i2);
    }

    public final boolean isEmpty() {
        return this.first > this.vGK;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (this.first == ((c) obj).first && this.vGK == ((c) obj).vGK));
    }

    public final int hashCode() {
        return isEmpty() ? -1 : (this.first * 31) + this.vGK;
    }

    public final String toString() {
        return this.first + ".." + this.vGK;
    }
}
