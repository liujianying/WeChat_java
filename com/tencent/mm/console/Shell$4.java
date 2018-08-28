package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.sdk.platformtools.x;

class Shell$4 implements a {
    Shell$4() {
    }

    public final void n(Intent intent) {
        int intExtra = intent.getIntExtra("level", 0);
        x.w("MicroMsg.Shell", "kiro set Log.level=%d", new Object[]{Integer.valueOf(x.getLogLevel())});
        x.Da(intExtra);
    }
}
