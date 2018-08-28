package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.os.CountDownTimer;
import com.tencent.mm.plugin.appbrand.s.j;

class c$a extends CountDownTimer {
    final /* synthetic */ c fKg;

    public c$a(c cVar) {
        this.fKg = cVar;
        super(60000, 1000);
    }

    public final void onTick(long j) {
        this.fKg.fJY.setText(this.fKg.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_repeat_send_after_second, new Object[]{(j / 1000)}));
    }

    public final void onFinish() {
        this.fKg.aig();
    }
}
