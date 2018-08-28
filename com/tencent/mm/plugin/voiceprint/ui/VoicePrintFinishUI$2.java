package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VoicePrintFinishUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ VoicePrintFinishUI oGq;

    VoicePrintFinishUI$2(VoicePrintFinishUI voicePrintFinishUI) {
        this.oGq = voicePrintFinishUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oGq.finish();
        return true;
    }
}
