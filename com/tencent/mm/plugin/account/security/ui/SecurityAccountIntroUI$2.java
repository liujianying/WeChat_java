package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;

class SecurityAccountIntroUI$2 implements OnClickListener {
    final /* synthetic */ SecurityAccountIntroUI ePa;

    SecurityAccountIntroUI$2(SecurityAccountIntroUI securityAccountIntroUI) {
        this.ePa = securityAccountIntroUI;
    }

    public final void onClick(View view) {
        String d = w.d(this.ePa.getSharedPreferences(ad.chY(), 0));
        Intent intent = new Intent();
        if (bi.oW(SecurityAccountIntroUI.d(this.ePa))) {
            intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
        } else {
            intent.putExtra("rawUrl", SecurityAccountIntroUI.d(this.ePa));
        }
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("title", this.ePa.getString(j.safe_device_protect_close));
        intent.putExtra("show_bottom", false);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        a.ezn.j(intent, this.ePa);
    }
}
