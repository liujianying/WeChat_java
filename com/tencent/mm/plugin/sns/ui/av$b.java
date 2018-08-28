package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.sns.model.af;

public class av$b implements a {
    int mPosition;
    x ocm = null;

    public av$b(x xVar, int i) {
        this.ocm = xVar;
        this.mPosition = i;
    }

    public final void x(String str, boolean z) {
        if (z) {
            g.Ek();
            if (g.Eg().Dx()) {
                af.aRu().post(new Runnable() {
                    public final void run() {
                        if (av$b.this.ocm.bCc() != null) {
                            ((aw) av$b.this.ocm.bCc()).GN(av$b.this.mPosition);
                        }
                        av$b.this.ocm.notifyDataSetChanged();
                    }
                });
            }
        }
    }
}
