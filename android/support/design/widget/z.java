package android.support.design.widget;

import android.view.View;

final class z {
    private int jj;
    private int jk;
    int jl;
    int jm;
    private final View mView;

    public z(View view) {
        this.mView = view;
    }

    public final void aS() {
        this.jj = this.mView.getTop();
        this.jk = this.mView.getLeft();
        aT();
    }

    final void aT() {
        android.support.v4.view.z.j(this.mView, this.jl - (this.mView.getTop() - this.jj));
        android.support.v4.view.z.k(this.mView, this.jm - (this.mView.getLeft() - this.jk));
    }

    public final boolean p(int i) {
        if (this.jl == i) {
            return false;
        }
        this.jl = i;
        aT();
        return true;
    }
}
