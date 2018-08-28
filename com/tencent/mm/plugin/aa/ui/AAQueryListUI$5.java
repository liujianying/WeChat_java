package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class AAQueryListUI$5 implements a {
    final /* synthetic */ AAQueryListUI eCd;

    AAQueryListUI$5(AAQueryListUI aAQueryListUI) {
        this.eCd = aAQueryListUI;
    }

    public final void bd(Object obj) {
        x.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[]{obj});
        if (AAQueryListUI.g(this.eCd) != null) {
            AAQueryListUI.g(this.eCd).dismiss();
            AAQueryListUI.h(this.eCd);
        }
        AAQueryListUI.i(this.eCd);
        if (AAQueryListUI.a(this.eCd).getFooterViewsCount() > 0) {
            AAQueryListUI.a(this.eCd).removeFooterView(AAQueryListUI.d(this.eCd));
        }
        if (obj instanceof String) {
            Toast.makeText(this.eCd, obj.toString(), 1).show();
        } else {
            Toast.makeText(this.eCd, i.get_aa_list_record_failed, 1).show();
        }
    }
}
