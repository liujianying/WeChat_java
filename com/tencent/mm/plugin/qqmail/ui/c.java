package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.model.au;

public final class c implements e {
    private static long mhO = 0;
    private Activity bOb;
    private a mhP;

    public static abstract class a {
        public abstract void boA();

        public abstract void boz();
    }

    public c(Activity activity) {
        au.DF().a(138, this);
        this.bOb = activity;
    }

    public final void a(a aVar) {
        this.mhP = aVar;
        ju juVar = new ju();
        juVar.bTI.bOb = this.bOb;
        juVar.bTI.bTK = new 1(this, juVar);
        com.tencent.mm.sdk.b.a.sFg.a(juVar, Looper.myLooper());
    }

    public final void release() {
        au.DF().b(138, this);
    }

    protected final void finalize() {
        release();
        super.finalize();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (this.mhP != null) {
                this.mhP.boz();
                this.mhP = null;
            }
        } else if (this.mhP != null) {
            this.mhP.boA();
            this.mhP = null;
        }
        mhO = System.currentTimeMillis();
    }
}
