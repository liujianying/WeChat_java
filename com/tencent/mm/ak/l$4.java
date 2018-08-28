package com.tencent.mm.ak;

import com.tencent.mm.ab.s;
import com.tencent.mm.ab.u;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.protocal.c.bwj;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.Map;

class l$4 implements a {
    final /* synthetic */ l dVN;

    l$4(l lVar) {
        this.dVN = lVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        Throwable th;
        x.d(l.f(this.dVN), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", l.j(this.dVN), Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
        h hVar;
        String str2;
        if (i == -21005) {
            x.w(l.f(this.dVN), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", l.j(this.dVN));
            if (l.k(this.dVN) != null) {
                l.k(this.dVN).OS();
            }
            l.g(this.dVN).a(3, i, "", this.dVN);
            return 0;
        } else if (i != 0) {
            x.e(l.f(this.dVN), "cdntra cdnCallback clientid:%s startRet:%d", l.j(this.dVN), Integer.valueOf(i));
            i.hU((int) l.b(this.dVN));
            i.hT((int) l.b(this.dVN));
            if (keep_sceneresult != null) {
                hVar = h.mEJ;
                Object[] objArr = new Object[16];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = Long.valueOf(l.l(this.dVN));
                objArr[3] = Long.valueOf(bi.VF());
                objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
                objArr[5] = Integer.valueOf(l.m(this.dVN));
                objArr[6] = Integer.valueOf(keep_sceneresult.field_fileLength);
                objArr[7] = keep_sceneresult.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                if (keep_sceneresult == null) {
                    str2 = "";
                } else {
                    str2 = l.lO(keep_sceneresult.report_Part2);
                }
                objArr[15] = str2;
                hVar.h(10421, objArr);
            }
            l.g(this.dVN).a(3, i, "", this.dVN);
            if (l.k(this.dVN) != null) {
                l.k(this.dVN).OS();
            }
            return 0;
        } else {
            e d = l.d(this.dVN);
            if (d == null || d.dTK != l.c(this.dVN)) {
                g.ND().lw(l.j(this.dVN));
                x.e(l.f(this.dVN), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(l.c(this.dVN)), l.j(this.dVN));
                if (l.k(this.dVN) != null) {
                    l.k(this.dVN).OS();
                }
                return 0;
            } else if (keep_progressinfo != null) {
                l.a(this.dVN, d, keep_progressinfo.field_finishedLength, 0, 0, keep_sceneresult);
                return 0;
            } else {
                if (keep_sceneresult != null) {
                    x.i(l.f(this.dVN), "dkupimg sceneResult:%s", keep_sceneresult);
                    bwj bwj;
                    Object[] objArr2;
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e(l.f(this.dVN), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", l.j(this.dVN), Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult);
                        if (keep_sceneresult.field_retCode == -21111) {
                            x.w(l.f(this.dVN), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", l.j(this.dVN), Boolean.valueOf(l.n(this.dVN)));
                            com.tencent.mm.kernel.g.Ek();
                            com.tencent.mm.kernel.g.Em().H(new 1(this, keep_sceneresult));
                            return 0;
                        }
                        bwj = null;
                        if (!bi.bC(keep_sceneresult.field_sKeyrespbuf)) {
                            bwj = new bwj();
                            try {
                                bwj.aG(keep_sceneresult.field_sKeyrespbuf);
                                x.d(l.f(this.dVN), "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(bwj.six.rfn), bwj.six.rgv.toString());
                            } catch (Throwable e) {
                                th = e;
                                bwj = null;
                                x.e(l.f(this.dVN), "UploadMsgImgResponse parse fail: %s", th);
                                x.e(l.f(this.dVN), "exception:%s", bi.i(th));
                            } catch (Throwable e2) {
                                th = e2;
                                bwj = null;
                                x.e(l.f(this.dVN), "UploadMsgImgResponse parse UninitializedMessageException: %s", th);
                                x.e(l.f(this.dVN), "exception:%s", bi.i(th));
                            }
                        }
                        i.hU((int) l.b(this.dVN));
                        i.hT((int) l.b(this.dVN));
                        h hVar2 = h.mEJ;
                        objArr2 = new Object[16];
                        objArr2[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                        objArr2[1] = Integer.valueOf(1);
                        objArr2[2] = Long.valueOf(l.l(this.dVN));
                        objArr2[3] = Long.valueOf(bi.VF());
                        objArr2[4] = Integer.valueOf(d.bL(ad.getContext()));
                        objArr2[5] = Integer.valueOf(l.m(this.dVN));
                        objArr2[6] = Integer.valueOf(keep_sceneresult.field_fileLength);
                        objArr2[7] = keep_sceneresult.field_transInfo;
                        objArr2[8] = "";
                        objArr2[9] = "";
                        objArr2[10] = "";
                        objArr2[11] = "";
                        objArr2[12] = "";
                        objArr2[13] = "";
                        objArr2[14] = "";
                        objArr2[15] = keep_sceneresult == null ? "" : l.lO(keep_sceneresult.report_Part2);
                        hVar2.h(10421, objArr2);
                        hVar2 = h.mEJ;
                        objArr2 = new Object[16];
                        objArr2[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                        objArr2[1] = Integer.valueOf(1);
                        objArr2[2] = Long.valueOf(l.l(this.dVN));
                        objArr2[3] = Long.valueOf(bi.VF());
                        objArr2[4] = Integer.valueOf(d.bL(ad.getContext()));
                        objArr2[5] = Integer.valueOf(l.m(this.dVN));
                        objArr2[6] = Integer.valueOf(keep_sceneresult.field_fileLength);
                        objArr2[7] = keep_sceneresult.field_transInfo;
                        objArr2[8] = "";
                        objArr2[9] = "";
                        objArr2[10] = "";
                        objArr2[11] = "";
                        objArr2[12] = "";
                        objArr2[13] = "";
                        objArr2[14] = "";
                        objArr2[15] = keep_sceneresult == null ? "" : l.lO(keep_sceneresult.report_Part2);
                        hVar2.h(13937, objArr2);
                        if (bwj == null || bwj.six.rfn == 0) {
                            l.g(this.dVN).a(3, keep_sceneresult.field_retCode, "", this.dVN);
                        } else {
                            l.g(this.dVN).a(4, bwj.six.rfn, bwj.six.rgv.toString(), this.dVN);
                        }
                        if (l.k(this.dVN) != null) {
                            l.k(this.dVN).OS();
                        }
                    } else {
                        String str3;
                        x.i(l.f(this.dVN), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Boolean.valueOf(keep_sceneresult.field_needSendMsgField));
                        hVar = h.mEJ;
                        objArr2 = new Object[3];
                        objArr2[0] = Integer.valueOf(d.source == 0 ? 3 : d.source);
                        objArr2[1] = l.u(this.dVN);
                        objArr2[2] = Integer.valueOf(keep_sceneresult.field_UploadHitCacheType);
                        hVar.h(13230, objArr2);
                        String v = l.v(this.dVN);
                        str2 = "";
                        a lL = f.lL(v);
                        if (lL == null || bi.oW(lL.appId)) {
                            str3 = str2;
                        } else {
                            str3 = f.c(lL.appId, lL.mediaTagName, lL.messageExt, lL.messageAction);
                        }
                        if (bi.oW(v)) {
                            str2 = (("<msg><img aeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnmidimgurl=\"" + keep_sceneresult.field_fileId + "\" cdnbigimgurl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + keep_sceneresult.field_fileId + "\" cdnthumbaeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnthumblength=\"" + keep_sceneresult.field_thumbimgLength + "\" ") + "length=\"" + (keep_sceneresult.field_midimgLength == 0 ? keep_sceneresult.field_fileLength : keep_sceneresult.field_midimgLength) + "\" hdlength=\"" + keep_sceneresult.field_fileLength + "\"/>" + str3 + "</msg>";
                            x.i(l.f(this.dVN), "cdn callback new build cdnInfo:%s", str2);
                        } else {
                            Map z2 = bl.z(v, "msg");
                            if (z2 != null) {
                                if (d.dTO == 0) {
                                    str2 = (("<msg><img aeskey=\"" + ((String) z2.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + keep_sceneresult.field_fileId + "\" cdnbigimgurl=\"" + ((String) z2.get(".msg.img.$cdnbigimgurl")) + "\" ") + "cdnthumburl=\"" + ((String) z2.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) z2.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) z2.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + (keep_sceneresult.field_midimgLength == 0 ? keep_sceneresult.field_fileLength : keep_sceneresult.field_midimgLength) + "\" hdlength=\"" + ((String) z2.get(".msg.img.$hdlength")) + "\"/>" + str3 + "</msg>";
                                } else {
                                    str2 = (("<msg><img aeskey=\"" + ((String) z2.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + ((String) z2.get(".msg.img.$cdnmidimgurl")) + "\" cdnbigimgurl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + ((String) z2.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) z2.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) z2.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + ((String) z2.get(".msg.img.$length")) + "\" hdlength=\"" + keep_sceneresult.field_fileLength + "\"/>" + str3 + "</msg>";
                                }
                                x.i(l.f(this.dVN), "cdn callback rebuild cdnInfo:%s", str2);
                            } else {
                                str2 = v;
                            }
                        }
                        if (keep_sceneresult.isUploadBySafeCDNWithMD5()) {
                            if (bi.oW(l.w(this.dVN))) {
                                x.w(l.f(this.dVN), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                            } else {
                                str2 = (("<msg><img aeskey=\"" + l.w(this.dVN) + "\" cdnmidimgurl=\"" + keep_sceneresult.field_fileId + "\" cdnbigimgurl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + keep_sceneresult.field_fileId + "\" cdnthumbaeskey=\"" + l.w(this.dVN) + "\" ") + "length=\"" + keep_sceneresult.field_midimgLength + "\" hdlength=\"" + keep_sceneresult.field_fileLength + "\"/>" + str3 + "</msg>";
                            }
                        }
                        d.lK(str2);
                        if (l.b(this.dVN) != l.c(this.dVN)) {
                            l.e(this.dVN).lK(str2);
                        }
                        if (keep_sceneresult.field_needSendMsgField) {
                            com.tencent.mm.kernel.g.Eh().dpP.a(new m(l.x(this.dVN), (bwi) l.s(this.dVN).dID.dIL, d, keep_sceneresult, new 2(this, keep_sceneresult, d)), 0);
                        } else {
                            h.mEJ.h(10421, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(this.dVN)), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(l.m(this.dVN)), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", l.lO(keep_sceneresult.report_Part2));
                            bwj = new bwj();
                            try {
                                bwj.aG(keep_sceneresult.field_sKeyrespbuf);
                                long j = bwj.rcq != 0 ? bwj.rcq : (long) bwj.rci;
                                x.d(l.f(this.dVN), "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(bwj.six.rfn), bwj.six.rgv.toString());
                                l.a(this.dVN, d, d.dHI, j, bwj.lOH, keep_sceneresult);
                                l.g(this.dVN).a(0, 0, "", this.dVN);
                                if (l.k(this.dVN) != null) {
                                    l.k(this.dVN).OS();
                                }
                                return 0;
                            } catch (Throwable e22) {
                                x.e(l.f(this.dVN), "UploadMsgImgResponse parse fail: %s", e22);
                                x.e(l.f(this.dVN), "exception:%s", bi.i(e22));
                                l.g(this.dVN).a(3, keep_sceneresult.field_retCode, "", this.dVN);
                                if (l.k(this.dVN) != null) {
                                    l.k(this.dVN).OS();
                                }
                            }
                        }
                    }
                }
                return 0;
            }
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        bwi bwi = (bwi) l.s(this.dVN).dID.dIL;
        ki kiVar = new ki();
        kiVar.rmn = bwi.ssC.siM;
        kiVar.jTv = bwi.rcj.siM;
        kiVar.jTu = bwi.rck.siM;
        kiVar.rmo = bwi.ssJ;
        kiVar.rmp = bwi.ssK;
        kiVar.otY = l.y(this.dVN);
        kiVar.rmr = l.z(this.dVN);
        kiVar.rms = l.A(this.dVN);
        kiVar.rmt = l.B(this.dVN);
        kiVar.rco = bwi.rco;
        kiVar.rmy = l.C(this.dVN);
        kiVar.jQb = bwi.jQb;
        kiVar.raM = bwi.raM;
        kiVar.raO = bwi.raO;
        kiVar.raN = bwi.raN;
        e d = l.d(this.dVN);
        String o = o.Pf().o(d.dTL, "", "");
        g.NE();
        kiVar.rmA = b.lr(o);
        kiVar.rmB = d.dTP;
        if (kiVar.rmB <= 0) {
            kiVar.rmB = l.x(this.dVN) == 4 ? 2 : 1;
        }
        switch (l.x(this.dVN)) {
            case 1:
            case 2:
                kiVar.rdq = 1;
                break;
            case 4:
                kiVar.rdq = 3;
                break;
            case 6:
                kiVar.rdq = 5;
                break;
            default:
                kiVar.rdq = 2;
                break;
        }
        if (kiVar.rmB == 3) {
            kiVar.rdq = 4;
        }
        x.i(l.f(this.dVN), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(kiVar.rmo), Integer.valueOf(kiVar.rmp), kiVar.rco, kiVar.jTu, kiVar.rmy, Long.valueOf(l.c(this.dVN)), Long.valueOf(l.D(this.dVN)), d.dTL, o, Integer.valueOf(kiVar.rmA), Integer.valueOf(kiVar.rmB), Integer.valueOf(kiVar.rdq));
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = kiVar;
        aVar.dIH = new bwj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.dIF = 625;
        aVar.dII = 9;
        aVar.dIJ = 1000000009;
        com.tencent.mm.ab.b KT = aVar.KT();
        c Lr = l.E(this.dVN).Lr();
        String f = l.f(this.dVN);
        String str2 = "getCdnAuthInfo login:%s";
        Object[] objArr = new Object[1];
        objArr[0] = Lr == null ? "acc == null" : Boolean.valueOf(Lr.Ln());
        x.i(f, str2, objArr);
        if (Lr == null || !Lr.Ln()) {
            x.e(l.f(this.dVN), "getCdnAuthInfo accinfo return null. clientimgid:%s", kiVar.rmn);
            return;
        }
        if (s.a(Lr.DE(), Lr.Lm(), Lr.Lo(), KT.KV(), byteArrayOutputStream, Lr.Lp())) {
            x.d(l.f(this.dVN), "getCdnAuthInfo successed.clientimgid:%s", kiVar.rmn);
        } else {
            x.e(l.f(this.dVN), "getCdnAuthInfo failed. clientimgid:%s", kiVar.rmn);
        }
    }

    public final byte[] i(String str, byte[] bArr) {
        PInt pInt = new PInt();
        kj kjVar = new kj();
        try {
            byte[] a = u.a(bArr, com.tencent.mm.kernel.g.Eh().dpP.dJs.Lr().DE(), pInt, kjVar);
            x.i(l.f(this.dVN), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", kjVar.rmy, kjVar.rmC, kjVar.rmn);
            l.b(this.dVN, kjVar.rmy);
            x.i(l.f(this.dVN), "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
            return a;
        } catch (Exception e) {
            x.e(l.f(this.dVN), "decodePrepareResponse Exception:%s", e);
            l.b(this.dVN, null);
            return null;
        }
    }
}
