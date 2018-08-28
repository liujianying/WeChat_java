package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.pluginsdk.ui.applet.q.b;

class IPCallShareCouponCardUI$5 implements b {
    final /* synthetic */ String fhM;
    final /* synthetic */ IPCallShareCouponCardUI kyi;
    final /* synthetic */ EditText kyj;
    final /* synthetic */ int kyk;

    IPCallShareCouponCardUI$5(IPCallShareCouponCardUI iPCallShareCouponCardUI, EditText editText, String str, int i) {
        this.kyi = iPCallShareCouponCardUI;
        this.kyj = editText;
        this.fhM = str;
        this.kyk = i;
    }

    public final void gb(boolean z) {
        if (z) {
            h hVar = new h(this.kyk, this.kyj == null ? this.fhM : this.kyj.getText().toString());
            IPCallShareCouponCardUI iPCallShareCouponCardUI = this.kyi;
            IPCallShareCouponCardUI iPCallShareCouponCardUI2 = this.kyi;
            this.kyi.getString(R.l.app_tip);
            IPCallShareCouponCardUI.b(iPCallShareCouponCardUI, com.tencent.mm.ui.base.h.a(iPCallShareCouponCardUI2, this.kyi.getString(R.l.app_sending), true, new 1(this, hVar)));
            au.DF().a(hVar, 0);
        }
    }
}
