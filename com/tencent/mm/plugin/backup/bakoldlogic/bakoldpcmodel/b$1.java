package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.a.n;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$1 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ List gZr;
    final /* synthetic */ b gZs;

    b$1(b bVar, int i, List list) {
        this.gZs = bVar;
        this.bpX = i;
        this.gZr = list;
    }

    public final void run() {
        switch (this.bpX) {
            case 0:
                b.a(this.gZs, ((Integer) ((pw) this.gZr.get(0)).rue.getFirst()).intValue());
                return;
            case 1:
                WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
                int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                if (dhcpInfo != null) {
                    int i = dhcpInfo.netmask;
                    String str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                    x.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", str, Integer.valueOf(i));
                    String str2 = null;
                    int i2 = 0;
                    for (pw pwVar : this.gZr) {
                        x.i("MicroMsg.BakOldJavaEngine", "try ip:%s", pwVar.rud);
                        if (pwVar.rud != null) {
                            if (pwVar.rud.split("\\.").length >= 4) {
                                int w = n.w(new byte[]{(byte) (bi.getInt(pwVar.rud.split("\\.")[0], 0) & 255), (byte) (bi.getInt(pwVar.rud.split("\\.")[1], 0) & 255), (byte) (bi.getInt(pwVar.rud.split("\\.")[2], 0) & 255), (byte) (bi.getInt(pwVar.rud.split("\\.")[3], 0) & 255)});
                                if ((i & w) == (i & ipAddress)) {
                                    b.a(this.gZs, pwVar.rud, ((Integer) pwVar.rue.getFirst()).intValue());
                                    return;
                                }
                                int intValue;
                                if ((w & 65535) == (65535 & ipAddress)) {
                                    String str3 = pwVar.rud;
                                    intValue = ((Integer) pwVar.rue.getFirst()).intValue();
                                    str2 = str3;
                                } else {
                                    intValue = i2;
                                }
                                i2 = intValue;
                            } else {
                                continue;
                            }
                        }
                    }
                    if (str2 != null) {
                        x.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", str2, Integer.valueOf(i2));
                        b.a(this.gZs, str2, i2);
                        return;
                    }
                    b.a(this.gZs, 10009, String.format("not match ip mask:%d, localip:%s", new Object[]{Integer.valueOf(i), str}).getBytes());
                    x.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", Integer.valueOf(i), str);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
