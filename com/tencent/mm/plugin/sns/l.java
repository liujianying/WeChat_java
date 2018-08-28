package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

public final class l implements i {
    public final void b(String str, d dVar) {
        p.b(str, dVar);
    }

    public final String a(String str, PString pString) {
        return p.a(str, pString);
    }

    public final void a(String str, b bVar, bd bdVar) {
        if (bdVar.aQm()) {
            a gp = a.gp(bdVar.field_content);
            if (gp != null && !bi.oW(gp.bZN)) {
                bVar.p(str, gp.bZN);
            }
        }
    }

    public final void Z(bd bdVar) {
        String C = p.C(bdVar);
        if (C != null) {
            byte[] decode = Base64.decode(C, 0);
            bqw bqw = new bqw();
            try {
                bqw.aG(decode);
                if (bqw.soW != null) {
                    Object obj;
                    if (bdVar.field_talker.endsWith("@chatroom")) {
                        obj = p.a.ekU.value;
                    } else {
                        String obj2 = p.a.ekT.value;
                    }
                    x.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[]{obj2, C, bqw.soW.soZ, bqw.soW.spa});
                    ((c) g.l(c.class)).h(13235, new Object[]{obj2, bqw.soW.soZ, bqw.soW.spa});
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            }
        }
    }

    public final String C(bd bdVar) {
        return p.C(bdVar);
    }
}
