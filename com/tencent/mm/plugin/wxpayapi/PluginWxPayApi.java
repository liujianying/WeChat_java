package com.tencent.mm.plugin.wxpayapi;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.wxpayapi.a.a;
import com.tencent.mm.pluginsdk.wallet.b;

public class PluginWxPayApi extends f implements a {
    public String name() {
        return "plugin-wxpayapi";
    }

    public void installed() {
        alias(PluginWxPayApi.class);
    }

    public void dependency() {
    }

    public void configure(g gVar) {
        gVar.ES();
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.plugin.x.a());
        }
    }
}
