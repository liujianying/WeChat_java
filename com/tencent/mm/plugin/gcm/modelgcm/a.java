package com.tencent.mm.plugin.gcm.modelgcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class a implements e {
    private static a khk;
    private Context context;
    private int khh = 3;
    private int khi = 0;
    private String khj = "";
    private com.google.android.gms.gcm.a khl;

    private a(Context context) {
        this.context = context;
    }

    public static a aVG() {
        x.i("GcmRegister", "GCM getInstance");
        if (khk != null) {
            return khk;
        }
        Context context = ad.getContext();
        if (context == null) {
            x.e("GcmRegister", "GCM appcontext null");
            return null;
        }
        a aVar = new a(context);
        khk = aVar;
        return aVar;
    }

    public final void aVH() {
        x.i("GcmRegister", "checkregister");
        aa.UX().postDelayed(new 1(this), 5000);
    }

    public final void aVI() {
        x.i("GcmRegister", "doRegist old regid[%s]", new Object[]{aVJ()});
        if (dG(this.context)) {
            this.khl = com.google.android.gms.gcm.a.al(this.context);
            if (bi.oW(r0) || aVK()) {
                x.i("GcmRegister", "doRegist registerInBackground as regid[%s] is null or expired", new Object[]{r0});
                new a(this).execute(new Void[]{null, null, null});
                return;
            }
            aVM();
            return;
        }
        x.i("GcmRegister", "Google Play Services Unavailable.");
        h.mEJ.k(11250, "2,0");
        f.mDy.a(452, 0, 1, false);
        if (aVO()) {
            aVJ();
            aVN();
        }
    }

    @SuppressLint({"NewApi"})
    public final String aVJ() {
        SharedPreferences aVL = aVL();
        String string = aVL.getString("registration_id", "");
        if (string.length() == 0) {
            x.i("GcmRegister", "registrationId not found.");
            f.mDy.a(452, 1, 1, false);
            return "";
        } else if (aVL.getInt("appVersion", Integer.MIN_VALUE) != dF(this.context)) {
            x.i("GcmRegister", "App version changed.");
            f.mDy.a(452, 2, 1, false);
            return "";
        } else {
            f.mDy.a(452, 4, 1, false);
            return string;
        }
    }

    final boolean aVK() {
        if (bi.bG(aVL().getLong("regtime", 0)) <= 259200) {
            return false;
        }
        x.i("GcmRegister", "gcm regid timeout[%d, %d]", new Object[]{Long.valueOf(bi.bG(aVL().getLong("regtime", 0))), Integer.valueOf(259200)});
        f.mDy.a(452, 3, 1, false);
        return true;
    }

    private SharedPreferences aVL() {
        return this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    }

    private static int dF(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            x.e("GcmRegister", "Could not get package name.");
            return i;
        }
    }

    public final void aVM() {
        f.mDy.a(452, 11, 1, false);
        int Df = aa.UZ().esl.Df();
        String aVJ = aVJ();
        if (bi.oW(aVJ)) {
            x.i("GcmRegister", "sendRegistrationIdToBackend regid is empty.");
            f.mDy.a(452, 13, 1, false);
        } else if (this.khi != 0 && Df == this.khi && aVJ.equals(this.khj)) {
            x.i("GcmRegister", "uin[%s][%s] already reg to weixin svr", new Object[]{Integer.valueOf(this.khi), bi.Xf(aVJ)});
            f.mDy.a(452, 12, 1, false);
        } else {
            this.khj = aVJ;
            x.i("GcmRegister", "regToWeixinServer [%s]", new Object[]{bi.Xf(this.khj)});
            try {
                new e(aVJ, Df).a(aa.UZ(), this);
                f.mDy.a(452, 14, 1, false);
            } catch (Throwable th) {
                f.mDy.a(452, 15, 1, false);
                x.e("GcmRegister", "NetScenePushReg doScene error:" + th.toString());
            }
        }
    }

    public final void aVN() {
        x.i("GcmRegister", "unregToWeixinServer");
        f.mDy.a(452, 18, 1, false);
        String aVJ = aVJ();
        if (bi.oW(aVJ)) {
            x.e("GcmRegister", "unregToWeixinServer regid is empty.");
            f.mDy.a(452, 19, 1, false);
        } else if (aVO()) {
            fB(false);
            try {
                new f(aVJ, aa.UZ().esl.Df()).a(aa.UZ(), this);
                f.mDy.a(452, 21, 1, false);
            } catch (Throwable th) {
                x.e("GcmRegister", "NetScenePushUnReg doScene error:" + th.toString());
                f.mDy.a(452, 22, 1, false);
            }
        } else {
            x.e("GcmRegister", "is not reg to Svr. no need unreg.");
            f.mDy.a(452, 20, 1, false);
        }
    }

    public final void aq(Context context, String str) {
        SharedPreferences aVL = aVL();
        int dF = dF(context);
        String string = aVL.getString("registration_id", "");
        x.i("GcmRegister", "Saving regId on app version[%s] regid[%s to %s] same[%b]", new Object[]{Integer.valueOf(dF), bi.Xf(string), bi.Xf(str), Boolean.valueOf(string.equals(str))});
        if (bi.oW(string)) {
            f.mDy.a(452, 37, 1, false);
        }
        if (bi.oW(str)) {
            f.mDy.a(452, 38, 1, false);
        }
        f.mDy.a(452, string.equals(str) ? 39 : 40, 1, false);
        Editor edit = aVL.edit();
        edit.putString("registration_id", str);
        edit.putInt("appVersion", dF);
        edit.putLong("regtime", bi.VE());
        edit.commit();
    }

    private void fB(boolean z) {
        SharedPreferences aVL = aVL();
        x.i("GcmRegister", "Saving regSvrResult: " + z);
        Editor edit = aVL.edit();
        edit.putBoolean("isRegToSvr", z);
        edit.commit();
        if (z) {
            this.khi = aa.UZ().esl.Df();
        } else {
            this.khi = 0;
        }
    }

    public final boolean aVO() {
        return aVL().getBoolean("isRegToSvr", false);
    }

    private static boolean dG(Context context) {
        try {
            if (Integer.valueOf(VERSION.SDK_INT).intValue() < 8) {
                return false;
            }
            int ae = com.google.android.gms.common.e.ae(context);
            if (ae == 0) {
                return true;
            }
            x.w("GcmRegister", "device not support GCM reason = " + ae);
            return false;
        } catch (Throwable th) {
            x.e("GcmRegister", th.toString());
            return false;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = false;
        x.i("GcmRegister", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        lVar.dJc = true;
        if (lVar != null) {
            if (lVar instanceof e) {
                if (i == 0 && i2 == 0) {
                    x.i("GcmRegister", "NetScenePushReg success.");
                    f.mDy.a(452, 16, 1, false);
                    z = true;
                } else {
                    x.i("GcmRegister", "NetScenePushReg faild.");
                    f.mDy.a(452, 17, 1, false);
                }
                fB(z);
            } else if (lVar instanceof f) {
                if (i == 0 && i2 == 0) {
                    x.i("GcmRegister", "NetScenePushUnReg success.");
                    f.mDy.a(452, 23, 1, false);
                } else {
                    x.e("GcmRegister", "NetScenePushUnReg faild.");
                    f.mDy.a(452, 24, 1, false);
                }
                fB(false);
            }
        }
    }
}
