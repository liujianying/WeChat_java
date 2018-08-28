package com.d.a.a;

import android.location.Location;
import android.os.Handler;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import java.util.ArrayList;

final class s {
    private long bjZ;
    float bka;
    private ArrayList<String> bkb = new ArrayList();
    private ArrayList<float[]> bkc = new ArrayList();
    private ArrayList<double[]> bkd = new ArrayList();
    final d bke;
    Handler bkf;

    public s(d dVar) {
        this.bke = dVar;
    }

    private void d(p pVar) {
        if (this.bkf != null) {
            this.bkf.post(new d(this, pVar, (byte) 0));
        }
    }

    private static void writeLog(String str) {
        o.q("post_processing_log_" + y.bmR, str);
    }

    final void sK() {
        z.a(null).execute(new c(this, (byte) 0));
    }

    final synchronized void sL() {
        try {
            aB(true);
        } catch (Exception e) {
        }
    }

    final void sM() {
        this.bjZ = 0;
        this.bka = 0.0f;
        z.a(null).execute(new f(this, (byte) 0));
    }

    final synchronized void reset() {
        sN();
        sO();
    }

    private synchronized void sN() {
        this.bkd.clear();
    }

    private synchronized void sO() {
        this.bkb.clear();
        this.bkc.clear();
    }

    private synchronized void aB(boolean z) {
        if (!this.bkc.isEmpty() && !this.bkd.isEmpty()) {
            int size = z ? this.bkd.size() : this.bkd.size() - 1;
            int size2 = this.bkc.size();
            if (size > 1) {
                int i = 0;
                int i2 = 1;
                while (true) {
                    int i3 = i2;
                    if (i3 >= size) {
                        this.bkb.subList(0, i).clear();
                        this.bkb.trimToSize();
                        this.bkc.subList(0, i).clear();
                        this.bkc.trimToSize();
                        this.bkd.subList(0, size - 1).clear();
                        this.bkd.trimToSize();
                        break;
                    }
                    double[] dArr = (double[]) this.bkd.get(i3 - 1);
                    double[] dArr2 = (double[]) this.bkd.get(i3);
                    float[] fArr = new float[1];
                    Location.distanceBetween(dArr[0], dArr[1], dArr[0], (dArr[1] <= 179.0d ? 1.0E-5d : -1.0E-5d) + dArr[1], fArr);
                    double d = (double) fArr[0];
                    Location.distanceBetween(dArr[0], dArr[1], (dArr[0] <= 89.0d ? 1.0E-5d : -1.0E-5d) + dArr[0], dArr[1], fArr);
                    double d2 = (double) fArr[0];
                    double d3 = dArr2[0] - dArr[0];
                    double d4 = dArr2[1] - dArr[1];
                    if (d4 > 180.0d) {
                        d4 -= 360.0d;
                    } else if (d4 < -180.0d) {
                        d4 += 360.0d;
                    }
                    d4 = (d4 / 1.0E-5d) * d;
                    d3 = (d3 / 1.0E-5d) * d2;
                    double d5 = dArr2[4] - dArr[4];
                    double d6 = dArr2[5] - dArr[5];
                    double sqrt = Math.sqrt(((d4 * d4) + (d3 * d3)) / ((d5 * d5) + (d6 * d6)));
                    if (sqrt < ((double) (1.0f / y.bmU)) || sqrt > ((double) y.bmU)) {
                        int i4 = i;
                        while (i4 < size2 && ((double) ((float[]) this.bkc.get(i4))[2]) <= dArr2[6]) {
                            i4++;
                        }
                        i2 = i4;
                    } else {
                        Object obj;
                        float f;
                        int i5;
                        boolean z2;
                        d4 = Math.atan2(d3, d4) - Math.atan2(d6, d5);
                        d3 = Math.cos(d4);
                        double[] dArr3 = new double[]{d3, -Math.sin(d4), d5, d3};
                        if (sqrt < 1.0d) {
                            d4 = sqrt;
                        } else {
                            d4 = 1.0d / sqrt;
                        }
                        double d7 = d4 * 10.0d;
                        double abs = 1.0d + Math.abs(d5);
                        StringBuilder stringBuilder = new StringBuilder();
                        int i6 = 0;
                        float f2 = 0.0f;
                        float f3 = 0.0f;
                        float f4 = 0.0f;
                        if (y.bmK) {
                            writeLog("ref_point," + dArr[0] + ',' + dArr[1] + ',' + dArr[2] + ',' + dArr[8]);
                            obj = 1;
                            f = 0.0f;
                        } else {
                            int obj2 = 1;
                            f = 0.0f;
                        }
                        while (true) {
                            i5 = i;
                            if (i5 < size2) {
                                float[] fArr2 = (float[]) this.bkc.get(i5);
                                if (((double) fArr2[2]) > dArr2[6]) {
                                    break;
                                }
                                Object obj3;
                                fArr2[3] = Double.valueOf(Math.max(6.0d, Math.min((Math.abs((((double) fArr2[2]) - dArr[6]) / d7) * abs) + dArr[2], (Math.abs((((double) fArr2[2]) - dArr2[6]) / d7) * abs) + dArr2[2]))).floatValue();
                                double[] dArr4 = new double[]{((double) fArr2[0]) - dArr[4], ((double) fArr2[1]) - dArr[5]};
                                double[] dArr5 = new double[]{dArr4[0] * sqrt, dArr4[1] * sqrt};
                                dArr4 = new double[]{(dArr5[0] * dArr3[0]) + (dArr5[1] * dArr3[1]), (dArr5[0] * dArr3[2]) + (dArr5[1] * dArr3[3])};
                                dArr5 = new double[]{dArr4[0] + 0.0d, dArr4[1] + 0.0d};
                                double[] dArr6 = new double[]{((1.0E-5d * dArr5[1]) / d2) + dArr[0], ((1.0E-5d * dArr5[0]) / d) + dArr[1]};
                                if (dArr6[0] > 90.0d) {
                                    dArr6[0] = 180.0d - dArr6[0];
                                } else if (dArr6[0] < -90.0d) {
                                    dArr6[0] = -180.0d - dArr6[0];
                                }
                                if (dArr6[1] > 180.0d) {
                                    dArr6[1] = dArr6[1] - 360.0d;
                                } else if (dArr6[1] < -180.0d) {
                                    dArr6[1] = dArr6[1] + 360.0d;
                                }
                                if (y.bmK) {
                                    writeLog("scan_point," + dArr6[0] + ',' + dArr6[1] + ',' + fArr2[3]);
                                }
                                String str = (String) this.bkb.get(i5);
                                int round = Math.round(fArr2[3]);
                                if (round > i6) {
                                    i6 = round;
                                }
                                i = Math.round(fArr2[4]);
                                if (str != null) {
                                    try {
                                        stringBuilder.append(str);
                                        double d8 = dArr6[0];
                                        double d9 = dArr6[1];
                                        str = "";
                                        if (v.e(d8, d9)) {
                                            str = "|MD," + d8 + ',' + d9 + ',' + round + ',' + i + ',' + str;
                                        } else {
                                            str = "";
                                        }
                                        stringBuilder.append(str);
                                    } catch (Error e) {
                                    }
                                }
                                if (obj2 != null) {
                                    f2 = fArr2[5];
                                    f3 = fArr2[2];
                                    obj3 = null;
                                } else {
                                    obj3 = obj2;
                                }
                                f4 = fArr2[5];
                                i = i5 + 1;
                                obj2 = obj3;
                                f = fArr2[2];
                            } else {
                                break;
                            }
                        }
                        if (y.bmK) {
                            writeLog("ref_point," + dArr2[0] + ',' + dArr2[1] + ',' + dArr2[2] + ',' + dArr2[8]);
                        }
                        if (((float) i6) <= y.bmS) {
                            float f5 = f4 - f2;
                            float f6 = f - f3;
                            if (f5 > 0.0f && (((double) f6) * sqrt) / ((double) f5) <= ((double) y.bmT)) {
                                r.sC().bJ(stringBuilder.toString());
                                z2 = true;
                                if (y.bmK) {
                                    writeLog(z2 ? "buffered" : "discarded");
                                }
                                d(new g(z2));
                                i2 = i5;
                            }
                        }
                        z2 = false;
                        if (y.bmK) {
                            writeLog(z2 ? "buffered" : "discarded");
                        }
                        d(new g(z2));
                        i2 = i5;
                    }
                    i3++;
                }
            }
        }
    }

