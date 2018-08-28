package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import com.tencent.mm.ax.e;
import com.tencent.mm.p.a;
import com.tencent.mm.ui.base.n.d;

class SelfQRCodeUI$7 implements d {
    final /* synthetic */ SelfQRCodeUI mQy;

    SelfQRCodeUI$7(SelfQRCodeUI selfQRCodeUI) {
        this.mQy = selfQRCodeUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                SelfQRCodeUI.e(this.mQy);
                return;
            case 2:
                SelfQRCodeUI.a(this.mQy, 0);
                return;
            case 3:
                if (!a.bx(this.mQy.mController.tml)) {
                    ActionBarActivity actionBarActivity = this.mQy.mController.tml;
                    if (!e.Sz()) {
                        com.tencent.mm.bg.d.A(this.mQy.mController.tml, "scanner", ".ui.BaseScanUI");
                        return;
                    }
                    return;
                }
                return;
            case 4:
                SelfQRCodeUI.f(this.mQy);
                return;
            default:
                return;
        }
    }
}
