package com.tencent.mm.modelmulti;

import com.tencent.mm.booter.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Queue;

class p$d implements c {
    final /* synthetic */ p eay;

    p$d(p pVar) {
        this.eay = pVar;
    }

    public final boolean c(Queue<c> queue) {
        PInt pInt = new PInt();
        g.Ek();
        g.Eg();
        byte[] a = f.a(pInt, a.Df());
        String str = "MicroMsg.SyncService";
        String str2 = "%s index:%d, buf.len:%d ";
        Object[] objArr = new Object[3];
        objArr[0] = this;
        objArr[1] = Integer.valueOf(pInt.value);
        objArr[2] = Integer.valueOf(a != null ? a.length : -1);
        x.i(str, str2, objArr);
        if (pInt.value == 0 || bi.bC(a)) {
            return false;
        }
        awe awe;
        int i = pInt.value;
        awe awe2 = null;
        try {
            b bVar = new b();
            bVar.G(a);
            awe = bVar.qWX;
        } catch (Exception e) {
            com.tencent.mm.plugin.report.f.mDy.a(99, 38, 1, false);
            x.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed ", new Object[]{this, Integer.valueOf(i)});
            g.Ek();
            g.Eg();
            f.aO(i, a.Df());
            awe = awe2;
        } catch (Error e2) {
            com.tencent.mm.plugin.report.f.mDy.a(99, 39, 1, false);
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            x.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[]{this, Integer.valueOf(i), Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory)});
            p.F("LightPush memory error", false);
            awe = awe2;
        }
        if (awe == null) {
            return false;
        }
        com.tencent.mm.plugin.report.f.mDy.a(99, 20, 1, false);
        p.a aVar = new p.a(this.eay, this, true, awe, new 1(this, i), (byte) 0);
        return true;
    }

    public final String toString() {
        return "LightPush[" + hashCode() + "]";
    }
}
