package com.tencent.mm.modelstat;

import android.net.wifi.ScanResult;
import com.tencent.mm.modelstat.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.List;

class e$c$1 implements Runnable {
    final /* synthetic */ c ejB;

    e$c$1(c cVar) {
        this.ejB = cVar;
    }

    public final void run() {
        x.i("MicroMsg.IndoorReporter", "start wifi");
        while (this.ejB.ejz) {
            try {
                int i;
                long VF = bi.VF();
                List scanResults = this.ejB.bnh.getScanResults();
                String str = "";
                if (scanResults == null || scanResults.size() <= 0) {
                    i = 0;
                } else {
                    Collections.sort(scanResults, new 1(this));
                    int i2 = 0;
                    i = 0;
                    while (i2 < scanResults.size()) {
                        int i3;
                        ScanResult scanResult = (ScanResult) scanResults.get(i2);
                        if (scanResult != null && !bi.oW(scanResult.BSSID) && !bi.oW(scanResult.SSID)) {
                            str = str + scanResult.SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "") + ";" + scanResult.BSSID + ";" + scanResult.level + ";";
                            i3 = i + 1;
                            if (i3 >= this.ejB.eiW) {
                                i = i3;
                                break;
                            }
                        } else {
                            i3 = i;
                        }
                        i2++;
                        i = i3;
                    }
                }
                x.i("MicroMsg.IndoorReporter", "%d %s", new Object[]{Integer.valueOf(((VF - this.ejB.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str).length()), (VF - this.ejB.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str});
                this.ejB.ejA.add(r0);
                this.ejB.bnh.startScan();
                Thread.sleep((long) this.ejB.ejy);
            } catch (Exception e) {
                x.e("MicroMsg.IndoorReporter", "Except:%s", new Object[]{e.getMessage()});
                return;
            }
        }
    }
}
