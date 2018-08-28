package com.tencent.mm.plugin.video;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.x;

public class PluginVideo extends f implements a {
    public String name() {
        return "plugin-video";
    }

    public void execute(g gVar) {
        x.i("MicroMsg.PluginVideo", "plugin video execute");
        if (gVar.ES()) {
            pin(new p(o.class));
            pin(new p(d.class));
            pin(new p(n.class));
        }
    }
}
