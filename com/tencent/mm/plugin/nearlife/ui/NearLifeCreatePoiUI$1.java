package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;

class NearLifeCreatePoiUI$1 implements OnClickListener {
    final /* synthetic */ NearLifeCreatePoiUI lEr;

    NearLifeCreatePoiUI$1(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.lEr = nearLifeCreatePoiUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("ui_title", R.l.nl_select_address_title);
        if (NearLifeCreatePoiUI.a(this.lEr) != null) {
            intent.putExtra("extra_province", NearLifeCreatePoiUI.a(this.lEr).dRI);
            intent.putExtra("extra_city", NearLifeCreatePoiUI.a(this.lEr).dRJ);
        }
        d.b(this.lEr.mController.tml, "address", ".ui.WalletMultiRcptSelectUI", intent, 1);
    }
}
