package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.List;

class e$5 implements OnPreDrawListener {
    final /* synthetic */ DynamicGridView olI;
    final /* synthetic */ e olJ;
    final /* synthetic */ List olL;

    e$5(e eVar, DynamicGridView dynamicGridView, List list) {
        this.olJ = eVar;
        this.olI = dynamicGridView;
        this.olL = list;
    }

    public final boolean onPreDraw() {
        this.olI.getViewTreeObserver().removeOnPreDrawListener(this);
        this.olJ.xH(this.olL.size());
        return true;
    }
}
