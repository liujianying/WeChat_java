package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class c {
    public WXRTEditText qrX = null;
    public WXRTEditText qrY = null;
    public WXRTEditText qrZ = null;

    public c(WXRTEditText wXRTEditText) {
        this.qrX = wXRTEditText;
    }

    public c(WXRTEditText wXRTEditText, WXRTEditText wXRTEditText2) {
        this.qrY = wXRTEditText;
        this.qrZ = wXRTEditText2;
    }
}
