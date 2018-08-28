package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends d implements Runnable {
    private final String ffA;
    private final c ffB = new 1(this);
    private final c ffC = new 2(this);
    final c ffD = new c() {
        public final void enter() {
            super.enter();
            x.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
            ac.cv(true);
            g.Eh().dpP.a(1168, new 1(this));
        }
    };
    private final int ffz;

    public j(int i, String str) {
        super("LibIncrementalTestCase", Looper.getMainLooper());
        this.ffz = i;
        this.ffA = str;
    }

    public final void run() {
        a(this.ffB);
        a(this.ffC);
        a(this.ffD);
        b(this.ffB);
        start();
    }

    protected final void abD() {
        super.abD();
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
    }
}
