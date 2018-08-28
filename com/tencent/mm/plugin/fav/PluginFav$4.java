package com.tencent.mm.plugin.fav;

import com.tencent.mm.g.a.qv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class PluginFav$4 extends c<qv> {
    final /* synthetic */ PluginFav iVm;

    PluginFav$4(PluginFav pluginFav) {
        this.iVm = pluginFav;
        this.sFo = qv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.Fav.PluginFav", "runService");
        if (PluginFav.access$000(this.iVm) != null) {
            PluginFav.access$000(this.iVm).run();
        }
        if (PluginFav.access$100(this.iVm) != null) {
            PluginFav.access$100(this.iVm).run();
        }
        if (PluginFav.access$200(this.iVm) != null) {
            PluginFav.access$200(this.iVm).run();
        }
        if (PluginFav.access$300(this.iVm) != null) {
            PluginFav.access$300(this.iVm).run();
        }
        if (PluginFav.access$400(this.iVm) != null) {
            PluginFav.access$400(this.iVm).run();
        }
        return false;
    }
}
