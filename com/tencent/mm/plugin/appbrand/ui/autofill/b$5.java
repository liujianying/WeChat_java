package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements OnClickListener {
    final /* synthetic */ b gxI;

    b$5(b bVar) {
        this.gxI = bVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
        if (b.a(this.gxI) != null) {
            b.a(this.gxI).a(b.e(this.gxI).getText().toString(), b.d(this.gxI));
        }
    }
}
