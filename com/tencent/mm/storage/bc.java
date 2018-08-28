package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class bc extends m {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )"};
    public e diF;

    protected final boolean Xu() {
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bc(com.tencent.mm.bt.h r14) {
        /*
        r13 = this;
        r12 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r11 = 2;
        r1 = 1;
        r4 = 0;
        r6 = 0;
        r13.<init>();
        r13.diF = r14;
        r7 = "MediaDuplication";
        r0 = r13.diF;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r3 = "PRAGMA table_info( ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r3 = " )";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r3 = 0;
        r5 = 2;
        r2 = r0.b(r2, r3, r5);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r0 = "name";
        r8 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0193 }
        r0 = r6;
        r3 = r6;
        r5 = r6;
    L_0x0037:
        r9 = r2.moveToNext();	 Catch:{ Exception -> 0x0193 }
        if (r9 == 0) goto L_0x0064;
    L_0x003d:
        if (r8 < 0) goto L_0x0037;
    L_0x003f:
        r9 = r2.getString(r8);	 Catch:{ Exception -> 0x0193 }
        r10 = "remuxing";
        r10 = r10.equalsIgnoreCase(r9);	 Catch:{ Exception -> 0x0193 }
        if (r10 == 0) goto L_0x004e;
    L_0x004c:
        r5 = r1;
        goto L_0x0037;
    L_0x004e:
        r10 = "duration";
        r10 = r10.equalsIgnoreCase(r9);	 Catch:{ Exception -> 0x0193 }
        if (r10 == 0) goto L_0x0059;
    L_0x0057:
        r3 = r1;
        goto L_0x0037;
    L_0x0059:
        r10 = "status";
        r9 = r10.equalsIgnoreCase(r9);	 Catch:{ Exception -> 0x0193 }
        if (r9 == 0) goto L_0x0037;
    L_0x0062:
        r0 = r1;
        goto L_0x0037;
    L_0x0064:
        r2.close();	 Catch:{ Exception -> 0x0193 }
        r2 = com.tencent.mm.kernel.g.Ei();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = r2.dqq;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r8 = java.lang.Thread.currentThread();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r8 = r8.getId();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r8 = r2.dO(r8);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        if (r5 != 0) goto L_0x008c;
    L_0x007b:
        r2 = "MicroMsg.MediaCheckDuplicationStorage";
        r5 = "it had no [remuxing] column, alter table now";
        com.tencent.mm.sdk.platformtools.x.i(r2, r5);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = "alter table MediaDuplication add remuxing text ";
        r5 = r13.diF;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r5.fV(r7, r2);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
    L_0x008c:
        if (r3 != 0) goto L_0x009f;
    L_0x008e:
        r2 = "MicroMsg.MediaCheckDuplicationStorage";
        r3 = "it had no [duration] column, alter table now";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = "alter table MediaDuplication add duration int ";
        r3 = r13.diF;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r3.fV(r7, r2);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
    L_0x009f:
        if (r0 != 0) goto L_0x00b2;
    L_0x00a1:
        r0 = "MicroMsg.MediaCheckDuplicationStorage";
        r2 = "it had no [status] column, alter table now";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r0 = "alter table MediaDuplication add status int ";
        r2 = r13.diF;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2.fV(r7, r0);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
    L_0x00b2:
        r2 = 0;
        r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00c1;
    L_0x00b8:
        r0 = com.tencent.mm.kernel.g.Ei();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r0 = r0.dqq;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r0.gp(r8);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
    L_0x00c1:
        r5 = "MediaDuplication";
        r2 = 0;
        r0 = r13.diF;	 Catch:{ Exception -> 0x014c, all -> 0x017c }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014c, all -> 0x017c }
        r8 = "SELECT count(*) from ";
        r7.<init>(r8);	 Catch:{ Exception -> 0x014c, all -> 0x017c }
        r7 = r7.append(r5);	 Catch:{ Exception -> 0x014c, all -> 0x017c }
        r7 = r7.toString();	 Catch:{ Exception -> 0x014c, all -> 0x017c }
        r8 = 0;
        r9 = 2;
        r7 = r0.b(r7, r8, r9);	 Catch:{ Exception -> 0x014c, all -> 0x017c }
        r0 = r7.moveToFirst();	 Catch:{ Exception -> 0x0186 }
        if (r0 == 0) goto L_0x0195;
    L_0x00e4:
        r0 = 0;
        r0 = r7.getInt(r0);	 Catch:{ Exception -> 0x0186 }
    L_0x00e9:
        r7.close();	 Catch:{ Exception -> 0x018a }
        if (r0 < r12) goto L_0x00f7;
    L_0x00ee:
        r7 = r13.diF;	 Catch:{ Exception -> 0x018d, all -> 0x017c }
        r8 = 0;
        r9 = 0;
        r2 = r7.delete(r5, r8, r9);	 Catch:{ Exception -> 0x018d, all -> 0x017c }
        r2 = (long) r2;
    L_0x00f7:
        r4 = "MicroMsg.MediaCheckDuplicationStorage";
        r5 = "MediaDuplication record[%d], max record[%d], deleteRecord[%d]";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r0 = java.lang.Integer.valueOf(r0);
        r7[r6] = r0;
        r0 = java.lang.Integer.valueOf(r12);
        r7[r1] = r0;
        r0 = java.lang.Long.valueOf(r2);
        r7[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r7);
        return;
    L_0x0116:
        r0 = move-exception;
        r2 = r4;
    L_0x0118:
        r3 = "MicroMsg.MediaCheckDuplicationStorage";
        r5 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0190 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r0, r5, r7);	 Catch:{ all -> 0x0190 }
        r3 = "MicroMsg.MediaCheckDuplicationStorage";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0190 }
        r7 = "tryAddDBCol error: ";
        r5.<init>(r7);	 Catch:{ all -> 0x0190 }
        r0 = r0.toString();	 Catch:{ all -> 0x0190 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x0190 }
        r0 = r0.toString();	 Catch:{ all -> 0x0190 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r0);	 Catch:{ all -> 0x0190 }
        if (r2 == 0) goto L_0x00c1;
    L_0x0140:
        r2.close();
        goto L_0x00c1;
    L_0x0145:
        r0 = move-exception;
    L_0x0146:
        if (r4 == 0) goto L_0x014b;
    L_0x0148:
        r4.close();
    L_0x014b:
        throw r0;
    L_0x014c:
        r5 = move-exception;
        r0 = r6;
        r7 = r4;
    L_0x014f:
        r4 = "MicroMsg.MediaCheckDuplicationStorage";
        r8 = "";
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0184 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r5, r8, r9);	 Catch:{ all -> 0x0184 }
        r4 = "MicroMsg.MediaCheckDuplicationStorage";
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0184 }
        r9 = "check to delete MediaDuplication. error : ";
        r8.<init>(r9);	 Catch:{ all -> 0x0184 }
        r5 = r5.toString();	 Catch:{ all -> 0x0184 }
        r5 = r8.append(r5);	 Catch:{ all -> 0x0184 }
        r5 = r5.toString();	 Catch:{ all -> 0x0184 }
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);	 Catch:{ all -> 0x0184 }
        if (r7 == 0) goto L_0x00f7;
    L_0x0177:
        r7.close();
        goto L_0x00f7;
    L_0x017c:
        r0 = move-exception;
        r7 = r4;
    L_0x017e:
        if (r7 == 0) goto L_0x0183;
    L_0x0180:
        r7.close();
    L_0x0183:
        throw r0;
    L_0x0184:
        r0 = move-exception;
        goto L_0x017e;
    L_0x0186:
        r4 = move-exception;
        r5 = r4;
        r0 = r6;
        goto L_0x014f;
    L_0x018a:
        r4 = move-exception;
        r5 = r4;
        goto L_0x014f;
    L_0x018d:
        r5 = move-exception;
        r7 = r4;
        goto L_0x014f;
    L_0x0190:
        r0 = move-exception;
        r4 = r2;
        goto L_0x0146;
    L_0x0193:
        r0 = move-exception;
        goto L_0x0118;
    L_0x0195:
        r0 = r6;
        goto L_0x00e9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.bc.<init>(com.tencent.mm.bt.h):void");
    }

    public final boolean y(String str, int i, String str2) {
        if (bi.oW(str2)) {
            x.e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
            return false;
        }
        if (i <= 0) {
            int cm = com.tencent.mm.a.e.cm(str2);
            if (cm <= 0) {
                x.e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(cm), str2});
                return false;
            }
            i = cm;
        }
        if (bi.oW(str)) {
            str = g.cu(str2);
            if (bi.oW(str)) {
                x.e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", new Object[]{str2});
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", str);
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("path", str2);
        contentValues.put("createtime", Long.valueOf(bi.VF()));
        contentValues.put("status", Integer.valueOf(s$l.AppCompatTheme_buttonStyleSmall));
        x.i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", new Object[]{Long.valueOf(this.diF.insert("MediaDuplication", "", contentValues)), Integer.valueOf(i), str, str2});
        return this.diF.insert("MediaDuplication", "", contentValues) > 0;
    }

    public final String de(String str, int i) {
        if (bi.oW(str) || i <= 0) {
            x.e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", new Object[]{str, Integer.valueOf(i)});
            return "";
        }
        Cursor b = this.diF.b("select path from MediaDuplication where md5 = '" + str + "' and  size = " + i + " and status != 100", null, 2);
        if (b == null) {
            x.e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", new Object[]{r1});
            return null;
        }
        String str2 = "";
        if (b.moveToNext()) {
            str2 = b.getString(0);
        }
        b.close();
        if (bi.oW(str2) || com.tencent.mm.a.e.cm(str2) > 0) {
            return str2;
        }
        x.w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", new Object[]{str2, Integer.valueOf(com.tencent.mm.a.e.cm(str2)), Integer.valueOf(i)});
        this.diF.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str, String.valueOf(i), "100"});
        return "";
    }

    public final boolean K(String str, String str2, int i) {
        if (bi.oW(str) || bi.oW(str2)) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", new Object[]{str, str2});
            return false;
        }
        int cm = com.tencent.mm.a.e.cm(str);
        int cm2 = com.tencent.mm.a.e.cm(str2);
        if (cm <= 0 || cm2 <= 0) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", new Object[]{Integer.valueOf(cm), Integer.valueOf(cm2)});
            return false;
        }
        String cu = g.cu(str);
        if (bi.oW(cu)) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + str + " size : " + cm);
            return false;
        }
        long VG = bi.VG();
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", cu);
        contentValues.put("size", Integer.valueOf(cm));
        contentValues.put("createtime", Long.valueOf(bi.VF()));
        contentValues.put("remuxing", str2);
        contentValues.put("duration", Integer.valueOf(i));
        contentValues.put("status", Integer.valueOf(100));
        x.i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", new Object[]{Long.valueOf(this.diF.insert("MediaDuplication", "", contentValues)), Integer.valueOf(cm), cu, str2, str, Integer.valueOf(i), Long.valueOf(bi.bI(VG))});
        return this.diF.insert("MediaDuplication", "", contentValues) > 0;
    }

    public final boolean a(String str, PString pString, PInt pInt) {
        if (bi.oW(str)) {
            x.d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
            return false;
        }
        int cm = com.tencent.mm.a.e.cm(str);
        if (cm <= 0) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : " + str);
            return false;
        }
        String cu = g.cu(str);
        if (bi.oW(cu)) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : " + str);
            return false;
        }
        String str2 = "select remuxing, duration from MediaDuplication  where md5 = '" + cu + "' AND  size = " + cm + " AND status = 100";
        long VG = bi.VG();
        Cursor cursor = null;
        try {
            cursor = this.diF.b(str2, null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                pString.value = cursor.getString(0);
                pInt.value = cursor.getInt(1);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e, "", new Object[0]);
            x.e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        if (bi.oW(pString.value)) {
            x.d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
            return false;
        } else if (com.tencent.mm.a.e.cm(pString.value) <= 0) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + pString.value);
            this.diF.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[]{cu, String.valueOf(cm), "100"});
            pString.value = null;
            return false;
        } else {
            x.i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", new Object[]{pString.value, Integer.valueOf(pInt.value), Long.valueOf(bi.bI(VG))});
            return true;
        }
    }
}
