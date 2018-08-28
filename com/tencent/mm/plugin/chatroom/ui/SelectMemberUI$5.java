package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.n;
import com.tencent.mm.ui.base.h;

class SelectMemberUI$5 implements OnClickListener {
    final /* synthetic */ String dhF;
    final /* synthetic */ SelectMemberUI hPv;

    SelectMemberUI$5(SelectMemberUI selectMemberUI, String str) {
        this.hPv = selectMemberUI;
        this.dhF = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        au.DF().a(new n(SelectMemberUI.e(this.hPv), this.dhF), 0);
        SelectMemberUI selectMemberUI = this.hPv;
        Context context = this.hPv;
        this.hPv.getString(R.l.app_tip);
        SelectMemberUI.a(selectMemberUI, h.a(context, this.hPv.getString(R.l.room_transferring_owner), false, null));
    }
}
