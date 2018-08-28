package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.5;
import java.util.ArrayList;
import java.util.Iterator;

class v$3 implements Runnable {
    final /* synthetic */ v NZ;
    final /* synthetic */ ArrayList Ob;

    v$3(v vVar, ArrayList arrayList) {
        this.NZ = vVar;
        this.Ob = arrayList;
    }

    public final void run() {
        Iterator it = this.Ob.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            v vVar = this.NZ;
            ai U = z.U(tVar.SU);
            vVar.NU.add(tVar);
            U.t(1.0f).h(vVar.RV).a(new 5(vVar, tVar, U)).start();
        }
        this.Ob.clear();
        this.NZ.NR.remove(this.Ob);
    }
}
