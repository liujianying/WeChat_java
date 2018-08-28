package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.18;
import com.tencent.mm.ui.base.n.d;

class SnsAdNativeLandingPagesUI$18$3 implements d {
    final /* synthetic */ 18 nTa;

    SnsAdNativeLandingPagesUI$18$3(18 18) {
        this.nTa = 18;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        SnsAdNativeLandingPagesUI.b(this.nTa.nSR);
        if (menuItem != null) {
            switch (menuItem.getItemId()) {
                case 1:
                    SnsAdNativeLandingPagesUI.y(this.nTa.nSR);
                    return;
                case 2:
                    SnsAdNativeLandingPagesUI.z(this.nTa.nSR);
                    return;
                case 3:
                    SnsAdNativeLandingPagesUI.A(this.nTa.nSR);
                    return;
                case 4:
                    this.nTa.nSR.u(this.nTa.nSR, SnsAdNativeLandingPagesUI.q(this.nTa.nSR), SnsAdNativeLandingPagesUI.r(this.nTa.nSR));
                    return;
                default:
                    return;
            }
        }
    }
}
