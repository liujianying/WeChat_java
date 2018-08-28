package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.base.h;

class b$3 implements OnClickListener {
    final /* synthetic */ b gxI;

    b$3(b bVar) {
        this.gxI = bVar;
    }

    public final void onClick(View view) {
        h.a(this.gxI.getContext(), this.gxI.getString(j.app_brand_idcard_verify_sms_msg) + b.d(this.gxI).reN, this.gxI.getString(j.app_brand_idcard_verify_sms_confirm_phone), this.gxI.getString(j.app_ok), this.gxI.getString(j.app_cancel), false, new 1(this), new 2(this));
    }
}
