package com.d.a.a;

import android.os.SystemClock;
import com.d.a.a.u.b;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

class u$f {
    final /* synthetic */ u blN;
    private ArrayList<b> bma;
    private a[] bmb;
    private int bmc;
    private float[][] bmd;
    private float[][] bme;
    private float[][] bmf;
    private int[] bmg;
    private int bmh;
    private int bmi;
    private int bmj;

    private u$f(u uVar) {
        this.blN = uVar;
        this.bma = new ArrayList();
        this.bmb = new a[5];
        this.bmc = 0;
        this.bmd = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
        this.bme = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
        this.bmf = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        this.bmg = new int[6];
        this.bmh = 5;
        this.bmi = -1;
        this.bmj = 0;
    }

    /* synthetic */ u$f(u uVar, byte b) {
        this(uVar);
    }

    final synchronized void reset() {
        this.bma.clear();
        this.bmb = new a[5];
        this.bmc = 0;
        this.bmd = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
        this.bme = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
        this.bmf = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        this.bmg = new int[6];
        this.bmh = 5;
    }

    private synchronized boolean sU() {
        boolean z;
        if (this.bmc >= 20) {
            float[] fArr = this.bmd[0];
            fArr[2] = fArr[2] / 20.0f;
            fArr = this.bmd[1];
            fArr[2] = fArr[2] / 20.0f;
            fArr = this.bmd[2];
            fArr[2] = fArr[2] / 20.0f;
            fArr = this.bme[0];
            fArr[2] = fArr[2] / 20.0f;
            fArr = this.bme[1];
            fArr[2] = fArr[2] / 20.0f;
            fArr = this.bme[2];
            fArr[2] = fArr[2] / 20.0f;
            float f = this.bme[0][2];
            float f2 = this.bmd[0][0] - this.bmd[0][2];
            float f3 = this.bmd[0][2] - this.bmd[0][1];
            float f4 = this.bme[1][2];
            float f5 = this.bmd[1][0] - this.bmd[1][2];
            float f6 = this.bmd[1][2] - this.bmd[1][1];
            float f7 = this.bme[2][2];
            float f8 = this.bmd[2][0] - this.bmd[2][2];
            float f9 = this.bmd[2][2] - this.bmd[2][1];
            this.bmf[0][0] = (f * 0.32999998f) + (0.67f * this.bmf[0][0]);
            this.bmf[0][1] = (f2 * 0.32999998f) + (0.67f * this.bmf[0][1]);
            this.bmf[0][2] = (f3 * 0.32999998f) + (0.67f * this.bmf[0][2]);
            this.bmf[1][0] = (0.67f * this.bmf[1][0]) + (f4 * 0.32999998f);
            this.bmf[1][1] = (0.67f * this.bmf[1][1]) + (0.32999998f * f5);
            this.bmf[1][2] = (0.67f * this.bmf[1][2]) + (0.32999998f * f6);
            this.bmf[2][0] = (0.67f * this.bmf[2][0]) + (0.32999998f * f7);
            this.bmf[2][1] = (0.67f * this.bmf[2][1]) + (0.32999998f * f8);
            this.bmf[2][2] = (0.67f * this.bmf[2][2]) + (0.32999998f * f9);
            a(sV());
            this.bmc = 0;
            this.bmd = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bme = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            if (this.bma.size() >= 100) {
                this.bma.subList(0, 20).clear();
                this.bma.trimToSize();
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private synchronized a sV() {
        a aVar;
        Object obj;
        float abs;
        float abs2;
        float abs3;
        float f;
        int i;
        int i2;
        Object obj2 = this.bmj == 0 ? 1 : null;
        if (obj2 != null) {
            this.bmh = ((double) Math.abs(this.bmf[2][0])) < 9.3d ? 5 : 2;
            this.bmg = new int[6];
            obj = null;
        } else {
            Object obj3 = (Math.abs(this.bmf[0][0]) < 7.0f || (this.bmf[1][1] < 2.3f && this.bmf[1][2] < 2.3f)) ? null : 1;
            if (obj3 != null) {
                this.bmh = 2;
                this.bmg = new int[6];
                obj = obj3;
            } else {
                int i3;
                abs = Math.abs(this.bmf[0][0]);
                abs2 = Math.abs(this.bmf[1][0]);
                abs3 = Math.abs(this.bmf[2][0]);
                if (abs > abs2) {
                    if (abs > abs3) {
                        i3 = 0;
                    } else {
                        i3 = 2;
                    }
                } else if (abs2 > abs3) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                f = 0.0f;
                int i4 = 0;
                i = 0;
                for (i2 = 0; i2 < 3; i2++) {
                    if (i2 != i3) {
                        for (int i5 = 1; i5 < 3; i5++) {
                            if (this.bmf[i2][i5] > f) {
                                f = this.bmf[i2][i5];
                                i = i5;
                                i4 = i2;
                            }
                        }
                    }
                }
                i3 = ((i4 * 2) + i) - 1;
                int[] iArr = this.bmg;
                iArr[i3] = iArr[i3] + 1;
                i3 = 0;
                while (i3 <= 5) {
                    if (i3 != this.bmh && this.bmg[i3] > this.bmg[this.bmh]) {
                        this.bmh = i3;
                    }
                    i3++;
                }
                obj = obj3;
            }
        }
        if (this.bmi >= 0 && this.bmi <= 5) {
            this.bmh = this.bmi;
        }
        aVar = new a(this, (byte) 0);
        aVar = new a(this, (byte) 0);
        if (this.bmb[0] != null) {
            aVar.bmo = this.bmb[0].bmo;
            aVar.bml = this.bmb[0].bml;
        }
        if (this.bmb[4] != null) {
            aVar.bmo = this.bmb[4].bmo;
            aVar.bml = this.bmb[4].bml;
        }
        if (!this.bma.isEmpty()) {
            b bVar;
            i2 = this.bma.size();
            float[] fArr = new float[6];
            float[] fArr2 = new float[6];
            Iterator it = this.bma.iterator();
            abs3 = 0.0f;
            float f2 = 0.0f;
            while (it.hasNext()) {
                bVar = (b) it.next();
                f2 += obj == null ? bVar.blz : bVar.blC;
                if (obj == null) {
                    abs2 = bVar.blH;
                } else {
                    abs2 = (float) Math.sqrt((double) (((bVar.blA * bVar.blA) + (bVar.blB * bVar.blB)) + (bVar.blC * bVar.blC)));
                    bVar.blG = abs2;
                }
                abs3 += abs2;
                for (i = 0; i <= 5; i++) {
                    fArr[i] = fArr[i] + bVar.blL[i];
                    fArr2[i] = fArr2[i] + bVar.blM[i];
                }
            }
            float f3 = f2 / ((float) i2);
            float f4 = abs3 / ((float) i2);
            float f5 = obj == null ? f3 : f4;
            float[] fArr3 = new float[]{(float) Math.atan2((double) fArr[0], (double) fArr2[0]), (float) Math.atan2((double) fArr[1], (double) fArr2[1]), (float) Math.atan2((double) fArr[2], (double) fArr2[2]), (float) Math.atan2((double) fArr[3], (double) fArr2[3]), (float) Math.atan2((double) fArr[4], (double) fArr2[4]), (float) Math.atan2((double) fArr[5], (double) fArr2[5])};
            float f6 = obj == null ? f3 : f4;
            abs2 = 0.0f;
            float f7 = obj == null ? 1.2f : 1.0f;
            float f8 = obj2 != null ? 0.08726647f : 0.2617994f;
            Iterator it2 = this.bma.iterator();
            f2 = f4;
            float f9 = 0.0f;
            float f10 = 0.0f;
            int i6 = 0;
            while (it2.hasNext()) {
                float f11;
                bVar = (b) it2.next();
                float f12 = obj == null ? bVar.blz : bVar.blG;
                abs3 = obj == null ? bVar.blH : bVar.blG;
                if (obj == null) {
                    f11 = f3;
                } else {
                    f11 = f4;
                }
                if (i6 > 0) {
                    float f13;
                    if (f6 < f12) {
                        if (obj2 == null) {
                            f = f12 - f11;
                            if (f > 2.0f * f7) {
                                f13 = f / 2.0f;
                                f6 = f12;
                            }
                        }
                        f13 = f7;
                        f6 = f12;
                    } else {
                        f13 = f7;
                    }
                    if (f2 < abs3) {
                        f = abs3;
                    } else {
                        f = f2;
                    }
                    if (f12 > f11) {
                        f7 = f13;
                        f2 = f;
                        i6++;
                    } else {
                        if (i6 <= 10) {
                            Object obj4 = 1;
                            if (aVar.bmo != 0 && bVar.time - aVar.bmo < 250) {
                                obj4 = null;
                            }
                            if (obj4 != null && f - f4 < 0.3f) {
                                obj4 = null;
                            }
                            if (obj4 != null) {
                                aVar.bmk++;
                                abs2 += f6;
                                f2 = (float) Math.atan2((double) (bVar.blL[this.bmh] + f10), (double) (bVar.blM[this.bmh] + f9));
                                abs3 = Math.abs(f2 - fArr3[this.bmh]);
                                if (abs3 > 3.1415927f) {
                                    abs3 = 6.2831855f - abs3;
                                }
                                Object obj5 = abs3 >= f8 ? 1 : null;
                                abs3 = 1.0f;
                                if (obj5 != null) {
                                    abs3 = 0.93f;
                                } else {
                                    f2 = fArr3[this.bmh];
                                }
                                f7 = (float) (Math.sin((double) f2) * ((double) abs3));
                                abs3 = (float) (((double) abs3) * Math.cos((double) f2));
                                aVar.x += f7;
                                aVar.y += abs3;
                                if (bVar.time - aVar.bmo > 250) {
                                    aVar.x -= f7;
                                    aVar.y -= abs3;
                                    aVar.bmk++;
                                }
                            }
                            aVar.bmo = bVar.time;
                        }
                        abs3 = bVar.blL[this.bmh];
                        f7 = f13;
                        f2 = f;
                        f9 = bVar.blM[this.bmh];
                        f10 = abs3;
                        i6 = 0;
                    }
                } else if (f12 <= f11) {
                    abs3 = bVar.blL[this.bmh];
                    f9 = bVar.blM[this.bmh];
                    f10 = abs3;
                } else if (f12 - f11 >= f7) {
                    f2 = abs3;
                    f6 = f12;
                    i6 = 1;
                }
            }
            if (aVar.bmk > 0) {
                abs = obj == null ? 0.0f : 0.08f;
                abs2 /= (float) aVar.bmk;
                abs3 = aVar.bml;
                abs += ((abs2 - f5) / 15.0f) + 0.537f;
                if (abs3 != 0.0f) {
                    abs = (abs * 0.67f) + (0.33f * abs3);
                }
                aVar.bml = abs;
                aVar.x *= aVar.bml;
                aVar.y *= aVar.bml;
                aVar.bmm = ((float) aVar.bmk) * aVar.bml;
            }
        }
        aVar.bmn = aVar.bmm / ((float) (this.bma.size() / 20));
        if (this.bmb[0] != null) {
            aVar.x += this.bmb[0].x;
            aVar.y += this.bmb[0].y;
            aVar.z += this.bmb[0].z;
            aVar.bmk += this.bmb[0].bmk;
            aVar.bmm += this.bmb[0].bmm;
        }
        if (this.bmb[4] != null && aVar.bmk > 0) {
            this.bmb[4].x = ((this.bmb[4].x + aVar.x) + (aVar.x * aVar.bml)) / 2.0f;
            this.bmb[4].y = ((this.bmb[4].y + aVar.y) + (aVar.y * aVar.bml)) / 2.0f;
        }
        return aVar;
    }

    private synchronized void a(a aVar) {
        System.arraycopy(this.bmb, 1, this.bmb, 0, 4);
        if (this.bmb[4] == null || SystemClock.elapsedRealtime() - aVar.bmo <= 1000) {
            this.bmb[4] = aVar;
        } else {
            a aVar2 = this.bmb[4];
            aVar2.x = (aVar2.x + aVar.x) / 2.0f;
            aVar2.y = (aVar2.y + aVar.y) / 2.0f;
            aVar2.z = (aVar2.z + aVar.z) / 2.0f;
            aVar2.bmk = Math.round(((float) (aVar2.bmk + aVar.bmk)) / 2.0f);
            aVar2.bml = (aVar2.bml + aVar.bml) / 2.0f;
            aVar2.bmm = (aVar2.bmm + aVar.bmm) / 2.0f;
            aVar2.bmo = aVar.bmo;
            aVar2.bmn = aVar.bmn;
        }
    }

    final synchronized void a(b bVar) {
        if (this.bmj > 0 && this.bmj < 101) {
            this.bmj--;
        }
        this.bma.add(bVar);
        this.bmc++;
        if (bVar.blA > this.bmd[0][0]) {
            this.bmd[0][0] = bVar.blA;
        }
        if (bVar.blA < this.bmd[0][1]) {
            this.bmd[0][1] = bVar.blA;
        }
        float[] fArr = this.bmd[0];
        fArr[2] = fArr[2] + bVar.blA;
        if (bVar.blB > this.bmd[1][0]) {
            this.bmd[1][0] = bVar.blB;
        }
        if (bVar.blB < this.bmd[1][1]) {
            this.bmd[1][1] = bVar.blB;
        }
        fArr = this.bmd[1];
        fArr[2] = fArr[2] + bVar.blB;
        if (bVar.blC > this.bmd[2][0]) {
            this.bmd[2][0] = bVar.blC;
        }
        if (bVar.blC < this.bmd[2][1]) {
            this.bmd[2][1] = bVar.blC;
        }
        fArr = this.bmd[2];
        fArr[2] = fArr[2] + bVar.blC;
        if (bVar.blD > this.bme[0][0]) {
            this.bme[0][0] = bVar.blD;
        }
        if (bVar.blD < this.bme[0][1]) {
            this.bme[0][1] = bVar.blD;
        }
        fArr = this.bme[0];
        fArr[2] = fArr[2] + bVar.blD;
        if (bVar.blE > this.bme[1][0]) {
            this.bme[1][0] = bVar.blE;
        }
        if (bVar.blE < this.bme[1][1]) {
            this.bme[1][1] = bVar.blE;
        }
        fArr = this.bme[1];
        fArr[2] = fArr[2] + bVar.blE;
        if (bVar.blF > this.bme[2][0]) {
            this.bme[2][0] = bVar.blF;
        }
        if (bVar.blF < this.bme[2][1]) {
            this.bme[2][1] = bVar.blF;
        }
        fArr = this.bme[2];
        fArr[2] = fArr[2] + bVar.blF;
        if (sU()) {
            u.b(this.blN);
        }
    }

    final synchronized a sW() {
        return this.bmb[4] != null ? this.bmb[4].sX() : null;
    }
}
