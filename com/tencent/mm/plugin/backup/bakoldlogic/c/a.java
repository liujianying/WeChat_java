package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.k;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    final int gRy;
    private v gXt = new v();
    private w gXu = new w();
    final String han;
    final String hao;
    private boolean hap = false;
    final byte[] key;

    public a(String str, String str2, byte[] bArr, String str3) {
        x.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[]{str3, str, str2, bi.cjd()});
        this.gXt.hbs = new com.tencent.mm.bk.b(k.b(str.getBytes(), bArr));
        this.gXt.hcC = 0;
        this.gXt.ID = str3;
        this.gXt.hcD = 0;
        this.han = str2;
        this.hao = str3;
        this.key = bArr;
        this.gRy = -1;
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
            x.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[]{Integer.valueOf(this.gXu.hcd)});
            g(4, this.gXu.hcd, "not not success");
        } else if (this.hao.equals(this.gXu.ID)) {
            String str = new String(k.a(this.gXu.hbs.lR, this.key));
            this.hap = str.length() != this.han.length() ? false : str.equals(this.han);
            x.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[]{Boolean.valueOf(this.hap)});
            if (this.hap) {
                g(0, 0, "auth ok");
                this.gXt.hbs = new com.tencent.mm.bk.b(k.b(this.han.getBytes(), this.key));
                this.gXt.hcC = 1;
                this.gXt.ID = this.hao;
                try {
                    x.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
                    b.o(this.gXt.toByteArray(), 1, i);
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BakOldAuthScene", e, "directSendAuthOk req to bur err.", new Object[0]);
                    return;
                }
            }
            x.e("MicroMsg.BakOldAuthScene", "check ok failed");
            g(4, 1, "not ok packet");
        } else {
            x.e("MicroMsg.BakOldAuthScene", "not the same id");
            g(4, -1, "not the same id");
        }
    }
}
