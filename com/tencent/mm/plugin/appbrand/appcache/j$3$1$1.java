package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.aq.a;
import com.tencent.mm.plugin.appbrand.appcache.base.b;
import com.tencent.mm.plugin.appbrand.appcache.j.3.1;
import com.tencent.mm.pluginsdk.g.a.c.k;

class j$3$1$1 implements a {
    final /* synthetic */ 1 ffI;

    j$3$1$1(1 1) {
        this.ffI = 1;
    }

    public final /* bridge */ /* synthetic */ void a(k kVar) {
    }

    public final /* bridge */ /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
        if (aVar == b.a.a.fio) {
            j.a(this.ffI.ffH.ffE, "公共库增量(maybe)更新成功，重启微信确认是否生效");
        } else {
            j.a(this.ffI.ffH.ffE, "公共库增量失败");
        }
    }
}
