package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.k;
import com.tencent.mm.plugin.voip.model.l.2;
import com.tencent.mm.plugin.voip.model.l.3;
import com.tencent.mm.plugin.voip.model.l.b;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bqp;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.protocal.c.bzt;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.protocal.c.caa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;

public final class j {
    public static int oKn = 2;
    public boolean bXc;
    public Context gKE;
    ag mHandler;
    public int mStatus;
    public boolean oJA;
    public bqp oJB;
    public int oJC;
    public long oJD;
    public long oJE;
    public int oJF;
    public int oJG;
    public boolean oJH;
    public boolean oJI;
    public boolean oJJ;
    public int oJK;
    int oJL;
    private int oJM;
    int oJN;
    private int oJO;
    int oJP;
    public boolean oJQ;
    private boolean oJR;
    private int oJS;
    private boolean oJT;
    private int oJU;
    private int oJV;
    private int oJW;
    public v2protocal oJX;
    public u oJY;
    public l oJZ;
    public boolean oJt;
    public boolean oJu;
    public boolean oJv;
    public boolean oJw;
    public boolean oJx;
    public boolean oJy;
    public boolean oJz;
    public t oKa;
    public byte[] oKb;
    public caa oKc;
    public boolean oKd;
    public boolean oKe;
    public int oKf;
    public int oKg;
    public int oKh;
    public boolean oKi;
    public int oKj;
    public al oKk;
    private Timer oKl;
    private int oKm;
    private al oKo;
    private a oKp;

    protected j() {
        this.mStatus = 1;
        this.oJt = false;
        this.oJu = false;
        this.oJv = false;
        this.oJw = false;
        this.bXc = false;
        this.oJx = false;
        this.oJy = false;
        this.oJz = false;
        this.oJA = false;
        this.oJB = new bqp();
        this.oJC = 0;
        this.oJD = 0;
        this.oJE = 0;
        this.oJF = 0;
        this.oJG = 0;
        this.oJH = false;
        this.oJI = false;
        this.oJJ = false;
        this.oJK = 10;
        this.oJL = -1;
        this.oJM = -1;
        this.oJN = -1;
        this.oJO = -1;
        this.oJP = -1;
        this.oJQ = false;
        this.oJR = false;
        this.oJS = 1;
        this.oJT = false;
        this.oJU = 1;
        this.oJV = -1;
        this.oJW = -1;
        this.gKE = null;
        this.oJY = u.oNN;
        this.oKb = null;
        this.oKc = null;
        this.oKd = false;
        this.oKe = false;
        this.oKf = 0;
        this.oKg = 0;
        this.oKh = 0;
        this.oKi = false;
        this.oKj = 0;
        this.oKk = new al(Looper.getMainLooper(), new 1(this), true);
        this.mHandler = new 3(this, Looper.getMainLooper());
        this.oKl = null;
        this.oKm = 0;
        this.oKo = new al(Looper.getMainLooper(), new 6(this), false);
        this.oKp = null;
        this.oJX = new v2protocal(this.mHandler);
        this.oJZ = new l(this);
        this.oKa = new t(this);
        this.oKh = 0;
    }

    public final void reset() {
        x.i("MicroMsg.Voip.VoipContext", "reset");
        this.oJY.bKB();
        if (this.oJX.lkO) {
            this.oJX.iT(false);
        }
        this.oJX.reset();
        this.oJL = -1;
        this.oJM = -1;
        this.oJN = -1;
        this.oJO = -1;
        this.oJP = -1;
        this.oJZ.bKe();
        this.oJX.oOD = 0;
        this.oKo.SO();
        this.oKa.bLl();
        this.oKk.SO();
        this.oJt = false;
        this.oJv = false;
        this.oJu = false;
        this.oJw = false;
        this.bXc = false;
        this.oJx = false;
        this.oKb = null;
        this.oKc = null;
        this.oJH = false;
        this.oJI = false;
        this.oJJ = false;
        this.oJQ = false;
        this.oJR = false;
        this.oJT = false;
        this.oJS = 1;
        this.oJU = 1;
        this.oKd = false;
        this.oJV = -1;
        this.oJW = -1;
        this.oJy = false;
        this.oJz = false;
        this.oJx = false;
        this.oJt = false;
        this.oJA = false;
        this.oJK = 10;
        this.mStatus = 1;
        this.oKh = 0;
        this.oKj = 0;
        this.oKi = false;
    }

