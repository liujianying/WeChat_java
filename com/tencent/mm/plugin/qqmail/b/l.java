package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.no;
import com.tencent.mm.protocal.c.np;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends com.tencent.mm.ab.l implements k {
    b diG;
    private e diJ;
    private ArrayList<Long> mcU;

    public l(ArrayList<Long> arrayList) {
        this.mcU = arrayList;
        a aVar = new a();
        aVar.dIG = new no();
        aVar.dIH = new np();
        aVar.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
        aVar.dIF = 483;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if ((i2 != 0 || i3 != 0) && this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        } else if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 483;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        no noVar = (no) this.diG.dID.dIL;
        noVar.hbF = this.mcU.size();
        LinkedList linkedList = new LinkedList();
        Iterator it = this.mcU.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            qe qeVar = new qe();
            qeVar.rcq = longValue;
            linkedList.add(qeVar);
            x.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[]{Long.valueOf(longValue)});
        }
        noVar.rrE = linkedList;
        x.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[]{Integer.valueOf(noVar.hbF), Integer.valueOf(noVar.rrE.size())});
        return a(eVar, this.diG, this);
    }
}
