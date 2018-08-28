package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.cdo;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class aw implements e, l {
    public static int nmz = 0;
    private String cXR = "";
    public Set<a> dba = new HashSet();
    private s nsa = null;
    public com.tencent.mm.plugin.sns.model.ac.a nsb = new com.tencent.mm.plugin.sns.model.ac.a() {
        public final void hQ(boolean z) {
            if (!z) {
                aw.this.bwX();
            }
        }
    };

    public interface a {
        void Q(int i, boolean z);

        void byX();
    }

    public final String bxU() {
        if (this.cXR == null || this.cXR.equals("")) {
            g.Ek();
            this.cXR = (String) g.Ei().DT().get(2, null);
        }
        return this.cXR;
    }

    private void a(n nVar, int i, int i2, String str) {
        int i3;
        qh qhVar;
        x.i("MicroMsg.UploadManager", "localId " + nVar.bBe() + "processError " + i2 + " errMsg: " + str);
        h.mEJ.a(22, 129, 1, true);
        if (i != 0) {
            try {
                i3 = ((ath) new ath().aG(af.byd().fj((long) i).nJM)).rWj;
                try {
                    atf bAW = nVar.bAW();
                    if (bAW != null) {
                        bAW.rWj = i3;
                        nVar.field_postBuf = bAW.toByteArray();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.UploadManager", "parse uploadInfo error");
                    x.d("MicroMsg.UploadManager", "post error " + i3);
                    nVar.bBi();
                    af.byo().b(nVar.nJc, nVar);
                    x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + nVar.nJc);
                    qhVar = new qh();
                    qhVar.caS.caT = (long) nVar.nJc;
                    com.tencent.mm.sdk.b.a.sFg.m(qhVar);
                    switch (i2) {
                        case 1:
                            x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                            break;
                        case 2:
                            x.e("MicroMsg.UploadManager", "parser protobuf error");
                            break;
                        case 3:
                            x.e("MicroMsg.UploadManager", "local id is not in db");
                            break;
                        case 4:
                            x.e("MicroMsg.UploadManager", "arg is error");
                            break;
                        case 5:
                            x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                            break;
                        case 6:
                            x.e("MicroMsg.UploadManager", "errtle  error");
                            break;
                    }
                    P(nVar.nJc, false);
                }
            } catch (Exception e2) {
                i3 = 0;
                x.e("MicroMsg.UploadManager", "parse uploadInfo error");
                x.d("MicroMsg.UploadManager", "post error " + i3);
                nVar.bBi();
                af.byo().b(nVar.nJc, nVar);
                x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + nVar.nJc);
                qhVar = new qh();
                qhVar.caS.caT = (long) nVar.nJc;
                com.tencent.mm.sdk.b.a.sFg.m(qhVar);
                switch (i2) {
                    case 1:
                        x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                        break;
                    case 2:
                        x.e("MicroMsg.UploadManager", "parser protobuf error");
                        break;
                    case 3:
                        x.e("MicroMsg.UploadManager", "local id is not in db");
                        break;
                    case 4:
                        x.e("MicroMsg.UploadManager", "arg is error");
                        break;
                    case 5:
                        x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                        break;
                    case 6:
                        x.e("MicroMsg.UploadManager", "errtle  error");
                        break;
                }
                P(nVar.nJc, false);
            }
        }
        atf bAW2 = nVar.bAW();
        i3 = bAW2 != null ? bAW2.rWj : 0;
        x.d("MicroMsg.UploadManager", "post error " + i3);
        nVar.bBi();
        af.byo().b(nVar.nJc, nVar);
        x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + nVar.nJc);
        qhVar = new qh();
        qhVar.caS.caT = (long) nVar.nJc;
        com.tencent.mm.sdk.b.a.sFg.m(qhVar);
        switch (i2) {
            case 1:
                x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                break;
            case 2:
                x.e("MicroMsg.UploadManager", "parser protobuf error");
                break;
            case 3:
                x.e("MicroMsg.UploadManager", "local id is not in db");
                break;
            case 4:
                x.e("MicroMsg.UploadManager", "arg is error");
                break;
            case 5:
                x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                break;
            case 6:
                x.e("MicroMsg.UploadManager", "errtle  error");
                break;
        }
        P(nVar.nJc, false);
    }

    private void c(n nVar, int i, String str) {
        a(nVar, 0, i, str);
    }

    private static int wA(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    public final boolean eu(String str, String str2) {
        x.d("MicroMsg.UploadManager", "imgPath " + str + " text " + str2);
        String str3 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.u(str.getBytes());
        FileOp.y(str, str3);
        ax axVar = new ax(1);
        axVar.My(str2);
        axVar.wG(6);
        List linkedList = new LinkedList();
        linkedList.add(new com.tencent.mm.plugin.sns.data.h(str3, 2));
        axVar.cj(linkedList);
        if (axVar.commit() > 0) {
            return true;
        }
        return false;
    }

    public static ax b(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        int i;
        x.d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        x.d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            default:
                i = -1;
                break;
        }
        ax axVar = new ax(i);
        axVar.ME(bi.aG(str2, "")).MF(bi.aG(str3, ""));
        axVar.wG(5);
        x.d("MicroMsg.UploadManager", "TimeLineType " + i);
        if (i == -1) {
            x.d("MicroMsg.UploadManager", "timeLineType is invalid");
            return null;
        }
        if (!bi.oW(str)) {
            axVar.My(str);
        }
        axVar.MD(bi.aG(wXMediaMessage.title, "")).MB(bi.aG(wXMediaMessage.description, ""));
        int wA;
        switch (iMediaObject.type()) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) iMediaObject;
                axVar.MB("");
                axVar.My(wXTextObject.text);
                return axVar;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                if (bi.bC(wXImageObject.imageData)) {
                    if (bi.oW(wXImageObject.imagePath)) {
                        x.e("MicroMsg.UploadManager", "share img but no res is exist!");
                        return null;
                    } else if (axVar.eD(wXImageObject.imagePath, "")) {
                        return axVar;
                    } else {
                        return null;
                    }
                } else if (axVar.b(wXImageObject.imageData, "", "")) {
                    return axVar;
                } else {
                    return null;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                String aG = bi.aG(!bi.oW(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String aG2 = bi.aG(!bi.oW(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                axVar.MD("").MB("");
                wA = wA(3);
                if (wA == -1) {
                    x.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (axVar.a(wXMediaMessage.thumbData, aG, bi.aG(!bi.oW(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, ""), aG2, wA, bi.aG(wXMediaMessage.title, ""), bi.aG(wXMediaMessage.description, ""))) {
                    return axVar;
                }
                return null;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                axVar.MD("").MB("");
                wA = wA(4);
                if (wA == -1) {
                    x.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (axVar.a(wXMediaMessage.thumbData, bi.aG(!bi.oW(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""), wXVideoObject.videoLowBandUrl, wXVideoObject.videoUrl, wA, bi.aG(wXMediaMessage.title, ""), bi.aG(wXMediaMessage.description, ""))) {
                    return axVar;
                }
                return null;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
                if (!bi.bC(wXMediaMessage.thumbData)) {
                    axVar.b(wXMediaMessage.thumbData, bi.aG(wXMediaMessage.description, ""), bi.aG(wXMediaMessage.title, ""));
                }
                axVar.MB(wXWebpageObject.webpageUrl).MC(wXWebpageObject.webpageUrl);
                axVar.nsx.sqc.jPK = wXWebpageObject.webpageUrl;
                axVar.MA(wXWebpageObject.canvasPageXml);
                return axVar;
            case 6:
                x.e("MicroMsg.UploadManager", "file is not support!");
                return null;
            case 7:
                WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
                if (bi.oW(wXAppExtendObject.filePath) || !wXAppExtendObject.filePath.startsWith("http")) {
                    x.e("MicroMsg.UploadManager", "appdata is not support!");
                    return null;
                }
                axVar.MD(wXAppExtendObject.filePath);
                axVar.MB(wXAppExtendObject.filePath);
                return axVar;
            default:
                x.e("MicroMsg.UploadManager", "none type not support!");
                return null;
        }
    }

    public final boolean a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i) {
        ax b = b(wXMediaMessage, str, str2, str3);
        if (b == null) {
            return false;
        }
        b.Mz(wXMediaMessage.mediaTagName);
        b.aa(str2, wXMediaMessage.messageExt, wXMediaMessage.messageAction);
        if (i > com.tencent.mm.plugin.sns.c.a.nkE) {
            b.wC(1);
        }
        x.d("MicroMsg.UploadManager", "shareAppMsg set and the result: " + b.commit());
        return true;
    }

    private boolean q(n nVar) {
        if (nVar == null) {
            return false;
        }
        bsu bAJ = nVar.bAJ();
        if (bAJ.sqc.ruz == 8) {
            return true;
        }
        if (bAJ.sqc.ruz == 2) {
            return true;
        }
        if (bAJ.sqc.ruz == 26) {
            fz fzVar = new fz();
            fzVar.bOL.type = 30;
            fzVar.bOL.bOS = 5;
            fzVar.bOL.desc = bAJ.sqc.ruC;
            fzVar.bOL.bOR = String.valueOf(nVar.nJc);
            com.tencent.mm.sdk.b.a.sFg.m(fzVar);
            if (fzVar.bOM.ret != 1) {
                return false;
            }
        }
        if (bAJ == null || bAJ.sqc.ruA == null) {
            c(nVar, 1, "timeline or timelineObjList is null");
            return false;
        } else if (bAJ.sqc.ruA.size() == 0) {
            return true;
        } else {
            try {
                boolean z;
                boolean z2;
                atf atf = (atf) new atf().aG(nVar.field_postBuf);
                if (bAJ.sqc.ruz != 1) {
                    z = true;
                } else if (atf.rWc.size() > 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (bAJ.sqc.ruz == 21) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if (bAJ.sqc.ruz == 15) {
                    Iterator it = atf.rWc.iterator();
                    while (it.hasNext()) {
                        ari ari = (ari) it.next();
                        int wB = wB(ari.rTF);
                        if (wB == b.nso) {
                            a(nVar, ari.rTF, 2, "upload has set it fail");
                            return false;
                        } else if (wB == b.nsq) {
                            return false;
                        }
                    }
                    return true;
                }
                Iterator it2 = atf.rWc.iterator();
                while (it2.hasNext()) {
                    ari ari2 = (ari) it2.next();
                    int a = a(ari2.rTF, z2, atf, bAJ.sqc.ruz);
                    if (a == b.nso) {
                        a(nVar, ari2.rTF, 2, "upload has set it fail");
                        return false;
                    } else if (a == b.nsq) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + nVar.bBe());
                c(nVar, 2, "mediaPostInfo parser error " + e.getMessage());
                return false;
            }
        }
    }

    public final void r(n nVar) {
        if (nVar != null) {
            atf atf;
            x.i("MicroMsg.UploadManager", "cancel snsinfo " + nVar.bBe());
            try {
                atf = (atf) new atf().aG(nVar.field_postBuf);
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + nVar.bBe());
                c(nVar, 2, "mediaPostInfo parser error " + e.getMessage());
                atf = null;
            }
            if (!(atf == null || atf.rWc == null)) {
                Iterator it = atf.rWc.iterator();
                while (it.hasNext()) {
                    ari ari = (ari) it.next();
                    int ww = af.byn().ww(ari.rTF);
                    af.byn().wv(ari.rTF);
                    x.i("MicroMsg.UploadManager", "cancel upload %d", new Object[]{Integer.valueOf(ww)});
                    if (nVar.field_type != 15 && ww >= 0) {
                        g.Ek();
                        g.Eh().dpP.cancel(ww);
                        af.byn().wu(ari.rTF);
                    }
                }
            }
            if (af.byn().wq(nVar.nJc) && this.nsa != null) {
                x.i("MicroMsg.UploadManager", "cancel post");
                this.nsa.hNA = true;
                g.Ek();
                g.Eh().dpP.c(this.nsa);
                af.byn().ws(nVar.nJc);
            }
            n xd = af.byo().xd(nVar.nJc);
            if (!(xd == null || xd.field_snsId == 0)) {
                af.byn().eS(xd.field_snsId);
                g.Ek();
                g.Eh().dpP.a(new r(xd.field_snsId, 1), 0);
            }
            af.byo().xe(nVar.nJc);
            if (nVar.field_type == 21) {
                com.tencent.mm.plugin.sns.lucky.a.g.bxc().bxe();
            }
            x.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + nVar.bBe());
            qh qhVar = new qh();
            qhVar.caS.caT = (long) nVar.nJc;
            com.tencent.mm.sdk.b.a.sFg.m(qhVar);
        }
    }

    public final void bwX() {
        af.aRu().postDelayed(new 1(this), 1000);
    }

    private boolean byV() {
        o byo = af.byo();
        String str = "select *,rowid from SnsInfo  where " + o.nJx + " order by SnsInfo.rowid asc ";
        Cursor rawQuery = byo.diF.rawQuery(str, null);
        x.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            rawQuery = null;
        } else {
            rawQuery.moveToFirst();
        }
        n nVar = new n();
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        do {
            nVar.d(rawQuery);
            try {
                atf atf = (atf) new atf().aG(nVar.field_postBuf);
                int i = atf.dHg;
                if (n.fh(atf.rWf)) {
                    a(atf);
                    c(nVar, 6, "snsinfo is tle");
                    x.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + nVar.bBe() + " is die ");
                }
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
                c(nVar, 2, "MediaPostInfo parser error");
            }
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return true;
    }

    private static bsu s(n nVar) {
        bsu bAJ = nVar.bAJ();
        arj arj = bAJ.sqa;
        String str = bAJ.spZ;
        String str2 = bAJ.qIb;
        String str3 = bAJ.qIc;
        String str4 = bAJ.sqc.jOS;
        String str5 = bAJ.sqc.bHD;
        String str6 = bAJ.sqc.jPK;
        String str7 = bAJ.sqc.ruC;
        dc dcVar = bAJ.sqb;
        cdo cdo = bAJ.sqi;
        int i = bAJ.sqc.ruz;
        int i2 = bAJ.sqc.ruB;
        bsu RF = com.tencent.mm.modelsns.e.RF();
        RF.hbL = nVar.field_userName;
        RF.rVG = nVar.field_pravited;
        RF.spZ = str;
        RF.qIb = bi.oV(str2);
        RF.qIc = bi.oV(str3);
        RF.sqe = bAJ.sqe;
        RF.sqf = bAJ.sqf;
        RF.dwt = bAJ.dwt;
        RF.sqg = bAJ.sqg;
        RF.ogR = bAJ.ogR;
        RF.sqc.jOS = str4;
        RF.sqc.bHD = str5;
        RF.sqc.ruz = i;
        RF.sqc.ruB = i2;
        RF.sqc.jPK = str6;
        RF.sqc.ruC = str7;
        RF.sqa = arj;
        RF.sqh = bAJ.sqh;
        RF.nNV = bAJ.nNV;
        if (bAJ.nsB != null) {
            RF.nsB = bAJ.nsB;
        }
        if (dcVar != null) {
            RF.sqb = dcVar;
        }
        if (cdo != null) {
            RF.sqi = cdo;
        }
        Iterator it = bAJ.sqc.ruA.iterator();
        while (it.hasNext()) {
            ate ate = (ate) it.next();
            if (ate.rVK == 1) {
                RF.sqc.ruA.add(ate);
            }
        }
        if (bAJ.nsD != null) {
            RF.nsD = bAJ.nsD;
        }
        return RF;
    }

    private boolean t(n nVar) {
        try {
            atf atf = (atf) new atf().aG(nVar.field_postBuf);
            atf.dHg++;
            nVar.field_postBuf = atf.toByteArray();
            af.byo().b(nVar.nJc, nVar);
            int i = atf.dHg;
            if (n.fh(atf.rWf)) {
                c(nVar, 6, "this item isTimeLimit");
                x.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + nVar.bBe() + " is die ");
                return false;
            }
            x.i("MicroMsg.UploadManager", "try start post " + nVar.bBe());
            if (q(nVar)) {
                String str;
                bsu bAJ = nVar.bAJ();
                bsu s = s(nVar);
                i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= atf.rWc.size()) {
                        break;
                    }
                    i = ((ari) atf.rWc.get(i2)).rTF;
                    r fj = af.byd().fj((long) i);
                    if (fj == null) {
                        c(nVar, 3, "can not get the media from db ,localMediaId: " + i);
                        return false;
                    }
                    try {
                        ath ath = (ath) new ath().aG(fj.nJM);
                        if (ath.rWx == null || ath.rWz.size() <= 0) {
                            x.e("MicroMsg.UploadManager", "item with not url" + nVar.field_type);
                        } else {
                            ate a;
                            ate ate;
                            str = ath.rWx.jPK;
                            String str2 = ((atb) ath.rWz.get(0)).jPK;
                            int i3 = ath.rWx.hcE;
                            int i4 = ((atb) ath.rWz.get(0)).hcE;
                            String str3 = ath.bKg;
                            atg atg = null;
                            if (i2 < bAJ.sqc.ruA.size()) {
                                atg = ((ate) bAJ.sqc.ruA.get(i2)).rVH;
                            }
                            if (bAJ.sqc.ruz != 4 && bAJ.sqc.ruz != 5) {
                                a = com.tencent.mm.modelsns.e.a(fj.nJL, fj.type, str, str2, i3, i4, ath.rVG, "", atg);
                            } else if (i2 < bAJ.sqc.ruA.size()) {
                                ate = (ate) bAJ.sqc.ruA.get(i2);
                                ate.rVE = str2;
                                ate.rVF = i4;
                                a = ate;
                            } else {
                                a = null;
                            }
                            if (a != null && s.sqc.ruz == 1) {
                                a.bKg = str3;
                            }
                            if (a != null && s.sqc.ruz == 15) {
                                a.bKg = ath.bKg;
                                a.rVZ = ath.rVZ;
                            }
                            if (i2 < bAJ.sqc.ruA.size()) {
                                ate = (ate) bAJ.sqc.ruA.get(i2);
                                a.bHD = ate.bHD;
                                a.jOS = ate.jOS;
                                a.bID = ate.bID;
                                a.nME = ate.nME;
                            }
                            if (a == null) {
                                c(nVar, 3, "make media error");
                                return false;
                            }
                            s.sqc.ruA.add(a);
                            i = i2 + 1;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        c(nVar, 2, "mediaUploadInfo parser error " + e.getMessage());
                        return false;
                    }
                }
                x.e("MicroMsg.UploadManager", "item with not url" + nVar.field_type);
                if (nVar.field_type != 3) {
                    c(nVar, 4, "buf url is null");
                    return false;
                }
                if (af.byn().wr(nVar.nJc)) {
                    List linkedList = new LinkedList();
                    Iterator it = atf.rWd.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((bqg) it.next()).hbL);
                    }
                    str = j.b(s);
                    x.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + s.sqf + " contentDescShowType: " + s.sqe);
                    if (nVar.field_pravited == 1) {
                        x.i("MicroMsg.UploadManager", "content private xml is null ? " + bi.oW(str));
                    } else {
                        x.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[]{str});
                    }
                    if (str == null || str.equals("")) {
                        c(nVar, 5, "content is error");
                        af.byn().ws(nVar.nJc);
                        return false;
                    }
                    boolean z;
                    if (atf.rWl == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    af.aRu().post(new 4(this, str, atf, linkedList, bAJ, nVar.nJc, z, atf.rWm, s.sqa.rTK, s.sqc.bHD));
                } else {
                    x.d("MicroMsg.UploadManager", "this snsinfo is posting");
                    return false;
                }
            }
            x.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + nVar.bBe());
            return true;
        } catch (Exception e2) {
            x.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
            c(nVar, 2, "MediaPostInfo parser error:" + e2.getMessage());
            return false;
        }
    }

    private void P(int i, boolean z) {
        af.aRu().post(new 3(this, i, z));
    }

    private int a(int i, boolean z, atf atf, int i2) {
        if (i == -1) {
            x.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
            return b.nso;
        }
        r fj = af.byd().fj((long) i);
        try {
            ath ath = (ath) new ath().aG(fj.nJM);
            x.i("MicroMsg.UploadManager", "state " + ath.rWA + " pic isMuti: " + z);
            if (ath.rWA == 1) {
                return b.nso;
            }
            String str = an.s(af.getAccSnsPath(), fj.nJI) + i.LE(fj.nJI);
            if (FileOp.mI(str) == 0) {
                x.i("MicroMsg.UploadManager", "path not exist  " + str);
                return b.nso;
            } else if (ath.rWA == 0) {
                return b.nsp;
            } else {
                if (af.byn().wt(i)) {
                    af.byd().a(i, fj);
                    af.aRu().post(new 5(this, i, com.tencent.mm.a.g.u((bi.VG() + " " + System.currentTimeMillis()).getBytes()), z, atf, i2));
                }
                return b.nsq;
            }
        } catch (Exception e) {
            x.e("MicroMsg.UploadManager", "parse uploadInfo error");
            return b.nso;
        }
    }

    private static void a(atf atf) {
        if (atf != null) {
            Iterator it = atf.rWc.iterator();
            while (it.hasNext()) {
                af.byn().wu(((ari) it.next()).rTF);
            }
        }
    }

    private int wB(int i) {
        if (i == -1) {
            x.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
            return b.nso;
        }
        r fj = af.byd().fj((long) i);
        try {
            ath ath = (ath) new ath().aG(fj.nJM);
            x.i("MicroMsg.UploadManager", "state " + ath.rWA + " doUploadSight, serverErr:" + ath.rWj);
            if (ath.rWA == 1) {
                return b.nso;
            }
            if (FileOp.mI(ath.videoPath) == 0) {
                x.i("MicroMsg.UploadManager", "path not fileexist  " + ath.videoPath);
                return b.nso;
            } else if (FileOp.mI(ath.rWC) == 0) {
                x.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + ath.rWC);
                return b.nso;
            } else if (ath.rWA == 0) {
                return b.nsp;
            } else {
                if (af.byn().wt(i)) {
                    af.byd().a(i, fj);
                    new ac(i, fj, ath.videoPath, ath.rWC, this.nsb).bxO();
                }
                return b.nsq;
            }
        } catch (Exception e) {
            x.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
            return b.nso;
        }
    }

    public final void byW() {
        for (a aVar : this.dba) {
            if (aVar != null) {
                aVar.byX();
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + lVar.getType() + " @" + hashCode());
        switch (lVar.getType()) {
            case 207:
                if (!(i == 0 && i2 == 0)) {
                    bwX();
                    break;
                }
            case 209:
                s sVar = (s) lVar;
                int i3 = sVar.nkZ;
                if (sVar.hNA) {
                    long j = sVar.noj;
                    x.i("MicroMsg.UploadManager", "get the del post come back %d " + j, new Object[]{Integer.valueOf(i3)});
                    if (j != 0) {
                        af.byn().eS(j);
                        g.Ek();
                        g.Eh().dpP.a(new r(j, 1), 0);
                    }
                    af.byo().xe(i3);
                    if (j != 0) {
                        af.byt().fd(j);
                        com.tencent.mm.plugin.sns.storage.i.fc(j);
                    }
                }
                if (i == 0 && i2 == 0) {
                    P(sVar.nkZ, true);
                    ak.eW(sVar.noj);
                } else {
                    P(sVar.nkZ, false);
                }
                this.nsa = null;
                break;
        }
        if (i != 0 || i2 != 0) {
        }
    }
}
