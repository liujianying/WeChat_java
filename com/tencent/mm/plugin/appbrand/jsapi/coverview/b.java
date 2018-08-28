package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends c {
    public static final int CTRL_INDEX = 342;
    public static final String NAME = "animateCoverView";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean a(p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("finalStyle");
            float a = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject2, "left", com.tencent.mm.plugin.appbrand.q.f.ad(view.getX()));
            float a2 = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject2, "top", com.tencent.mm.plugin.appbrand.q.f.ad(view.getY()));
            float optDouble = (float) jSONObject2.optDouble("opacity", (double) view.getAlpha());
            float optDouble2 = (float) jSONObject2.optDouble("rotate", (double) view.getRotation());
            float optDouble3 = (float) jSONObject2.optDouble("scaleX", (double) view.getScaleX());
            float optDouble4 = (float) jSONObject2.optDouble("scaleY", (double) view.getScaleY());
            int optInt = jSONObject.optInt("duration", l.CTRL_BYTE);
            String optString = jSONObject.optString("easing", "linear");
            View view2 = view;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "x", new float[]{view.getX(), a});
            view2 = view;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "y", new float[]{view.getY(), a2});
            view2 = view;
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "alpha", new float[]{view.getAlpha(), optDouble});
            view2 = view;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "rotation", new float[]{view.getRotation(), optDouble2});
            view2 = view;
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, "scaleX", new float[]{view.getScaleX(), optDouble3});
            view2 = view;
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view2, "scaleY", new float[]{view.getScaleY(), optDouble4});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) optInt);
            TimeInterpolator timeInterpolator = null;
            if (optString != null) {
                if (optString.equals("ease")) {
                    timeInterpolator = new AccelerateDecelerateInterpolator();
                } else if (optString.equals("ease-in")) {
                    timeInterpolator = new AccelerateInterpolator();
                } else if (optString.equals("ease-out")) {
                    timeInterpolator = new DecelerateInterpolator();
                }
            }
            if (timeInterpolator == null) {
                timeInterpolator = new LinearInterpolator();
            }
            animatorSet.setInterpolator(timeInterpolator);
            animatorSet.addListener(new 1(this, fVar));
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6});
            animatorSet.start();
            return true;
        } catch (Throwable e) {
            x.w("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", Log.getStackTraceString(e));
            fVar.tp(f("fail:missing finalStyle", null));
            return false;
        }
    }

    protected final boolean aik() {
        return true;
    }
}
