package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$7 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ int kPA;
    final /* synthetic */ int kPB;
    final /* synthetic */ b qBO;
    final /* synthetic */ int qBY;

    b$7(b bVar, int i, int i2, String str, int i3) {
        this.qBO = bVar;
        this.kPA = i;
        this.kPB = i2;
        this.ewx = str;
        this.qBY = i3;
    }

    public final void run() {
        b bVar = this.qBO;
        int i = this.kPA;
        int i2 = this.kPB;
        String str = this.ewx;
        int i3 = this.qBY;
        s Tn = a.ccH().Tn(i.ex(i, i2));
        if (Tn != null) {
            boolean z = Tn.field_fileUpdated;
            Tn.field_fileUpdated = false;
            a.ccH().g(Tn);
            if (i3 != bi.getInt(Tn.field_fileVersion, 0)) {
                return;
            }
            if (a.ccH().handler == null) {
                x.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            } else {
                a.ccH().handler.post(new b$8(bVar, i, i2, str, i3, z));
            }
        }
    }
}