    public final void bJK() {
        int i = 0;
        if (this.oJt && this.oJC == 0) {
            this.oJC = 1;
            if (this.oJX.field_speedTestInfoLength < 8) {
                a.eT("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.oJX.field_speedTestInfoLength);
                return;
            }
            int i2 = this.oJX.oPQ[1];
            if (i2 + 2 > this.oJX.field_speedTestInfoLength) {
                a.eT("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", bufsize=" + this.oJX.field_speedTestInfoLength);
                return;
            }
            int i3 = this.oJX.oPQ[(i2 + 2) + 1];
            if ((i2 + 6) + i3 != this.oJX.field_speedTestInfoLength) {
                a.eT("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", C2SRttCnt=" + i3 + ", bufsize=" + this.oJX.field_speedTestInfoLength);
                return;
            }
            int i4;
            this.oJD = this.oJX.kpp;
            this.oJF = this.oJX.netType;
            this.oJG = this.oJX.kpo;
            this.oJB.rxG = this.oJX.kpo;
            this.oJB.soz = this.oJX.oOw;
            this.oJB.rth = this.oJX.netType;
            this.oJB.soA = this.oJt ? 1 : 0;
            bqp bqp = this.oJB;
            if (this.oJv) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            bqp.soB = i2;
            this.oJB.soC = this.oJX.oPQ[0];
            i3 = 2;
            this.oJB.soD = this.oJX.oPQ[1];
            i2 = 0;
            while (true) {
                i4 = i3;
                if (i2 >= this.oJB.soD) {
                    break;
                }
                i3 = i4 + 1;
                this.oJB.soE.add(Integer.valueOf(this.oJX.oPQ[i4]));
                i2++;
            }
            int i5 = i4 + 1;
            this.oJB.soF = this.oJX.oPQ[i4];
            i2 = i5 + 1;
            this.oJB.soG = this.oJX.oPQ[i5];
            while (i < this.oJB.soG) {
                i4 = i2 + 1;
                this.oJB.soH.add(Integer.valueOf(this.oJX.oPQ[i2]));
                i++;
                i2 = i4;
            }
            i3 = i2 + 1;
            this.oJB.soI = this.oJX.oPQ[i2];
            this.oJB.soJ = this.oJX.oPQ[i3];
            new k(this.oJB).bLp();
            return;
        }
        a.eT("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.oJt + " ,mSpeedTestStatus=" + this.oJC);
    }

    public final void bJL() {
        if (this.oJC != 0) {
            if (this.oJC == 1) {
                this.oJC = 0;
                this.oJX.oPy = 0;
                return;
            }
            this.oJC = 0;
            v2protocal v2protocal = this.oJX;
            a.eU("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
            v2protocal.StopSpeedTest();
            v2protocal.oPy = 0;
        }
    }

    public final void yu(int i) {
        this.oJX.oOy = Math.abs(i);
    }

    public final void bJM() {
        this.oJX.oOz = this.oJZ.bKd();
        this.oJX.oOA = this.oJZ.bJw();
    }

    public final void yv(int i) {
        this.oJX.oOB = i;
    }

    public final void shutdown() {
        bKb();
        this.mHandler.post(new 2(this));
    }

    public final void setStatus(int i) {
        if (i != this.mStatus) {
            if (i == 4) {
                this.oKo.J(60000, 60000);
            }
            this.mStatus = i;
        }
    }

    public final int bJN() {
        if (this.mStatus == 1) {
            return 0;
        }
        if (this.mStatus == 2 || this.mStatus == 3) {
            return 1;
        }
        if (this.mStatus != 4) {
            return 3;
        }
        return 2;
    }

    public final boolean bJO() {
        if (this.mStatus == 3) {
            return true;
        }
        return false;
    }

    public final boolean bJP() {
        x.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[]{Integer.valueOf(this.mStatus)});
        if (this.mStatus == 1) {
            return false;
        }
        return true;
    }

    public final void yw(int i) {
        if (8 == i || 9 == i) {
            this.oJO = i;
        } else {
            this.oJL = i;
            this.oJM = i;
        }
        t tVar = this.oKa;
        byte[] yO = a.yO(i);
        bhy bhy = new bhy();
        bhy.bq(yO);
        bhy bhy2 = new bhy();
        try {
            bhy2.bq(bhy.toByteArray());
            bzt bzt = new bzt();
            bzt.rtM = 3;
            bzt.rtN = bhy2;
            bzt.jTv = q.GF();
            bzu bzu = new bzu();
            bzu.hbF = 1;
            bzu.hbG.add(bzt);
            tVar.a(bzu, false, 4);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
        }
    }

    public final boolean bJQ() {
        if (this.oJJ) {
            return false;
        }
        switch (this.oJL) {
            case -1:
                return true;
            case 0:
                if (4 != this.oJM) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.oJM || -1 == this.oJM)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.oJM || 6 == this.oJM || 7 == this.oJM) {
                    return false;
                }
        }
        return true;
    }

    public final boolean bJR() {
        if (this.oJJ) {
            return false;
        }
        switch (this.oJL) {
            case -1:
                return true;
            case 0:
                if (4 != this.oJM) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.oJN || this.oJN == 0 || -1 == this.oJN)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.oJN || 6 == this.oJN || 7 == this.oJN) {
                    return false;
                }
        }
        return true;
    }

