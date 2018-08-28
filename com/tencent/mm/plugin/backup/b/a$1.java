package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.lan_cs.Server.a;
import com.tencent.mm.plugin.backup.f.b;
import java.io.IOException;

class a$1 implements a {
    final /* synthetic */ a gRT;

    public a$1(a aVar) {
        this.gRT = aVar;
    }

    public final void gO(int i) {
        if (a.a(this.gRT) == 1) {
            b.mK(i);
        }
    }

    public final void onRecv(String str, int i, byte[] bArr) {
        a.a(this.gRT, str);
        a.a(this.gRT, i);
        try {
            a.a(this.gRT, bArr);
        } catch (IOException e) {
            a.a(this.gRT, 10006, ("server readErr:" + e.toString()).getBytes());
        }
    }

    public final void Fh() {
        a.a(this.gRT, 10011, "listen server onDisconnect".getBytes());
    }

    public final void onConnect(String str, int i) {
        a.a(this.gRT, str);
        a.a(this.gRT, i);
    }
}
