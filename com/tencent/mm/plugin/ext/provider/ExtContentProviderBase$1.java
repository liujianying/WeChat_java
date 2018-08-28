package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.x;

class ExtContentProviderBase$1 implements Runnable {
    final /* synthetic */ b heb;
    final /* synthetic */ ExtContentProviderBase iJR;

    ExtContentProviderBase$1(ExtContentProviderBase extContentProviderBase, b bVar) {
        this.iJR = extContentProviderBase;
        this.heb = bVar;
    }

    public final void run() {
        try {
            if (au.HX()) {
                au.DF().a(new bg(new 1(this)), 0);
            }
        } catch (Exception e) {
            x.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
            this.heb.countDown();
        }
    }
}
