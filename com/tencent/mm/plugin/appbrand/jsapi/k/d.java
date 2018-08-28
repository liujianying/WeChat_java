package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 105;
    private static final String NAME = "showToast";
    al eVk;
    View fXP;
    l.a fXQ = null;

    static /* synthetic */ boolean a(d dVar, FrameLayout frameLayout) {
        l bV = l.bV(frameLayout);
        if (bV == null) {
            x.e("MicroMsg.JsApiShowToast", "appBrandInputRootFrameLayout is null : the page may be destroy");
            return true;
        }
        View currentBottomPanel = bV.getCurrentBottomPanel();
        boolean z = currentBottomPanel != null && currentBottomPanel.isShown();
        x.i("MicroMsg.JsApiShowToast", "isKeyBoardShown:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            ((LinearLayout) dVar.fXP).setGravity(80);
            x.d("MicroMsg.JsApiShowToast", "bottomMargin:%d", new Object[]{Integer.valueOf((frameLayout.getHeight() / 2) - frameLayout.getScrollY())});
            dVar.kQ(r0);
        } else {
            ((LinearLayout) dVar.fXP).setGravity(17);
            dVar.kQ(0);
        }
        return false;
    }

    static /* synthetic */ void bK(View view) {
        if (view != null) {
            view.setVisibility(8);
            if (ViewGroup.class.isInstance(view.getParent())) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.l lVar, JSONObject jSONObject, int i) {
        boolean z = true;
        p d = e.d(lVar);
        if (d == null) {
            x.w("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
            lVar.E(i, f("fail", null));
            return;
        }
        x.i("MicroMsg.JsApiShowToast", "showToast:%s", new Object[]{jSONObject});
        int optInt = jSONObject.optInt("duration", 1500);
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("icon", "success");
        String optString3 = jSONObject.optString("image");
        boolean optBoolean = jSONObject.optBoolean("mask");
        if (!(bi.oW(optString2) && bi.oW(optString3))) {
            z = false;
        }
        if (this.fXQ == null) {
            this.fXQ = new 1(this, lVar);
        }
        ah.A(new 2(this, z, d, lVar, optInt, i, optBoolean, optString2, optString3, optString));
    }

    private void kQ(int i) {
        LinearLayout linearLayout = (LinearLayout) this.fXP.findViewById(g.show_toast_view_container);
        LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if (layoutParams == null) {
            x.w("MicroMsg.JsApiShowToast", "layoutParams is null");
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.bottomMargin = i;
        linearLayout.setLayoutParams(layoutParams);
    }
}
