package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.sdk.platformtools.x;

class Shell$11 implements a {
    Shell$11() {
    }

    public final void n(Intent intent) {
        ig igVar = new ig();
        igVar.bRH.bRM = intent.getExtras().getString("path", "/data/local/tmp/test.apk");
        x.w("MicroMsg.Shell", "hotpatch test [%s]", new Object[]{igVar.bRH.bRM});
        com.tencent.mm.sdk.b.a.sFg.m(igVar);
    }
}
