package com.d.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.SystemClock;
import com.d.a.a.r.c;
import com.d.a.a.r.e;
import com.d.a.a.s.a;
import java.lang.reflect.Array;
import java.util.List;

class n extends b {
    private final e biP = new e(this, (byte) 0);
    final j biQ = new j();
    private final d biR = new d();
    private final i biS;
    final s biT;
    private long biU;
    private long biV;
    private long biW;
    private int biX;
    private long biY;
    private boolean biZ;
    private Location bja;
    private int bjb;
    private float bjc;
    private float bjd;
    private float bje;
    private int bjf;
    private int bjg;
    private long bjh;

    private static class d {
        private String bjn;
        private long bjo;
        private String bjp;
        private long bjq;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        final synchronized String a(String str, long j, boolean z) {
            String str2;
            if (z) {
                if (this.bjn != null && g(j, this.bjo)) {
                    str = new StringBuilder(String.valueOf(str)).append(this.bjn).toString();
                    this.bjn = null;
                }
                str2 = str;
                if (this.bjp != null && g(j, this.bjq)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(this.bjp).toString();
                    this.bjp = null;
                }
            } else {
                if (this.bjn != null && g(j, this.bjo)) {
                    str = new StringBuilder(String.valueOf(str)).append(v.bO(this.bjn)).toString();
                    this.bjn = null;
                }
                str2 = str;
                if (this.bjp != null && g(j, this.bjq)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(v.bN(this.bjp)).toString();
                    this.bjp = null;
                }
            }
            return str2;
        }

        final synchronized void d(String str, long j) {
            this.bjn = str;
            this.bjo = j;
        }

        final synchronized void e(String str, long j) {
            this.bjp = str;
            this.bjq = j;
        }

        final synchronized void reset() {
            this.bjn = null;
            this.bjp = null;
            this.bjo = 0;
            this.bjq = 0;
        }

        static boolean g(long j, long j2) {
            return Math.abs(j - j2) <= 10000;
        }
    }

    n() {
        if (i.bho == null) {
            i.bho = new i();
        }
        this.biS = i.bho;
        this.biZ = true;
        this.biT = new s(this);
    }

