package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.6;
import android.support.v7.widget.v.b;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

class v$1 implements Runnable {
    final /* synthetic */ ArrayList NY;
    final /* synthetic */ v NZ;

    v$1(v vVar, ArrayList arrayList) {
        this.NZ = vVar;
        this.NY = arrayList;
    }

    public final void run() {
        Iterator it = this.NY.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            v vVar = this.NZ;
            t tVar = bVar.Oq;
            int i = bVar.Om;
            int i2 = bVar.On;
            int i3 = bVar.Oo;
            int i4 = bVar.Op;
            View view = tVar.SU;
            i = i3 - i;
            i2 = i4 - i2;
            if (i != 0) {
                z.U(view).u(0.0f);
            }
            if (i2 != 0) {
                z.U(view).v(0.0f);
            }
            ai U = z.U(view);
            vVar.NV.add(tVar);
            U.h(vVar.RX).a(new 6(vVar, tVar, i, i2, U)).start();
        }
        this.NY.clear();
        this.NZ.NS.remove(this.NY);
    }
}
