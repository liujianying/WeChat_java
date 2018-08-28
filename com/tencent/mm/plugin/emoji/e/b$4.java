package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.cq;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.d.1;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class b$4 extends c<cq> {
    final /* synthetic */ b ifh;

    b$4(b bVar) {
        this.ifh = bVar;
        this.sFo = cq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        switch (((cq) bVar).bKc.state) {
            case 0:
                d aDL = d.aDL();
                au.HU();
                String Gg = com.tencent.mm.model.c.Gg();
                aDL.ifp = true;
                if (bi.oW(Gg)) {
                    x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "filepath is empty.");
                } else {
                    au.HU();
                    x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "need clean emoji file:%B", new Object[]{Boolean.valueOf(System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.DT().get(a.sPc, Long.valueOf(0))).longValue() >= 86400000)});
                    if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.DT().get(a.sPc, Long.valueOf(0))).longValue() >= 86400000) {
                        x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "startClean");
                        au.Em().H(new 1(aDL, Gg));
                    }
                }
                e aDM = e.aDM();
                if (aDM.isEnable()) {
                    if (!aDM.bgH) {
                        aDM.bgH = true;
                        au.HU();
                        if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.DT().get(a.sPd, Long.valueOf(0))).longValue() < 86400000) {
                            z = false;
                        }
                        if (!z) {
                            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "need no encrypt.");
                            break;
                        }
                        au.Em().H(new e.1(aDM));
                        break;
                    }
                    x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt process file is running.");
                    break;
                }
                x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt is disable.");
                break;
            case 1:
                d.aDL().ifp = false;
                e.aDM().bgH = false;
                break;
        }
        return false;
    }
}
