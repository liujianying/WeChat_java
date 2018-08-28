package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class c$g implements a {
    private final String mjG = ".sysmsg.addcontact.type";
    private final String mjH = ".sysmsg.addcontact.username";
    private final String mjI = ".sysmsg.addcontact.encryptusername";
    final /* synthetic */ c mjy;

    c$g(c cVar) {
        this.mjy = cVar;
    }

    public final void a(d.a aVar) {
        e.i(aVar, "addMsgInfo");
        Map z = bl.z(ab.a(aVar.dIN.rcl), "sysmsg");
        if (z != null && e.i((String) z.get(this.mjG), "1")) {
            int i;
            b bVar;
            String str = (String) z.get(this.mjH);
            String str2 = (String) z.get(this.mjI);
            CharSequence charSequence = str;
            if (charSequence == null || b.f.a.U(charSequence)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                charSequence = str2;
                i = (charSequence == null || b.f.a.U(charSequence)) ? 1 : 0;
                if (i == 0) {
                    com.tencent.mm.storage.ab abVar = new com.tencent.mm.storage.ab();
                    abVar.setUsername(str);
                    abVar.dD(str2);
                    c.c(this.mjy, abVar);
                    bVar = c.mju;
                    x.d(c.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[]{abVar.getUsername(), abVar.wR()});
                    return;
                }
            }
            bVar = c.mju;
            x.e(c.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[]{r5});
        }
    }
}
