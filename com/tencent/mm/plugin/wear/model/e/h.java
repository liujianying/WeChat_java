package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.ceb;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11000));
        arrayList.add(Integer.valueOf(11003));
        arrayList.add(Integer.valueOf(11035));
        return arrayList;
    }

    public final boolean bSz() {
        return false;
    }

    protected final byte[] p(int i, byte[] bArr) {
        int i2 = 0;
        String str;
        String str2;
        if (i == 11000) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = FileOp.ct(str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e, "handleData", new Object[0]);
            }
            String[] split = str2.split("​​");
            List arrayList = new ArrayList();
            for (int i3 = 0; i3 < split.length; i3++) {
                arrayList.add(split[i3]);
                if (i3 % 50 == 9) {
                    com.tencent.mm.plugin.report.service.h.mEJ.n("WearCrash", arrayList);
                    arrayList.clear();
                }
            }
            if (arrayList.size() > 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.n("WearCrash", arrayList);
                arrayList.clear();
            }
            new File(str).delete();
        } else if (i == 11003) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = FileOp.ct(str);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e2, "handleData", new Object[0]);
            }
            String[] split2 = str2.split("​​");
            int length = split2.length;
            while (i2 < length) {
                x.i("MicroMsg.Wear.LOG", split2[i2]);
                i2++;
            }
            new File(str).delete();
        } else if (i == 11035) {
            ceb ceb = new ceb();
            try {
                ceb.aG(bArr);
            } catch (IOException e3) {
            }
            if (a.bSl().pIM.pJd.pJT != null) {
                x.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", Integer.valueOf(ceb.jTt), a.bSl().pIM.pJd.pJT.hbQ, a.bSl().pIM.pJd.pJT.szd, Integer.valueOf(a.bSl().pIM.pJd.pJT.rdn), a.bSl().pIM.pJd.pJT.sze, ceb.svH);
                com.tencent.mm.plugin.report.service.h.mEJ.h(ceb.jTt, r2.hbQ, r2.szd, Integer.valueOf(r2.rdn), r2.sze, ceb.svH);
            }
        }
        return null;
    }
}
