package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class SnsLabelUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLabelUI nXL;

    SnsLabelUI$5(SnsLabelUI snsLabelUI) {
        this.nXL = snsLabelUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SnsLabelUI snsLabelUI = this.nXL;
        String c = bi.c(snsLabelUI.nXx.nXT, ",");
        String c2 = bi.c(snsLabelUI.nXx.nXV, ",");
        String c3 = bi.c(snsLabelUI.nXx.nXU, ",");
        String c4 = bi.c(snsLabelUI.nXx.nXW, ",");
        if ((snsLabelUI.nXx.nXR == 2 && snsLabelUI.nXx.nXT.size() == 0 && snsLabelUI.nXx.nXV.size() == 0) || (snsLabelUI.nXx.nXR == 3 && snsLabelUI.nXx.nXU.size() == 0 && snsLabelUI.nXx.nXW.size() == 0)) {
            h.a(snsLabelUI, snsLabelUI.getString(j.sns_label_need_select_one_least), "", snsLabelUI.getString(j.sns_label_transform_ok), null);
        } else if ((snsLabelUI.nXx.nXR == 2 && bi.oW(c) && bi.oW(c2)) || (snsLabelUI.nXx.nXR == 3 && bi.oW(c3) && bi.oW(c4))) {
            h.a(snsLabelUI, snsLabelUI.getString(j.sns_label_need_select_one_least), "", snsLabelUI.getString(j.sns_label_transform_ok), null);
        } else {
            snsLabelUI.bDz();
        }
        return true;
    }
}
