package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelstat.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

class SettingsAboutMicroMsgUI$2 implements OnClickListener {
    private al eaF = null;
    private e ehD = null;
    final /* synthetic */ SettingsAboutMicroMsgUI mRb;

    SettingsAboutMicroMsgUI$2(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        this.mRb = settingsAboutMicroMsgUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.RT().commitNow();
        g.Ek();
        if (a.gI(g.Eg().dpx)) {
            o DF = g.DF();
            1 1 = new 1(this);
            this.ehD = 1;
            DF.a(281, 1);
            ac acVar = new ac(2);
            g.DF().a(acVar, 0);
            this.eaF = new al(new 2(this, acVar), false);
            this.eaF.J(5000, 5000);
            SettingsAboutMicroMsgUI settingsAboutMicroMsgUI = this.mRb;
            ActionBarActivity actionBarActivity = this.mRb.mController.tml;
            this.mRb.getString(i.app_tip);
            SettingsAboutMicroMsgUI.a(settingsAboutMicroMsgUI, h.a(actionBarActivity, this.mRb.getString(i.webwx_logout_processing_txt), true, new 3(this, acVar)));
            return;
        }
        SettingsAboutMicroMsgUI.b(this.mRb);
    }
}
