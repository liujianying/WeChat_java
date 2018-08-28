package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class LoginFaceUI extends LoginHistoryUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.eRq) {
            this.eLS = 4;
            this.eRl.setVisibility(0);
            this.eQS.setVisibility(0);
            findViewById(f.face_btn_icon).setEnabled(false);
            ((TextView) findViewById(f.face_login_btn)).setTextColor(getResources().getColorStateList(c.white_text_color_selector));
            ((TextView) findViewById(f.face_login_btn)).setBackgroundResource(getResources().getColor(c.transparent));
            this.eQS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    h.mEJ.h(11557, new Object[]{Integer.valueOf(2)});
                    Intent intent = new Intent();
                    intent.putExtra("k_user_name", LoginFaceUI.this.eRg);
                    intent.putExtra("k_purpose", 2);
                    intent.putExtra("k_need_signature", true);
                    d.b(LoginFaceUI.this.mController.tml, "facedetect", ".ui.FaceDetectUI", intent, 1025);
                }
            });
        }
    }

    protected final void Yz() {
        int i = -1;
        super.Yz();
        YA();
        q qVar = new q(this.eRg, this.eRp, "", 0);
        String str = "MicroMsg.LoginFaceUI";
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
        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(j.login_logining), true, new 2(this, qVar));
        g.DF().a(qVar, 0);
    }
}
