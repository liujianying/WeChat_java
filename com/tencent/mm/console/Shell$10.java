package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class Shell$10 implements a {
    Shell$10() {
    }

    public final void n(Intent intent) {
        af.exS = intent.getIntExtra("flag", 0);
        x.w("MicroMsg.Shell", "dkwt shell [%d]", new Object[]{Integer.valueOf(af.exS)});
    }
}
