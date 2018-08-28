package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.subapp.c.c.a;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bwv;
import com.tencent.mm.protocal.c.bww;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import junit.framework.Assert;

public final class b extends l implements k {
    al dHa = new al(new 1(this), true);
    private com.tencent.mm.ab.b diG;
    e diJ;
    private int endFlag = 0;
    private boolean eoE = false;
    long eoJ;
    private int eon = 0;
    String fileName;
    int retCode = 0;

    public b(String str) {
        boolean z = true;
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:" + str);
        this.fileName = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        this.eoE = false;
        if (this.fileName == null) {
            x.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        g Ok = h.Ok(this.fileName);
        if (Ok == null || !Ok.TM()) {
            x.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        boolean z;
        x.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + Ok.field_nettimes);
        String str = this.fileName;
        if (str == null) {
            z = false;
        } else {
            g Ok2 = h.Ok(str);
            if (Ok2 == null) {
                z = false;
            } else if (Ok2.field_nettimes >= 80) {
                z = false;
            } else {
                Ok2.field_nettimes++;
                Ok2.bWA = 16384;
                z = h.a(Ok2);
            }
        }
        if (z) {
            int i;
            int i2;
            a aVar = new a();
            if (Ok.field_status == 8) {
                x.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
                this.endFlag = 1;
                h.op(Ok.field_filename);
                i = 1;
            } else {
                if (Ok.field_status == 3) {
                    this.eoE = true;
                }
                c Ol = h.Ol(this.fileName);
                if (Ol == null) {
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                aVar = Ol.xU(Ok.field_offset);
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + aVar.ret + " readlen:" + aVar.bEG + " newOff:" + aVar.eon + " netOff:" + Ok.field_offset + " line:" + g.getLine());
                if (aVar.ret < 0) {
                    x.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + aVar.ret + " readlen:" + aVar.bEG + " newOff:" + aVar.eon + " netOff:" + Ok.field_offset);
                    h.nP(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                this.eon = aVar.eon;
                if (this.eon < Ok.field_offset || this.eon >= 469000) {
                    x.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.eon + " OldtOff:" + Ok.field_offset);
                    h.nP(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                this.endFlag = 0;
                if (aVar.bEG != 0 || this.eoE) {
                    if (this.eoE) {
                        if (Ok.field_totallen <= 0) {
                            x.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + Ok.field_totallen);
                            h.nP(this.fileName);
                            this.retCode = g.getLine() + 10000;
                            return -1;
                        } else if (Ok.field_totallen > this.eon && aVar.bEG < 6000) {
                            x.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + aVar.bEG + " newOff:" + aVar.eon + " netOff:" + Ok.field_offset + " totalLen:" + Ok.field_totallen);
                            h.nP(this.fileName);
                            this.retCode = g.getLine() + 10000;
                            return -1;
                        } else if (Ok.field_totallen <= this.eon) {
                            this.endFlag = 1;
                        }
                    }
                    i = 0;
                } else {
                    x.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                    h.nP(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
            }
            int i3 = Ok.field_voicelenght;
            if (i3 == 0) {
                i2 = ((this.eon - 6) / 32) * 20;
            } else {
                i2 = i3;
            }
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + Ok.field_msgid);
            com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
            aVar2.dIG = new bwv();
            aVar2.dIH = new bww();
            aVar2.uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
            aVar2.dIF = 329;
            aVar2.dII = 157;
            aVar2.dIJ = 1000000157;
            this.diG = aVar2.KT();
            bwv bwv = (bwv) this.diG.dID.dIL;
            bwv.jTv = q.GF();
            bwv.jTu = Ok.field_user;
            bwv.rjC = Ok.field_offset;
            bwv.rdo = Ok.field_clientid;
            bwv.rvX = i2;
            bwv.rgC = this.endFlag;
            bwv.rcq = Ok.field_msgid;
            bwv.rvY = i;
            bwv.sth = (int) (Ok.field_createtime / 1000);
            bwv.rVw = 1;
            if (i != 1) {
                bwv.rtW = new bhy().S(aVar.buf, aVar.bEG);
                bwv.rvV = aVar.bEG;
            } else {
                bwv.rtW = new bhy().b(com.tencent.mm.bk.b.bi(new byte[1]));
                bwv.rvV = 1;
            }
            x.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + Ok.field_msgid);
            x.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + bwv.rcq + " user:" + bwv.jTu + " offset:" + bwv.rjC + " dataLen:" + bwv.rtW.siI + " endFlag:" + bwv.rgC);
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + Ok.field_msgid + " file:" + this.fileName + " readBytes:" + aVar.bEG + " neTTTOff:" + Ok.field_offset + " neWWWOff:" + this.eon + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + Ok.field_status);
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + bwv.toString());
            this.eoJ = System.currentTimeMillis();
            return a(eVar, this.diG, this);
        }
        x.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
        h.nP(this.fileName);
        this.retCode = g.getLine() + 10000;
        return -1;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        bwv bwv = (bwv) ((com.tencent.mm.ab.b) qVar).dID.dIL;
        x.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + bwv.rjC + " dataLen:" + bwv.rtW.siI + " endFlag:" + bwv.rgC);
        return com.tencent.mm.ab.l.b.dJm;
    }

    protected final int Cc() {
        return 240;
    }

    protected final void a(l.a aVar) {
        h.nP(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + i2 + " errCode:" + i3);
        bwv bwv = (bwv) ((com.tencent.mm.ab.b) qVar).dID.dIL;
        bww bww = (bww) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        x.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + bww.toString());
        if (i2 == 4 && i3 == -22) {
            g Ok = h.Ok(this.fileName);
            if (Ok != null) {
                if (Ok.field_status == 3) {
                    au.HU();
                    bd dW = c.FT().dW((long) Ok.field_msglocalid);
                    dW.setContent(f.b(Ok.field_human, (long) Ok.field_voicelenght, false));
                    dW.setStatus(2);
                    au.HU();
                    c.FT().a((long) Ok.field_msglocalid, dW);
                }
                Ok.field_status = 97;
                Ok.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Ok.bWA = 320;
                h.a(Ok);
            }
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            h.nP(this.fileName);
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            int i4;
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + bww.rcq + " toUser:" + bwv.jTu);
            String str2 = this.fileName;
            int i5 = this.eon;
            long j = bww.rcq;
            String str3 = bww.rdo;
            int i6 = this.endFlag;
            if (str2 == null) {
                i4 = -1;
            } else {
                x.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + str2 + "] newOff:" + i5 + " SvrID:" + j + " clientID:" + str3 + " hasSendEndFlag " + i6);
                g Ok2 = h.Ok(str2);
                if (Ok2 == null) {
                    i4 = -1;
                } else {
                    Ok2.field_offset = i5;
                    Ok2.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    Ok2.bWA = 264;
                    if (bi.oW(Ok2.field_clientid) && str3 != null) {
                        Ok2.field_clientid = str3;
                        Ok2.bWA |= WXMediaMessage.TITLE_LENGTH_LIMIT;
                    }
                    if (Ok2.field_msgid == 0 && j != 0) {
                        Ok2.field_msgid = j;
                        Ok2.bWA |= 4;
                    }
                    i4 = 0;
                    x.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + Ok2.field_totallen + "  newOffset " + i5 + "  " + Ok2.field_status);
                    if (Ok2.field_totallen <= i5 && Ok2.field_status == 3 && i6 == 1) {
                        Ok2.field_status = 99;
                        Ok2.bWA |= 64;
                        au.HU();
                        bd dW2 = c.FT().dW((long) Ok2.field_msglocalid);
                        dW2.ep(Ok2.field_user);
                        dW2.ax(Ok2.field_msgid);
                        dW2.setStatus(2);
                        dW2.setContent(f.b(Ok2.field_human, (long) Ok2.field_voicelenght, false));
                        au.HU();
                        c.FT().a((long) Ok2.field_msglocalid, dW2);
                        x.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + str2 + " total:" + Ok2.field_totallen + " status:" + Ok2.field_status + " netTimes:" + Ok2.field_nettimes);
                        i4 = 1;
                        h.ol(str2);
                    }
                    if (!h.a(Ok2)) {
                        i4 = -4;
                    }
                }
            }
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + i4 + " file:" + this.fileName + " MsgSvrId:" + bww.rcq + " clientId:" + bww.rdo + " neWWOff:" + this.eon + " neTTTT:" + bww.rvV);
            if (i4 < 0) {
                h.nP(this.fileName);
                x.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + i4);
                this.diJ.a(i2, i3, str, this);
            } else if (i4 == 1) {
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
                this.diJ.a(i2, i3, str, this);
            } else {
                long j2 = this.eoE ? 0 : 500;
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + j2);
                this.dHa.J(j2, j2);
            }
        } else {
            x.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + i2 + " errCode:" + i3);
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 329;
    }
}
