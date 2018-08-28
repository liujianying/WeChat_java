package com.tencent.mm.plugin.voip.model;

import android.os.Bundle;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class l {
    public static int oKK = 0;
    public static int oKL = 0;
    public static int oKu = 3;
    private a kqr = new 1(this);
    volatile c ltc = null;
    public j oHa = null;
    private int oKA = 0;
    private int oKB = 1;
    private long oKC = 0;
    private int oKD = 0;
    private int oKE = 0;
    final Object oKF = new Object();
    public int oKG = 0;
    public boolean oKH = false;
    public boolean oKI = false;
    public int oKJ = 0;
    b oKM;
    b oKt = null;
    public int oKv = 1;
    int oKw = 92;
    private long oKx = 0;
    private long oKy = 0;
    private int oKz = 1;

    static /* synthetic */ void k(l lVar) {
        synchronized (lVar.oKF) {
            lVar.ltc = new c(v2protocal.lsT, 1, 1);
            lVar.ltc.ey(20);
            lVar.ltc.aN(true);
            lVar.ltc.wm();
            lVar.ltc.bDQ = -19;
            lVar.ltc.t(1, false);
            lVar.ltc.aM(true);
            lVar.ltc.bEb = lVar.kqr;
            if (!(lVar.ltc.wn() || lVar.ltc.bDF == 13)) {
                lVar.oKG = 1;
            }
        }
        com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.m_iAudioDevErr:" + lVar.oKG);
        lVar.oHa.yu(lVar.oKG);
        lVar.oHa.oJX.oPS.oLa = (byte) 1;
    }

    public l(j jVar) {
        this.oHa = jVar;
    }

    public final int bKd() {
        if (this.ltc == null || this.oHa.oJX.oPS.oLa != (byte) 1) {
            return 0;
        }
        return this.ltc.bDF;
    }

    public final int bJw() {
        if (this.oKt == null || this.oHa.oJX.oPS.oLa != (byte) 1) {
            return 0;
        }
        return this.oKt.bJw();
    }

    public final synchronized void bKe() {
        int i = 0;
        synchronized (this) {
            x.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[]{this.ltc});
            if (this.oKv == oKu) {
                com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
                synchronized (this.oKF) {
                    if (this.ltc != null) {
                        x.e("MicroMsg.Voip.VoipDeviceHandler", "status DEV_STOP, but recorder still not null!!");
                        this.ltc.we();
                        this.ltc = null;
                    }
                }
            } else {
                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
                this.oKv = oKu;
                if (this.oKM != null) {
                    com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    this.oKM.oKP = true;
                    e.remove(this.oKM);
                    this.oKM = null;
                }
                this.oKB = 1;
                this.oKD = 0;
                this.oKw = 92;
                this.oKx = 0;
                this.oKy = 0;
                this.oKz = 1;
                this.oKA = 0;
                this.oKG = 0;
                this.oHa.oJX.oOz = bKd();
                this.oHa.oJX.oOA = bJw();
                v2protocal v2protocal = this.oHa.oJX;
                int wp = (this.ltc == null || this.oHa.oJX.oPS.oLa != (byte) 1) ? -2 : this.ltc.wp();
                v2protocal.oOD = wp;
                v2protocal v2protocal2 = this.oHa.oJX;
                if (this.oKt != null && this.oHa.oJX.oPS.oLa == (byte) 1) {
                    i = this.oKt.bJx();
                }
                v2protocal2.oOK = (int) ((((float) au.HV().getStreamVolume(i)) / ((float) au.HV().getStreamMaxVolume(i))) * 100.0f);
                synchronized (this.oKF) {
                    if (!(this.oKt == null || this.ltc == null)) {
                        e.b(new a(this, this.oKt, this.ltc), "VoipDeviceHandler_stopDev", 10);
                        x.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                        this.oKt = null;
                        this.ltc = null;
                    }
                }
            }
        }
    }

    public final int b(byte[] bArr, int i, int i2, int i3, int i4) {
        if (this.oKv != 2) {
            return 0;
        }
        if (!this.oHa.bJV()) {
            return 0;
        }
        v2protocal v2protocal = this.oHa.oJX;
        v2protocal.oPA++;
        if (this.oKI) {
            x.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
            this.oHa.oJX.oPX = false;
            this.oKH = false;
            this.oKI = false;
            this.oHa.yx(1);
        }
        if (!this.oHa.oJX.oPX || this.oHa.oJX.oPT == null) {
            this.oKH = false;
        } else {
            d dVar = this.oHa.oJX.oPT;
            if (!(dVar.oHa == null || dVar.oHa.oJX == null)) {
                if (dVar.oHa.oJX.setAppCmd(d.oIN, dVar.oII.oJb, dVar.oII.oJb.length) >= 0) {
                    d.a aVar = dVar.oII;
                    ByteBuffer wrap = ByteBuffer.wrap(aVar.oJb);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    aVar.oIO = wrap.getShort();
                    aVar.oIP = wrap.get();
                    aVar.oIQ = wrap.get();
                    aVar.oIR = wrap.get();
                    aVar.oIS = wrap.get();
                    aVar.oIT = wrap.get();
                    aVar.oIU = wrap.get();
                    aVar.oIV = wrap.get();
                    aVar.oIW = wrap.get();
                    aVar.oIX = wrap.get();
                    aVar.oIY = wrap.get();
                    aVar.oIZ = wrap.get();
                    aVar.oJa = wrap.get();
                    aVar = dVar.oII;
                    x.d("MeidaCodec[HWEnc]", "raw S2P:" + aVar.oJb);
                    x.d("MeidaCodec[HWEnc]", "-S2P- iKbps:" + aVar.oIO + ", fps:" + aVar.oIP + ", IP:" + aVar.oIQ + ", RS:" + aVar.oIR + ", QPMin:" + aVar.oIS + ", QPMax:" + aVar.oIT + ", HPP:" + aVar.oIU + ", SWitch:" + aVar.oIV + ", Reso:" + aVar.oIW + ", Rsvd1:" + aVar.oIX + ", Rsvd2:" + aVar.oIY + ", Skip:" + aVar.oIZ + ", IReq:" + aVar.oJa);
                }
                if (dVar.oIi != null) {
                    int i5 = dVar.oII.oIO;
                    if ((dVar.oIE == 8 ? 1 : null) == null) {
                        i5 = (int) (((double) i5) * (1.0d + ((1.0d * ((double) Math.max(Math.min(dVar.oHa.oJX.oOV, 30), 0))) / 100.0d)));
                    }
                    if (dVar.oIm != i5) {
                        dVar.yn(i5);
                        x.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + d.oIu + ", new_br: " + dVar.oIm + ", tuneBR:" + i5 + ", tuneRatio:" + dVar.oHa.oJX.oOV);
                        dVar.oIm = i5;
                    }
                    if ((byte) 1 == dVar.oII.oJa && d.oIu > 0) {
                        if (dVar.oIi != null) {
                            x.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
                            Bundle bundle = new Bundle();
                            bundle.putInt("request-sync", 0);
                            dVar.oIi.setParameters(bundle);
                        }
                        x.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + d.oIu);
                    }
                    if (dVar.oII.oIP != dVar.oIl) {
                        dVar.oIl = dVar.oII.oIP;
                    }
                }
            }
            boolean equalsIgnoreCase = this.oHa.oJX.oPT.ENCODING.equalsIgnoreCase("video/avc");
            if (this.oHa.oJX.oPT.ENCODING.equalsIgnoreCase("video/hevc") || (equalsIgnoreCase && 1 == (this.oHa.oJX.oPT.oII.oIX & 1) && this.oHa.oJX.oPT.oII.oIW >= (byte) 6)) {
                this.oKH = true;
            } else {
                this.oKH = false;
            }
        }
        x.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + System.currentTimeMillis() + ", len:" + i + ", cnt:" + this.oHa.oJX.oPA + ", mIsHWEncEnable:" + this.oHa.oJX.oPX + ", mIsHWEncUsing:" + this.oKH);
        if (!this.oKH || this.oHa.oJX.oPT == null) {
            if ((this.oKJ >> 8) != 0) {
                this.oKJ &= -257;
                this.oHa.oJY.setHWDecMode(this.oKJ);
            }
            return this.oHa.oJX.videoEncodeToSend(bArr, i, i3, i4, i2);
        }
        if (1 != (this.oKJ >> 8)) {
            this.oKJ |= ab.CTRL_BYTE;
            this.oHa.oJY.setHWDecMode(this.oKJ);
        }
        int d = this.oHa.oJX.oPT.d(bArr, i3, i4, i2);
        if (d >= 0) {
            return 1;
        }
        x.d("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + d);
        this.oKI = true;
        return 0;
    }
}
