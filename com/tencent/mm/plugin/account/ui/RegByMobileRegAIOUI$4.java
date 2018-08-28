package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;

class RegByMobileRegAIOUI$4 implements OnClickListener {
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$4(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.eVb = regByMobileRegAIOUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("country_name", RegByMobileRegAIOUI.j(this.eVb));
        intent.putExtra("couttry_code", RegByMobileRegAIOUI.d(this.eVb));
        a.ezn.b(intent, this.eVb);
    }
}
