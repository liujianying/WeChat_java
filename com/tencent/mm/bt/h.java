package com.tencent.mm.bt;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class h implements com.tencent.mm.sdk.e.e {
    String TAG = "MicroMsg.SqliteDB";
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private long gTh = 0;
    private a tdL = null;
    public a tdM = new a();
    private String tdN = "";
    public e tdO = null;
    public String tdP = "";
    final LinkedList<b> tdQ = new LinkedList();
    private ag tdR = null;
    protected f tdk = null;

    public interface a {
        /* renamed from: Ea */
        void aD();

        /* renamed from: Eb */
        void aD();

        /* renamed from: Ec */
        void aD();
    }

    public static class b {
        public long lastReportTime;
        public String table;
        public Cursor tdV;
        public String tdW;
        public long tdX;
        public boolean tdY;
        public String tdZ;
        public c tea;
    }

    private static class c extends AssertionError {
        c() {
        }

        c(String str) {
            super(str);
        }
    }

    public interface d {
        String[] xb();
    }

    public interface e {
        void Ed();
    }

    public h(a aVar) {
        this.tdL = aVar;
    }

    protected void finalize() {
        ex(null);
    }

    public void closeDB() {
        ex(null);
    }

    public void ex(String str) {
        if (this.tdk != null) {
            if (this.tdL != null) {
                this.tdL.aD();
            }
            x.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", Boolean.valueOf(inTransaction()), Long.toHexString(this.gTh), Long.valueOf(Thread.currentThread().getId()), bi.cjd());
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            if (str != null) {
                this.tdN = str;
            }
            this.tdk.close();
            this.tdk = null;
            x.d(this.TAG, "end close db time:%d", Long.valueOf(aVar.Ad()));
        }
    }

    public final boolean cjr() {
        return this.tdk == null || !this.tdk.isOpen();
    }

    private void ZL(String str) {
        String processName = ad.getProcessName();
        String packageName = ad.getPackageName();
        x.i(this.TAG, "check process :[%s] [%s] path[%s]", processName, packageName, str);
        if (processName != null && packageName != null && !packageName.equals(processName)) {
            Assert.assertTrue("processName:" + processName + "  packagename:" + packageName, false);
        }
    }

    public final boolean b(String str, HashMap<Integer, d> hashMap, boolean z) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        ZL(str);
        if (!this.tdM.a(str, (HashMap) hashMap, z) || this.tdM.tdk == null) {
            this.tdk = null;
            this.tdM = null;
            x.e(this.TAG, "initDB failed.");
            return false;
        }
        this.tdk = this.tdM.tdk;
        x.i(this.TAG, "SqliteDB db %s", this.tdk);
        return true;
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, d> hashMap, boolean z) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        ZL(str2);
        if (!this.tdM.a(str, str2, str3, j, str4, hashMap, z) || this.tdM.tdk == null) {
            this.tdP = this.tdM.getError();
            this.tdk = null;
            this.tdM = null;
            x.i(this.TAG, "initDB failed. %s", this.tdP);
            return false;
        }
        this.tdP = this.tdM.getError();
        this.tdk = this.tdM.tdk;
        return true;
    }

    public final boolean a(String str, String str2, long j, String str3, HashMap<Integer, d> hashMap) {
        return a(str, str2, "", j, str3, hashMap, true);
    }

    public final boolean isOpen() {
        if (this.tdk != null && this.tdk.isOpen()) {
            return true;
        }
        Assert.assertTrue("DB has been closed :[" + this.tdN + "]", bi.oW(this.tdN));
        return false;
    }

    public final String getKey() {
        if (this.tdM == null) {
            return null;
        }
        return this.tdM.aAL;
    }

    public final String getPath() {
        if (isOpen()) {
            return this.tdk.getPath();
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
        return null;
    }

    public static String fz(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return DatabaseUtils.sqlEscapeString(str);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return a(str, strArr, str2, strArr2, str3, str4, str5, 0);
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        if (isOpen()) {
            int cij;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayQuery;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                cij = g.Em().cij();
            } else {
                cij = 0;
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, cij, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionQuery, this.TAG);
            c.begin();
            Cursor a;
            try {
                a = this.tdk.a(str, strArr, str2, strArr2, str3, str4, str5, i);
                c.a(str, a, this.gTh);
                return a;
            } catch (Exception e) {
                f.mDy.a(181, 10, 1, false);
                x.e(this.TAG, "execSQL Error :" + e.getMessage());
                c.k(e);
                a = d.cnR();
                return a;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
            return d.cnR();
        }
    }

    public final Cursor b(final String str, String[] strArr, int i) {
        int i2 = 0;
        Assert.assertTrue("sql is null ", !bi.oW(str));
        if (isOpen()) {
            boolean z = HardCoderJNI.hcDBEnable;
            int i3 = HardCoderJNI.hcDBDelayQuery;
            int i4 = HardCoderJNI.hcDBCPU;
            int i5 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i2 = g.Em().cij();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i3, i4, i5, i2, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionQuery, this.TAG);
            c.begin();
            final Cursor b;
            try {
                b = this.tdk.b(str, strArr, i);
                if (com.tencent.mm.sdk.a.b.chn() || com.tencent.mm.sdk.a.b.chp()) {
                    if (this.tdR == null) {
                        HandlerThread Xs = com.tencent.mm.sdk.f.e.Xs("CheckCursor");
                        Xs.start();
                        this.tdR = new ag(Xs.getLooper());
                    }
                    final c cVar = new c();
                    this.tdR.postDelayed(new Runnable() {
                        public final void run() {
                            try {
                                long VF = bi.VF();
                                if (b != null && !b.isClosed()) {
                                    int intValue;
                                    String str;
                                    String str2;
                                    HashMap hashMap = new HashMap();
                                    int i = 0;
                                    c cVar = null;
                                    synchronized (h.this.tdQ) {
                                        Pair pair;
                                        c cVar2;
                                        Iterator it = h.this.tdQ.iterator();
                                        while (it.hasNext()) {
                                            b bVar = (b) it.next();
                                            if (bVar == null || bVar.tdV == null || bVar.tdV.isClosed()) {
                                                it.remove();
                                            } else {
                                                Pair pair2;
                                                if ((VF - bVar.lastReportTime) / 1000 > 100) {
                                                    bVar.lastReportTime = VF;
                                                    if (!bVar.tdY) {
                                                        x.w(h.this.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(VF - bVar.tdX), Integer.valueOf(bVar.tdV.hashCode()), bVar.tdW, Boolean.valueOf(bVar.tdY), bVar.tdZ);
                                                    } else if (TextUtils.isEmpty(bVar.tdZ)) {
                                                        x.w(h.this.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(VF - bVar.tdX), Integer.valueOf(bVar.tdV.hashCode()), bVar.tdW, Boolean.valueOf(bVar.tdY), bVar.tdZ);
                                                    } else {
                                                        x.w(h.this.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(VF - bVar.tdX), Integer.valueOf(bVar.tdV.hashCode()), bVar.tdW, Boolean.valueOf(bVar.tdY), bVar.tdZ);
                                                    }
                                                }
                                                pair = (Pair) hashMap.get(bVar.tdW);
                                                if (pair == null) {
                                                    pair = new Pair(Integer.valueOf(VF - bVar.tdX > 30000 ? 1 : 0), bVar);
                                                    hashMap.put(bVar.tdW, pair);
                                                    pair2 = pair;
                                                } else if (VF - bVar.tdX > 30000) {
                                                    Pair pair3 = new Pair(Integer.valueOf(((Integer) pair.first).intValue() + 1), pair.second);
                                                    hashMap.put(bVar.tdW, pair3);
                                                    pair2 = pair3;
                                                } else {
                                                    pair2 = pair;
                                                }
                                                if (i < ((Integer) pair2.first).intValue()) {
                                                    intValue = ((Integer) pair2.first).intValue();
                                                    cVar2 = ((b) pair2.second).tea;
                                                } else {
                                                    cVar2 = cVar;
                                                    intValue = i;
                                                }
                                                cVar = cVar2;
                                                i = intValue;
                                            }
                                        }
                                        x.d(h.this.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", Integer.valueOf(i), Integer.valueOf(h.this.tdQ.size()), Integer.valueOf(hashMap.size()));
                                        if (i <= (com.tencent.mm.sdk.a.b.chn() ? 20 : 50)) {
                                            if (h.this.tdQ.size() <= (com.tencent.mm.sdk.a.b.chn() ? 50 : 100)) {
                                            }
                                        }
                                        str = "";
                                        Iterator it2 = hashMap.keySet().iterator();
                                        while (true) {
                                            str2 = str;
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            str = (String) it2.next();
                                            pair = (Pair) hashMap.get(str);
                                            str = str2 + str + "," + pair.first + "," + ((b) pair.second).tdY + "," + ((b) pair.second).tdZ + ";";
                                        }
                                        if (cVar != null) {
                                            cVar2 = new c(str2);
                                            cVar2.setStackTrace(cVar.getStackTrace());
                                            throw cVar2;
                                        }
                                        throw new AssertionError(str2);
                                    }
                                    long VF2 = bi.VF();
                                    b bVar2 = new b();
                                    bVar2.tdV = b;
                                    bVar2.table = str;
                                    bVar2.tdX = VF;
                                    bVar2.tdW = "";
                                    bVar2.tdY = true;
                                    bVar2.tea = cVar;
                                    StackTraceElement[] stackTrace = cVar.getStackTrace();
                                    int i2 = 0;
                                    while (true) {
                                        intValue = i2;
                                        if (intValue >= stackTrace.length) {
                                            break;
                                        }
                                        Object obj;
                                        str = stackTrace[intValue].getClassName();
                                        String methodName = stackTrace[intValue].getMethodName();
                                        str2 = str.replace("com.tencent.mm.", "") + ":" + methodName + "(" + stackTrace[intValue].getLineNumber() + ")";
                                        Class cls = Class.forName(str);
                                        try {
                                            obj = cls.getDeclaredField("field_MARK_CURSOR_CHECK_IGNORE") != null ? 1 : null;
                                        } catch (Exception e) {
                                            obj = null;
                                        }
                                        if (obj == null) {
                                            if (!TextUtils.isEmpty(bVar2.tdW)) {
                                                if (!bVar2.tdY) {
                                                    break;
                                                }
                                                str = str2.toLowerCase();
                                                if (str.contains("cursor") || str.contains("adapter")) {
                                                    bVar2.tdZ = str2;
                                                }
                                            } else {
                                                bVar2.tdW = str2;
                                                boolean z = false;
                                                for (Method method : cls.getMethods()) {
                                                    if (method.getName().equals(methodName)) {
                                                        z = method.getReturnType().getName().contains(".Cursor");
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                bVar2.tdY = z;
                                            }
                                        }
                                        i2 = intValue + 1;
                                    }
                                    if (TextUtils.isEmpty(bVar2.tdW)) {
                                        bVar2.tdW = aj.b(stackTrace);
                                    }
                                    synchronized (h.this.tdQ) {
                                        h.this.tdQ.add(bVar2);
                                    }
                                    x.d(h.this.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", Long.valueOf(VF2 - VF), Long.valueOf(bi.bH(VF)), bVar2.tdW, Boolean.valueOf(bVar2.tdY), bVar2.tdZ);
                                }
                            } catch (Throwable e2) {
                                x.e(h.this.TAG, "checkCursor table:[%s] e:%s[%s]", str, e2.getMessage(), bi.i(e2));
                            }
                        }
                    }, 500);
                }
                c.a(str, b, this.gTh);
                return b;
            } catch (Exception e) {
                f.mDy.a(181, 10, 1, false);
                x.e(this.TAG, "execSQL Error :" + e.getMessage());
                c.k(e);
                b = d.cnR();
                return b;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
            return d.cnR();
        }
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        return b(str, strArr, 0);
    }

    public final boolean a(String str, String str2, String str3, List<String> list, ExecuteSqlCallback executeSqlCallback) {
        if (isOpen()) {
            return DBDumpUtil.doRecoveryDb(this.tdk.tdt, str, str2, str3, list, null, executeSqlCallback, true);
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
        return false;
    }

    public final long getPageSize() {
        return this.tdk.tdt.getPageSize();
    }

    public final f cnZ() {
        return this.tdk;
    }

    public final SQLiteDatabase coa() {
        f fVar = this.tdk;
        return fVar.tdt != null ? fVar.tdt : fVar.tdu;
    }

    public final boolean fV(String str, String str2) {
        Assert.assertTrue("sql is null ", !bi.oW(str2));
        if (isOpen()) {
            int cij;
            boolean z = HardCoderJNI.hcDBEnable;
            int i = HardCoderJNI.hcDBDelayWrite;
            int i2 = HardCoderJNI.hcDBCPU;
            int i3 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                cij = g.Em().cij();
            } else {
                cij = 0;
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i, i2, i3, cij, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                this.tdk.execSQL(str2);
                c.a(str2, null, this.gTh);
                return true;
            } catch (Exception e) {
                f.mDy.a(181, 11, 1, false);
                String message = e.getMessage();
                x.e(this.TAG, "execSQL Error :" + message);
                if (message != null && message.contains("no such table")) {
                    x.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", this.tdM.tdl);
                    com.tencent.mm.a.e.deleteFile(r1.tdl);
                    if (this.tdO != null) {
                        this.tdO.Ed();
                    }
                    Assert.assertTrue("clean ini cache and reboot", false);
                }
                c.k(e);
                return false;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
            return false;
        }
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        return a(str, str2, contentValues, false);
    }

    public final long a(String str, String str2, ContentValues contentValues, boolean z) {
        int i = 0;
        if (isOpen()) {
            long insert;
            boolean z2 = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Em().cij();
            }
            int startPerformance = HardCoderJNI.startPerformance(z2, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                insert = this.tdk.insert(str, str2, contentValues);
                c.a(str, null, this.gTh);
            } catch (Exception e) {
                f.mDy.a(181, 11, 1, false);
                x.e(this.TAG, "insert Error :" + e.getMessage());
                c.k(e);
                if (!z) {
                    return -1;
                }
                throw e;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
                return -1;
            }
            return insert;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
        return -2;
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        int i = 0;
        if (isOpen()) {
            int update;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Em().cij();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                update = this.tdk.update(str, contentValues, str2, strArr);
                c.a(str, null, this.gTh);
            } catch (Exception e) {
                f.mDy.a(181, 11, 1, false);
                x.e(this.TAG, "update Error :" + e.getMessage());
                c.k(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
                return -1;
            }
            return update;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
        return -2;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        int i = 0;
        if (isOpen()) {
            long replace;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Em().cij();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                replace = this.tdk.replace(str, str2, contentValues);
                c.a(str, null, this.gTh);
            } catch (Exception e) {
                f.mDy.a(181, 11, 1, false);
                x.e(this.TAG, "repalce  Error :" + e.getMessage());
                c.k(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
                return -1;
            }
            return replace;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
        return -2;
    }

    public final int delete(String str, String str2, String[] strArr) {
        int i = 0;
        if (isOpen()) {
            int delete;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Em().cij();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                delete = this.tdk.delete(str, str2, strArr);
                c.a(str, null, this.gTh);
            } catch (Exception e) {
                f.mDy.a(181, 11, 1, false);
                x.e(this.TAG, "delete Error :" + e.getMessage());
                c.k(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
                return -1;
            }
            return delete;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
        return -2;
    }

    public final boolean ZM(String str) {
        if (isOpen()) {
            try {
                this.tdk.execSQL("DROP TABLE " + str);
            } catch (Exception e) {
                f.mDy.a(181, 11, 1, false);
                x.e(this.TAG, "drop table Error :" + e.getMessage());
                c.k(e);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
        }
        return false;
    }

    public final synchronized long dO(long j) {
        long j2 = -1;
        synchronized (this) {
            x.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b  {%s}", Long.valueOf(j), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(this.gTh), Boolean.valueOf(isOpen()), bi.cjd());
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
                j2 = -4;
            } else if (this.gTh > 0) {
                x.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.gTh);
            } else if (ah.isMainThread() || j != -1) {
                try {
                    c.begin();
                    this.tdk.beginTransaction();
                    c.a("beginTrans", null, 0);
                    this.gTh = bi.VF() & 2147483647L;
                    this.gTh |= (r2 & 2147483647L) << 32;
                    if (this.tdL != null) {
                        this.tdL.aD();
                    }
                    j2 = this.gTh;
                } catch (Exception e) {
                    f.mDy.a(181, 8, 1, false);
                    x.e(this.TAG, "beginTransaction Error :" + e.getMessage());
                    c.k(e);
                    j2 = -3;
                }
            } else {
                x.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", Long.valueOf(j), Long.valueOf(r2));
                j2 = -2;
            }
        }
        return j2;
    }

    public final synchronized int gp(long j) {
        int i = 0;
        synchronized (this) {
            long VF = bi.VF();
            x.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(j), Long.valueOf(this.gTh), Boolean.valueOf(isOpen()), bi.cjd());
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
                i = -4;
            } else if (j != this.gTh) {
                x.e(this.TAG, "ERROR endTransaction ticket:" + j + " transactionTicket:" + this.gTh);
                i = -1;
            } else {
                if (((j >> 32) & 2147483647L) != r4) {
                    x.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", Long.toHexString(j), Long.valueOf((j >> 32) & 2147483647L), Long.valueOf(r4));
                    i = -2;
                } else {
                    try {
                        c.begin();
                        this.tdk.endTransaction();
                        x.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(bi.bH(VF)), Long.valueOf(r4), Long.valueOf(j), Long.valueOf(this.gTh), Boolean.valueOf(isOpen()), bi.cjd());
                        c.a("endTrans", null, 0);
                        this.gTh = 0;
                        if (this.tdL != null) {
                            this.tdL.aD();
                        }
                    } catch (Exception e) {
                        x.e(this.TAG, "endTransaction Error :" + e.getMessage());
                        f.mDy.a(181, 9, 1, false);
                        c.k(e);
                        i = -3;
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean inTransaction() {
        boolean z = false;
        synchronized (this) {
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.cjd());
            } else if (this.gTh > 0) {
                z = true;
            }
        }
        return z;
    }
}
