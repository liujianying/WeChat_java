package com.tencent.mm.plugin.soter;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.c.d;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.sdk.platformtools.x;

public class PluginSoter extends f implements c, a {
    private d onr = null;
    private boolean ons = false;

    public String name() {
        return "plugin-soter";
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            x.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[]{gVar.dox});
            this.ons = true;
            x.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
            this.onr = new d();
            safeAddListener(this.onr);
        }
    }

    public void uninstalled() {
        super.uninstalled();
        safeRemoveListener(this.onr);
    }

    private void safeAddListener(com.tencent.mm.sdk.b.c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.b.a.sFg.d(cVar)) {
            x.w("MicroMsg.PluginSoter", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.b.a.sFg.b(cVar);
        }
    }

    private void safeRemoveListener(com.tencent.mm.sdk.b.c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.PluginSoter", "alvinluo listener is null");
        } else {
            com.tencent.mm.sdk.b.a.sFg.c(cVar);
        }
    }

    public void onAccountInitialized(e.c cVar) {
        x.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[]{Boolean.valueOf(this.ons)});
        if (this.ons) {
            h.bFi();
            b.a(false, false, null);
        }
    }

    public void onAccountRelease() {
        x.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    }
}
