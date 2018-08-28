package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class LoginVoiceUI extends LoginHistoryUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.eRq) {
            this.eLS = 1;
            this.eRj.setVisibility(0);
            this.eQR.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.eQQ.getLayoutParams();
            layoutParams.gravity = 1;
            layoutParams.leftMargin = 0;
            this.eQQ.setLayoutParams(layoutParams);
            findViewById(a$f.voice_btn_icon).setEnabled(false);
            ((TextView) findViewById(a$f.voice_login_btn)).setTextColor(getResources().getColorStateList(c.white_text_color_selector));
            ((TextView) findViewById(a$f.voice_login_btn)).setBackgroundResource(getResources().getColor(c.transparent));
            this.eQR.setOnClickListener(new 1(this));
        }
    }

    public final boolean YD() {
        return false;
    }

    protected final void Yz() {
        int i = -1;
        super.Yz();
        YA();
        q qVar = new q(this.eRg, this.eRp, "", 0);
        qVar.mW(this.eRp);
        String str = "MicroMsg.LoginVoiceUI";
        String str2 = "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.eRp == null ? -1 : this.eRp.length());
        objArr[1] = bi.Xf(this.eRp);
        if (this.eQY.eIY != null) {
            i = this.eQY.eIY.length();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bi.Xf(this.eQY.eIY);
        x.d(str, str2, objArr);
        getString(j.app_tip);
        this.eHw = h.a(this, getString(j.login_logining), true, new 2(this, qVar));
        g.DF().a(qVar, 0);
    }
}
