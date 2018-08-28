package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class Shell$8 implements Shell$a {
    Shell$8() {
    }

    public final void n(Intent intent) {
        af.exp = intent.getStringExtra("errmsg");
        x.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", new Object[]{af.exp});
    }
}
