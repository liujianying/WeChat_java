package android.support.v7.widget.a;

import android.support.v7.widget.RecyclerView.d;

class a$5 implements d {
    final /* synthetic */ a Yc;

    a$5(a aVar) {
        this.Yc = aVar;
    }

    public final int af(int i, int i2) {
        if (this.Yc.XX == null) {
            return i2;
        }
        int i3 = this.Yc.XY;
        if (i3 == -1) {
            i3 = this.Yc.Sa.indexOfChild(this.Yc.XX);
            this.Yc.XY = i3;
        }
        if (i2 == i - 1) {
            return i3;
        }
        return i2 >= i3 ? i2 + 1 : i2;
    }
}
