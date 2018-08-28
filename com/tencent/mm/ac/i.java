package com.tencent.mm.ac;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends com.tencent.mm.sdk.e.i<g> {
    public static final String[] diD = new String[]{com.tencent.mm.sdk.e.i.a(g.dhO, "BizKF")};
    public e diF;

    public i(e eVar) {
        super(eVar, g.dhO, "BizKF", null);
        this.diF = eVar;
        eVar.fV("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
        eVar.fV("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    }

    public final g kQ(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.diF.a("BizKF", null, "openId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.d(a);
            a.close();
            return gVar;
        }
        x.w("MicroMsg.BizKFStorage", "get null with openId:" + str);
        a.close();
        return null;
    }

    public static boolean a(g gVar) {
        if (gVar == null || System.currentTimeMillis() - gVar.field_updateTime < 86400000) {
            return false;
        }
        return true;
    }

    private boolean b(g gVar) {
        if (gVar == null || bi.oW(gVar.field_openId) || bi.oW(gVar.field_brandUsername)) {
            x.w("MicroMsg.BizKFStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.diF.replace("BizKF", g.dhO.sKz, gVar.wH()) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", new Object[]{gVar.field_openId, gVar.field_brandUsername, Boolean.valueOf(z)});
        return z;
    }

    public final g kR(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Cursor a = this.diF.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.d(a);
            a.close();
            return gVar;
        }
        x.w("MicroMsg.BizKFStorage", "get null with brandUsername:" + str);
        a.close();
        return null;
    }

    public final int e(LinkedList<g> linkedList) {
        if (linkedList.size() <= 0) {
            x.e("MicroMsg.BizKFStorage", "null kfs");
            return 0;
        }
        long dO;
        if (this.diF instanceof h) {
            dO = ((h) this.diF).dO(Thread.currentThread().getId());
        } else {
            dO = 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar != null && b(gVar)) {
                i++;
            }
            i = i;
        }
        if (this.diF instanceof h) {
            g.Ei().dqq.gp(dO);
        }
        x.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", new Object[]{Integer.valueOf(i)});
        return i;
    }
}
