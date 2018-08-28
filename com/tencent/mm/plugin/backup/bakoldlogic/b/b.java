package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;
import java.util.LinkedList;

public final class b implements j {
    public final int a(ey eyVar, bd bdVar, LinkedList<u> linkedList) {
        bhz bhz;
        switch (bdVar.getType()) {
            case 1048625:
                int length = bi.oW(bdVar.field_content) ? 0 : bdVar.field_content.getBytes().length;
                if (bdVar.field_content == null) {
                    return -1;
                }
                String trim = an.YJ(bdVar.field_content).taT.trim();
                if (!a.wx(trim)) {
                    trim = bdVar.field_content;
                    if (!a.wx(trim)) {
                        x.e("MicroMsg.BakOldItemAppMsg", "get xml error " + trim);
                        return 0;
                    }
                }
                if (!bi.oW(trim)) {
                    bhz = new bhz();
                    bhz.VO(bi.aG(trim, ""));
                    eyVar.rcl = bhz;
                    g$a gp = g$a.gp(trim);
                    String Gg = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().Gg();
                    String E = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asD().E(bdVar.field_imgPath, true);
                    String str = Gg + gp.dwq;
                    if (e.cm(E) <= 0) {
                        return -1;
                    }
                    length = (i.a(new i$a(E, eyVar, linkedList, 6, "_thumb")) + length) + i.a(new i$a(str, eyVar, linkedList, com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asE().Zy(an.YJ(ab.a(eyVar.rcl)).bKg)));
                }
                return length;
            case 285212721:
                int length2 = bi.oW(bdVar.field_content) ? 0 : bdVar.field_content.getBytes().length;
                String wz = a.wz(bdVar.field_content);
                if (bi.oW(wz)) {
                    return 0;
                }
                bhz = new bhz();
                bhz.VO(bi.aG(wz, ""));
                eyVar.rcl = bhz;
                return length2;
            default:
                return b(eyVar, bdVar, linkedList);
        }
    }

