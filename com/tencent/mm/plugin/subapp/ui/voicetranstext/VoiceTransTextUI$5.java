package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.g.a.kg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class VoiceTransTextUI$5 extends c<kg> {
    final /* synthetic */ VoiceTransTextUI ouz;

    VoiceTransTextUI$5(VoiceTransTextUI voiceTransTextUI) {
        this.ouz = voiceTransTextUI;
        this.sFo = kg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kg kgVar = (kg) bVar;
        x.i("MicroMsg.VoiceTransTextUI", "receive notify, process----> may be pass.");
        if (VoiceTransTextUI.n(this.ouz) != null && !VoiceTransTextUI.m(this.ouz) && (kgVar instanceof kg) && kgVar.bUD.bUE == VoiceTransTextUI.n(this.ouz).oug) {
            x.i("MicroMsg.VoiceTransTextUI", "");
            if (VoiceTransTextUI.o(this.ouz)) {
                x.i("MicroMsg.VoiceTransTextUI", "has new result! but need wait. so, wait.");
                VoiceTransTextUI.p(this.ouz);
            } else {
                new ag(this.ouz.getMainLooper()).post(new 1(this));
            }
        }
        return false;
    }
}
