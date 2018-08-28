package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import java.util.Arrays;

final class k {
    float aex;
    short[] ahA;
    private int ahB;
    short[] ahC;
    private int ahD;
    private short[] ahE;
    private int ahF;
    private int ahG;
    int ahH;
    int ahI;
    int ahJ;
    int ahK;
    private int ahL;
    private int ahM;
    private int ahN;
    private int ahO;
    final int ahu;
    private final int ahv;
    private final int ahw;
    final int ahx = (this.ahw * 2);
    private final short[] ahy = new short[this.ahx];
    private int ahz = this.ahx;
    float pitch;
    private final int sampleRate;

    public k(int i, int i2) {
        this.sampleRate = i;
        this.ahu = i2;
        this.ahv = i / 400;
        this.ahw = i / 65;
        this.ahA = new short[(this.ahx * i2)];
        this.ahB = this.ahx;
        this.ahC = new short[(this.ahx * i2)];
        this.ahD = this.ahx;
        this.ahE = new short[(this.ahx * i2)];
        this.ahF = 0;
        this.ahG = 0;
        this.ahL = 0;
        this.aex = 1.0f;
        this.pitch = 1.0f;
    }

    private void cd(int i) {
        if (this.ahI + i > this.ahB) {
            this.ahB += (this.ahB / 2) + i;
            this.ahC = Arrays.copyOf(this.ahC, this.ahB * this.ahu);
        }
    }

    final void ce(int i) {
        if (this.ahH + i > this.ahz) {
            this.ahz += (this.ahz / 2) + i;
            this.ahA = Arrays.copyOf(this.ahA, this.ahz * this.ahu);
        }
    }

