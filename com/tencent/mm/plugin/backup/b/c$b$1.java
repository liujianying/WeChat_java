package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.a;
import com.tencent.mm.plugin.backup.f.c.b;
import com.tencent.mm.sdk.platformtools.x;

class c$b$1 implements b {
    final /* synthetic */ c.b gSD;

    c$b$1(c.b bVar) {
        this.gSD = bVar;
    }

    public final void d(boolean z, String str, int i) {
        a aVar = this.gSD.gSt;
        long j = (long) i;
        aVar.gSp.addAndGet(0 - j);
        if (aVar.gSp.get() < 8388608) {
            aVar.gSq.open();
        }
        if (aVar.gSp.get() < 16777216) {
            aVar.gSr.open();
        }
        String str2 = "MicroMsg.BackupPackAndSend";
        String str3 = "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(aVar.gSp.get());
        objArr[2] = Boolean.valueOf(aVar.gSp.get() >= 8388608);
        objArr[3] = Boolean.valueOf(aVar.gSp.get() >= 16777216);
        objArr[4] = Boolean.valueOf(aVar.gSq.sGC);
        objArr[5] = Boolean.valueOf(aVar.gSr.sGC);
        x.v(str2, str3, objArr);
        this.gSD.gSo.gSj += (long) i;
        x.i(this.gSD.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), str});
    }
}
