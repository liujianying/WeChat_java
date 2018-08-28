package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements Runnable {
    final /* synthetic */ byte[] jXt;
    final /* synthetic */ boolean oYQ;
    final /* synthetic */ i oYR;

    i$1(i iVar, byte[] bArr, boolean z) {
        this.oYR = iVar;
        this.jXt = bArr;
        this.oYQ = z;
    }

    public final void run() {
        if (this.jXt != null) {
            if (this.oYQ) {
                if (FileOp.cn(i.bO())) {
                    FileOp.I(i.bO(), true);
                }
                FileOp.mL(i.bO());
                i.a(this.oYR);
            } else {
                if (FileOp.cn(i.ath())) {
                    FileOp.I(i.ath(), true);
                }
                FileOp.mL(i.ath());
                i.b(this.oYR);
            }
            try {
                String str = System.currentTimeMillis();
                String str2 = "MicroMsg.LqtBindQueryInfoCache";
                String str3 = "saveCacheToDisk, dir: %s, name: %s, save: %s";
                Object[] objArr = new Object[3];
                objArr[0] = this.oYQ ? i.bO() : i.ath();
                objArr[1] = str;
                objArr[2] = Boolean.valueOf(this.oYQ);
                x.i(str2, str3, objArr);
                long VG = bi.VG();
                FileOp.l((this.oYQ ? i.bO() : i.ath()) + str, this.jXt);
                x.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
