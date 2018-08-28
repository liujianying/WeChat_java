package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.xweb.xwalk.a.f.a;
import java.io.File;
import java.util.HashMap;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;

public final class e extends AsyncTask<String, Integer, Integer> {
    private static String vFH = "0";
    static XWalkUpdater vFj;
    private HashMap<String, String> vFG;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        r2 = com.tencent.xweb.xwalk.a.c.cJo();
        r2 = r2.cJr();
        if (r2 == 0) goto L_0x0020;
    L_0x000c:
        r2 = "time to update";
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = r0;
    L_0x0013:
        if (r2 == 0) goto L_0x0022;
    L_0x0015:
        r2 = cJx();
        if (r2 != 0) goto L_0x0041;
    L_0x001b:
        r0 = java.lang.Integer.valueOf(r0);
    L_0x001f:
        return r0;
    L_0x0020:
        r2 = r1;
        goto L_0x0013;
    L_0x0022:
        r2 = com.tencent.xweb.xwalk.a.c.cJu();
        if (r2 == 0) goto L_0x003f;
    L_0x0028:
        com.tencent.xweb.xwalk.a.c.cJo();
        r2 = com.tencent.xweb.xwalk.a.c.cJp();
        if (r2 != 0) goto L_0x003f;
    L_0x0031:
        r2 = cJx();
        if (r2 != 0) goto L_0x003f;
    L_0x0037:
        if (r0 == 0) goto L_0x0041;
    L_0x0039:
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x001f;
    L_0x003f:
        r0 = r1;
        goto L_0x0037;
    L_0x0041:
        r0 = java.lang.Integer.valueOf(r1);
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.e.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 1) {
            b(c.cJv());
        } else if (num.intValue() == 2) {
            if (NetworkUtil.isNetworkAvailable()) {
                XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew begin!!");
                a aVar = new a();
                aVar.mUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
                aVar.mFilePath = XWalkEnvironment.getUpdateConfigDir() + File.separator + "updateConfg.xml";
                aVar.vFN = true;
                c.cJt();
                com.tencent.xweb.util.e.cIZ();
                1 1 = new 1();
                f fVar = new f();
                fVar.vFI = 1;
                fVar.vFJ = aVar;
                fVar.vFK = 0;
                fVar.vFL = System.currentTimeMillis();
                fVar.execute(new a[]{fVar.vFJ});
            } else {
                XWalkEnvironment.addXWalkInitializeLog("network not available!!");
            }
        }
        super.onPostExecute(num);
    }

    public e(XWalkUpdater xWalkUpdater, HashMap<String, String> hashMap) {
        vFj = xWalkUpdater;
        this.vFG = hashMap;
        if (hashMap != null) {
            String str = (String) hashMap.get("UpdaterCheckType");
            vFH = str;
            if (str == null || !vFH.equals("1")) {
                vFH = "0";
            } else {
                c.cJo().cJs();
            }
        }
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + vFH);
    }

    private static boolean b(c.a aVar) {
        if (cJx() || !NetworkUtil.isNetworkAvailable()) {
            return false;
        }
        if (!aVar.vFq && !NetworkUtil.isWifiAvailable()) {
            XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
            return false;
        } else if (!vFj.updateXWalkRuntime(aVar.cJw())) {
            return false;
        } else {
            cJy();
            return true;
        }
    }

    public static boolean cJx() {
        int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("UpdatingProcessId", -1);
        if (i == Process.myPid()) {
            XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
            return true;
        } else if (i < 0) {
            return false;
        } else {
            ActivityManager activityManager = (ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService("activity");
            Process.myPid();
            int myUid = Process.myUid();
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i) {
                    if (runningAppProcessInfo.uid == myUid) {
                        XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
                        return true;
                    }
                    cJz();
                    return false;
                }
            }
            cJz();
            return false;
        }
    }

    public static void cJy() {
        int myPid = Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putInt("UpdatingProcessId", myPid);
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("start updating progress");
    }

    public static void cJz() {
        Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.remove("UpdatingProcessId");
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("finish updating progress");
    }

    public static void cJA() {
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        cJz();
        c.a(null);
    }

    public static void Iy(int i) {
        cJz();
        c.Iy(i);
    }

    static void c(c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!XWalkEnvironment.hasAvailableVersion()) {
            XWalkInitializer.addXWalkInitializeLog("no availableversion installed, do start download ");
            b(aVar);
        } else if (aVar.vFA <= System.currentTimeMillis()) {
            b(aVar);
        }
    }
}
