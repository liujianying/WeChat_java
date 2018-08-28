package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.t;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.protocal.c.lc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class v extends l implements k {
    private final b diG;
    private e diJ;
    public String hxc;
    public ArrayList<la> hxd;

    public v(String str, float f, float f2, String str2) {
        this.hxc = str;
        a aVar = new a();
        aVar.dIG = new lb();
        aVar.dIH = new lc();
        aVar.uri = "/cgi-bin/micromsg-bin/cardshoplbs";
        aVar.dIF = 563;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        lb lbVar = (lb) this.diG.dID.dIL;
        lbVar.huU = str;
        lbVar.bUg = f;
        lbVar.bSx = f2;
        lbVar.cac = str2;
        x.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[]{str, Float.valueOf(f), Float.valueOf(f2), str2});
    }

    public final int getType() {
        return 563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bi.oW(((lb) this.diG.dID.dIL).huU)) {
            x.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
            return -1;
        }
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((lc) this.diG.dIE.dIL).hwU;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
            }
            this.hxd = t.yi(obj);
            if (this.hxd != null) {
                x.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[]{Integer.valueOf(this.hxd.size())});
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
