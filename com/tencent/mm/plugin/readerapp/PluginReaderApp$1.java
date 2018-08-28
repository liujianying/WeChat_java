package com.tencent.mm.plugin.readerapp;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;

class PluginReaderApp$1 implements Runnable {
    final /* synthetic */ PluginReaderApp mnp;

    PluginReaderApp$1(PluginReaderApp pluginReaderApp) {
        this.mnp = pluginReaderApp;
    }

    public final void run() {
        if (System.currentTimeMillis() - ((Long) g.Ei().DT().get(a.sZU, Long.valueOf(0))).longValue() >= 604800000) {
            g.Ek();
            if ((bi.f((Integer) g.Ei().DT().get(15, null)) != 0 ? 1 : null) != null) {
                PluginReaderApp.access$000(this.mnp);
            } else {
                g.DF().a(138, PluginReaderApp.access$100(this.mnp));
            }
        }
    }
}
