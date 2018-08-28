package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class NewTaskUI$3 implements OnClickListener {
    final /* synthetic */ NewTaskUI uBg;

    NewTaskUI$3(NewTaskUI newTaskUI) {
        this.uBg = newTaskUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(this.uBg).eJa + " img len" + NewTaskUI.a(this.uBg).eIZ.length + " " + g.Ac());
        if (NewTaskUI.b(this.uBg) == null) {
            x.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            return;
        }
        final q qVar = new q(NewTaskUI.a(this.uBg).eRQ, NewTaskUI.b(this.uBg).getSecImgCode(), NewTaskUI.b(this.uBg).getSecImgSid(), NewTaskUI.b(this.uBg).getSecImgEncryptKey());
        au.DF().a(qVar, 0);
        NewTaskUI newTaskUI = this.uBg;
        NewTaskUI newTaskUI2 = this.uBg;
        this.uBg.getString(R.l.app_tip);
        NewTaskUI.a(newTaskUI, h.a(newTaskUI2, this.uBg.getString(R.l.login_logining), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                au.DF().c(qVar);
            }
        }));
    }
}