    final synchronized void a(float f, float f2, float f3, float f4, int i, String str) {
        this.bkb.add(str);
        this.bkc.add(new float[]{f, f2, f3, null, (float) i, f4});
        if (this.bkb.size() > ab.CTRL_BYTE) {
            this.bkb.subList(0, 1).clear();
            this.bkb.trimToSize();
            if (this.bkc.size() > ab.CTRL_BYTE) {
                this.bkc.subList(0, 1).clear();
                this.bkc.trimToSize();
            }
        }
    }

    final boolean a(double d, double d2, double d3, float f, double d4, double d5, double d6, long j) {
        if (f < y.bmV) {
            return false;
        }
        if (j - this.bjZ < 1000 && f <= this.bka) {
            return false;
        }
        z a = z.a(null);
        a.execute(new b(this, d, d2, d3, (double) f, d4, d5, d6, (double) j, (byte) 0));
        this.bjZ = j;
        this.bka = f;
        return true;
    }

    final synchronized void b(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        Object obj;
        int size = this.bkd.size();
        int size2 = this.bkb.size();
        if (size <= 0) {
            this.bkd.add(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8});
            obj = 1;
        } else {
            Object obj2 = (double[]) this.bkd.get(size - 1);
            float[] fArr;
            if (d8 - obj2[8] >= 30000.0d) {
                fArr = new float[1];
                Location.distanceBetween(obj2[0], obj2[1], d, d2, fArr);
                if (fArr[0] >= 30.0f) {
                    this.bkd.add(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8});
                    obj = 1;
                    if (size >= 8) {
                        this.bkd.subList(0, 1).clear();
                        this.bkd.trimToSize();
                    }
                    try {
                        aB(false);
                    } catch (Exception e) {
                    }
                }
            } else if (d4 >= obj2[3]) {
                fArr = new float[]{30.0f};
                if (size > 1) {
                    double[] dArr = (double[]) this.bkd.get(size - 2);
                    Location.distanceBetween(dArr[0], dArr[1], d, d2, fArr);
                }
                if (fArr[0] >= 30.0f) {
                    System.arraycopy(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8}, 0, obj2, 0, obj2.length);
                    obj = 1;
                }
            }
            obj = null;
        }
        if (obj != null) {
            int size3 = this.bkd.size();
            d(new e(size3));
            if (size3 == 1) {
                sO();
            }
        }
    }
}
