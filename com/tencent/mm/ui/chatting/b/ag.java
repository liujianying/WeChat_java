package com.tencent.mm.ui.chatting.b;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.a.n;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.b.b.y;
import java.util.LinkedList;
import java.util.List;

@a(cwo = y.class)
public class ag extends a implements e, f.a, y {
    private static boolean tRX = false;
    private int djl = -1;
    @SuppressLint({"HandlerLeak"})
    private com.tencent.mm.sdk.platformtools.ag handler = new 1(this);
    private int tRW;
    private long tRY;

    public final void keepSignalling() {
        if (this.tRW == -2) {
            au.DF().a(new bg(new 3(this)), 0);
        }
    }

    public final void stopSignalling() {
        au.DF().a(new bg(new 4(this)), 0);
    }

    public final void Fe(int i) {
        if (this.bAG == null) {
            x.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[]{bi.cjd().toString()});
            return;
        }
        com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
        int i2 = (s.fq(aVar.getTalkerUserName()) || ((c) aVar.O(c.class)).cus()) ? 1 : 0;
        int intValue = ((Integer) au.HS().get(35, Integer.valueOf(10))).intValue();
        List linkedList = new LinkedList();
        linkedList.add(aVar.getTalkerUserName());
        if (intValue == -2) {
            if (i2 == 0 || !(i == 1 || i == 2)) {
                x.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[]{Integer.valueOf(i)});
                au.DF().a(new com.tencent.mm.modelsimple.f(linkedList, n.eo(i)), 0);
                return;
            }
            x.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[]{Integer.valueOf(i)});
        } else if (i2 != 0 || ab.XQ(aVar.getTalkerUserName()) || ab.XO(aVar.getTalkerUserName()) || aVar.oLT.ckW()) {
            x.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
        } else {
            if (this.tRY == 0) {
                List cvI = ((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvI();
                if (cvI != null && cvI.size() > 0) {
                    this.tRY = ((bd) cvI.get(0)).field_createTime;
                }
            }
            long bH = bi.bH(this.tRY);
            if (intValue == -1 || bH > ((long) intValue) * 1000) {
                x.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[]{Long.valueOf(bH / 1000), Integer.valueOf(intValue)});
                return;
            }
            x.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[]{Integer.valueOf(i), Long.valueOf(bH / 1000)});
            au.DF().a(new com.tencent.mm.modelsimple.f(linkedList, n.eo(i)), 0);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.bAG != null) {
            this.bAG.dismissDialog();
            if (10 == lVar.getType()) {
                boolean cvQ = ((w) this.bAG.O(w.class)).cvQ();
                boolean cvR = ((w) this.bAG.O(w.class)).cvR();
                if (((w) this.bAG.O(w.class)).cvT() || cvR || cvQ) {
                    x.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[]{Boolean.valueOf(cvQ), Boolean.valueOf(cvR), Boolean.valueOf(r0)});
                } else if (i == 0 && i2 == 0) {
                    com.tencent.mm.modelsimple.f fVar = (com.tencent.mm.modelsimple.f) lVar;
                    if (fVar.eeZ != null && fVar.eeZ.equals(this.bAG.getTalkerUserName())) {
                        if (fVar.content == null || fVar.content.length != 4) {
                            x.e("MicroMsg.SignallingComponent", "unknown directsend op");
                            return;
                        }
                        int r = n.r(fVar.content, 0);
                        x.d("MicroMsg.SignallingComponent", "directsend: status=" + r);
                        switch (r) {
                            case 1:
                                tRX = true;
                                ((o) this.bAG.O(o.class)).setMMTitle(R.l.chatting_status_typing);
                                this.handler.sendMessageDelayed(new Message(), 15000);
                                com.tencent.mm.sdk.b.a.sFg.m(new mq());
                                return;
                            case 3:
                                tRX = true;
                                ((o) this.bAG.O(o.class)).setMMTitle(R.l.chatting_status_voice_typing);
                                this.handler.sendMessageDelayed(new Message(), 15000);
                                return;
                            default:
                                tRX = false;
                                ((o) this.bAG.O(o.class)).cvn();
                                this.bAG.avj();
                                return;
                        }
                    }
                }
            }
        }
    }

    public final void a(f fVar, f.c cVar) {
        x.d("MicroMsg.SignallingComponent", "on msg notify change");
        if (this.bAG == null) {
            x.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
        } else if (this.bAG.getTalkerUserName().equals(cVar.talker) && "insert".equals(cVar.lcx) && cVar.lcy.size() > 0 && ((bd) cVar.lcy.get(0)).field_isSend == 0) {
            x.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[]{Integer.valueOf(((bd) cVar.lcy.get(0)).field_flag), Long.valueOf(((bd) cVar.lcy.get(0)).field_msgSeq)});
            this.tRY = bi.VF();
        }
    }

    public final void a(com.tencent.mm.ui.chatting.c.a aVar) {
        super.a(aVar);
        x.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[]{this});
        au.DF().a(new bg(new 2(this)), 0);
    }

    public final void cun() {
        super.cun();
        x.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[]{this});
        this.handler.removeCallbacksAndMessages(null);
    }

    public final void cpH() {
        au.HU();
        com.tencent.mm.model.c.FT().a(this, Looper.getMainLooper());
        au.DF().a(10, this);
    }

    public final void cpK() {
        au.HU();
        com.tencent.mm.model.c.FT().a(this);
        au.DF().b(10, this);
    }
}
