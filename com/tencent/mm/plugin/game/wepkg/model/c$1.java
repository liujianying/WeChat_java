package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Bundle;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements c<Bundle> {
    final /* synthetic */ kk keT;
    final /* synthetic */ c keU;

    c$1(c cVar, kk kkVar) {
        this.keU = cVar;
        this.keT = kkVar;
    }

    public final /* synthetic */ void at(Object obj) {
        Bundle bundle = (Bundle) obj;
        x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload complete. total time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - c.access$100())});
        if (bundle != null) {
            c.a(this.keU, this.keT);
        }
    }
}
