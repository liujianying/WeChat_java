package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class j$10 implements a {
    final /* synthetic */ j kzY;

    j$10(j jVar) {
        this.kzY = jVar;
    }

    public final void ga(boolean z) {
        if (i.aXt().aXl()) {
            x.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[]{Boolean.valueOf(z)});
            com.tencent.mm.plugin.ipcall.a.c.a aXq = i.aXq();
            int tf = z ? aXq.kqx.tf(412) : aXq.kqx.tf(413);
            if (tf < 0) {
                x.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:" + tf);
            }
            i.aXs().kqc.setMute(z);
            h.mEJ.h(12057, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        }
    }
}
