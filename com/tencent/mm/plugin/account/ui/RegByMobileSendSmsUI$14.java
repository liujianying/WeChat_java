package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelfriend.a;

class RegByMobileSendSmsUI$14 implements OnClickListener {
    final /* synthetic */ RegByMobileSendSmsUI eVm;
    final /* synthetic */ a eVo;

    RegByMobileSendSmsUI$14(RegByMobileSendSmsUI regByMobileSendSmsUI, a aVar) {
        this.eVm = regByMobileSendSmsUI;
        this.eVo = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RegByMobileSendSmsUI.a(this.eVm, this.eVo.getUsername(), this.eVo.Oi());
    }
}
