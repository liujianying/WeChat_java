package com.tencent.mm.plugin.z;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class e$2 implements e {
    final /* synthetic */ e lsS;

    e$2(e eVar) {
        this.lsS = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(222, this.lsS.lsR);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
            com.tencent.mm.a.e.k(new File(f.bfG()));
            com.tencent.mm.a.e.k(new File(f.bfH()));
            long bH = bi.bH(this.lsS.lsM);
            h.mEJ.a(466, 1, 1, false);
            h.mEJ.a(466, 5, this.lsS.lsP, false);
            h.mEJ.a(466, 7, bH, false);
            h.mEJ.a(466, 11, this.lsS.lsO, false);
            h.mEJ.a(466, 12, this.lsS.lsN, false);
            h.mEJ.h(14108, new Object[]{Long.valueOf(this.lsS.lsP), Long.valueOf(bH), Long.valueOf(this.lsS.lsO), Long.valueOf(this.lsS.lsN), Integer.valueOf(0), Integer.valueOf(this.lsS.bTr)});
            return;
        }
        x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        h.mEJ.a(466, 3, 1, false);
        h.mEJ.h(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.lsS.bTr)});
    }
}
