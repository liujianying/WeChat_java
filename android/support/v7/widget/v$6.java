package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.c;
import android.view.View;

class v$6 extends c {
    final /* synthetic */ v NZ;
    final /* synthetic */ t Oc;
    final /* synthetic */ ai Od;
    final /* synthetic */ int Oe;
    final /* synthetic */ int Of;

    v$6(v vVar, t tVar, int i, int i2, ai aiVar) {
        this.NZ = vVar;
        this.Oc = tVar;
        this.Oe = i;
        this.Of = i2;
        this.Od = aiVar;
        super((byte) 0);
    }

    public final void p(View view) {
        this.NZ.A(this.Oc);
    }

    public final void ar(View view) {
        if (this.Oe != 0) {
            z.b(view, 0.0f);
        }
        if (this.Of != 0) {
            z.c(view, 0.0f);
        }
    }

    public final void q(View view) {
        this.Od.a(null);
        this.NZ.y(this.Oc);
        this.NZ.NV.remove(this.Oc);
        this.NZ.eS();
    }
}
