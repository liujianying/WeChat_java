package com.tencent.mm.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;

class SecurityImage$1 implements OnClickListener {
    final /* synthetic */ SecurityImage trV;

    SecurityImage$1(SecurityImage securityImage) {
        this.trV = securityImage;
    }

    public final void onClick(View view) {
        SecurityImage.a(this.trV);
        if (SecurityImage.b(this.trV) != null) {
            SecurityImage.b(this.trV).Xe();
        }
    }
}
