package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiPcUI$2$2 implements e {
    final /* synthetic */ 2 jnT;
    final /* synthetic */ al jnV;

    FreeWifiPcUI$2$2(2 2, al alVar) {
        this.jnT = 2;
        this.jnV = alVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        this.jnV.SO();
        if (i == 0 && i2 == 0) {
            this.jnT.jnS.finish();
        } else if (!m.cD(i, i2) || m.isEmpty(str)) {
            FreeWifiPcUI.a(this.jnT.jnS, this.jnT.jnS.getString(R.l.free_wifi_errmsg_cannot_set_pc_login_user_info), this.jnT.jnS.getString(R.l.free_wifi_errmsg_cannot_set_pc_login_user_info2));
        } else {
            FreeWifiPcUI.a(this.jnT.jnS, str + "(" + m.a(m.G(this.jnT.jnS.getIntent()), b.jiN, i2) + ")", "");
        }
        a aOa = k.aOa();
        aOa.jib = String.valueOf(FreeWifiPcUI.e(this.jnT.jnS));
        aOa.jic = FreeWifiPcUI.d(this.jnT.jnS);
        aOa.jid = FreeWifiPcUI.c(this.jnT.jnS);
        aOa.jif = b.jiN.jiQ;
        aOa.jig = b.jiN.name;
        aOa.result = i2;
        aOa.aOc().aOb();
        x.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", m.E(this.jnT.jnS.getIntent()), Integer.valueOf(m.F(this.jnT.jnS.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.jnT.jnS)), FreeWifiPcUI.d(this.jnT.jnS), FreeWifiPcUI.c(this.jnT.jnS));
    }
}
