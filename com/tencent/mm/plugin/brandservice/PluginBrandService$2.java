package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.b.a;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class PluginBrandService$2 extends c<ag> {
    final /* synthetic */ PluginBrandService hnF;

    PluginBrandService$2(PluginBrandService pluginBrandService) {
        this.hnF = pluginBrandService;
        this.sFo = ag.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ag agVar = (ag) bVar;
        if (agVar == null || !(agVar instanceof ag)) {
            return false;
        }
        ag agVar2 = agVar;
        switch (agVar2.bHr.action) {
            case 1:
                Context context = agVar2.bHr.context;
                String str = agVar2.bHr.bHt;
                String str2 = agVar2.bHr.title;
                int i = agVar2.bHr.fromScene;
                long j = agVar2.bHr.bHu;
                int i2 = agVar2.bHr.offset;
                boolean z = agVar2.bHr.bHv;
                if (context == null || bi.oW(str)) {
                    x.e("MicroMsg.BrandService.BrandServiceLogic", "context(%s) or keyword(%s) is null or nil.", new Object[]{context, str});
                    return false;
                }
                g.DF().a(1071, new a(context, str, j, i2, i, str2, z, agVar2));
                g.DF().a(new h(str, j, i2, i, ""), 0);
                return true;
            default:
                x.d("MicroMsg.BrandService.BrandServiceLogic", "Do not support the action(%d).", new Object[]{Integer.valueOf(agVar2.bHr.action)});
                return false;
        }
    }
}
