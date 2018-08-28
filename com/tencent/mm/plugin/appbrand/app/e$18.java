package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$18 extends c<o> {
    final /* synthetic */ e ffn;

    e$18(e eVar) {
        this.ffn = eVar;
        this.sFo = o.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean fV = e.abf().fgu.fV("AppBrandCommonKVData", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'");
        x.i("MicroMsg.AppBrandCommonKVDataStorage", "sql:%s, updateRet : %b", new Object[]{"update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'", Boolean.valueOf(fV)});
        return true;
    }
}
