package com.tencent.mm.plugin.fts;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class PluginFTS$7 implements e {
    final /* synthetic */ PluginFTS jpM;

    PluginFTS$7(PluginFTS pluginFTS) {
        this.jpM = pluginFTS;
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.Ek();
        if (bi.f((Integer) g.Ei().DT().get(15, null)) != 0) {
            g.DF().b(138, PluginFTS.access$1400(this.jpM));
            PluginFTS.access$1502(this.jpM, true);
            x.i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
            PluginFTS.access$1200(this.jpM);
        }
    }
}
