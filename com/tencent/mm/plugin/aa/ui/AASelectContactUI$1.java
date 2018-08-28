package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import java.util.HashSet;
import java.util.List;

class AASelectContactUI$1 implements OnClickListener {
    final /* synthetic */ AASelectContactUI eCw;

    AASelectContactUI$1(AASelectContactUI aASelectContactUI) {
        this.eCw = aASelectContactUI;
    }

    public final void onClick(View view) {
        if (AASelectContactUI.a(this.eCw).isChecked()) {
            if (AASelectContactUI.b(this.eCw) != null) {
                AASelectContactUI.b(this.eCw).clear();
            } else {
                AASelectContactUI.a(this.eCw, new HashSet());
            }
            AASelectContactUI.a(this.eCw).setChecked(false);
            this.eCw.cyp().notifyDataSetChanged();
        } else {
            List pb = h.pb(AASelectContactUI.c(this.eCw));
            if (((long) pb.size()) > AASelectContactUI.d(this.eCw)) {
                com.tencent.mm.ui.base.h.a(this.eCw.mController.tml, this.eCw.getString(i.aa_select_contact_exceed_alert, new Object[]{Long.valueOf(AASelectContactUI.d(this.eCw))}), "", new 1(this, pb), new 2(this));
            } else {
                AASelectContactUI.a(this.eCw, pb);
            }
        }
        com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(6)});
    }
}
