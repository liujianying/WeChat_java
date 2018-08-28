package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;

class SecurityAccountVerifyUI$4 implements OnClickListener {
    final /* synthetic */ SecurityAccountVerifyUI ePi;

    SecurityAccountVerifyUI$4(SecurityAccountVerifyUI securityAccountVerifyUI) {
        this.ePi = securityAccountVerifyUI;
    }

    public final void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",L600_300,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("L600_300")).append(",1").toString());
        String d = w.d(this.ePi.getSharedPreferences(ad.chY(), 0));
        Intent intent = new Intent();
        intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("title", this.ePi.getString(j.safe_device_protect_close));
        intent.putExtra("show_bottom", false);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        com.tencent.mm.plugin.account.a.a.ezn.j(intent, this.ePi);
    }
}
