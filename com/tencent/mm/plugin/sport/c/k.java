package com.tencent.mm.plugin.sport.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class k implements SensorEventListener {
    private static long opc = 0;
    private static long opd = 0;
    private static long ope = 0;
    private static long opf = 0;
    private static long opg = 0;
    private static long oph = 0;
    private static long opi = 0;
    private static long opj = 0;
    public c opk;

    public static long bFO() {
        return ope;
    }

    public static long bFP() {
        return opg;
    }

    public k() {
        opg = 0;
        oph = 0;
        opi = 0;
        opj = 0;
        opc = 0;
        opd = 0;
        ope = 0;
        opf = 0;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        JSONObject bFJ = g.bFJ();
        if (bFJ.optInt("deviceStepSwitch") != 1) {
            if (this.opk != null) {
                this.opk.bFH();
            }
            x.i("MicroMsg.Sport.SportStepDetector", "device step switch off");
            return;
        }
        int optInt = bFJ.optInt("stepCounterMaxStep5m", 3000);
        String str;
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            x.i("MicroMsg.Sport.SportStepDetector", "Step change %f, accuracy %s, %s", new Object[]{Float.valueOf(sensorEvent.values[0]), Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp)});
            long ciZ = bi.ciZ() / 10000;
            if (opg == 0) {
                opg = i.xS(202);
            }
            if (opd == 0) {
                opd = i.xS(203);
            }
            if (ope == 0) {
                ope = i.xS(201);
            }
            if (opf == 0) {
                opf = ope;
            }
            if (oph == 0) {
                oph = i.xS(204);
            }
            if (opi == 0) {
                opi = oph;
            }
            if (opj == 0) {
                opj = i.xS(209);
            }
            x.i("MicroMsg.Sport.SportStepDetector", "currentVar: beginOfToday %d saveTodayTime %d preSensorStep %d currentTodayStep %d lastSaveSensorStep %d lastSaveStepTime %d preSysStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(ciZ), Long.valueOf(opg), Long.valueOf(opd), Long.valueOf(ope), Long.valueOf(opf), Long.valueOf(oph), Long.valueOf(opi), Long.valueOf(opj)});
            long j = (long) sensorEvent.values[0];
            opc = j;
            if (j >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = sensorEvent.timestamp;
                if (opg != ciZ) {
                    x.i("MicroMsg.Sport.SportStepDetector", "new day beginOfToday: %s saveTodayTime: %s, ", new Object[]{n.bx(10000 * ciZ), n.bx(opg * 10000)});
                    i.N(202, ciZ);
                    i.N(201, 0);
                    i.N(204, currentTimeMillis);
                    i.N(209, sensorEvent.timestamp);
                    i.N(203, (long) ((int) opc));
                    opd = opc;
                    ope = 0;
                    opf = 0;
                    opg = ciZ;
                    oph = currentTimeMillis;
                    opi = currentTimeMillis;
                    opj = j2;
                    return;
                }
                Object obj;
                boolean z;
                j = 0;
                long j3 = ((currentTimeMillis - opi) / 300000) + ((long) ((currentTimeMillis - opi) % 300000 > 0 ? 1 : 0));
                long j4 = (((j2 / 1000000) - (opj / 1000000)) / 300000) + ((long) (((j2 / 1000000) - (opj / 1000000)) % 300000 > 0 ? 1 : 0));
                x.i("MicroMsg.Sport.SportStepDetector", "timesOf5Minute(%d, %d). rebootTime: %d %s", new Object[]{Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(i.xS(205)), n.bx(i.xS(205))});
                boolean z2 = false;
                str = "";
                if (i.xS(205) > oph) {
                    long j5 = opc - opf;
                    if (j5 <= 0 || (j5 >= ((long) optInt) * j4 && j5 >= ((long) optInt) * j3)) {
                        ciZ = 0;
                    } else {
                        str = "rebootIncrease Valid Step diffStep > 0";
                        ciZ = j5;
                    }
                    if (j5 < 0 && (opc < ((long) optInt) * j4 || opc < ((long) optInt) * j3)) {
                        ciZ = opc;
                        str = "rebootIncrease Valid Step diffStep < 0";
                    }
                    i.N(205, 0);
                    j = ciZ;
                    obj = str;
                    z = true;
                } else {
                    if (opc < opd) {
                        x.i("MicroMsg.Sport.SportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[]{Long.valueOf(opc), Long.valueOf(opd), Long.valueOf(opf)});
                        ciZ = opc;
                        opd = ciZ;
                        opf = ciZ;
                        z2 = true;
                    }
                    String obj2;
                    if (opc - opd < j4 * ((long) optInt) || opc - opd < j3 * ((long) optInt)) {
                        j = opc - opd;
                        obj2 = "normalIncrease Valid Step";
                        z = z2;
                    } else {
                        obj2 = str;
                        z = z2;
                    }
                }
                x.i("MicroMsg.Sport.SportStepDetector", "increase step %s %d %b", new Object[]{obj2, Long.valueOf(j), Boolean.valueOf(z)});
                ope += j;
                if (currentTimeMillis - oph > ((long) bFJ.optInt("stepCounterSaveInterval", 60000)) || opc - opf > ((long) bFJ.optInt("stepCounterSaveStep")) || z) {
                    i.N(201, ope);
                    i.N(203, opc);
                    i.N(204, currentTimeMillis);
                    i.N(209, j2);
                    x.i("MicroMsg.Sport.SportStepDetector", "save to [file] currentTodayStep %d lastSaveSensorStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(ope), Long.valueOf(opf), Long.valueOf(opi), Long.valueOf(oph), Long.valueOf(opj)});
                    oph = currentTimeMillis;
                    opf = opc;
                } else {
                    x.i("MicroMsg.Sport.SportStepDetector", "save to cache currentTodayStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(ope), Long.valueOf(opi), Long.valueOf(oph), Long.valueOf(opj)});
                }
                opd = opc;
                opi = currentTimeMillis;
                opj = j2;
            }
        } else if (sensorEvent == null || sensorEvent.values == null) {
            String str2 = "MicroMsg.Sport.SportStepDetector";
            str = "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(sensorEvent == null);
            objArr[1] = Boolean.valueOf(sensorEvent != null);
            x.e(str2, str, objArr);
        } else {
            x.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[]{Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp)});
            int i = 0;
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i2 = 0;
            while (i2 < length) {
                float f = fArr[i2];
                r10 = new Object[2];
                int i3 = i + 1;
                r10[0] = Integer.valueOf(i);
                r10[1] = Float.valueOf(f);
                x.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
                i2++;
                i = i3;
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
