package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.d.dl;
import com.tencent.mm.plugin.game.model.an;

class GameIndexWxagView$1 implements OnClickListener {
    final /* synthetic */ int jUG;
    final /* synthetic */ GameIndexWxagView jYW;

    GameIndexWxagView$1(GameIndexWxagView gameIndexWxagView, int i) {
        this.jYW = gameIndexWxagView;
        this.jUG = i;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof dl)) {
            dl dlVar = (dl) view.getTag();
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1079;
            ((d) g.l(d.class)).a(this.jYW.getContext(), dlVar.hbL, dlVar.jQb, dlVar.jTy, 0, dlVar.jTx, appBrandStatObject);
            an.a(this.jYW.getContext(), 10, 1025, 999, 30, dlVar.jQb, this.jUG, null);
        }
    }
}