    private void a(short[] sArr, int i, int i2) {
        cd(i2);
        System.arraycopy(sArr, this.ahu * i, this.ahC, this.ahI * this.ahu, this.ahu * i2);
        this.ahI += i2;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.ahx / i2;
        int i4 = this.ahu * i2;
        int i5 = i * this.ahu;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[((i6 * i4) + i5) + i8];
            }
            this.ahy[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4 = b.CTRL_BYTE;
        int i5 = 1;
        int i6 = i * this.ahu;
        int i7 = 0;
        int i8 = 0;
        int i9 = i2;
        while (i9 <= i3) {
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                i10 += Math.abs(sArr[i6 + i11] - sArr[(i6 + i9) + i11]);
            }
            if (i10 * i8 < i5 * i9) {
                i5 = i10;
                i8 = i9;
            }
            if (i10 * i4 > i7 * i9) {
                i4 = i9;
            } else {
                i10 = i7;
            }
            i9++;
            i7 = i10;
        }
        this.ahN = i5 / i8;
        this.ahO = i7 / i4;
        return i8;
    }

    final void jw() {
        int i;
        int min;
        int a;
        int i2;
        short[] sArr;
        int i3 = this.ahI;
        float f = this.aex / this.pitch;
        if (((double) f) <= 1.00001d && ((double) f) >= 0.99999d) {
            a(this.ahA, 0, this.ahH);
            this.ahH = 0;
        } else if (this.ahH >= this.ahx) {
            int i4 = this.ahH;
            i = 0;
            do {
                if (this.ahK > 0) {
                    min = Math.min(this.ahx, this.ahK);
                    a(this.ahA, i, min);
                    this.ahK -= min;
                    i += min;
                } else {
                    short[] sArr2 = this.ahA;
                    min = this.sampleRate > 4000 ? this.sampleRate / 4000 : 1;
                    if (this.ahu == 1 && min == 1) {
                        min = a(sArr2, i, this.ahv, this.ahw);
                    } else {
                        b(sArr2, i, min);
                        a = a(this.ahy, 0, this.ahv / min, this.ahw / min);
                        if (min != 1) {
                            i2 = a * min;
                            a = i2 - (min * 4);
                            i2 += min * 4;
                            if (a < this.ahv) {
                                min = this.ahv;
                            } else {
                                min = a;
                            }
                            if (i2 > this.ahw) {
                                a = this.ahw;
                            } else {
                                a = i2;
                            }
                            if (this.ahu == 1) {
                                min = a(sArr2, i, min, a);
                            } else {
                                b(sArr2, i, 1);
                                min = a(this.ahy, 0, min, a);
                            }
                        } else {
                            min = a;
                        }
                    }
                    a = this.ahN;
                    Object obj = (a == 0 || this.ahL == 0) ? null : this.ahO > a * 3 ? null : a * 2 <= this.ahM * 3 ? null : 1;
                    int i5 = obj != null ? this.ahL : min;
                    this.ahM = this.ahN;
                    this.ahL = min;
                    if (((double) f) > 1.0d) {
                        sArr = this.ahA;
                        if (f >= 2.0f) {
                            min = (int) (((float) i5) / (f - 1.0f));
                        } else {
                            this.ahK = (int) ((((float) i5) * (2.0f - f)) / (f - 1.0f));
                            min = i5;
                        }
                        cd(min);
                        a(min, this.ahu, this.ahC, this.ahI, sArr, i, sArr, i + i5);
                        this.ahI += min;
                        i += min + i5;
                    } else {
                        int i6;
                        Object obj2 = this.ahA;
                        if (f < 0.5f) {
                            i6 = (int) ((((float) i5) * f) / (1.0f - f));
                        } else {
                            this.ahK = (int) ((((float) i5) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                            i6 = i5;
                        }
                        cd(i5 + i6);
                        System.arraycopy(obj2, this.ahu * i, this.ahC, this.ahI * this.ahu, this.ahu * i5);
                        a(i6, this.ahu, this.ahC, this.ahI + i5, obj2, i + i5, obj2, i);
                        this.ahI += i5 + i6;
                        i += i6;
                    }
                }
            } while (this.ahx + i <= i4);
            min = this.ahH - i;
            System.arraycopy(this.ahA, this.ahu * i, this.ahA, 0, this.ahu * min);
            this.ahH = min;
        }
        if (this.pitch != 1.0f) {
            float f2 = this.pitch;
            if (this.ahI != i3) {
                int i7;
                a = (int) (((float) this.sampleRate) / f2);
                min = this.sampleRate;
                while (true) {
                    i2 = min;
                    i7 = a;
                    if (i7 <= 16384 && i2 <= 16384) {
                        break;
                    }
                    a = i7 / 2;
                    min = i2 / 2;
                }
                min = this.ahI - i3;
                if (this.ahJ + min > this.ahD) {
                    this.ahD += (this.ahD / 2) + min;
                    this.ahE = Arrays.copyOf(this.ahE, this.ahD * this.ahu);
                }
                System.arraycopy(this.ahC, this.ahu * i3, this.ahE, this.ahJ * this.ahu, this.ahu * min);
                this.ahI = i3;
                this.ahJ = min + this.ahJ;
                min = 0;
                while (true) {
                    a = min;
                    if (a >= this.ahJ - 1) {
                        break;
                    }
                    while ((this.ahF + 1) * i7 > this.ahG * i2) {
                        cd(1);
                        for (min = 0; min < this.ahu; min++) {
                            sArr = this.ahC;
                            i = (this.ahI * this.ahu) + min;
                            short[] sArr3 = this.ahE;
                            int i8 = (this.ahu * a) + min;
                            short s = sArr3[i8];
                            short s2 = sArr3[i8 + this.ahu];
                            int i9 = (this.ahF + 1) * i7;
                            i8 = i9 - (this.ahG * i2);
                            int i10 = i9 - (this.ahF * i7);
                            sArr[i] = (short) (((s2 * (i10 - i8)) + (s * i8)) / i10);
                        }
                        this.ahG++;
                        this.ahI++;
                    }
                    this.ahF++;
                    if (this.ahF == i2) {
                        this.ahF = 0;
                        a.ap(this.ahG == i7);
                        this.ahG = 0;
                    }
                    min = a + 1;
                }
                min = this.ahJ - 1;
                if (min != 0) {
                    System.arraycopy(this.ahE, this.ahu * min, this.ahE, 0, (this.ahJ - min) * this.ahu);
                    this.ahJ -= min;
                }
            }
        }
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
