package com.tencent.mm.plugin.translate;

import com.tencent.mm.g.a.rv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.translate.a.1;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class a$1$1 implements a {
    final /* synthetic */ int bFr;
    final /* synthetic */ c oEm;
    final /* synthetic */ 1 oEn;

    a$1$1(1 1, int i, c cVar) {
        this.oEn = 1;
        this.bFr = i;
        this.oEm = cVar;
    }

    public final boolean Ks() {
        int i = this.bFr != 0 ? this.bFr : this.oEm.ret;
        rv rvVar = new rv();
        rvVar.ccL.ret = i;
        rvVar.ccL.ccF = this.oEm.ccF;
        rvVar.ccL.id = this.oEm.id;
        rvVar.ccL.ccM = this.oEm.ccM;
        rvVar.ccL.type = this.oEm.type;
        rvVar.ccL.bhd = this.oEm.bhd;
        rvVar.ccL.cbd = this.oEm.cbd;
        com.tencent.mm.sdk.b.a.sFg.m(rvVar);
        return false;
    }

    public final boolean Kr() {
        x.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[]{this.oEm.id});
        if (this.bFr != 0) {
            x.e("MicroMsg.SubCoreTranslate", "translate error");
        } else if (this.oEm.ret != 0) {
            x.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[]{Integer.valueOf(this.oEm.ret)});
        } else if (bi.oW(this.oEm.ccM)) {
            x.e("MicroMsg.SubCoreTranslate", "translate return null");
        } else if (this.oEm.type == 0 || this.oEm.type == 1) {
            x.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
            c cVar = this.oEm;
            au.HU();
            bd dW = com.tencent.mm.model.c.FT().dW(bi.WV(cVar.id));
            dW.es(bi.oU(cVar.ccM));
            dW.field_transBrandWording = bi.oU(bi.oV(cVar.cbd));
            dW.cGs = true;
            dW.cGM = cVar.cGM;
            dW.cpN = true;
            if (cVar.oEv == 1) {
                if (dW.cmt()) {
                    dW.eC(dW.cqa | 1024);
                }
            } else if (dW.cmt()) {
                dW.eC(dW.cqa & -1025);
            }
            ((i) g.l(i.class)).bcY().a(dW.field_msgId, dW);
        }
        return true;
    }
}
