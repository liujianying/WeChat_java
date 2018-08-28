package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.a.k;
import com.tencent.mm.bk.b;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    public v gXt = new v();
    public w gXu = new w();
    final int gXv;
    final String gXw;
    final byte[] gXx;
    final String gXy;

    public a(String str, String str2, byte[] bArr, String str3, int i, int i2) {
        x.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[]{Integer.valueOf(i2), bi.cjd()});
        this.gXt.hbs = new b(k.b(str.getBytes(), bArr));
        this.gXt.hcC = 0;
        this.gXt.ID = str3;
        this.gXt.hcD = i;
        this.gXw = str2;
        this.gXy = str3;
        this.gXx = bArr;
        this.gXv = i2;
    }

    public final int getType() {
        return 1;
    }

    public final com.tencent.mm.bk.a asj() {
        return this.gXu;
    }

    public final com.tencent.mm.bk.a ask() {
        return this.gXt;
    }

    public final void mI(int i) {
        if (this.gXu.hcd != 0) {
            x.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[]{Integer.valueOf(this.gXu.hcd)});
            g(4, this.gXu.hcd, "onSceneEnd status failed");
        } else if (this.gXy.equals(this.gXu.ID)) {
            String str = new String(k.a(this.gXu.hbs.lR, this.gXx));
            x.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[]{Boolean.valueOf(str.length() != this.gXw.length() ? false : str.equals(this.gXw))});
            if (str.length() != this.gXw.length() ? false : str.equals(this.gXw)) {
                g(0, 0, "onSceneEnd auth success");
                if (this.gXv != 22 || this.gXu.hcD >= c.gRm) {
                    this.gXt.hbs = new b(k.b(this.gXw.getBytes(), this.gXx));
                    this.gXt.hcC = 1;
                    this.gXt.ID = this.gXy;
                    try {
                        x.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
                        b.o(this.gXt.toByteArray(), 1, i);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BackupAuthScene", e, "directSendAuthOk req to bur err.", new Object[0]);
                        return;
                    }
                }
                return;
            }
            x.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
            g(4, -3, "onSceneEnd check ok failed");
        } else {
            x.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
            g(4, -1, "onSceneEnd not the same id");
        }
    }

    public final void s(boolean z, boolean z2) {
        v vVar;
        if (z) {
            vVar = this.gXt;
            vVar.hcF |= c.gRq;
        }
        vVar = this.gXt;
        vVar.hcF |= c.gRr;
        vVar = this.gXt;
        vVar.hcF |= c.gRs;
        if (z2) {
            vVar = this.gXt;
            vVar.hcF |= c.gRt;
        }
    }
}
