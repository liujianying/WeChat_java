package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.masssend.ui.c.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;

class MassSendHistoryUI$1 implements e {
    final /* synthetic */ MassSendHistoryUI lbg;

    MassSendHistoryUI$1(MassSendHistoryUI massSendHistoryUI) {
        this.lbg = massSendHistoryUI;
    }

    public final String Gm(String str) {
        au.HU();
        if (c.isSDCardAvailable()) {
            String oV = bi.oV(str);
            if (!MassSendHistoryUI.a(this.lbg).isPlaying() || !oV.equals(MassSendHistoryUI.b(this.lbg).laO)) {
                return !MassSendHistoryUI.a(this.lbg, oV) ? "" : oV;
            } else {
                MassSendHistoryUI.bcx();
                this.lbg.releaseWakeLock();
                MassSendHistoryUI.a(this.lbg).aJ(false);
                return "";
            }
        }
        s.gH(this.lbg);
        return "";
    }
}