    private static int b(ey eyVar, bd bdVar, LinkedList<u> linkedList) {
        int i;
        g$a gp;
        if (bi.oW(bdVar.field_content)) {
            i = 0;
        } else {
            i = bdVar.field_content.getBytes().length;
        }
        String str = bdVar.field_content;
        if (bdVar.field_isSend != 1 && d.fq(bdVar.field_talker)) {
            int indexOf = bdVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str = bdVar.field_content.substring(indexOf + 1);
            }
        }
        str = bi.WT(str);
        if (str != null) {
            gp = g$a.gp(str);
        } else {
            gp = null;
        }
        if (gp == null) {
            x.e("MicroMsg.BakOldItemAppMsg", "content is null");
            return 0;
        }
        x.d("MicroMsg.BakOldItemAppMsg", "content type " + gp.type);
        String E = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asD().E(bdVar.field_imgPath, true);
        if (e.cn(E)) {
            i += i.a(new i$a(E, eyVar, linkedList, 6, "_thumb"));
        } else if (gp.type == 2) {
            return -1;
        }
        com.tencent.mm.pluginsdk.model.app.b SR;
        switch (gp.type) {
            case 2:
                if (!bi.oW(gp.bGP)) {
                    com.tencent.mm.pluginsdk.model.app.b SR2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asF().SR(gp.bGP);
                    if ((SR2 != null && SR2.aSc()) || (bdVar.field_isSend == 1 && SR2 != null && SR2.field_isUpload)) {
                        E = SR2.field_fileFullPath;
                        if (e.cn(E)) {
                            x.d("MicroMsg.BakOldItemAppMsg", "image " + E);
                            i += i.a(new i$a(E, eyVar, linkedList, 8, false, null));
                            break;
                        }
                    }
                }
                break;
            case 6:
                SR = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asF().SR(gp.bGP);
                if ((SR != null && SR.aSc()) || (bdVar.field_isSend == 1 && SR != null && SR.field_isUpload)) {
                    x.d("MicroMsg.BakOldItemAppMsg", "full path " + SR.field_fileFullPath);
                    if (e.cn(SR.field_fileFullPath)) {
                        if (com.tencent.mm.plugin.backup.a.d.aqS() == 1 && ((long) (gp.dwo / 1024)) >= 0 && gp.filemd5 != null) {
                            if (bdVar.field_isSend == 1) {
                                str = bdVar.field_talker;
                            } else {
                                str = bdVar.field_talker;
                            }
                            i += i.a(new i$a(SR.field_fileFullPath, eyVar, linkedList, 7, true, new u()));
                            break;
                        }
                        i += i.a(new i$a(SR.field_fileFullPath, eyVar, linkedList, 7, false, null));
                        break;
                    }
                }
                break;
            case 7:
                SR = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asF().SR(gp.bGP);
                if ((SR != null && SR.aSc()) || (bdVar.field_isSend == 1 && SR != null && SR.field_isUpload)) {
                    x.d("MicroMsg.BakOldItemAppMsg", "full path " + SR.field_fileFullPath);
                    if (e.cn(SR.field_fileFullPath)) {
                        i += i.a(new i$a(SR.field_fileFullPath, eyVar, linkedList, 7, false, null));
                        break;
                    }
                }
                break;
            case 19:
            case 24:
                mf mfVar = new mf();
                mfVar.bWR.bVv = gp.dwW;
                mfVar.bWR.bIZ = bdVar.field_msgId;
                com.tencent.mm.sdk.b.a.sFg.m(mfVar);
                x.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[]{mfVar.bWS.bWT});
                String[] split = mfVar.bWS.bWT.split(":");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (e.cn(split[i2])) {
                        x.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[]{split[i2], Integer.valueOf(i2)});
                        i += i.a(new i$a(split[i2], eyVar, linkedList, 7, "_fav." + i2));
                    }
                }
                break;
        }
        return i;
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        String str2 = eyVar.rcj.siM;
        String str3 = eyVar.rcl.siM;
        if (str3 == null) {
            return 0;
        }
        int iA;
        bdVar.setContent(str3);
        if (bdVar.field_isSend != 1 && d.fq(str2)) {
            iA = d.iA(eyVar.rcl.siM);
            if (iA != -1) {
                str3 = (eyVar.rcl.siM + " ").substring(iA + 2).trim();
            }
        }
        String WT = bi.WT(str3);
        g$a gp = g$a.gp(WT);
        int i;
        if (gp == null) {
            x.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
            return 0;
        } else if (gp.type == 2000) {
            bdVar.setType(419430449);
            d.i(bdVar);
            return 0;
        } else if (gp.type == 19 || gp.type == 24) {
            bdVar.setType(l.d(gp));
            d.i(bdVar);
            mf mfVar = new mf();
            mfVar.bWR.bVv = gp.dwW;
            mfVar.bWR.bIZ = bdVar.field_msgId;
            com.tencent.mm.sdk.b.a.sFg.m(mfVar);
            x.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[]{mfVar.bWS.bWT});
            String[] split = mfVar.bWS.bWT.split(":");
            for (i = 0; i < split.length; i++) {
                WT = a.a(eyVar, 7, "." + i);
                if (!bi.oW(WT)) {
                    x.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[]{WT, Integer.valueOf(i)});
                    j.q(a.wI(WT), split[i], false);
                }
            }
            return 0;
        } else {
            f fVar = new f();
            fVar.field_appId = gp.appId;
            c atm = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm();
            if (atm.uin == 0) {
                throw new com.tencent.mm.model.b();
            }
            if (atm.gYM.b(fVar, new String[0]) && fVar.field_appVersion < gp.cbu) {
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atn().f(1, gp.appId);
            }
            bdVar.setType(l.d(gp));
            byte[] b = a.b(eyVar, 6);
            if (b != null && bdVar.field_msgId == 0) {
                str3 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asD().a(b, gp.type == 2, CompressFormat.PNG);
                x.d("MicroMsg.BakOldItemAppMsg", g.Ac() + " thumbData MsgInfo path:" + str3);
                if (!bi.oW(str3)) {
                    bdVar.eq(str3);
                    x.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:" + str3);
                }
            }
            str2 = a.a(eyVar, 8);
            i = a.c(eyVar, 8);
            if (bi.oW(str2)) {
                str2 = a.a(eyVar, 7);
                i = a.c(eyVar, 7);
            }
            String wI = a.wI(str2);
            d.i(bdVar);
            com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
            gp.a(gVar);
            gVar.field_msgId = bdVar.field_msgId;
            c atm2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm();
            if (atm2.uin == 0) {
                throw new com.tencent.mm.model.b();
            }
            atm2.gYL.b(gVar);
            if (!bi.oW(str2)) {
                com.tencent.mm.plugin.messenger.foundation.a.a.f FT = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().FT();
                if (str.equals(eyVar.rcj.siM)) {
                    str2 = eyVar.rck.siM;
                } else {
                    str2 = eyVar.rcj.siM;
                }
                bd I = FT.I(str2, eyVar.rcq);
                com.tencent.mm.pluginsdk.model.app.b SR = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asF().SR(gp.bGP);
                if (SR == null) {
                    x.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
                    long j = I.field_msgId;
                    g$a gp2 = g$a.gp(WT);
                    if (gp2 != null) {
                        WT = l.al(com.tencent.mm.compatible.util.e.dgj, gp2.title, gp2.dwp);
                        int i2 = gp2.sdkVer;
                        String str4 = gp2.appId;
                        String str5 = gp2.bGP;
                        iA = gp2.dwo;
                        com.tencent.mm.pluginsdk.model.app.b bVar = new com.tencent.mm.pluginsdk.model.app.b();
                        bVar.field_fileFullPath = WT;
                        bVar.field_appId = str4;
                        bVar.field_sdkVer = (long) i2;
                        bVar.field_mediaSvrId = str5;
                        bVar.field_totalLen = (long) iA;
                        bVar.field_status = 101;
                        bVar.field_isUpload = false;
                        bVar.field_createTime = bi.VF();
                        bVar.field_lastModifyTime = bi.VE();
                        bVar.field_msgInfoId = j;
                        bVar.field_netTimes = 0;
                        if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asF().b(bVar)) {
                            x.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[]{Long.valueOf(j)});
                        }
                    }
                    SR = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asF().SR(gp.bGP);
                    if (SR == null) {
                        x.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[]{gp.bGP});
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
                j.q(wI, SR.field_fileFullPath, false);
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().asF().c(SR, new String[0]);
            }
            return 0;
        }
    }
}
