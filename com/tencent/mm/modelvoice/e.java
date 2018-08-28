package com.tencent.mm.modelvoice;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.sq;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e extends l implements k {
    private static ao eoC = null;
    private static List<c> eoD = new ArrayList();
    private String bWJ;
    private al dHa = new al(new 2(this), false);
    private b diG;
    private com.tencent.mm.ab.e diJ;
    private String eoB;
    private boolean eoE = false;
    private boolean eoF = false;
    public String fileName;
    public int retCode = 0;

    public static void a(ao aoVar) {
        if (eoC == null) {
            eoC = aoVar;
        }
    }

    public static void a(c cVar) {
        if (!eoD.contains(cVar)) {
            eoD.add(cVar);
        }
    }

    public static void b(c cVar) {
        eoD.remove(cVar);
    }

    private void doNotify() {
        bd os = q.os(this.fileName);
        if (os != null) {
            if (eoC != null) {
                eoC.a(os);
            }
            for (c 1 : eoD) {
                ah.A(new 1(this, 1, os));
            }
        }
    }

    public e(p pVar) {
        boolean z;
        Assert.assertTrue(pVar != null);
        this.fileName = pVar.fileName;
        if (this.fileName != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.eoB = pVar.eoB;
        this.bWJ = pVar.bWJ;
        x.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", new Object[]{this.fileName, this.eoB, this.bWJ});
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        if (this.fileName == null) {
            x.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        p ot = q.ot(this.fileName);
        if (ot == null || !ot.TL()) {
            x.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        x.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + ot.enO);
        if (q.oj(this.fileName)) {
            int i = ot.emu - ot.enH;
            if (i > 0) {
                if (ot.dHI == ot.emu) {
                    this.eoE = true;
                }
                a aVar = new a();
                aVar.dIG = new sq();
                aVar.dIH = new sr();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvoice";
                aVar.dIF = 128;
                aVar.dII = 20;
                aVar.dIJ = 1000000020;
                this.diG = aVar.KT();
                sq sqVar = (sq) this.diG.dID.dIL;
                sqVar.rdo = ot.clientId;
                sqVar.rcq = ot.bYu;
                sqVar.rvV = i;
                sqVar.rjC = ot.enH;
                if (s.fq(this.bWJ)) {
                    sqVar.rvj = this.bWJ;
                    sqVar.rvW = ot.epJ;
                }
                x.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[]{sqVar.rdo, Integer.valueOf(sqVar.rci), Long.valueOf(sqVar.rcq), Integer.valueOf(sqVar.rvV), Integer.valueOf(sqVar.rjC), sqVar.rvj, Long.valueOf(sqVar.rvW)});
                return a(eVar, this.diG, this);
            } else if (ot.status == 5) {
                this.eoF = true;
                x.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + ot.emu + " Local:" + ot.enH);
                this.retCode = g.getLine() + 10000;
                return -1;
            } else {
                q.a(this.fileName, ot.enH, null);
                this.retCode = g.getLine() + 10000;
                return -1;
            }
        }
        x.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        q.nP(this.fileName);
        this.retCode = g.getLine() + 10000;
        return -1;
    }

    protected final int a(q qVar) {
        sq sqVar = (sq) ((b) qVar).dID.dIL;
        if (sqVar.rcq != 0 && sqVar.rdo != null && sqVar.rdo.length() != 0 && sqVar.rvV > 0 && sqVar.rjC >= 0) {
            return l.b.dJm;
        }
        q.nP(this.fileName);
        return l.b.dJn;
    }

    protected final int Cc() {
        return 100;
    }

    protected final void a(l.a aVar) {
        h.mEJ.a(111, 233, 1, false);
        q.nP(this.fileName);
    }

    public final boolean KY() {
        boolean KY = super.KY();
        if (KY) {
            h.mEJ.a(111, 232, 1, false);
        }
        return KY;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        sr srVar = (sr) ((b) qVar).dIE.dIL;
        if (srVar.rvY == 1) {
            x.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
            q.oo(this.fileName);
        } else if (i3 == -22) {
            q.nP(this.fileName);
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            h.mEJ.a(111, 231, 1, false);
            q.nP(this.fileName);
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + srVar.rtW.siI + " fileOff:" + srVar.rjC);
            if (srVar.rtW.siK == null) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
                q.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
                return;
            }
            byte[] toByteArray = srVar.rtW.siK.toByteArray();
            if (toByteArray.length == 0) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
                q.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
                return;
            }
            int write = q.aC(this.eoB, this.fileName).write(toByteArray, toByteArray.length, srVar.rjC);
            if (write < 0) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + write);
                q.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
                return;
            }
            q.c(this.fileName, toByteArray, toByteArray.length);
            x.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + write + " voiceFormat:" + this.eoB);
            write = q.a(this.fileName, write, null);
            if (write < 0) {
                h.mEJ.a(111, 229, 1, false);
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + write);
                this.diJ.a(i2, i3, str, this);
            } else if (write == 1) {
                doNotify();
                this.diJ.a(i2, i3, str, this);
            } else {
                long j = 1000;
                if (this.eoE) {
                    j = 0;
                }
                this.dHa.J(j, j);
            }
        } else {
            h.mEJ.a(111, 230, 1, false);
            x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " resp:" + qVar.Id().qWB);
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 128;
    }
}
