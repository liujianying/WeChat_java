package com.tencent.mm.plugin.sns.a.b;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bb;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private b diG;
    public e diJ;

    public c(String str, String str2) {
        this(str, 18, 5, str2, 2, -1);
    }

    public c(String str, int i, int i2, String str2, int i3, long j) {
        this(str, i, i2, str2, i3, "", j);
    }

    public c(String str, int i, int i2, String str2, int i3, String str3) {
        this(str, i, i2, str2, i3, 0, "", str3);
    }

    private c(String str, int i, int i2, String str2, int i3, String str3, long j) {
        this(str, i, i2, str2, i3, 0, str3, n.nkD.eC(j), 0);
    }

    private c(String str, int i, int i2, String str2, int i3, int i4, String str3, int i5, int i6) {
        a aVar = new a();
        aVar.dIG = new bb();
        aVar.dIH = new bc();
        if (i5 != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/click";
            aVar.dIF = 1232;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adclick";
            aVar.dIF = 1817;
        }
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        x.i("MicroMsg.NetSceneAdClick", "uri %s", new Object[]{this.diG.uri});
        x.i("MicroMsg.NetSceneAdClick", "NetSceneAdClick clickPos: " + i + " viewId: " + str + " sceneType: " + i2 + " adtype " + i3 + ", clickAction " + i4 + ",source " + i5 + ", descXml " + str2);
        if (!bi.oW(str2)) {
            x.i("MicroMsg.NetSceneAdClick", "descXml: " + str2);
        }
        bb bbVar = (bb) this.diG.dID.dIL;
        bbVar.egJ = i;
        bbVar.egF = str;
        bbVar.scene = i2;
        bbVar.rbn = str2;
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                bbVar.bssid = bi.aG(connectionInfo.getBSSID(), "");
                bbVar.ssid = bi.aG(connectionInfo.getSSID(), "");
            }
        }
        bbVar.rbo = System.currentTimeMillis();
        bbVar.rbq = i3;
        bbVar.rbr = i4;
        bbVar.source = i5;
        bbVar.rbs = str3;
        bbVar.rbt = i6;
    }

    public c(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4) {
        this(str, i, i2, str2, i3, i4, str3, str4, 0);
    }

    public c(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4, int i5) {
        this(str, i, i2, str2, i3, i4, str3, n.nkD.Lx(str4), i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 1232;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAdClick", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.diJ.a(i2, i3, str, this);
    }
}
