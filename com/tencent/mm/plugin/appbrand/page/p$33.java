package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.n.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;

class p$33 implements OnClickListener {
    final /* synthetic */ p gnH;

    p$33(p pVar) {
        this.gnH = pVar;
    }

    public final void onClick(View view) {
        boolean z;
        int i = 0;
        AppBrandOptionButton appBrandOptionButton = (AppBrandOptionButton) view;
        if (this.gnH.mContext == null || !(this.gnH.mContext instanceof MMActivity)) {
            z = false;
        } else {
            z = ((MMActivity) this.gnH.mContext).mController.hideVKB();
        }
        if (appBrandOptionButton.gFx) {
            1 1 = new 1(this);
            if (z) {
                i = 100;
            }
            ah.i(1, (long) i);
            return;
        }
        a.tm(this.gnH.mAppId);
    }
}
