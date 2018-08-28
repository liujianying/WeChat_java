package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.5;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 413;
    public static final String NAME = "scrollWebviewTo";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        final long optLong = jSONObject.optLong("duration", 300);
        if (jSONObject.has("scrollTop")) {
            try {
                final int round = Math.round(f.ae(new BigDecimal(jSONObject.getString("scrollTop")).floatValue()));
                final p pVar2 = pVar;
                final int i2 = i;
                ah.A(new Runnable() {
                    public final void run() {
                        t tVar = pVar2.gns;
                        int i = round;
                        long j = optLong;
                        if (tVar.goy != null) {
                            tVar.goy.cancel();
                            tVar.goy = null;
                        }
                        Animator ofInt = ValueAnimator.ofInt(new int[]{tVar.getView().getScrollY(), i});
                        ofInt.addUpdateListener(new 5(tVar));
                        ofInt.setInterpolator(new DecelerateInterpolator());
                        ofInt.setDuration(j);
                        ofInt.start();
                        tVar.goy = ofInt;
                        pVar2.E(i2, c.this.f("ok", null));
                    }
                });
                return;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[]{e});
                pVar.E(i, f("fail:invalid data " + bi.oV(e.getMessage()), null));
                return;
            }
        }
        pVar.E(i, f("fail:invalid data", null));
    }
}
