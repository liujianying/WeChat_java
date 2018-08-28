package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$e {
    b RT = null;
    private ArrayList<a> RU = new ArrayList();
    public long RV = 120;
    public long RW = 120;
    public long RX = 250;
    public long RY = 250;

    interface b {
        void l(t tVar);
    }

    public abstract boolean a(t tVar, t tVar2, c cVar, c cVar2);

    public abstract void d(t tVar);

    public abstract boolean d(t tVar, c cVar, c cVar2);

    public abstract boolean e(t tVar, c cVar, c cVar2);

    public abstract void eR();

    public abstract void eT();

    public abstract boolean f(t tVar, c cVar, c cVar2);

    public abstract boolean isRunning();

    public c a(q qVar, t tVar, int i, List<Object> list) {
        return new c().b(tVar, 0);
    }

    static int j(t tVar) {
        int x = t.x(tVar) & 14;
        if (tVar.gs()) {
            return 4;
        }
        if ((x & 4) != 0) {
            return x;
        }
        int i = tVar.SV;
        int gm = tVar.gm();
        if (i == -1 || gm == -1 || i == gm) {
            return x;
        }
        return x | 2048;
    }

    public final void k(t tVar) {
        l(tVar);
        if (this.RT != null) {
            this.RT.l(tVar);
        }
    }

    public void l(t tVar) {
    }

    public final boolean a(a aVar) {
        boolean isRunning = isRunning();
        if (aVar != null) {
            if (isRunning) {
                this.RU.add(aVar);
            } else {
                aVar.ga();
            }
        }
        return isRunning;
    }

    public boolean m(t tVar) {
        return true;
    }

    public boolean a(t tVar, List<Object> list) {
        return m(tVar);
    }

    public final void fZ() {
        int size = this.RU.size();
        for (int i = 0; i < size; i++) {
            ((a) this.RU.get(i)).ga();
        }
        this.RU.clear();
    }
}
