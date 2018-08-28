package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.avj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class e {
    private static boolean mDt = false;
    private static Map<Long, Long> mEr;
    private static a mEs = new a();
    private static int mEt = -1;
    private static boolean mEu = false;

    public static void a(long j, String str, boolean z, boolean z2) {
        if (z2) {
            try {
                SmcLogic.writeImportKvData(j, str, z);
            } catch (Throwable e) {
                x.e("MicroMsg.KVEasyReport", "localReport :%s", bi.i(e));
            }
        } else {
            try {
                SmcLogic.writeKvData(j, str, z);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.KVEasyReport", e2, "", new Object[0]);
                if (d.fS(20)) {
                    SmcLogic.writeKvData(j, str, z);
                }
            }
        }
        if (mDt) {
            j brV = j.brV();
            if (brV.mDt && brV.mFb != null) {
                List linkedList;
                x.v("MicroMsg.SubCoreReport", "put kv info [%d %s]", Long.valueOf(j), str);
                List list = (List) brV.mFb.get(String.valueOf(j));
                boolean z3 = false;
                if (list == null) {
                    linkedList = new LinkedList();
                } else {
                    d dVar = (d) list.get(list.size() - 1);
                    z3 = bi.bH(dVar.mEo) < 1000;
                    if (z3) {
                        dVar.mEq = true;
                    }
                    linkedList = list;
                }
                linkedList.add(0, new d(j, str, bi.VF(), z3));
                brV.mFb.put(String.valueOf(j), linkedList);
            }
        }
    }

    public static void a(long j, byte[] bArr, boolean z, boolean z2) {
        if (z2) {
            try {
                SmcLogic.writeImportKvPbData(j, bArr, z);
                return;
            } catch (Throwable e) {
                x.e("MicroMsg.KVEasyReport", "localReport :%s", bi.i(e));
                return;
            }
        }
        SmcLogic.writeKvPbData(j, bArr, z);
    }

    public static void b(long j, long j2, long j3, boolean z) {
        long j4 = j;
        do {
            int i;
            String str = "MicroMsg.KVEasyReport";
            String str2 = "SmcLogic.reportIDKey class loader %s, %s ";
            Object[] objArr = new Object[2];
            if (e.class.getClassLoader() == null) {
                i = -1;
            } else {
                i = e.class.getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(i);
            if (Thread.currentThread().getContextClassLoader() == null) {
                i = -1;
            } else {
                i = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            try {
                SmcLogic.reportIDKey(j4, j2, j3, z);
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.fS(20)) {
                    SmcLogic.reportIDKey(j4, j2, j3, z);
                }
            }
            if (mEu) {
                if (mEr == null) {
                    brQ();
                }
                j4 = bi.a((Long) mEr.get(Long.valueOf(j4)), 0);
            } else {
                return;
            }
        } while (j4 > 0);
    }

    public static void c(ArrayList<IDKey> arrayList, boolean z) {
        if (arrayList != null) {
            try {
                SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.fS(20)) {
                    SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
                }
            }
        }
    }

    public static void ht(boolean z) {
        x.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", Boolean.valueOf(mEu), Boolean.valueOf(z), bi.cjd());
        mEu = z;
    }

    public static synchronized void brQ() {
        synchronized (e.class) {
            if (mEr == null) {
                mEr = new HashMap(20);
            }
            amj brI = a.brI();
            if (!(brI == null || brI.rOY == mEt)) {
                mEt = brI.rOY;
                mEr.clear();
                LinkedList linkedList = brI.rOZ;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        avj avj = (avj) it.next();
                        mEr.put(new Long((long) avj.rYf), new Long((long) avj.rYg));
                    }
                }
            }
            x.i("MicroMsg.KVEasyReport", "summerhv reloadHeavyUserIDMap heavyUserIDMap[%d][%d][%s], stack[%s]", Integer.valueOf(mEt), Integer.valueOf(mEr.size()), mEr, bi.cjd());
        }
    }

    public static void hr(boolean z) {
        mDt = z;
    }
}
