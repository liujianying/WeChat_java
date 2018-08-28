package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SettingsVoicePrintUI$5 implements OnClickListener {
    final /* synthetic */ SettingsVoicePrintUI oGa;

    SettingsVoicePrintUI$5(SettingsVoicePrintUI settingsVoicePrintUI) {
        this.oGa = settingsVoicePrintUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.oGa, "android.permission.RECORD_AUDIO", 80, "", "")), bi.cjd(), this.oGa});
        if (a.a(this.oGa, "android.permission.RECORD_AUDIO", 80, "", "")) {
            SettingsVoicePrintUI.a(this.oGa);
        }
    }
}
