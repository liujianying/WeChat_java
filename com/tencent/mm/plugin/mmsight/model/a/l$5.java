package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class l$5 extends ag {
    final /* synthetic */ l liS;

    l$5(l lVar, Looper looper) {
        this.liS = lVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.liS.liH == -1) {
            this.liS.liH = Process.myTid();
            x.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[]{Integer.valueOf(this.liS.liH)});
        }
        if (message.what == 1) {
            int length;
            int i;
            int i2;
            int i3;
            byte[] bArr;
            p pVar;
            int i4;
            this.liS.liq.bef();
            l lVar = this.liS;
            byte[] bArr2 = (byte[]) message.obj;
            p pVar2;
            if (lVar.lgJ) {
                pVar2 = lVar.lir;
                length = bArr2.length;
                i = lVar.liB;
                i2 = lVar.liC;
                i3 = i;
                bArr = bArr2;
                pVar = pVar2;
            } else {
                pVar2 = lVar.lir;
                length = bArr2.length;
                i4 = (lVar.liD == 0 || lVar.liD == 180) ? lVar.liB : lVar.liC;
                if (lVar.liD == 0 || lVar.liD == 180) {
                    i2 = lVar.liC;
                    i3 = i4;
                    bArr = bArr2;
                    pVar = pVar2;
                } else {
                    i2 = lVar.liB;
                    i3 = i4;
                    bArr = bArr2;
                    pVar = pVar2;
                }
            }
            pVar.lhs = bi.VG();
            if (pVar.ljv < 0) {
                x.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
            } else {
                boolean z;
                int i5;
                int i6;
                boolean z2;
                synchronized (p.class) {
                    pVar.frameCount++;
                }
                i4 = pVar.ljw;
                boolean z3 = pVar.lgJ;
                if (z3) {
                    i4 = pVar.ljx == -1 ? pVar.ljw : pVar.ljx;
                } else if (pVar.ljx == -1 || pVar.ljx == pVar.ljw) {
                    z = false;
                    SightVideoJNI.setRotateForBufId(pVar.ljv, i4);
                    i = z ? (i4 == 0 || i4 == 180) ? pVar.kGn : pVar.kGo : (i4 == 0 || i4 == 180) ? pVar.kGo : pVar.kGn;
                    i5 = z ? (i4 == 0 || i4 == 180) ? pVar.kGo : pVar.kGn : (i4 == 0 || i4 == 180) ? pVar.kGn : pVar.kGo;
                    i6 = z ? (i4 == 0 || i4 == 180) ? i3 : i2 : (i4 == 0 || i4 == 180) ? i2 : i3;
                    if (z) {
                        if (i4 == 0 || i4 == 180) {
                            i3 = i2;
                        }
                    } else if (!(i4 == 0 || i4 == 180)) {
                        i3 = i2;
                    }
                    z2 = i6 == i || i3 != i5;
                    SightVideoJNI.writeYuvDataForMMSight(pVar.ljv, bArr, length, i, i5, z, z2, i6, i3);
                    x.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bi.bI(pVar.lhs))});
                } else {
                    z3 = true;
                    i4 = pVar.ljx;
                    i4 = Math.max(0, pVar.ljw <= 180 ? i4 - pVar.ljw : i4 + (360 - pVar.ljw));
                    if (i4 >= 360) {
                        i4 = 0;
                    } else {
                        z = true;
                        SightVideoJNI.setRotateForBufId(pVar.ljv, i4);
                        if (z) {
                        }
                        if (z) {
                        }
                        if (z) {
                        }
                        if (z) {
                            if (!(i4 == 0 || i4 == 180)) {
                                i3 = i2;
                            }
                        } else if (i4 == 0 || i4 == 180) {
                            i3 = i2;
                        }
                        if (i6 == i) {
                        }
                        SightVideoJNI.writeYuvDataForMMSight(pVar.ljv, bArr, length, i, i5, z, z2, i6, i3);
                        x.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bi.bI(pVar.lhs))});
                    }
                }
                z = z3;
                SightVideoJNI.setRotateForBufId(pVar.ljv, i4);
                if (z) {
                }
                if (z) {
                }
                if (z) {
                }
                if (z) {
                    if (i4 == 0 || i4 == 180) {
                        i3 = i2;
                    }
                } else if (!(i4 == 0 || i4 == 180)) {
                    i3 = i2;
                }
                if (i6 == i) {
                }
                SightVideoJNI.writeYuvDataForMMSight(pVar.ljv, bArr, length, i, i5, z, z2, i6, i3);
                x.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bi.bI(pVar.lhs))});
            }
            j.lin.F(bArr2);
            lVar.liM = true;
        }
    }
}
