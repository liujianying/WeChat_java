package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

public final class m {
    p fFv;
    d gmE;
    List<k> gmF;
    String mAppId;

    public m(Context context, String str, p pVar, List<k> list) {
        boolean z = false;
        this.mAppId = str;
        this.fFv = pVar;
        this.gmF = list;
        this.gmE = new d(context);
        View ahb = this.fFv.ahb();
        if (ahb != null) {
            this.gmE.dS(ahb);
        }
        this.gmE.ofp = new 1(this);
        this.gmE.ofq = new 2(this);
        if (this.fFv.gnz) {
            d dVar = this.gmE;
            int parseColor = Color.parseColor("#000000");
            if (dVar.ilW != null) {
                dVar.ilW.setBackgroundColor(parseColor);
            }
            dVar.uJU = Boolean.valueOf(an.Ec(parseColor));
            if (dVar.uJU.booleanValue() && dVar.uKc != null) {
                dVar.uKc.setImageDrawable(dVar.mContext.getResources().getDrawable(c.dark_bg_line_color));
            }
        }
        if (this.fFv.fdO.aaq()) {
            boolean z2;
            d dVar2 = this.gmE;
            if (this.fFv.isFullScreen() || ((com.tencent.mm.plugin.appbrand.game.page.d) this.fFv).ahf()) {
                z2 = true;
            } else {
                z2 = false;
            }
            dVar2.qgK = z2;
            dVar2 = this.gmE;
            if (this.fFv.isFullScreen() || ((com.tencent.mm.plugin.appbrand.game.page.d) this.fFv).ahf()) {
                z = true;
            }
            dVar2.qgL = z;
        } else {
            this.gmE.qgK = this.fFv.isFullScreen();
        }
        this.gmE.bXO();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new 3(this, context));
        }
    }
}
