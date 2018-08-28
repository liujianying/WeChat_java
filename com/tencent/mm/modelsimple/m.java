package com.tencent.mm.modelsimple;

import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ags;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class m extends l implements k {
    private String account;
    private b diG;
    private e diJ;

    public m(String str) {
        this.account = str;
        a aVar = new a();
        aVar.dIG = new ags();
        aVar.dIH = new agt();
        aVar.uri = "/cgi-bin/micromsg-bin/getprofile";
        aVar.dIF = HardCoderJNI.SCENE_QUIT_CHATTING;
        this.diG = aVar.KT();
        ((ags) this.diG.dID.dIL).hbL = str;
    }

    public final int getType() {
        return HardCoderJNI.SCENE_QUIT_CHATTING;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bi.oW(this.account)) {
            x.e("MicroMsg.NetSceneGetProfile", "null or empty username");
            return -1;
        }
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        if (i2 == 0 && i3 == 0) {
            agt agt = (agt) this.diG.dIE.dIL;
            com.tencent.mm.sdk.b.b sdVar = new sd();
            sdVar.ccW.ccX = agt.rKa.stD;
            com.tencent.mm.sdk.b.a.sFg.m(sdVar);
            if (com.tencent.mm.model.q.GF().equals(agt.rJZ.rvi.toString()) && !bi.oW(agt.rKa.rra)) {
                g.Ei().DT().a(aa.a.USERINFO_SELFINFO_SMALLIMGURL_STRING, agt.rKa.rra);
            }
            x.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", Integer.valueOf(agt.rJZ.rYa), Integer.valueOf(agt.rKa.stx));
            g.Ei().DT().set(64, Integer.valueOf(agt.rKa.raE));
            g.Ei().DT().set(144385, Integer.valueOf(agt.rKa.stx));
            g.Ei().DT().set(40, Integer.valueOf(agt.rJZ.rYa));
            g.Ei().DT().set(339975, Integer.valueOf(agt.rKa.stF));
            x.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", Integer.valueOf(agt.rKa.stF));
            g.Ei().DT().a(aa.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(agt.rKa.rEA));
            x.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", Integer.valueOf(agt.rKa.stF), Integer.valueOf(agt.rKa.rEA));
            g.Ei().DT().set(208903, agt.rKa.rhh);
            g.Ei().DT().set(274433, agt.rKa.rXl);
            g.Ei().DT().set(274434, agt.rKa.rXk);
            g.Ei().DT().set(274436, agt.rKa.sty);
            g.Ei().DT().a(aa.a.USERINFO_PROFILE_WEIDIANINFO_STRING, bi.aG(agt.rKa.csY, ""));
            g.Ei().DT().a(aa.a.USERINFO_F2F_RING_TONE_STRING, agt.rKa.stH);
            x.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", agt.rKa.csY);
            at.dBv.T("last_login_use_voice", agt.rJZ.rYa);
            if (VERSION.SDK_INT < 23) {
                System.putString(ad.getContext().getContentResolver(), "89884a87498ef44f", agt.rKa.stE);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
