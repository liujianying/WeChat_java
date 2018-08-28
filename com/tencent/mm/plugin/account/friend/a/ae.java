package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.any;
import com.tencent.mm.protocal.c.anz;
import com.tencent.mm.protocal.c.aoa;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ae extends l implements k {
    private final b diG;
    private e diJ;
    private LinkedList<any> eLa;
    public String eLb;

    public ae(ArrayList<String> arrayList) {
        int i = 0;
        a aVar = new a();
        aVar.dIG = new anz();
        aVar.dIH = new aoa();
        aVar.uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
        aVar.dIF = 489;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.eLa = new LinkedList();
        if (arrayList.size() > 0) {
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    any any = new any();
                    any.rhh = (String) arrayList.get(i2);
                    this.eLa.add(any);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.diJ = eVar2;
        anz anz = (anz) this.diG.dID.dIL;
        anz.hbF = this.eLa.size();
        anz.hbG = this.eLa;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final aoa XP() {
        return (aoa) this.diG.dIE.dIL;
    }

    public final int getType() {
        return 489;
    }
}
