package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class b$a$2 implements a {
    final /* synthetic */ b.a qCc;

    b$a$2(b.a aVar) {
        this.qCc = aVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        if (bi.oW(a)) {
            x.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
            return;
        }
        x.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n" + a);
        if (!bi.oW(a)) {
            Map z = bl.z(a, "sysmsg");
            j.n(0, 0);
            String str = "MicroMsg.CheckResUpdateNewXmlParser";
            String str2 = "parsed values.size = %s";
            Object[] objArr = new Object[1];
            objArr[0] = z == null ? "null" : String.valueOf(z.size());
            x.i(str, str2, objArr);
            if (z == null) {
                j.n(0, 30);
            } else {
                j.n(0, 31);
            }
            if (z != null && z.size() > 0 && bi.oV((String) z.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")) {
                e.f(".sysmsg", "delete", z);
                e.f(".sysmsg", "cache", z);
                e.f(".sysmsg", "decrypt", z);
            }
        }
    }
}
