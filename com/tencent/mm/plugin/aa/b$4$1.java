package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.plugin.aa.b.4;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class b$4$1 implements a<Void, com.tencent.mm.ab.a.a<c>> {
    final /* synthetic */ bp ezA;
    final /* synthetic */ 4 ezB;

    b$4$1(4 4, bp bpVar) {
        this.ezB = 4;
        this.ezA = bpVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        x.i("MicroMsg.SubCoreAA", "close aa urge notify cgiback, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            x.i("MicroMsg.SubCoreAA", "close aa urge notify success");
            if (((c) aVar.dIv).hUm > 0 && !bi.oW(((c) aVar.dIv).hUn)) {
                Toast.makeText(ad.getContext(), ((c) aVar.dIv).hUn, 0).show();
                h.mEJ.a(407, 29, 1, false);
            } else if (((c) aVar.dIv).hUm == 0) {
                Toast.makeText(ad.getContext(), i.close_aa_notify_tips, 0).show();
                h.mEJ.a(407, 27, 1, false);
                if (!bi.oW(((c) aVar.dIv).qYe)) {
                    com.tencent.mm.plugin.aa.a.h.g(this.ezA.bJa.bIZ, ((c) aVar.dIv).qYe);
                }
            } else {
                x.i("MicroMsg.SubCoreAA", "illegal resp");
                h.mEJ.a(407, 29, 1, false);
            }
        } else {
            x.i("MicroMsg.SubCoreAA", "close aa urge notify failed");
            Toast.makeText(ad.getContext(), i.close_aa_notify_fail_tips, 1).show();
            h.mEJ.a(407, 28, 1, false);
        }
        return uQG;
    }
}
