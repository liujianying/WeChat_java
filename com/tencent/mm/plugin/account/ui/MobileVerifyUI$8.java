package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.tools.k;

class MobileVerifyUI$8 implements OnClickListener {
    final /* synthetic */ MobileVerifyUI eUo;
    private final int eUq = 0;
    private final int eUr = 1;
    private final int eUs = 2;

    MobileVerifyUI$8(MobileVerifyUI mobileVerifyUI) {
        this.eUo = mobileVerifyUI;
    }

    public final void onClick(View view) {
        k kVar = new k(this.eUo);
        kVar.ofp = new 1(this);
        kVar.ofq = new 2(this);
        kVar.bEo();
    }
}
