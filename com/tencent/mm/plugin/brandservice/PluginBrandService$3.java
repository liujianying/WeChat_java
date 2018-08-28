package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.s;

class PluginBrandService$3 implements a {
    final /* synthetic */ PluginBrandService hnF;

    PluginBrandService$3(PluginBrandService pluginBrandService) {
        this.hnF = pluginBrandService;
    }

    public final void a(f fVar, c cVar) {
        int i = 0;
        if (fVar != null && cVar != null) {
            int i2;
            if (("insert".equals(cVar.lcx) || "update".equals(cVar.lcx)) && cVar.lcy != null) {
                while (true) {
                    i2 = i;
                    if (i2 < cVar.lcy.size()) {
                        bd bdVar = (bd) cVar.lcy.get(i2);
                        if (bdVar.field_isSend != 1) {
                            s.ag(bdVar);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            } else if ("delete".equals(cVar.lcx) && cVar.lcy != null) {
                while (true) {
                    i2 = i;
                    if (i2 < cVar.lcy.size()) {
                        s.ai((bd) cVar.lcy.get(i2));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
