package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.sdk.platformtools.al.a;

class WXRTEditText$3 implements a {
    final /* synthetic */ WXRTEditText qrh;

    WXRTEditText$3(WXRTEditText wXRTEditText) {
        this.qrh = wXRTEditText;
    }

    public final boolean vD() {
        if (WXRTEditText.m(this.qrh) != null && WXRTEditText.m(this.qrh).getType() == 1) {
            int i = WXRTEditText.m(this.qrh).qrR;
            WXRTEditText.n(this.qrh);
            this.qrh.ae(i, false);
        }
        return true;
    }
}
