package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class BizBindWxaInfoUI$2 implements OnItemClickListener {
    final /* synthetic */ BizBindWxaInfoUI lUn;

    BizBindWxaInfoUI$2(BizBindWxaInfoUI bizBindWxaInfoUI) {
        this.lUn = bizBindWxaInfoUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        WxaAttributes$WxaEntryInfo wxaAttributes$WxaEntryInfo = (WxaAttributes$WxaEntryInfo) adapterView.getAdapter().getItem(i);
        if (wxaAttributes$WxaEntryInfo != null) {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1020;
            appBrandStatObject.bGG = BizBindWxaInfoUI.a(this.lUn);
            ((d) g.l(d.class)).a(this.lUn, wxaAttributes$WxaEntryInfo.username, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoUI.b(this.lUn));
        }
    }
}
