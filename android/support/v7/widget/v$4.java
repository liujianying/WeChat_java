package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.c;
import android.view.View;

class v$4 extends c {
    final /* synthetic */ v NZ;
    final /* synthetic */ t Oc;
    final /* synthetic */ ai Od;

    v$4(v vVar, t tVar, ai aiVar) {
        this.NZ = vVar;
        this.Oc = tVar;
        this.Od = aiVar;
        super((byte) 0);
    }

    public final void p(View view) {
        this.NZ.z(this.Oc);
    }

    public final void q(View view) {
        this.Od.a(null);
        z.d(view, 1.0f);
        this.NZ.k(this.Oc);
        this.NZ.NW.remove(this.Oc);
        this.NZ.eS();
    }
}
