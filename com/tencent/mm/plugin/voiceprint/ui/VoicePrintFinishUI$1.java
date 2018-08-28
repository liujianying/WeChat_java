package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class VoicePrintFinishUI$1 implements OnClickListener {
    final /* synthetic */ VoicePrintFinishUI oGq;

    VoicePrintFinishUI$1(VoicePrintFinishUI voicePrintFinishUI) {
        this.oGq = voicePrintFinishUI;
    }

    public final void onClick(View view) {
        if (VoicePrintFinishUI.a(this.oGq) == 72) {
            Intent intent = new Intent();
            intent.setClass(this.oGq, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            this.oGq.startActivity(intent);
        }
        this.oGq.finish();
    }
}
