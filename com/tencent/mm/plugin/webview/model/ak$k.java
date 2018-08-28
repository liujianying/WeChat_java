package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;

public class ak$k {
    public int cfR;
    public HashMap<String, Long> pSH = new HashMap();
    final /* synthetic */ ak pSn;
    public String pSv;

    public ak$k(ak akVar) {
        this.pSn = akVar;
    }

    public final void bd(String str, boolean z) {
        if (bi.oW(str)) {
            x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        } else if (!this.pSH.containsKey(str)) {
        } else {
            if (z) {
                this.pSH.put(str, Long.valueOf(bi.VF() - ((Long) this.pSH.get(str)).longValue()));
                return;
            }
            this.pSH.put(str, Long.valueOf(-1));
        }
    }

    public final void c(d dVar) {
        if (dVar != null) {
            int bUp = ak.bUp();
            for (Entry entry : this.pSH.entrySet()) {
                String str = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                h.mEJ.a(32, 2, 1, true);
                if (longValue == -1) {
                    h.mEJ.a(32, 13, 1, true);
                    x.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[]{str, Integer.valueOf(bUp)});
                }
                if (longValue >= 0 && longValue <= 60000) {
                    String str2 = this.pSv;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(2);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bUp);
                    objArr[3] = str == null ? str : str.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(ak.bB());
                    objArr[8] = Integer.valueOf(ak.KD());
                    objArr[9] = Integer.valueOf(this.cfR);
                    objArr[10] = this.pSv;
                    ak.a(dVar, str2, objArr);
                    x.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{str, Long.valueOf(longValue), Integer.valueOf(bUp), Integer.valueOf(this.cfR), this.pSv});
                    h.mEJ.a(32, 6, longValue, true);
                }
            }
        }
    }
}
