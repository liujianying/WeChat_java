package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ag;

class b$1 extends a {
    final /* synthetic */ b owc;

    b$1(b bVar) {
        this.owc = bVar;
    }

    public final void ev(int i) {
        if (i == 4) {
            new ag(Looper.getMainLooper()).post(new 1(this));
        }
    }
}
