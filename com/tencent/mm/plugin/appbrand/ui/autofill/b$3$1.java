package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.ui.autofill.b.3;
import com.tencent.mm.sdk.platformtools.x;

class b$3$1 implements OnClickListener {
    final /* synthetic */ 3 gxK;

    b$3$1(3 3) {
        this.gxK = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.gxK.gxI.eRn.cru();
        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
        if (this.gxK.gxI.gxe != null) {
            this.gxK.gxI.gxe.a(this.gxK.gxI.gxF);
        }
    }
}
