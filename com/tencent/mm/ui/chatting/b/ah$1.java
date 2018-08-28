package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.po;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ah$1 extends c<po> {
    final /* synthetic */ ah tSj;

    ah$1(ah ahVar) {
        this.tSj = ahVar;
        this.sFo = po.class.getName().hashCode();
    }

    private boolean a(po poVar) {
        byte[] bArr = poVar.cav.data;
        if (bArr != null) {
            bz bzVar = new bz();
            try {
                bzVar.aG(bArr);
                final String a = ab.a(bzVar.rcs);
                x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr SilenceNotifyEvent callback chatRoomId[%s], current talker[%s]", new Object[]{a, this.tSj.bAG.oLT.field_username});
                if (!bi.oW(a) && a.equals(this.tSj.bAG.oLT.field_username)) {
                    final int i = bzVar.rcr;
                    final int i2 = bzVar.rct;
                    au.Em().H(new Runnable() {
                        public final void run() {
                            long j;
                            long j2;
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr SilenceNotifyEvent in chatting lastSeq[%d], undeliverCount[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                            long j3 = (long) i;
                            long j4 = (long) i;
                            long j5 = (long) i2;
                            long Ha = ((i) g.l(i.class)).bcY().Ha(a);
                            if (Ha <= 0 || Ha >= j4) {
                                j = j5;
                                j2 = j4;
                            } else {
                                j = (Ha - Ha) - 1;
                                j2 = Ha;
                            }
                            if (j <= 0) {
                                j4 = 1;
                            } else {
                                j4 = j;
                            }
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr SilenceNotifyEvent in chatting down [%d, %d, %d, %d]", new Object[]{Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(Ha), Long.valueOf(j4)});
                            ah$1.this.tSj.tSb = false;
                            o.PN().a(new a(a, (int) j3, (int) j2, (int) j4, 0), ah$1.this.tSj);
                        }
                    });
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", e, "summerbadcr SilenceNotifyEvent callback parse:", new Object[0]);
            }
        } else {
            x.e("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr silenceNotifyListener callback event data is null");
        }
        return false;
    }
}
