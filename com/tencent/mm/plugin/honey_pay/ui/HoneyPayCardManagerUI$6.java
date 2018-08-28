package com.tencent.mm.plugin.honey_pay.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

class HoneyPayCardManagerUI$6 implements d {
    final /* synthetic */ HoneyPayCardManagerUI kkT;
    final /* synthetic */ List kkU;

    HoneyPayCardManagerUI$6(HoneyPayCardManagerUI honeyPayCardManagerUI, List list) {
        this.kkT = honeyPayCardManagerUI;
        this.kkU = list;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        HoneyPayCardManagerUI.a(this.kkT, (Bankcard) this.kkU.get(i));
        x.i(this.kkT.TAG, "select bankcard: %s, %s", new Object[]{HoneyPayCardManagerUI.g(this.kkT).field_bindSerial, HoneyPayCardManagerUI.g(this.kkT).field_bankcardTypeName});
        HoneyPayCardManagerUI.b(this.kkT, HoneyPayCardManagerUI.c(this.kkT));
        bao bao = new bao();
        bao.scW = HoneyPayCardManagerUI.g(this.kkT).field_desc;
        bao.lMV = HoneyPayCardManagerUI.g(this.kkT).field_bankcardType;
        bao.scY = HoneyPayCardManagerUI.g(this.kkT).field_bindSerial;
        bao.scZ = HoneyPayCardManagerUI.g(this.kkT).field_bankcardTail;
        HoneyPayCardManagerUI.a(this.kkT, bao);
        HoneyPayCardManagerUI.d(this.kkT);
        HoneyPayCardManagerUI.e(this.kkT);
    }
}
