package android.support.v7.widget;

final class ag {
    int Tu = 0;
    int Tv = 0;
    int Tw = Integer.MIN_VALUE;
    int Tx = 0;
    int Ty = 0;
    boolean Tz = false;
    boolean dx = false;
    int tK = Integer.MIN_VALUE;

    ag() {
    }

    public final void aj(int i, int i2) {
        this.Tw = i;
        this.tK = i2;
        this.Tz = true;
        if (this.dx) {
            if (i2 != Integer.MIN_VALUE) {
                this.Tu = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.Tv = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.Tu = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.Tv = i2;
        }
    }
}
