package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ag;
import com.google.android.gms.c.h;

public class c extends ag<c> {
    public final q aHe;
    public boolean aIm;

    public c(q qVar) {
        super(qVar.ns(), qVar.aFC);
        this.aHe = qVar;
    }

    protected final void a(ae aeVar) {
        h hVar = (h) aeVar.e(h.class);
        if (TextUtils.isEmpty(hVar.aGl)) {
            hVar.aGl = this.aHe.nw().nP();
        }
        if (this.aIm && TextUtils.isEmpty(hVar.aWp)) {
            q qVar = this.aHe;
            q.a(qVar.aGe);
            a aVar = qVar.aGe;
            hVar.aWp = aVar.mG();
            hVar.aWq = aVar.mF();
        }
    }

    public final ae oj() {
        ae ql = qm().ql();
        q qVar = this.aHe;
        q.a(qVar.aGf);
        ql.b(qVar.aGf.nG());
        ql.b(this.aHe.aGg.og());
        qo();
        return ql;
    }
}
