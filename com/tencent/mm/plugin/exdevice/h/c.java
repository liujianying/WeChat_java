package com.tencent.mm.plugin.exdevice.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class c extends i<b> {
    public static final String[] diD = new String[]{i.a(b.dhO, "HardDeviceInfo")};
    private e diF;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar) {
        b bVar = (b) cVar;
        if (bVar == null || bi.oW(bVar.field_brandName) || bi.oW(bVar.field_deviceID)) {
            x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "wrong argument");
            return false;
        }
        x.i("MicroMsg.exdevice.HardDeviceInfoStorage", "replace: brandName=%s, deviceId=%s, ret=%s ", new Object[]{bVar.field_brandName, bVar.field_deviceID, Boolean.valueOf(this.diF.replace("HardDeviceInfo", b.dhO.sKz, bVar.wH()) > 0)});
        return this.diF.replace("HardDeviceInfo", b.dhO.sKz, bVar.wH()) > 0;
    }

    public c(e eVar) {
        super(eVar, b.dhO, "HardDeviceInfo", null);
        this.diF = eVar;
        eVar.fV("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
        eVar.fV("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
    }

    public final b Ak(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Cursor a = this.diF.a("HardDeviceInfo", null, "mac=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.d(a);
            a.close();
            return bVar;
        }
        x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + str);
        a.close();
        return null;
    }

    public final b cX(long j) {
        b bVar = null;
        Cursor query = this.diF.query("HardDeviceInfo", null, "mac=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                bVar = new b();
                bVar.d(query);
            } else {
                x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + j);
            }
            query.close();
        }
        return bVar;
    }

    public final b Al(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Cursor a = this.diF.a("HardDeviceInfo", null, "deviceID=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.d(a);
            a.close();
            return bVar;
        }
        x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:" + str);
        a.close();
        return null;
    }

    public final b cz(String str, String str2) {
        if (bi.oW(str2) || bi.oW(str)) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", new Object[]{str2, str});
            return null;
        }
        Cursor a = this.diF.a("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[]{str2, str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.d(a);
            a.close();
            return bVar;
        }
        x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", new Object[]{str2, str});
        a.close();
        return null;
    }

    public static boolean Am(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
            return false;
        } else if (str.contains("wxmsg_music") || str.contains("wxmsg_poi") || str.contains("wxmsg_image") || str.contains("wxmsg_file") || str.contains("wxmsg_video") || str.contains("wxmsg_url")) {
            return true;
        } else {
            return false;
        }
    }

    public final List<b> aHI() {
        List<b> linkedList = new LinkedList();
        Cursor axc = axc();
        if (axc == null || !axc.moveToFirst()) {
            if (axc != null) {
                axc.close();
            }
            return linkedList;
        }
        do {
            b bVar = new b();
            bVar.d(axc);
            String str = bVar.cCX;
            if (str != null && Am(str)) {
                linkedList.add(bVar);
            }
        } while (axc.moveToNext());
        if (axc != null) {
            axc.close();
        }
        return linkedList;
    }

    public final List<b> aHJ() {
        List<b> linkedList = new LinkedList();
        Cursor axc = axc();
        if (axc == null || !axc.moveToFirst()) {
            if (axc != null) {
                axc.close();
            }
            return linkedList;
        }
        do {
            b bVar = new b();
            bVar.d(axc);
            String str = bVar.cCT;
            String str2 = bVar.iconUrl;
            String str3 = bVar.category;
            String str4 = bVar.field_brandName;
            if (!(bi.oW(str3) || str3.equals("1") || str3.equals("0") || bi.oW(str4) || bi.oW(str) || bi.oW(str2))) {
                linkedList.add(bVar);
            }
        } while (axc.moveToNext());
        if (axc != null) {
            axc.close();
        }
        return linkedList;
    }

    public final b cA(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", new Object[]{str, str2});
            return null;
        }
        Cursor a = this.diF.a("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.d(a);
            a.close();
            return bVar;
        }
        x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:" + str);
        a.close();
        return null;
    }

    public final LinkedList<b> An(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        Cursor a = this.diF.a("HardDeviceInfo", null, "brandName=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return linkedList;
        }
        if (a.moveToFirst()) {
            do {
                b bVar = new b();
                bVar.d(a);
                linkedList.add(bVar);
            } while (a.moveToNext());
        }
        a.close();
        return linkedList;
    }

    public final LinkedList<b> aHK() {
        LinkedList<b> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.d(rawQuery);
                    linkedList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean cB(String str, String str2) {
        if (bi.oW(str)) {
            return false;
        }
        if (this.diF.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[]{str, str2}) <= 0) {
            x.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", new Object[]{str});
            return false;
        }
        x.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", new Object[]{str});
        return true;
    }

    public final int e(b bVar) {
        int update;
        ContentValues wH = bVar.wH();
        if (wH.size() > 0) {
            update = this.diF.update("HardDeviceInfo", wH, "deviceID = ? and deviceType = ? ", new String[]{bVar.field_deviceID, bVar.field_deviceType});
        } else {
            update = 0;
        }
        x.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", new Object[]{bVar.field_deviceID, bVar.field_deviceType, Integer.valueOf(update)});
        return update;
    }
}
