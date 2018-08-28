package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class i$3 extends ag {
    final /* synthetic */ i orB;

    i$3(i iVar) {
        this.orB = iVar;
    }

    public final void handleMessage(Message message) {
        x.d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
        if (!i.b(this.orB)) {
            au.HV().b(this.orB);
            au.HV().yC();
            this.orB.ew(200);
        }
    }
}
