package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avv;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class aa extends l implements k {
    public final b diG;
    private e diJ;

    public aa(int i) {
        a aVar = new a();
        aVar.dIG = new avv();
        aVar.dIH = new avw();
        aVar.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
        aVar.dIF = 135;
        aVar.dII = 23;
        aVar.dIJ = 1000000023;
        this.diG = aVar.KT();
        ((avv) this.diG.dID.dIL).rQA = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 135;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        avw avw = (avw) this.diG.dIE.dIL;
        x.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + avw.jTa.size() + " group:" + avw.rcM.size());
        Set hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < avw.rYO) {
                if (!hashSet.contains(((avz) avw.jTa.get(i5)).hbL)) {
                    linkedList.add(avw.jTa.get(i5));
                    hashSet.add(((avz) avw.jTa.get(i5)).hbL);
                }
                i4 = i5 + 1;
            } else {
                avw.jTa = linkedList;
                avw.rYO = linkedList.size();
                this.diJ.a(i2, i3, str, this);
                return;
            }
        }
    }
}
