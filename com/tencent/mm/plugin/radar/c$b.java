package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.graphics.Bitmap;
import b.c.b.e;
import com.tencent.mm.a.f;
import com.tencent.mm.aa.q;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.lang.ref.WeakReference;

public final class c$b implements a {
    private Bitmap byb;
    private final f<String, WeakReference<Bitmap>> lZt = new f(15);
    private Bitmap mjm;

    c$b() {
        try {
            Context context = ad.getContext();
            e.h(context, "MMApplicationContext.getContext()");
            this.byb = b.a(context.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bp.a.getDensity(null));
            Bitmap bitmap = this.byb;
            Bitmap bitmap2 = this.byb;
            if (bitmap2 == null) {
                e.cJM();
            }
            this.mjm = c.a(bitmap, false, (float) (bitmap2.getWidth() / 2));
        } catch (IOException e) {
            c.a aVar = c.mjl;
            x.printErrStackTrace(c.access$getTAG$cp(), e, "", new Object[0]);
        }
    }

    public final void a(i iVar) {
        e.i(iVar, "drawable");
        if (iVar instanceof com.tencent.mm.aa.f.c) {
            q.Kp().a((com.tencent.mm.aa.f.c) iVar);
        }
    }

    public final Bitmap cJ(String str) {
        e.i(str, "tag");
        WeakReference weakReference = (WeakReference) this.lZt.get(str);
        if (!(weakReference == null || weakReference.get() == null)) {
            Object obj = weakReference.get();
            if (obj == null) {
                throw new b.i("null cannot be cast to non-null type android.graphics.Bitmap");
            } else if (!((Bitmap) obj).isRecycled() && (e.i((Bitmap) weakReference.get(), this.byb) ^ 1) == 0) {
                return (Bitmap) weakReference.get();
            }
        }
        Bitmap jM = com.tencent.mm.aa.c.jM(str);
        if (jM == null || jM.isRecycled()) {
            return this.mjm;
        }
        jM = c.a(jM, false, (float) (jM.getWidth() / 2));
        this.lZt.m(str, new WeakReference(jM));
        return jM;
    }

    public final Bitmap uM() {
        return this.byb;
    }

    public final Bitmap cK(String str) {
        e.i(str, "tag");
        return null;
    }

    public final Bitmap b(String str, int i, int i2, int i3) {
        e.i(str, "tag");
        return null;
    }
}
