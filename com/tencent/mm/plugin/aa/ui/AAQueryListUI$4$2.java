package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.aa.ui.AAQueryListUI.4;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class AAQueryListUI$4$2 implements d {
    final /* synthetic */ 4 eCe;

    AAQueryListUI$4$2(4 4) {
        this.eCe = 4;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                x.i("MicroMsg.AAQueryListUI", "go to launch list: %d", new Object[]{Integer.valueOf(AAQueryListUI.e(this.eCe.eCd))});
                if (AAQueryListUI.e(this.eCe.eCd) != 1) {
                    AAQueryListUI.a(this.eCe.eCd, 1);
                    this.eCe.eCd.setMMTitle(i.aa_record_list_launch_title);
                    AAQueryListUI.f(this.eCe.eCd).mode = AAQueryListUI.e(this.eCe.eCd);
                    AAQueryListUI.f(this.eCe.eCd).Wf();
                    AAQueryListUI.f(this.eCe.eCd).notifyDataSetChanged();
                    AAQueryListUI.a(this.eCe.eCd, true, AAQueryListUI.e(this.eCe.eCd));
                    return;
                }
                return;
            case 2:
                x.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", new Object[]{Integer.valueOf(AAQueryListUI.e(this.eCe.eCd))});
                if (AAQueryListUI.e(this.eCe.eCd) != 2) {
                    this.eCe.eCd.setMMTitle(i.aa_record_list_pay_title);
                    AAQueryListUI.f(this.eCe.eCd).mode = AAQueryListUI.e(this.eCe.eCd);
                    AAQueryListUI.f(this.eCe.eCd).Wf();
                    AAQueryListUI.f(this.eCe.eCd).notifyDataSetChanged();
                    AAQueryListUI.a(this.eCe.eCd, 2);
                    AAQueryListUI.a(this.eCe.eCd, true, AAQueryListUI.e(this.eCe.eCd));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
