package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ad;
import com.tencent.mm.plugin.backup.h.ae;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class d extends b {
    private static int progress;
    private int dHI;
    private f has = null;
    private ad hau = new ad();
    private ae hav = new ae();
    private String haw;
    public String id;
    private byte[] key;
    private int offset = 0;
    private int start = 0;

    public d(String str, String str2, int i, int i2, f fVar, byte[] bArr) {
        if (i == 1) {
            this.haw = str + "backupItem/" + a.wv(str2);
        } else {
            this.haw = str + "backupMeida/" + a.wv(str2);
        }
        this.id = str2;
        this.hau.hcI = str2;
        this.hau.hcJ = i;
        this.dHI = i2;
        x.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[]{this.hau.hcI, Integer.valueOf(this.hau.hcJ), Integer.valueOf(this.dHI)});
        this.has = fVar;
        this.key = bArr;
    }

    public final boolean ass() {
        int i;
        long j = 524288;
        x.i("MicroMsg.BakSceneRestoreData", "doSecne");
        int i2 = this.dHI;
        if (this.hau.hcJ == 2) {
            if (((long) (this.dHI - this.offset)) <= 524288) {
                j = (long) (this.dHI - this.offset);
            }
            i = (int) j;
        } else {
            i = i2;
        }
        this.start = this.offset;
        this.offset = i + this.start;
        this.hau.hcL = this.start;
        this.hau.hcM = this.offset;
        this.hau.hcO = progress;
        return super.ass();
    }

    public static void setProgress(int i) {
        x.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[]{Integer.valueOf(i)});
        progress = i;
    }

    public final com.tencent.mm.bk.a asj() {
        return this.hav;
    }

    public final com.tencent.mm.bk.a ask() {
        return this.hau;
    }

    public final void mI(int i) {
        x.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[]{this.hav.hcI, Integer.valueOf(this.hav.hcJ), Integer.valueOf(this.hav.hcL), Integer.valueOf(this.hav.hcM), Integer.valueOf(this.hav.hcd)});
        if (this.hav.hcd != 0 && this.hav.hcd != 10) {
            g(4, this.hav.hcd, "error");
        } else if (this.hav.hcL == this.start && this.hav.hcM == this.offset) {
            byte[] aesCryptEcb;
            this.has.a(this.hau.hcM - this.hau.hcL, this.dHI, this);
            byte[] bArr = this.hav.hbs.lR;
            if (this.key != null) {
                aesCryptEcb = AesEcb.aesCryptEcb(bArr, this.key, false, this.offset == this.dHI);
            } else {
                aesCryptEcb = bArr;
            }
            String str = this.haw;
            String str2 = this.id;
            File file = new File(str + str2);
            long length = file.exists() ? file.length() : 0;
            e.b(str, str2, aesCryptEcb);
            File file2 = new File(str + str2);
            if (length == (file2.exists() ? file2.length() : 0)) {
                x.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[]{str + str2});
                e.b(str, str2, aesCryptEcb);
            }
            str = "MicroMsg.BakSceneRestoreData";
            String str3 = "onSceneEnd appendbuf len:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aesCryptEcb == null ? 0 : aesCryptEcb.length);
            x.i(str, str3, objArr);
            if (this.offset == this.dHI) {
                x.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[]{this.id, Integer.valueOf(this.dHI)});
                g(0, 0, "success");
                return;
            }
            ass();
        } else {
            x.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[]{Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.hav.hcL), Integer.valueOf(this.hav.hcM)});
            g(3, -1, "error");
        }
    }

    public final int getType() {
        return 7;
    }
}