    private boolean a(long j, int i, double d, double d2, double d3, float f, int i2, float f2) {
        boolean z;
        long j2 = j / 1000;
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d2);
        if (this.biZ) {
            this.biQ.a(j2, toRadians, toRadians2, f, this.biP.bjs, y.bmQ);
            this.biZ = false;
            z = true;
        } else {
            z = false;
        }
        j$a j_a = new j$a(i, (double) j2, toRadians, toRadians2, d3, (double) f, i2, (double) f2, 0, 0.0d, 0.0d);
        this.biQ.a(j_a);
        if (y.bmK) {
            o.q("filter_input_log_" + y.bmR, j_a.toString());
        }
        return z;
    }

    final void sz() {
        this.biZ = true;
        this.bja = null;
        this.bjb = 0;
    }

    final void a(List<ScanResult> list, long j, long j2) {
        long ai = aa.ai(j);
        boolean z = this.biV == 0 || j2 - this.biV >= this.biU;
        String a = v.a(list, z);
        String a2 = this.biR.a(a, j2, z);
        if (z) {
            r sC = r.sC();
            int i = this.bjg;
            if (a2 != null) {
                long currentTimeMillis;
                if (sC.bgH) {
                    if (sC.sE()) {
                        currentTimeMillis = System.currentTimeMillis();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (sC.bjG != null) {
                            sC.bjG.execute(new e(sC, a2, currentTimeMillis, elapsedRealtime, i, (byte) 0));
                        }
                    } else {
                        sC.sD();
                    }
                }
                currentTimeMillis = aa.ai(System.currentTimeMillis());
                if (sC.bjG != null) {
                    sC.bjG.execute(new c(sC, a2, currentTimeMillis, 0, (byte) 0));
                }
            }
        } else {
            r.sC().bJ(v.a(a2, ai, "0"));
        }
        if (d.g(j2, this.biW)) {
            String str;
            if (z) {
                str = null;
            } else {
                str = a;
            }
            if (str == null) {
                str = v.a(list, false);
            }
            String a3 = v.a(str, ai, "2");
            s sVar = this.biT;
            float f = this.bjc;
            float f2 = this.bjd;
            float f3 = this.bje;
            float f4 = (float) this.bjf;
            int i2 = this.biX;
            if (sVar.bka != 0.0f) {
                z.a(null).execute(new a(sVar, f, f2, f3, f4, i2, a3, (byte) 0));
            }
        }
    }

    void a(x xVar, long j, long j2) {
        this.biV = xVar.bjU;
        this.biX = xVar.level;
        this.biY = xVar.bjk;
        if (xVar.bmw.equals("W")) {
            if (a(j2, 2, xVar.latitude, xVar.longitude, xVar.altitude, xVar.biF, xVar.bmB, xVar.aex)) {
                this.biS.a(xVar.latitude, xVar.longitude, xVar.biF, this.bjc, this.bjd, this.bje);
            }
        }
        if (!u.sT().bkT) {
            c(new a(xVar.latitude, xVar.longitude, Float.valueOf(xVar.biF).intValue(), this.biX, this.biY));
        }
    }

    final void a(float f, float f2, int i, float f3, float f4, float f5, long j) {
        Object obj;
        e eVar = this.biP;
        if (j - eVar.bjr > 5000) {
            eVar.aA(false);
        }
        if (j - this.biW > 5000) {
            sA();
        }
        this.bjc = f;
        this.bjd = f2;
        this.bje = f4;
        this.bjf = i;
        this.biW = j;
        int i2 = f5 > 0.0f ? 1 : 0;
        this.bjg = i2;
        if (this.biV != 0 || j - this.bjh >= 30000) {
            boolean z = i2 == 0;
            if (!(z && this.biP.bjs)) {
                ab.sZ().az(z);
                k.sy().az(z);
            }
        }
        double[] dArr = new double[2];
        i iVar = this.biS;
        double[] dArr2 = new double[]{(double) f, (double) f2};
        if (iVar.bhx) {
            dArr[0] = iVar.bhp;
            dArr[1] = iVar.bhq;
            dArr[0] = dArr[0] + ((1.0E-5d * (dArr2[1] - ((double) iVar.bhs))) / ((double) iVar.bhv));
            dArr[1] = dArr[1] + ((1.0E-5d * (dArr2[0] - ((double) iVar.bhr))) / ((double) iVar.bhw));
            if (dArr[0] > 90.0d) {
                dArr[0] = 180.0d - dArr[0];
            } else if (dArr[0] < -90.0d) {
                dArr[0] = -180.0d - dArr[0];
            }
            if (dArr[1] > 180.0d) {
                dArr[1] = dArr[1] - 360.0d;
            } else if (dArr[1] < -180.0d) {
                dArr[1] = dArr[1] + 360.0d;
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            double d = dArr[0];
            double d2 = dArr[1];
            iVar = this.biS;
            float f6 = ((f4 - iVar.bht) / 10.0f) + iVar.bhu;
            float f7 = 0.0f;
            Location location = new Location("S");
            location.setLatitude(d);
            location.setLongitude(d2);
            if (this.bja != null) {
                f7 = this.bja.bearingTo(location);
            }
            this.bja = location;
            int max = Math.max(0, i - this.bjb);
            this.bjb = i;
            j$a j_a = new j$a(3, (double) (j / 1000), Math.toRadians(d), Math.toRadians(d2), 0.0d, (double) f6, 0, (double) f5, max, (double) f3, Math.toRadians((double) f7));
            this.biQ.a(j_a);
            if (y.bmK) {
                o.q("filter_input_log_" + y.bmR, j_a.toString());
            }
            double[] dArr3 = new double[4];
            long j2 = j / 1000;
            double[] dArr4 = new double[2];
            double[] dArr5 = new double[2];
            double[] dArr6 = new double[2];
            double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
            double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
            j jVar = this.biQ;
            d = ((double) j2) - jVar.bhz.bhB;
            double d3 = d * d;
            double[] dArr9 = new double[2];
            dArr4[0] = jVar.bhz.bik[0] + (jVar.bhz.bik[2] * d);
            dArr4[1] = (d * jVar.bhz.bik[3]) + jVar.bhz.bik[1];
            dArr6[0] = jVar.bhz.bik[2];
            dArr6[1] = jVar.bhz.bik[3];
            if (jVar.bhz.bhS) {
                dArr9[0] = dArr4[0] - jVar.bhz.bhT[0];
                dArr9[1] = dArr4[1] - jVar.bhz.bhT[1];
                d = Math.sqrt((dArr9[0] * dArr9[0]) + (dArr9[1] * dArr9[1]));
                d = (d * d) * jVar.bhz.bin;
            } else {
                d = 0.0d;
            }
            dArr7[0][0] = (jVar.bhz.bil[0][0] + (jVar.bhz.bil[2][2] * d3)) + d;
            dArr7[0][1] = jVar.bhz.bil[0][1] + (jVar.bhz.bil[2][3] * d3);
            dArr7[1][0] = jVar.bhz.bil[1][0] + (jVar.bhz.bil[3][2] * d3);
            dArr7[1][1] = d + ((d3 * jVar.bhz.bil[3][3]) + jVar.bhz.bil[1][1]);
            dArr8[0][0] = jVar.bhz.bil[2][2];
            dArr8[0][1] = jVar.bhz.bil[2][3];
            dArr8[1][0] = jVar.bhz.bil[3][2];
            dArr8[1][1] = jVar.bhz.bil[3][3];
            jVar.a(1, dArr4, dArr5);
            dArr3[0] = Math.toDegrees(dArr5[0]);
            dArr3[1] = Math.toDegrees(dArr5[1]);
            dArr3[2] = Math.sqrt((dArr7[0][0] + dArr7[1][1]) / 2.0d);
            dArr3[3] = Math.sqrt((dArr6[0] * dArr6[0]) + (dArr6[1] * dArr6[1]));
            if (y.bmK) {
                o.q("filter_output_log_" + y.bmR, String.valueOf(j2) + ',' + dArr3[0] + ',' + dArr3[1] + ',' + dArr3[2] + ',' + dArr3[3]);
            }
            d = dArr3[0];
            double d4 = dArr3[1];
            int intValue = Double.valueOf(dArr3[2]).intValue();
            this.biR.e(!v.e(d, d4) ? "" : "&SD=" + d + ',' + d4 + ',' + 0 + ',' + intValue + ',' + this.biX + ',' + 0 + ',' + Double.valueOf(dArr3[3]).intValue() + ',' + 0 + ',' + 0 + ',' + 0, j);
            c(new a(d, d4, intValue, this.biX, this.biY));
        }
    }

    final void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2) {
        if (i2 > 0) {
            e eVar = this.biP;
            if (i3 >= 3) {
                if (j2 - eVar.bjr <= 5000) {
                    eVar.aA(true);
                }
                eVar.bjr = j2;
            }
            this.biR.d(!v.e(d, d2) ? "" : "&GD=" + d + ',' + d2 + ',' + i + ',' + i3 + ',' + i5 + ',' + i2 + ',' + Math.round(f) + ',' + j + ',', j2);
            if (a(j2, 1, d, d2, (double) i, (float) i2, i5, (float) i3)) {
                this.biS.a(d, d2, (float) i2, this.bjc, this.bjd, this.bje);
            }
            if (d.g(j2, this.biW)) {
                this.biT.a(d, d2, (double) i2, f, (double) this.bjc, (double) this.bjd, (double) this.bje, j2);
            }
            if (y.bmK) {
                o.q("gps_log_" + y.bmR, String.valueOf(d) + ',' + d2 + ',' + i + ',' + i2 + ',' + i3 + ',' + i4 + ',' + i5 + ',' + f + ',' + j);
            }
        }
    }

    void a(int i, String str, long j, long j2) {
        c(new b(i, str, (byte) 0));
        if (i == -4 || i == -5) {
            stop();
        }
    }

    synchronized void a(Handler handler, d.a aVar) {
        c cVar;
        if (aVar instanceof c) {
            cVar = (c) aVar;
        } else {
            cVar = new c(aVar != null ? aVar.bgK : 5000, 9000);
        }
        this.biU = cVar.bjm;
        sA();
        this.biT.bkf = handler;
        this.bjh = SystemClock.elapsedRealtime();
        super.a(handler, cVar);
    }

    final synchronized void stop() {
        this.biT.sK();
        super.stop();
    }

    private void sA() {
        this.biS.bhx = false;
        this.biT.sM();
        this.biR.reset();
        this.biP.reset();
        sz();
        this.biV = 0;
        this.biW = SystemClock.elapsedRealtime();
        this.bjc = 0.0f;
        this.bjd = 0.0f;
        this.bje = 0.0f;
        this.bjf = 0;
        this.bjg = 0;
        this.biX = 0;
    }

    final k.a a(d.a aVar) {
        return new k.a(0);
    }
}
