package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.m.3;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class t {
    public static boolean nO(String str) {
        if (str == null) {
            return false;
        }
        r nW = nW(str);
        if (nW == null || nW.enO >= 2500) {
            return false;
        }
        nW.enO++;
        nW.bWA = 16384;
        return e(nW);
    }

    public static boolean nP(String str) {
        h.mEJ.a(111, 218, 1, false);
        x.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[]{str, bi.cjd()});
        o.Tf().bFf.remove(str);
        if (str == null) {
            return false;
        }
        r nW = nW(str);
        if (nW == null) {
            x.e("MicroMsg.VideoLogic", "Set error failed file:" + str);
            return false;
        }
        nW.status = 198;
        nW.enK = System.currentTimeMillis() / 1000;
        nW.bWA = 1280;
        aso aso = nW.enW;
        aso.rUQ = 0;
        nW.enW = aso;
        boolean e = e(nW);
        x.d("MicroMsg.VideoLogic", "setError file:" + str + " msgid:" + nW.enN + " old stat:" + nW.status);
        if (nW == null || nW.enN == 0) {
            return e;
        }
        bd dW = ((i) g.l(i.class)).bcY().dW((long) nW.enN);
        int type = dW.getType();
        x.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[]{Integer.valueOf(type)});
        if (43 != type && 62 != type) {
            return e;
        }
        f.mDy.a(111, 32, 1, true);
        dW.ep(nW.Tj());
        dW.setContent(p.b(nW.Tk(), -1, true));
        x.d("MicroMsg.VideoLogic", "[oneliang][setError]");
        ((i) g.l(i.class)).bcY().a(dW.field_msgId, dW);
        return e;
    }

    public static boolean nQ(String str) {
        r nW = nW(str);
        if (nW == null || nW.enN == 0) {
            return false;
        }
        bd dW = ((i) g.l(i.class)).bcY().dW((long) nW.enN);
        int type = dW.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[]{Integer.valueOf(type)});
        if (43 != type && 62 != type) {
            return false;
        }
        dW.setContent(p.b(nW.Tk(), (long) nW.enM, false));
        dW.setStatus(2);
        ((i) g.l(i.class)).bcY().a((long) nW.enN, dW);
        nW.status = 197;
        nW.enK = bi.VE();
        nW.bWA = 1280;
        x.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
        return e(nW);
    }

    public static boolean b(String str, int i, String str2, String str3) {
        return a(str, i, str2, str3, 0, "", 43);
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3) {
        return a(str, i, str2, str3, i2, str4, i3, null, "");
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3, bri bri, String str5) {
        r rVar = new r();
        rVar.fileName = str;
        rVar.enM = i;
        rVar.bWJ = str2;
        rVar.enF = (String) g.Ei().DT().get(2, "");
        rVar.createTime = bi.VE();
        rVar.enK = bi.VE();
        rVar.enS = str4;
        rVar.elu = str3;
        rVar.enV = bri;
        rVar.bZN = str5;
        if (!bi.oW(str3)) {
            rVar.enQ = 1;
        }
        if (i2 > 0) {
            rVar.enQ = 1;
        }
        if (62 == i3) {
            rVar.enT = 3;
        } else if (i2 > 0) {
            rVar.enT = 2;
        } else {
            rVar.enT = 1;
        }
        o.Ta();
        int nM = s.nM(s.nK(str));
        if (nM <= 0) {
            x.e("MicroMsg.VideoLogic", "get Video size failed :" + str);
            return false;
        }
        rVar.dHI = nM;
        o.Ta();
        String nL = s.nL(str);
        int nM2 = s.nM(nL);
        if (nM2 <= 0) {
            x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + nL + " size:" + nM2);
            return false;
        }
        rVar.enJ = nM2;
        x.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + rVar.enJ + " videosize:" + rVar.dHI + " msgType:" + i3);
        rVar.status = 102;
        bd bdVar = new bd();
        bdVar.ep(rVar.Tj());
        bdVar.setType(i3);
        bdVar.eX(1);
        bdVar.eq(str);
        bdVar.setStatus(1);
        bdVar.ay(com.tencent.mm.model.bd.iD(rVar.Tj()));
        rVar.enN = (int) com.tencent.mm.model.bd.i(bdVar);
        return o.Ta().a(rVar);
    }

    public static long a(String str, String str2, String str3, int i) {
        if (bi.oW(str)) {
            x.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[]{Integer.valueOf(i)});
            return -1;
        } else if (bi.oW(str2)) {
            x.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[]{Integer.valueOf(i)});
            return -1;
        } else {
            int i2;
            r rVar;
            r rVar2 = new r();
            rVar2.fileName = str;
            rVar2.enM = 1;
            rVar2.bWJ = str2;
            rVar2.enF = (String) g.Ei().DT().get(2, "");
            rVar2.createTime = bi.VE();
            rVar2.enK = bi.VE();
            rVar2.enS = null;
            rVar2.elu = str3;
            if (!bi.oW(str3)) {
                rVar2.enQ = 1;
            }
            if (62 == i) {
                rVar2.enQ = 0;
                i2 = 3;
                rVar = rVar2;
            } else if (rVar2.enQ == 0) {
                i2 = 1;
                rVar = rVar2;
            } else {
                i2 = -1;
                rVar = rVar2;
            }
            rVar.enT = i2;
            rVar2.dHI = 0;
            rVar2.status = 106;
            bd bdVar = new bd();
            bdVar.ep(rVar2.Tj());
            bdVar.setType(i);
            bdVar.eX(1);
            bdVar.eq(str);
            bdVar.setStatus(8);
            bdVar.ay(com.tencent.mm.model.bd.iD(rVar2.Tj()));
            long i3 = com.tencent.mm.model.bd.i(bdVar);
            rVar2.enN = (int) i3;
            if (o.Ta().a(rVar2)) {
                return i3;
            }
            return -1;
        }
    }

    public static void l(String str, int i, int i2) {
        r nW = nW(str);
        if (nW == null) {
            x.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[]{str, Integer.valueOf(i2)});
            return;
        }
        o.Ta();
        x.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[]{Integer.valueOf(s.nM(s.nK(str))), Integer.valueOf(i2)});
        nW.dHI = r0;
        nW.enM = i;
        aso aso = nW.enW;
        aso.rUO = false;
        nW.enW = aso;
        nW.status = 102;
        o.Ta();
        nW.enJ = s.nM(s.nL(str));
        x.i("MicroMsg.VideoLogic", "update prepare:" + str + " thumbsize:" + nW.enJ);
        nW.bWA = 4512;
        x.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[]{Boolean.valueOf(e(nW)), Integer.valueOf(i2)});
        bd dW = ((i) g.l(i.class)).bcY().dW((long) nW.enN);
        x.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[]{Long.valueOf(dW.field_msgId), Long.valueOf(dW.field_msgSvrId), dW.field_talker, Integer.valueOf(dW.getType()), Integer.valueOf(dW.field_isSend), dW.field_imgPath, Integer.valueOf(dW.field_status), Long.valueOf(dW.field_createTime)});
        dW.ep(nW.Tj());
        dW.setType(i2);
        dW.eX(1);
        dW.eq(str);
        dW.setStatus(1);
        x.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[]{Long.valueOf(dW.field_msgId), Long.valueOf(dW.field_msgSvrId), dW.field_talker, Integer.valueOf(dW.getType()), Integer.valueOf(dW.field_isSend), dW.field_imgPath, Integer.valueOf(dW.field_status), Long.valueOf(dW.field_createTime)});
        ((i) g.l(i.class)).bcY().a((long) nW.enN, dW);
    }

    public static int nR(String str) {
        r nW = nW(str);
        if (nW == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nW.status == 102 || nW.status == 105) {
            int i = nW.status;
            if (nW.status == 102 || nW.enJ != nW.enI) {
                nW.status = 103;
            } else {
                nW.status = 104;
            }
            x.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.Ac() + "startSend file:" + str + " status:[" + i + "->" + nW.status + "]");
            nW.enL = bi.VE();
            nW.enK = bi.VE();
            nW.bWA = 3328;
            if (e(nW)) {
                o.Tf().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " get status failed: " + str + " status:" + nW.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static int bC(long j) {
        for (r rVar : o.Ta().bB(j)) {
            int i = rVar.status;
            rVar.status = 200;
            x.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.Ac() + "startSend file:" + rVar.getFileName() + " status:[" + i + "->" + rVar.status + "]");
            rVar.enL = bi.VE();
            rVar.enK = bi.VE();
            rVar.bWA = 3328;
            if (!e(rVar)) {
                x.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.Ac() + " update failed: " + rVar.getFileName());
                return 0 - com.tencent.mm.compatible.util.g.getLine();
            }
        }
        g.Em().H(new 3(o.Tg()));
        return 0;
    }

    public static void c(r rVar) {
        if (rVar == null) {
            x.e("MicroMsg.VideoLogic", "video info is null");
            return;
        }
        bd dW = ((i) g.l(i.class)).bcY().dW((long) rVar.enN);
        int type = dW.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[]{Integer.valueOf(type)});
        if (43 == type || 62 == type) {
            dW.eX(1);
            dW.ep(rVar.Tj());
            dW.ax(rVar.bYu);
            dW.setStatus(2);
            dW.setContent(p.b(rVar.Tk(), (long) rVar.enM, false));
            ((i) g.l(i.class)).bcY().a((long) rVar.enN, dW);
            x.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[]{Long.valueOf(dW.field_msgId)});
        }
    }

    static boolean d(r rVar) {
        bd dW = ((i) g.l(i.class)).bcY().dW((long) rVar.enN);
        int type = dW.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[]{Integer.valueOf(type)});
        if (43 != type && 62 != type) {
            return false;
        }
        dW.ax(rVar.bYu);
        dW.setContent(p.b(rVar.Tk(), (long) rVar.enM, false));
        dW.ep(rVar.Tj());
        x.d("MicroMsg.VideoLogic", "set msg content :" + dW.field_content);
        ((i) g.l(i.class)).bcY().b(rVar.bYu, dW);
        x.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[]{Long.valueOf(dW.field_msgId)});
        if (dW.cmk()) {
            x.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[]{Integer.valueOf(rVar.dHI)});
        }
        return true;
    }

    public static int nS(String str) {
        r nW = nW(str);
        if (nW == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nW.status == 111 || nW.status == 113 || nW.status == 121 || nW.status == 122 || nW.status == 123) {
            nW.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            nW.enL = bi.VE();
            nW.enK = bi.VE();
            nW.bWA = 3328;
            if (e(nW)) {
                o.Tf().Tx();
                o.Tf().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " get status failed: " + str + " status:" + nW.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static int nT(String str) {
        r nW = nW(str);
        if (nW == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nW.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || nW.status == 120 || nW.status == 122 || nW.status == 123) {
            nW.status = 113;
            nW.enK = bi.VE();
            nW.bWA = 1280;
            if (e(nW)) {
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " get status failed: " + str + " status:" + nW.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static boolean U(String str, int i) {
        int i2 = 0;
        r nW = nW(str);
        if (nW == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " getinfo failed: " + str);
            return false;
        }
        if (i != nW.dHI) {
            x.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(nW.dHI)});
            nW.dHI = i;
            i2 = 32;
        }
        nW.enH = i;
        nW.enK = bi.VE();
        d(nW);
        nW.status = 199;
        nW.bWA = i2 | 1296;
        boolean e = e(nW);
        x.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str + " newsize:" + i + " total:" + nW.dHI + " status:" + nW.status + " netTimes:" + nW.enO + " update ret: " + e);
        return e;
    }

    public static boolean nU(String str) {
        x.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : " + str);
        r rVar = new r();
        rVar.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        rVar.enK = bi.VE();
        rVar.enL = bi.VE();
        rVar.fileName = str;
        rVar.bWA = 3328;
        if (!e(rVar)) {
            return false;
        }
        o.Tf().run();
        return true;
    }

    public static boolean nV(String str) {
        r nW = nW(str);
        if (nW == null) {
            return false;
        }
        x.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[]{str});
        aso aso = nW.enW;
        if (aso != null) {
            aso.rUQ = 0;
            nW.enW = aso;
        }
        if (nW.enI < nW.enJ) {
            nW.status = 103;
        } else {
            nW.status = 104;
        }
        nW.createTime = bi.VE();
        nW.enK = bi.VE();
        nW.enL = bi.VE();
        nW.bWA = 536874752;
        if (!e(nW)) {
            return false;
        }
        o.Tf().run();
        return true;
    }

    public static r nW(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return o.Ta().nI(str);
    }

    public static boolean e(r rVar) {
        if (rVar == null) {
            return false;
        }
        if ((rVar.getFileName() == null || rVar.getFileName().length() <= 0) && rVar.bWA == -1) {
            return false;
        }
        return o.Ta().b(rVar);
    }

    public static String nX(String str) {
        String str2 = e.dgl + bi.VF() + ".mp4";
        if (j.fN(str, str2)) {
            return str2;
        }
        return null;
    }

    public static int f(r rVar) {
        if (rVar.dHI == 0) {
            return 0;
        }
        x.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + rVar.enH + " " + rVar.dHI);
        return (rVar.enH * 100) / rVar.dHI;
    }

    public static int g(r rVar) {
        if (rVar.dHI == 0) {
            return 0;
        }
        x.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + rVar.emu + " " + rVar.dHI);
        return (rVar.emu * 100) / rVar.dHI;
    }

    public static boolean nY(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
            return false;
        }
        x.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: " + str);
        r nW = nW(str);
        if (nW == null || nW.status != 199) {
            return false;
        }
        int i = nW.dHI;
        o.Ta();
        int cm = com.tencent.mm.a.e.cm(s.nK(str));
        x.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[]{Integer.valueOf(cm), Integer.valueOf(i)});
        if (cm <= 0 || Math.abs(cm - i) <= 16) {
            return false;
        }
        x.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[]{Integer.valueOf(cm), Integer.valueOf(i)});
        String fileName = nW.getFileName();
        h.mEJ.a(111, 217, 1, false);
        r nW2 = nW(fileName);
        if (nW2 != null) {
            bd dW = ((i) g.l(i.class)).bcY().dW((long) nW2.enN);
            int type = dW.getType();
            x.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[]{Integer.valueOf(type)});
            if (43 == type || 62 == type) {
                dW.setContent(p.b(nW2.Tk(), (long) nW2.enM, false));
                dW.setStatus(2);
                ((i) g.l(i.class)).bcY().a((long) nW2.enN, dW);
                nW2.status = 196;
                nW2.enK = bi.VE();
                nW2.bWA = 1280;
                x.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
                e(nW2);
            }
        }
        return true;
    }

    public static int w(int i, String str) {
        int i2;
        long VG = bi.VG();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!o.Td().b(str, pInt, pInt2) || bi.bG((long) pInt.value) >= 300) {
            i2 = 0;
        } else {
            i2 = pInt2.value;
        }
        if (i2 < 0 || i2 >= i - 1) {
            i2 = 0;
        }
        x.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(pInt.value), str, Long.valueOf(bi.bI(VG))});
        return i2;
    }

    public static void c(String str, int i, boolean z) {
        if (bi.oW(str)) {
            x.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[]{str});
            return;
        }
        boolean z2;
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 1000;
        long VG = bi.VG();
        long update;
        if (o.Td().oc(str)) {
            w Td = o.Td();
            int VF = (int) (bi.VF() / 1000);
            if (!bi.oW(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("starttime", Integer.valueOf(VF));
                contentValues.put("playduration", Integer.valueOf(i2));
                update = (long) Td.diF.update("VideoPlayHistory", contentValues, "filename=?", new String[]{str});
                x.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            w Td2 = o.Td();
            int VF2 = (int) (bi.VF() / 1000);
            int i3 = z ? 1 : 0;
            if (!bi.oW(str)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, str);
                contentValues2.put("starttime", Integer.valueOf(VF2));
                contentValues2.put("playduration", Integer.valueOf(i2));
                contentValues2.put("downloadway", Integer.valueOf(i3));
                update = Td2.diF.insert("VideoPlayHistory", FFmpegMetadataRetriever.METADATA_KEY_FILENAME, contentValues2);
                x.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        x.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[]{Boolean.valueOf(z2), str, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(bi.bI(VG))});
    }

    public static void nZ(String str) {
        boolean z = true;
        if (!bi.oW(str)) {
            if (o.Td().diF.delete("VideoPlayHistory", "filename= ?", new String[]{str}) <= 0) {
                z = false;
            }
            x.d("MicroMsg.VideoLogic", "delete video play history ret : " + z + " filename : " + str);
        }
    }

    public static String e(long j, int i) {
        return j + "_" + i;
    }

    public static int e(long j, String str) {
        if (bi.oW(str)) {
            return -1;
        }
        try {
            String[] split = str.split("_");
            if (split != null && split.length == 2 && bi.getLong(split[0], 0) == j) {
                return bi.getInt(split[1], 0);
            }
            return -1;
        } catch (Exception e) {
            x.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + e.toString());
            return -1;
        }
    }

    public static void V(String str, int i) {
        r nW = nW(str);
        if (nW != null) {
            nW.status = 122;
            nW.enL = bi.VE();
            nW.enK = bi.VE();
            nW.dQo = i;
            nW.bWA = 268438784;
            x.i("MicroMsg.VideoLogic", "set online video Completion ret: " + o.Ta().b(nW) + " status: " + nW.status);
        }
    }

    public static int oa(String str) {
        r nW = nW(str);
        if (nW == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nW.status == 111 || nW.status == 113 || nW.status == 121 || nW.status == 122 || nW.status == 123) {
            int i = 256;
            d.NP();
            if (d.NU()) {
                nW.status = 122;
            } else {
                x.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
                nW.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                nW.enH = 0;
                i = 272;
            }
            nW.enL = bi.VE();
            nW.enK = bi.VE();
            nW.bWA = (i | 2048) | 1024;
            if (e(nW)) {
                o.Tf().Tx();
                o.Tf().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " get status failed: " + str + " status:" + nW.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static boolean W(String str, int i) {
        return b(nW(str), i);
    }

    public static boolean b(r rVar, int i) {
        if (rVar == null) {
            return false;
        }
        rVar.dQo = i;
        rVar.bWA = 268435456;
        return e(rVar);
    }

    public static boolean a(String str, PInt pInt, PInt pInt2) {
        Throwable e;
        Throwable th;
        if (bi.oW(str)) {
            x.w("MicroMsg.VideoLogic", "get media info but path is null");
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                pInt.value = bi.ge((long) bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                pInt2.value = bi.getInt(mediaMetadataRetriever.extractMetadata(20), 0) / 1000;
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", new Object[]{str});
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", new Object[]{Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str});
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever = null;
            x.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", new Object[]{str});
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", new Object[]{Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str});
            return true;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", new Object[]{Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str});
        return true;
    }
}
