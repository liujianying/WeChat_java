package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ObjectAnimator;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.5;
import org.json.JSONObject;

public final class bo extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "showTabBar";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.page.l currentPage = lVar.fdO.fcz.getCurrentPage();
        if (currentPage instanceof e) {
            int i2;
            c tabBar = ((e) currentPage).getTabBar();
            boolean optBoolean = jSONObject.optBoolean("animation", true);
            String str = "translationY";
            float[] fArr = new float[2];
            int height = tabBar.getHeight();
            if ("top".equals(tabBar.gEi)) {
                i2 = -1;
            } else {
                i2 = 1;
            }
            fArr[0] = (float) (i2 * height);
            fArr[1] = 0.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tabBar, str, fArr);
            ofFloat.setDuration(optBoolean ? 250 : 0);
            tabBar.post(new 5(tabBar, ofFloat));
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("fail:not TabBar page", null));
    }
}
