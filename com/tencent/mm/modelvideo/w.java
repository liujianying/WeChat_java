package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class w {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS VideoPlayHistory ( filename text PRIMARY KEY, starttime int, playduration int, downloadway int );"};
    e diF;

    public w(h hVar) {
        this.diF = hVar;
    }

    public final boolean oc(String str) {
        Cursor cursor;
        Cursor query;
        Throwable e;
        if (bi.oW(str)) {
            return false;
        }
        cursor = null;
        try {
            query = this.diF.query("VideoPlayHistory", new String[]{"filename"}, "filename=?", new String[]{bi.oU(str)}, "", "", "");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th) {
            e = th;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        return false;
        try {
            x.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
    }

    public final boolean b(String str, PInt pInt, PInt pInt2) {
        boolean z;
        Throwable e;
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.diF.a("VideoPlayHistory", new String[]{"starttime", "playduration"}, "filename=?", new String[]{bi.oU(str)}, "", "", "", 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        pInt.value = a.getInt(a.getColumnIndex("starttime"));
                        pInt2.value = a.getInt(a.getColumnIndex("playduration"));
                        z = true;
                        if (a != null) {
                            a.close();
                        }
                        x.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
                        if (a != null) {
                            a.close();
                            z = false;
                        } else {
                            z = false;
                        }
                        x.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        return z;
                    } catch (Throwable th) {
                        e = th;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            z = false;
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        x.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
        return z;
    }
}
