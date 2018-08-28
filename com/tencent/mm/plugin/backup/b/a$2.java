package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.lan_cs.Client.a;
import java.io.IOException;

class a$2 implements a {
    final /* synthetic */ a gRT;

    a$2(a aVar) {
        this.gRT = aVar;
    }

    public final void onRecv(String str, int i, byte[] bArr) {
        a.a(this.gRT, str);
        a.a(this.gRT, i);
        try {
            a.a(this.gRT, bArr);
        } catch (IOException e) {
            a.a(this.gRT, 10006, ("client readErr:" + e.toString()).getBytes());
        }
    }

    public final void Fh() {
        a.a(this.gRT, 10011, "client onDisconnect".getBytes());
    }
}
