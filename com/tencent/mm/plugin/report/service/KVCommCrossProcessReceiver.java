package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver extends BroadcastReceiver {
    private static String className = "";
    private static Object lock = new Object();
    private static ag mEe;
    private static int mEf = 10000;
    private static volatile long mEg = 10000;
    private static volatile int mEh = -1;
    private static BroadCastData mEi = new BroadCastData();

    static /* synthetic */ void a(KVCommCrossProcessReceiver kVCommCrossProcessReceiver, Intent intent) {
        try {
            switch (s.a(intent, "type", 0)) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("INTENT_IDKEYGROUP");
                    if (bundleExtra != null) {
                        BroadCastData broadCastData = (BroadCastData) bundleExtra.getParcelable("BUNDLE_IDKEYGROUP");
                        ArrayList arrayList = broadCastData.mDX;
                        ArrayList arrayList2 = broadCastData.mDW;
                        x.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(broadCastData.mDV.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                            e.c(groupIDKeyDataInfo.mDY, groupIDKeyDataInfo.mDZ);
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it2.next();
                            e.b(stIDKeyDataInfo.mFa, stIDKeyDataInfo.key, stIDKeyDataInfo.value, stIDKeyDataInfo.mDZ);
                        }
                        it = r7.iterator();
                        while (it.hasNext()) {
                            KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                            e.a(kVReportDataInfo.mEv, kVReportDataInfo.value, kVReportDataInfo.mEw, kVReportDataInfo.mDZ);
                        }
                        break;
                    }
                    break;
                case 2:
                    x.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive TYPE_ONCRASHOREXCEPTION");
                    BaseEvent.onSingalCrash(0);
                    break;
            }
            if (k.bB(ad.getContext())) {
                new ag(Looper.myLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        if (k.bB(ad.getContext())) {
                            x.e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
                            x.chS();
                            BaseEvent.onSingalCrash(0);
                            Process.killProcess(Process.myPid());
                        }
                    }
                }, 5000);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "", new Object[0]);
        }
    }

    static {
        HandlerThread Xs = e.Xs("kv_report");
        Xs.start();
        mEe = new ag(Xs.getLooper()) {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    KVCommCrossProcessReceiver.brM();
                }
            }
        };
    }

    public void onReceive(Context context, final Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
        } else {
            mEe.post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", Long.valueOf(Thread.currentThread().getId()));
                    KVCommCrossProcessReceiver.a(KVCommCrossProcessReceiver.this, intent);
                }
            });
        }
    }

    public static void brK() {
        if (100 >= 0) {
            mEg = 100;
        }
    }

    public static void brL() {
        mEh = 1000;
    }

    private static void brM() {
        Parcelable broadCastData;
        synchronized (lock) {
            broadCastData = new BroadCastData(mEi);
            BroadCastData broadCastData2 = mEi;
            broadCastData2.mDV.clear();
            broadCastData2.mDW.clear();
            broadCastData2.mDX.clear();
        }
        ArrayList arrayList = broadCastData.mDX;
        ArrayList arrayList2 = broadCastData.mDW;
        ArrayList arrayList3 = broadCastData.mDV;
        if (k.bB(ad.getContext()) || !ad.cig()) {
            x.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                f.d(groupIDKeyDataInfo.mDY, groupIDKeyDataInfo.mDZ);
            }
            it = arrayList2.iterator();
            while (it.hasNext()) {
                StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it.next();
                f.d((int) stIDKeyDataInfo.mFa, (int) stIDKeyDataInfo.key, (int) stIDKeyDataInfo.value, stIDKeyDataInfo.mDZ);
            }
            it = arrayList3.iterator();
            while (it.hasNext()) {
                KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                f.b((int) kVReportDataInfo.mEv, kVReportDataInfo.value, kVReportDataInfo.mEw, kVReportDataInfo.mDZ);
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ad.getPackageName(), getClassName()));
        intent.putExtra("type", 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_IDKEYGROUP", broadCastData);
        intent.putExtra("INTENT_IDKEYGROUP", bundle);
        x.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
        try {
            ad.getContext().sendBroadcast(intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "sendBroadcastMessageDirectly", new Object[0]);
        }
    }

    private static String getClassName() {
        if (bi.oW(className)) {
            className = ad.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
        }
        return className;
    }

    public static void a(KVReportDataInfo kVReportDataInfo) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, isImportant: %b,isReportNow: %b", Long.valueOf(kVReportDataInfo.mEv), Boolean.valueOf(kVReportDataInfo.mDZ), Boolean.valueOf(kVReportDataInfo.mEw));
        synchronized (lock) {
            mEi.mDV.add(kVReportDataInfo);
        }
        if (mEg == 0) {
            brM();
        } else if (!mEe.hasMessages(1)) {
            mEe.sendEmptyMessageDelayed(1, mEg);
        }
    }

    public static void a(StIDKeyDataInfo stIDKeyDataInfo) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", Long.valueOf(stIDKeyDataInfo.mFa), Long.valueOf(stIDKeyDataInfo.key), Long.valueOf(stIDKeyDataInfo.value), Boolean.valueOf(stIDKeyDataInfo.mDZ));
        synchronized (lock) {
            mEi.mDW.add(stIDKeyDataInfo);
        }
        if (mEg == 0 || brN()) {
            brM();
        } else if (!mEe.hasMessages(1)) {
            mEe.sendEmptyMessageDelayed(1, mEg);
        }
    }

    public static void K(ArrayList<IDKey> arrayList) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", Integer.valueOf(arrayList.size()), Boolean.valueOf(false));
        synchronized (lock) {
            BroadCastData broadCastData = mEi;
            broadCastData.mDX.add(new GroupIDKeyDataInfo((ArrayList) arrayList));
        }
        if (mEg == 0 || brN()) {
            brM();
        } else if (!mEe.hasMessages(1)) {
            mEe.sendEmptyMessageDelayed(1, mEg);
        }
    }

    private static boolean brN() {
        if (mEh <= 0 || mEi == null) {
            return false;
        }
        try {
            if ((mEi.mDW.size() + mEi.mDX.size()) + mEi.mDV.size() >= mEh) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", e);
            return false;
        }
    }

    public static void brO() {
        if (k.bB(ad.getContext()) || !ad.cig()) {
            x.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ad.getPackageName(), getClassName()));
        intent.putExtra("type", 2);
        ad.getContext().sendBroadcast(intent);
    }

    public static void brP() {
        if (mEe != null) {
            mEe.removeMessages(1);
            mEe.handleMessage(mEe.obtainMessage(1));
        }
    }
}
