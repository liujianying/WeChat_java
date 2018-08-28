package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s$a$a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import java.io.IOException;
import java.util.HashMap;

public final class a implements e, com.tencent.mm.modelvideo.s.a {
    private static int qlV = 1048576;
    private static int qlW = 26214400;
    private bf qlX = new bf();
    private HashMap<String, bd> qlY = new HashMap();

    static /* synthetic */ void a(a aVar, long j) {
        bg bgVar = new bg();
        bgVar.bJC = j;
        bgVar.sHf = bi.VE();
        aVar.qlX.tcm.add(bgVar);
        aVar.bYE();
        aVar.bYD();
    }

    static /* synthetic */ void b(a aVar, long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aVar.qlX.tcm.size()) {
                bg bgVar = (bg) aVar.qlX.tcm.get(i2);
                if (bgVar.bJC == j) {
                    aVar.qlX.tcm.remove(bgVar);
                    aVar.bYE();
                    return;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public a() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        byte[] f = com.tencent.mm.a.e.f(stringBuilder.append(g.Ei().cachePath).append("syncmsgid.ini").toString(), 0, -1);
        if (!bi.bC(f)) {
            try {
                this.qlX.aG(f);
            } catch (Exception e) {
                x.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
            }
        }
        o.Ta().a(this, Looper.getMainLooper());
        g.DF().a(221, this);
    }

    public final void fF(final long j) {
        au.HU();
        if (((Boolean) c.DT().get(com.tencent.mm.storage.aa.a.sVp, Boolean.valueOf(true))).booleanValue()) {
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    a.a(a.this, j);
                }
            });
        } else {
            x.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
        }
    }

    public final void fG(long j) {
        new ag(Looper.getMainLooper()).post(new 2(this, j));
    }

    public final void bYD() {
        new ag(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                a.a(a.this);
            }
        });
    }

    private void bYE() {
        try {
            byte[] toByteArray = this.qlX.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            com.tencent.mm.a.e.b(stringBuilder.append(g.Ei().cachePath).append("syncmsgid.ini").toString(), toByteArray, toByteArray.length);
        } catch (IOException e) {
            x.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
        }
    }

    public final void a(s$a$a s_a_a) {
        bd bdVar = (bd) this.qlY.get(s_a_a.fileName);
        if (bdVar != null) {
            r nW = t.nW(bdVar.field_imgPath);
            if (nW == null) {
                return;
            }
            if (bdVar.cmu() || nW.status == 199) {
                x.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[]{Long.valueOf(bdVar.field_msgId), Integer.valueOf(nW.status)});
                fG(bdVar.field_msgId);
                this.qlY.remove(bdVar.field_imgPath);
            } else if (bdVar.field_status == 198) {
                this.qlY.remove(bdVar.field_imgPath);
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && (lVar instanceof ac)) {
            fG(((ac) lVar).bJC);
            x.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[]{Long.valueOf(r0)});
        }
    }
}
