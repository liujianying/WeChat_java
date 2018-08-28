package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.f.a;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.sdk.platformtools.x;

class f$a$1 implements Runnable {
    final /* synthetic */ String jgB;
    final /* synthetic */ a jgC;

    f$a$1(a aVar, String str) {
        this.jgC = aVar;
        this.jgB = str;
    }

    public final void run() {
        if (TextUtils.isEmpty(this.jgB)) {
            x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
        }
        e eVar = new e(this.jgB);
        g.Ek();
        g.Eh().dpP.a(eVar, 0);
    }
}
