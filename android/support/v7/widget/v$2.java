package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.7;
import android.support.v7.widget.v.8;
import android.support.v7.widget.v.a;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

class v$2 implements Runnable {
    final /* synthetic */ v NZ;
    final /* synthetic */ ArrayList Oa;

    v$2(v vVar, ArrayList arrayList) {
        this.NZ = vVar;
        this.Oa = arrayList;
    }

    public final void run() {
        Iterator it = this.Oa.iterator();
        while (it.hasNext()) {
            ai h;
            a aVar = (a) it.next();
            v vVar = this.NZ;
            t tVar = aVar.Ok;
            View view = tVar == null ? null : tVar.SU;
            t tVar2 = aVar.Ol;
            View view2 = tVar2 != null ? tVar2.SU : null;
            if (view != null) {
                h = z.U(view).h(vVar.RY);
                vVar.NX.add(aVar.Ok);
                h.u((float) (aVar.Oo - aVar.Om));
                h.v((float) (aVar.Op - aVar.On));
                h.t(0.0f).a(new 7(vVar, aVar, h)).start();
            }
            if (view2 != null) {
                h = z.U(view2);
                vVar.NX.add(aVar.Ol);
                h.u(0.0f).v(0.0f).h(vVar.RY).t(1.0f).a(new 8(vVar, aVar, h, view2)).start();
            }
        }
        this.Oa.clear();
        this.NZ.NT.remove(this.Oa);
    }
}
