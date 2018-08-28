package com.tencent.mm.pluginsdk.model.app;

import android.support.design.a$i;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

public final class al extends l implements k {
    a bGT = null;
    String bJK;
    boolean dVC = true;
    String dVk = "";
    private i.a dVu = new 1(this);
    private b diG;
    e diJ;
    private boolean dlR = false;
    int dlT = 0;
    keep_SceneResult dlU;
    c dlW = new 2(this);
    private String dwq = null;
    private boolean qAB = true;
    private long qAC = -1;
    b qAe = null;
    long qAh = -1;
    int retCode = 0;
    long startTime = 0;
    String toUser;

    public al(long j, String str, String str2) {
        this.qAh = j;
        this.dwq = str;
        this.bJK = str2;
        b.a aVar = new b.a();
        aVar.dIG = new bvm();
        aVar.dIH = new bvn();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        aVar.dIF = 220;
        aVar.dII = a$i.AppCompatTheme_radioButtonStyle;
        aVar.dIJ = 1000000105;
        this.diG = aVar.KT();
        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[]{Long.valueOf(j), str, bi.cjd()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        this.qAe = new b();
        if (!ao.asF().b(this.qAh, this.qAe) || this.qAe == null) {
            x.e("MicroMsg.NetSceneUploadAppAttach", g.Ac() + " summerbig get info failed rowid:" + this.qAh);
            this.retCode = -10000 - g.getLine();
            this.qAe = null;
            return -1;
        } else if (this.qAe.field_status != 101) {
            x.e("MicroMsg.NetSceneUploadAppAttach", g.Ac() + " summerbig get field_status failed rowid:" + this.qAh + " status:" + this.qAe.field_status);
            return -1;
        } else {
            Object obj;
            if (this.startTime == 0) {
                this.startTime = bi.VF();
                this.qAC = this.qAe.field_offset;
            }
            x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[]{Long.valueOf(this.qAh), this.qAe.field_fileFullPath, Long.valueOf(this.qAe.field_totalLen), Boolean.valueOf(this.qAe.field_isUpload), Integer.valueOf(this.qAe.field_isUseCdn), Long.valueOf(this.qAe.field_type)});
            if (bi.oW(this.qAe.field_appId)) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
                if (!(this.qAe.field_type == 8 || this.qAe.field_type == 6)) {
                    this.retCode = -10000 - g.getLine();
                    return -1;
                }
            }
            if (this.qAe.field_type == 8 || this.qAe.field_type == 9) {
                x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[]{Long.valueOf(this.qAe.field_type)});
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.ND();
                if (com.tencent.mm.modelcdntran.c.hz(4) || this.qAe.field_isUseCdn == 1) {
                    au.HU();
                    bd dW = com.tencent.mm.model.c.FT().dW(this.qAe.field_msgInfoId);
                    if (dW.field_msgId != this.qAe.field_msgInfoId) {
                        x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[]{Long.valueOf(this.qAe.field_msgInfoId), Long.valueOf(this.qAe.sKx), Long.valueOf(this.qAe.field_createTime), Long.valueOf(this.qAe.field_totalLen), Long.valueOf(this.qAe.field_status), Boolean.valueOf(this.qAe.field_isUpload), Integer.valueOf(this.qAe.field_isUseCdn), this.qAe.field_mediaId});
                        this.toUser = null;
                        obj = null;
                    } else {
                        this.toUser = dW.field_talker;
                        String str = "";
                        if (!bi.oW(dW.field_imgPath)) {
                            str = o.Pf().lN(dW.field_imgPath);
                        }
                        int cm = com.tencent.mm.a.e.cm(str);
                        int cm2 = com.tencent.mm.a.e.cm(this.qAe.field_fileFullPath);
                        if (cm >= com.tencent.mm.modelcdntran.b.dOG) {
                            x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[]{str, Integer.valueOf(cm)});
                            obj = null;
                        } else {
                            this.dVk = d.a("upattach", this.qAe.field_createTime, dW.field_talker, this.qAh);
                            x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[]{Long.valueOf(this.qAe.field_createTime), this.dVk});
                            if (bi.oW(this.dVk)) {
                                x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[]{Long.valueOf(this.qAh)});
                                obj = null;
                            } else {
                                Object obj2;
                                i iVar = new i();
                                String str2 = dW.field_content;
                                if (s.fq(dW.field_talker)) {
                                    int iA = com.tencent.mm.model.bd.iA(dW.field_content);
                                    if (iA != -1) {
                                        str2 = (dW.field_content + " ").substring(iA + 2).trim();
                                    }
                                }
                                this.bGT = a.gp(bi.WT(str2));
                                if (this.bGT != null) {
                                    x.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[]{this.bGT.dwD, bi.Xf(this.bGT.dwK), this.bGT.filemd5, Integer.valueOf(this.bGT.type)});
                                    iVar.field_fileId = this.bGT.dwD;
                                    iVar.field_aesKey = this.bGT.dwK;
                                    iVar.field_filemd5 = this.bGT.filemd5;
                                    obj2 = (this.bGT.dws != 0 || this.bGT.dwo > 26214400) ? 1 : null;
                                } else {
                                    x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                    obj2 = null;
                                }
                                iVar.dPV = this.dVu;
                                iVar.field_mediaId = this.dVk;
                                iVar.field_fullpath = this.qAe.field_fileFullPath;
                                iVar.field_thumbpath = str;
                                iVar.field_fileType = obj2 != null ? com.tencent.mm.modelcdntran.b.dOm : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                                iVar.field_svr_signature = obj2 != null ? bi.oV(this.qAe.field_signature) : "";
                                iVar.field_onlycheckexist = obj2 != null ? bi.oW(this.qAe.field_signature) : false;
                                iVar.field_fake_bigfile_signature_aeskey = this.qAe.field_fakeAeskey;
                                iVar.field_fake_bigfile_signature = this.qAe.field_fakeSignature;
                                iVar.field_talker = dW.field_talker;
                                iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
                                iVar.field_totalLen = cm2;
                                iVar.field_needStorage = false;
                                iVar.field_isStreamMedia = false;
                                iVar.field_enable_hitcheck = this.dVC;
                                iVar.field_chattype = s.fq(dW.field_talker) ? 1 : 0;
                                iVar.field_force_aeskeycdn = false;
                                iVar.field_trysafecdn = true;
                                x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[]{Long.valueOf(this.qAe.field_msgInfoId), iVar.field_fullpath, Integer.valueOf(cm2), str, Integer.valueOf(cm), this.dVk, Integer.valueOf(iVar.field_fileType), Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_onlycheckexist), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), bi.Xf(iVar.field_aesKey), iVar.field_filemd5, bi.Xf(iVar.field_svr_signature), bi.Xf(iVar.field_fake_bigfile_signature_aeskey), bi.Xf(iVar.field_fake_bigfile_signature)});
                                if (com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
                                    if (this.qAe.field_isUseCdn != 1) {
                                        this.qAe.field_isUseCdn = 1;
                                        boolean c = ao.asF().c(this.qAe, new String[0]);
                                        if (!c) {
                                            x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:" + c);
                                            this.retCode = -10000 - g.getLine();
                                            this.diJ.a(3, -1, "", this);
                                            obj = null;
                                        }
                                    }
                                    x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[]{this.dVk});
                                    obj = 1;
                                } else {
                                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                                    this.dVk = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                } else {
                    r2 = new Object[2];
                    com.tencent.mm.modelcdntran.g.ND();
                    r2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hz(4));
                    r2[1] = Integer.valueOf(this.qAe.field_isUseCdn);
                    x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", r2);
                    obj = null;
                }
            }
            if (obj != null) {
                x.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[]{Long.valueOf(this.qAh)});
                return 0;
            } else if (this.qAe.field_netTimes > 3200) {
                l.fK(this.qAe.sKx);
                x.e("MicroMsg.NetSceneUploadAppAttach", g.Ac() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.qAh);
                return -1;
            } else {
                b bVar = this.qAe;
                bVar.field_netTimes++;
                if (bi.oW(this.qAe.field_clientAppDataId)) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
                    this.retCode = -10000 - g.getLine();
                    return -1;
                } else if (this.qAe.field_totalLen <= 0 || this.qAe.field_totalLen > 26214400) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.qAe.field_totalLen);
                    this.retCode = -10000 - g.getLine();
                    if (this.qAe.field_totalLen > 26214400) {
                        l.fK(this.qAe.sKx);
                    }
                    return -1;
                } else if (bi.oW(this.qAe.field_fileFullPath)) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
                    this.retCode = -10000 - g.getLine();
                    return -1;
                } else if (com.tencent.mm.a.e.cm(this.qAe.field_fileFullPath) > 26214400) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
                    l.fK(this.qAe.sKx);
                    return -1;
                } else {
                    byte[] f;
                    if (bi.oW(this.dwq)) {
                        f = com.tencent.mm.a.e.f(this.qAe.field_fileFullPath, (int) this.qAe.field_offset, 8192);
                    } else {
                        f = com.tencent.mm.a.e.f(this.qAe.field_fileFullPath, (int) this.qAe.field_offset, WXMediaMessage.THUMB_LENGTH_LIMIT);
                    }
                    if (bi.bC(f)) {
                        x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
                        this.retCode = -10000 - g.getLine();
                        return -1;
                    }
                    bvm bvm = (bvm) this.diG.dID.dIL;
                    bvm.jQb = this.qAe.field_appId;
                    bvm.rdn = (int) this.qAe.field_sdkVer;
                    bvm.ssa = this.qAe.field_clientAppDataId;
                    bvm.hcE = (int) this.qAe.field_type;
                    bvm.hbL = q.GF();
                    bvm.rdV = (int) this.qAe.field_totalLen;
                    bvm.rdW = (int) this.qAe.field_offset;
                    if (this.dwq == null || !this.qAB) {
                        bvm.rdX = f.length;
                        bvm.rtW = new bhy().bq(f);
                        if (this.dwq != null) {
                            bvm.rwt = this.dwq;
                        }
                        return a(eVar, this.diG, this);
                    }
                    bvm.rwt = this.dwq;
                    bvm.rdV = (int) this.qAe.field_totalLen;
                    bvm.rdX = 0;
                    bvm.rtW = new bhy().bq(new byte[0]);
                    this.qAB = false;
                    return a(eVar, this.diG, this);
                }
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bi.oW(this.dVk)) {
            x.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.dVk});
        } else if (i2 == 0 && i3 == 0) {
            bvn bvn = (bvn) ((b) qVar).dIE.dIL;
            if (bvn.jQb != null && this.dwq == null && (!bvn.jQb.equals(this.qAe.field_appId) || !bvn.ssa.equals(this.qAe.field_clientAppDataId))) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
                this.retCode = -10000 - g.getLine();
                this.diJ.a(3, -1, "", this);
            } else if (bvn.rdV < 0 || ((long) bvn.rdV) != this.qAe.field_totalLen || bvn.rdW < 0 || ((long) bvn.rdW) > this.qAe.field_totalLen) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
                this.retCode = -10000 - g.getLine();
                this.diJ.a(3, -1, "", this);
            } else {
                this.qAe.field_offset = (long) bvn.rdW;
                this.qAe.field_mediaSvrId = l.SX(bvn.rvP) ? bvn.rvP : "";
                if (this.qAe.field_status == 105) {
                    x.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.qAe.field_mediaSvrId + "," + this.qAe.field_offset + "] ");
                    this.diJ.a(i2, -1, "", this);
                    return;
                }
                if (this.qAe.field_offset == this.qAe.field_totalLen) {
                    if (bi.oW(this.qAe.field_mediaSvrId)) {
                        x.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
                        this.retCode = -10000 - g.getLine();
                        this.diJ.a(3, -1, "", this);
                        l.fK(this.qAe.sKx);
                        return;
                    }
                    this.qAe.field_status = 199;
                    h.mEJ.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.qAe.field_totalLen - this.qAC)});
                }
                boolean c = ao.asF().c(this.qAe, new String[0]);
                if (!c) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:" + c);
                    this.retCode = -10000 - g.getLine();
                    d(null);
                    this.diJ.a(3, -1, "", this);
                } else if (this.qAe.field_status == 199) {
                    this.diJ.a(0, 0, "", this);
                } else if (a(this.dIX, this.diJ) < 0) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
                    this.diJ.a(3, -1, "", this);
                }
            }
        } else {
            x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - g.getLine();
            if (i2 == 4) {
                h.mEJ.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.qAe.field_totalLen - this.qAC)});
            }
            this.diJ.a(i2, i3, str, this);
        }
    }

    protected final int Cc() {
        return 3200;
    }

    public final int getType() {
        return 220;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return l.b.dJm;
    }

    final void d(keep_SceneResult keep_sceneresult) {
        if (this.qAe.field_type == 2) {
            com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100131");
            if (fJ.isValid()) {
                this.dlT = ai.getInt((String) fJ.ckq().get("needUploadData"), 1);
            }
            if (!this.dlR && this.dlT != 0) {
                this.dlU = keep_sceneresult;
                this.dlR = true;
                ms msVar = new ms();
                com.tencent.mm.sdk.b.a.sFg.b(this.dlW);
                msVar.bXH.filePath = this.qAe.field_fileFullPath;
                com.tencent.mm.sdk.b.a.sFg.m(msVar);
            }
        }
    }
}
