package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.bua;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class WXCustomSchemeEntryActivity$1 implements a {
    final /* synthetic */ WXCustomSchemeEntryActivity hee;

    WXCustomSchemeEntryActivity$1(WXCustomSchemeEntryActivity wXCustomSchemeEntryActivity) {
        this.hee = wXCustomSchemeEntryActivity;
    }

    public final void a(int i, int i2, String str, l lVar, boolean z) {
        x.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z)});
        if (!(lVar == null || i == 0 || i2 == 0 || !(lVar instanceof aa))) {
            bua Rw = ((aa) lVar).Rw();
            if (!(Rw == null || this.hee.isFinishing())) {
                s.makeText(this.hee, this.hee.getString(R.l.app_tip) + " : " + bi.oV(Rw.srt), 0).show();
            }
        }
        this.hee.finish();
    }
}
