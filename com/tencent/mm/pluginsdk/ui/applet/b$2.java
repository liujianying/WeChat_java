package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.storage.ab;

class b$2 implements a {
    final /* synthetic */ ab eLI;
    final /* synthetic */ b qIl;

    b$2(b bVar, ab abVar) {
        this.qIl = bVar;
        this.eLI = abVar;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            this.qIl.P(this.eLI);
        } else {
            this.qIl.gW(0);
        }
        this.qIl.qIi.dismiss();
    }
}
