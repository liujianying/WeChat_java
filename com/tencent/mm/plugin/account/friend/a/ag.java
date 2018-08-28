package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag extends l implements k {
    private final b diG;
    private e diJ = null;

    public ag(String str, List<String[]> list) {
        int i = 0;
        a aVar = new a();
        aVar.dIG = new arg();
        aVar.dIH = new arh();
        aVar.uri = "/cgi-bin/micromsg-bin/listmfriend";
        aVar.dIF = 431;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        arg arg = (arg) this.diG.dID.dIL;
        arg.rwj = str;
        arg.rTB = 0;
        if (list != null) {
            i = list.size();
        }
        arg.rTz = i;
        arg.rTC = new LinkedList();
        arg.rTA = new LinkedList();
        if (list != null) {
            for (String[] strArr : list) {
                if (!bi.oW(strArr[2])) {
                    arg.rTA.add(new bhz().VO(strArr[2]));
                }
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final LinkedList<arf> XR() {
        LinkedList linkedList = ((arh) this.diG.dIE.dIL).rTD;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                arf arf = (arf) it.next();
                com.tencent.mm.plugin.d.a.ZN().Gw().fX(arf.hbL, arf.rEJ);
            }
        }
        return ((arh) this.diG.dIE.dIL).rTD;
    }

    public final int getType() {
        return 431;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        g.Em().a(new 1(this, (arh) this.diG.dIE.dIL));
        this.diJ.a(i2, i3, str, this);
    }
}
