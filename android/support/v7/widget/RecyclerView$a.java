package android.support.v7.widget;

import android.support.v4.os.e;
import android.support.v7.widget.RecyclerView.t;
import android.view.ViewGroup;
import java.util.List;

public abstract class RecyclerView$a<VH extends t> {
    public final RecyclerView$b RR = new RecyclerView$b();
    public boolean RS = false;

    public abstract VH a(ViewGroup viewGroup, int i);

    public abstract void a(VH vh, int i);

    public abstract int getItemCount();

    public void a(VH vh, int i, List<Object> list) {
        a((t) vh, i);
    }

    public final VH d(ViewGroup viewGroup, int i) {
        e.beginSection("RV CreateView");
        VH a = a(viewGroup, i);
        a.SX = i;
        e.endSection();
        return a;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public final void fX() {
        if (this.RR.fY()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.RS = true;
    }

    public long getItemId(int i) {
        return -1;
    }

    public void a(VH vh) {
    }

    public final void a(RecyclerView$c recyclerView$c) {
        this.RR.registerObserver(recyclerView$c);
    }

    public final void b(RecyclerView$c recyclerView$c) {
        this.RR.unregisterObserver(recyclerView$c);
    }

    public final void bl(int i) {
        this.RR.X(i, 1);
    }

    public final void c(int i, Object obj) {
        this.RR.b(i, 1, obj);
    }

    public final void X(int i, int i2) {
        this.RR.X(i, i2);
    }

    public final void b(int i, int i2, Object obj) {
        this.RR.b(i, i2, obj);
    }

    public final void bm(int i) {
        this.RR.Z(i, 1);
    }

    public final void Y(int i, int i2) {
        this.RR.Y(i, i2);
    }

    public final void Z(int i, int i2) {
        this.RR.Z(i, i2);
    }

    public final void bn(int i) {
        this.RR.aa(i, 1);
    }

    public final void aa(int i, int i2) {
        this.RR.aa(i, i2);
    }
}
