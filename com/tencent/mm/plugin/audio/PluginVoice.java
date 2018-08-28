package com.tencent.mm.plugin.audio;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.audio.a.a;

public class PluginVoice extends f implements a {
    public String name() {
        return "plugin-voice";
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            pin(new p(m.class));
        }
    }
}
