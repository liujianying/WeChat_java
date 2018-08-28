package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.game.m;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class ag extends n {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";
    private float fFS = -1.0f;

    public final String a(l lVar, JSONObject jSONObject) {
        int[] iArr;
        HashMap hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        hashMap.put("pixelRatio", Float.valueOf(lVar.getContext().getResources().getDisplayMetrics().density));
        if (e(lVar) != null) {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: normal");
            iArr = new int[]{e(lVar).getWidth(), e(lVar).getHeight()};
        } else if (lVar.getContext() instanceof Activity) {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: DecorView");
            lVar.getContext().getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            iArr = new int[]{r2.right - r2.left, (r2.bottom - r2.top) - a.fromDPToPix(lVar.getContext(), 48)};
        } else {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: Screen");
            iArr = new int[]{lVar.getContext().getResources().getDisplayMetrics().widthPixels, lVar.getContext().getResources().getDisplayMetrics().heightPixels};
        }
        hashMap.put("windowWidth", Integer.valueOf(f.lO(iArr[0])));
        hashMap.put("windowHeight", Integer.valueOf(f.lO(iArr[1])));
        if (lVar.fdO == null || !lVar.fdO.aaq()) {
            hashMap.put("screenWidth", Integer.valueOf(f.lO(lVar.getContext().getResources().getDisplayMetrics().widthPixels)));
            hashMap.put("screenHeight", Integer.valueOf(f.lO(lVar.getContext().getResources().getDisplayMetrics().heightPixels)));
        } else {
            Point point = new Point();
            m.fAw.d(point);
            hashMap.put("screenWidth", Integer.valueOf(f.lO(point.x)));
            hashMap.put("screenHeight", Integer.valueOf(f.lO(point.y)));
        }
        int aa = com.tencent.mm.ui.statusbar.a.aa(lVar.getContext());
        if (aa == 0) {
            aa = s.gJ(lVar.getContext());
        }
        hashMap.put("statusBarHeight", Integer.valueOf(f.lO(aa)));
        hashMap.put("language", w.fD(lVar.getContext()));
        hashMap.put("version", e.aj(null, d.qVN));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        hashMap.put("benchmarkLevel", Integer.valueOf(lVar.fdO.fcu.frl));
        if (this.fFS != -1.0f) {
            hashMap.put("fontSizeSetting", Integer.valueOf((int) (this.fFS * 16.0f)));
        } else {
            float f = MultiProcessSharedPreferences.getSharedPreferences(lVar.getContext(), ad.chY(), 0).getFloat("text_size_scale_key", 1.0f);
            hashMap.put("fontSizeSetting", Integer.valueOf((int) (f * 16.0f)));
            this.fFS = f;
        }
        return f("ok", hashMap);
    }

    private static View e(l lVar) {
        p d = d(lVar);
        return d == null ? null : d.aha();
    }
}
