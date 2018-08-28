package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.ah;

class MassSendMsgUI$15 implements Runnable {
    final /* synthetic */ int fXT;
    final /* synthetic */ String jfT;
    final /* synthetic */ MassSendMsgUI lbm;

    MassSendMsgUI$15(MassSendMsgUI massSendMsgUI, String str, int i) {
        this.lbm = massSendMsgUI;
        this.jfT = str;
        this.fXT = i;
    }

    public final void run() {
        VideoTransPara NQ = d.NP().NQ();
        aso aso = new aso();
        aso.rUP = true;
        if (l.a(this.jfT, NQ, aso, new 1(this))) {
            l.b(this.jfT, NQ, aso, new 2(this));
        }
        ah.A(new 3(this));
    }
}
