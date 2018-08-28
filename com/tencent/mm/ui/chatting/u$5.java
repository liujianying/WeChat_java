package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.g;

class u$5 implements Runnable {
    final /* synthetic */ Intent miG;
    final /* synthetic */ u tKV;

    u$5(u uVar, Intent intent) {
        this.tKV = uVar;
        this.miG = intent;
    }

    public final void run() {
        g.a(this.tKV.mContext, this.miG, this.tKV.mContext.getString(R.l.chatfooter_mail_without_unread_count), null, null);
    }
}
