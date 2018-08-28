package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.g;

class r$2 implements a {
    final /* synthetic */ r tQd;

    r$2(r rVar) {
        this.tQd = rVar;
    }

    public final boolean vD() {
        if (this.tQd.bAG != null) {
            c.NM();
            boolean NN = c.NN();
            int lastVisiblePosition = this.tQd.bAG.getLastVisiblePosition() - this.tQd.bAG.getHeaderViewsCount();
            g gVar = (g) this.tQd.bAG.O(g.class);
            int max = Math.max(this.tQd.bAG.getFirstVisiblePosition() - this.tQd.bAG.getHeaderViewsCount(), 0);
            int max2 = Math.max(Math.min(lastVisiblePosition, gVar.getCount()), 0);
            x.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + max + " last: " + max2);
            if (max2 < max) {
                x.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
                r.a(this.tQd).J(1000, 1000);
            } else {
                o.Pg().dTC = true;
                for (int i = max; i <= max2; i++) {
                    bd ES = gVar.ES(i);
                    if (ES != null && ES.field_isSend == 0 && ES.ckA()) {
                        e bq = o.Pf().bq(ES.field_msgSvrId);
                        if (!(bq.OM() || ES.cGL == 2)) {
                            if (ES.cGL != 1) {
                                if (NN) {
                                    c.NM();
                                    if (!c.o(ES)) {
                                    }
                                }
                            }
                            com.tencent.mm.modelcdntran.g.ND().dPa.add("image_" + ES.field_msgId);
                            o.Pg().a(bq.dTK, ES.field_msgId, 0, Integer.valueOf(i), R.g.chat_img_template, this.tQd);
                        }
                    }
                }
                o.Pg().OL();
            }
        }
        return false;
    }
}
