package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.b;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.k$a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.a.a.5;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import java.nio.ByteBuffer;

final class i implements com.google.android.exoplayer2.source.i {
    private final j atZ;
    public final int group;

    public i(j jVar, int i) {
        this.atZ = jVar;
        this.group = i;
    }

    public final boolean hv() {
        j jVar = this.atZ;
        return jVar.auv || (!jVar.le() && jVar.auh[this.group].asn.kG());
    }

    public final void kC() {
        this.atZ.kC();
    }

    public final int b(k kVar, e eVar, boolean z) {
        j jVar = this.atZ;
        int i = this.group;
        if (jVar.le()) {
            return -3;
        }
        int i2;
        int i3;
        Object obj;
        int i4;
        if (!jVar.auf.isEmpty()) {
            while (jVar.auf.size() > 1) {
                i2 = ((f) jVar.auf.getFirst()).uid;
                for (i3 = 0; i3 < jVar.auh.length; i3++) {
                    if (jVar.aup[i3]) {
                        g gVar = jVar.auh[i3].asn;
                        if ((gVar.kG() ? gVar.arY[gVar.cI(gVar.ase)] : gVar.ask) == i2) {
                            obj = null;
                            break;
                        }
                    }
                }
                obj = 1;
                if (obj == null) {
                    break;
                }
                jVar.auf.removeFirst();
            }
            f fVar = (f) jVar.auf.getFirst();
            Format format = fVar.asK;
            if (!format.equals(jVar.aul)) {
                a aVar = jVar.atP;
                i2 = jVar.aci;
                i4 = fVar.asL;
                Object obj2 = fVar.asM;
                long j = fVar.asN;
                if (aVar.aru != null) {
                    aVar.handler.post(new 5(aVar, i2, format, i4, obj2, j));
                }
            }
            jVar.aul = format;
        }
        h hVar = jVar.auh[i];
        boolean z2 = jVar.auv;
        long j2 = jVar.aur;
        switch (hVar.asn.a(kVar, eVar, z, z2, hVar.ass, hVar.aso)) {
            case -5:
                hVar.ass = kVar.aep;
                return -5;
            case -4:
                if (!eVar.jy()) {
                    long j3;
                    if (eVar.aih < j2) {
                        eVar.cf(Integer.MIN_VALUE);
                    }
                    if (eVar.jD()) {
                        g.a aVar2 = hVar.aso;
                        j3 = aVar2.mb;
                        hVar.aiZ.reset(1);
                        hVar.a(j3, hVar.aiZ.data, 1);
                        long j4 = 1 + j3;
                        byte b = hVar.aiZ.data[0];
                        obj = (b & 128) != 0 ? 1 : null;
                        int i5 = b & 127;
                        if (eVar.aif.iv == null) {
                            eVar.aif.iv = new byte[16];
                        }
                        hVar.a(j4, eVar.aif.iv, i5);
                        j4 += (long) i5;
                        if (obj != null) {
                            hVar.aiZ.reset(2);
                            hVar.a(j4, hVar.aiZ.data, 2);
                            j4 += 2;
                            i5 = hVar.aiZ.readUnsignedShort();
                        } else {
                            i5 = 1;
                        }
                        int[] iArr = eVar.aif.numBytesOfClearData;
                        if (iArr == null || iArr.length < i5) {
                            iArr = new int[i5];
                        }
                        int[] iArr2 = eVar.aif.numBytesOfEncryptedData;
                        if (iArr2 == null || iArr2.length < i5) {
                            iArr2 = new int[i5];
                        }
                        if (obj != null) {
                            i3 = i5 * 6;
                            hVar.aiZ.reset(i3);
                            hVar.a(j4, hVar.aiZ.data, i3);
                            j4 += (long) i3;
                            hVar.aiZ.setPosition(0);
                            for (i3 = 0; i3 < i5; i3++) {
                                iArr[i3] = hVar.aiZ.readUnsignedShort();
                                iArr2[i3] = hVar.aiZ.mh();
                            }
                        } else {
                            iArr[0] = 0;
                            iArr2[0] = aVar2.size - ((int) (j4 - aVar2.mb));
                        }
                        k$a k_a = aVar2.aml;
                        b bVar = eVar.aif;
                        byte[] bArr = k_a.aiS;
                        byte[] bArr2 = eVar.aif.iv;
                        int i6 = k_a.aiR;
                        int i7 = k_a.ahT;
                        i3 = k_a.ahU;
                        bVar.numSubSamples = i5;
                        bVar.numBytesOfClearData = iArr;
                        bVar.numBytesOfEncryptedData = iArr2;
                        bVar.key = bArr;
                        bVar.iv = bArr2;
                        bVar.mode = i6;
                        bVar.ahT = i7;
                        bVar.ahU = i3;
                        if (t.SDK_INT >= 16) {
                            bVar.ahV.numSubSamples = bVar.numSubSamples;
                            bVar.ahV.numBytesOfClearData = bVar.numBytesOfClearData;
                            bVar.ahV.numBytesOfEncryptedData = bVar.numBytesOfEncryptedData;
                            bVar.ahV.key = bVar.key;
                            bVar.ahV.iv = bVar.iv;
                            bVar.ahV.mode = bVar.mode;
                            if (t.SDK_INT >= 24) {
                                b.a aVar3 = bVar.ahW;
                                aVar3.ahX.set(bVar.ahT, bVar.ahU);
                                aVar3.ahV.setPattern(aVar3.ahX);
                            }
                        }
                        i3 = (int) (j4 - aVar2.mb);
                        aVar2.mb += (long) i3;
                        aVar2.size -= i3;
                    }
                    eVar.ch(hVar.aso.size);
                    j3 = hVar.aso.mb;
                    ByteBuffer byteBuffer = eVar.aig;
                    i2 = hVar.aso.size;
                    hVar.K(j3);
                    while (i2 > 0) {
                        i4 = Math.min(i2, (int) (hVar.asq.ald - j3));
                        byteBuffer.put(hVar.asq.asA.data, hVar.asq.M(j3), i4);
                        i2 -= i4;
                        j3 += (long) i4;
                        if (j3 == hVar.asq.ald) {
                            hVar.asq = hVar.asq.asB;
                        }
                    }
                }
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    public final void H(long j) {
        j jVar = this.atZ;
        h hVar = jVar.auh[this.group];
        if (!jVar.auv || j <= hVar.asn.kI()) {
            hVar.e(j, true);
        } else {
            hVar.asn.kJ();
        }
    }
}
