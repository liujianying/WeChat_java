package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class l extends b implements a {
    ViewGroup mContainer;
    Map<String, Long> usr = new HashMap();
    Map<Long, b> uss = new HashMap();

    public l(Context context) {
        super(context);
        o.Ta().a(this, Looper.getMainLooper());
        this.mContainer = (ViewGroup) this.view;
    }

    public final int getLayoutId() {
        return R.i.mass_send_sight_banner;
    }

    public final void destroy() {
        o.Ta().a(this);
    }

    private void anw() {
        x.i("MicroMsg.MassSightBanner", "call update status");
        a aVar = new a((byte) 0);
        aVar.ust = new WeakReference(this);
        au.Em().H(aVar);
    }

    public final void a(a.a aVar) {
        String str = aVar.fileName;
        Long l = (Long) this.usr.get(str);
        if (l == null) {
            x.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[]{str});
            if (bi.aG(str, "").startsWith("DELETE_")) {
                anw();
                return;
            }
            return;
        }
        b bVar = (b) this.uss.get(l);
        if (bVar == null) {
            x.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[]{l});
            return;
        }
        r nW = t.nW(str);
        if (nW == null) {
            x.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[]{str, l});
        } else if (nW.status == 199) {
            x.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[]{str, l});
            anw();
        } else {
            c.a(bVar, nW);
        }
    }
}
