package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqpinyin.voicerecoapi.c;
import java.io.IOException;

class WearMessageLogic$b extends d {
    public int mFO;
    public int pJs;
    public int pJt;
    public byte[] pJu;
    final /* synthetic */ WearMessageLogic pJv;

    private WearMessageLogic$b(WearMessageLogic wearMessageLogic) {
        this.pJv = wearMessageLogic;
    }

    /* synthetic */ WearMessageLogic$b(WearMessageLogic wearMessageLogic, byte b) {
        this(wearMessageLogic);
    }

    protected final void execute() {
        switch (this.pJt) {
            case 30001:
                p pVar = a.bSl().pIM.pJf;
                int i = this.mFO;
                byte[] bArr = this.pJu;
                if (!pVar.ftL.contains(Integer.valueOf(i))) {
                    cfe cfe = new cfe();
                    try {
                        cfe.aG(bArr);
                    } catch (IOException e) {
                    }
                    if (pVar.pKb != i) {
                        pVar.reset();
                        pVar.pKb = i;
                        x.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[]{Integer.valueOf(pVar.pKb)});
                        e.deleteFile(p.pJW);
                        if (pVar.pJZ == null) {
                            pVar.pJZ = new com.tencent.mm.e.c.d();
                            pVar.pJZ.df(p.pJW);
                        }
                        if (pVar.pJY == null) {
                            pVar.pJY = new c(1500000);
                            if (pVar.pJY.start() != 0) {
                                pVar.pKc = -2;
                                return;
                            }
                        }
                        String str = cfe.szk;
                        if (pVar.pJX == null) {
                            ah.A(new p$1(pVar, str));
                        }
                        pVar.a(i, cfe);
                        return;
                    } else if (cfe.szN) {
                        x.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[]{Integer.valueOf(i)});
                        pVar.reset();
                        return;
                    } else if (cfe.szM) {
                        pVar.a(i, cfe);
                        if (pVar.pJZ != null) {
                            pVar.pJZ.wA();
                            pVar.pJZ = null;
                            x.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
                        }
                        if (pVar.pJY != null) {
                            pVar.pJY.stop();
                            pVar.pJY = null;
                            x.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
                        }
                        if (pVar.pJX != null) {
                            pVar.pJX.eoE = true;
                            if (!pVar.ceW) {
                                au.DF().a(pVar.pJX, 0);
                            }
                            pVar.pJX = null;
                            x.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
                            return;
                        }
                        return;
                    } else {
                        pVar.a(i, cfe);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final String getName() {
        return "LongConnectTask";
    }
}
