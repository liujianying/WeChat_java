package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aee;
import com.tencent.mm.protocal.c.aef;
import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.protocal.c.aeh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class z extends l implements k {
    private e doG = null;
    private String ivJ = "";
    b ivx = null;

    public z(LinkedList<aef> linkedList, String str, String str2) {
        this.ivJ = str2;
        a aVar = new a();
        aVar.dIG = new aeg();
        aVar.dIH = new aeh();
        aVar.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
        aVar.dIF = 543;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        aeg aeg = (aeg) this.ivx.dID.dIL;
        if (!bi.oW(str)) {
            aee aee = new aee();
            aee.rgK = str;
            aeg.rIu = aee;
        }
        aeg.rIt = linkedList;
    }

    public final int getType() {
        return 543;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
    }
}
