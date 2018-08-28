package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.ui.base.h;

class l$9 implements OnClickListener {
    final /* synthetic */ l eSI;

    l$9(l lVar) {
        this.eSI = lVar;
    }

    public final void onClick(View view) {
        h.a(this.eSI.eSu, this.eSI.eSu.getString(a$j.regbymobile_reg_verify_mobile_msg) + this.eSI.account, this.eSI.eSu.getString(a$j.regbymobile_reg_verify_mobile_title), this.eSI.eSu.getString(a$j.app_ok), this.eSI.eSu.getString(a$j.app_cancel), false, new 1(this), new 2(this));
    }
}
