package com.tencent.mm.modelvideo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.protocal.c.sp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class d extends l implements k {
    int dHI;
    private al dHa;
    String dVk;
    String dVr;
    int dVs;
    private a dVu;
    private b diG;
    e diJ;
    boolean elU;
    boolean elV;
    r elW;
    j elX;
    int elY;
    private boolean elZ;
    boolean ema;
    long emb;
    String fileName;
    private String mediaId;
    int retCode;
    private int startOffset;
    long startTime;

    protected final void cancel() {
        wk();
        super.cancel();
    }

    final boolean wk() {
        boolean z = false;
        if (!bi.oW(this.mediaId)) {
            if (this.elU) {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[]{SR()});
                o.Tb().k(this.mediaId, null);
            } else {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[]{SR()});
                g.ND().lx(this.mediaId);
            }
            z = true;
        }
        this.elZ = true;
        return z;
    }

    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        this.elW = null;
        this.dVk = "";
        this.startOffset = 0;
        this.startTime = 0;
        this.dHI = 0;
        this.retCode = 0;
        this.elY = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.elZ = false;
        this.ema = true;
        this.dVr = null;
        this.dVs = 0;
        this.emb = 0;
        this.dVu = new 1(this);
        this.dHa = new al(new 3(this), false);
        Assert.assertTrue(str != null);
        this.fileName = str;
        this.elU = z;
        x.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[]{SR(), str, Boolean.valueOf(z)});
    }

    private boolean SQ() {
        x.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[]{SR(), this.elW.Tm()});
        Map z = bl.z(this.elW.Tm(), "msg");
        if (z == null) {
            h.mEJ.a(111, 214, 1, false);
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[]{SR()});
            return false;
        }
        String str = (String) z.get(".msg.videomsg.$cdnvideourl");
        String str2 = (String) z.get(".msg.videomsg.$tpvideourl");
        if (bi.oW(str) && bi.oW(str2)) {
            h.mEJ.a(111, 213, 1, false);
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[]{SR()});
            return false;
        }
        String str3 = (String) z.get(".msg.videomsg.$aeskey");
        this.dHI = bi.getInt((String) z.get(".msg.videomsg.$length"), 0);
        String str4 = (String) z.get(".msg.videomsg.$fileparam");
        this.dVk = com.tencent.mm.modelcdntran.d.a("downvideo", this.elW.createTime, this.elW.Tj(), this.elW.getFileName());
        if (bi.oW(this.dVk)) {
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[]{SR(), this.elW.getFileName()});
            return false;
        }
        Object obj;
        if (!this.elU && this.dHI < 1048576 && this.elW != null && this.elW.bSX > 0) {
            this.elU = true;
            x.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[]{SR(), Boolean.valueOf(this.elU)});
        }
        String str5 = (String) z.get(".msg.videomsg.$md5");
        StringBuilder stringBuilder = new StringBuilder();
        o.Ta();
        String stringBuilder2 = stringBuilder.append(s.nK(this.fileName)).append(".tmp").toString();
        this.elX = new j();
        this.elX.filename = this.elW.getFileName();
        this.elX.dQk = str5;
        this.elX.dQl = this.dHI;
        this.elX.dQm = 0;
        this.elX.bSS = this.elW.Tk();
        this.elX.dQn = this.elW.Tj();
        this.elX.bSU = s.fq(this.elW.Tj()) ? m.gK(this.elW.Tj()) : 0;
        this.elX.field_mediaId = this.dVk;
        this.elX.field_fullpath = stringBuilder2;
        this.elX.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.elX.field_totalLen = this.dHI;
        this.elX.field_aesKey = str3;
        this.elX.field_fileId = str;
        this.elX.field_priority = com.tencent.mm.modelcdntran.b.dOk;
        this.elX.dPV = this.dVu;
        this.elX.field_wxmsgparam = str4;
        this.elX.field_chattype = s.fq(this.elW.Tj()) ? 1 : 0;
        this.elX.dQo = this.elW.dQo;
        if (!bi.oW(str2)) {
            str3 = (String) z.get(".msg.videomsg.$tpauthkey");
            this.elX.field_fileId = "";
            this.elX.field_fileType = 19;
            this.elX.field_authKey = str3;
            this.elX.dPW = str2;
        }
        bd I = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().I(this.elW.Tj(), this.elW.bYu);
        this.elX.dQq = I.field_createTime;
        this.elX.bYu = I.field_msgSvrId;
        com.tencent.mm.model.bd.b iF = com.tencent.mm.model.bd.iF(I.cqb);
        this.elX.dQr = iF != null ? iF.dCB : 0;
        if (this.elW.Tj().equals(I.field_talker)) {
            this.elX.field_limitrate = iF == null ? 0 : iF.dCz / 8;
        }
        x.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[]{SR(), Integer.valueOf(this.elX.field_limitrate), this.elW.getFileName()});
        if (g.ND().dPa.contains("video_" + this.elW.enN)) {
            g.ND().dPa.remove("video_" + this.elW.enN);
            this.elX.field_autostart = true;
        } else {
            this.elX.field_autostart = false;
        }
        if (3 == this.elW.enT) {
            this.elX.field_smallVideoFlag = 1;
        }
        if (!(bi.oW(str5) || this.elU)) {
            int i;
            str2 = ((com.tencent.mm.plugin.t.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.t.a.a.class)).FY().de(str5, this.dHI);
            int cm = com.tencent.mm.a.e.cm(str2);
            int i2 = this.dHI - cm;
            o.Ta();
            str3 = s.nK(this.fileName);
            if (com.tencent.mm.a.e.cm(str3) > 0) {
                x.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[]{SR()});
                boolean deleteFile = com.tencent.mm.a.e.deleteFile(str3);
                bc FY = ((com.tencent.mm.plugin.t.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.t.a.a.class)).FY();
                int i3 = this.dHI;
                i = 0;
                if (!bi.oW(str5)) {
                    i = FY.diF.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str5, String.valueOf(i3), "100"});
                }
                r nW = t.nW(this.fileName);
                nW.enH = 0;
                nW.bWA = 16;
                t.e(nW);
                x.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[]{SR(), Integer.valueOf(r11), Boolean.valueOf(deleteFile), Integer.valueOf(i)});
                str2 = "";
            }
            x.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[]{SR(), Integer.valueOf(this.dHI), str5, Integer.valueOf(cm), str2, Integer.valueOf(i2), stringBuilder2, Integer.valueOf(r11)});
            if (bi.oW(str2)) {
                this.dVr = str5;
                this.dVs = this.dHI;
            } else if (i2 >= 0 && i2 <= 16) {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[]{SR(), str2, stringBuilder2});
                com.tencent.mm.sdk.platformtools.j.fN(str2, stringBuilder2);
                iE(this.dHI);
                ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().a(new c(I.field_talker, "update", I));
                h hVar = h.mEJ;
                Object[] objArr = new Object[7];
                objArr[0] = str;
                objArr[1] = Long.valueOf(this.elW.bYu);
                objArr[2] = str5;
                objArr[3] = Long.valueOf(this.elW.createTime);
                objArr[4] = this.elW.Tj();
                objArr[5] = Integer.valueOf(3 != this.elW.enT ? 43 : 62);
                objArr[6] = Integer.valueOf(cm);
                hVar.h(13267, objArr);
                obj = 1;
                if (obj == null) {
                    this.mediaId = this.elX.field_mediaId;
                    this.emb = bi.VF();
                    this.elV = this.elW.videoFormat == 2;
                    x.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[]{SR(), Boolean.valueOf(this.elV), Boolean.valueOf(this.elU)});
                    if (!this.elV && this.elU) {
                        this.ema = false;
                        j jVar = this.elX;
                        o.Ta();
                        jVar.field_fullpath = s.nK(this.fileName);
                        o.Tb().a(this.elX, false);
                    } else if (!g.ND().b(this.elX, -1)) {
                        h.mEJ.a(111, 212, 1, false);
                        x.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[]{SR()});
                        this.dVk = "";
                        return false;
                    } else if (this.elV) {
                        h.mEJ.a(354, 135, 1, false);
                    }
                }
                if (this.elW.enR != 1) {
                    this.elW.enR = 1;
                    this.elW.bWA = 524288;
                    t.e(this.elW);
                }
                if (3 != this.elW.enT) {
                    str5 = this.elW.Tj();
                    if (!bi.oW(str5)) {
                        int gK;
                        if (s.fq(str5)) {
                            gK = m.gK(str5);
                        } else {
                            gK = 0;
                        }
                        try {
                            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                            int subtype = activeNetworkInfo.getSubtype();
                            if (activeNetworkInfo.getType() == 1) {
                                i = 1;
                            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                                i = 4;
                            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                                i = 3;
                            } else if (subtype == 1 || subtype == 2) {
                                i = 2;
                            } else {
                                i = 0;
                            }
                        } catch (Throwable e) {
                            x.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[]{bi.i(e)});
                            i = 0;
                        }
                        x.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[]{SR(), str5 + "," + gK + "," + str + "," + this.dHI + "," + i});
                        h.mEJ.k(12024, str);
                    }
                }
                return true;
            }
        }
        obj = null;
        if (obj == null) {
            this.mediaId = this.elX.field_mediaId;
            this.emb = bi.VF();
            this.elV = this.elW.videoFormat == 2;
            x.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[]{SR(), Boolean.valueOf(this.elV), Boolean.valueOf(this.elU)});
            if (!this.elV && this.elU) {
                this.ema = false;
                j jVar2 = this.elX;
                o.Ta();
                jVar2.field_fullpath = s.nK(this.fileName);
                o.Tb().a(this.elX, false);
            } else if (!g.ND().b(this.elX, -1)) {
                h.mEJ.a(111, 212, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[]{SR()});
                this.dVk = "";
                return false;
            } else if (this.elV) {
                h.mEJ.a(354, 135, 1, false);
            }
        }
        if (this.elW.enR != 1) {
            this.elW.enR = 1;
            this.elW.bWA = 524288;
            t.e(this.elW);
        }
        if (3 != this.elW.enT) {
            str5 = this.elW.Tj();
            if (!bi.oW(str5)) {
                int gK2;
                if (s.fq(str5)) {
                    gK2 = m.gK(str5);
                } else {
                    gK2 = 0;
                }
                try {
                    NetworkInfo activeNetworkInfo2 = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    int subtype2 = activeNetworkInfo2.getSubtype();
                    if (activeNetworkInfo2.getType() == 1) {
                        i = 1;
                    } else if (subtype2 == 13 || subtype2 == 15 || subtype2 == 14) {
                        i = 4;
                    } else if (subtype2 == 3 || subtype2 == 4 || subtype2 == 5 || subtype2 == 6 || subtype2 == 12) {
                        i = 3;
                    } else if (subtype2 == 1 || subtype2 == 2) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                } catch (Throwable e2) {
                    x.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[]{bi.i(e2)});
                    i = 0;
                }
                x.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[]{SR(), str5 + "," + gK2 + "," + str + "," + this.dHI + "," + i});
                h.mEJ.k(12024, str);
            }
        }
        return true;
    }

    final void iE(int i) {
        boolean renameTo;
        if (this.ema) {
            StringBuilder stringBuilder = new StringBuilder();
            o.Ta();
            File file = new File(stringBuilder.append(s.nK(this.fileName)).append(".tmp").toString());
            o.Ta();
            renameTo = file.renameTo(new File(s.nK(this.fileName)));
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            o.Ta();
            com.tencent.mm.a.e.deleteFile(stringBuilder2.append(s.nK(this.fileName)).append(".tmp").toString());
            renameTo = true;
        }
        com.tencent.mm.kernel.g.Em().H(new 2(this, renameTo, i));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 1;
        this.diJ = eVar2;
        this.elW = t.nW(this.fileName);
        if (this.elW == null) {
            x.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            return -1;
        }
        if (this.elW != null && 3 == this.elW.enT) {
            this.elY = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        if (this.startTime == 0) {
            this.startTime = bi.VF();
            this.startOffset = this.elW.enH;
        }
        if (SQ()) {
            x.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[]{this.fileName});
            return 0;
        } else if (this.elW.status != 112) {
            x.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.elW.status + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "]");
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            return -1;
        } else {
            x.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "]  filesize:" + this.elW.enH + " file:" + this.elW.dHI + " netTimes:" + this.elW.enO);
            if (!t.nO(this.fileName)) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.elW.enO + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else if (this.elW.bYu <= 0) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.elW.bYu + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else if (this.elW.enH < 0 || this.elW.dHI <= this.elW.enH || this.elW.dHI <= 0) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.elW.enH + " total:" + this.elW.dHI + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else {
                b.a aVar = new b.a();
                aVar.dIG = new so();
                aVar.dIH = new sp();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvideo";
                aVar.dIF = 150;
                aVar.dII = 40;
                aVar.dIJ = 1000000040;
                this.diG = aVar.KT();
                so soVar = (so) this.diG.dID.dIL;
                soVar.rcq = this.elW.bYu;
                soVar.rdW = this.elW.enH;
                soVar.rdV = this.elW.dHI;
                if (!ab.bU(ad.getContext())) {
                    i = 2;
                }
                soVar.rvT = i;
                return a(eVar, this.diG, this);
            }
        }
    }

    protected final int a(q qVar) {
        so soVar = (so) ((b) qVar).dID.dIL;
        if (soVar.rcq > 0 && soVar.rdW >= 0 && soVar.rdV > 0 && soVar.rdV > soVar.rdW) {
            return l.b.dJm;
        }
        x.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
        t.nP(this.fileName);
        return l.b.dJn;
    }

    protected final int Cc() {
        return 2500;
    }

    public final boolean KY() {
        boolean KY = super.KY();
        if (KY) {
            h.mEJ.a(111, 210, 1, false);
        }
        return KY;
    }

    protected final void a(l.a aVar) {
        h.mEJ.a(111, 211, 1, false);
        t.nP(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.elZ) {
            x.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !bi.oW(this.dVk)) {
            x.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.dVk});
        } else {
            sp spVar = (sp) ((b) qVar).dIE.dIL;
            so soVar = (so) ((b) qVar).dID.dIL;
            this.elW = t.nW(this.fileName);
            if (this.elW == null) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.diJ.a(i2, i3, str, this);
            } else if (this.elW.status == 113) {
                x.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                this.diJ.a(i2, i3, str, this);
            } else if (this.elW.status != 112) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.elW.status + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                this.diJ.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                h.mEJ.a(111, 208, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                h.mEJ.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bL(ad.getContext())), Integer.valueOf(this.elY), Integer.valueOf(this.dHI - this.startOffset)});
                this.diJ.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                h.mEJ.a(111, 207, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                this.elW.status = 113;
                t.e(this.elW);
                this.diJ.a(i2, i3, str, this);
            } else if (bi.bC(spVar.rtW.siK.lR)) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
            } else if (spVar.rdW != soVar.rdW) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + spVar.rdW + " reqStartPos:" + soVar.rdW + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
            } else if (spVar.rdV != soVar.rdV) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + spVar.rdV + " reqTotal:" + soVar.rdV + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
            } else if (soVar.rdV < spVar.rdW) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + spVar.rdV + " respStartPos:" + soVar.rdW + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
            } else if (spVar.rcq != soVar.rcq) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + spVar.rcq + " reqMsgId:" + soVar.rcq + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                t.nP(this.fileName);
                this.diJ.a(i2, i3, str, this);
            } else {
                x.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + spVar.rtW.siI + " reqStartPos:" + soVar.rdW + " totallen:" + soVar.rdV + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                o.Ta();
                int a = s.a(s.nK(this.fileName), soVar.rdW, spVar.rtW.siK.toByteArray());
                if (a < 0) {
                    x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + a + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                    t.nP(this.fileName);
                    this.diJ.a(i2, i3, str, this);
                } else if (a > this.elW.dHI) {
                    x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + a + " totalLen:" + this.elW.dHI + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                    t.nP(this.fileName);
                    this.diJ.a(i2, i3, str, this);
                } else {
                    int line;
                    String str2 = this.fileName;
                    r nW = t.nW(str2);
                    if (nW == null) {
                        x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " getinfo failed: " + str2);
                        line = 0 - com.tencent.mm.compatible.util.g.getLine();
                    } else {
                        nW.enH = a;
                        nW.enK = bi.VE();
                        nW.bWA = 1040;
                        line = 0;
                        if (nW.dHI > 0 && a >= nW.dHI) {
                            t.d(nW);
                            nW.status = 199;
                            nW.bWA |= 256;
                            x.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str2 + " newsize:" + a + " total:" + nW.dHI + " status:" + nW.status + " netTimes:" + nW.enO);
                            line = 1;
                        }
                        x.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.Ac() + " file:" + str2 + " newsize:" + a + " total:" + nW.dHI + " status:" + nW.status);
                        if (!t.e(nW)) {
                            line = 0 - com.tencent.mm.compatible.util.g.getLine();
                        }
                    }
                    if (line < 0) {
                        x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + line + " newOffset :" + a + " [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "] ");
                        this.diJ.a(i2, i3, str, this);
                    } else if (line == 1) {
                        h.mEJ.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bL(ad.getContext())), Integer.valueOf(this.elY), Integer.valueOf(this.dHI - this.startOffset)});
                        a.a(this.elW, 1);
                        x.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.elW.bYu + "," + this.elW.Tk() + "," + this.elW.Tj() + "]");
                        this.diJ.a(i2, i3, str, this);
                    } else if (this.elZ) {
                        this.diJ.a(i2, i3, str, this);
                    } else {
                        this.dHa.J(0, 0);
                    }
                }
            }
        }
    }

    public final int getType() {
        return 150;
    }

    final String SR() {
        return this.fileName + "_" + hashCode();
    }
}
