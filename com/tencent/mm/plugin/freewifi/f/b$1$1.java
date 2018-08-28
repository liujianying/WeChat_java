package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.f.b.1;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class b$1$1 implements e {
    final /* synthetic */ 1 jlM;

    b$1$1(1 1) {
        this.jlM = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        try {
            x.i("MicroMsg.FreeWifi.FreeWifiServerReporter", "errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (m.cC(i, i2)) {
                LinkedList aPa = ((com.tencent.mm.plugin.freewifi.d.e) lVar).aPa();
                if (aPa != null && aPa.size() > 0) {
                    f aOM = j.aOM();
                    Iterator it = aPa.iterator();
                    while (it.hasNext()) {
                        xm xmVar = (xm) it.next();
                        String str2 = xmVar.id;
                        x.i("MicroMsg.FreeWifi.FreeWifiServerReporter", "resp LinkedList<FreeWifiReport>. id=%s, errcode=%d", new Object[]{str2, Integer.valueOf(xmVar.bMH)});
                        if (!m.isEmpty(str2) && r0 == 0) {
                            x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete. id=%s", new Object[]{str2});
                            com.tencent.mm.plugin.freewifi.g.e eVar = new com.tencent.mm.plugin.freewifi.g.e();
                            eVar.field_id = str2;
                            x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete ret" + aOM.a(eVar, new String[0]));
                        }
                    }
                }
            }
            b.jlI = true;
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiServerReporter", m.h(e));
            b.jlI = true;
        } catch (Throwable th) {
            b.jlI = true;
            throw th;
        }
    }
}
