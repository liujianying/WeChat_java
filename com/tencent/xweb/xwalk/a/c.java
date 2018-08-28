package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.xweb.xwalk.a.a.a;
import com.tencent.xweb.xwalk.a.a.b;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class c {
    static c vFw;
    static a vFx;

    private c() {
    }

    public static synchronized c cJo() {
        c cVar;
        synchronized (c.class) {
            if (vFw == null) {
                vFw = new c();
            }
            cVar = vFw;
        }
        return cVar;
    }

    public static void Iy(int i) {
        if (NetworkUtil.isNetworkAvailable()) {
            SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
            int i2 = sharedPreferencesForUpdateConfig.getInt("nTryCnt", 0) + 1;
            if (i <= -2 && i >= -5) {
                i2 += 3;
            }
            if (i2 > 3) {
                XWalkInitializer.addXWalkInitializeLog("FailedTooManytimes at this version");
                XWalkInitializer.addXWalkInitializeLog("abandon Current Scheduler");
                a(null);
                return;
            }
            cJv().vFC = i2;
            Editor edit = sharedPreferencesForUpdateConfig.edit();
            edit.putInt("nTryCnt", i2);
            a(edit, i2);
            edit.commit();
        }
    }

    private static synchronized void a(Editor editor, int i) {
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis() + ((long) (7200000 * i));
            XWalkInitializer.addXWalkInitializeLog("rescheduler update time after " + ((7200000 * i) / 60000) + " minute");
            editor.putLong("nTimeToUpdate", currentTimeMillis);
        }
    }

    public static a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        a cJv = cJv();
        if (cJv == null || cJv.vFl == aVar.vFl) {
            return null;
        }
        com.tencent.xweb.xwalk.a.a.c cVar;
        int i;
        cJv = new a();
        if (aVar == null || aVar.vFm == null || aVar.vFm.length == 0) {
            cVar = null;
        } else {
            i = VERSION.SDK_INT;
            for (com.tencent.xweb.xwalk.a.a.c cVar2 : aVar.vFm) {
                if (cVar2 != null) {
                    if (cVar2.vFr >= 49) {
                        if (cVar2.vFr > XWalkEnvironment.getAvailableVersion()) {
                            if (cVar2.vCo.cID()) {
                                cVar = cVar2;
                                break;
                            }
                            XWalkInitializer.addXWalkInitializeLog("no matched version  filter retunr false");
                        } else {
                            XWalkInitializer.addXWalkInitializeLog("no matched version  getAvailableVersion above ");
                        }
                    } else {
                        XWalkInitializer.addXWalkInitializeLog("no matched version  below min support apk version ");
                    }
                } else {
                    XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
                }
            }
            XWalkInitializer.addXWalkInitializeLog("no matched version");
            cVar = null;
        }
        if (cVar == null || cVar.vFr <= XWalkEnvironment.getAvailableVersion()) {
            XWalkInitializer.addXWalkInitializeLog("no matched version");
            cJv = null;
        } else {
            XWalkInitializer.addXWalkInitializeLog("got matched version");
            cJv.vFl = aVar.vFl;
            cJv.vFk = cVar.vFk;
            cJv.vFr = cVar.vFr;
            cJv.vFB = cVar.vFu.vFv;
            cJv.vFq = cVar.vFq;
            cJv.bUseCdn = cVar.bUseCdn;
            if (cVar.vFt != null) {
                for (b bVar : cVar.vFt) {
                    if (bVar.vFo == XWalkEnvironment.getAvailableVersion()) {
                        XWalkInitializer.addXWalkInitializeLog("got matched patch");
                        break;
                    }
                }
            }
            XWalkInitializer.addXWalkInitializeLog("no matched patch");
            b bVar2 = null;
            if (bVar2 != null) {
                cJv.vFz = true;
                cJv.vFp = bVar2.vFp;
                cJv.bxD = bVar2.vFk;
                cJv.vFq = bVar2.vFq;
                cJv.bUseCdn = bVar2.bUseCdn;
            } else {
                cJv.vFz = false;
                cJv.vFp = cVar.vFp;
            }
            i = (int) (Math.random() * ((double) cVar.vFs));
            cJv.vFA = ((long) ((i * 60) * TbsLog.TBSLOG_CODE_SDK_BASE)) + System.currentTimeMillis();
            XWalkInitializer.addXWalkInitializeLog("schedul after " + i + " minute to update");
        }
        if (cJv == null) {
            return null;
        }
        a(cJv);
        return cJv;
    }

    public static boolean cJp() {
        if (!cJq()) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("has scheduler for update");
        return true;
    }

    public static synchronized boolean cJq() {
        boolean z = false;
        synchronized (c.class) {
            if (!(cJv() == null || cJv().vFp == null || cJv().vFp.isEmpty())) {
                if (cJv().vFr > XWalkEnvironment.getAvailableVersion()) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized boolean cJr() {
        boolean z = false;
        synchronized (this) {
            if (cJq()) {
                if (System.currentTimeMillis() >= cJv().vFA) {
                    XWalkInitializer.addXWalkInitializeLog("time to update");
                    z = true;
                } else {
                    XWalkInitializer.addXWalkInitializeLog("has scheduler waiting for update, but time is not up");
                }
            }
        }
        return z;
    }

    public final synchronized void cJs() {
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.putLong("nTimeToUpdate", 0);
        edit.commit();
        cJv().vFy = 0;
        cJv().vFA = 0;
    }

    public static synchronized void a(a aVar) {
        synchronized (c.class) {
            vFx = aVar;
            if (aVar == null) {
                vFx = new a();
            }
            Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
            edit.putString("strMd5", vFx.vFk);
            edit.putString("strUrl", vFx.vFp);
            edit.putString("strConfigVer", vFx.vFl);
            edit.putBoolean("bIsPatchUpdate", vFx.vFz);
            edit.putBoolean("bCanUseCellular", vFx.vFq);
            edit.putBoolean("bUseCdn", vFx.bUseCdn);
            edit.putLong("nTimeToUpdate", vFx.vFA);
            edit.putInt("nApkVer", vFx.vFr);
            edit.putInt("nTryCnt", vFx.vFC);
            edit.putString("strPatchMd5", vFx.bxD);
            edit.putString("strVersionDetail", vFx.vFB);
            edit.commit();
        }
    }

    public static void cJt() {
        cJv().vFy = System.currentTimeMillis();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", cJv().vFy);
        edit.commit();
    }

    private static boolean M(long j, long j2) {
        if (j > j2 + 86400000 || j + 86400000 < j2) {
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("the most recent time to fetch config is too close");
        return false;
    }

    public static boolean cJu() {
        if (cJq()) {
            XWalkInitializer.addXWalkInitializeLog("has scheduler , don't need to fetch config");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!M(currentTimeMillis, cJv().vFy)) {
            return false;
        }
        long j = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getLong("nLastFetchConfigTime", 0);
        cJv().vFy = j;
        if (!M(currentTimeMillis, j)) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("enough time after last time fetch config");
        return true;
    }

    public static a cJv() {
        if (vFx != null) {
            return vFx;
        }
        vFx = new a();
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        vFx.vFy = sharedPreferencesForUpdateConfig.getLong("nLastFetchConfigTime", 0);
        if (!sharedPreferencesForUpdateConfig.contains("strUrl")) {
            return vFx;
        }
        vFx.vFk = sharedPreferencesForUpdateConfig.getString("strMd5", null);
        vFx.vFp = sharedPreferencesForUpdateConfig.getString("strUrl", null);
        vFx.vFl = sharedPreferencesForUpdateConfig.getString("strConfigVer", null);
        vFx.vFz = sharedPreferencesForUpdateConfig.getBoolean("bIsPatchUpdate", false);
        vFx.vFA = sharedPreferencesForUpdateConfig.getLong("nTimeToUpdate", 0);
        vFx.vFr = sharedPreferencesForUpdateConfig.getInt("nApkVer", 0);
        vFx.vFC = sharedPreferencesForUpdateConfig.getInt("nTryCnt", 0);
        vFx.bxD = sharedPreferencesForUpdateConfig.getString("strPatchMd5", null);
        vFx.vFB = sharedPreferencesForUpdateConfig.getString("strVersionDetail", null);
        vFx.vFq = sharedPreferencesForUpdateConfig.getBoolean("bCanUseCellular", false);
        vFx.bUseCdn = sharedPreferencesForUpdateConfig.getBoolean("bUseCdn", false);
        return vFx;
    }
}
