package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class bk extends i<bj> {
    public static final String[] diD = new String[]{i.a(bj.dhO, "OpenMsgListener")};
    public e diF;

    public final /* synthetic */ boolean a(c cVar) {
        bj bjVar = (bj) cVar;
        if (bjVar == null || bi.oW(bjVar.field_appId)) {
            x.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
            return false;
        }
        x.d("MicroMsg.OpenMsgListenerStorage", "replace: id=%s, ret=%s ", new Object[]{bjVar.field_appId, Boolean.valueOf(this.diF.replace("OpenMsgListener", bj.dhO.sKz, bjVar.wH()) > 0)});
        return this.diF.replace("OpenMsgListener", bj.dhO.sKz, bjVar.wH()) > 0;
    }

    public bk(e eVar) {
        super(eVar, bj.dhO, "OpenMsgListener", null);
        this.diF = eVar;
        eVar.fV("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
        eVar.fV("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
    }

    public final bj Zf(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.diF.a("OpenMsgListener", null, "appId=?", new String[]{bi.oU(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bj bjVar = new bj();
            bjVar.d(a);
            a.close();
            return bjVar;
        }
        x.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:" + str);
        a.close();
        return null;
    }

    public final Cursor cmR() {
        return rawQuery("select * from OpenMsgListener where (status = ?) ", new String[]{"1"});
    }
}
