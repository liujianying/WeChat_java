package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.LinkedList;
import java.util.List;

public final class c extends l implements k {
    public final b diG;
    private e diJ;
    public int eKI;
    private List<String> iin;

    public c(int i, List<String> list) {
        a aVar = new a();
        aVar.dIG = new eq();
        aVar.dIH = new er();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
        aVar.dIF = 698;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.eKI = i;
        this.iin = list;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i3 == -434) {
            x.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sOQ, Boolean.valueOf(true));
            h.mEJ.a(164, 7, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sOQ, Boolean.valueOf(false));
            if (this.eKI == 1) {
                h.mEJ.a(164, 5, 1, false);
            } else {
                h.mEJ.a(164, 8, 1, false);
            }
        } else if (this.eKI == 1) {
            h.mEJ.a(164, 6, 1, false);
        } else {
            h.mEJ.a(164, 9, 1, false);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        eq eqVar = (eq) this.diG.dID.dIL;
        eqVar.rfe = this.eKI;
        eqVar.rfd = new LinkedList(this.iin);
        if (eqVar.rfd == null || eqVar.rfd.size() <= 0) {
            x.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
        } else {
            x.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[]{Integer.valueOf(eqVar.rfd.size())});
            for (int i = 0; i < eqVar.rfd.size(); i++) {
                x.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[]{eqVar.rfd.get(i)});
            }
        }
        return a(eVar, this.diG, this);
    }
}
