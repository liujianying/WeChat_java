package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class bv extends i<bu> {
    public static final String[] diD = new String[]{i.a(bu.dhO, "UserOpenIdInApp")};
    public e diF;

    public bv(e eVar) {
        super(eVar, bu.dhO, "UserOpenIdInApp", null);
        this.diF = eVar;
        eVar.fV("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
        eVar.fV("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    }

    public final bu Zq(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.diF.a("UserOpenIdInApp", null, "openId=?", new String[]{bi.oU(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bu buVar = new bu();
            buVar.d(a);
            a.close();
            return buVar;
        }
        x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:" + str);
        a.close();
        return null;
    }

    public final boolean a(bu buVar) {
        if (buVar == null || bi.oW(buVar.field_appId) || bi.oW(buVar.field_openId) || bi.oW(buVar.field_username)) {
            x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.diF.replace("UserOpenIdInApp", bu.dhO.sKz, buVar.wH()) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[]{buVar.field_appId, buVar.field_username, Boolean.valueOf(z)});
        return z;
    }
}
