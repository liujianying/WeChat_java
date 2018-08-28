package android.support.b;

class a$e {
    public final long lU;
    public final long lV;

    /* synthetic */ a$e(long j, long j2, byte b) {
        this(j, j2);
    }

    private a$e(long j, long j2) {
        if (j2 == 0) {
            this.lU = 0;
            this.lV = 1;
            return;
        }
        this.lU = j;
        this.lV = j2;
    }

    public final String toString() {
        return this.lU + "/" + this.lV;
    }
}
