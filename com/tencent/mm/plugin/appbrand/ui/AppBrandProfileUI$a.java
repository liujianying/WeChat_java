package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class AppBrandProfileUI$a extends t implements OnClickListener {
    final /* synthetic */ AppBrandProfileUI gvm;
    WxaBindBizInfoView gvs;
    String mAppId;

    static /* synthetic */ void a(AppBrandProfileUI$a appBrandProfileUI$a, List list) {
        WxaBindBizInfoView wxaBindBizInfoView = appBrandProfileUI$a.gvs;
        wxaBindBizInfoView.gEP.clear();
        if (!(list == null || list.isEmpty())) {
            wxaBindBizInfoView.gEP.addAll(list);
        }
        wxaBindBizInfoView.dj(true);
    }

    AppBrandProfileUI$a(AppBrandProfileUI appBrandProfileUI, View view) {
        this.gvm = appBrandProfileUI;
        super(view);
        this.gvs = (WxaBindBizInfoView) view.findViewById(g.profile_bind_biz_info_item);
        view.setOnClickListener(this);
    }

    public final void onClick(View view) {
        Collection wxaEntryInfoList = this.gvs.getWxaEntryInfoList();
        if (wxaEntryInfoList == null || wxaEntryInfoList.isEmpty()) {
            x.i("MicroMsg.AppBrandProfileUI", "deal onBindBizInfo click failed, bindBizInfoList is null or nil.");
        } else if (wxaEntryInfoList.size() == 1) {
            d.b(this.SU.getContext(), "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", ((WxaEntryInfo) wxaEntryInfoList.get(0)).username).putExtra("key_start_biz_profile_from_app_brand_profile", true).putExtra("force_get_contact", true));
            AppBrandProfileUI.a(this.gvm, 3, 1);
        } else {
            Intent intent = new Intent(this.gvm.mController.tml, WxaBindBizInfoUI.class);
            intent.putExtra("app_id", this.mAppId);
            intent.putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(wxaEntryInfoList));
            this.gvm.mController.tml.startActivity(intent);
        }
    }
}
