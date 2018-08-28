package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.g.a.sp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class VoiceCreateUI$1 extends c<sp> {
    final /* synthetic */ VoiceCreateUI oGi;

    VoiceCreateUI$1(VoiceCreateUI voiceCreateUI) {
        this.oGi = voiceCreateUI;
        this.sFo = sp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.d("MicroMsg.VoiceCreateUI", "detect finish, noise:%b", new Object[]{Boolean.valueOf(((sp) bVar).cdt.cdu)});
        if (((sp) bVar).cdt.cdu) {
            VoiceCreateUI.a(this.oGi);
        } else {
            VoiceCreateUI.b(this.oGi);
        }
        return false;
    }
}
