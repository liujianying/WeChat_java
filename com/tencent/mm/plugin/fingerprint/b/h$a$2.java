package com.tencent.mm.plugin.fingerprint.b;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.fingerprint.b.h.a;
import com.tencent.mm.sdk.platformtools.x;

class h$a$2 implements Runnable {
    final /* synthetic */ String jgB;
    final /* synthetic */ a jgJ;

    h$a$2(a aVar, String str) {
        this.jgJ = aVar;
        this.jgB = str;
    }

    public final void run() {
        x.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
        Message obtainMessage = this.jgJ.jgH.jgz.obtainMessage();
        obtainMessage.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString("rsaKey", this.jgB);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }
}
