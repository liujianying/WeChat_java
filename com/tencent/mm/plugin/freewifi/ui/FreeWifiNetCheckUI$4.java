package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiNetCheckUI$4 implements e {
    final /* synthetic */ String fFV;
    final /* synthetic */ FreeWifiNetCheckUI jnK;
    final /* synthetic */ String jnL;
    final /* synthetic */ String jnM;

    FreeWifiNetCheckUI$4(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2, String str3) {
        this.jnK = freeWifiNetCheckUI;
        this.jnL = str;
        this.jnM = str2;
        this.fFV = str3;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            xq aOV = ((h) lVar).aOV();
            if (aOV != null) {
                Intent intent = this.jnK.getIntent();
                intent.putExtra("free_wifi_appid", aOV.rbW);
                intent.putExtra("free_wifi_head_img_url", aOV.jPM);
                intent.putExtra("free_wifi_welcome_msg", aOV.rDu);
                intent.putExtra("free_wifi_welcome_sub_title", aOV.rDw);
                intent.putExtra("free_wifi_privacy_url", aOV.rDv);
                intent.putExtra("free_wifi_app_nickname", aOV.hcS);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", this.jnL);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", this.jnM);
                intent.setClass(this.jnK, FreeWifiPcUI.class);
                this.jnK.finish();
                this.jnK.startActivity(intent);
            }
        } else if (!m.cD(i, i2) || m.isEmpty(str)) {
            FreeWifiNetCheckUI.a(this.jnK, this.jnK.getString(R.l.free_wifi_errmsg_cannot_get_pc_front_page), this.jnK.getString(R.l.free_wifi_errmsg_cannot_get_pc_front_page2));
        } else {
            FreeWifiNetCheckUI.a(this.jnK, str + "(" + m.a(m.G(FreeWifiNetCheckUI.b(this.jnK)), b.jiL, i2) + ")", "");
        }
        a aOa = k.aOa();
        aOa.jib = this.jnL;
        aOa.jic = this.fFV;
        aOa.jid = this.jnM;
        aOa.jif = b.jiL.jiQ;
        aOa.jig = b.jiL.name;
        aOa.result = i2;
        aOa.aOc().aOb();
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", new Object[]{m.E(this.jnK.getIntent()), Integer.valueOf(m.F(this.jnK.getIntent())), Integer.valueOf(i2)});
    }
}
