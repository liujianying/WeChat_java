package com.tencent.mm.e.b;

import com.tencent.mm.e.b.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c bEj;

    c$1(c cVar) {
        this.bEj = cVar;
    }

    public final void d(int i, byte[] bArr) {
        c cVar;
        int i2;
        int i3;
        this.bEj.bDX++;
        if (this.bEj.bDZ && System.currentTimeMillis() - this.bEj.bDS <= 1000 && ((long) (this.bEj.bDX - 10)) > (System.currentTimeMillis() - this.bEj.bDS) / ((long) this.bEj.bDL)) {
            h.mEJ.a(151, 0, 1, false);
            h.mEJ.a(151, 4, 1, false);
            x.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[]{Integer.valueOf(this.bEj.bDX), Long.valueOf((System.currentTimeMillis() - this.bEj.bDS) / ((long) this.bEj.bDL))});
            this.bEj.bDY = true;
        }
        if (this.bEj.bEe != null) {
            this.bEj.bEe.w(bArr, i);
        }
        if (i > 0) {
            cVar = this.bEj;
            if (!(cVar.bDU && -2 == cVar.bDH)) {
                int i4 = i / cVar.bDT;
                for (i2 = 5; i2 <= cVar.bDV + i4; i2 += 5) {
                    i3 = ((i2 - cVar.bDV) - 1) * cVar.bDT;
                    int i5 = cVar.bDT + i3;
                    if (i3 < 0 || i5 > i) {
                        x.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i5)});
                        break;
                    }
                    while (i3 < i5) {
                        if (bArr[i3] != (byte) 0) {
                            cVar.bDH = -1;
                            cVar.bDU = true;
                            break;
                        }
                        i3++;
                    }
                    cVar.bDH++;
                }
                cVar.bDV = (cVar.bDV + i4) % 5;
                if (cVar.bDH == 20) {
                    cVar.bDF = 6;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
                    if (cVar.bDG == -1 && cVar.bDI == -1) {
                        cVar.bDF = 11;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                    } else if (cVar.bDG == -1) {
                        cVar.bDF = 8;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                    } else if (cVar.bDI == -1) {
                        cVar.bDF = 9;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                    }
                    h.mEJ.a(151, 0, 1, false);
                    h.mEJ.a(151, 5, 1, false);
                    cVar.bDH = -2;
                    cVar.wo();
                }
            }
        }
        if (!this.bEj.bDN) {
            return;
        }
        if (i > 0) {
            cVar = this.bEj;
            if (cVar.bDG != -1) {
                i3 = 0;
                for (i2 = 0; i2 < i / 2; i2++) {
                    short s = (short) ((bArr[(i2 * 2) + 1] << 8) | (bArr[(i2 * 2) + 0] & 255));
                    if (s >= (short) 32760 || s == Short.MIN_VALUE) {
                        i3++;
                    }
                    if (i3 >= 5) {
                        cVar.bDG++;
                        break;
                    }
                }
                if (cVar.bDG > 100) {
                    cVar.bDF = 7;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                    if (cVar.bDH == -2 && cVar.bDI == -1) {
                        cVar.bDF = 11;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                    } else if (cVar.bDH == -2) {
                        cVar.bDF = 8;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                    } else if (cVar.bDI == -1) {
                        cVar.bDF = 10;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                    }
                    h.mEJ.a(151, 0, 1, false);
                    h.mEJ.a(151, 6, 1, false);
                    cVar.wo();
                    cVar.bDG = -1;
                    return;
                }
                return;
            }
            return;
        }
        c cVar2 = this.bEj;
        if (cVar2.bDI != -1 && i < 0) {
            cVar2.bDI++;
            if (cVar2.bDI >= 50) {
                cVar2.bDF = 5;
                x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                if (cVar2.bDH == -2 && cVar2.bDG == -1) {
                    cVar2.bDF = 11;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                } else if (cVar2.bDH == -2) {
                    cVar2.bDF = 9;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                } else if (cVar2.bDG == -1) {
                    cVar2.bDF = 10;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                }
                h.mEJ.a(151, 0, 1, false);
                h.mEJ.a(151, 7, 1, false);
                cVar2.wo();
                cVar2.bDI = -1;
            }
        }
    }
}
