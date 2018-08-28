package com.tencent.mm.plugin.backup.e;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.LinkedList;

public final class a implements l {
    public final int a(ey eyVar, boolean z, bd bdVar, String str, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.e.h.a> hashMap, boolean z2, long j) {
        int length;
        String trim;
        bhz bhz;
        switch (bdVar.getType()) {
            case 1048625:
                length = bi.oW(bdVar.field_content) ? 0 : bdVar.field_content.getBytes().length;
                if (bdVar.field_content == null) {
                    return -1;
                }
                trim = an.YJ(bdVar.field_content).taT.trim();
                if (!g.wx(trim)) {
                    trim = bdVar.field_content;
                    if (!g.wx(trim)) {
                        x.e("MicroMsg.BackupItemAppMsg", "get xml error " + trim);
                        return 0;
                    }
                }
                if (bi.oW(trim)) {
                    return length;
                }
                bhz = new bhz();
                bhz.VO(bi.aG(trim, ""));
                eyVar.rcl = bhz;
                com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(trim);
                String Gg = d.asG().asH().Gg();
                String E = d.asG().asH().asD().E(bdVar.field_imgPath, true);
                String str2 = Gg + gp.dwq;
                if (e.cm(E) <= 0) {
                    return -1;
                }
                return (length + i.a(new com.tencent.mm.plugin.backup.e.i.a(E, eyVar, linkedList, 6, z, "_thumb", z2))) + i.a(new com.tencent.mm.plugin.backup.e.i.a(str2, eyVar, linkedList, 5, z, z2, null));
            case 285212721:
            case 486539313:
                length = bi.oW(bdVar.field_content) ? 0 : bdVar.field_content.getBytes().length;
                if (z) {
                    return length;
                }
                trim = a.wz(bdVar.field_content);
                if (bi.oW(trim)) {
                    return 0;
                }
                bhz = new bhz();
                bhz.VO(bi.aG(trim, ""));
                eyVar.rcl = bhz;
                return length;
            default:
                return b(eyVar, z, bdVar, str, linkedList, hashMap, z2, j);
        }
    }

