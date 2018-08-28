package com.tencent.mm.plugin.fts;

import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;

class PluginFTS$10 extends a {
    final /* synthetic */ PluginFTS jpM;
    String jpP = w.fD(ad.getContext());
    boolean jpQ = false;

    PluginFTS$10(PluginFTS pluginFTS) {
        this.jpM = pluginFTS;
    }

    public final boolean execute() {
        this.jpQ = ((int) ((n) g.n(n.class)).getFTSIndexDB().s(-3, 0)) != this.jpP.hashCode();
        if (this.jpQ) {
            com.tencent.mm.sdk.b.a.sFg.m(new se());
        }
        return true;
    }

    public final String afC() {
        return String.format("{changed: %b}", new Object[]{Boolean.valueOf(this.jpQ)});
    }

    public final String getName() {
        return "CheckLanguageUpdate";
    }
}
