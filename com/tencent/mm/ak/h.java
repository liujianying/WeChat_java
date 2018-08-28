package com.tencent.mm.ak;

import com.tencent.mm.a.g;
import com.tencent.mm.model.e;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class h extends e {
    protected final bd a(by byVar, String str, String str2, String str3) {
        g Pf = o.Pf();
        bd a = super.a(byVar, str, str2, str3);
        if (a.field_msgId != 0) {
            return a;
        }
        long j = byVar.rcq;
        e bq = Pf.bq(j);
        if (bq.bYu == j) {
            FileOp.deleteFile(Pf.o(bq.dTL, "", ""));
            FileOp.deleteFile(Pf.o(bq.dTN, "", ""));
            FileOp.deleteFile(Pf.o(bq.dTN, "", "") + "hd");
            Pf.dCZ.delete("ImgInfo2", "msgSvrId=?", new String[]{String.valueOf(j)});
            if (bq.ON()) {
                bq = Pf.hQ(bq.dTU);
                if (bq != null) {
                    FileOp.deleteFile(Pf.o(bq.dTL, "", ""));
                    FileOp.deleteFile(Pf.o(bq.dTN, "", ""));
                    FileOp.deleteFile(Pf.o(bq.dTN, "", "") + "hd");
                    Pf.dCZ.delete("ImgInfo2", "id=?", new String[]{bq.dTK});
                }
            }
        }
        if (byVar.rcm != 2) {
            x.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
            return a;
        }
        byte[] bArr;
        int i;
        byte[] a2 = ab.a(byVar.rcn);
        if (af.exs) {
            x.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
            bArr = null;
        } else {
            bArr = a2;
        }
        Map z = bl.z(a.field_content, "msg");
        long j2 = -1;
        if (!bi.oW(a.field_content)) {
            Map z2;
            x.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[]{a.field_content});
            if (z == null) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 190, 1, false);
            }
            if (z != null) {
                int i2 = bi.getInt((String) z.get(".msg.img.$hdlength"), 0);
                i = bi.getInt((String) z.get(".msg.img.$tphdlength"), 0);
                if (i2 > 0) {
                    i = byVar.rcm;
                    j = Pf.a(bArr, byVar.rcq, true, a.field_content, new PString(), new PInt(), new PInt());
                } else if (i > 0) {
                    i = byVar.rcm;
                    j = Pf.a(bArr, byVar.rcq, true, a.field_content, new PString(), new PInt(), new PInt());
                }
                z2 = bl.z(a.field_content, "msgoperation");
                if (z2 != null) {
                    a.ew((String) z2.get(".msgoperation.expinfo.expidstr"));
                    a.fk(bi.getInt((String) z2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                    x.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[]{a.cGK, Integer.valueOf(a.cGL)});
                }
                j2 = j;
            }
            j = -1;
            z2 = bl.z(a.field_content, "msgoperation");
            if (z2 != null) {
                a.ew((String) z2.get(".msgoperation.expinfo.expidstr"));
                a.fk(bi.getInt((String) z2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                x.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[]{a.cGK, Integer.valueOf(a.cGL)});
            }
            j2 = j;
        }
        String str4 = (String) z.get(".msg.img.$tpthumburl");
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        i = byVar.rcm;
        j = Pf.a(bArr, byVar.rcq, false, a.field_content, pString, pInt, pInt2);
        if (!(!bi.bC(bArr) || z == null || bi.oW(str4))) {
            pInt.value = bi.getInt((String) z.get(".msg.img.$tpthumbwidth"), 0);
            pInt2.value = bi.getInt((String) z.get(".msg.img.$tpthumbheight"), 0);
        }
        if (j > 0) {
            a.eq(pString.value);
            a.fh(pInt.value);
            a.fi(pInt2.value);
            if (j2 > 0) {
                bq = o.Pf().b(Long.valueOf(j));
                bq.hM((int) j2);
                o.Pf().a(Long.valueOf(j), bq);
            }
        }
        String str5;
        int i3;
        String o;
        long j3;
        long VF;
        String str6;
        if (bi.bC(bArr) && z != null && !bi.oW(str4)) {
            str5 = (String) z.get(".msg.img.$tpthumbaeskey");
            i3 = bi.getInt((String) z.get(".msg.img.tpthumblength"), 0);
            String str7 = (String) z.get(".msg.img.$tpauthkey");
            o = Pf.o(g.u(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j3 = a.field_msgSvrId;
            x.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[]{Long.valueOf(j3), str, str4, o});
            VF = bi.VF();
            str6 = o + ".tmp";
            i iVar = new i();
            iVar.field_mediaId = d.a("downimgthumb", a.field_createTime, str, String.valueOf(j3));
            iVar.field_fullpath = str6;
            iVar.field_fileType = 19;
            iVar.field_aesKey = str5;
            iVar.field_authKey = str7;
            iVar.dPW = str4;
            iVar.dPV = new 1(this, a, str, j3, o, str4, i3, VF, str6);
            a.setStatus(4);
            com.tencent.mm.modelcdntran.g.ND().b(iVar, -1);
        } else if (bi.bC(bArr) && z != null) {
            str5 = (String) z.get(".msg.img.$cdnthumbaeskey");
            final String str8 = (String) z.get(".msg.img.$cdnthumburl");
            i3 = bi.getInt((String) z.get(".msg.img.$cdnthumblength"), 0);
            o = Pf.o(g.u(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j3 = a.field_msgSvrId;
            x.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[]{Long.valueOf(j3), str, str8, o});
            VF = bi.VF();
            str6 = o + ".tmp";
            i iVar2 = new i();
            iVar2.field_mediaId = d.a("downimgthumb", a.field_createTime, str, String.valueOf(j3));
            iVar2.field_fullpath = str6;
            iVar2.field_fileType = b.MediaType_THUMBIMAGE;
            iVar2.field_totalLen = i3;
            iVar2.field_aesKey = str5;
            iVar2.field_fileId = str8;
            iVar2.field_priority = b.dOl;
            iVar2.field_chattype = s.fq(str) ? 1 : 0;
            x.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[]{Integer.valueOf(iVar2.field_chattype), str});
            final bd bdVar = a;
            final String str9 = str;
            iVar2.dPV = new a() {
                public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                    h.a(i, keep_sceneresult, bdVar, str9, j3, o, str8, i3, VF, str6);
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] i(String str, byte[] bArr) {
                    return null;
                }
            };
            a.setStatus(4);
            com.tencent.mm.modelcdntran.g.ND().b(iVar2, -1);
        }
        return a;
    }

    public static int a(int i, keep_SceneResult keep_sceneresult, bd bdVar, String str, long j, String str2, String str3, int i2, long j2, String str4) {
        if (i != 0) {
            x.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str3, str2});
            bdVar.setStatus(5);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().b(bdVar.field_msgSvrId, bdVar);
            com.tencent.mm.plugin.report.service.h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(j2), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(i2), ""});
            com.tencent.mm.plugin.report.service.h.mEJ.h(13937, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(j2), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(i2), ""});
            o.Pf().doNotify();
            return 0;
        } else if (keep_sceneresult == null) {
            return 0;
        } else {
            if (keep_sceneresult.field_retCode != 0) {
                x.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(j), str, str3, str2});
                bdVar.setStatus(5);
                if (!bi.oW(bdVar.field_talker)) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().b(bdVar.field_msgSvrId, bdVar);
                }
            } else {
                new File(str4).renameTo(new File(str2));
                bdVar.setStatus(6);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                c.c(str2, pInt, pInt2);
                bdVar.fh(pInt.value);
                bdVar.fi(pInt2.value);
                x.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(j), str, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), str3, str2});
                if (!bi.oW(bdVar.field_talker)) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().b(bdVar.field_msgSvrId, bdVar);
                }
                com.tencent.mm.plugin.report.service.h.mEJ.a(198, 1, (long) i2, false);
                com.tencent.mm.plugin.report.service.h.mEJ.a(198, 2, 1, false);
                com.tencent.mm.plugin.report.service.h.mEJ.a(198, s.fq(str) ? 4 : 3, 1, false);
            }
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(keep_sceneresult == null ? i : keep_sceneresult.field_retCode);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(j2);
            objArr[3] = Long.valueOf(bi.VF());
            objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
            objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(i2);
            objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
            hVar.h(10421, objArr);
            if (!(keep_sceneresult == null || keep_sceneresult.field_retCode == 0)) {
                hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                objArr = new Object[16];
                if (keep_sceneresult != null) {
                    i = keep_sceneresult.field_retCode;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(bi.VF());
                objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
                objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
                objArr[6] = Integer.valueOf(i2);
                objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                hVar.h(13937, objArr);
            }
            o.Pf().doNotify();
            return 0;
        }
    }

    public final void h(bd bdVar) {
        o.Pf().r(bdVar);
    }
}