    private void bJS() {
        a.eV("MicroMsg.Voip.VoipContext", "DeviceInfo.mAudioInfo.aecMode:" + com.tencent.mm.compatible.e.q.deN.dci);
        if (com.tencent.mm.compatible.e.q.deN.dbK == 1) {
            this.oJX.tf(JsApiBatchGetContact.CTRL_INDEX);
        }
        byte[] bArr = new byte[2];
        if (com.tencent.mm.compatible.e.q.deN.dci >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dci;
            this.oJX.setAppCmd(406, bArr, 1);
        } else if (com.tencent.mm.compatible.e.q.deN.dci == -2) {
            this.oJX.tf(407);
        }
        if (com.tencent.mm.compatible.e.q.deN.dcj >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dcj;
            this.oJX.setAppCmd(408, bArr, 1);
        } else if (com.tencent.mm.compatible.e.q.deN.dcj == -2) {
            this.oJX.tf(409);
        }
        if (com.tencent.mm.compatible.e.q.deN.dcl >= 0) {
            byte[] bArr2 = new byte[5];
            if (com.tencent.mm.compatible.e.q.deN.dcm >= 0 && com.tencent.mm.compatible.e.q.deN.dcn >= 0) {
                bArr2[0] = (byte) com.tencent.mm.compatible.e.q.deN.dcm;
                bArr2[1] = (byte) com.tencent.mm.compatible.e.q.deN.dcn;
                if (com.tencent.mm.compatible.e.q.deN.dco >= 0) {
                    bArr2[2] = (byte) com.tencent.mm.compatible.e.q.deN.dco;
                    bArr2[3] = (byte) com.tencent.mm.compatible.e.q.deN.dcl;
                    bArr2[4] = (byte) com.tencent.mm.compatible.e.q.deN.dcp;
                    this.oJX.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr2, 5);
                } else {
                    this.oJX.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr2, 2);
                }
            }
        } else if (com.tencent.mm.compatible.e.q.deN.dcl == -2) {
            this.oJX.tf(405);
        }
        if (com.tencent.mm.compatible.e.q.deN.dbL >= 0 || com.tencent.mm.compatible.e.q.deN.dbN >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (com.tencent.mm.compatible.e.q.deN.dbL >= 0) {
                bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dbL;
            }
            if (com.tencent.mm.compatible.e.q.deN.dbN >= 0) {
                bArr[1] = (byte) com.tencent.mm.compatible.e.q.deN.dbN;
            }
            this.oJX.setAppCmd(414, bArr, 2);
        }
        if (com.tencent.mm.compatible.e.q.deN.dbM >= 0 || com.tencent.mm.compatible.e.q.deN.dbO >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (com.tencent.mm.compatible.e.q.deN.dbM >= 0) {
                bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dbM;
            }
            if (com.tencent.mm.compatible.e.q.deN.dbO >= 0) {
                bArr[1] = (byte) com.tencent.mm.compatible.e.q.deN.dbO;
            }
            this.oJX.setAppCmd(415, bArr, 2);
        }
        if (com.tencent.mm.compatible.e.q.deN.dbP >= 0 || com.tencent.mm.compatible.e.q.deN.dbQ >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (com.tencent.mm.compatible.e.q.deN.dbP >= 0) {
                bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dbP;
            }
            if (com.tencent.mm.compatible.e.q.deN.dbQ >= 0) {
                bArr[1] = (byte) com.tencent.mm.compatible.e.q.deN.dbQ;
            }
            this.oJX.setAppCmd(422, bArr, 2);
        }
        if (com.tencent.mm.compatible.e.q.deN.dbR >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dbR;
            this.oJX.setAppCmd(416, bArr, 1);
        }
        if (com.tencent.mm.compatible.e.q.deN.dbV >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dbV;
            this.oJX.setAppCmd(431, bArr, 4);
        }
        if (com.tencent.mm.compatible.e.q.deN.dbS >= 0 && !(this.oJX.oOX == 0 && com.tencent.mm.compatible.e.q.deN.dbS == 5)) {
            bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dbS;
            this.oJX.setAppCmd(417, bArr, 1);
        }
        if (com.tencent.mm.compatible.e.q.deN.dbT >= 0 && !(this.oJX.oOX == 0 && com.tencent.mm.compatible.e.q.deN.dbT == 5)) {
            bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dbT;
            this.oJX.setAppCmd(418, bArr, 1);
        }
        if (com.tencent.mm.compatible.e.q.deN.dbU >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dbU;
            this.oJX.setAppCmd(419, bArr, 1);
        }
        if (this.oJX.oOX == 1 && (com.tencent.mm.compatible.e.q.deN.dbS == 5 || com.tencent.mm.compatible.e.q.deN.dbT == 5)) {
            this.oJX.oOJ = 5;
        }
        if (1 == com.tencent.mm.compatible.e.q.deN.dcs) {
            byte[] bArr3 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr3[i * 2] = (byte) (com.tencent.mm.compatible.e.q.deN.dct[i] & 255);
                bArr3[(i * 2) + 1] = (byte) ((com.tencent.mm.compatible.e.q.deN.dct[i] >> 8) & 255);
            }
            this.oJX.setAppCmd(420, bArr3, 30);
        }
        if (com.tencent.mm.compatible.e.q.deN.dcs == 0) {
            this.oJX.tf(421);
        }
        if (com.tencent.mm.compatible.e.q.deN.dcu[0] > (short) 0 || com.tencent.mm.compatible.e.q.deN.dcu[1] > (short) 0) {
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            if (com.tencent.mm.compatible.e.q.deN.dcu[0] > (short) 0 && com.tencent.mm.compatible.e.q.deN.dcu[0] < (short) 10000) {
                bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dcu[0];
            }
            if (com.tencent.mm.compatible.e.q.deN.dcu[1] > (short) 0 && com.tencent.mm.compatible.e.q.deN.dcu[1] < (short) 10000) {
                bArr[1] = (byte) com.tencent.mm.compatible.e.q.deN.dcu[1];
            }
            this.oJX.setAppCmd(423, bArr, 2);
        }
        if (com.tencent.mm.compatible.e.q.deN.dcw > 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.e.q.deN.dcw;
            this.oJX.setAppCmd(424, bArr, 1);
        }
        if (com.tencent.mm.compatible.e.q.deN.dcE >= 0) {
            this.oJX.setAppCmd(426, new byte[]{(byte) com.tencent.mm.compatible.e.q.deN.dcE, (byte) com.tencent.mm.compatible.e.q.deN.dcF, (byte) com.tencent.mm.compatible.e.q.deN.dcG, (byte) com.tencent.mm.compatible.e.q.deN.dcH}, 4);
        }
    }

    public final void bJT() {
        a.eU("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
        if (this.oJx && this.oJv) {
            a.eU("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
            this.oJX.setActive();
            if (this.oJA) {
                a.eU("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.oJA);
                return;
            }
            int i;
            Object obj;
            if (this.oJX.startEngine() == 0) {
                this.oJX.oPS.oLq = 0;
            } else {
                this.oJA = false;
                this.oJX.oPS.oLq = 1;
            }
            bJS();
            if (!bJQ() && !bJR()) {
                bJX();
            } else if (this.oKl != null) {
                bJX();
            } else {
                this.oKl = new Timer();
                this.oKm = 0;
                this.oKl.schedule(new 5(this), 200, 200);
            }
            this.oJY.bKC();
            l lVar = this.oJZ;
            if (lVar.oKv == 2) {
                a.eT("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
            } else {
                a.eU("MicroMsg.Voip.VoipDeviceHandler", "start device......");
                lVar.oKv = 2;
                lVar.oKI = false;
                lVar.oKJ = 0;
                if (lVar.oKM != null) {
                    a.eV("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    lVar.oKM.oKP = true;
                    e.remove(lVar.oKM);
                    lVar.oKM = null;
                }
                lVar.oKM = new b(lVar);
                e.post(lVar.oKM, "VoipDeviceHandler_decode");
                a.eV("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
                com.tencent.mm.compatible.e.q.deN.dump();
                lVar.oKt = new b();
                lVar.oKt.X(v2protocal.lsT, 20, 0);
                lVar.oKw = lVar.oKt.r(lVar.oHa.gKE, true);
                byte[] bArr = new byte[1];
                bArr[0] = (byte) (lVar.oKt.oGZ ? 1 : 0);
                lVar.oHa.oJX.setAppCmd(502, bArr, 1);
                if (lVar.oKw <= 10) {
                    if (lVar.oKw <= 0) {
                        lVar.oKG = 1;
                    }
                    lVar.oKw = 92;
                }
                lVar.oKt.oHi = new 2(lVar);
                if (lVar.oKt.bJt() <= 0) {
                    lVar.oKG = 1;
                }
                e.b(new 3(lVar), "voip_start_record", 10);
            }
            m mVar = this.oJX.oPS;
            if (mVar.beginTime == 0) {
                mVar.oLj = 0;
            } else {
                mVar.oLj = (int) (System.currentTimeMillis() - mVar.beginTime);
            }
            a.eU("MicroMsg.VoipDailReport", "devin:beginTime:" + mVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            a.eU("MicroMsg.VoipDailReport", "devin:endNewDial:" + mVar.oLj);
            this.oJY.onConnected();
            this.mStatus = 5;
            mVar = this.oJX.oPS;
            mVar.oLr = System.currentTimeMillis();
            a.eU("MicroMsg.VoipDailReport", "devin:beginTalk:" + mVar.oLr);
            this.oJX.setSvrConfig(CdnLogic.kAppTypeYunStorage, this.oJX.oOP, this.oJX.oOQ, 0, 0, 0, 0);
            this.oJX.setSvrConfig(203, 0, 0, this.oJX.oOU, 0, 0, 0);
            this.oJX.setSvrConfig(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, 0, 0, this.oJX.oOY, 0, 0, 0);
            this.oJX.setSvrConfig(103, this.oJX.oOR, this.oJX.oOS, this.oJX.oOT, this.oJX.oOW, 0, 0);
            this.oJX.setSvrConfig(205, 0, 0, this.oJX.oPm, 0, 0, 0);
            this.oJX.setSvrConfig(207, 0, 0, this.oJX.oOu, 0, 0, 0);
            a.eU("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.oJX.oPm + " SwitchFlag = " + this.oJX.oOu);
            int i2 = (this.oJX.oOZ >> 2) & 3;
            int i3 = this.oJX.oOZ & 3;
            if (this.oJX.kpw == 0) {
                i = (i2 << 2) + i3;
            } else {
                i = (i3 << 2) + i2;
            }
            this.oJX.setSvrConfig(502, 0, 0, i, 0, 0, 0);
            this.oJX.setSvrConfig(503, 0, 0, this.oJX.oPa, this.oJX.oPb, this.oJX.oPc, this.oJX.oPd);
            if (!(this.oJX.oPr == null || this.oJX.oPs == null)) {
                this.oJX.setSvrConfig(504, 0, 0, this.oJX.oPq, 0, 0, 0);
                this.oJX.setSvrConfig(505, 0, 0, this.oJX.oPr[0], this.oJX.oPr[1], this.oJX.oPr[2], this.oJX.oPr[3]);
                this.oJX.setSvrConfig(506, 0, 0, this.oJX.oPs[0], this.oJX.oPs[1], 0, 0);
                a.eU("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.oJX.oPq + ",FECKeyPara1 = " + this.oJX.oPr[0] + "," + this.oJX.oPr[1] + "," + this.oJX.oPr[2] + "," + this.oJX.oPr[3] + ",FECKeyPara2 = " + this.oJX.oPs[0] + "," + this.oJX.oPs[1]);
            }
            this.oJX.setSvrConfig(507, 0, 0, (this.oJX.oPe & 4) >> 2, (this.oJX.oPe & 2) >> 1, this.oJX.oPe & 1, 0);
            this.oJX.setjbmbitraterssvrparam();
            a.eU("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.oJX.oOP + ",audioTsdEdge = " + this.oJX.oOQ + ",passthroughQosAlgorithm = " + this.oJX.oOR + ",fastPlayRepair = " + this.oJX.oOS + ", audioDTX = " + this.oJX.oOU + ", mARQFlag = " + i + ", mQosStrategy = " + this.oJX.oPe + ", mSvrCfgListV = " + this.oJX.oOT + ", maxBRForRelay = " + this.oJX.oOW);
            byte[] bArr2 = new byte[]{(byte) com.tencent.mm.compatible.e.q.deM.ddk, (byte) -1};
            a.eV("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
            a.eV("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + bArr2[0]);
            this.oJX.setAppCmd(15, bArr2, 1);
            a.eV("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + d.qVN);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(d.qVN);
            this.oJX.setAppCmd(505, allocate.array(), 4);
            bArr2 = new byte[4];
            this.oJX.setAppCmd(26, bArr2, 4);
            allocate = ByteBuffer.wrap(bArr2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            int i4 = allocate.getInt();
            a.eV("MicroMsg.Voip.VoipContext", "steve: iHW: " + i4);
            if (((this.oJX.oOT & 4) != 0 ? 1 : null) == null && this.oJX.oPX) {
                a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
                obj = (i4 & 4) != 0 ? 1 : null;
                Object obj2 = (i4 & 8) != 0 ? 1 : null;
                if (!(obj == null && obj2 == null)) {
                    this.oJZ.oKI = true;
                    bJU();
                }
                this.oJX.oPX = false;
            }
            if (this.oJX.oPX) {
                v2protocal v2protocal = this.oJX;
                int i5 = com.tencent.mm.compatible.e.q.deM.ddm;
                boolean z = false;
                Object obj3 = (i4 & 4) != 0 ? 1 : null;
                obj = (i4 & 8) != 0 ? 1 : null;
                if (!(obj3 == null && obj == null)) {
                    String str = obj3 != null ? "video/hevc" : "video/avc";
                    v2protocal.oPT = new d(v2protocal.width, v2protocal.height, v2protocal.oPV, v2protocal.bitrate, i5, str);
                    a.eU("MicroMsg.Voip", "steve : create HW encoder successfully:" + str);
                    if (v2protocal.oPW != null) {
                        v2protocal.oPU = new c(v2protocal.oPW);
                        a.eU("MicroMsg.Voip", "steve : create HW decoder successfully!");
                    }
                    z = true;
                    if (v2protocal.oPT == null || v2protocal.oPU == null) {
                        v2protocal.oPX = false;
                        z = false;
                    }
                }
                a.eU("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + z + ", iHW:" + i4);
                if (!this.oJX.oPX) {
                    a.eU("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                    this.oJZ.oKI = true;
                    bJU();
                }
            }
            if (this.oJX.oPT != null) {
                this.oJX.oPT.oHa = this;
            }
            if (v2protocal.oPU != null) {
                v2protocal.oPU.a(this);
            }
            this.oJA = true;
            this.oKi = false;
            return;
        }
        a.eU("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.oJx + ", isChannelConnectedSuccess " + this.oJv);
    }

    public final void bJU() {
        yx(2);
        if (this.oJX != null) {
            a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
            int i = oKn;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i);
            this.oJX.setAppCmd(27, allocate.array(), 4);
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            allocate2.putInt(6);
            a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
            this.oJX.setAppCmd(30, allocate2.array(), 4);
        }
    }

    public final boolean bJV() {
        boolean bJQ = bJQ();
        int i = 0;
        if (bJQ) {
            i = 1;
        }
        if (this.oJV == -1 || this.oJV != i) {
            this.oJV = i;
            if (bJQ) {
                a.eV("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
                this.oJX.tf(203);
            } else {
                a.eV("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
                this.oJX.tf(CdnLogic.kAppTypeYunStorage);
            }
        }
        return bJQ;
    }

    public final boolean bJW() {
        boolean bJR = bJR();
        int i = 0;
        if (bJR) {
            i = 1;
        }
        if (this.oJW == -1 || this.oJW != i) {
            this.oJW = i;
            if (bJR) {
                a.eV("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
                this.oJX.tf(CdnLogic.kAppTypeNearEvent);
            } else {
                a.eV("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
                this.oJX.tf(200);
            }
        }
        return bJR;
    }

    private void bJX() {
        if (this.mStatus == 5) {
            setStatus(6);
            m mVar = this.oJX.oPS;
            if (mVar.beginTime == 0) {
                mVar.oKT = 0;
            } else {
                mVar.oKT = (int) (System.currentTimeMillis() - mVar.beginTime);
            }
            a.eU("MicroMsg.VoipDailReport", "devin:beginTime:" + mVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            a.eU("MicroMsg.VoipDailReport", "devin:endDial:" + mVar.oKT);
            a.eU("MicroMsg.Voip.VoipContext", "talking  now .......!");
            this.mHandler.post(new 4(this));
        }
    }

    public final void yx(int i) {
        try {
            bxi bxi = new bxi();
            bxi.stM = i;
            if (1 == i) {
                a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                allocate.putInt(6);
                bxi.stN = new com.tencent.mm.bk.b(allocate.array());
                this.oJX.setAppCmd(32, allocate.array(), 4);
            } else {
                bxi.stN = null;
            }
            this.oJX.SendRUDP(bxi.toByteArray(), bxi.toByteArray().length);
            a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:" + i);
        } catch (Exception e) {
            a.eU("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
        }
    }

    private void bJY() {
        if (this.mStatus != 2 && this.mStatus != 3 && this.mStatus != 4) {
            a.eU("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
        } else if (this.oJt) {
            a.eU("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
        } else {
            int i;
            a.eU("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int i2 = ((((this.oJX.oOZ >> 2) & 3) >> 1) & 1) & (((this.oJX.oOZ & 3) >> 1) & 1);
            v2protocal v2protocal = this.oJX;
            int i3 = this.oJX.oOk;
            long j = (long) this.oJX.kpo;
            int i4 = this.oJX.kpw;
            long j2 = this.oJX.kpp;
            byte[] bArr = this.oJX.oOm;
            int i5 = this.oJX.channelStrategy;
            int i6 = this.oJX.oOr;
            int i7 = this.oJX.oOs;
            int i8 = this.oJX.oOp;
            if (this.oJX.oOq == null) {
                i = 0;
            } else {
                i = this.oJX.oOq.length;
            }
            int configInfo = v2protocal.setConfigInfo(i3, j, i4, j2, bArr, i5, i6, i7, i8, i, this.oJX.oOq, this.oJX.oOt, i2, this.oJX.oOj, this.oJX.oPj, this.oJX.oPk, this.oJX.oPl, this.oJX.oOu);
            if (configInfo == 0) {
                configInfo = this.oJX.connectToPeerRelay();
            }
            a.eU("MicroMsg.Voip.VoipContext", "zhengxue[Logic], mARQFlag: " + i2 + ",  NetType: " + this.oJX.oOj + ", EncryptStrategy: " + this.oJX.oPj);
            if (configInfo < 0) {
                a.eT("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:" + configInfo);
                this.oJX.oPS.oKQ = 14;
                o(1, -9002, "");
                return;
            }
            this.oJt = true;
            this.oJX.oPS.oKX = (byte) 1;
            this.oJX.oPS.oLf = 1;
        }
    }

    public final void bJZ() {
        boolean z = !bi.bC(this.oJX.oOm);
        a.eU("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + z + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.oJz + ",isRemoteAccepted:" + this.oJw + ",isLocalAccept:" + this.bXc);
        this.oJX.oPS.oLc = 7;
        if (!z) {
            return;
        }
        if (this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6 && ((this.mStatus != 2 || !this.oJz) && (this.mStatus != 3 || !this.oJz))) {
            return;
        }
        if (this.mStatus != 2 && this.mStatus != 3 && this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6) {
            a.eU("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
        } else if (this.oJw || this.bXc) {
            if (!this.oJt) {
                bJY();
            }
            if (this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6) {
                a.eU("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + this.mStatus);
            } else if (this.oJu) {
                a.eU("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
            } else {
                this.oJu = true;
                a.eU("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
                int connectToPeerDirect = this.oJX.connectToPeerDirect();
                if (connectToPeerDirect < 0) {
                    a.eT("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:" + connectToPeerDirect);
                    this.oJX.oPS.oKQ = 14;
                    o(1, -9002, "");
                    return;
                }
                bKa();
            }
        } else if (this.oJz && !this.oJt) {
            bJY();
        }
    }

    public final void bKa() {
        if (this.oJu && !bi.bC(this.oJX.oOo)) {
            int handleCommand = this.oJX.handleCommand(this.oJX.oOo, this.oJX.oOo.length);
            if (handleCommand < 0) {
                a.eT("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:" + handleCommand);
            }
            this.oJX.oOo = null;
        }
    }

    public final void aQ(byte[] bArr) {
        x.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
        this.oJX.oPS.oKV = (byte) 1;
        this.oJX.oPS.oKU = (byte) 1;
        this.oJX.oOm = bArr;
    }

    public final void b(int i, byte[] bArr, byte[] bArr2) {
        this.oJX.oPq = i;
        this.oJX.oPr = bArr;
        this.oJX.oPs = bArr2;
    }

    public final void a(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.oJX.oOp = i;
        this.oJX.oOq = bArr;
        this.oJX.oPj = i2;
        this.oJX.oPk = bArr2;
    }

    public final void yy(int i) {
        this.oJX.oPl = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.protocal.c.byy r5, com.tencent.mm.protocal.c.byy r6, com.tencent.mm.protocal.c.byy r7) {
        /*
        r4 = this;
        r3 = 0;
        r0 = android.net.Proxy.getDefaultHost();
        r1 = android.net.Proxy.getDefaultPort();
        if (r0 == 0) goto L_0x0070;
    L_0x000b:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0070;
    L_0x0011:
        if (r1 <= 0) goto L_0x0070;
    L_0x0013:
        r2 = new com.tencent.mm.protocal.c.cah;
        r2.<init>();
        r3 = 1;
        r2.swD = r3;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r2.swE = r1;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r1 = 0;
        r2.swF = r1;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r1 = "";
        r2.userName = r1;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r1 = "";
        r2.eSH = r1;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r0 = java.net.InetAddress.getByName(r0);	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r0 = r0.getHostAddress();	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r0 = com.tencent.mm.plugin.voip.b.a.Fw(r0);	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r2.swE = r0;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r0 = r4.oJX;
        r0 = r0.a(r5, r6, r7, r2);
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = "MicroMsg.Voip.VoipContext";
        r1 = "setIp fail!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x0049:
        return;
    L_0x004a:
        r0 = move-exception;
        r0 = r4.oJX;
        r0 = r0.a(r5, r6, r7, r2);
        if (r0 == 0) goto L_0x0049;
    L_0x0053:
        r0 = "MicroMsg.Voip.VoipContext";
        r1 = "setIp fail!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0049;
    L_0x005d:
        r0 = move-exception;
        r1 = r4.oJX;
        r1 = r1.a(r5, r6, r7, r2);
        if (r1 == 0) goto L_0x006f;
    L_0x0066:
        r1 = "MicroMsg.Voip.VoipContext";
        r2 = "setIp fail!";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
    L_0x006f:
        throw r0;
    L_0x0070:
        r0 = new com.tencent.mm.protocal.c.cah;
        r0.<init>();
        r0.swD = r3;
        r0.swE = r3;
        r0.swF = r3;
        r1 = "";
        r0.userName = r1;
        r1 = "";
        r0.eSH = r1;
        r1 = r4.oJX;
        r0 = r1.a(r5, r6, r7, r0);
        if (r0 == 0) goto L_0x0049;
    L_0x008d:
        r0 = "MicroMsg.Voip.VoipContext";
        r1 = "setIp fail!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.model.j.a(com.tencent.mm.protocal.c.byy, com.tencent.mm.protocal.c.byy, com.tencent.mm.protocal.c.byy):void");
    }

    public final void h(int i, int i2, int i3, int i4, int i5) {
        this.oJX.oOZ = i;
        this.oJX.oPa = i2;
        this.oJX.oPb = i3;
        this.oJX.oPc = i4;
        this.oJX.oPd = i5;
    }

    public final void yz(int i) {
        this.oJX.oPe = i;
    }

    public final void aR(byte[] bArr) {
        x.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[]{Byte.valueOf(this.oJX.oPS.oKZ)});
        if (this.oJX.oPS.oKZ != (byte) 1 && bArr != null) {
            this.oJX.oPS.oKZ = (byte) 1;
            this.oJX.oOn = bArr;
            int exchangeCabInfo = this.oJX.exchangeCabInfo(this.oJX.oOn, this.oJX.oOn.length);
            if (exchangeCabInfo < 0) {
                a.eT("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:" + exchangeCabInfo);
                this.oJX.oPS.oKQ = 15;
                o(1, -9003, "");
            }
        }
    }

    public final void yA(int i) {
        this.oJX.oPS.oKW = (byte) 1;
        this.oJX.channelStrategy = i;
    }

    public final void yB(int i) {
        this.oJX.oOt = i;
    }

    public final void bKb() {
        x.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
        this.oKk.SO();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.oKp = aVar;
        }
    }

    public final void o(int i, int i2, String str) {
        bKb();
        if (this.oKp != null) {
            this.oKp.o(i, i2, str);
        }
    }
}
