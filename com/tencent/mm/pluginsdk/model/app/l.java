package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.File;

public final class l {
    private static ac qzW;

    public interface a {
        void eu(int i, int i2);
    }

    public static boolean SX(String str) {
        if (bi.oW(str) || str.equals("0:0")) {
            return false;
        }
        return true;
    }

    public static void fJ(long j) {
        b fH = ao.asF().fH(j);
        if (fH != null) {
            boolean deleteFile = e.deleteFile(fH.field_fileFullPath);
            boolean a = ao.asF().a(fH, new String[]{"msgInfoId"});
            x.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[]{Boolean.valueOf(deleteFile), Boolean.valueOf(a), Long.valueOf(fH.field_msgInfoId), fH.field_mediaSvrId, fH.field_fileFullPath, bi.cjd()});
        }
    }

    public static void fK(long j) {
        c asF = ao.asF();
        asF.diF.fV("appattach", " update appattach set status = 198 , lastModifyTime = " + bi.VE() + " where rowid = " + j);
        asF.doNotify();
        b bVar = new b();
        ao.asF().b(j, bVar);
        if (bVar.field_msgInfoId > 0) {
            au.HU();
            bd dW = c.FT().dW(bVar.field_msgInfoId);
            if (dW.field_msgId == bVar.field_msgInfoId) {
                dW.setStatus(5);
                au.HU();
                c.FT().a(dW.field_msgId, dW);
            }
        }
    }

    public static int SY(String str) {
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(str);
        if (gp == null) {
            return -1;
        }
        if (!SX(gp.bGP)) {
            return -1;
        }
        b bVar = new b();
        long j = bi.getLong(gp.bGP, -1);
        if (j != -1) {
            ao.asF().b(j, bVar);
            if (bVar.sKx != j) {
                bVar = ao.asF().SR(gp.bGP);
                if (bVar == null || !bVar.field_mediaSvrId.equals(gp.bGP)) {
                    return -1;
                }
            }
        }
        bVar = ao.asF().SR(gp.bGP);
        if (bVar == null || !bVar.field_mediaSvrId.equals(gp.bGP)) {
            return -1;
        }
        if (bVar.field_totalLen == 0) {
            return -1;
        }
        return (int) ((bVar.field_offset * 100) / bVar.field_totalLen);
    }

    public static String c(long j, String str, String str2) {
        x.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[]{Long.valueOf(j), str, str2});
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(str);
        if (gp == null) {
            return null;
        }
        String al;
        if (str2 == null) {
            al = al(com.tencent.mm.compatible.util.e.dgj, gp.title, gp.dwp);
        } else {
            al = str2;
        }
        if (bi.oW(gp.bGP) && !bi.oW(gp.dwD)) {
            gp.bGP = gp.dwD.hashCode();
        }
        int i = gp.sdkVer;
        String str3 = gp.appId;
        String str4 = gp.bGP;
        int i2 = gp.dwo;
        int i3 = gp.type;
        String str5 = gp.dwK;
        return a(al, j, i, str3, str4, i2, i3, gp.dws);
    }

    public static void a(bd bdVar, final a aVar) {
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(bdVar.field_content);
        if (gp == null) {
            x.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[]{bdVar.field_content});
            return;
        }
        if (bi.oW(gp.bGP) && !bi.oW(gp.dwD)) {
            x.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[]{bdVar.field_content});
            gp.bGP = gp.dwD.hashCode();
        }
        String str = gp.bGP;
        if (!a(bdVar, am(str, bdVar.field_msgId)) && e(str, bdVar)) {
            qzW = new ac(bdVar.field_msgId, str, new f() {
                public final void a(int i, int i2, com.tencent.mm.ab.l lVar) {
                    if (aVar != null) {
                        aVar.eu(i, i2);
                    }
                }
            });
            au.DF().a(qzW, 0);
        }
    }

    public static boolean a(bd bdVar, b bVar) {
        if (bVar == null || !new File(bVar.field_fileFullPath).exists()) {
            return false;
        }
        if (bVar.aSc() || (bdVar.field_isSend == 1 && bVar.field_isUpload)) {
            return true;
        }
        return false;
    }

    public static boolean e(String str, bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        boolean z = true;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        b am = am(str, bdVar.field_msgId);
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(bdVar.field_content);
        if (am != null) {
            String str7 = am.field_fileFullPath;
        }
        if (gp != null) {
            str2 = ai.oV(gp.title);
            str3 = ai.oV(gp.dwp).toLowerCase();
            str4 = ai.oV(gp.filemd5);
            str5 = ai.oV(gp.bSS);
            str6 = ai.oV(gp.dwK);
        }
        String str8;
        if (am == null) {
            c(bdVar.field_msgId, bdVar.field_content, null);
            am = am(str, bdVar.field_msgId);
            if (am != null) {
                str8 = "MicroMsg.AppMsgLogic";
                String str9 = "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(am.sKx);
                objArr[1] = Long.valueOf(am.field_totalLen);
                objArr[2] = am.field_fileFullPath;
                objArr[3] = Long.valueOf(am.field_type);
                objArr[4] = am.field_mediaId;
                objArr[5] = Long.valueOf(am.field_msgInfoId);
                objArr[6] = Boolean.valueOf(am.field_isUpload);
                objArr[7] = Integer.valueOf(am.field_signature == null ? -1 : am.field_signature.length());
                x.i(str8, str9, objArr);
                if (gp != null && (gp.dws != 0 || gp.dwo > 26214400)) {
                    boolean z2;
                    if (ai.oW(am.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
            }
        } else {
            File file = new File(am.field_fileFullPath);
            if (am.field_status == 199 && !file.exists()) {
                x.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
                c(bdVar.field_msgId, bdVar.field_content, null);
            }
            String str10 = "MicroMsg.AppMsgLogic";
            str8 = "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(am.sKx);
            objArr2[1] = Long.valueOf(am.field_totalLen);
            objArr2[2] = am.field_fileFullPath;
            objArr2[3] = Long.valueOf(am.field_type);
            objArr2[4] = am.field_mediaId;
            objArr2[5] = Long.valueOf(am.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(am.field_isUpload);
            objArr2[7] = Boolean.valueOf(file.exists());
            objArr2[8] = Long.valueOf(am.field_status);
            objArr2[9] = Integer.valueOf(am.field_signature == null ? -1 : am.field_signature.length());
            x.i(str10, str8, objArr2);
        }
        if (!z) {
            au.DF().a(new z(am, str6, str4, str2, str3, str5), 0);
        }
        return z;
    }

    public static b am(String str, long j) {
        b SZ = SZ(str);
        if (SZ == null) {
            SZ = ao.asF().fH(j);
        }
        if (SZ != null) {
            x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[]{SZ, Long.valueOf(SZ.sKx), Boolean.valueOf(SZ.field_isUpload), SZ.field_fileFullPath, Long.valueOf(SZ.field_totalLen), Long.valueOf(SZ.field_offset), SZ.field_mediaSvrId, SZ.field_mediaId, Long.valueOf(SZ.field_msgInfoId), Long.valueOf(SZ.field_type), ai.VI()});
        } else {
            x.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[]{ai.VI()});
        }
        return SZ;
    }

    public static String a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        b bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bi.VF();
        bVar.field_lastModifyTime = bi.VE();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        bVar.field_type = (long) i3;
        x.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[]{Boolean.valueOf(ao.asF().b(bVar)), Long.valueOf(bVar.sKx), Long.valueOf(bVar.field_totalLen), Long.valueOf(bVar.field_type), Integer.valueOf(i4), str, bi.cjd()});
        return str3;
    }

    public static b a(String str, long j, int i, String str2, String str3, int i2) {
        b bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bi.VF();
        bVar.field_lastModifyTime = bi.VE();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        return bVar;
    }

    public static b a(String str, com.tencent.mm.y.g.a aVar, String str2) {
        x.i("MicroMsg.AppMsgLogic", g.Ac() + " summerbig buildUploadAttachInfo clientAppDataId:" + str + " attach file :" + str2);
        if (str2.replace("//", "/").startsWith(com.tencent.mm.compatible.util.e.duM)) {
            x.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[]{str2.replace("//", "/")});
            return null;
        }
        b bVar = new b();
        bVar.field_totalLen = (long) aVar.dwo;
        bVar.field_fileFullPath = str2;
        bVar.field_sdkVer = (long) aVar.sdkVer;
        bVar.field_appId = aVar.appId;
        bVar.field_clientAppDataId = str;
        bVar.field_type = (long) aVar.type;
        bVar.field_status = 200;
        bVar.field_isUpload = true;
        bVar.field_createTime = bi.VF();
        bVar.field_lastModifyTime = bi.VE();
        bVar.field_mediaSvrId = bi.VF();
        ao.asF().b(bVar);
        x.d("MicroMsg.AppMsgLogic", g.Ac() + " summerbig buildUploadAttachInfo file:" + bVar.field_fileFullPath + " rowid:" + bVar.sKx + " clientAppDataId:" + bVar.field_clientAppDataId);
        if (bVar.sKx >= 0) {
            return bVar;
        }
        x.e("MicroMsg.AppMsgLogic", g.Ac() + " summerbig uploadAttach insert appattach info failed :" + bVar.sKx);
        return null;
    }

    public static int a(long j, String str, keep_SceneResult keep_sceneresult) {
        au.HU();
        bd dW = c.FT().dW(j);
        if (dW.field_msgId != j) {
            x.e("MicroMsg.AppMsgLogic", g.Ac() + " getmsgFailed id:" + j);
            return 0 - g.getLine();
        }
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(dW.field_content);
        if (gp == null) {
            x.e("MicroMsg.AppMsgLogic", g.Ac() + " getmsgFailed id:" + j);
            return 0 - g.getLine();
        }
        gp.bGP = str;
        dW.setContent(com.tencent.mm.y.g.a.a(gp, gp.bGP, keep_sceneresult));
        au.HU();
        c.FT().a(dW.field_msgId, dW);
        com.tencent.mm.y.g fI = ao.cbY().fI(j);
        if (fI != null) {
            fI.field_xml = dW.field_content;
            ao.cbY().c(fI, new String[]{"msgId"});
        }
        b fH = ao.asF().fH(j);
        fH.field_mediaSvrId = str;
        fH.field_offset = fH.field_totalLen;
        ao.asF().c(fH, new String[0]);
        return 0;
    }

    public static int a(com.tencent.mm.y.g.a aVar, String str, String str2, String str3, String str4, byte[] bArr) {
        return a(aVar, str, str2, str3, str4, bArr, null);
    }

    public static int a(com.tencent.mm.y.g.a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5) {
        return a(aVar, str, str2, str3, str4, bArr, str5, "");
    }

    public static String al(String str, String str2, String str3) {
        String str4;
        if (bi.oW(str2)) {
            str4 = str + "da_" + bi.VF();
        } else {
            str4 = str + str2;
            if (e.cn(str4)) {
                File file = new File(str + "/" + bi.VF());
                if (!(file.exists() && file.isDirectory())) {
                    file.mkdirs();
                }
                str4 = file.getAbsolutePath() + "/" + str2;
            }
        }
        if (!(bi.oW(str3) || str4.endsWith(str3))) {
            str4 = str4 + "." + str3;
        }
        try {
            if (new File(str4).getParentFile().getCanonicalPath().equalsIgnoreCase(new File(str).getCanonicalPath())) {
                return str4;
            }
            x.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[]{str + "da_" + bi.VF()});
            return str + "da_" + bi.VF();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
            return str + "da_" + bi.VF();
        }
    }

    public static int a(com.tencent.mm.y.g.a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) {
        x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[]{str4, aVar});
        b bVar = null;
        String str7 = System.currentTimeMillis();
        if (!bi.oW(str4)) {
            bVar = a(str7, aVar, str4);
            if (bVar == null) {
                return 0 - g.getLine();
            }
        }
        bd bdVar = new bd();
        if (bArr != null && bArr.length > 0) {
            if (aVar.type == 33 || aVar.type == 36) {
                str7 = o.Pf().a(bArr, CompressFormat.JPEG, (int) (com.tencent.mm.sdk.platformtools.c.chu().density * 240.0f), (int) (com.tencent.mm.sdk.platformtools.c.chu().density * 240.0f));
            } else {
                str7 = o.Pf().a(6, bArr, aVar.type == 2, CompressFormat.PNG);
            }
            x.d("MicroMsg.AppMsgLogic", g.Ac() + " thumbData MsgInfo path:" + str7);
            if (!bi.oW(str7)) {
                bdVar.eq(str7);
                x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str7);
            }
        }
        if (bVar != null) {
            aVar.bGP = bVar.sKx;
        }
        bdVar.setContent(com.tencent.mm.y.g.a.a(aVar, null, null));
        bdVar.setStatus(1);
        bdVar.ep(str3);
        bdVar.ay(com.tencent.mm.model.bd.iD(str3));
        bdVar.eX(1);
        bdVar.setType(d(aVar));
        if (com.tencent.mm.ac.f.eZ(bdVar.field_talker)) {
            bdVar.dt(com.tencent.mm.ac.a.e.Ir());
            x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[]{bdVar.cqb});
        }
        au.HU();
        long T = c.FT().T(bdVar);
        x.d("MicroMsg.AppMsgLogic", g.Ac() + " msginfo insert id: " + T);
        if (T < 0) {
            x.e("MicroMsg.AppMsgLogic", g.Ac() + "insert msg failed :" + T);
            return 0 - g.getLine();
        }
        x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + T);
        bdVar.setMsgId(T);
        com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
        gVar.field_xml = bdVar.field_content;
        gVar.field_appId = str;
        gVar.field_title = aVar.title;
        gVar.field_type = aVar.type;
        gVar.field_description = aVar.description;
        gVar.field_msgId = T;
        gVar.field_source = str2;
        ao.cbY().b(gVar);
        String str8 = "MicroMsg.AppMsgLogic";
        String str9 = "summerbig sendAppMsg attInfo is null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(bVar == null);
        x.i(str8, str9, objArr);
        if (bVar != null) {
            bVar.field_msgInfoId = T;
            bVar.field_status = 101;
            ao.asF().c(bVar, new String[0]);
            if (aVar.type == 2 || !bi.oW(str5)) {
                ao.cca().u(T, str5);
            }
            ao.cca().run();
        } else {
            ao.cca();
            com.tencent.mm.pluginsdk.model.app.an.a.d(T, str5, str6);
        }
        return 0;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4) {
        return a(wXMediaMessage, str, str2, str3, i, str4, null);
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4, String str5) {
        com.tencent.mm.y.g.a aVar = new com.tencent.mm.y.g.a();
        aVar.appId = str;
        aVar.appName = str2;
        aVar.dwr = i;
        return a(aVar, wXMediaMessage, str3, str4, str5);
    }

    public static int a(com.tencent.mm.y.g.a aVar, WXMediaMessage wXMediaMessage, String str) {
        return a(aVar, wXMediaMessage, str, null, null);
    }

    private static int a(com.tencent.mm.y.g.a aVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        b bVar;
        String g;
        String b = b(aVar, wXMediaMessage, str2);
        x.d("MicroMsg.AppMsgLogic", g.Ac() + "summerbig content url:" + aVar.url + " lowUrl:" + aVar.dwn + " attachlen:" + aVar.dwo + " attachid:" + aVar.bGP + " attach file:" + b);
        String str4 = System.currentTimeMillis();
        if (bi.oW(b)) {
            bVar = null;
        } else {
            b a = a(str4, aVar, b);
            if (a == null) {
                return 0 - g.getLine();
            }
            Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(b);
            if (VZ != null) {
                aVar.dwJ = VZ.outWidth;
                aVar.dwI = VZ.outHeight;
            }
            bVar = a;
        }
        bd bdVar = new bd();
        if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
            if (wXMediaMessage.thumbData.length <= 32768 || wXMediaMessage.getType() == 36) {
                g = o.Pf().g(6, wXMediaMessage.thumbData);
            } else {
                g = o.Pf().a(6, wXMediaMessage.thumbData, aVar.type == 2, CompressFormat.JPEG);
            }
            x.d("MicroMsg.AppMsgLogic", g.Ac() + " summerbig thumbData MsgInfo path:" + g);
            if (!bi.oW(g)) {
                bdVar.eq(g);
            }
        }
        if (bVar != null) {
            aVar.bGP = bVar.sKx;
        }
        for (String g2 : bi.F(str.split(","))) {
            aVar.dwq = str2;
            bdVar.setContent(com.tencent.mm.y.g.a.a(aVar, null, null));
            bdVar.setStatus(1);
            bdVar.ep(g2);
            bdVar.ay(com.tencent.mm.model.bd.iD(g2));
            bdVar.eX(1);
            bdVar.setType(d(aVar));
            if (com.tencent.mm.ac.f.eZ(bdVar.field_talker)) {
                bdVar.dt(com.tencent.mm.ac.a.e.Ir());
            }
            au.HU();
            long T = c.FT().T(bdVar);
            if (T < 0) {
                x.e("MicroMsg.AppMsgLogic", g.Ac() + " summerbig insert msg failed :" + T);
                return 0 - g.getLine();
            }
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " summerbig new msg inserted to db , local id = " + T);
            bdVar.setMsgId(T);
            com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
            gVar.field_xml = bdVar.field_content;
            gVar.field_title = wXMediaMessage.title;
            gVar.field_type = wXMediaMessage.mediaObject.type();
            gVar.field_description = wXMediaMessage.description;
            gVar.field_msgId = T;
            gVar.field_source = aVar.appName;
            ao.cbY().b(gVar);
            if (bVar != null) {
                bVar.field_msgInfoId = T;
                bVar.field_status = 101;
                x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[]{Long.valueOf(bVar.field_msgInfoId), Long.valueOf(bVar.field_status), Long.valueOf(bVar.sKx), Integer.valueOf(gVar.field_type)});
                ao.asF().c(bVar, new String[0]);
                if (!bi.oW(str3)) {
                    ao.cca().u(bVar.field_msgInfoId, str3);
                }
                ao.cca().run();
            } else {
                x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[]{bVar, Long.valueOf(T), str3, Integer.valueOf(gVar.field_type)});
                ao.cca();
                com.tencent.mm.pluginsdk.model.app.an.a.v(T, str3);
            }
        }
        return 0;
    }

    public static String bh(byte[] bArr) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.AppMsgLogic", g.Ac() + " attachBuf is null");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        String stringBuilder2 = stringBuilder.append(c.Gk()).append("ua_").append(bi.VF()).toString();
        x.d("MicroMsg.AppMsgLogic", g.Ac() + " buildUploadAttachInfo file:" + stringBuilder2);
        if (e.b(stringBuilder2, bArr, bArr.length) == 0) {
            return stringBuilder2;
        }
        x.e("MicroMsg.AppMsgLogic", g.Ac() + " writeFile error file:" + stringBuilder2);
        return null;
    }

    public static String b(com.tencent.mm.y.g.a aVar, WXMediaMessage wXMediaMessage, String str) {
        x.d("MicroMsg.AppMsgLogic", g.Ac() + "mediaMessageToContent sdkver:" + wXMediaMessage.sdkVer + " title:" + wXMediaMessage.title + " desc:" + wXMediaMessage.description + " type:" + wXMediaMessage.mediaObject.type());
        aVar.sdkVer = wXMediaMessage.sdkVer;
        aVar.title = wXMediaMessage.title;
        aVar.description = wXMediaMessage.description;
        aVar.mediaTagName = wXMediaMessage.mediaTagName;
        aVar.messageAction = wXMediaMessage.messageAction;
        aVar.messageExt = wXMediaMessage.messageExt;
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        aVar.type = iMediaObject.type();
        if (aVar.type == 7) {
            WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
            aVar.extInfo = wXAppExtendObject.extInfo;
            if (bi.bC(wXAppExtendObject.fileData)) {
                aVar.dwo = e.cm(wXAppExtendObject.filePath);
                x.d("MicroMsg.AppMsgLogic", g.Ac() + " read file:" + wXAppExtendObject.filePath + " len:" + aVar.dwo);
                if (aVar.dwo <= 0) {
                    return null;
                }
                aVar.dwp = e.cp(wXAppExtendObject.filePath);
                return wXAppExtendObject.filePath;
            }
            x.d("MicroMsg.AppMsgLogic", g.Ac() + " fileData:" + wXAppExtendObject.fileData.length);
            aVar.dwo = wXAppExtendObject.fileData.length;
            return bh(wXAppExtendObject.fileData);
        } else if (aVar.type == 6) {
            WXFileObject wXFileObject = (WXFileObject) iMediaObject;
            if (bi.bC(wXFileObject.fileData)) {
                aVar.dwo = e.cm(wXFileObject.filePath);
                x.d("MicroMsg.AppMsgLogic", g.Ac() + " read file:" + wXFileObject.filePath + " len:" + aVar.dwo);
                if (aVar.dwo <= 0) {
                    return null;
                }
                aVar.dwp = e.cp(wXFileObject.filePath);
                return wXFileObject.filePath;
            }
            x.d("MicroMsg.AppMsgLogic", g.Ac() + " fileData:" + wXFileObject.fileData.length);
            aVar.dwo = wXFileObject.fileData.length;
            return bh(wXFileObject.fileData);
        } else if (aVar.type == 2) {
            WXImageObject wXImageObject = (WXImageObject) iMediaObject;
            if (!bi.bC(wXImageObject.imageData)) {
                x.d("MicroMsg.AppMsgLogic", g.Ac() + " fileData:" + wXImageObject.imageData.length);
                aVar.dwo = wXImageObject.imageData.length;
                return bh(wXImageObject.imageData);
            } else if (bi.oW(wXImageObject.imagePath)) {
                return null;
            } else {
                aVar.dwo = e.cm(wXImageObject.imagePath);
                x.d("MicroMsg.AppMsgLogic", g.Ac() + " read file:" + wXImageObject.imagePath + " len:" + aVar.dwo);
                if (aVar.dwo <= 0) {
                    return null;
                }
                aVar.dwp = e.cp(wXImageObject.imagePath);
                au.HU();
                String absolutePath = new File(c.Gk(), "appmsg_img_" + System.currentTimeMillis()).getAbsolutePath();
                Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(wXImageObject.imagePath);
                if (VZ == null || VZ.outWidth <= 0 || VZ.outHeight <= 0) {
                    boolean z;
                    String str2 = "MicroMsg.AppMsgLogic";
                    String str3 = "options is null! %B, bitmapWidth = %d, bitmapHeight = %d";
                    Object[] objArr = new Object[3];
                    if (VZ == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Integer.valueOf(VZ == null ? -1 : VZ.outWidth);
                    objArr[2] = Integer.valueOf(VZ == null ? -1 : VZ.outHeight);
                    x.e(str2, str3, objArr);
                    return null;
                } else if (q.a(wXImageObject.imagePath, "", true)) {
                    x.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[]{wXImageObject.imagePath, absolutePath});
                    if (e.y(wXImageObject.imagePath, absolutePath) >= 0) {
                        return absolutePath;
                    }
                    x.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[]{wXImageObject.imagePath, absolutePath});
                    return null;
                } else {
                    if (VZ.outWidth > 960 || VZ.outHeight > 960) {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        Bitmap a = com.tencent.mm.sdk.platformtools.c.a(wXImageObject.imagePath, 960, 960, false, decodeResultLogger, 0);
                        if (a != null) {
                            try {
                                com.tencent.mm.sdk.platformtools.c.a(a, 100, CompressFormat.JPEG, absolutePath, true);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
                                return null;
                            }
                        }
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            h.mEJ.k(12712, KVStatHelper.getKVStatString(wXImageObject.imagePath, 6, decodeResultLogger));
                        }
                        return null;
                    } else if (e.y(wXImageObject.imagePath, absolutePath) < 0) {
                        return null;
                    }
                    return absolutePath;
                }
            }
        } else if (aVar.type == 3) {
            WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
            aVar.url = wXMusicObject.musicUrl;
            aVar.dwn = wXMusicObject.musicLowBandUrl;
            aVar.dwN = wXMusicObject.musicDataUrl;
            aVar.dwO = wXMusicObject.musicLowBandDataUrl;
            return null;
        } else if (aVar.type == 4) {
            WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
            aVar.url = wXVideoObject.videoUrl;
            aVar.dwn = wXVideoObject.videoLowBandUrl;
            return null;
        } else if (aVar.type == 5) {
            WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
            aVar.url = wXWebpageObject.webpageUrl;
            if (!bi.oW(wXWebpageObject.extInfo)) {
                aVar.extInfo = wXWebpageObject.extInfo;
            }
            if (!bi.oW(wXWebpageObject.canvasPageXml)) {
                aVar.canvasPageXml = wXWebpageObject.canvasPageXml;
            }
            return null;
        } else {
            WXEmojiSharedObject wXEmojiSharedObject;
            if (aVar.type == 36) {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) iMediaObject;
                aVar.dyS = wXMiniProgramObject.userName;
                aVar.dyR = wXMiniProgramObject.path;
                aVar.url = wXMiniProgramObject.webpageUrl;
                WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(wXMiniProgramObject.userName);
                if (rR != null) {
                    if (rR.ael() != null) {
                        aVar.dza = rR.ael().cbu;
                    }
                    aVar.dzb = rR.field_brandIconURL;
                    x.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[]{Integer.valueOf(aVar.dza), aVar.dzb});
                }
            } else if (aVar.type == 1) {
                aVar.title = ((WXTextObject) iMediaObject).text;
                return null;
            } else if (aVar.type == 8) {
                WXEmojiObject wXEmojiObject = (WXEmojiObject) iMediaObject;
                if (!bi.bC(wXEmojiObject.emojiData)) {
                    x.d("MicroMsg.AppMsgLogic", g.Ac() + " fileData:" + wXEmojiObject.emojiData.length);
                    aVar.dwo = wXEmojiObject.emojiData.length;
                    return bh(wXEmojiObject.emojiData);
                } else if (bi.oW(wXEmojiObject.emojiPath)) {
                    aVar.dwq = str;
                } else {
                    aVar.dwo = e.cm(wXEmojiObject.emojiPath);
                    x.d("MicroMsg.AppMsgLogic", g.Ac() + " read file:" + wXEmojiObject.emojiPath + " len:" + aVar.dwo);
                    if (aVar.dwo <= 0) {
                        return null;
                    }
                    aVar.dwp = e.cp(wXEmojiObject.emojiPath);
                    return wXEmojiObject.emojiPath;
                }
            } else if (aVar.type == 15) {
                wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                aVar.thumburl = wXEmojiSharedObject.thumburl;
                aVar.dxa = wXEmojiSharedObject.packageflag;
                aVar.dwZ = wXEmojiSharedObject.packageid;
                aVar.showType = 8;
                aVar.url = wXEmojiSharedObject.url;
                return null;
            } else if (aVar.type == 13) {
                wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                aVar.thumburl = wXEmojiSharedObject.thumburl;
                aVar.dxa = wXEmojiSharedObject.packageflag;
                aVar.dwZ = wXEmojiSharedObject.packageid;
                aVar.showType = 8;
                aVar.url = wXEmojiSharedObject.url;
                return null;
            } else if (aVar.type == 25) {
                WXDesignerSharedObject wXDesignerSharedObject = (WXDesignerSharedObject) iMediaObject;
                aVar.thumburl = wXDesignerSharedObject.thumburl;
                aVar.url = wXDesignerSharedObject.url;
                aVar.dyG = wXDesignerSharedObject.designerUIN;
                aVar.designerName = wXDesignerSharedObject.designerName;
                aVar.designerRediretctUrl = wXDesignerSharedObject.designerRediretctUrl;
                aVar.showType = 18;
                return null;
            } else if (aVar.type == 27 || aVar.type == 26) {
                WXEmojiPageSharedObject wXEmojiPageSharedObject = (WXEmojiPageSharedObject) iMediaObject;
                aVar.thumburl = wXEmojiPageSharedObject.iconUrl;
                aVar.url = wXEmojiPageSharedObject.url;
                aVar.tid = wXEmojiPageSharedObject.tid;
                aVar.dyH = wXEmojiPageSharedObject.title;
                aVar.desc = wXEmojiPageSharedObject.desc;
                aVar.iconUrl = wXEmojiPageSharedObject.iconUrl;
                aVar.secondUrl = wXEmojiPageSharedObject.secondUrl;
                aVar.pageType = wXEmojiPageSharedObject.pageType;
                aVar.showType = 20;
                return null;
            }
            return null;
        }
    }

    public static b d(bd bdVar, String str) {
        b SZ = SZ(str);
        if (SZ != null) {
            return SZ;
        }
        c(bdVar.field_msgId, bdVar.field_content, null);
        return SZ(str);
    }

    public static b SZ(String str) {
        b bVar = new b();
        if (bi.oW(str)) {
            return null;
        }
        x.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[]{str});
        long j = bi.getLong(str, -1);
        if (j != -1) {
            ao.asF().b(j, bVar);
            if (bVar.sKx != j) {
                bVar = ao.asF().SR(str);
                if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                    x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                    bVar = null;
                }
            }
        } else {
            bVar = ao.asF().SR(str);
            if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                bVar = null;
            }
        }
        x.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[]{str, Long.valueOf(j)});
        return bVar;
    }

    public static void ae(bd bdVar) {
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(bdVar.field_content);
        if (gp == null) {
            x.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
            return;
        }
        String E;
        byte[] e;
        com.tencent.mm.y.g.a a;
        String str;
        String str2;
        b a2;
        bd bdVar2;
        long T;
        b SZ = SZ(gp.bGP);
        String str3 = "";
        if (!(SZ == null || SZ.field_fileFullPath == null || SZ.field_fileFullPath.equals(""))) {
            au.HU();
            str3 = al(c.Gk(), gp.title, gp.dwp);
            j.q(SZ.field_fileFullPath, str3, false);
        }
        if (!(bdVar.field_imgPath == null || bdVar.field_imgPath.equals(""))) {
            E = o.Pf().E(bdVar.field_imgPath, true);
            try {
                e = e.e(E, 0, e.cm(E));
            } catch (Exception e2) {
            }
            a = com.tencent.mm.y.g.a.a(gp);
            str = gp.appId;
            str = gp.appName;
            str2 = System.currentTimeMillis();
            if (bi.oW(str3)) {
                a2 = a(str2, a, str3);
                if (a2 == null) {
                    g.getLine();
                    return;
                }
            }
            a2 = null;
            bdVar2 = new bd();
            if (e != null && e.length > 0) {
                E = o.Pf().a(6, e, a.type != 2, CompressFormat.PNG);
                x.d("MicroMsg.AppMsgLogic", g.Ac() + " thumbData MsgInfo path:" + E);
                if (!bi.oW(E)) {
                    bdVar2.eq(E);
                    x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + E);
                }
            }
            if (a2 != null) {
                a.bGP = a2.sKx;
            }
            bdVar2.setContent(com.tencent.mm.y.g.a.a(a, null, null));
            bdVar2.setStatus(1);
            bdVar2.ep(bdVar.field_talker);
            bdVar2.ay(com.tencent.mm.model.bd.iD(bdVar.field_talker));
            bdVar2.eX(1);
            bdVar2.setType(d(a));
            if (com.tencent.mm.ac.f.eZ(bdVar2.field_talker)) {
                bdVar2.dt(com.tencent.mm.ac.a.e.Ir());
                x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[]{bdVar2.cqb});
            }
            au.HU();
            T = c.FT().T(bdVar2);
            x.d("MicroMsg.AppMsgLogic", g.Ac() + " msginfo insert id: " + T);
            if (T >= 0) {
                x.e("MicroMsg.AppMsgLogic", g.Ac() + "insert msg failed :" + T);
                g.getLine();
            }
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + T);
            bdVar2.setMsgId(T);
            sc scVar = new sc();
            scVar.ccT.ccU = bdVar.field_msgId;
            scVar.ccT.ccV = T;
            com.tencent.mm.sdk.b.a.sFg.m(scVar);
            com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
            gVar.field_xml = bdVar2.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = T;
            gVar.field_source = str;
            ao.cbY().b(gVar);
            if (a2 != null) {
                a2.field_msgInfoId = T;
                a2.field_status = 101;
                ao.asF().c(a2, new String[0]);
                ao.cca().run();
                return;
            }
            ao.cca();
            com.tencent.mm.pluginsdk.model.app.an.a.fM(T);
            return;
        }
        e = null;
        a = com.tencent.mm.y.g.a.a(gp);
        str = gp.appId;
        str = gp.appName;
        str2 = System.currentTimeMillis();
        if (bi.oW(str3)) {
            a2 = null;
        } else {
            a2 = a(str2, a, str3);
            if (a2 == null) {
                g.getLine();
                return;
            }
        }
        bdVar2 = new bd();
        if (a.type != 2) {
        }
        E = o.Pf().a(6, e, a.type != 2, CompressFormat.PNG);
        x.d("MicroMsg.AppMsgLogic", g.Ac() + " thumbData MsgInfo path:" + E);
        if (bi.oW(E)) {
            bdVar2.eq(E);
            x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + E);
        }
        if (a2 != null) {
            a.bGP = a2.sKx;
        }
        bdVar2.setContent(com.tencent.mm.y.g.a.a(a, null, null));
        bdVar2.setStatus(1);
        bdVar2.ep(bdVar.field_talker);
        bdVar2.ay(com.tencent.mm.model.bd.iD(bdVar.field_talker));
        bdVar2.eX(1);
        bdVar2.setType(d(a));
        if (com.tencent.mm.ac.f.eZ(bdVar2.field_talker)) {
            bdVar2.dt(com.tencent.mm.ac.a.e.Ir());
            x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[]{bdVar2.cqb});
        }
        au.HU();
        T = c.FT().T(bdVar2);
        x.d("MicroMsg.AppMsgLogic", g.Ac() + " msginfo insert id: " + T);
        if (T >= 0) {
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + T);
            bdVar2.setMsgId(T);
            sc scVar2 = new sc();
            scVar2.ccT.ccU = bdVar.field_msgId;
            scVar2.ccT.ccV = T;
            com.tencent.mm.sdk.b.a.sFg.m(scVar2);
            com.tencent.mm.y.g gVar2 = new com.tencent.mm.y.g();
            gVar2.field_xml = bdVar2.field_content;
            gVar2.field_title = a.title;
            gVar2.field_type = a.type;
            gVar2.field_description = a.description;
            gVar2.field_msgId = T;
            gVar2.field_source = str;
            ao.cbY().b(gVar2);
            if (a2 != null) {
                a2.field_msgInfoId = T;
                a2.field_status = 101;
                ao.asF().c(a2, new String[0]);
                ao.cca().run();
                return;
            }
            ao.cca();
            com.tencent.mm.pluginsdk.model.app.an.a.fM(T);
            return;
        }
        x.e("MicroMsg.AppMsgLogic", g.Ac() + "insert msg failed :" + T);
        g.getLine();
    }

    public static int d(com.tencent.mm.y.g.a aVar) {
        if (aVar == null) {
            return 49;
        }
        int i = aVar.type;
        int i2 = aVar.showType;
        int i3 = aVar.dwP;
        int i4 = aVar.dwQ;
        int i5 = aVar.dyl;
        x.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + i2 + " atype " + i + ", itemShowType = " + i3 + ", c2cNewAAType = " + i5);
        if (i3 == 4 || i4 != 0) {
            return 318767153;
        }
        if (i == 2001) {
            if (i2 == 1) {
                return 469762097;
            }
            if (i5 == 4) {
                return 503316529;
            }
            return 436207665;
        } else if (i == 2002) {
            return 536870961;
        } else {
            switch (i2) {
                case 1:
                    if (i == 21) {
                        return -1879048185;
                    }
                    return 285212721;
                case 2:
                    if (i != 21) {
                        return 301989937;
                    }
                    return -1879048183;
                case 3:
                    if (i == 21) {
                        return -1879048176;
                    }
                    return -1879048189;
                case 4:
                    if (i != 21) {
                        return -1879048190;
                    }
                    return -1879048183;
                case 5:
                    return -1879048191;
                case 17:
                    return -1879048186;
                default:
                    switch (i) {
                        case 1:
                            return 16777265;
                        case 2:
                            return 268435505;
                        case 8:
                            return 1048625;
                        case 10:
                            return 335544369;
                        case 13:
                            return 369098801;
                        case 16:
                            return 452984881;
                        case 17:
                            return -1879048186;
                        case 20:
                            return 402653233;
                        case s$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                            com.tencent.mm.y.a aVar2 = (com.tencent.mm.y.a) aVar.u(com.tencent.mm.y.a.class);
                            if (aVar2 != null && aVar2.dvC && (aVar.dyU == 2 || aVar.dyU == 3)) {
                                return 553648177;
                            }
                            if (aVar2 != null && aVar2.dvF && aVar.dyU == 3) {
                                return 587202609;
                            }
                            break;
                        case s$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                            return 520093745;
                        case 2000:
                            return 419430449;
                    }
                    return 49;
            }
        }
    }

    public static int BJ(int i) {
        switch (i) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
            case -1879048186:
            case -1879048185:
            case -1879048183:
            case -1879048176:
            case 1048625:
            case 16777265:
            case 268435505:
            case 285212721:
            case 301989937:
            case 335544369:
            case 402653233:
            case 419430449:
            case 553648177:
            case 587202609:
                return 49;
            default:
                return i;
        }
    }
}
