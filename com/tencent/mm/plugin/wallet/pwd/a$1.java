package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pwd.a.j.1;
import com.tencent.mm.plugin.wallet.pwd.a.j.2;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class a$1 extends g {
    final /* synthetic */ a phb;

    a$1(a aVar, MMActivity mMActivity, i iVar) {
        this.phb = aVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && (lVar instanceof y)) {
            x.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", new Object[]{o.bOS().bPU().field_reset_passwd_flag, o.bOS().bPU().field_find_passwd_url});
            if ((o.bOW().bPD() == null ? 0 : o.bOW().bPD().size()) <= 0 && !bi.oW(r2.field_find_passwd_url)) {
                x.i("MicroMsg.ProcessManager", "hy: no bankcard and do not support add bank card to forget");
                MMActivity mMActivity = this.fEY;
                h.a(mMActivity, true, mMActivity.getString(a.i.wallet_password_forget_not_support), "", mMActivity.getString(a.i.app_ok), mMActivity.getString(a.i.app_cancel), new 1(mMActivity), new 2(mMActivity));
            }
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        return false;
    }
}
