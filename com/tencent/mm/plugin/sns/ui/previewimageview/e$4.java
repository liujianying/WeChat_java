package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.f;

class e$4 implements f {
    final /* synthetic */ DynamicGridView olI;
    final /* synthetic */ e olJ;
    final /* synthetic */ View olK;

    e$4(e eVar, DynamicGridView dynamicGridView, View view) {
        this.olJ = eVar;
        this.olI = dynamicGridView;
        this.olK = view;
    }

    public final void bEN() {
        DynamicGridView dynamicGridView = this.olI;
        dynamicGridView.iDm = false;
        dynamicGridView.requestDisallowInterceptTouchEvent(false);
        if (DynamicGridView.bES() && dynamicGridView.omf) {
            dynamicGridView.iu(true);
        }
        if (VERSION.SDK_INT >= 21) {
            this.olI.setElevation(this.olJ.olB);
        } else {
            this.olK.bringToFront();
        }
    }
}
