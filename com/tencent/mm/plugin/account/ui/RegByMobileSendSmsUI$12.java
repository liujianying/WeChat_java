package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;

class RegByMobileSendSmsUI$12 implements OnClickListener {
    final /* synthetic */ RegByMobileSendSmsUI eVm;
    final /* synthetic */ a eVo;

    RegByMobileSendSmsUI$12(RegByMobileSendSmsUI regByMobileSendSmsUI, a aVar) {
        this.eVm = regByMobileSendSmsUI;
        this.eVo = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.DF().a(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this.eVm);
        RegByMobileSendSmsUI.a(this.eVm, this.eVo.getUsername(), this.eVo.Oi());
    }
}
