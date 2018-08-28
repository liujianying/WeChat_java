package com.tencent.mm.sandbox.updater;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sandbox.b$a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$3 implements b$a {
    final /* synthetic */ c sDP;

    c$3(c cVar) {
        this.sDP = cVar;
    }

    public final void co(int i, int i2) {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + i + ", offset=" + i2);
        c.b(this.sDP).co(i, i2);
    }

    public final void a(int i, int i2, bhp bhp) {
        if (i != 0) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=" + i);
            if (i == -2) {
                new File(this.sDP.beJ()).delete();
            }
            c.e(this.sDP);
            this.sDP.a(c.b(this.sDP));
            return;
        }
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try {
            if (e.cm(this.sDP.beJ()) < c.f(this.sDP)) {
                x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
                this.sDP.a(c.b(this.sDP));
            } else if (c.g(this.sDP)) {
                if (c.h(this.sDP).equalsIgnoreCase(g.cu(this.sDP.beJ()))) {
                    c.a(this.sDP, bhp);
                    return;
                }
                x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
                new File(this.sDP.beJ()).delete();
                c.b(this.sDP).a(2, -1, bhp);
            } else if (c.i(this.sDP).equalsIgnoreCase(g.cu(this.sDP.beJ()))) {
                e.i(c.sDh, c.j(this.sDP) + ".temp", c.k(this.sDP) + ".apk");
                c.b(this.sDP).a(200, 0, bhp);
            } else {
                x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
                new File(this.sDP.beJ()).delete();
                c.b(this.sDP).a(-1, -1, bhp);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            c.b(this.sDP).a(-1, -1, bhp);
        }
    }

    public final void fV(long j) {
        c.b(this.sDP).fV(j);
    }

    public final void fW(long j) {
        c.b(this.sDP).fW(j);
    }
}
