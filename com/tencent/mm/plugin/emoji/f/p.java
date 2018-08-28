package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.protocal.c.agk;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class p extends l implements k {
    private final b diG;
    private e diJ;
    private int fdx;
    public byte[] iiN;
    private int iiY;

    public p(int i, byte[] bArr) {
        this(i, bArr, (byte) 0);
    }

    private p(int i, byte[] bArr, byte b) {
        this.iiN = null;
        a aVar = new a();
        aVar.dIG = new agk();
        aVar.dIH = new agl();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
        aVar.dIF = 720;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iiY = i;
        this.iiN = bArr;
        this.fdx = 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        agl agl = (agl) ((b) qVar).dIE.dIL;
        if (agl.rcT != null) {
            this.iiN = ab.a(agl.rcT);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 720;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        agk agk = (agk) this.diG.dID.dIL;
        agk.rHi = this.iiY;
        if (this.iiN != null) {
            agk.rcT = ab.O(this.iiN);
        } else {
            agk.rcT = new bhy();
        }
        agk.otY = this.fdx;
        x.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", agk.rcT == null ? "Buf is NULL" : agk.rcT.toString());
        return a(eVar, this.diG, this);
    }

    public final agl aET() {
        return this.diG == null ? null : (agl) this.diG.dIE.dIL;
    }

    public static f a(agl agl) {
        x.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
        if (agl == null) {
            return null;
        }
        f fVar = new f();
        if (!(agl == null || agl.rHC == null)) {
            fVar.ihp = agl.rHC.size();
            List arrayList = new ArrayList();
            Iterator it = agl.rHC.iterator();
            while (it.hasNext()) {
                ts tsVar = (ts) it.next();
                if (tsVar.rem != null) {
                    arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(tsVar));
                }
            }
            fVar.ihq = arrayList;
        }
        return fVar;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 100;
    }
}
