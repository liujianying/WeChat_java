package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.w;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static d nxJ = new d();
    public w cXI;
    public int dlT = 0;
    public HashMap<String, Integer> nxK;
    public HashMap<String, String> nxL;
    public int nxM = 200;
    public int nxN = 86400;

    private d() {
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100077");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            this.nxM = bi.getInt((String) ckq.get("maxCacheFeedCount"), 200);
            this.nxN = bi.getInt((String) ckq.get("maxCacheSeconds"), 86400);
            this.dlT = bi.getInt((String) ckq.get("needUploadData"), 0);
        }
        x.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[]{Integer.valueOf(this.nxM), Integer.valueOf(this.nxN), Integer.valueOf(this.dlT)});
        this.cXI = new w(aa.duN + "snsreport.cfg");
        Object obj = this.cXI.get(3, new HashMap());
        Object obj2 = this.cXI.get(4, new HashMap());
        if ((obj instanceof HashMap) && (obj2 instanceof HashMap)) {
            this.nxK = (HashMap) obj;
            this.nxL = (HashMap) obj2;
            return;
        }
        FileOp.deleteFile(aa.duN + "snsreport.cfg");
        this.nxK = new HashMap();
        this.nxL = new HashMap();
    }

    public final void MT(String str) {
        if (this.dlT != 0) {
            this.nxK.put(str, Integer.valueOf(this.nxK.containsKey(str) ? ((Integer) this.nxK.get(str)).intValue() + 1 : 1));
        }
    }

    public final void eF(String str, String str2) {
        if (this.dlT != 0 && !bi.oW(str) && !bi.oW(str2)) {
            this.nxL.put(str, str2);
        }
    }
}
