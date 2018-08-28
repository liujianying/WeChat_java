package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.v.c;
import android.view.View;

class v$8 extends c {
    final /* synthetic */ v NZ;
    final /* synthetic */ v$a Og;
    final /* synthetic */ ai Oi;
    final /* synthetic */ View Oj;

    v$8(v vVar, v$a v_a, ai aiVar, View view) {
        this.NZ = vVar;
        this.Og = v_a;
        this.Oi = aiVar;
        this.Oj = view;
        super((byte) 0);
    }

    public final void p(View view) {
    }

    public final void q(View view) {
        this.Oi.a(null);
        z.d(this.Oj, 1.0f);
        z.b(this.Oj, 0.0f);
        z.c(this.Oj, 0.0f);
        this.NZ.k(this.Og.Ol);
        this.NZ.NX.remove(this.Og.Ol);
        this.NZ.eS();
    }
}
