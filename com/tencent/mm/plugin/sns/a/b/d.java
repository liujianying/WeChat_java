package com.tencent.mm.plugin.sns.a.b;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.protocal.c.bg;
import com.tencent.mm.protocal.c.bh;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private b diG;
    public e diJ;

    public d(String str, int i, bi biVar, int i2, int i3, int i4) {
        this(str, i, 1, 0, null, biVar, i2, "", i3, i4, 0, 0, 0);
    }

    public d(String str, int i, int i2, int i3, bf bfVar, bi biVar, int i4, String str2, int i5, int i6, int i7, int i8, int i9) {
        a aVar = new a();
        aVar.dIG = new bg();
        aVar.dIH = new bh();
        if (i6 != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/exposure";
            aVar.dIF = 1231;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adexposure";
            aVar.dIF = 1875;
        }
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        x.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[]{this.diG.uri});
        bg bgVar = (bg) this.diG.dID.dIL;
        bgVar.rbC = i3;
        bgVar.type = i2;
        bgVar.scene = i;
        bgVar.egF = str;
        bgVar.rbF = i5;
        bgVar.rbG = i7;
        bgVar.rbH = i8;
        bgVar.rbt = i9;
        if (bfVar != null) {
            bgVar.rbD = bfVar;
            x.i("MicroMsg.NetSceneAdExposure", "exposure_info " + bfVar.rbA);
        }
        if (biVar != null) {
            bgVar.rbE = biVar;
            x.i("MicroMsg.NetSceneAdExposure", "social_info " + biVar.rbI + " " + biVar.like_count);
        }
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                bgVar.bssid = com.tencent.mm.sdk.platformtools.bi.aG(connectionInfo.getBSSID(), "");
                bgVar.ssid = com.tencent.mm.sdk.platformtools.bi.aG(connectionInfo.getSSID(), "");
            }
        }
        bgVar.rbo = System.currentTimeMillis();
        bgVar.rbq = i4;
        if (str2 != null) {
            bgVar.rbn = str2;
        }
        x.i("MicroMsg.NetSceneAdExposure", "##time viewid " + str + " sceneType " + i + " type: " + i2 + " duration " + i3 + "feed_duration " + i7 + "feed_full_duration " + i8 + " ad_type " + i4 + " exposureCount " + i5 + " descXml:" + str2 + " flip_status " + i9);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 1231;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAdExposure", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bh bhVar = (bh) this.diG.dIE.dIL;
        x.i("MicroMsg.NetSceneAdExposure", "resp " + bhVar.ret + " msg: " + bhVar.bIr);
        this.diJ.a(i2, i3, str, this);
    }
}
