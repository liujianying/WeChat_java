package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.protocal.c.bzz;
import com.tencent.mm.protocal.c.caa;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends n<bzz, caa> {
    public e(int i, long j, String str) {
        a aVar = new a();
        aVar.dIG = new bzz();
        aVar.dIH = new caa();
        aVar.uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
        aVar.dIF = 303;
        aVar.dII = 119;
        aVar.dIJ = 1000000119;
        this.diG = aVar.KT();
        bzz bzz = (bzz) this.diG.dID.dIL;
        bzz.rxG = i;
        bzz.rxH = j;
        bzz.svS = str;
        bzz.hcE = 1;
        bzz.suO = System.currentTimeMillis();
    }

    public final int getType() {
        return 303;
    }

    public final void dP(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((caa) bLq()) != null) {
                x.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[]{Integer.valueOf(((caa) bLq()).rxG), Long.valueOf(((caa) bLq()).rxH), Integer.valueOf(((caa) bLq()).hLg), Integer.valueOf(((caa) bLq()).svK)});
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    }

    public final com.tencent.mm.ab.e bLm() {
        return new 1(this);
    }
}
