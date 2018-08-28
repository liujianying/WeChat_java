package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;

class JSAPIUploadLogHelperUI$1 implements a {
    final /* synthetic */ String dMs;
    final /* synthetic */ int esz;
    final /* synthetic */ JSAPIUploadLogHelperUI tkg;

    JSAPIUploadLogHelperUI$1(JSAPIUploadLogHelperUI jSAPIUploadLogHelperUI, String str, int i) {
        this.tkg = jSAPIUploadLogHelperUI;
        this.dMs = str;
        this.esz = i;
    }

    public final void a(e eVar) {
        synchronized (JSAPIUploadLogHelperUI.CO()) {
            JSAPIUploadLogHelperUI.ba(true);
        }
        au.DF().a(1, "", 0, false);
        x.chR();
        au.DF().a(2, this.dMs, this.esz, au.HX());
    }
}