    private static int b(ey eyVar, boolean z, bd bdVar, String str, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.e.h.a> hashMap, boolean z2, long j) {
        int i;
        com.tencent.mm.y.g.a gp;
        if (bi.oW(bdVar.field_content)) {
            i = 0;
        } else {
            i = bdVar.field_content.getBytes().length;
        }
        String str2 = bdVar.field_content;
        if (bdVar.field_isSend != 1 && c.fq(bdVar.field_talker)) {
            int indexOf = bdVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = bdVar.field_content.substring(indexOf + 1);
            }
        }
        str2 = bi.WT(str2);
        if (str2 != null) {
            gp = com.tencent.mm.y.g.a.gp(str2);
        } else {
            gp = null;
        }
        if (gp == null) {
            x.e("MicroMsg.BackupItemAppMsg", "content is null");
            return 0;
        }
        x.d("MicroMsg.BackupItemAppMsg", "content type " + gp.type);
        String E = d.asG().asH().asD().E(bdVar.field_imgPath, true);
        if (e.cn(E)) {
            i += i.a(new com.tencent.mm.plugin.backup.e.i.a(E, eyVar, linkedList, 6, z, "_thumb", z2));
        } else if (gp.type == 2) {
            return -1;
        }
        b SR;
        switch (gp.type) {
            case 2:
                if (bi.oW(gp.bGP)) {
                    return i;
                }
                b SR2 = d.asG().asH().asF().SR(gp.bGP);
                if ((SR2 == null || !SR2.aSc()) && (bdVar.field_isSend != 1 || SR2 == null || !SR2.field_isUpload)) {
                    return i;
                }
                E = SR2.field_fileFullPath;
                if (!e.cn(E)) {
                    return i;
                }
                x.d("MicroMsg.BackupItemAppMsg", "image " + E);
                return i + i.a(new com.tencent.mm.plugin.backup.e.i.a(E, eyVar, linkedList, 8, z, z2, null));
            case 6:
                SR = d.asG().asH().asF().SR(gp.bGP);
                if ((SR == null || !SR.aSc()) && (bdVar.field_isSend != 1 || SR == null || !SR.field_isUpload)) {
                    return i;
                }
                x.d("MicroMsg.BackupItemAppMsg", "full path " + SR.field_fileFullPath);
                if (!e.cn(SR.field_fileFullPath)) {
                    return i;
                }
                if (z) {
                    return i + i.a(new com.tencent.mm.plugin.backup.e.i.a(SR.field_fileFullPath, eyVar, linkedList, 7, z, z2, null));
                }
                if (com.tencent.mm.plugin.backup.a.d.aqS() != 1 || ((long) (gp.dwo / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) < j || gp.filemd5 == null) {
                    return i + i.a(new com.tencent.mm.plugin.backup.e.i.a(SR.field_fileFullPath, eyVar, linkedList, 7, z, z2, null));
                }
                String str3;
                String str4;
                if (bdVar.field_isSend == 1) {
                    str3 = str;
                    str4 = bdVar.field_talker;
                } else {
                    str3 = bdVar.field_talker;
                    str4 = str;
                }
                u uVar = new u();
                i += i.a(new com.tencent.mm.plugin.backup.e.i.a(SR.field_fileFullPath, eyVar, linkedList, 7, z, true, uVar));
                if (hashMap == null) {
                    return i;
                }
                com.tencent.mm.plugin.backup.e.h.a aVar = new com.tencent.mm.plugin.backup.e.h.a();
                aVar.gVU = uVar;
                aVar.bKg = gp.filemd5;
                aVar.gVW = str3 + "_" + str4 + "_" + bdVar.field_msgSvrId + "_backup";
                aVar.gVV = bdVar.field_msgSvrId;
                hashMap.put(Long.valueOf(bdVar.field_msgSvrId), aVar);
                return i;
            case 7:
                SR = d.asG().asH().asF().SR(gp.bGP);
                if ((SR == null || !SR.aSc()) && (bdVar.field_isSend != 1 || SR == null || !SR.field_isUpload)) {
                    return i;
                }
                x.d("MicroMsg.BackupItemAppMsg", "full path " + SR.field_fileFullPath);
                if (e.cn(SR.field_fileFullPath)) {
                    return i + i.a(new com.tencent.mm.plugin.backup.e.i.a(SR.field_fileFullPath, eyVar, linkedList, 7, z, z2, null));
                }
                return i;
            case 19:
            case 24:
                mf mfVar = new mf();
                mfVar.bWR.bVv = gp.dwW;
                mfVar.bWR.bIZ = bdVar.field_msgId;
                com.tencent.mm.sdk.b.a.sFg.m(mfVar);
                x.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[]{mfVar.bWS.bWT});
                String[] split = mfVar.bWS.bWT.split(":");
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= split.length) {
                        return i;
                    }
                    if (e.cn(split[i3])) {
                        x.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[]{split[i3], Integer.valueOf(i3)});
                        i += i.a(new com.tencent.mm.plugin.backup.e.i.a(split[i3], eyVar, linkedList, 7, z, "_fav." + i3, z2));
                    }
                    i2 = i3 + 1;
                }
            default:
                return i;
        }
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        String str2 = eyVar.rcj.siM;
        String str3 = eyVar.rcl.siM;
        if (str3 == null) {
            return 0;
        }
        int iA;
        bdVar.setContent(str3);
        if (bdVar.field_isSend != 1 && c.fq(str2)) {
            iA = c.iA(eyVar.rcl.siM);
            if (iA != -1) {
                str3 = (eyVar.rcl.siM + " ").substring(iA + 2).trim();
            }
        }
        String WT = bi.WT(str3);
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(WT);
        int i;
        if (gp == null) {
            x.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
            return 0;
        } else if (gp.type == 2000) {
            bdVar.setType(419430449);
            c.i(bdVar);
            return 0;
        } else if (gp.type == 19 || gp.type == 24) {
            bdVar.setType(l.d(gp));
            c.i(bdVar);
            mf mfVar = new mf();
            mfVar.bWR.bVv = gp.dwW;
            mfVar.bWR.bIZ = bdVar.field_msgId;
            com.tencent.mm.sdk.b.a.sFg.m(mfVar);
            x.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[]{mfVar.bWS.bWT});
            String[] split = mfVar.bWS.bWT.split(":");
            for (i = 0; i < split.length; i++) {
                WT = g.a(eyVar, 7, "." + i);
                if (!bi.oW(WT)) {
                    x.i("MicroMsg.BackupItemAppMsg", "record media exit:%s, index:%d", new Object[]{WT, Integer.valueOf(i)});
                    j.q(g.wu(WT) + WT, split[i], false);
                }
            }
            return 0;
        } else {
            f fVar = new f();
            fVar.field_appId = gp.appId;
            com.tencent.mm.plugin.backup.g.b asH = d.asG().asH();
            if (asH.uin == 0) {
                throw new com.tencent.mm.model.b();
            }
            if (asH.gYM.b(fVar, new String[0]) && fVar.field_appVersion < gp.cbu) {
                d.asG().asI().f(1, gp.appId);
            }
            bdVar.setType(l.d(gp));
            byte[] b = g.b(eyVar, 6);
            if (b != null && bdVar.field_msgId == 0) {
                str3 = d.asG().asH().asD().a(b, gp.type == 2, CompressFormat.PNG);
                x.d("MicroMsg.BackupItemAppMsg", com.tencent.mm.compatible.util.g.Ac() + " thumbData MsgInfo path:" + str3);
                if (!bi.oW(str3)) {
                    bdVar.eq(str3);
                    x.d("MicroMsg.BackupItemAppMsg", "new thumbnail saved, path:" + str3);
                }
            }
            str2 = g.a(eyVar, 8);
            i = g.c(eyVar, 8);
            if (bi.oW(str2)) {
                str2 = g.a(eyVar, 7);
                i = g.c(eyVar, 7);
            }
            String str4 = g.wu(str2) + str2;
            c.i(bdVar);
            com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
            gp.a(gVar);
            gVar.field_msgId = bdVar.field_msgId;
            com.tencent.mm.plugin.backup.g.b asH2 = d.asG().asH();
            if (asH2.uin == 0) {
                throw new com.tencent.mm.model.b();
            }
            asH2.gYL.b(gVar);
            if (!bi.oW(str2)) {
                com.tencent.mm.plugin.messenger.foundation.a.a.f FT = d.asG().asH().FT();
                if (str.equals(eyVar.rcj.siM)) {
                    str2 = eyVar.rck.siM;
                } else {
                    str2 = eyVar.rcj.siM;
                }
                bd I = FT.I(str2, eyVar.rcq);
                b SR = d.asG().asH().asF().SR(gp.bGP);
                if (SR == null) {
                    x.i("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
                    long j = I.field_msgId;
                    com.tencent.mm.y.g.a gp2 = com.tencent.mm.y.g.a.gp(WT);
                    if (gp2 != null) {
                        WT = l.al(com.tencent.mm.compatible.util.e.dgj, gp2.title, gp2.dwp);
                        int i2 = gp2.sdkVer;
                        String str5 = gp2.appId;
                        String str6 = gp2.bGP;
                        iA = gp2.dwo;
                        b bVar = new b();
                        bVar.field_fileFullPath = WT;
                        bVar.field_appId = str5;
                        bVar.field_sdkVer = (long) i2;
                        bVar.field_mediaSvrId = str6;
                        bVar.field_totalLen = (long) iA;
                        bVar.field_status = 101;
                        bVar.field_isUpload = false;
                        bVar.field_createTime = bi.VF();
                        bVar.field_lastModifyTime = bi.VE();
                        bVar.field_msgInfoId = j;
                        bVar.field_netTimes = 0;
                        if (!d.asG().asH().asF().b(bVar)) {
                            x.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[]{Long.valueOf(j)});
                        }
                    }
                    SR = d.asG().asH().asF().SR(gp.bGP);
                    if (SR == null) {
                        x.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[]{gp.bGP});
                        return 0;
                    } else if (!(gp.dwo == 0 || i == 0)) {
                        if (i >= gp.dwo) {
                            SR.field_status = 199;
                        } else if (bdVar.field_isSend == 1) {
                            SR.field_status = 105;
                        } else {
                            SR.field_status = 102;
                        }
                    }
                }
                long j2 = (long) i;
                SR.field_offset = j2;
                SR.field_totalLen = j2;
                j.q(str4, SR.field_fileFullPath, false);
                d.asG().asH().asF().c(SR, new String[0]);
            }
            return 0;
        }
    }
}
