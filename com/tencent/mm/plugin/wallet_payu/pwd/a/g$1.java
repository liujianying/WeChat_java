package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

class g$1 extends a {
    final /* synthetic */ g pFQ;

    g$1(g gVar, MMActivity mMActivity, i iVar, Bundle bundle) {
        this.pFQ = gVar;
        super(mMActivity, iVar, bundle);
    }

    public final CharSequence ui(int i) {
        if (i == 0) {
            return this.fEY.getString(a.i.wallet_check_pwd_modify_pwd_tip_payu);
        }
        return super.ui(i);
    }
}
