package com.tencent.mm.plugin.chatroom.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.d.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

class SeeAccessVerifyInfoUI$5 implements OnClickListener {
    final /* synthetic */ SeeAccessVerifyInfoUI hOz;

    SeeAccessVerifyInfoUI$5(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
        this.hOz = seeAccessVerifyInfoUI;
    }

    public final void onClick(View view) {
        SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = this.hOz;
        ActionBarActivity actionBarActivity = this.hOz.mController.tml;
        this.hOz.getString(R.l.app_tip);
        SeeAccessVerifyInfoUI.a(seeAccessVerifyInfoUI, h.a(actionBarActivity, this.hOz.getString(R.l.accessing_invite), false, null));
        new b(SeeAccessVerifyInfoUI.a(this.hOz), SeeAccessVerifyInfoUI.j(this.hOz), SeeAccessVerifyInfoUI.k(this.hOz), new LinkedList(bi.F(SeeAccessVerifyInfoUI.l(this.hOz).split(",")))).KM().b(this.hOz).f(new 1(this));
    }
}
