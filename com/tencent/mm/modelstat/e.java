package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.av.b.1;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import junit.framework.Assert;

public class e {
    private static e eiR;
    private int eiS = -1;
    private int eiT = 20000;
    private int eiU = 3000;
    private int eiV = TbsLog.TBSLOG_CODE_SDK_BASE;
    private int eiW = 20;
    private ArrayList<Pair<Float, Float>> eiX = new ArrayList();
    private ArrayList<Pair<Float, Float>> eiY = new ArrayList();
    private long startTime = 0;

    class b {
        long dDj = 0;
        private SensorManager ejl;
        long ejm = 0;
        a ejn = null;
        a ejo = null;
        a ejp = null;
        private Long ejq = null;
        ArrayList<Long> ejr = new ArrayList();
        ArrayList<a> ejs = new ArrayList();
        ArrayList<a> ejt = new ArrayList();
        ArrayList<a> eju = new ArrayList();
        ArrayList<float[]> ejv = new ArrayList();
        private SensorEventListener ejw = new SensorEventListener() {
            public final void onAccuracyChanged(Sensor sensor, int i) {
            }

            public final void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    long VF = bi.VF();
                    if (sensorEvent.sensor.getType() == 1) {
                        b.this.ejn = new a(sensorEvent);
                    } else if (sensorEvent.sensor.getType() == 2) {
                        b.this.ejo = new a(sensorEvent);
                    } else if (sensorEvent.sensor.getType() == 4) {
                        b.this.ejp = new a(sensorEvent);
                    }
                    long j = VF - b.this.dDj;
                    if (b.this.ejn != null && b.this.ejo != null && b.this.ejp != null) {
                        if (j > b.this.ejm || j < 0) {
                            float[] fArr = new float[9];
                            SensorManager.getRotationMatrix(fArr, null, b.this.ejn.values, b.this.ejo.values);
                            Object obj = new float[3];
                            SensorManager.getOrientation(fArr, obj);
                            b.this.dDj = VF;
                            b.this.ejr.add(Long.valueOf(VF));
                            b.this.ejs.add(b.this.ejn);
                            b.this.ejt.add(b.this.ejo);
                            b.this.eju.add(b.this.ejp);
                            b.this.ejv.add(obj);
                            int size = b.this.ejs.size() - 1;
                            x.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[]{Integer.valueOf(b.this.ejs.size()), Integer.valueOf(((a) b.this.ejs.get(size)).accuracy), Float.valueOf(((a) b.this.ejs.get(size)).values[0]), Float.valueOf(((a) b.this.ejs.get(size)).values[1]), Float.valueOf(((a) b.this.ejs.get(size)).values[2])});
                            x.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[]{Long.valueOf(j), Integer.valueOf(b.this.ejn.accuracy), Float.valueOf(b.this.ejn.values[0]), Float.valueOf(b.this.ejn.values[1]), Float.valueOf(b.this.ejn.values[2]), Integer.valueOf(b.this.ejo.accuracy), Float.valueOf(b.this.ejo.values[0]), Float.valueOf(b.this.ejo.values[1]), Float.valueOf(b.this.ejo.values[2]), Integer.valueOf(b.this.ejp.accuracy), Float.valueOf(b.this.ejp.values[0]), Float.valueOf(b.this.ejp.values[1]), Float.valueOf(b.this.ejp.values[2]), Float.valueOf(obj[0]), Float.valueOf(obj[1]), Float.valueOf(obj[2])});
                        }
                    }
                }
            }
        };
        private HandlerThread handlerThread = null;

        b() {
        }

        public final boolean u(Context context, int i) {
            boolean z;
            try {
                if (this.ejl == null) {
                    this.ejl = (SensorManager) context.getSystemService("sensor");
                }
                if (this.handlerThread == null) {
                    this.handlerThread = com.tencent.mm.sdk.f.e.cZ("MicroMsg.IndoorReporter", 1);
                    this.handlerThread.start();
                }
                Handler handler = new Handler(this.handlerThread.getLooper());
                z = this.ejl.registerListener(this.ejw, this.ejl.getDefaultSensor(1), 3, handler) && this.ejl.registerListener(this.ejw, this.ejl.getDefaultSensor(4), 3, handler) && this.ejl.registerListener(this.ejw, this.ejl.getDefaultSensor(2), 3, handler);
            } catch (Exception e) {
                x.e("MicroMsg.IndoorReporter", "start except:%s", new Object[]{e.getMessage()});
                z = false;
            }
            if (!z) {
                try {
                    if (this.ejl != null) {
                        this.ejl.unregisterListener(this.ejw);
                        this.ejl = null;
                    }
                } catch (Exception e2) {
                }
                try {
                    if (this.handlerThread != null) {
                        this.handlerThread.quit();
                        this.handlerThread = null;
                    }
                } catch (Exception e3) {
                }
            }
            this.ejm = (long) i;
            this.ejq = Long.valueOf(bi.VF());
            return z;
        }

        public final String RX() {
            try {
                if (this.ejl != null) {
                    this.ejl.unregisterListener(this.ejw);
                    this.ejl = null;
                }
            } catch (Exception e) {
            }
            try {
                if (this.handlerThread != null) {
                    this.handlerThread.quit();
                    this.handlerThread = null;
                }
            } catch (Exception e2) {
            }
            x.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[]{Integer.valueOf(this.ejr.size())});
            String str = this.ejq + ";" + this.ejr.size() + ";#";
            for (int i = 0; i < this.ejr.size(); i++) {
                str = (str + (((Long) this.ejr.get(i)).longValue() - this.ejq.longValue()) + ";") + a((a) this.ejs.get(i));
                x.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[]{Integer.valueOf(i), Integer.valueOf(((a) this.ejs.get(i)).accuracy), Float.valueOf(((a) this.ejs.get(i)).values[0]), Float.valueOf(((a) this.ejs.get(i)).values[1]), Float.valueOf(((a) this.ejs.get(i)).values[2]), a((a) this.ejs.get(i))});
                str = ((str + a((a) this.eju.get(i))) + a((a) this.ejt.get(i))) + String.format("%.3f;%.3f;%.3f;#", new Object[]{Float.valueOf(((float[]) this.ejv.get(i))[0]), Float.valueOf(((float[]) this.ejv.get(i))[1]), Float.valueOf(((float[]) this.ejv.get(i))[2])});
            }
            x.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[]{Integer.valueOf(str.length()), str});
            return str;
        }

        private static String a(a aVar) {
            try {
                String str = new String();
                return String.format("%d;%.3f;%.3f;%.3f;", new Object[]{Integer.valueOf(aVar.accuracy), Float.valueOf(aVar.values[0]), Float.valueOf(aVar.values[1]), Float.valueOf(aVar.values[2])});
            } catch (Exception e) {
                return "0;0;0;0;";
            }
        }
    }

    static /* synthetic */ boolean z(float f, float f2) {
        return ((double) Math.abs(f - f2)) < Math.pow(0.1d, 2.0d);
    }

    public static e RW() {
        if (eiR == null) {
            synchronized (e.class) {
                if (eiR == null) {
                    eiR = new e();
                }
            }
        }
        return eiR;
    }

    public final void a(int i, boolean z, boolean z2, float f, float f2, int i2) {
        x.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2)});
        if (g.Eg().Dx()) {
            g.Eg();
            if (!a.Dr()) {
                com.tencent.mm.av.b Qv = com.tencent.mm.av.b.Qv();
                String str = "";
                String str2 = "";
                int i3 = z2 ? 1 : 0;
                if (g.Eg().Dx()) {
                    g.Eg();
                    if (!a.Dr()) {
                        g.Ek();
                        g.Em().H(new 1(Qv, i3, f, f2, i, i2, str, str2));
                    }
                }
                if (this.eiY.size() != 0 || this.eiX.size() != 0 || nl(com.tencent.mm.k.g.AT().getValue("AndroidIndoorSensorReport"))) {
                    if (!com.tencent.mm.sdk.a.b.chp()) {
                        g.Eg();
                        int aM = h.aM(a.Df() + 5, 100);
                        if (aM > this.eiS) {
                            r3 = new Object[3];
                            g.Eg();
                            r3[0] = Long.valueOf(new o(a.Df()).longValue());
                            r3[1] = Integer.valueOf(aM);
                            r3[2] = Integer.valueOf(this.eiS);
                            x.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", r3);
                            return;
                        }
                    }
                    g.Ek();
                    g.Em().H(new 1(this, z2, f, f2, i, z, i2));
                }
            }
        }
    }

    public final boolean nl(String str) {
        if (bi.oW(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.eiS = bi.getInt(split[0], -1);
            if (this.eiS > 101) {
                Assert.assertTrue(false);
            }
            this.eiT = bi.getInt(split[1], 20000);
            this.eiU = bi.getInt(split[2], 3000);
            this.eiV = bi.getInt(split[3], TbsLog.TBSLOG_CODE_SDK_BASE);
            this.eiW = bi.getInt(split[4], 20);
            int i = bi.getInt(split[5], 0);
            for (int i2 = 0; i2 < i; i2++) {
                String[] split2 = split[i2 + 6].split(";");
                if ("1".equals(split2[0])) {
                    this.eiX.add(new Pair(Float.valueOf(bi.WX(split2[1])), Float.valueOf(bi.WX(split2[2]))));
                } else {
                    this.eiY.add(new Pair(Float.valueOf(bi.WX(split2[1])), Float.valueOf(bi.WX(split2[2]))));
                }
            }
            x.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[]{Integer.valueOf(this.eiT), Integer.valueOf(this.eiU), Integer.valueOf(this.eiV), Integer.valueOf(this.eiW), Integer.valueOf(i), Integer.valueOf(this.eiX.size()), Integer.valueOf(this.eiY.size())});
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[]{e.getMessage(), str});
            return false;
        }
    }
}
