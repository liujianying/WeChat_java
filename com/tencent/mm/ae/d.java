package com.tencent.mm.ae;

import android.database.Cursor;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class d extends ah {
    public final void transfer(int i) {
        x.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        if (gV(i)) {
            h.mEJ.e(336, 10, 1);
            long currentTimeMillis = System.currentTimeMillis();
            au.HU();
            if (bi.f((Integer) c.DT().get(86017, null)) == 3) {
                x.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
                return;
            }
            au.HU();
            c.FO().fV("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
            au.HU();
            Cursor c = c.FR().c("@all.weixin.android", "", null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                ab abVar = new ab();
                abVar.d(c);
                au.HU();
                c.FR().c(abVar.field_username, abVar);
                c.moveToNext();
            }
            c.close();
            x.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            au.HU();
            c.DT().set(86017, Integer.valueOf(3));
            x.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return;
        }
        x.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
    }

    public final boolean gV(int i) {
        return i != 0 && i < 604176383;
    }

    public final String getTag() {
        return "MicroMsg.VerifyFlagDataTransfer";
    }
}
