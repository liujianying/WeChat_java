package com.tencent.mm.plugin.fts;

import com.tencent.mm.g.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class PluginFTS$6 extends c<d> {
    final /* synthetic */ PluginFTS jpM;

    PluginFTS$6(PluginFTS pluginFTS) {
        this.jpM = pluginFTS;
        this.sFo = d.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        d dVar = (d) bVar;
        g access$500 = PluginFTS.access$500(this.jpM);
        boolean z = dVar.bGd.bGe;
        if (access$500.jpf != null) {
            access$500.jpf.ff(z);
        }
        PluginFTS.access$1302(this.jpM, !dVar.bGd.bGe);
        return false;
    }
}
