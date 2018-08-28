package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class Shell$1 implements a {
    Shell$1() {
    }

    public final void n(Intent intent) {
        int intExtra = intent.getIntExtra("type", Integer.MAX_VALUE);
        int intExtra2 = intent.getIntExtra("error", 0);
        if (intExtra != Integer.MAX_VALUE && intExtra2 != 0) {
            x.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
            af.bt(intExtra, intExtra2);
        }
    }
}
