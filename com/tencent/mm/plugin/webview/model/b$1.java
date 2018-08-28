package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ak.m;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class b$1 implements Runnable {
    final /* synthetic */ String pQZ;
    final /* synthetic */ d pRa;
    final /* synthetic */ b pRb;

    public b$1(b bVar, String str, d dVar) {
        this.pRb = bVar;
        this.pQZ = str;
        this.pRa = dVar;
    }

    public final void run() {
        Map z = bl.z(this.pQZ, "DNSAdvanceRelateDomain");
        LinkedList linkedList = new LinkedList();
        if (z != null && z.size() > 0) {
            String str;
            int i = 0;
            while (i < z.size()) {
                str = (String) z.get(".DNSAdvanceRelateDomain.RelateDomain" + (i == 0 ? "" : Integer.valueOf(i)) + ".$domain");
                if (bi.oW(str)) {
                    x.i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", new Object[]{Integer.valueOf(i)});
                    break;
                }
                if (!linkedList.contains(str)) {
                    linkedList.add(str);
                }
                i++;
            }
            int i2 = 0;
            while (true) {
                String str2 = (String) z.get(".DNSAdvanceRelateDomain.RelateDomain" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".Relate");
                str = (String) z.get(".DNSAdvanceRelateDomain.RelateDomain.Relate" + (i2 == 0 ? "" : Integer.valueOf(i2)));
                if (bi.oW(str2) && bi.oW(str)) {
                    break;
                }
                if (!(bi.oW(str2) || linkedList.contains(str2))) {
                    linkedList.add(str2);
                }
                if (!(bi.oW(str) || linkedList.contains(str))) {
                    linkedList.add(str);
                }
                i2++;
            }
            x.i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", new Object[]{Integer.valueOf(i2)});
            m bUr = this.pRb.pQY.bUr();
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    long currentTimeMillis;
                    str = (String) it.next();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    InetAddress inetAddress = null;
                    try {
                        inetAddress = InetAddress.getByName(str);
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        x.i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", new Object[]{str, Long.valueOf(currentTimeMillis)});
                    } catch (Exception e) {
                        x.e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", new Object[]{e.getMessage()});
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    }
                    bUr.grC = currentTimeMillis;
                    bUr.url = str;
                    if (inetAddress != null) {
                        bUr.bLW = true;
                    } else {
                        bUr.bLW = false;
                    }
                    d dVar = this.pRa;
                    if (dVar != null) {
                        x.i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", new Object[]{Integer.valueOf(ak.bUp()), Long.valueOf(bUr.grC), bUr.url, Boolean.valueOf(bUr.bLW)});
                        String str3 = bUr.pSv;
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(1);
                        objArr[1] = Long.valueOf(bUr.grC);
                        objArr[2] = Integer.valueOf(ao.getNetType(ad.getContext()));
                        objArr[3] = bUr.url == null ? bUr.url : bUr.url.replace(",", "!");
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ak.bB());
                        objArr[8] = Integer.valueOf(ak.KD());
                        objArr[9] = Integer.valueOf(bUr.cfR);
                        objArr[10] = bUr.pSv;
                        ak.a(dVar, str3, objArr);
                        if (!bUr.bLW) {
                            h.mEJ.a(32, 12, 1, true);
                        }
                        h.mEJ.a(32, 1, 1, true);
                        h.mEJ.a(32, 5, bUr.grC, true);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", new Object[]{e2.getMessage()});
            }
        }
    }
}
