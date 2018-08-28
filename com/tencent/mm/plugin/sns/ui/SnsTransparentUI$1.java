package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

class SnsTransparentUI$1 implements a {
    final /* synthetic */ String ofG;
    final /* synthetic */ String ofH;
    final /* synthetic */ String ofI;
    final /* synthetic */ String ofJ;
    final /* synthetic */ String ofK;
    final /* synthetic */ String ofL;
    final /* synthetic */ SnsTransparentUI ofM;

    SnsTransparentUI$1(SnsTransparentUI snsTransparentUI, String str, String str2, String str3, String str4, String str5, String str6) {
        this.ofM = snsTransparentUI;
        this.ofG = str;
        this.ofH = str2;
        this.ofI = str3;
        this.ofJ = str4;
        this.ofK = str5;
        this.ofL = str6;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String str;
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("Select_Conv_User");
            }
            if (str == null || str.length() == 0) {
                x.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
                this.ofM.finish();
                return;
            }
            x.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
            String str2 = this.ofG;
            SnsTransparentUI snsTransparentUI = this.ofM;
            t.a.qJO.a(((MMActivity) snsTransparentUI).mController, this.ofH, this.ofI, this.ofJ, true, snsTransparentUI.getResources().getString(i$j.app_send), new 1(this, str2, str, snsTransparentUI));
            return;
        }
        this.ofM.finish();
    }
}
