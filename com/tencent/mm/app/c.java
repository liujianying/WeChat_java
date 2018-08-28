package com.tencent.mm.app;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.aa.f;
import com.tencent.mm.aa.q;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ad;

final class c implements a {
    private Bitmap byb;
    f byc;

    public c() {
        this.byb = null;
        this.byb = com.tencent.mm.compatible.g.a.decodeResource(ad.getContext().getResources(), R.k.default_avatar);
    }

    public final void a(i iVar) {
        if (iVar instanceof com.tencent.mm.aa.f.c) {
            q.Kp().a((com.tencent.mm.aa.f.c) iVar);
        }
    }

    public final Bitmap cJ(String str) {
        return com.tencent.mm.aa.c.a(str, false, -1);
    }

    public final Bitmap uM() {
        return this.byb;
    }

    public final Bitmap cK(String str) {
        if (this.byc == null) {
            this.byc = q.Kp();
        }
        return f.jS(str);
    }

    public final Bitmap b(String str, int i, int i2, int i3) {
        return com.tencent.mm.aa.c.c(str, i, i2, i3);
    }
}
