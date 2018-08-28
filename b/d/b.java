package b.d;

import b.a.a;
import java.util.NoSuchElementException;

public final class b extends a {
    private final int fHo;
    private final int vGM;
    private boolean vGN;
    private int vGO;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.fHo = i3;
        this.vGM = i2;
        if (this.fHo > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.vGN = z;
        if (!this.vGN) {
            i = this.vGM;
        }
        this.vGO = i;
    }

    public final boolean hasNext() {
        return this.vGN;
    }

    public final int nextInt() {
        int i = this.vGO;
        if (i != this.vGM) {
            this.vGO += this.fHo;
        } else if (this.vGN) {
            this.vGN = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
