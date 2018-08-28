package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.f;

public final class a implements f {
    private final a CN;
    private boolean CO;
    private final int CP;
    private final int CQ;

    public interface a {
        void aD(int i);
    }

    public final void z(float f) {
        Math.min(1.0f, Math.max(0.0f, f));
    }

    public final void cE() {
        if (this.CO) {
            aD(this.CQ);
        }
    }

    public final void cF() {
        if (this.CO) {
            aD(this.CP);
        }
    }

    private void aD(int i) {
        this.CN.aD(i);
    }
}
