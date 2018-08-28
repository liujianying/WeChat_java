package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class aa {
    private static aa etn;
    private static boolean etw = false;
    private static boolean hasInit = false;
    private t cWB;
    private ab eto;
    private ac etp;
    private Context etq;
    private a etr;
    private z ets;
    private y ett;
    private Looper etu;
    private w etv;
    private ag handler;

    private aa() {
    }

    private static aa UQ() {
        if (etn == null) {
            etn = new aa();
        }
        return etn;
    }

    private static SharedPreferences UR() {
        return ad.getContext().getSharedPreferences("notify_key_pref_no_account", 4);
    }

    public static SharedPreferences US() {
        String string = UR().getString("login_weixin_username", "");
        if (bi.oW(string)) {
            string = at.dBv.I("login_weixin_username", "");
            if (!bi.oW(string)) {
                UR().edit().putString("login_weixin_username", string).commit();
            }
        }
        if (string != null) {
            string = string.replace("[\\/\\\\]", "#").trim();
        }
        return ad.getContext().getSharedPreferences("notify_key_pref" + string, 4);
    }

    public static void UT() {
        if (!hasInit) {
            SharedPreferences US = US();
            long j = US.getLong("wakeup_alarm_last_tick", 0);
            int i = US.getInt("wakeup_alarm_last_cnt", 0);
            if (j == 0 || j > bi.VF()) {
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", Integer.valueOf(i));
                US.edit().putLong("wakeup_alarm_last_tick", bi.VF()).commit();
                US.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                return;
            } else if (bi.bH(j) > 86400000) {
                US.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
                US.edit().putLong("wakeup_alarm_last_tick", bi.VF()).commit();
                US.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", Integer.valueOf(i));
            } else {
                US.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", Integer.valueOf(i + 1));
            }
        }
        hasInit = true;
    }

    public static boolean UU() {
        String I = at.dBv.I("login_user_name", "");
        if (I != null) {
            I = I.replaceAll("[/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("notify_key_pref" + I, 4);
        x.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0)), Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_last_cnt", 0)));
        return (r0 > 10 ? 1 : 0) | (sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0) > 10 ? 1 : 0);
    }

    public static ab UV() {
        return UQ().eto;
    }

    public static void a(ab abVar) {
        UQ().eto = abVar;
    }

    public static ac UW() {
        return UQ().etp;
    }

    public static void a(ac acVar) {
        UQ().etp = acVar;
    }

    public static Context getContext() {
        return UQ().etq;
    }

    public static void setContext(Context context) {
        UQ().etq = context;
    }

    public static ag UX() {
        return UQ().handler;
    }

    public static void setHandler(ag agVar) {
        UQ().handler = agVar;
    }

    public static a UY() {
        return UQ().etr;
    }

    public static void a(a aVar) {
        UQ().etr = aVar;
    }

    public static t UZ() {
        return UQ().cWB;
    }

    public static void b(t tVar) {
        UQ().cWB = tVar;
    }

    public static z Va() {
        return UQ().ets;
    }

    public static void a(z zVar) {
        UQ().ets = zVar;
    }

    public static y Vb() {
        return UQ().ett;
    }

    public static void a(y yVar) {
        UQ().ett = yVar;
    }

    public static Looper Vc() {
        if (UQ().etu == null) {
            HandlerThread Xs = e.Xs("MMPushCore_handlerThread");
            Xs.start();
            UQ().etu = Xs.getLooper();
        }
        return UQ().etu;
    }

    public static w Vd() {
        return UQ().etv;
    }

    public static void a(w wVar) {
        UQ().etv = wVar;
    }

    public static void cb(boolean z) {
        UQ();
        etw = z;
    }

    public static boolean Ve() {
        UQ();
        return etw;
    }
}
