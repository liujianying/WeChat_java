package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.a.b;
import com.tencent.mm.y.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e implements i {
    private static Map<String, Object> gjZ = new HashMap();
    private static Map<String, List<a>> gka = new HashMap();

    public final b jm(String str) {
        c abe = com.tencent.mm.plugin.appbrand.app.e.abe();
        int hashCode = str.hashCode();
        b bVar = new b();
        bVar.field_shareKeyHash = hashCode;
        if (!abe.b(bVar, new String[]{"shareKeyHash"})) {
            x.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
            bVar = null;
        }
        if (bVar == null) {
            x.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", new Object[]{str, Integer.valueOf(str.hashCode())});
            return null;
        }
        x.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", new Object[]{str, Integer.valueOf(str.hashCode()), Integer.valueOf(bVar.field_btnState)});
        return bVar;
    }

    public final boolean I(String str, int i) {
        boolean z;
        c abe = com.tencent.mm.plugin.appbrand.app.e.abe();
        if (bi.oW(str)) {
            x.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
            z = false;
        } else {
            b bVar = new b();
            bVar.field_shareKeyHash = str.hashCode();
            boolean b = abe.b(bVar, new String[0]);
            bVar.field_btnState = i;
            z = b ? abe.c(bVar, new String[0]) : abe.b(bVar);
        }
        x.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", new Object[]{str, Integer.valueOf(str.hashCode()), Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            gjZ.get(str);
        }
        return z;
    }

    public final boolean a(String str, String str2, String str3, int i, int i2) {
        boolean z;
        c abe = com.tencent.mm.plugin.appbrand.app.e.abe();
        if (bi.oW(str)) {
            x.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
            z = false;
        } else {
            b bVar = new b();
            bVar.field_shareKeyHash = str.hashCode();
            boolean b = abe.b(bVar, new String[0]);
            bVar.field_updatePeroid = i;
            bVar.field_msgState = i2;
            bVar.field_content = str2;
            bVar.field_contentColor = str3;
            z = b ? abe.c(bVar, new String[0]) : abe.b(bVar);
        }
        x.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", new Object[]{str, Integer.valueOf(str.hashCode()), str2, str3, Boolean.valueOf(z)});
        return z;
    }

    public final synchronized void a(String str, String str2, String str3, int i, a aVar) {
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3)) {
            x.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
        } else {
            List list = (List) gka.get(str);
            if (list == null) {
                x.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[]{str});
                list = new ArrayList();
                gka.put(str, list);
            }
            x.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[]{Integer.valueOf(str3.hashCode())});
            x.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[]{str3});
            a aVar2 = new a((byte) 0);
            aVar2.appId = str2;
            aVar2.dzR = str3;
            aVar2.gkb = i;
            aVar2.gkc = aVar;
            if (bi.oW(aVar2.appId) || bi.oW(aVar2.dzR)) {
                x.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
            } else {
                x.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[]{Integer.valueOf(b.gkd.gke.size())});
                r2.gke.put(Integer.valueOf(aVar2.dzR.hashCode()), aVar2);
                b.gkd.alo();
            }
            list.add(aVar2);
        }
    }

    public final synchronized void jn(String str) {
        x.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[]{str});
        List<a> list = (List) gka.get(str);
        if (list == null) {
            x.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
        } else {
            for (a aVar : list) {
                x.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[]{Integer.valueOf(b.gkd.gke.size())});
                r2.gke.remove(Integer.valueOf(aVar.dzR.hashCode()));
            }
            gka.remove(str);
        }
    }
}
