package com.tencent.mm.ui.transmit;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;
import java.io.ByteArrayOutputStream;

class MsgRetransmitUI$17 implements a {
    final /* synthetic */ String bAd;
    final /* synthetic */ bd dAs;
    final /* synthetic */ g$a fZg;
    final /* synthetic */ b tIK;
    final /* synthetic */ MsgRetransmitUI uDL;
    final /* synthetic */ byte[] uDT;
    final /* synthetic */ String uDU;

    MsgRetransmitUI$17(MsgRetransmitUI msgRetransmitUI, b bVar, bd bdVar, g$a g_a, String str, String str2, byte[] bArr) {
        this.uDL = msgRetransmitUI;
        this.tIK = bVar;
        this.dAs = bdVar;
        this.fZg = g_a;
        this.bAd = str;
        this.uDU = str2;
        this.uDT = bArr;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i == 0 && keep_progressinfo != null) {
            this.tIK.field_offset = (long) keep_progressinfo.field_finishedLength;
            ao.asF().c(this.tIK, new String[0]);
        }
        if (i == 0 && keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            this.tIK.field_status = 199;
            this.tIK.field_offset = this.tIK.field_totalLen;
            ao.asF().c(this.tIK, new String[0]);
            this.dAs.setStatus(3);
            au.HU();
            c.FT().a(this.dAs.field_msgId, this.dAs);
            l.a(this.fZg, this.fZg.appId, this.fZg.appName, this.bAd, this.uDU, this.uDT, MsgRetransmitUI.a(this.uDL));
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
