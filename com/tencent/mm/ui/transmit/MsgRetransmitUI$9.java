package com.tencent.mm.ui.transmit;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class MsgRetransmitUI$9 implements a {
    final /* synthetic */ MsgRetransmitUI uDL;
    final /* synthetic */ List uDP;

    MsgRetransmitUI$9(MsgRetransmitUI msgRetransmitUI, List list) {
        this.uDL = msgRetransmitUI;
        this.uDP = list;
    }

    public final void a(a.a aVar) {
        if (this.uDL.fileName.equals(aVar.fileName)) {
            r nW = t.nW(aVar.fileName);
            if (nW == null || !nW.Tp()) {
                x.i("MicroMsg.MsgRetransmitUI", "oreh sendVideo fialed , fileName:%s", new Object[]{aVar.fileName});
            } else {
                x.i("MicroMsg.MsgRetransmitUI", "oreh sendVideo suc  fileName:%s", new Object[]{aVar.fileName});
            }
            o.Ta().a(this);
            MsgRetransmitUI.a(this.uDL, this.uDP);
        }
    }
}
