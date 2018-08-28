package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class NearLifeCreatePoiUI$5 implements a {
    final /* synthetic */ NearLifeCreatePoiUI lEr;

    NearLifeCreatePoiUI$5(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.lEr = nearLifeCreatePoiUI;
    }

    public final void b(Addr addr) {
        CharSequence charSequence = bi.oV(addr.dRJ) + bi.oV(addr.dRL);
        CharSequence charSequence2 = bi.oV(addr.dRM) + bi.oV(addr.dRN);
        x.d("MicroMsg.NearLifeCreatePoiUI", "get address:" + charSequence);
        if (bi.oW(NearLifeCreatePoiUI.e(this.lEr).getText().toString())) {
            NearLifeCreatePoiUI.e(this.lEr).setText(charSequence);
        }
        if (bi.oW(NearLifeCreatePoiUI.f(this.lEr).getText().toString()) && !bi.oW(charSequence2)) {
            NearLifeCreatePoiUI.f(this.lEr).setText(charSequence2);
        }
        NearLifeCreatePoiUI.a(this.lEr, addr);
    }
}
