package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;

class WxaBindBizInfoUI$2 implements a {
    final /* synthetic */ WxaBindBizInfoUI gwZ;

    WxaBindBizInfoUI$2(WxaBindBizInfoUI wxaBindBizInfoUI) {
        this.gwZ = wxaBindBizInfoUI;
    }

    public final void lI(int i) {
        WxaEntryInfo lJ = this.gwZ.gwW.lJ(i);
        if (lJ != null) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", lJ.username);
            intent.putExtra("key_start_biz_profile_from_app_brand_profile", true);
            intent.putExtra("force_get_contact", true);
            d.b(this.gwZ, "profile", ".ui.ContactInfoUI", intent);
        }
    }
}
