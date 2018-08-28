package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkm;
import com.tencent.mm.protocal.c.bkn;
import java.util.LinkedList;

public final class ah extends l implements k {
    private final b diG;
    private e diJ;

    public ah(int[] iArr) {
        a aVar = new a();
        aVar.dIG = new bkm();
        aVar.dIH = new bkn();
        aVar.uri = "/cgi-bin/micromsg-bin/sendinviteemail";
        aVar.dIF = 116;
        aVar.dII = 41;
        aVar.dIJ = 1000000041;
        this.diG = aVar.KT();
        LinkedList linkedList = new LinkedList();
        for (int valueOf : iArr) {
            linkedList.add(Integer.valueOf(valueOf));
        }
        ((bkm) this.diG.dID.dIL).ska = linkedList;
        ((bkm) this.diG.dID.dIL).sjZ = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 116;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
