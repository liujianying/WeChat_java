package com.tencent.mm.plugin.j.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class b extends i<a> {
    public static final String[] ciG = new String[]{"CREATE  INDEX IF NOT EXISTS msgid_username_index ON WxFileIndex2 ( msgId,username,msgSubType ) ", "CREATE  INDEX IF NOT EXISTS username_type_index ON WxFileIndex2 ( username,msgtime,msgSubType ) "};
    public static final String[] diD = new String[]{i.a(a.dhO, "WxFileIndex2"), "DROP TABLE IF EXISTS WxFileIndex"};
    public e diF;

    public b(e eVar) {
        super(eVar, a.dhO, "WxFileIndex2", ciG);
        this.diF = eVar;
    }

    public final boolean delete() {
        long delete;
        try {
            delete = (long) this.diF.delete("WxFileIndex2", null, null);
        } catch (Exception e) {
            delete = 0;
        }
        return delete > 0;
    }

    public final long nC(int i) {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.diF.rawQuery("select sum(size)  from WxFileIndex2  where msgType=" + i, null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final long nD(int i) {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.diF.rawQuery("select count(*)  from WxFileIndex2  where msgType=" + i + " and size>0", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final long avB() {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.diF.rawQuery("select sum(size)  from WxFileIndex2 where msgSubType in (1,20,23,30,32,34 )", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Cursor avC() {
        Cursor cursor = null;
        try {
            return this.diF.rawQuery("select username,  sum(size) as total from WxFileIndex2 where size > 0  and msgSubType in (1,20,23,30,32,34 ) group by username order by total desc", null);
        } catch (Exception e) {
            return cursor;
        }
    }

    public final List<a> i(String str, long j, long j2) {
        long VG = bi.VG();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgSubType in (1,20,23,30,32,34 ) and size > 0  order by msgtime DESC,msgSubType ASC ";
        List<a> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.diF.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    a aVar = new a();
                    aVar.d(cursor);
                    arrayList.add(aVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", new Object[]{str2});
            x.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", new Object[]{str, Integer.valueOf(arrayList.size()), Long.valueOf(bi.bI(VG))});
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", new Object[]{str, Integer.valueOf(arrayList.size()), Long.valueOf(bi.bI(VG))});
        return arrayList;
    }

    public final List<a> j(String str, long j, long j2) {
        long VG = bi.VG();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgType in (43,62,44,3,49,268435505 ) order by msgtime DESC,msgSubType ASC ";
        List<a> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.diF.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    a aVar = new a();
                    aVar.d(cursor);
                    arrayList.add(aVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", new Object[]{str2});
            x.i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", new Object[]{str, Integer.valueOf(arrayList.size()), Long.valueOf(bi.bI(VG))});
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", new Object[]{str, Integer.valueOf(arrayList.size()), Long.valueOf(bi.bI(VG))});
        return arrayList;
    }

    public final List<a> O(bd bdVar) {
        Object obj = null;
        if (bdVar == null) {
            return obj;
        }
        String str = "select *, rowid from WxFileIndex2  where msgId=" + bdVar.field_msgId + " AND username='" + bdVar.field_talker + "' order by msgSubType ASC ";
        List<a> arrayList = new ArrayList();
        try {
            Cursor rawQuery = this.diF.rawQuery(str, null);
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.d(rawQuery);
                arrayList.add(aVar);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e) {
            if (obj != null) {
                obj.close();
            }
        } catch (Throwable th) {
            if (obj != null) {
                obj.close();
            }
        }
        return arrayList;
    }

    public final int aw(List<a> list) {
        if (list.isEmpty()) {
            return 0;
        }
        long VG = bi.VG();
        int i = 0;
        for (a a : list) {
            int i2;
            if (a(a, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        x.d("MicroMsg.WxFileIndexStorage", "insert list result[%d %d] cost[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(bi.bI(VG))});
        return i;
    }

    public final int ax(List<a> list) {
        if (list.isEmpty()) {
            return 0;
        }
        long VG = bi.VG();
        int i = 0;
        for (a aVar : list) {
            int i2;
            if (a(aVar.sKx, aVar, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        x.d("MicroMsg.WxFileIndexStorage", "update list result[%d %d] cost[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(bi.bI(VG))});
        return i;
    }
}
