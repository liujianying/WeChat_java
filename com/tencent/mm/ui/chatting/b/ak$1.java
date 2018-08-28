package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;

class ak$1 implements Runnable {
    final /* synthetic */ fi qjL;
    final /* synthetic */ ak tSU;

    ak$1(ak akVar, fi fiVar) {
        this.tSU = akVar;
        this.qjL = fiVar;
    }

    public final void run() {
        if (this.qjL.bNG.aoy) {
            if (bi.oW(this.qjL.bNG.content)) {
                if (this.qjL.bNG.state == 2) {
                    x.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[]{this.qjL.bNF.bNH});
                    ak.a(this.tSU, ak.a(this.tSU).getString(R.l.chatting_transform_fail));
                }
                ak.a(this.tSU, Long.valueOf(this.qjL.bNF.bNH).longValue());
                ak.b(this.tSU, Long.valueOf(this.qjL.bNF.bNH).longValue());
                this.tSU.tSR = false;
                ak.b(this.tSU);
            } else {
                x.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[]{this.qjL.bNF.bNH});
                bd c = ak.c(this.tSU, Long.valueOf(this.qjL.bNF.bNH).longValue());
                if (c != null) {
                    this.tSU.a(Long.valueOf(this.qjL.bNF.bNH).longValue(), this.qjL.bNG.content, b.ues);
                    c.cmE();
                    au.HU();
                    c.FT().a(c.field_msgId, c);
                    ak.b(this.tSU, Long.valueOf(this.qjL.bNF.bNH).longValue());
                    ak.b(this.tSU);
                }
                this.tSU.tSR = false;
            }
            ak.c(this.tSU);
            return;
        }
        if (!bi.oW(this.qjL.bNG.content)) {
            this.tSU.a(Long.valueOf(this.qjL.bNF.bNH).longValue(), this.qjL.bNG.content, b.uer);
            x.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[]{this.qjL.bNF.bNH});
        }
        ak.b(this.tSU);
    }
}
