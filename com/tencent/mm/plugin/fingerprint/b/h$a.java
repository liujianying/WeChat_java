package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class h$a implements o$a {
    final /* synthetic */ h jgH;

    private h$a(h hVar) {
        this.jgH = hVar;
    }

    /* synthetic */ h$a(h hVar, byte b) {
        this(hVar);
    }

    public final void tp(String str) {
        if (TextUtils.isEmpty(str)) {
            ah.A(new 1(this));
            x.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
            return;
        }
        ah.A(new 2(this, str));
    }
}
