package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.ImageView;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import java.util.HashMap;

public final class b implements a {
    public HashMap<Long, Integer> hre = new HashMap();
    private i hrf;

    public b(i iVar) {
        this.hrf = iVar;
    }

    public static void a(String str, ImageView imageView) {
        com.tencent.mm.ak.a.a Pj = o.Pj();
        c.a aVar = new c.a();
        aVar.dXR = com.tencent.mm.plugin.brandservice.b.a.chatting_item_biz_default_bg;
        aVar.dXD = 1;
        Pj.a(str, imageView, aVar.Pt());
    }

    public static String f(e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        String str2 = eVar.dTL;
        if (eVar.ON()) {
            String d = o.Pf().d(eVar);
            if (d != null) {
                d = o.Pf().o(d, "", "");
                if (com.tencent.mm.a.e.cn(d)) {
                    x.i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
                    str = d;
                }
            }
        }
        if (str == null) {
            return o.Pf().o(str2, "", "");
        }
        return str;
    }

    public static e b(q qVar) {
        e eVar = null;
        if (qVar.field_msgId > 0) {
            eVar = o.Pf().br(qVar.field_msgId);
        }
        if ((eVar == null || eVar.dTK <= 0) && qVar.field_msgSvrId > 0) {
            return o.Pf().bq(qVar.field_msgSvrId);
        }
        return eVar;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        if (i3 == 0 && i4 == 0) {
            j(j2, 1);
            this.hrf.avj();
            return;
        }
        x.i("MicroMsg.BizTimeLineImgMsgHandler", "onImgTaskEnd errType %d, errCode %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i4 == -5103059) {
            j(j2, 2);
        } else {
            j(j2, 3);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    public final int cb(long j) {
        if (this.hre.containsKey(Long.valueOf(j))) {
            return ((Integer) this.hre.get(Long.valueOf(j))).intValue();
        }
        return 0;
    }

    public final void j(long j, int i) {
        this.hre.put(Long.valueOf(j), Integer.valueOf(i));
    }
}
