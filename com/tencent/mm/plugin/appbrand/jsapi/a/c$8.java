package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

class c$8 implements a {
    final /* synthetic */ c fKg;
    final /* synthetic */ MMActivity fKl;

    c$8(c cVar, MMActivity mMActivity) {
        this.fKg = cVar;
        this.fKl = mMActivity;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 100) {
            this.fKg.fKd = 1;
            if (i2 == -1) {
                this.fKg.fKe = 1;
                x.i("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_OK");
                h.mEJ.h(14249, new Object[]{this.fKg.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fKg.fKd), Integer.valueOf(this.fKg.fKe), Integer.valueOf(this.fKg.fKc)});
                com.tencent.mm.ui.base.h.bA(this.fKl.mController.tml, this.fKl.getResources().getString(j.app_brand_get_phone_number_bind_success));
                this.fKg.aie();
            } else {
                this.fKg.fKe = 0;
                this.fKg.fJQ.E(this.fKg.fFd, this.fKg.f("fail:user cancel", null));
                x.e("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_CANCEL OR RESULT_FIRST_USER");
                h.mEJ.h(14249, new Object[]{this.fKg.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fKg.fKd), Integer.valueOf(this.fKg.fKe), Integer.valueOf(this.fKg.fKc)});
            }
            this.fKl.geJ = null;
        }
    }
}
