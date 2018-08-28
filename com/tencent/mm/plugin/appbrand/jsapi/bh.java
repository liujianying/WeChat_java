package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bh extends a {
    public static final int CTRL_INDEX = 198;
    public static final String NAME = "setNavigationBarColor";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        try {
            long vF = j.vF(jSONObject.getString("frontColor"));
            if (vF == -1) {
                throw new Exception();
            }
            int i2 = (int) vF;
            vF = j.vF(jSONObject.getString("backgroundColor"));
            if (vF == -1) {
                throw new Exception();
            }
            int i3 = (int) vF;
            double optDouble = jSONObject.optDouble("alpha", 1.0d);
            int i4 = 0;
            Object obj = "";
            JSONObject optJSONObject = jSONObject.optJSONObject("animation");
            if (optJSONObject != null) {
                i4 = optJSONObject.optInt("duration");
                obj = optJSONObject.optString("timingFunc");
            }
            p d = d(lVar);
            if (d == null) {
                lVar.E(i, f("fail:no page for now", null));
                return;
            }
            int backgroundColor = d.gnn.getBackgroundColor();
            int foregroundColor = d.gnn.getForegroundColor();
            double backgroundAlpha = d.gnn.getBackgroundAlpha();
            TimeInterpolator linearInterpolator = "linear".equals(obj) ? new LinearInterpolator() : "easeIn".equals(obj) ? new AccelerateInterpolator() : "easeOut".equals(obj) ? new DecelerateInterpolator() : "easeInOut".equals(obj) ? new AccelerateDecelerateInterpolator() : null;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{backgroundColor, i3});
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.setDuration((long) i4);
            valueAnimator.setInterpolator(linearInterpolator);
            valueAnimator.addUpdateListener(new 1(this, d));
            ValueAnimator valueAnimator2 = new ValueAnimator();
            valueAnimator2.setIntValues(new int[]{foregroundColor, i2});
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            valueAnimator2.setDuration((long) i4);
            valueAnimator2.setInterpolator(linearInterpolator);
            valueAnimator2.addUpdateListener(new 2(this, d));
            ValueAnimator valueAnimator3 = new ValueAnimator();
            valueAnimator3.setFloatValues(new float[]{(float) backgroundAlpha, (float) optDouble});
            valueAnimator3.setDuration((long) i4);
            valueAnimator3.setInterpolator(linearInterpolator);
            valueAnimator3.addUpdateListener(new 3(this, d));
            valueAnimator.start();
            valueAnimator2.start();
            lVar.E(i, f("ok", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
            lVar.E(i, f("fail", null));
        }
    }
}
