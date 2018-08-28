package com.tencent.mm.modelstat;

import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class e$c {
    WifiManager bnh;
    int eiW = 0;
    List<String> ejA = new ArrayList();
    final /* synthetic */ e eje;
    int ejy = 0;
    boolean ejz = false;
    long startTime = 0;
    Thread thread = e.b(new 1(this), "MicroMsg.IndoorReporter_WIFI_Scan");

    e$c(e eVar) {
        this.eje = eVar;
    }

    public final String RX() {
        boolean z = false;
        this.ejz = false;
        try {
            if (this.thread != null && this.thread.isAlive()) {
                this.thread.join(500);
            }
        } catch (Exception e) {
            x.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[]{e.getMessage()});
        }
        String str = this.ejA.size() + ";#";
        while (true) {
            boolean z2 = z;
            if (z2 >= this.ejA.size()) {
                return str;
            }
            str = str + ((String) this.ejA.get(z2)) + "#";
            z = z2 + 1;
        }
    }
}
