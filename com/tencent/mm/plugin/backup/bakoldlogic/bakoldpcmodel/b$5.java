package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class b$5 implements Runnable {
    final /* synthetic */ b gZs;

    b$5(b bVar) {
        this.gZs = bVar;
    }

    public final void run() {
        Looper.prepare();
        b.a(this.gZs, new ag());
        Looper.loop();
    }
}
