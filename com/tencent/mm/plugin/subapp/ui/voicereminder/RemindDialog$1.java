package com.tencent.mm.plugin.subapp.ui.voicereminder;

import com.tencent.mm.model.am.d;
import com.tencent.mm.sdk.platformtools.x;

class RemindDialog$1 implements d {
    final /* synthetic */ RemindDialog otT;

    RemindDialog$1(RemindDialog remindDialog) {
        this.otT = remindDialog;
    }

    public final void n(String str, long j) {
        x.d("MicroMsg.RemindDialog", "onVoiceRemind " + str);
        RemindDialog.a(this.otT).add(str);
        RemindDialog.b(this.otT);
    }
}
