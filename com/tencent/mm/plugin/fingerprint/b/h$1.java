package com.tencent.mm.plugin.fingerprint.b;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements a {
    final /* synthetic */ h jgH;

    h$1(h hVar) {
        this.jgH = hVar;
    }

    public final boolean handleMessage(Message message) {
        if (1 != message.what) {
            return false;
        }
        Object string = message.getData().getString("rsaKey");
        if (TextUtils.isEmpty(string)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + message.what + " rsaKey is null");
            ah.A(new 1(this));
        }
        this.jgH.jgF.a(new e(string), false, false);
        return true;
    }
}
