package com.tencent.mm.plugin.subapp.ui.voicereminder;

import com.tencent.mm.sdk.platformtools.bi;

class RemindDialog$5 implements Runnable {
    final /* synthetic */ RemindDialog otT;

    RemindDialog$5(RemindDialog remindDialog) {
        this.otT = remindDialog;
    }

    public final void run() {
        CharSequence stringBuffer = new StringBuffer();
        for (String str : RemindDialog.a(this.otT)) {
            if (bi.oW(str)) {
                stringBuffer.append("\n\n");
            } else {
                stringBuffer.append(str + "\n\n");
            }
        }
        if (RemindDialog.d(this.otT) != null) {
            RemindDialog.d(this.otT).setMessage(stringBuffer);
        }
    }
}
