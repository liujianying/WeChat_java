package com.tencent.mm.plugin.fts;

import com.tencent.mm.plugin.fts.PluginFTS.8;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;

class PluginFTS$8$1 extends a {
    String jpN = "";
    final /* synthetic */ 8 jpO;

    PluginFTS$8$1(8 8) {
        this.jpO = 8;
    }

    public final boolean execute() {
        this.jpN = w.fD(ad.getContext());
        PluginFTS.access$200(this.jpO.jpM).t(-3, (long) this.jpN.hashCode());
        return true;
    }

    public final String toString() {
        return "LanguageUpdate(\"" + this.jpN + "\")";
    }
}
