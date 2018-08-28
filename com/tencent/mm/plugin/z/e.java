package com.tencent.mm.plugin.z;

import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.z.a.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class e implements aq, a {
    public static e lsG;
    public int bTr;
    private String cXR;
    private i.a dVu = new 1(this);
    public c lsH = new c();
    public byte[] lsI;
    String lsJ;
    String lsK;
    int lsL;
    public long lsM;
    long lsN;
    long lsO;
    long lsP;
    boolean lsQ = false;
    final com.tencent.mm.ab.e lsR = new 2(this);

    public final void a(String str, int i, String str2, int i2, long j, long j2) {
        x.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d", new Object[]{str, Integer.valueOf(i)});
        this.lsN = (long) i2;
        this.lsO = j;
        this.lsP = j2;
        this.cXR = str2;
        String str3 = "MSG_SYNCHRONIZE_" + i + "_" + bi.VF();
        i iVar = new i();
        iVar.dPV = this.dVu;
        iVar.field_mediaId = str3;
        iVar.field_fullpath = str;
        iVar.field_fileType = b.MediaType_FILE;
        iVar.field_talker = (String) d.asG().asH().DT().get(2, null);
        iVar.field_priority = b.dOk;
        if (!g.ND().c(iVar)) {
            x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[]{str3});
            h.mEJ.a(466, 2, 1, false);
            h.mEJ.h(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.bTr)});
        }
    }

    public final void HK() {
        x.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[]{Boolean.valueOf(this.lsQ), Boolean.valueOf(com.tencent.mm.kernel.a.gI(com.tencent.mm.kernel.g.Eg().dpx))});
        if (this.lsQ && com.tencent.mm.kernel.a.gI(com.tencent.mm.kernel.g.Eg().dpx)) {
            x.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
            au.HU();
            c.b(this);
            this.lsQ = false;
            bfE();
        }
    }

    final void bfE() {
        x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg.");
        au.DF().a(TbsListener$ErrorCode.UNLZMA_FAIURE, this.lsR);
        au.DF().a(new d(this.lsJ, this.lsK, this.lsL, this.cXR), 0);
    }

    public final void onCancel() {
        x.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[]{aj.cin()});
        this.lsH.lsA = true;
    }
}
