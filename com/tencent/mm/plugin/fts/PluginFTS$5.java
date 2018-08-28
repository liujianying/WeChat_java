package com.tencent.mm.plugin.fts;

import com.tencent.mm.g.a.by;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class PluginFTS$5 extends c<by> {
    final /* synthetic */ PluginFTS jpM;

    PluginFTS$5(PluginFTS pluginFTS) {
        this.jpM = pluginFTS;
        this.sFo = by.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((by) bVar) instanceof by) {
            PluginFTS.access$1000(this.jpM).dead();
            PluginFTS.access$1102(this.jpM, true);
            x.i("MicroMsg.FTS.PluginFTS", "All account post reset");
            PluginFTS.access$1200(this.jpM);
        }
        return false;
    }
}
