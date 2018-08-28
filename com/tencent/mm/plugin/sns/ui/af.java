package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.k.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.5;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class af {
    String bKW;
    ate caK;
    long dQj;
    int dTR;
    String elA;
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
    String elz;
    HashMap<String, Integer> nPL = null;
    a nPM;
    int nPN;
    private int nPO = 0;
    long nPP;
    private long nPQ;
    private long nPR;
    private int nPS;
    private b nPT;
    int progress;
    int total;

    public af(a aVar) {
        this.nPM = aVar;
        this.elE = new f();
        this.nPL = new HashMap();
        this.nPT = new b((byte) 0);
        this.nPT.elS = g.AT().getInt("SnsVideoPreloadSec", 5);
        this.nPT.elT = g.AT().getInt("SnsVideoDownloadSec", 1);
        this.nPT.nPV = g.AT().getInt("SnsVideoFullDownloadPercent", 101);
        x.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[]{Integer.valueOf(this.nPT.elS), Integer.valueOf(this.nPT.elT), Integer.valueOf(this.nPT.nPV)});
        reset();
    }

    public final void clear() {
        x.i("MicroMsg.OnlineVideoViewHelper", "clear");
        reset();
        this.nPM = null;
        this.elE = null;
    }

    private void reset() {
        this.elz = "";
        this.elG = -1;
        this.elJ = 0;
        this.elF = 0;
        this.nPO = 0;
        this.elD = 0;
        this.elC = 0;
        this.elI = false;
        this.elL = false;
        this.elM = false;
        this.nPL.clear();
        this.caK = null;
        this.dTR = 0;
        this.bKW = null;
        if (this.nPT != null) {
            this.elK = this.nPT.elS;
        }
        this.nPP = 0;
        this.dQj = 0;
        this.nPS = 0;
        this.nPR = 0;
        this.nPQ = 0;
    }

    public final boolean bCw() {
        if (!bi.oW(this.elz)) {
            x.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[]{this.elz, Boolean.valueOf(this.elC == 3), Integer.valueOf(this.nPN)});
            ar bym = com.tencent.mm.plugin.sns.model.af.bym();
            String str = this.elz;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.nPM.getPlayVideoDuration());
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
            objArr[5] = Integer.valueOf(this.nPM.getUiStayTime());
            objArr[6] = Integer.valueOf(this.nPM.getPlayErrorCode());
            if (!bi.oW(str)) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Em().H(new 5(bym, str, objArr));
            }
            if (this.nPN >= this.nPT.nPV && !r0) {
                com.tencent.mm.plugin.sns.model.af.bym().a(this.caK, this.dTR, this.bKW, false, false, 36);
            }
            h.mEJ.a(354, 203, 1, false);
        }
        return true;
    }

    public final boolean NS(String str) {
        return bi.fS(this.elz, str);
    }

    public final boolean iC(int i) {
        int i2;
        boolean z = false;
        if (this.elG != -1) {
            i2 = this.elG;
        } else {
            i2 = i;
        }
        x.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.elJ), Integer.valueOf(this.elF), Integer.valueOf(this.elD), Integer.valueOf(this.elC), this.elz, Long.valueOf(this.nPQ - this.dQj), Boolean.valueOf(this.elL)});
        switch (this.elC) {
            case 1:
                boolean z2;
                boolean z3;
                if (iD(i2)) {
                    bCy();
                    if (!this.elL) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[]{this.elz});
                        if (this.elD == 5) {
                            this.elD = 1;
                        }
                        this.nPM.aX(this.elA, true);
                        this.elL = true;
                        z2 = true;
                    } else if (this.elI) {
                        if (this.nPO == 0 && this.nPQ == 0) {
                            bCy();
                        } else if (this.nPR > 0) {
                            this.nPS = (int) (((long) this.nPS) + bi.bH(this.nPR));
                        }
                        x.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[]{Integer.valueOf(this.nPO), Integer.valueOf(this.nPS), this.elz});
                        this.elD = 3;
                        if (this.elG != -1) {
                            this.nPM.sG(this.elG);
                            this.elG = -1;
                            this.elI = false;
                            z2 = true;
                        } else {
                            this.elI = !this.nPM.bCr();
                            z2 = true;
                        }
                    } else {
                        if (this.elD != 3) {
                            x.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[]{Integer.valueOf(this.elD)});
                            this.elD = this.nPM.bCr() ? 3 : this.elD;
                        }
                        z2 = true;
                    }
                } else {
                    this.elI = true;
                    if (this.elJ > 0) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[]{this.elz, Integer.valueOf(this.nPO), Integer.valueOf(this.elD)});
                        this.nPR = bi.VF();
                        if (!(this.elD == 2 || this.elD == 4)) {
                            this.elK += this.nPT.elS;
                            this.elK = Math.min(this.elK, 60);
                            this.nPO++;
                            this.elD = 4;
                        }
                        this.nPM.SN();
                    } else if (this.elG == -1) {
                        this.elD = 1;
                    } else {
                        this.elD = 2;
                    }
                    z2 = false;
                }
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                pInt.value = Math.max(i2, this.elJ);
                if (this.elD == 1) {
                    pInt.value = i2;
                    pInt2.value = pInt.value + this.elK;
                }
                if (this.elD == 2) {
                    pInt.value = i2 - 8;
                    if (pInt.value < 0) {
                        pInt.value = 0;
                    }
                    pInt2.value = (pInt.value + this.elK) + 8;
                }
                if (this.elD == 3 || this.elD == 4) {
                    pInt.value = this.elJ;
                    pInt2.value = ((this.elK + i2) + 1) + this.nPT.elT;
                }
                if (pInt2.value >= this.elF + 1) {
                    pInt2.value = this.elF + 1;
                }
                if (pInt2.value < pInt.value) {
                    pInt2.value = pInt.value + this.nPT.elT;
                    z3 = false;
                } else {
                    x.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.elD), Integer.valueOf(this.elJ), Integer.valueOf(this.elK)});
                    z3 = true;
                }
                if (!z3) {
                    x.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
                    o.Tb();
                    com.tencent.mm.modelcdntran.f.g(this.elz, 0, -1);
                } else if (dB(pInt.value, pInt2.value)) {
                    this.elJ = Math.max(this.elJ, pInt2.value);
                    return true;
                }
                return z2;
            case 2:
                x.w("MicroMsg.OnlineVideoViewHelper", "download error.");
                return true;
            case 3:
                bCy();
                if (this.elL) {
                    if (this.elI) {
                        af afVar;
                        if (this.elG != -1) {
                            this.nPM.sG(this.elG);
                            this.elG = -1;
                            afVar = this;
                        } else if (this.nPM.bCr()) {
                            afVar = this;
                        } else {
                            z = true;
                            afVar = this;
                        }
                        afVar.elI = z;
                    }
                    this.elD = 3;
                    return true;
                }
                if (this.elD == 5) {
                    this.elD = 1;
                }
                this.nPM.aX(this.elA, false);
                this.elL = true;
                return true;
            default:
                x.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
                return true;
        }
    }

    private boolean iD(int i) {
        if (this.elC == 3) {
            return true;
        }
        if (this.elJ - i <= 1 && this.elJ < this.elF) {
            return false;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (!this.elE.a(i, i + 1, pInt, pInt2)) {
                return false;
            }
            boolean isVideoDataAvailable = o.Tb().isVideoDataAvailable(this.elz, pInt.value, pInt2.value);
            if (isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            this.elJ = i;
            return isVideoDataAvailable;
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
            return false;
        }
    }

    private boolean dB(int i, int i2) {
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.elE.a(i, i2, pInt, pInt2)) {
                pInt2.value += 81920;
                isVideoDataAvailable = o.Tb().isVideoDataAvailable(this.elz, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    x.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
                } else if (!this.nPL.containsKey(this.elz + 0 + "_-1")) {
                    String str = this.elz + pInt.value + "_" + pInt2.value;
                    x.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.elM), Boolean.valueOf(false)});
                    if (this.nPL.containsKey(str) || this.elM) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str);
                    } else {
                        this.elM = true;
                        o.Tb();
                        com.tencent.mm.modelcdntran.f.g(this.elz, pInt.value, pInt2.value);
                        this.nPL.put(str, Integer.valueOf(i2));
                    }
                }
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
            x.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
        } else if (!this.nPL.containsKey(this.elz + 0 + "_-1")) {
            String str2 = this.elz + pInt.value + "_" + pInt2.value;
            x.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.elM), Boolean.valueOf(false)});
            if (this.nPL.containsKey(str2) || this.elM) {
                x.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str2);
            } else {
                this.elM = true;
                o.Tb();
                com.tencent.mm.modelcdntran.f.g(this.elz, pInt.value, pInt2.value);
                this.nPL.put(str2, Integer.valueOf(i2));
            }
        }
        return isVideoDataAvailable;
    }

    final void bCx() {
        x.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[]{this.elz});
        bCy();
        ah.A(new 2(this));
    }

    final void bCy() {
        if (this.nPQ == 0) {
            this.nPQ = bi.VF();
        }
    }
}
