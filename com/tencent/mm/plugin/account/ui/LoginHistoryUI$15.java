package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LoginHistoryUI$15 implements OnClickListener {
    final /* synthetic */ int bFq;
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$15(LoginHistoryUI loginHistoryUI, int i) {
        this.eRA = loginHistoryUI;
        this.bFq = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = -1;
        x.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.eRA.eQY.eJa + " img len" + this.eRA.eQY.eIZ.length + " " + g.Ac());
        String str = "MicroMsg.LoginHistoryUI";
        String str2 = "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(this.bFq);
        objArr[1] = Integer.valueOf(this.eRA.eRp == null ? -1 : this.eRA.eRp.length());
        objArr[2] = bi.Xf(this.eRA.eRp);
        if (this.eRA.eQY.eIY != null) {
            i2 = this.eRA.eQY.eIY.length();
        }
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = bi.Xf(this.eRA.eQY.eIY);
        x.d(str, str2, objArr);
        q qVar = new q(this.eRA.eQY.account, this.eRA.eQY.eIY, this.eRA.eQY.eRQ, LoginHistoryUI.i(this.eRA).getSecImgCode(), LoginHistoryUI.i(this.eRA).getSecImgSid(), LoginHistoryUI.i(this.eRA).getSecImgEncryptKey(), 0, "", false, false);
        if (bi.oW(this.eRA.eQY.eIY) && !bi.oW(this.eRA.eRp)) {
            x.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[]{bi.Xf(this.eRA.eRp)});
            qVar.mW(this.eRA.eRp);
        }
        com.tencent.mm.kernel.g.DF().a(qVar, 0);
        LoginHistoryUI loginHistoryUI = this.eRA;
        Context context = this.eRA;
        this.eRA.getString(a$j.app_tip);
        loginHistoryUI.eHw = h.a(context, this.eRA.getString(a$j.login_logining), true, new 1(this, qVar));
    }
}
