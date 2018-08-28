package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.mmsight.model.a.b.1;
import com.tencent.mm.plugin.mmsight.model.a.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class n$2 extends ag {
    final /* synthetic */ n ljp;

    n$2(n nVar, Looper looper) {
        this.ljp = nVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                n nVar = this.ljp;
                if (nVar.ljg != null) {
                    int i;
                    boolean z;
                    int i2;
                    int i3;
                    int i4;
                    boolean z2;
                    boolean z3;
                    b bVar;
                    a aVar;
                    Object obj;
                    nVar.ljl.ec(1);
                    long VG = bi.VG();
                    q qVar = nVar.ljg;
                    int i5 = nVar.liB;
                    int i6 = nVar.liC;
                    bi.VG();
                    int i7 = qVar.ljw;
                    boolean z4 = qVar.lgJ;
                    if (z4) {
                        i = qVar.ljx == -1 ? qVar.ljw : qVar.ljx;
                    } else if (qVar.ljx == -1 || qVar.ljx == qVar.ljw) {
                        z = false;
                        i2 = (qVar.ljx != -1 || qVar.ljx == qVar.ljw) ? qVar.ljw : qVar.ljx;
                        i3 = (i2 != 0 || i2 == 180) ? i5 : i6;
                        i4 = (i2 != 0 || i2 == 180) ? i6 : i5;
                        z2 = i3 == qVar.kGn || i4 != qVar.kGo;
                        z3 = (qVar.ljy != -1 || qVar.ljz == -1 || (qVar.ljy == qVar.kGn && qVar.ljz == qVar.kGo)) ? z2 : true;
                        x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(qVar.lgJ), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                        bVar = new b(i3, i4, qVar.lhv, qVar.kGn, qVar.kGo, z3, z, i7, bArr);
                        aVar = qVar.ljA;
                        if (!aVar.lhj) {
                            if (aVar.handler == null) {
                                aVar.handler = new ag(Looper.myLooper());
                            }
                            i4 = aVar.lhf % a.lhd;
                            if (aVar.lhe[i4] != null) {
                                i5 = aVar.lhf;
                                Looper looper = aVar.lhe[i4].getLooper();
                                a aVar2 = aVar.lhk;
                                bVar.lhr = i5;
                                bVar.lhw = i4;
                                bVar.lhs = bi.VG();
                                x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.lho.length), Integer.valueOf(bVar.lhr)});
                                new ag(looper).post(new 1(bVar, aVar2));
                                aVar.lhf++;
                            }
                        }
                        x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
                        if (!nVar.liK && nVar.liQ) {
                            nVar.liK = true;
                            obj = new byte[bArr.length];
                            System.arraycopy(bArr, 0, obj, 0, bArr.length);
                            e.post(new n$9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                        }
                        nVar.liM = true;
                    } else {
                        z4 = true;
                        i = qVar.ljx;
                        i7 = Math.max(0, qVar.ljw <= 180 ? i - qVar.ljw : i + (360 - qVar.ljw));
                        if (i7 >= 360) {
                            i = 0;
                        } else {
                            z = true;
                            if (qVar.ljx != -1) {
                            }
                            if (i2 != 0) {
                            }
                            if (i2 != 0) {
                            }
                            if (i3 == qVar.kGn) {
                            }
                            if (qVar.ljy != -1) {
                            }
                            x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(qVar.lgJ), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                            bVar = new b(i3, i4, qVar.lhv, qVar.kGn, qVar.kGo, z3, z, i7, bArr);
                            aVar = qVar.ljA;
                            if (aVar.lhj) {
                                if (aVar.handler == null) {
                                    aVar.handler = new ag(Looper.myLooper());
                                }
                                i4 = aVar.lhf % a.lhd;
                                if (aVar.lhe[i4] != null) {
                                    i5 = aVar.lhf;
                                    Looper looper2 = aVar.lhe[i4].getLooper();
                                    a aVar22 = aVar.lhk;
                                    bVar.lhr = i5;
                                    bVar.lhw = i4;
                                    bVar.lhs = bi.VG();
                                    x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.lho.length), Integer.valueOf(bVar.lhr)});
                                    new ag(looper2).post(new 1(bVar, aVar22));
                                    aVar.lhf++;
                                }
                            }
                            x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
                            nVar.liK = true;
                            obj = new byte[bArr.length];
                            System.arraycopy(bArr, 0, obj, 0, bArr.length);
                            e.post(new n$9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                            nVar.liM = true;
                        }
                    }
                    z = z4;
                    i7 = i;
                    if (qVar.ljx != -1) {
                    }
                    if (i2 != 0) {
                    }
                    if (i2 != 0) {
                    }
                    if (i3 == qVar.kGn) {
                    }
                    if (qVar.ljy != -1) {
                    }
                    x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(qVar.lgJ), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                    bVar = new b(i3, i4, qVar.lhv, qVar.kGn, qVar.kGo, z3, z, i7, bArr);
                    aVar = qVar.ljA;
                    if (aVar.lhj) {
                        if (aVar.handler == null) {
                            aVar.handler = new ag(Looper.myLooper());
                        }
                        i4 = aVar.lhf % a.lhd;
                        if (aVar.lhe[i4] != null) {
                            i5 = aVar.lhf;
                            Looper looper22 = aVar.lhe[i4].getLooper();
                            a aVar222 = aVar.lhk;
                            bVar.lhr = i5;
                            bVar.lhw = i4;
                            bVar.lhs = bi.VG();
                            x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.lho.length), Integer.valueOf(bVar.lhr)});
                            new ag(looper22).post(new 1(bVar, aVar222));
                            aVar.lhf++;
                        }
                    }
                    x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
                    nVar.liK = true;
                    obj = new byte[bArr.length];
                    System.arraycopy(bArr, 0, obj, 0, bArr.length);
                    e.post(new n$9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                    nVar.liM = true;
                }
            }
        }
    }
}
