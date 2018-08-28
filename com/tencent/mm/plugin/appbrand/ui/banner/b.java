package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import org.json.JSONArray;
import org.json.JSONException;

final class b {
    b() {
    }

    static boolean y(Intent intent) {
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(a.gxL.Ke());
        int intExtra = intent.getIntExtra(a.gxM.Ke(), 0);
        String stringExtra2 = intent.getStringExtra(a.gxN.Ke());
        String stringExtra3 = intent.getStringExtra(a.gxO.Ke());
        String stringExtra4 = intent.getStringExtra(a.gxP.Ke());
        for (a Ke : a.values()) {
            intent.removeExtra(Ke.Ke());
        }
        if (bi.oW(stringExtra) || bi.oW(stringExtra2)) {
            return false;
        }
        a(stringExtra, intExtra, stringExtra2, stringExtra3, stringExtra4);
        return true;
    }

    static boolean a(OperateTask operateTask) {
        if (operateTask == null || !g.Eg().Dx()) {
            return false;
        }
        BannerModel anZ = BannerModel.anZ();
        if (anZ == null || !anZ.appId.equals(operateTask.fVF) || anZ.fmv != operateTask.gyh) {
            return false;
        }
        a(anZ.appId, anZ.fmv, anZ.appName, anZ.fmD, operateTask.gyi);
        return true;
    }

    static void a(Intent intent, String str, int i, String str2, String str3, String str4) {
        if (intent != null) {
            intent.putExtra(a.gxL.Ke(), str);
            intent.putExtra(a.gxM.Ke(), i);
            intent.putExtra(a.gxN.Ke(), str2);
            intent.putExtra(a.gxO.Ke(), str3);
            intent.putExtra(a.gxP.Ke(), str4);
        }
    }

    private static void a(String str, int i, String str2, String str3, String str4) {
        if (g.Eg().Dx()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONArray.put(String.valueOf(i));
            jSONArray.put(str2);
            jSONArray.put(str3);
            jSONArray.put(bi.oV(str4));
            String jSONArray2 = jSONArray.toString();
            synchronized (b.class) {
                g.Ei().DT().a(a.sTS, jSONArray2);
            }
        }
    }

    private static Object[] anP() {
        if (!g.Eg().Dx()) {
            return null;
        }
        String str;
        synchronized (b.class) {
            str = (String) g.Ei().DT().get(a.sTS, "");
        }
        if (bi.oW(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != a.gxQ) {
                return null;
            }
            Object[] objArr = new Object[a.gxQ];
            for (int i = 0; i < a.gxQ; i++) {
                objArr[i] = jSONArray.optString(i, "");
            }
            objArr[a.gxM.ordinal()] = Integer.valueOf(bi.getInt((String) objArr[a.gxM.ordinal()], 0));
            return objArr;
        } catch (JSONException e) {
            return null;
        }
    }

    static BannerModel anQ() {
        Object[] anP = anP();
        if (anP == null) {
            return null;
        }
        BannerModel bannerModel = new BannerModel();
        bannerModel.appId = (String) anP[a.gxL.ordinal()];
        bannerModel.fmv = ((Integer) anP[a.gxM.ordinal()]).intValue();
        bannerModel.appName = (String) anP[a.gxN.ordinal()];
        bannerModel.fmD = (String) anP[a.gxO.ordinal()];
        bannerModel.gyo = (String) anP[a.gxP.ordinal()];
        return bannerModel;
    }
}
