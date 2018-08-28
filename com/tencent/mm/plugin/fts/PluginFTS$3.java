package com.tencent.mm.plugin.fts;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class PluginFTS$3 implements e {
    final /* synthetic */ PluginFTS jpM;

    PluginFTS$3(PluginFTS pluginFTS) {
        this.jpM = pluginFTS;
    }

    public final void aPT() {
        g.Ek();
        int intValue = ((Integer) g.Ei().DT().get(a.sXV, Integer.valueOf(3))).intValue();
        x.e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", new Object[]{Integer.valueOf(intValue)});
        if (intValue > 0) {
            intValue--;
            g.Ek();
            g.Ei().DT().a(a.sXV, Integer.valueOf(intValue));
            PluginFTS.access$300(this.jpM);
            PluginFTS.access$400(this.jpM);
            PluginFTS.access$200(this.jpM).close();
            d.aPR();
            PluginFTS.access$500(this.jpM).a(-131072, new PluginFTS$b(this.jpM, (byte) 0));
        }
    }
}
