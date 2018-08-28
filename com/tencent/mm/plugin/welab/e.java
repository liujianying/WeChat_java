package com.tencent.mm.plugin.welab;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static void a(a aVar) {
        int i;
        d dVar = new d();
        dVar.r("expid", aVar.qmP + ",");
        dVar.r("appid", aVar.bPS + ",");
        dVar.r("action", aVar.action + ",");
        dVar.r("timestamp", aVar.timeStamp + ",");
        String str = "hasRedPoint";
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar.qmQ) {
            i = 1;
        } else {
            i = 0;
        }
        dVar.r(str, stringBuilder.append(i).append(",").toString());
        x.i("WelabReporter", "report " + dVar.wF());
        h.mEJ.h(14206, new Object[]{dVar});
    }

    public static void n(String str, int i, boolean z) {
        a aVar = new a();
        aVar.bPS = str;
        aVar.action = i;
        aVar.timeStamp = System.currentTimeMillis();
        aVar.qmP = b.bYI().RT(str).field_expId;
        aVar.qmQ = z;
        a(aVar);
    }
}
