package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.a;
import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.plugin.backup.f.c.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$b$2 implements c {
    final /* synthetic */ b gSD;

    c$b$2(b bVar) {
        this.gSD = bVar;
    }

    public final void a(com.tencent.mm.plugin.backup.f.c cVar) {
        long VF = bi.VF();
        a aVar = this.gSD.gSt;
        long asz = (long) cVar.asz();
        boolean z = this.gSD.ftu;
        String str = "MicroMsg.BackupPackAndSend";
        String str2 = "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Long.valueOf(asz);
        objArr[2] = Long.valueOf(aVar.gSp.get());
        objArr[3] = Boolean.valueOf(aVar.gSp.get() >= 8388608);
        objArr[4] = Boolean.valueOf(aVar.gSp.get() >= 16777216);
        x.v(str, str2, objArr);
        if (aVar.gSp.get() + asz >= 8388608) {
            aVar.gSq.close();
        }
        if (aVar.gSp.get() >= 16777216) {
            aVar.gSr.close();
        }
        long VF2 = bi.VF();
        while (!aVar.gSo.gSg) {
            if (aVar.gSp.get() < (z ? 16777216 : 8388608)) {
                aVar.gSp.addAndGet(asz);
                str = "MicroMsg.BackupPackAndSend";
                String str3 = "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]";
                Object[] objArr2 = new Object[6];
                objArr2[0] = Long.valueOf(bi.bH(VF2));
                objArr2[1] = Boolean.valueOf(z);
                objArr2[2] = Long.valueOf(asz);
                objArr2[3] = Long.valueOf(aVar.gSp.get());
                objArr2[4] = Boolean.valueOf(aVar.gSp.get() >= 8388608);
                objArr2[5] = Boolean.valueOf(aVar.gSp.get() >= 16777216);
                x.v(str, str3, objArr2);
                this.gSD.gSs.offer(new 1(this, cVar, VF));
            }
            (z ? aVar.gSr : aVar.gSq).cih();
        }
        this.gSD.gSs.offer(new 1(this, cVar, VF));
    }
}
