package com.tencent.mm.plugin.nfc_open.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class NfcWebViewUI$2 implements Runnable {
    final /* synthetic */ NfcWebViewUI lFy;
    final /* synthetic */ String lFz;

    NfcWebViewUI$2(NfcWebViewUI nfcWebViewUI, String str) {
        this.lFy = nfcWebViewUI;
        this.lFz = str;
    }

    public final void run() {
        h.mEJ.h(12794, new Object[]{this.lFz, Integer.valueOf(0)});
        x.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.lFz);
    }
}
