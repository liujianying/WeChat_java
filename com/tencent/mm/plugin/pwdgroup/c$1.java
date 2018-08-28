package com.tencent.mm.plugin.pwdgroup;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class c$1 implements a {
    private Bitmap byb = null;
    private f<String, WeakReference<Bitmap>> lZt;
    final /* synthetic */ c lZu;

    c$1(c cVar) {
        this.lZu = cVar;
        try {
            this.byb = b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bp.a.getDensity(null));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", e, "", new Object[0]);
        }
        this.lZt = new f(15);
    }

    public final void a(i iVar) {
        if (iVar instanceof c) {
            q.Kp().a((c) iVar);
        }
    }

    public final Bitmap cJ(String str) {
        WeakReference weakReference = (WeakReference) this.lZt.get(str);
        if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled() && weakReference.get() == this.byb) {
            return (Bitmap) weakReference.get();
        }
        Bitmap a = com.tencent.mm.aa.c.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            return this.byb;
        }
        this.lZt.m(str, new WeakReference(a));
        return a;
    }

    public final Bitmap uM() {
        return this.byb;
    }

    public final Bitmap cK(String str) {
        return null;
    }

    public final Bitmap b(String str, int i, int i2, int i3) {
        return null;
    }
}
