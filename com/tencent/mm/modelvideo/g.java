package com.tencent.mm.modelvideo;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.h;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelvideo.s.2;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.bwq;
import com.tencent.mm.protocal.c.bwr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g extends l implements k {
    private static int emr = 32000;
    private final int MAX_TIMES;
    private String cas = "";
    al dHa = new al(new 2(this), true);
    private boolean dVC = true;
    private String dVk = "";
    private a dVu = new 1(this);
    com.tencent.mm.compatible.util.g.a dYW = null;
    private b diG;
    private e diJ;
    private r elW;
    private int elY = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
    private boolean elZ = false;
    private final long ems = 1800000;
    boolean emt = false;
    private int emu = -1;
    private boolean emv = false;
    private boolean emw = false;
    private int emx = 0;
    private int emy = 0;
    int emz = 0;
    String fileName;
    int retCode = 0;
    private long startTime = 0;

    static /* synthetic */ int l(g gVar) {
        o.Ta();
        String nK = s.nK(gVar.elW.getFileName());
        if (c.oZ(nK)) {
            int i;
            com.tencent.mm.plugin.a.b bVar = new com.tencent.mm.plugin.a.b();
            long oY = bVar.oY(nK);
            long j = bVar.eyy;
            if (oY >= 131072 || oY <= 0 || gVar.elW.enM <= 5 || bVar.eyz <= 0 || j <= 0) {
                i = 0;
            } else {
                i = ((int) j) + ((int) ((bVar.eyz * 5) / ((long) gVar.elW.enM)));
                if (i <= 131072) {
                    i += 131072;
                }
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s check preload length[%d] moovPos[%d %d] duration[%d] filelen[%d]", gVar.SR(), Integer.valueOf(i), Long.valueOf(oY), Long.valueOf(j), Integer.valueOf(gVar.elW.enM), Long.valueOf(bVar.eyz));
            return i;
        }
        x.w("MicroMsg.NetSceneUploadVideo", "%s check preload length but it not mp4.", gVar.SR());
        return 0;
    }

    protected final void cancel() {
        x.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", SR(), this.dVk);
        if (!bi.oW(this.dVk)) {
            com.tencent.mm.modelcdntran.g.ND().lw(this.dVk);
        }
        this.elZ = true;
        super.cancel();
    }

    private boolean SQ() {
        if (s.hP(this.elW.Tj())) {
            x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", SR(), this.elW.Tj());
            return false;
        }
        com.tencent.mm.modelcdntran.g.ND();
        if (com.tencent.mm.modelcdntran.c.hz(2) || this.elW.enR == 1) {
            this.dVk = d.a("upvideo", this.elW.createTime, this.elW.Tj(), this.elW.getFileName());
            if (bi.oW(this.dVk)) {
                x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", SR(), this.elW.getFileName());
                return false;
            }
            o.Ta();
            String nL = s.nL(this.fileName);
            o.Ta();
            String nK = s.nK(this.fileName);
            i iVar = new i();
            iVar.dPV = this.dVu;
            iVar.field_mediaId = this.dVk;
            iVar.field_fullpath = nK;
            iVar.field_thumbpath = nA(nL);
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
            iVar.field_enable_hitcheck = this.dVC;
            iVar.field_largesvideo = com.tencent.mm.modelcontrol.d.NP().lB(nK) ? 1 : 0;
            if (this.elW != null && 3 == this.elW.enT) {
                iVar.field_smallVideoFlag = 1;
            }
            String str = "MicroMsg.NetSceneUploadVideo";
            String str2 = "%s upload video MMSightExtInfo is null? %b %s";
            Object[] objArr = new Object[3];
            objArr[0] = SR();
            objArr[1] = Boolean.valueOf(this.elW.enW == null);
            objArr[2] = this.fileName;
            x.i(str, str2, objArr);
            if (this.elW.enW != null && this.elW.enW.rUP) {
                x.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", SR());
                o.Ta();
                n.SY().a("", s.nK(this.fileName), this.elW.Tj(), "", "", 2, 2);
                com.tencent.mm.modelcontrol.d.NP();
                iVar.field_largesvideo = com.tencent.mm.modelcontrol.d.a(com.tencent.mm.modelcontrol.d.NP().NQ());
            }
            str = "MicroMsg.NetSceneUploadVideo";
            str2 = "%s checkAD file:%s adinfo:%s";
            objArr = new Object[3];
            objArr[0] = SR();
            objArr[1] = this.elW.getFileName();
            objArr[2] = this.elW.enV == null ? "null" : this.elW.enV.dyP;
            x.i(str, str2, objArr);
            if (!(this.elW.enV == null || bi.oW(this.elW.enV.dyP))) {
                iVar.field_advideoflag = 1;
            }
            iVar.field_talker = this.elW.Tj();
            iVar.field_chattype = s.fq(this.elW.Tj()) ? 1 : 0;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
            iVar.field_needStorage = false;
            iVar.field_isStreamMedia = false;
            iVar.field_trysafecdn = true;
            this.emy = com.tencent.mm.a.e.cm(iVar.field_fullpath);
            this.emx = com.tencent.mm.a.e.cm(iVar.field_thumbpath);
            if (this.emx >= com.tencent.mm.modelcdntran.b.dOG) {
                x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", SR(), iVar.field_thumbpath, Integer.valueOf(this.emx));
                return false;
            }
            int i;
            Map z = bl.z(this.elW.Tm(), "msg");
            if (z != null) {
                iVar.field_fileId = (String) z.get(".msg.videomsg.$cdnvideourl");
                iVar.field_aesKey = (String) z.get(".msg.videomsg.$aeskey");
                this.emw = true;
            } else {
                x.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", SR());
                try {
                    boolean z2;
                    boolean z3;
                    boolean z4;
                    String[] split;
                    String[] split2 = bi.oV(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("UseVideoHash")).split(",");
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eg();
                    int aM = h.aM(com.tencent.mm.kernel.a.Df(), 100);
                    boolean z5 = (split2 == null || split2.length <= 0) ? false : bi.getInt(split2[0], 0) >= aM;
                    boolean z6 = (split2 == null || split2.length < 2) ? false : bi.getInt(split2[1], 0) >= aM;
                    boolean z7 = (split2 == null || split2.length < 3) ? false : bi.getInt(split2[2], 0) >= aM;
                    if (com.tencent.mm.sdk.a.b.chp()) {
                        z2 = true;
                        z3 = true;
                        z4 = true;
                    } else {
                        z2 = z6;
                        z3 = z5;
                        z4 = z7;
                    }
                    if (z3) {
                        s Ta = o.Ta();
                        x.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", Integer.valueOf(bi.getInt(split2[2], 0)), nK, bi.cjd());
                        long VF = bi.VF();
                        if (bi.oW(nK)) {
                            x.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", nK);
                            nL = "";
                        } else {
                            int[] nN = s.nN(nK);
                            if (nN == null || nN.length < 33) {
                                x.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", nK);
                                nL = "";
                            } else {
                                Ta.dCZ.fV("VideoHash", "delete from VideoHash where CreateTime < " + (bi.VE() - 432000));
                                int i2 = nN[32];
                                StringBuffer stringBuffer = new StringBuffer();
                                for (i = 0; i < 32; i++) {
                                    stringBuffer.append(Integer.toHexString(nN[i]));
                                }
                                int length = stringBuffer.length();
                                Vector vector = new Vector();
                                Vector vector2 = new Vector();
                                Vector vector3 = new Vector();
                                Vector vector4 = new Vector();
                                int i3 = -1;
                                Cursor b = Ta.dCZ.b("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = " + i2, null, 0);
                                while (b.moveToNext()) {
                                    long j = b.getLong(1);
                                    String string = b.getString(2);
                                    String string2 = b.getString(3);
                                    String string3 = b.getString(4);
                                    x.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", string, string2);
                                    if (bi.oW(string) || bi.oW(string2)) {
                                        com.tencent.mm.plugin.report.service.h.mEJ.h(12696, Integer.valueOf(104), Integer.valueOf(i2));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", string, string2);
                                    } else if (length != string.length()) {
                                        com.tencent.mm.plugin.report.service.h.mEJ.h(12696, Integer.valueOf(105), Integer.valueOf(i2));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", Integer.valueOf(length), Integer.valueOf(string.length()));
                                    } else {
                                        i = 0;
                                        while (true) {
                                            aM = i;
                                            if (aM >= length) {
                                                break;
                                            }
                                            if (stringBuffer.charAt(aM) == string.charAt(aM)) {
                                                i = 0 + 1;
                                            } else {
                                                i = 0;
                                            }
                                            aM++;
                                        }
                                        if (i3 < 0 || vector3.size() <= i3 || ((Integer) vector3.get(i3)).intValue() < 0) {
                                            i = vector3.size();
                                        } else {
                                            i = i3;
                                        }
                                        vector3.add(Integer.valueOf(0));
                                        vector.add(string2);
                                        vector2.add(string3);
                                        vector4.add(Long.valueOf(j));
                                        x.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", Integer.valueOf(0), Integer.valueOf(length), vector3.get(i), Integer.valueOf(i), Integer.valueOf(vector3.size()));
                                        i3 = i;
                                    }
                                }
                                b.close();
                                if (i3 < 0 || vector3.size() <= 0) {
                                    com.tencent.mm.plugin.report.service.h.mEJ.h(12696, Integer.valueOf(HardCoderJNI.SCENE_RECEIVE_MSG), Integer.valueOf(i2));
                                    x.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", Integer.valueOf(i3), Integer.valueOf(vector3.size()));
                                    nL = "";
                                } else {
                                    int intValue = ((Integer) vector3.get(i3)).intValue();
                                    length = (intValue * 100) / 256;
                                    if (length < 77) {
                                        com.tencent.mm.plugin.report.service.h.mEJ.h(12696, Integer.valueOf(HardCoderJNI.SCENE_SEND_MSG), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", Long.valueOf(bi.bH(VF)), Integer.valueOf(intValue), Integer.valueOf(length), Integer.valueOf(nN.length - 1), nK);
                                        nL = "";
                                    } else {
                                        str2 = bi.oV((String) vector.get(i3));
                                        i = 0;
                                        while (true) {
                                            int i4 = i;
                                            if (i4 >= vector3.size()) {
                                                break;
                                            }
                                            if (i4 == i3 || ((Integer) vector3.get(i4)).intValue() < intValue || str2.hashCode() == ((String) vector.get(i4)).hashCode()) {
                                                i = 0;
                                            } else {
                                                i = 0 + 1;
                                            }
                                            i4++;
                                        }
                                        if (null > null) {
                                            Ta.dCZ.fV("VideoHash", "delete from VideoHash where size = " + i2);
                                            com.tencent.mm.plugin.report.service.h.mEJ.h(12696, Integer.valueOf(HardCoderJNI.SCENE_SEND_PIC_MSG), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(0));
                                            x.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", Integer.valueOf(0), nK);
                                            nL = "";
                                        } else {
                                            VF = bi.bH(VF);
                                            long a = bi.a((Long) vector4.get(i3), 0);
                                            com.tencent.mm.plugin.report.service.h.mEJ.h(12696, Integer.valueOf(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l.CTRL_BYTE), String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(intValue), Long.valueOf(a), Integer.valueOf(vector4.size()), Long.valueOf(VF)}));
                                            com.tencent.mm.plugin.report.service.h.mEJ.h(12696, Integer.valueOf(length + 3000), r5);
                                            x.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", Long.valueOf(VF), Integer.valueOf(intValue), Integer.valueOf(length), Long.valueOf(a), nK, str2, vector2.get(i3));
                                            nL = (String) vector2.get(i3);
                                            z5 = bi.VF() % 1000 < ((long) (r14 * 10)) || length < 90;
                                            x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", Boolean.valueOf(z5), Long.valueOf(VF), Integer.valueOf(r14), Integer.valueOf(length), Boolean.valueOf(com.tencent.mm.sdk.a.b.chp()));
                                            if (z5 || com.tencent.mm.sdk.a.b.chp()) {
                                                com.tencent.mm.sdk.f.e.b(new 2(Ta, nK, nL, r5), "checkVideoHashByteDiff", 1);
                                            }
                                            nL = str2;
                                        }
                                    }
                                }
                            }
                        }
                        if (!bi.oW(nL)) {
                            split = nL.split("##");
                            if (z2 && split != null && split.length == 2) {
                                iVar.field_fileId = split[0];
                                iVar.field_aesKey = split[1];
                                this.emv = true;
                            }
                            x.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", SR(), Boolean.valueOf(com.tencent.mm.sdk.a.b.chp()), r12, Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(this.emv), iVar.field_fileId, iVar.field_aesKey);
                        }
                    }
                    split = null;
                    iVar.field_fileId = split[0];
                    iVar.field_aesKey = split[1];
                    this.emv = true;
                    x.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", SR(), Boolean.valueOf(com.tencent.mm.sdk.a.b.chp()), r12, Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(this.emv), iVar.field_fileId, iVar.field_aesKey);
                } catch (Throwable e) {
                    x.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", bi.i(e));
                }
            }
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
            objArr = new Object[2];
            i = this.emv ? 1 : this.emw ? 2 : 0;
            objArr[0] = Integer.valueOf(i + 700);
            objArr[1] = Integer.valueOf(this.elW.dHI);
            hVar.h(12696, objArr);
            if (bi.oW(iVar.field_aesKey) || bi.oW(iVar.field_aesKey)) {
                nL = "";
                iVar.field_aesKey = nL;
                iVar.field_fileId = nL;
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", SR(), iVar.field_mediaId, iVar.field_fileId, iVar.field_aesKey, Boolean.valueOf(this.dVC), Integer.valueOf(iVar.field_largesvideo));
            if (com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
                if (this.elW.enR != 1) {
                    this.elW.enR = 1;
                    this.elW.status = 104;
                    this.elW.clientId = this.dVk;
                    this.elW.bWA = 524544;
                    t.e(this.elW);
                }
                return true;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 226, 1, false);
            x.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", SR());
            this.dVk = "";
            return false;
        }
        r4 = new Object[3];
        com.tencent.mm.modelcdntran.g.ND();
        r4[1] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hz(2));
        r4[2] = Integer.valueOf(this.elW.enR);
        x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", r4);
        return false;
    }

    public g(String str) {
        Assert.assertTrue(str != null);
        x.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:" + str);
        this.fileName = str;
        this.elW = t.nW(str);
        if (this.elW != null) {
            this.MAX_TIMES = 2500;
        } else {
            this.MAX_TIMES = 0;
        }
        this.dYW = new com.tencent.mm.compatible.util.g.a();
        if (this.elW != null && 3 == this.elW.enT) {
            this.elY = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        x.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", SR(), Integer.valueOf(this.elY));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        this.elW = t.nW(this.fileName);
        if (this.elW == null || !(this.elW.status == 104 || this.elW.status == 103)) {
            x.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", SR(), this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        StringBuilder append = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.elW.status).append(" [").append(this.elW.enI).append(",").append(this.elW.enJ).append("] [").append(this.elW.emu).append(",").append(this.elW.dHI).append("]  netTimes:").append(this.elW.enO).append(" times:");
        int i = this.emz;
        this.emz = i + 1;
        x.d("MicroMsg.NetSceneUploadVideo", append.append(i).toString());
        if (this.startTime == 0) {
            this.startTime = bi.VF();
            this.emu = this.elW.emu;
        }
        o.Ta();
        if (q.nE(s.nK(this.fileName))) {
            x.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", SR(), this.elW.Tm());
            com.tencent.mm.plugin.report.service.h.mEJ.a(354, 139, 1, false);
        }
        if (SQ()) {
            x.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            return 0;
        }
        String cu;
        if (this.elW.enQ == 1) {
            this.emt = true;
        } else if (this.elW.createTime + 600 < bi.VE()) {
            x.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
            t.nP(this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (!t.nO(this.fileName)) {
            x.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
            t.nP(this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.dIG = new bwq();
        aVar.dIH = new bwr();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.dIF = 149;
        aVar.dII = 39;
        aVar.dIJ = 1000000039;
        this.diG = aVar.KT();
        bwq bwq = (bwq) this.diG.dID.dIL;
        bwq.jTv = (String) com.tencent.mm.kernel.g.Ei().DT().get(2, (Object) "");
        bwq.jTu = this.elW.Tj();
        bwq.rdo = this.fileName;
        if (this.emt) {
            bwq.ssT = 2;
        }
        if (this.elW.enT == 3) {
            bwq.ssT = 3;
        }
        bwq.slf = this.elW.enM;
        bwq.rVp = this.elW.enJ;
        bwq.ssQ = this.elW.dHI;
        bwq.rvT = ab.bU(ad.getContext()) ? 1 : 2;
        bwq.rVs = 2;
        bwq.ssR = 0;
        bwq.ssS = new bhy().bq(new byte[0]);
        bwq.rVr = new bhy().bq(new byte[0]);
        if (bi.oW(this.cas)) {
            o.Ta();
            cu = com.tencent.mm.a.g.cu(s.nK(this.fileName));
            this.cas = cu;
        } else {
            cu = this.cas;
        }
        bwq.ssW = cu;
        bwq.rco = bf.Ir();
        bwq.stf = this.elW.bZN;
        bri bri = this.elW.enV;
        if (bri != null && !bi.oW(bri.dyJ)) {
            bwq.ssX = bi.aG(bri.dyJ, "");
            bwq.ssY = bri.rBq;
            bwq.ssZ = bi.aG(bri.dyL, "");
            bwq.stb = bi.aG(bri.dyN, "");
            bwq.sta = bi.aG(bri.dyM, "");
            bwq.stc = bi.aG(bri.dyO, "");
        } else if (!(bri == null || bi.oW(bri.dyN) || bi.oW(bri.dyM))) {
            bwq.stb = bri.dyN;
            bwq.sta = bri.dyM;
        }
        if (bri != null) {
            bwq.ste = bi.aG(bri.dyP, "");
            bwq.std = bi.aG(bri.dyQ, "");
        }
        x.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", Integer.valueOf(bwq.slf), Integer.valueOf(bwq.rVq), Integer.valueOf(bwq.ssQ), Integer.valueOf(bwq.ssT), bwq.ssW, bwq.ssX, Integer.valueOf(bwq.ssY), bwq.ssZ, bwq.stc);
        s.b k;
        Object obj;
        if (this.elW.status == 103) {
            o.Ta();
            k = s.k(s.nL(this.fileName), this.elW.enI, emr);
            if (k.ret < 0 || k.bEG == 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 225, 1, false);
                t.nP(this.fileName);
                x.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            x.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + k.ret + " readlen:" + k.bEG + " newOff:" + k.eon + " netOff:" + this.elW.enI);
            if (k.eon < this.elW.enI) {
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + k.eon + " OldtOff:" + this.elW.enI);
                t.nP(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            obj = new byte[k.bEG];
            System.arraycopy(k.buf, 0, obj, 0, k.bEG);
            bwq.rVq = this.elW.enI;
            bwq.rVr = new bhy().bq(obj);
        } else {
            o.Ta();
            k = s.k(s.nK(this.fileName), this.elW.emu, emr);
            if (k.ret < 0 || k.bEG == 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 224, 1, false);
                t.nP(this.fileName);
                x.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            x.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + k.ret + " readlen:" + k.bEG + " newOff:" + k.eon + " netOff:" + this.elW.emu);
            if (k.eon < this.elW.emu) {
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + k.eon + " OldtOff:" + this.elW.emu);
                t.nP(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            } else if (k.eon >= c.els) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 222, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.els);
                t.nP(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            } else {
                obj = new byte[k.bEG];
                System.arraycopy(k.buf, 0, obj, 0, k.bEG);
                bwq.ssR = this.elW.emu;
                bwq.rVq = this.elW.enI;
                bwq.ssS = new bhy().bq(obj);
            }
        }
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        bwq bwq = (bwq) ((b) qVar).dID.dIL;
        if (!bi.oW(bwq.rdo) && bwq.rVs > 0 && !bi.oW(bwq.jTv) && !bi.oW(bwq.jTu) && bwq.rvT > 0 && bwq.rVq <= bwq.rVp && bwq.rVq >= 0 && bwq.ssR <= bwq.ssQ && bwq.ssR >= 0 && ((bwq.ssR != bwq.ssQ || bwq.rVq != bwq.rVp) && bwq.rVp > 0 && bwq.ssQ > 0 && (bwq.ssS.siI > 0 || bwq.rVr.siI > 0))) {
            return b.dJm;
        }
        x.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + bwq.jTu);
        return b.dJn;
    }

    protected final int Cc() {
        return this.MAX_TIMES;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.h.mEJ.a(111, 221, 1, false);
        t.nP(this.fileName);
    }

    public final boolean KY() {
        boolean KY = super.KY();
        if (KY) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 210, 1, false);
        }
        return KY;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.dVk);
        if (this.elZ) {
            x.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.elW.Tj());
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !bi.oW(this.dVk)) {
            x.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.dVk);
        } else {
            bwr bwr = (bwr) ((b) qVar).dIE.dIL;
            bwq bwq = (bwq) ((b) qVar).dID.dIL;
            this.elW = t.nW(this.fileName);
            if (this.elW == null) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.diJ.a(i2, i3, str, this);
            } else if (this.elW.status == 105) {
                x.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                this.diJ.a(i2, i3, str, this);
            } else if (this.elW.status != 104 && this.elW.status != 103) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.elW.status + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                this.diJ.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 == -22) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.elW.Tj());
                t.nQ(this.fileName);
                this.diJ.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 220, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.elW.Tj());
                t.nP(this.fileName);
                com.tencent.mm.plugin.report.service.h.mEJ.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.elY), Integer.valueOf(0));
                this.diJ.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 219, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.elW.Tj());
                this.diJ.a(i2, i3, str, this);
            } else if (!bi.bC(bwq.rVr.siK.lR) && bwq.rVq != bwr.rVq - bwq.rVr.siI) {
                x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + bwq.rVq + "," + bwq.rVr.siI + "," + bwr.rVq + "] file:" + this.fileName + " user:" + bwq.jTu);
                t.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
            } else if (bi.bC(bwq.ssS.siK.lR) || bwq.ssR == bwr.ssR - bwq.ssS.siI) {
                this.elW.enK = bi.VE();
                this.elW.bYu = bwr.rcq;
                this.elW.bWA = 1028;
                x.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(this.elW.bYu), Integer.valueOf(af.exn));
                if (!(10007 != af.exm || af.exn == 0 || this.elW.bYu == 0)) {
                    this.elW.bYu = (long) af.exn;
                    af.exn = 0;
                }
                Object obj = null;
                int i4 = this.elW.status;
                if (i4 == 103) {
                    this.elW.enI = bwq.rVr.siI + bwq.rVq;
                    this.elW.bWA |= 64;
                    if (this.elW.enI >= this.elW.enJ) {
                        this.elW.status = 104;
                        this.elW.bWA |= 256;
                    }
                } else if (i4 == 104) {
                    this.elW.emu = bwq.ssS.siI + bwq.ssR;
                    this.elW.bWA |= 8;
                    if (this.elW.emu >= this.elW.dHI) {
                        this.elW.status = 199;
                        this.elW.bWA |= 256;
                        t.c(this.elW);
                        obj = 1;
                    }
                } else {
                    x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + i4 + " file:" + this.fileName + " user:" + bwq.jTu);
                    t.nP(this.fileName);
                    this.diJ.a(i2, i3, str, this);
                    return;
                }
                t.e(this.elW);
                if (this.elZ) {
                    this.diJ.a(i2, i3, str, this);
                } else if (obj == null) {
                    this.dHa.J(10, 10);
                } else {
                    boolean z;
                    com.tencent.mm.modelstat.b.ehL.f(((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW((long) this.elW.enN));
                    com.tencent.mm.plugin.report.service.h.mEJ.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.elY), Integer.valueOf(this.elW.dHI - this.emu));
                    if (this.elW == null) {
                        z = false;
                    } else {
                        com.tencent.mm.l.a Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(this.elW.Tj());
                        z = (Yg == null || ((int) Yg.dhP) <= 0) ? false : Yg.ckW();
                    }
                    if (z || s.hr(this.elW.Tj())) {
                        x.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", this.elW.Tj());
                        if (this.elW.bYu < 0) {
                            x.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.elW.bYu + " file:" + this.fileName + " toUser:" + this.elW.Tj());
                            t.nP(this.fileName);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
                        if (this.elW.bYu <= 0) {
                            x.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.elW.bYu + " file:" + this.fileName + " toUser:" + this.elW.Tj());
                            t.nP(this.fileName);
                        }
                    }
                    long Ad = this.dYW != null ? this.dYW.Ad() : 0;
                    x.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.elW.Tj() + " msgsvrid:" + this.elW.bYu + " thumbsize:" + this.elW.enJ + " videosize:" + this.elW.dHI + " useTime:" + Ad);
                    x.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + emr + " filesize:" + this.elW.dHI + " useTime:" + Ad);
                    a.a(this.elW, 0);
                    this.diJ.a(i2, i3, str, this);
                }
            } else {
                x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + bwq.ssR + "," + bwq.ssS.siI + "," + bwr.ssR + "] file:" + this.fileName + " user:" + bwq.jTu);
                t.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
            }
        }
    }

    public final int getType() {
        return 149;
    }

    private String nA(String str) {
        boolean z;
        Throwable e;
        File file = new File(str);
        File file2 = new File(file.getParentFile(), "send" + file.getName());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        boolean z2 = false;
        x.d("MicroMsg.NetSceneUploadVideo", "getSendThumbnailPath:origin file: %d", Long.valueOf(file.length()));
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        try {
            if (file.length() <= 32768) {
                z = z2;
            } else if (file2.exists()) {
                x.d("MicroMsg.NetSceneUploadVideo", "dst file %s exist!", file2.getAbsolutePath());
                z = true;
            } else {
                Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(file.getAbsolutePath());
                String str2 = "MicroMsg.NetSceneUploadVideo";
                String str3 = "getSendThumbnailPath:options %s";
                Object[] objArr = new Object[1];
                objArr[0] = VZ == null ? "null" : VZ.outWidth + "-" + VZ.outHeight;
                x.i(str2, str3, objArr);
                if (VZ == null || (VZ.outWidth <= 288 && VZ.outHeight <= 288)) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        Bitmap a = com.tencent.mm.sdk.platformtools.c.a(fileInputStream, 0.0f, 288, 288);
                        if (a != null) {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                z = a.compress(CompressFormat.JPEG, 60, fileOutputStream);
                                outputStream = fileOutputStream;
                                inputStream = fileInputStream;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bi.i(e));
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            z = z2;
                                        } catch (IOException e4) {
                                            z = z2;
                                        }
                                    } else {
                                        z = z2;
                                    }
                                    if (z) {
                                        x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", SR(), Long.valueOf(file2.length()), file2.getAbsolutePath());
                                        return file2.getAbsolutePath();
                                    }
                                    x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", SR(), Long.valueOf(file.length()), file.getAbsolutePath());
                                    return str;
                                } catch (Throwable th) {
                                    e = th;
                                    outputStream = fileOutputStream;
                                    inputStream = fileInputStream;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    throw e;
                                }
                            }
                        }
                        z = z2;
                        inputStream = fileInputStream;
                    } catch (Exception e7) {
                        e = e7;
                        fileOutputStream = null;
                        x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bi.i(e));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e32) {
                            }
                        }
                        if (fileOutputStream != null) {
                            z = z2;
                        } else {
                            try {
                                fileOutputStream.close();
                                z = z2;
                            } catch (IOException e42) {
                                z = z2;
                            }
                        }
                        if (z) {
                            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", SR(), Long.valueOf(file2.length()), file2.getAbsolutePath());
                            return file2.getAbsolutePath();
                        }
                        x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", SR(), Long.valueOf(file.length()), file.getAbsolutePath());
                        return str;
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e52) {
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e62) {
                            }
                        }
                        throw e;
                    }
                }
                z = com.tencent.mm.sdk.platformtools.c.a(file.getAbsolutePath(), 288, 288, CompressFormat.JPEG, 60, file2.getParentFile().getAbsolutePath() + "/", file2.getName());
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e9) {
                }
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            fileInputStream = null;
            x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bi.i(e));
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e322) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    z = z2;
                } catch (IOException e422) {
                    z = z2;
                }
            } else {
                z = z2;
            }
            if (z) {
                x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", SR(), Long.valueOf(file.length()), file.getAbsolutePath());
                return str;
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", SR(), Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e522) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e622) {
                }
            }
            throw e;
        }
        if (z) {
            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", SR(), Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        }
        x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", SR(), Long.valueOf(file.length()), file.getAbsolutePath());
        return str;
    }

    private String SR() {
        return this.fileName + "_" + hashCode();
    }
}
