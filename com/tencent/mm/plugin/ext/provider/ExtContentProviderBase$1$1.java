package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase.1;
import com.tencent.mm.sdk.platformtools.x;

class ExtContentProviderBase$1$1 implements a {
    final /* synthetic */ 1 iJS;

    ExtContentProviderBase$1$1(1 1) {
        this.iJS = 1;
    }

    public final void a(e eVar) {
        x.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
        this.iJS.heb.countDown();
    }
}
