package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public abstract class RecyclerView$p {
    h QG;
    RecyclerView Sa;
    public int Sv = -1;
    boolean Sw;
    boolean Sx;
    View Sy;
    private final a Sz = new a();

    protected abstract void a(int i, int i2, a aVar);

    protected abstract void a(View view, a aVar);

    protected abstract void onStop();

    protected final void stop() {
        if (this.Sx) {
            onStop();
            this.Sa.RB.Sv = -1;
            this.Sy = null;
            this.Sv = -1;
            this.Sw = false;
            this.Sx = false;
            h.a(this.QG, this);
            this.QG = null;
            this.Sa = null;
        }
    }
}
