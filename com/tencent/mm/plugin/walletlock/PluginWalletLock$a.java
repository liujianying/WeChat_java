package com.tencent.mm.plugin.walletlock;

import com.tencent.mm.bk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.sdk.platformtools.x;

class PluginWalletLock$a implements r<auy> {
    final /* synthetic */ PluginWalletLock pGy;

    private PluginWalletLock$a(PluginWalletLock pluginWalletLock) {
        this.pGy = pluginWalletLock;
    }

    /* synthetic */ PluginWalletLock$a(PluginWalletLock pluginWalletLock, byte b) {
        this(pluginWalletLock);
    }

    public final /* synthetic */ void e(a aVar) {
        x.i("MicroMsg.PluginWalletLock", "alvinluo afterSyncDoCmd");
        ((b) g.l(b.class)).init();
    }

    public final /* bridge */ /* synthetic */ void f(a aVar) {
    }
}
