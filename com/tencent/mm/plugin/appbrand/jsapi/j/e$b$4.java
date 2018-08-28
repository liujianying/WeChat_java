package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.j.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.j.e.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.picker.d$b;
import java.util.HashMap;
import java.util.Map;

class e$b$4 implements d$b<int[]> {
    final /* synthetic */ b fXl;

    e$b$4(b bVar) {
        this.fXl = bVar;
    }

    public final /* synthetic */ void bl(Object obj) {
        c cVar;
        int[] iArr = (int[]) obj;
        int i = iArr[0];
        int i2 = iArr[1];
        a aVar = new a((byte) 0);
        Map hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("column", Integer.valueOf(i));
        hashMap.put("current", Integer.valueOf(i2));
        aVar.x(hashMap);
        b bVar = this.fXl;
        if (bVar.mPageRef == null) {
            cVar = null;
        } else {
            p cVar2 = (p) bVar.mPageRef.get();
        }
        if (cVar2 != null) {
            aVar.a(cVar2).h(new int[]{cVar2.hashCode()});
        }
    }
}
