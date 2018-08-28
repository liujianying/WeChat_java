package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.protocal.c.sn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class ac extends l implements k {
    public long bJC;
    bd bXQ;
    f dVg;
    public String dVk;
    private i$a dVu;
    private b diG;
    e diJ;
    private long gVV;
    public String mediaId;
    public b qAe;
    long qAh;
    private int qAi;
    String qAj;
    public boolean qAk;
    private boolean qAl;
    private boolean qAm;
    int retCode;
    long startTime;
    private int type;

    public ac(String str) {
        this(str, null, 0);
    }

    public ac(long j, String str, f fVar) {
        this(str, fVar, 0);
        this.bJC = j;
    }

    public ac(long j, long j2, f fVar) {
        this.qAe = null;
        this.qAh = -1;
        this.mediaId = "";
        this.bJC = 0;
        this.bXQ = null;
        this.dVk = "";
        this.startTime = 0;
        this.qAi = -1;
        this.qAj = "";
        this.type = 0;
        this.retCode = 0;
        this.qAk = false;
        this.qAl = false;
        this.gVV = 0;
        this.qAm = false;
        this.dVu = new 1(this);
        this.gVV = j2;
        this.bJC = j;
        this.qAe = ao.asF().fH(j);
        this.dVg = fVar;
        this.qAl = true;
        if (this.qAe == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId" + j, new Object[]{Long.valueOf(j2)});
            return;
        }
        a aVar = new a();
        aVar.dIG = new sm();
        aVar.dIH = new sn();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.dIF = 221;
        aVar.dII = 106;
        aVar.dIJ = 1000000106;
        this.diG = aVar.KT();
    }

    public ac(b bVar) {
        this.qAe = null;
        this.qAh = -1;
        this.mediaId = "";
        this.bJC = 0;
        this.bXQ = null;
        this.dVk = "";
        this.startTime = 0;
        this.qAi = -1;
        this.qAj = "";
        this.type = 0;
        this.retCode = 0;
        this.qAk = false;
        this.qAl = false;
        this.gVV = 0;
        this.qAm = false;
        this.dVu = new 1(this);
        this.qAe = bVar;
        this.qAk = true;
        this.mediaId = this.qAe.field_mediaId;
        this.dVg = null;
        this.type = 0;
        if (bVar == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
            return;
        }
        a aVar = new a();
        aVar.dIG = new sm();
        aVar.dIH = new sn();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.dIF = 221;
        aVar.dII = 106;
        aVar.dIJ = 1000000106;
        this.diG = aVar.KT();
        x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[]{bVar.field_fileFullPath, Boolean.valueOf(true), bi.cjd()});
    }

    public ac(String str, f fVar, int i) {
        this.qAe = null;
        this.qAh = -1;
        this.mediaId = "";
        this.bJC = 0;
        this.bXQ = null;
        this.dVk = "";
        this.startTime = 0;
        this.qAi = -1;
        this.qAj = "";
        this.type = 0;
        this.retCode = 0;
        this.qAk = false;
        this.qAl = false;
        this.gVV = 0;
        this.qAm = false;
        this.dVu = new 1(this);
        this.mediaId = str;
        this.dVg = fVar;
        this.type = i;
        this.qAe = ao.asF().SR(str);
        if (this.qAe == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + str);
            return;
        }
        a aVar = new a();
        aVar.dIG = new sm();
        aVar.dIH = new sn();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.dIF = 221;
        aVar.dII = 106;
        aVar.dIJ = 1000000106;
        this.diG = aVar.KT();
        x.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[]{Integer.valueOf(i), this.qAe.field_fileFullPath, Long.valueOf(this.qAe.field_type), this.qAe.field_signature, bi.cjd()});
    }

    public final void cbT() {
        this.qAm = true;
        if (this.qAm) {
            com.tencent.mm.a.e.e(this.qAe.field_fileFullPath, "#!AMR\n".getBytes());
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (this.qAe == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", g.Ac() + " get info failed mediaId:" + this.mediaId);
            this.retCode = -10000 - g.getLine();
            return -1;
        }
        au.HU();
        this.bXQ = c.FT().dW(this.bJC);
        if (this.bXQ == null || this.bXQ.field_msgId != this.bJC) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", g.Ac() + " get msginfo failed mediaId:%s  msgId:%d", new Object[]{this.mediaId, Long.valueOf(this.bJC)});
            this.retCode = -10000 - g.getLine();
            return -1;
        }
        if (this.startTime == 0) {
            this.startTime = bi.VF();
            this.qAi = (int) this.qAe.field_offset;
        }
        sm smVar;
        if (this.gVV != 0) {
            smVar = (sm) this.diG.dID.dIL;
            smVar.hbL = q.GF();
            smVar.rdV = (int) this.qAe.field_totalLen;
            smVar.rdW = (int) this.qAe.field_offset;
            smVar.rdX = 0;
            smVar.hcE = 40;
            smVar.rcq = this.gVV;
            return a(eVar, this.diG, this);
        }
        Object obj;
        int i;
        String str = this.bXQ.field_content;
        if (s.fq(this.bXQ.field_talker)) {
            int iA = com.tencent.mm.model.bd.iA(this.bXQ.field_content);
            if (iA != -1) {
                str = (this.bXQ.field_content + " ").substring(iA + 2).trim();
            }
        }
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(bi.WT(str));
        if (gp == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[]{this.mediaId});
            obj = null;
        } else {
            x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[]{Long.valueOf(this.bJC), Long.valueOf(this.qAe.field_totalLen), this.qAe.field_fileFullPath, gp.dwD, bi.Xf(gp.dwK)});
            if ((bi.oW(gp.dwD) && bi.oW(gp.dwu)) || bi.oW(gp.dwK)) {
                x.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[]{Long.valueOf(this.bJC), gp.dwD, bi.Xf(gp.dwK)});
                obj = null;
            } else {
                this.dVk = d.a("downattach", this.qAe.field_createTime, this.bXQ.field_talker, this.qAh);
                if (bi.oW(this.dVk)) {
                    x.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[]{Long.valueOf(this.qAh)});
                    obj = null;
                } else {
                    com.tencent.mm.a.e.cs(this.qAe.field_fileFullPath);
                    this.qAj = this.qAe.field_fileFullPath + "_tmp";
                    i iVar = new i();
                    iVar.field_mediaId = this.dVk;
                    iVar.field_fullpath = this.qAj;
                    i = (gp.dws != 0 || gp.dwo > 26214400) ? com.tencent.mm.modelcdntran.b.dOm : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                    iVar.field_fileType = i;
                    iVar.field_totalLen = (int) this.qAe.field_totalLen;
                    iVar.field_aesKey = gp.dwK;
                    iVar.field_fileId = gp.dwD;
                    iVar.field_svr_signature = this.qAe.field_signature;
                    iVar.field_fake_bigfile_signature_aeskey = this.qAe.field_fakeAeskey;
                    iVar.field_fake_bigfile_signature = this.qAe.field_fakeSignature;
                    iVar.field_onlycheckexist = false;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
                    iVar.dPV = this.dVu;
                    iVar.field_chattype = s.fq(this.bXQ.field_talker) ? 1 : 0;
                    if (!bi.oW(gp.dwu)) {
                        iVar.field_fileType = 19;
                        iVar.field_authKey = gp.dwA;
                        iVar.dPW = gp.dwu;
                        iVar.field_fileId = "";
                    }
                    x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[]{Integer.valueOf(iVar.field_fileType), iVar.field_fullpath, bi.Xf(iVar.field_aesKey), bi.Xf(iVar.field_svr_signature), bi.Xf(iVar.field_fake_bigfile_signature_aeskey), bi.Xf(iVar.field_fake_bigfile_signature), Boolean.valueOf(iVar.field_onlycheckexist)});
                    if (com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                        if (this.qAe.field_isUseCdn != 1) {
                            this.qAe.field_isUseCdn = 1;
                            boolean c = ao.asF().c(this.qAe, new String[0]);
                            if (!c) {
                                x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:" + c);
                                this.retCode = -10000 - g.getLine();
                                this.diJ.a(3, -1, "", this);
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
                        this.dVk = "";
                        obj = null;
                    }
                }
            }
        }
        if (obj != null) {
            x.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[]{this.mediaId});
            return 0;
        }
        if (this.qAe.field_status == 102) {
            this.qAe.field_status = 101;
            if (!this.qAk) {
                ao.asF().c(this.qAe, new String[0]);
            }
        }
        this.qAh = this.qAe.sKx;
        if (bi.oW(this.qAe.field_mediaSvrId) && this.gVV == 0) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
            this.retCode = -10000 - g.getLine();
            return -1;
        } else if (this.qAe.field_totalLen <= 0 || this.qAe.field_totalLen > 26214400) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.qAe.field_totalLen);
            this.retCode = -10000 - g.getLine();
            return -1;
        } else if (bi.oW(this.qAe.field_fileFullPath) && this.gVV == 0) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
            this.retCode = -10000 - g.getLine();
            return -1;
        } else {
            i = com.tencent.mm.a.e.cm(this.qAe.field_fileFullPath);
            if (this.qAm) {
                i -= 6;
                if (i <= 0) {
                    i = 0;
                }
            }
            if (((long) i) != this.qAe.field_offset) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.qAe.field_offset);
                this.retCode = -10000 - g.getLine();
                return -1;
            }
            x.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[]{this.qAe.field_appId, this.qAe.field_mediaSvrId, Long.valueOf(this.qAe.field_sdkVer)});
            smVar = (sm) this.diG.dID.dIL;
            smVar.jQb = this.qAe.field_appId;
            smVar.rvP = this.qAe.field_mediaSvrId;
            smVar.rdn = (int) this.qAe.field_sdkVer;
            smVar.hbL = q.GF();
            smVar.rdV = (int) this.qAe.field_totalLen;
            smVar.rdW = (int) this.qAe.field_offset;
            smVar.rdX = 0;
            if (this.gVV != 0) {
                smVar.rcq = this.gVV;
            }
            if (this.type != 0) {
                smVar.hcE = this.type;
            } else {
                smVar.hcE = (int) this.qAe.field_type;
            }
            return a(eVar, this.diG, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bi.oW(this.dVk)) {
            x.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.dVk});
        } else if (i2 == 0 && i3 == 0) {
            sn snVar = (sn) ((b) qVar).dIE.dIL;
            this.qAe.field_totalLen = (long) snVar.rdV;
            if (snVar.rvP != null && !snVar.rvP.equals(this.qAe.field_mediaSvrId)) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
                this.retCode = -10000 - g.getLine();
                this.diJ.a(3, -1, "", this);
            } else if (((long) snVar.rdW) != this.qAe.field_offset) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + snVar.rdW);
                this.retCode = -10000 - g.getLine();
                this.diJ.a(3, -1, "", this);
            } else if (((long) snVar.rdX) + this.qAe.field_offset > this.qAe.field_totalLen) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + snVar.rdX + " off:" + this.qAe.field_offset + " total?:" + this.qAe.field_totalLen);
                this.retCode = -10000 - g.getLine();
                this.diJ.a(3, -1, "", this);
            } else {
                byte[] a = ab.a(snVar.rtW);
                if (a == null || a.length == 0 || a.length != snVar.rdX) {
                    x.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
                    this.retCode = -10000 - g.getLine();
                    this.diJ.a(3, -1, "", this);
                    return;
                }
                String str2 = new String(a);
                x.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[]{Boolean.valueOf(this.qAl)});
                if (this.qAe.field_offset < this.qAe.field_totalLen && this.qAl) {
                    au.HU();
                    bd dW = c.FT().dW(this.qAe.field_msgInfoId);
                    StringBuffer stringBuffer;
                    if (!str2.startsWith("<appmsg")) {
                        if (!dW.field_content.startsWith("<msg>")) {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(dW.field_content).append(str2);
                            this.qAe.field_fullXml = stringBuffer.toString();
                        }
                        if (str2.endsWith("</appmsg>") || this.qAe.field_offset + ((long) a.length) == this.qAe.field_totalLen) {
                            if (s.fq(dW.field_talker)) {
                                String[] split = dW.field_content.split("\n", 2);
                                String str3 = split[0];
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(str3).append("\n<msg>").append(split[1]).append(str2).append("</msg>");
                                this.qAe.field_fullXml = stringBuffer2.toString();
                            } else {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append("<msg>").append(this.qAe.field_fullXml).append("</msg>");
                                this.qAe.field_fullXml = stringBuffer.toString();
                            }
                        }
                    } else if (!s.fq(dW.field_talker)) {
                        this.qAe.field_fullXml = str2;
                    } else if (!bi.oW(dW.field_content)) {
                        String str4 = dW.field_content.split("\n", 2)[0];
                        this.qAe.field_fullXml = new StringBuffer().append(str4).append("\n").toString();
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(this.qAe.field_fullXml).append(str2);
                        this.qAe.field_fullXml = stringBuffer.toString();
                    }
                    dW.setContent(this.qAe.field_fullXml);
                    au.HU();
                    c.FT().a(this.qAe.field_msgInfoId, dW);
                    x.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[]{str2});
                }
                int e = com.tencent.mm.a.e.e(this.qAe.field_fileFullPath, a);
                if (bi.oW(this.qAe.field_fileFullPath) || e == 0) {
                    b bVar = this.qAe;
                    bVar.field_offset += (long) a.length;
                    if (this.qAe.field_offset == this.qAe.field_totalLen) {
                        this.qAe.field_status = 199;
                    }
                    if (this.dVg != null) {
                        ah.A(new 2(this));
                    }
                    if (!(this.qAk ? true : ao.asF().c(this.qAe, new String[0]))) {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:" + e);
                        this.retCode = -10000 - g.getLine();
                        this.diJ.a(3, -1, "", this);
                        return;
                    } else if (this.qAe.field_status == 199) {
                        h.mEJ.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.qAe.field_totalLen - ((long) this.qAi))});
                        au.HU();
                        bd dW2 = c.FT().dW(this.qAe.field_msgInfoId);
                        au.HU();
                        c.FT().a(new com.tencent.mm.plugin.messenger.foundation.a.a.f.c(dW2.field_talker, "update", dW2));
                        this.diJ.a(0, 0, "", this);
                        return;
                    } else if (this.qAe.field_status == 102) {
                        this.diJ.a(3, -1, "", this);
                        this.retCode = -20102;
                        return;
                    } else if (a(this.dIX, this.diJ) < 0) {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
                        this.diJ.a(3, -1, "", this);
                        return;
                    } else {
                        return;
                    }
                }
                x.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:" + e);
                this.retCode = -10000 - g.getLine();
                this.diJ.a(3, -1, "", this);
            }
        } else {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - g.getLine();
            if (i2 == 4) {
                h.mEJ.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0)});
            }
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 221;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 400;
    }

    public final String getMediaId() {
        if (this.qAe == null) {
            return "";
        }
        return this.qAe.field_mediaSvrId;
    }
}
