package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

class c$1 extends a {
    final /* synthetic */ c pEf;

    c$1(c cVar, MMActivity mMActivity, i iVar, Bundle bundle) {
        this.pEf = cVar;
        super(mMActivity, iVar, bundle);
    }

    public final CharSequence ui(int i) {
        if (i == 0) {
            return this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_check_pwd_bind_bankcard_tip_payu);
        }
        return super.ui(i);
    }
}
