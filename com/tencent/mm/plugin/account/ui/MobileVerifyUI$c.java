package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.database.ContentObserver;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MobileVerifyUI$c extends ContentObserver {
    private Activity activity;
    final /* synthetic */ MobileVerifyUI eUo;

    public MobileVerifyUI$c(MobileVerifyUI mobileVerifyUI, Activity activity) {
        this.eUo = mobileVerifyUI;
        super(ag.fetchFreeHandler());
        this.activity = activity;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (MobileVerifyUI.f(this.eUo) != 3) {
            x.i("MicroMsg.MobileVerifyUI", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.activity, "android.permission.READ_SMS", 128, "", "")), bi.cjd(), this.activity});
            if (a.a(this.activity, "android.permission.READ_SMS", 128, "", "")) {
                MobileVerifyUI.j(this.eUo);
            }
        }
    }
}
