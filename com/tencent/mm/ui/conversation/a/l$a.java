package com.tencent.mm.ui.conversation.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.List;

final class l$a implements Runnable {
    WeakReference<l> ust;

    private l$a() {
    }

    /* synthetic */ l$a(byte b) {
        this();
    }

    public final void run() {
        List Tr = o.Ta().Tr();
        List Ts = o.Ta().Ts();
        l lVar = (l) this.ust.get();
        if (lVar == null) {
            x.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
            return;
        }
        x.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[]{Integer.valueOf(lVar.mContainer.getChildCount()), Integer.valueOf(Tr.size()), Integer.valueOf(Ts.size())});
        if (lVar.mContainer.getChildCount() != 0 || !Tr.isEmpty() || !Ts.isEmpty()) {
            Runnable l_c = new l$c();
            l_c.ust = new WeakReference(this.ust.get());
            l_c.usC = Tr;
            l_c.usD = Ts;
            ah.A(l_c);
        }
    }
}
