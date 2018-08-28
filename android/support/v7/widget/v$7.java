package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.v.c;
import android.view.View;

class v$7 extends c {
    final /* synthetic */ v NZ;
    final /* synthetic */ v$a Og;
    final /* synthetic */ ai Oh;

    v$7(v vVar, v$a v_a, ai aiVar) {
        this.NZ = vVar;
        this.Og = v_a;
        this.Oh = aiVar;
        super((byte) 0);
    }

    public final void p(View view) {
    }

    public final void q(View view) {
        this.Oh.a(null);
        z.d(view, 1.0f);
        z.b(view, 0.0f);
        z.c(view, 0.0f);
        this.NZ.k(this.Og.Ok);
        this.NZ.NX.remove(this.Og.Ok);
        this.NZ.eS();
    }
}
