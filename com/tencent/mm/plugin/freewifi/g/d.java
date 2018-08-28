package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends i<c> {
    public static final String[] diD = new String[]{i.a(c.dhO, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )"};

    public d(e eVar) {
        super(eVar, c.dhO, "FreeWifiInfo", null);
    }

    public final c Cf(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            return null;
        }
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", "select * from FreeWifiInfo where ssidmd5 = '" + ac.ce(str) + "' and wifiType = 1");
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final c Cg(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            return null;
        }
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", "select * from FreeWifiInfo where ssidmd5 = '" + ac.ce(str) + "'");
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final c aPn() {
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", "select * from FreeWifiInfo where connectState = 2");
        Cursor rawQuery = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final void Ch(String str) {
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + ac.ce(str) + "'");
        boolean fV = fV("FreeWifiInfo", r0);
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", Boolean.valueOf(fV));
    }
}
