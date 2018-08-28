package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.k.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.HashMap;

public final class l {
    long dQj;
    int elC = 0;
    int elD = 0;
    f elE;
    int elF;
    int elG;
    boolean elI;
    int elJ = 0;
    private int elK;
    boolean elL = false;
    boolean elM = false;
    int fhf;
    String filename;
    String mediaId;
    HashMap<String, Integer> nPL = new HashMap();
    int nPN;
    int nPO = 0;
    long nPP;
    long nPQ;
    private long nPR;
    private int nPS;
    i tXK;
    a tXL;

    public l(i iVar) {
        int i;
        this.tXK = iVar;
        reset();
        this.elE = new f();
        this.tXL = new a((byte) 0);
        String value = g.AT().getValue("AndroidOnlineVideoArgs");
        if (!bi.oW(value)) {
            x.i("MicroMsg.OnlineVideoUIHelper", "online video config : " + value);
            String[] split = value.split(";");
            if (split != null && split.length >= 4) {
                this.tXL.elS = bi.getInt(split[0], 5);
                this.tXL.elT = bi.getInt(split[1], 1);
                this.tXL.nPV = bi.getInt(split[2], 75);
                this.tXL.tXN = bi.getInt(split[3], 1) * 1048576;
                i = 1;
                if (i == 0) {
                    this.tXL.elS = 5;
                    this.tXL.elT = 1;
                    this.tXL.nPV = 75;
                    this.tXL.tXN = 1048576;
                }
                x.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[]{Integer.valueOf(this.tXL.elS), Integer.valueOf(this.tXL.elT), Integer.valueOf(this.tXL.nPV), Integer.valueOf(this.tXL.tXN)});
                this.elK = this.tXL.elS;
            }
        }
        boolean i2 = false;
        if (i2 == 0) {
            this.tXL.elS = 5;
            this.tXL.elT = 1;
            this.tXL.nPV = 75;
            this.tXL.tXN = 1048576;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[]{Integer.valueOf(this.tXL.elS), Integer.valueOf(this.tXL.elT), Integer.valueOf(this.tXL.nPV), Integer.valueOf(this.tXL.tXN)});
        this.elK = this.tXL.elS;
    }

    public final void reset() {
        String str = "";
        this.mediaId = str;
        this.filename = str;
        this.elG = -1;
        this.nPN = 0;
        this.fhf = 0;
        this.elJ = 0;
        this.elF = 0;
        this.nPO = 0;
        this.elD = 0;
        this.elC = 0;
        this.elI = false;
        this.elL = false;
        this.elM = false;
        this.nPL.clear();
        if (this.tXL != null) {
            this.elK = this.tXL.elS;
        }
        this.nPP = 0;
        this.dQj = 0;
        this.nPS = 0;
        this.nPR = 0;
        this.nPQ = 0;
    }

    public final void cxB() {
        int i;
        x.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
        if (this.elC == 3) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        this.elC = 0;
        if (!bi.oW(this.mediaId)) {
            if (i2 != 0) {
                cxD();
            } else if (this.nPN >= this.tXL.nPV) {
                x.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[]{Integer.valueOf(this.nPN), Integer.valueOf(this.tXL.nPV)});
                t.V(this.filename, 2);
                h.mEJ.a(354, 10, 1, false);
            }
            o.Tb().k(this.mediaId, cxE());
            h.mEJ.a(354, 2, 1, false);
        }
    }

    public final boolean isStreaming() {
        return !bi.oW(this.mediaId) && (this.elC == 1 || this.elC == 3);
    }

    public final boolean NS(String str) {
        return bi.fS(str, this.mediaId);
    }

    final void bCx() {
        x.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[]{this.filename});
        bCy();
        ah.A(new Runnable() {
            public final void run() {
                if (l.this.tXK != null) {
                    l.this.tXK.aX(l.this.filename, false);
                }
            }
        });
    }

    public final boolean ap(int i, boolean z) {
        boolean z2;
        switch (this.elC) {
            case 1:
                this.elD = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!f(pInt.value, pInt2.value, true)) {
                    this.elG = i;
                    this.elI = true;
                    this.tXK.SN();
                    z2 = false;
                    break;
                }
                this.elG = -1;
                this.elI = false;
                this.elJ = pInt2.value;
                this.elD = 3;
                break;
            case 3:
                break;
        }
        this.tXK.R(i, z);
        z2 = true;
        x.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.elC), Integer.valueOf(this.elD)});
        h.mEJ.a(354, 4, 1, false);
        return z2;
    }

    public final boolean iC(int i) {
        int i2;
        boolean z = false;
        if (this.elG != -1) {
            i2 = this.elG;
        } else {
            i2 = i;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.elJ), Integer.valueOf(this.elF), Integer.valueOf(this.elC), Long.valueOf(this.nPQ - this.dQj), Boolean.valueOf(this.elL)});
        switch (this.elC) {
            case 1:
                boolean z2;
                if (iD(i2)) {
                    if (this.nPO == 0 && this.nPQ == 0) {
                        bCy();
                    }
                    if (this.elL) {
                        l lVar;
                        int i3;
                        this.tXK.aaz(this.filename);
                        if (this.elI) {
                            if (this.nPO == 0 && this.nPQ == 0) {
                                bCy();
                            } else if (this.nPR > 0) {
                                this.nPS = (int) (((long) this.nPS) + bi.bH(this.nPR));
                            }
                            x.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[]{Integer.valueOf(this.nPO), Integer.valueOf(this.nPS)});
                            if (this.elG != -1) {
                                this.tXK.R(this.elG, true);
                                this.elG = -1;
                                z2 = false;
                                lVar = this;
                            } else if (this.tXK.bCr()) {
                                z2 = false;
                                lVar = this;
                            } else {
                                z2 = true;
                                lVar = this;
                            }
                            lVar.elI = z2;
                            i3 = 3;
                            lVar = this;
                        } else {
                            if (this.elD != 3) {
                                x.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[]{Integer.valueOf(this.elD)});
                                if (this.tXK.bCr()) {
                                    i3 = 3;
                                    lVar = this;
                                } else {
                                    i3 = this.elD;
                                    lVar = this;
                                }
                            }
                            z2 = true;
                        }
                        lVar.elD = i3;
                        z2 = true;
                    } else {
                        x.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[]{this.filename});
                        this.tXK.aX(this.filename, true);
                        this.elL = true;
                        z2 = true;
                    }
                } else {
                    this.elI = true;
                    if (this.elJ > 0) {
                        x.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.nPO + " playStatus : " + this.elD);
                        this.nPR = bi.VF();
                        if (!(this.elD == 2 || this.elD == 4)) {
                            this.elK += this.tXL.elS;
                            this.elK = Math.min(this.elK, 60);
                            this.nPO++;
                            this.elD = 4;
                        }
                        this.tXK.SN();
                    } else if (this.elG == -1) {
                        this.elD = 1;
                    } else {
                        this.elD = 2;
                    }
                    z2 = false;
                }
                this.tXK.FI(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (!a(i2, pInt, pInt2)) {
                    x.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
                } else if (f(pInt.value, pInt2.value, false)) {
                    this.elJ = Math.max(this.elJ, pInt2.value);
                    return true;
                }
                return z2;
            case 3:
                bCy();
                if (this.elL) {
                    if (this.elI) {
                        l lVar2;
                        if (this.elG != -1) {
                            this.tXK.R(this.elG, true);
                            this.elG = -1;
                            lVar2 = this;
                        } else if (this.tXK.bCr()) {
                            lVar2 = this;
                        } else {
                            z = true;
                            lVar2 = this;
                        }
                        lVar2.elI = z;
                    }
                    this.tXK.FI(i2);
                    return true;
                }
                this.tXK.aX(this.filename, false);
                this.elL = true;
                return true;
            default:
                return true;
        }
    }

    public final boolean iD(int i) {
        Throwable e;
        if (this.elC == 3) {
            return true;
        }
        if (this.elJ - i <= 2 && this.elJ < this.elF) {
            return false;
        }
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.elE.a(i, i + 2, pInt, pInt2)) {
                isVideoDataAvailable = o.Tb().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    try {
                        this.elJ = i;
                    } catch (Exception e2) {
                        e = e2;
                        x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                        x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                        return isVideoDataAvailable;
                    }
                }
            }
            isVideoDataAvailable = false;
        } catch (Exception e3) {
            e = e3;
            isVideoDataAvailable = false;
            x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
            return isVideoDataAvailable;
        }
        return isVideoDataAvailable;
    }

    private boolean a(int i, PInt pInt, PInt pInt2) {
        pInt.value = Math.max(i, this.elJ);
        if (this.elD == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.elK;
        }
        if (this.elD == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.elK) + 8;
        }
        if (this.elD == 3 || this.elD == 4) {
            pInt.value = this.elJ;
            pInt2.value = ((this.elK + i) + 2) + this.tXL.elT;
        }
        if (pInt2.value >= this.elF + 1) {
            pInt2.value = this.elF + 1;
        }
        if (pInt2.value <= pInt.value) {
            pInt2.value = pInt.value + this.tXL.elT;
            return false;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.elD), Integer.valueOf(this.elJ), Integer.valueOf(this.elK)});
        return true;
    }

    private boolean f(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.elE.a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = o.Tb().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    x.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
                } else if (!this.nPL.containsKey(this.mediaId + 0 + "_-1")) {
                    String str = this.mediaId + pInt.value + "_" + pInt2.value;
                    x.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.elM), Boolean.valueOf(z)});
                    if (this.nPL.containsKey(str) || (this.elM && !z)) {
                        x.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str);
                    } else {
                        this.elM = true;
                        o.Tb();
                        com.tencent.mm.modelcdntran.f.g(this.mediaId, pInt.value, pInt2.value);
                        this.nPL.put(str, Integer.valueOf(i2));
                    }
                }
                return isVideoDataAvailable;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
            x.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
        } else if (!this.nPL.containsKey(this.mediaId + 0 + "_-1")) {
            String str2 = this.mediaId + pInt.value + "_" + pInt2.value;
            x.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.elM), Boolean.valueOf(z)});
            if (this.nPL.containsKey(str2) || (this.elM && !z)) {
                x.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str2);
            } else {
                this.elM = true;
                o.Tb();
                com.tencent.mm.modelcdntran.f.g(this.mediaId, pInt.value, pInt2.value);
                this.nPL.put(str2, Integer.valueOf(i2));
            }
        }
        return isVideoDataAvailable;
    }

    public final void cxC() {
        String str = this.mediaId + 0 + "_-1";
        if (!this.nPL.containsKey(str)) {
            x.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[]{this.mediaId});
            o.Tb();
            com.tencent.mm.modelcdntran.f.g(this.mediaId, 0, -1);
            this.nPL.put(str, Integer.valueOf(0));
            h.mEJ.a(354, 24, 1, false);
            x.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[]{Integer.valueOf(hashCode()), this.filename});
            h.mEJ.h(13836, new Object[]{Integer.valueOf(TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER), Long.valueOf(bi.VE()), ""});
        }
        this.elD = 5;
    }

    final void cxD() {
        o.Ta();
        if (q.nF(s.nK(this.filename))) {
            boolean b;
            x.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[]{this.filename});
            r nW = t.nW(this.filename);
            if (nW != null) {
                nW.videoFormat = 2;
                nW.status = TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED;
                nW.enL = bi.VE();
                nW.enK = bi.VE();
                nW.dQo = 19;
                nW.bWA = 268438786;
                b = o.Ta().b(nW);
                x.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + b + " status: " + nW.status);
            } else {
                b = false;
            }
            if (b) {
                h.mEJ.a(354, 134, 1, false);
            }
        }
    }

    final void bCy() {
        if (this.nPQ == 0) {
            this.nPQ = bi.VF();
        }
    }

    final Object[] cxE() {
        Object[] objArr = new Object[7];
        i iVar = this.tXK;
        if (iVar.nPE < 0) {
            iVar.nPE = 0;
        }
        x.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[]{iVar.filename, Integer.valueOf(iVar.nPE)});
        objArr[0] = Integer.valueOf(iVar.nPE);
        if (this.nPQ <= 0) {
            this.nPQ = bi.VF();
        }
        int i = (int) (this.nPQ - this.dQj);
        if (i <= 0) {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        if (this.nPP <= 0) {
            this.nPP = bi.VF();
        }
        i = (int) (this.nPP - this.dQj);
        if (i <= 0) {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(this.nPO);
        if (this.nPO > 0) {
            if (this.nPS == 0) {
                this.nPS = (int) (((long) this.nPS) + bi.bH(this.nPR));
            }
            objArr[4] = Integer.valueOf(this.nPS / this.nPO);
        } else {
            objArr[4] = Integer.valueOf(0);
        }
        i iVar2 = this.tXK;
        if (iVar2.nPy <= 0 || iVar2.nPx <= 0) {
            i = 0;
        } else {
            i = (int) (iVar2.nPy - iVar2.nPx);
        }
        if (i < 0) {
            i = 0;
        }
        x.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[]{Integer.valueOf(iVar2.hashCode()), iVar2.filename, Integer.valueOf(i), Long.valueOf(iVar2.nPy), Long.valueOf(iVar2.nPx)});
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Integer.valueOf(this.tXK.jfN);
        return objArr;
    }
}
