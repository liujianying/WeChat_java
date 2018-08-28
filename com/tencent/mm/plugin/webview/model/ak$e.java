package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;

public class ak$e {
    public int cfR;
    public String gsE = "";
    final /* synthetic */ ak pSn;
    public HashMap<String, Long> pSs = new HashMap();
    public HashMap<String, Long> pSt = new HashMap();
    public boolean pSu = true;
    public String pSv;

    public ak$e(ak akVar) {
        this.pSn = akVar;
    }

    public final void c(d dVar) {
        if (dVar != null) {
            String str;
            long longValue;
            String str2;
            Object[] objArr;
            int bUp = ak.bUp();
            for (Entry entry : this.pSs.entrySet()) {
                str = (String) entry.getKey();
                longValue = ((Long) entry.getValue()).longValue();
                if (longValue >= 0 && longValue <= 180000) {
                    str2 = this.pSv;
                    objArr = new Object[11];
                    objArr[0] = Integer.valueOf(5);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bUp);
                    if (str != null) {
                        str = str.replace(",", "!");
                    }
                    objArr[3] = str;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(ak.bB());
                    objArr[8] = Integer.valueOf(ak.KD());
                    objArr[9] = Integer.valueOf(this.cfR);
                    objArr[10] = this.pSv;
                    ak.a(dVar, str2, objArr);
                    if (ak.bB() == 1) {
                        h.mEJ.a(32, 18, 1, true);
                        h.mEJ.a(32, 19, longValue, true);
                    }
                    h.mEJ.a(32, 8, 1, true);
                    h.mEJ.a(32, 9, longValue, true);
                    x.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{Long.valueOf(longValue), Integer.valueOf(bUp), Integer.valueOf(ak.bB()), Integer.valueOf(ak.KD()), Integer.valueOf(this.cfR), this.pSv});
                } else {
                    return;
                }
            }
            for (Entry entry2 : this.pSt.entrySet()) {
                str = (String) entry2.getKey();
                longValue = ((Long) entry2.getValue()).longValue();
                if (longValue >= 0 && longValue <= 180000) {
                    str2 = this.pSv;
                    objArr = new Object[11];
                    objArr[0] = Integer.valueOf(6);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bUp);
                    if (str != null) {
                        str = str.replace(",", "!");
                    }
                    objArr[3] = str;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(ak.bB());
                    objArr[8] = Integer.valueOf(ak.KD());
                    objArr[9] = Integer.valueOf(this.cfR);
                    objArr[10] = this.pSv;
                    ak.a(dVar, str2, objArr);
                    if (ak.bB() == 1) {
                        h.mEJ.a(32, 20, 1, true);
                        h.mEJ.a(32, 21, longValue, true);
                    }
                    h.mEJ.a(32, 10, 1, true);
                    h.mEJ.a(32, 11, longValue, true);
                    x.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{Long.valueOf(longValue), Integer.valueOf(bUp), Integer.valueOf(ak.bB()), Integer.valueOf(ak.KD()), Integer.valueOf(this.cfR), this.pSv});
                } else {
                    return;
                }
            }
        }
    }
}
