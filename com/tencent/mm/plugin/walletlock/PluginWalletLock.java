package com.tencent.mm.plugin.walletlock;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.walletlock.a.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.b.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class PluginWalletLock extends f implements c, a {
    private com.tencent.mm.plugin.walletlock.b.f pGx = null;

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.soter.a.a.class);
    }

    public void configure(g gVar) {
        if (gVar.ES()) {
            x.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
            com.tencent.mm.kernel.g.a(b.class, new e(new com.tencent.mm.plugin.walletlock.b.e()));
            t.a(1, new a(this, (byte) 0));
        }
    }

    public void execute(g gVar) {
    }

    public String name() {
        return "plugin-wallet-lock";
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        String value;
        x.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
        this.pGx = new com.tencent.mm.plugin.walletlock.b.f();
        com.tencent.mm.plugin.walletlock.b.f fVar = this.pGx;
        if (!com.tencent.mm.sdk.b.a.sFg.d(fVar.pIo)) {
            com.tencent.mm.sdk.b.a.sFg.b(fVar.pIo);
        }
        if (!com.tencent.mm.sdk.b.a.sFg.d(fVar.pIp)) {
            com.tencent.mm.sdk.b.a.sFg.b(fVar.pIp);
        }
        if (!com.tencent.mm.sdk.b.a.sFg.d(fVar.pIr)) {
            com.tencent.mm.sdk.b.a.sFg.b(fVar.pIr);
        }
        try {
            value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("PatternLockTimeInterval");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletLockInitTask", e, "", new Object[0]);
            value = null;
        }
        if (bi.oW(value)) {
            x.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
            com.tencent.mm.plugin.walletlock.gesture.a.a.pGU = 300;
        } else {
            int i = bi.getInt(value, 0);
            if (i >= 0) {
                x.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[]{Integer.valueOf(i)}));
                com.tencent.mm.plugin.walletlock.gesture.a.a.pGU = i;
            } else {
                x.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
                com.tencent.mm.plugin.walletlock.gesture.a.a.pGU = 300;
            }
        }
        ((b) com.tencent.mm.kernel.g.l(b.class)).init();
    }

    public void onAccountRelease() {
        x.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
        if (this.pGx != null) {
            com.tencent.mm.plugin.walletlock.b.f fVar = this.pGx;
            if (com.tencent.mm.sdk.b.a.sFg.d(fVar.pIo)) {
                com.tencent.mm.sdk.b.a.sFg.c(fVar.pIo);
            }
            if (com.tencent.mm.sdk.b.a.sFg.d(fVar.pIp)) {
                com.tencent.mm.sdk.b.a.sFg.c(fVar.pIp);
            }
            if (com.tencent.mm.sdk.b.a.sFg.d(fVar.pIr)) {
                com.tencent.mm.sdk.b.a.sFg.c(fVar.pIr);
            }
            i iVar = i.pIx;
            if (iVar.pIB != null) {
                iVar.pIB.clear();
            }
        }
    }
}
