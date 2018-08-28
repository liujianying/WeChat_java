package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ int jiW;
    final /* synthetic */ b jjU;
    final /* synthetic */ g jjV;
    final /* synthetic */ String jjh;
    final /* synthetic */ Intent val$intent;

    g$1(g gVar, String str, Intent intent, b bVar, int i) {
        this.jjV = gVar;
        this.jjh = str;
        this.val$intent = intent;
        this.jjU = bVar;
        this.jiW = i;
    }

    public final void run() {
        int i = this.jjV.jjT;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "now retry count = %d", new Object[]{Integer.valueOf(i2)});
                g.b(this.jjh, 1, this.val$intent);
                String AH = g.AU().AH();
                x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from cinfig : %s", new Object[]{AH});
                if (bi.oW(AH)) {
                    x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from config failed, use the default url : %s", new Object[]{"http://10.1.0.6/redirect"});
                    AH = "http://10.1.0.6/redirect";
                }
                String Cc = g.Cc(AH);
                x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url : %s, %s", new Object[]{AH, Cc});
                if (bi.oW(Cc)) {
                    x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url failed : %s, %s", new Object[]{AH, Cc});
                    try {
                        Thread.sleep(500);
                        i = i2;
                    } catch (Exception e) {
                        i = i2;
                    }
                } else {
                    AH = g.cP(Cc, "auth=");
                    x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauthmessage from location : %s, %s", new Object[]{AH, Cc});
                    if (bi.oW(AH)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauth message from location failed : %s", new Object[]{Cc});
                        g.b(this.jjh, 3, this.val$intent);
                    }
                    if (this.jjU != null) {
                        this.jjU.bp(AH, this.jiW);
                        return;
                    }
                    return;
                }
            }
            if (this.jjU != null) {
                this.jjU.bp(null, this.jiW);
            }
            g.b(this.jjh, 3, this.val$intent);
            return;
        }
    }
}
