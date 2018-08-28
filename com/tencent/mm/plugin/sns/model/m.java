package com.tencent.mm.plugin.sns.model;

import android.util.Base64;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.boc;
import com.tencent.mm.protocal.c.bod;
import com.tencent.mm.protocal.c.boe;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m extends l implements k {
    public static List<Long> nnQ = Collections.synchronizedList(new LinkedList());
    private b diG;
    public e diJ;
    private String elA;
    private long nkI;

    public static boolean eK(long j) {
        if (nnQ.contains(Long.valueOf(j))) {
            return false;
        }
        nnQ.add(Long.valueOf(j));
        return true;
    }

    private static boolean eL(long j) {
        nnQ.remove(Long.valueOf(j));
        return true;
    }

    public m(long j, int i, String str) {
        boolean z;
        bhy bhy = null;
        this.nkI = j;
        a aVar = new a();
        aVar.dIG = new bod();
        aVar.dIH = new boe();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
        aVar.dIF = 683;
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        this.elA = stringBuilder.append(g.Ei().cachePath).append("ad_detail_session").toString();
        byte[] e = FileOp.e(this.elA, 0, -1);
        this.diG = aVar.KT();
        ((bod) this.diG.dID.dIL).rlK = j;
        ((bod) this.diG.dID.dIL).slZ = ab.O(e);
        ((bod) this.diG.dID.dIL).otY = i;
        if (str != null && str.length() > 0) {
            bod bod = (bod) this.diG.dID.dIL;
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                if (decode != null) {
                    bhy = new bhy();
                    bhy.bq(decode);
                }
            }
            bod.sma = bhy;
        }
        String str2 = "MicroMsg.NetSceneSnsAdObjectDetial";
        StringBuilder append = new StringBuilder("req snsId ").append(j).append(" ").append(i.eF(j)).append(" scene ").append(i).append(" buf is null? ");
        if (e == null) {
            z = true;
        } else {
            z = false;
        }
        x.d(str2, append.append(z).toString());
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", new Object[]{Long.valueOf(j), Integer.valueOf(i), str});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 683;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        byte[] a;
        Object obj = 1;
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + i2 + " errCode " + i3);
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 4 && i3 == 1) {
                a = ab.a(((boe) this.diG.dIE.dIL).slZ);
                if (a != null) {
                    FileOp.deleteFile(this.elA);
                    FileOp.b(this.elA, a, a.length);
                }
                obj = null;
            } else {
                obj = null;
            }
        }
        if (obj == null) {
            this.diJ.a(i2, i3, str, this);
            eL(this.nkI);
            return;
        }
        a = ab.a(((boe) this.diG.dIE.dIL).slZ);
        FileOp.deleteFile(this.elA);
        FileOp.b(this.elA, a, a.length);
        boc boc = ((boe) this.diG.dIE.dIL).smb;
        bhy bhy = ((boe) this.diG.dIE.dIL).smc;
        if (boc != null) {
            x.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + ab.b(boc.slX.smH));
            x.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + boc.slY);
        }
        if (boc == null || boc.slX == null || boc.slX.rXs <= 0) {
            if (!(boc == null || boc.slX == null)) {
                x.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + boc.slX.smO.size() + " like: " + boc.slX.smL.size());
            }
            a.a(boc, bhy);
            this.diJ.a(i2, i3, str, this);
            eL(this.nkI);
            return;
        }
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", boc.slX.rlK + " will remove by get detail ");
        eL(this.nkI);
        af.byr().delete(boc.slX.rlK);
        af.byt().fd(boc.slX.rlK);
        com.tencent.mm.plugin.sns.storage.i.fc(boc.slX.rlK);
        this.diJ.a(i2, i3, str, this);
    }
}
