package com.tencent.mm.modelvoice;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bwv;
import com.tencent.mm.protocal.c.bww;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import junit.framework.Assert;

public final class f extends l implements k {
    al dHa;
    private b diG;
    e diJ;
    private int endFlag;
    private boolean eoE;
    private int eoI;
    long eoJ;
    private int eon;
    public String fileName;
    public int retCode;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        boolean z = true;
        this.retCode = 0;
        this.eon = 0;
        this.eoE = false;
        this.endFlag = 0;
        this.dHa = new al(new 1(this), true);
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:" + str);
        this.fileName = str;
        this.eoI = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        this.eoE = false;
        if (this.fileName == null) {
            x.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        p ot = q.ot(this.fileName);
        if (ot == null || !ot.TM()) {
            x.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        x.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + ot.enO);
        if (q.oj(this.fileName)) {
            int i;
            int i2;
            g gVar = new g();
            if (ot.status == 8) {
                x.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
                i = 1;
                this.endFlag = 0;
                q.op(ot.fileName);
                i2 = 0;
            } else {
                if (ot.status == 3) {
                    this.eoE = true;
                }
                b ok = q.ok(this.fileName);
                if (ok == null) {
                    this.retCode = g.getLine() + 10000;
                    x.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[]{this.fileName});
                    return -1;
                }
                int format = ok.getFormat();
                x.d("MicroMsg.NetSceneUploadVoice", "format " + format);
                g br = ok.br(ot.emu, 6000);
                x.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + br.ret + " readlen:" + br.bEG + " newOff:" + br.eon + " netOff:" + ot.emu + " line:" + g.getLine());
                if (br.ret < 0) {
                    h.mEJ.a(111, 241, 1, false);
                    x.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + br.ret + " readlen:" + br.bEG + " newOff:" + br.eon + " netOff:" + ot.emu);
                    q.nP(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                this.eon = br.eon;
                if (this.eon < ot.emu || this.eon >= 469000) {
                    h.mEJ.a(111, 240, 1, false);
                    x.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.eon + " OldtOff:" + ot.emu);
                    q.nP(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                this.endFlag = 0;
                if (br.bEG != 0 || this.eoE) {
                    if (this.eoE) {
                        if (ot.dHI <= 0) {
                            x.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + ot.dHI);
                            q.nP(this.fileName);
                            this.retCode = g.getLine() + 10000;
                            return -1;
                        } else if (ot.dHI > this.eon && br.bEG < 6000) {
                            x.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + br.bEG + " newOff:" + br.eon + " netOff:" + ot.emu + " totalLen:" + ot.dHI);
                            q.nP(this.fileName);
                            this.retCode = g.getLine() + 10000;
                            return -1;
                        } else if (ot.dHI <= this.eon) {
                            Integer num = (Integer) q.epM.get(q.getFullPath(this.fileName));
                            if (!(num == null || num.intValue() == 0)) {
                                g br2 = ok.br(0, ((Integer) q.epN.get(q.getFullPath(this.fileName))).intValue());
                                int b = q.b(num.intValue() & 255, br2.buf, br2.bEG);
                                if (num.intValue() != b) {
                                    x.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[]{Integer.valueOf(b), num, Integer.valueOf(i2), Integer.valueOf(br2.bEG)});
                                    x.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + br.bEG + " newOff:" + br.eon + " netOff:" + ot.emu + " totalLen:" + ot.dHI);
                                    h.mEJ.a(111, 173, 1, false);
                                    q.epM.put(q.getFullPath(this.fileName), Integer.valueOf(b));
                                    num = (Integer) q.epO.get(q.getFullPath(this.fileName));
                                    if (!(num == null || num.intValue() == 0 || num.intValue() == q.a(0, br2.buf, br2.bEG))) {
                                        x.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[]{num, Integer.valueOf(q.a(0, br2.buf, br2.bEG))});
                                        q.nP(this.fileName);
                                        this.retCode = g.getLine() + 10000;
                                        h.mEJ.a(111, 174, 1, false);
                                        return -1;
                                    }
                                }
                            }
                            this.endFlag = 1;
                        }
                    }
                    i2 = format;
                    i = 0;
                    gVar = br;
                } else {
                    x.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
            }
            int i3 = ot.epI;
            x.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                i3 = q.ou(this.fileName);
                x.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[]{Integer.valueOf(i3)});
                if (i3 < 0) {
                    i3 = q.iF(this.eon);
                    x.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[]{Integer.valueOf(i3)});
                }
            }
            int i4 = i3;
            a aVar = new a();
            aVar.dIG = new bwv();
            aVar.dIH = new bww();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadvoice";
            aVar.dIF = 127;
            aVar.dII = 19;
            aVar.dIJ = 1000000019;
            this.diG = aVar.KT();
            bwv bwv = (bwv) this.diG.dID.dIL;
            bwv.jTv = q.GF();
            bwv.jTu = ot.bWJ;
            bwv.rjC = ot.emu;
            bwv.rdo = ot.clientId;
            bwv.rvX = i4;
            bwv.rgC = this.endFlag;
            bwv.rcq = ot.bYu;
            bwv.rvY = i;
            bwv.sti = this.eoI;
            bwv.rco = bf.Is();
            bwv.rco = com.tencent.mm.j.a.a.yw().z(ot.bWJ, ot.enN);
            bwv.rVw = i2;
            if (i != 1) {
                bwv.rtW = new bhy().S(gVar.buf, gVar.bEG);
                bwv.rvV = gVar.bEG;
            } else {
                bwv.rtW = new bhy().b(com.tencent.mm.bk.b.bi(new byte[1]));
                bwv.rvV = 1;
            }
            x.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + ot.bYu);
            x.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + bwv.rcq + " user:" + bwv.jTu + " offset:" + bwv.rjC + " dataLen:" + bwv.rtW.siI + " endFlag:" + bwv.rgC);
            x.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + ot.bYu + " voiceFormat:" + i2 + " file:" + this.fileName + " readBytes:" + gVar.bEG + " neTTTOff:" + ot.emu + " neWWWOff:" + this.eon + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + ot.status + " voiceLen:" + i4);
            this.eoJ = System.currentTimeMillis();
            return a(eVar, this.diG, this);
        }
        x.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        q.nP(this.fileName);
        this.retCode = g.getLine() + 10000;
        return -1;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        bwv bwv = (bwv) ((b) qVar).dID.dIL;
        x.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + bwv.rcq + " offset:" + bwv.rjC + " dataLen:" + bwv.rtW.siI + " endFlag:" + bwv.rgC);
        if ((bwv.rcq != 0 || bwv.rjC == 0) && ((bwv.rtW != null && bwv.rtW.siI != 0) || bwv.rgC == 1 || bwv.rvY == 1)) {
            return l.b.dJm;
        }
        return l.b.dJn;
    }

    protected final int Cc() {
        return 60;
    }

    public final boolean KY() {
        boolean KY = super.KY();
        if (KY) {
            h.mEJ.a(111, 239, 1, false);
        }
        return KY;
    }

    protected final void a(l.a aVar) {
        h.mEJ.a(111, 238, 1, false);
        q.nP(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + i2 + " errCode:" + i3);
        bwv bwv = (bwv) ((b) qVar).dID.dIL;
        bww bww = (bww) ((b) qVar).dIE.dIL;
        if (i2 == 4 && i3 == -22) {
            q.nQ(this.fileName);
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            q.nP(this.fileName);
            h.mEJ.a(111, 237, 1, false);
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + bww.rcq + " toUser:" + bwv.jTu);
            if (bww.rcq > 0 || ab.gY(bwv.jTu)) {
                x.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Long.valueOf(bww.rcq), Integer.valueOf(af.exn)});
                if (10007 == af.exm && af.exn != 0) {
                    bww.rcq = (long) af.exn;
                    af.exn = 0;
                }
                int a = q.a(this.fileName, this.eon, bww.rcq, bww.rdo, this.endFlag, this.eoI);
                x.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + a + " file:" + this.fileName + " MsgSvrId:" + bww.rcq + " clientId:" + bww.rdo + " neWWOff:" + this.eon + " neTTTT:" + bww.rvV + " forwardflag:" + this.eoI);
                if (a < 0) {
                    q.nP(this.fileName);
                    x.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + a);
                    this.diJ.a(i2, i3, str, this);
                    return;
                } else if (a == 1) {
                    x.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
                    com.tencent.mm.modelstat.b.ehL.f(((i) com.tencent.mm.kernel.g.l(i.class)).bcY().dW((long) q.ot(this.fileName).enN));
                    this.diJ.a(i2, i3, str, this);
                    return;
                } else {
                    long j = this.eoE ? 0 : 500;
                    x.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + j);
                    this.dHa.J(j, j);
                    return;
                }
            }
            h.mEJ.a(111, 235, 1, false);
            x.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + bww.rcq + " netoff:" + bww.rjC);
            q.nP(this.fileName);
            this.diJ.a(i2, i3, str, this);
        } else {
            h.mEJ.a(111, 236, 1, false);
            x.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + i2 + " errCode:" + i3);
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 127;
    }
}
