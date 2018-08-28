package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.protocal.c.bxj;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a oqZ;

    a$1(a aVar) {
        this.oqZ = aVar;
    }

    public final boolean vD() {
        if (this.oqZ.oqY < 0) {
            return false;
        }
        bxj bxj;
        ajj ajj = (ajj) this.oqZ.diG.dIE.dIL;
        try {
            bxj = (bxj) ajj.rMl.get(this.oqZ.oqY);
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + this.oqZ.oqY + " not Found");
            bxj = null;
        }
        if (!(bxj == null || bxj.stP == null || bxj.stO == null)) {
            x.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + ajj.hcD + " idx:" + this.oqZ.oqY + " id:" + Integer.toHexString(bxj.bzI) + " size:" + bxj.stO.siI + " hdsize:" + bxj.stP.siI);
            a.a(bxj.bzI, true, bxj.stP.siK.toByteArray());
            a.a(bxj.bzI, false, bxj.stO.siK.toByteArray());
        }
        a aVar = this.oqZ;
        aVar.oqY--;
        return true;
    }
}
