package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.bua;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class WXBizEntryActivity$5 implements a {
    final /* synthetic */ WXBizEntryActivity hdL;

    WXBizEntryActivity$5(WXBizEntryActivity wXBizEntryActivity) {
        this.hdL = wXBizEntryActivity;
    }

    public final void a(int i, int i2, String str, l lVar, boolean z) {
        x.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z)});
        if (!(lVar == null || i == 0 || i2 == 0 || !(lVar instanceof aa))) {
            bua Rw = ((aa) lVar).Rw();
            if (!(Rw == null || this.hdL.isFinishing())) {
                s.makeText(this.hdL, this.hdL.getString(R.l.app_tip) + " : " + bi.oV(Rw.srt), 0).show();
            }
        }
        this.hdL.finish();
    }
}
