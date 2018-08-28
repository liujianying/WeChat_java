package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.o;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.Date;

public final class u extends c<sy> implements e {
    private String btH;
    private sy pqV;

    public u() {
        this.btH = null;
        this.sFo = sy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long longValue;
        this.pqV = (sy) bVar;
        this.btH = this.pqV.cdO.buF;
        g.Ek();
        Object obj = g.Ei().DT().get(a.sSp, Long.valueOf(0));
        long longValue2 = obj != null ? ((Long) obj).longValue() : 0;
        long time = new Date().getTime();
        g.Ek();
        obj = g.Ei().DT().get(a.sSq, Long.valueOf(600000));
        if (obj != null) {
            longValue = ((Long) obj).longValue();
            if (longValue <= 0) {
                longValue = 600000;
            }
        } else {
            longValue = 600000;
        }
        if (time - longValue2 > longValue || bi.oW(this.btH)) {
            x.i("MicroMsg.WalletGetBulletinEventListener", "data is out of date,do NetSceneGetBannerInfo for update");
            d dVar = new d();
            g.Ek();
            o oVar = g.Eh().dpP;
            oVar.a(385, this);
            oVar.a(dVar, 0);
        } else if (bi.oW(this.btH)) {
            x.e("MicroMsg.WalletGetBulletinEventListener", "mScene is null");
            this.pqV.bJX.run();
            this.pqV = null;
        } else {
            x.i("MicroMsg.WalletGetBulletinEventListener", "get bulletin data from db");
            bPf();
        }
        return true;
    }

    private void bPf() {
        com.tencent.mm.plugin.wallet_core.d.d bPa = o.bPa();
        r rVar = new r();
        rVar.field_bulletin_scene = this.btH;
        if (bPa.b(rVar, new String[0])) {
            this.pqV.cdP.cdQ = rVar.field_bulletin_scene;
            this.pqV.cdP.content = rVar.field_bulletin_content;
            this.pqV.cdP.url = rVar.field_bulletin_url;
        } else {
            x.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
        }
        this.pqV.bJX.run();
        this.pqV = null;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + i + ";errCode=" + i2);
        g.Ek();
        g.Eh().dpP.b(385, this);
        g.Ek();
        g.Ei().DT().a(a.sSp, Long.valueOf(new Date().getTime()));
        bPf();
    }
}
