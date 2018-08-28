package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class ExdeviceProfileUI$29 implements d {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$29(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                com.tencent.mm.plugin.sport.b.d.kB(26);
                ExdeviceProfileUI.s(this.iEx);
                return;
            case 1:
                com.tencent.mm.plugin.sport.b.d.kB(27);
                ExdeviceProfileUI.r(this.iEx);
                return;
            case 2:
                ExdeviceProfileUI.t(this.iEx);
                return;
            case 3:
                h.a(this.iEx.mController.tml, this.iEx.getString(R.l.exdevice_we_sport_black_intro), null, true, new 1(this), null);
                return;
            case 4:
                ExdeviceProfileUI.b(this.iEx, true);
                com.tencent.mm.plugin.sport.b.d.kB(10);
                ad.aHm();
                c.c("", ExdeviceProfileUI.w(this.iEx), ExdeviceProfileUI.u(this.iEx), 3);
                return;
            case 5:
                com.tencent.mm.plugin.sport.b.d.kB(41);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ExdeviceProfileUI.o(this.iEx));
                com.tencent.mm.bg.d.b(this.iEx, "webview", ".ui.tools.WebViewUI", intent);
                return;
            default:
                return;
        }
    }
}
