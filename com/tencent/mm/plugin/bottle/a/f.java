package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import java.util.Map;

public final class f extends l implements k {
    private final b diG;
    private e diJ;
    boolean hjY = false;

    public f() {
        a aVar = new a();
        aVar.dIG = new bau();
        aVar.dIH = new bav();
        aVar.uri = "/cgi-bin/micromsg-bin/pickbottle";
        aVar.dIF = 155;
        aVar.dII = 54;
        aVar.dIJ = 1000000054;
        this.diG = aVar.KT();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 155;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetScenePickBottle", "onGYNetEnd type:" + i2 + " code:" + i3);
        if (i2 == 4 && (i3 == -2002 || i3 == -56)) {
            c.ng(0);
            c.nh(0);
        }
        bav bav = (bav) this.diG.dIE.dIL;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.nh(bav.rGd);
                    c.ng(bav.rGc);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            this.hjY = true;
            x.d("MicroMsg.NetScenePickBottle", "bottle pack:pack:" + bav.rGd + " throw:" + bav.rGc);
            String[] strArr = null;
            if (bav.say != null) {
                strArr = bav.say.split(":");
            }
            if (strArr != null && strArr.length >= 2) {
                String str2 = strArr[0];
                au.HU();
                ab Yg = c.FR().Yg(str2);
                if (Yg == null || !Yg.field_username.equals(str2)) {
                    ab abVar = new ab();
                    abVar.setUsername(str2);
                    abVar.dx(bav.hcS == null ? "" : bav.hcS);
                    abVar.eI(3);
                    j jVar = new j();
                    jVar.username = str2;
                    jVar.csA = 3;
                    jVar.by(true);
                    jVar.bWA = -1;
                    try {
                        Map z = bl.z(bav.rIk, "userinfo");
                        if (z != null) {
                            abVar.eJ(bi.getInt((String) z.get(".userinfo.$sex"), 0));
                            abVar.dM((String) z.get(".userinfo.$signature"));
                            abVar.dS(RegionCodeDecoder.aq((String) z.get(".userinfo.$country"), (String) z.get(".userinfo.$province"), (String) z.get(".userinfo.$city")));
                            x.d("MicroMsg.NetScenePickBottle", "user:" + str2 + " sig:" + abVar.signature + " sex" + abVar.sex + " city:" + abVar.getCity() + " prov:" + abVar.getProvince());
                            jVar.dHR = (String) z.get(".userinfo.$bigheadimgurl");
                            jVar.dHQ = (String) z.get(".userinfo.$smallheadimgurl");
                            jVar.bWA = -1;
                            x.d("MicroMsg.NetScenePickBottle", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{str2, jVar.Kx(), jVar.Ky()});
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.NetScenePickBottle", "Set Contact failed " + e.getMessage() + " user:" + str2);
                    }
                    au.HU();
                    c.FR().R(abVar);
                    com.tencent.mm.aa.q.KH().a(jVar);
                }
            }
            x.d("MicroMsg.NetScenePickBottle", "getBottleType " + bav.sde);
            x.d("MicroMsg.NetScenePickBottle", "getMsgType " + bav.jQd);
            x.d("MicroMsg.NetScenePickBottle", "getBottleInfo " + bav.say);
            x.d("MicroMsg.NetScenePickBottle", "getUserInfo " + bav.rIk);
            x.d("MicroMsg.NetScenePickBottle", "getNickName " + bav.hcS);
            x.d("MicroMsg.NetScenePickBottle", "getUserStatus " + bav.sdf);
            x.d("MicroMsg.NetScenePickBottle", "getThrowCount " + bav.rGc);
            x.d("MicroMsg.NetScenePickBottle", "getPickCount " + bav.rGd);
            x.d("MicroMsg.NetScenePickBottle", "getDistance " + bav.sdg);
        } else if (i3 == -56) {
            c.nh(bav.rGd);
            c.nh(bav.rGc);
        }
        this.diJ.a(i2, i3, str, this);
    }

    final bav auh() {
        return (bav) this.diG.dIE.dIL;
    }
}
