package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class RegByMobileSetPwdUI$1 implements OnClickListener {
    final /* synthetic */ RegByMobileSetPwdUI eVH;

    RegByMobileSetPwdUI$1(RegByMobileSetPwdUI regByMobileSetPwdUI) {
        this.eVH = regByMobileSetPwdUI;
    }

    public final void onClick(View view) {
        String str = (String) g.Ei().DT().get(6, null);
        if (bi.oW(str)) {
            x.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
            Intent intent = new Intent(this.eVH, BindMContactUI.class);
            intent.putExtra("is_bind_for_reset_pwd", true);
            h.a(this.eVH, this.eVH.getString(j.regbymobile_reg_setpwd_no_mobile), "", this.eVH.getString(j.bind_start), this.eVH.getString(j.app_cancel), true, new 1(this, intent), null);
            return;
        }
        x.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
        h.a(this.eVH, this.eVH.getString(j.regbymobile_reg_setpwd_has_mobile, new Object[]{str}), "", this.eVH.getString(j.app_send), this.eVH.getString(j.app_cancel), true, new 2(this, str), null);
    }
}
