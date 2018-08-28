package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiPcUI$2 implements OnClickListener {
    final /* synthetic */ FreeWifiPcUI jnS;

    FreeWifiPcUI$2(FreeWifiPcUI freeWifiPcUI) {
        this.jnS = freeWifiPcUI;
    }

    public final void onClick(View view) {
        FreeWifiPcUI.b(this.jnS).setClickable(false);
        al alVar = new al(new 1(this), false);
        alVar.J(2000, 2000);
        a aOa = k.aOa();
        aOa.jib = String.valueOf(FreeWifiPcUI.e(this.jnS));
        aOa.jic = FreeWifiPcUI.d(this.jnS);
        aOa.jid = FreeWifiPcUI.c(this.jnS);
        aOa.jif = b.jiM.jiQ;
        aOa.jig = b.jiM.name;
        aOa.aOc().aOb();
        x.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[]{m.E(this.jnS.getIntent()), Integer.valueOf(m.F(this.jnS.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.jnS)), FreeWifiPcUI.d(this.jnS), FreeWifiPcUI.c(this.jnS)});
        new l(FreeWifiPcUI.d(this.jnS), FreeWifiPcUI.e(this.jnS), FreeWifiPcUI.c(this.jnS)).b(new 2(this, alVar));
    }
}
