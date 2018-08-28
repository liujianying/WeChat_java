package com.tencent.mm.av;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements a {
    final /* synthetic */ b eel;

    b$4(b bVar) {
        this.eel = bVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
        b.QD();
        this.eel.Qx();
        return false;
    }
}
