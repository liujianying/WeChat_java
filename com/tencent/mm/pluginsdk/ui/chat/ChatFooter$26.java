package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class ChatFooter$26 implements a {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$26(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void TB(String str) {
        x.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", str);
        if (bi.oW(ChatFooter.d(this.qMv)) || bi.oW(str)) {
            x.e("MicroMsg.ChatFooter", "onImageReceived, error args");
        } else {
            h.a(this.qMv.getContext(), this.qMv.getContext().getString(R.l.ext_accessories_send_spen_image), "", new 1(this, str), new 2(this));
        }
    }
}
