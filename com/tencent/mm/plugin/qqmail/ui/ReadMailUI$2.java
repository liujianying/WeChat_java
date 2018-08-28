package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.util.Map;

class ReadMailUI$2 implements Runnable {
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ ReadMailUI miD;
    final /* synthetic */ b miE;

    ReadMailUI$2(ReadMailUI readMailUI, b bVar, Runnable runnable) {
        this.miD = readMailUI;
        this.miE = bVar;
        this.bzs = runnable;
    }

    public final void run() {
        Map map = null;
        if (!this.miD.isFinishing()) {
            try {
                map = (Map) new ReadMailProxy(ReadMailUI.l(this.miD), null).REMOTE_CALL("getCookie", new Object[0]);
            } catch (Exception e) {
                x.w("MicroMsg.ReadMailUI", "getCookie, ex = %s", new Object[]{e.getMessage()});
            }
            if (map != null) {
                this.miE.setCookie(p.bor(), "skey=" + ((String) map.get("skey")));
                this.miE.setCookie(p.bor(), "uin=" + ((String) map.get("uin")));
                this.miE.setCookie(p.bor(), "svrid=" + ((String) map.get("svrid")));
                c.cIk();
                c.sync();
            }
            if (!this.miD.isFinishing() && ReadMailUI.g(this.miD) != null) {
                this.bzs.run();
            }
        }
    }
}
