package com.d.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import com.d.a.a.d.a;
import java.lang.reflect.Array;

final class u extends d implements SensorEventListener {
    private static u bkS;
    private static final int bky;
    private static final int bkz;
    private SensorManager bgR = null;
    private Sensor bkA;
    private Sensor bkB;
    private Sensor bkC;
    private Sensor bkD;
    private Sensor bkE = null;
    private long bkF = 0;
    private boolean bkG = true;
    private float[][] bkH = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bkI = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bkJ = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bkK = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkL = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkM = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkN = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[] bkO = new float[4];
    private float[][] bkP = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkQ = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkR = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    boolean bkT;
    private c bkU;
    private boolean[] bkV = new boolean[6];
    private int[] bkW = new int[6];
    private float[] bkX = new float[6];
    private float[] bkY = new float[6];
    private float[] bkZ = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    private float[][] bla = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20}));
    private final d blb = new d((byte) 0);
    private final f blc = new f(this, (byte) 0);
    private final a bld = new a((byte) 0);

    static {
        int round = Math.round(50000.0f);
        bky = round;
        bkz = round;
    }

    static u sT() {
        if (bkS == null) {
            bkS = new u();
        }
        return bkS;
    }

    private u() {
    }

    private static void a(float[][] fArr, float[][] fArr2) {
        for (int i = 0; i <= 5; i++) {
            SensorManager.getOrientation(fArr[i], fArr2[i]);
        }
    }

    private static float[] b(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[6]), ((fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4])) + (fArr[2] * fArr2[7]), ((fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5])) + (fArr[2] * fArr2[8]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3])) + (fArr[5] * fArr2[6]), ((fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4])) + (fArr[5] * fArr2[7]), ((fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5])) + (fArr[5] * fArr2[8]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3])) + (fArr[8] * fArr2[6]), ((fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4])) + (fArr[8] * fArr2[7]), ((fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5])) + (fArr[8] * fArr2[8])};
    }

    final void aw(Context context) {
    }

    final void a(Context context, Handler handler, a aVar) {
        if (context == null) {
            try {
                throw new Exception("SensorModule: register with null context");
            } catch (Exception e) {
                this.bkT = false;
                return;
            }
        }
        boolean a;
        for (int i = 0; i <= 5; i++) {
            this.bkI[i][0] = 1.0f;
            this.bkI[i][1] = 0.0f;
            this.bkI[i][2] = 0.0f;
            this.bkI[i][3] = 0.0f;
            this.bkI[i][4] = 1.0f;
            this.bkI[i][5] = 0.0f;
            this.bkI[i][6] = 0.0f;
            this.bkI[i][7] = 0.0f;
            this.bkI[i][8] = 1.0f;
        }
        this.bgR = (SensorManager) context.getSystemService("sensor");
        this.bkA = this.bgR.getDefaultSensor(10);
        this.bkD = this.bgR.getDefaultSensor(9);
        if (!(this.bkA == null || this.bkD == null)) {
            this.bkE = this.bgR.getDefaultSensor(11);
            if (this.bkE != null) {
                a = a(this.bgR, this, bky, bkz, handler, this.bkA, this.bkD, this.bkE);
            } else {
                this.bkB = this.bgR.getDefaultSensor(4);
                this.bkC = this.bgR.getDefaultSensor(2);
                if (!(this.bkB == null || this.bkC == null)) {
                    a = a(this.bgR, this, bky, bkz, handler, this.bkA, this.bkD, this.bkB, this.bkC);
                }
            }
            if (a) {
                this.bkT = true;
                this.bkU = new c(this, handler);
                if (this.bkU != null) {
                    this.bkU.f((long) Math.round(50.0f), 1000);
                }
            }
        }
        a = false;
        if (a) {
            this.bkT = true;
            this.bkU = new c(this, handler);
            if (this.bkU != null) {
                this.bkU.f((long) Math.round(50.0f), 1000);
            }
        }
    }

    final void ax(Context context) {
        if (this.bkU != null) {
            this.bkU.stop();
        }
        if (this.bgR != null) {
            try {
                this.bgR.unregisterListener(this);
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
        this.bgR = null;
        this.bkE = null;
        this.bkD = null;
        this.bkC = null;
        this.bkB = null;
        this.bkA = null;
        this.bkF = 0;
        this.bkG = true;
        this.bkH = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.bkI = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.bkK = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bkL = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bkM = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bkV = new boolean[6];
        this.bkW = new int[6];
        this.bkX = new float[6];
        this.bkY = new float[6];
        this.bkZ = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        this.bla = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20});
        this.bld.reset();
        this.blb.reset();
        this.blc.reset();
    }

    final void sr() {
    }

    final synchronized void a(Handler handler, a aVar) {
        super.a(handler, aVar);
    }

    static /* synthetic */ void b(u uVar) {
        a sW = uVar.blc.sW();
        if (sW != null) {
            uVar.c(new e(sW.x, sW.y, sW.bmk, sW.bml, sW.bmm, sW.bmn, (byte) 0));
        }
    }

    @TargetApi(19)
    private static boolean a(SensorManager sensorManager, SensorEventListener sensorEventListener, int i, int i2, Handler handler, Sensor... sensorArr) {
        try {
            Object obj = VERSION.SDK_INT >= 19 ? 1 : null;
            int length = sensorArr.length;
            int i3 = 0;
            while (i3 < length) {
                Sensor sensor = sensorArr[i3];
                if (obj != null ? sensorManager.registerListener(sensorEventListener, sensor, i, i2, handler) : sensorManager.registerListener(sensorEventListener, sensor, i, handler)) {
                    i3++;
                } else {
                    sensorManager.unregisterListener(sensorEventListener);
                    return false;
                }
            }
            return true;
        } catch (Error e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    static /* synthetic */ void a(u uVar) {
        if (uVar.bkA != null && uVar.bkB != null && uVar.bkC != null && uVar.bkD != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 > 5) {
                    break;
                }
                float f;
                float[] fArr;
                float[] fArr2;
                float f2;
                float f3;
                float abs;
                Object obj = null;
                if (Float.isNaN(uVar.bkZ[i2])) {
                    uVar.bkZ[i2] = uVar.bkL[i2][0];
                } else {
                    f = uVar.bkL[i2][0] - uVar.bkM[i2][0];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    fArr = uVar.bla[i2];
                    int[] iArr = uVar.bkW;
                    int i3 = iArr[i2];
                    iArr[i2] = i3 + 1;
                    fArr[i3] = f;
                    if (uVar.bkW[i2] == 20) {
                        uVar.bkW[i2] = 0;
                        if (!uVar.bkV[i2]) {
                            uVar.bkV[i2] = true;
                        }
                    }
                    fArr = uVar.bkY;
                    fArr[i2] = fArr[i2] + f;
                    fArr = uVar.bkX;
                    fArr[i2] = f + fArr[i2];
                    if (uVar.bkV[i2]) {
                        Object obj2;
                        if (Math.abs(uVar.bkX[i2]) < 0.08726647f) {
                            if (Math.abs(uVar.bkY[i2]) < 0.08726647f) {
                                f = uVar.bkL[i2][0] - uVar.bkZ[i2];
                                if (f < -3.1415927f) {
                                    f += 6.2831855f;
                                } else if (f > 3.1415927f) {
                                    f -= 6.2831855f;
                                }
                                uVar.bkL[i2][0] = (f / 2.0f) + uVar.bkZ[i2];
                                if (uVar.bkL[i2][0] < -3.1415927f) {
                                    uVar.bkL[i2][0] = 6.2831855f + uVar.bkL[i2][0];
                                } else if (uVar.bkL[i2][0] > 3.1415927f) {
                                    uVar.bkL[i2][0] = uVar.bkL[i2][0] - 6.2831855f;
                                }
                                uVar.bkZ[i2] = uVar.bkL[i2][0];
                                obj2 = 1;
                                fArr2 = uVar.bkX;
                                fArr2[i2] = fArr2[i2] - uVar.bla[i2][uVar.bkW[i2]];
                                obj = obj2;
                            } else {
                                f = uVar.bkY[i2] % 1.5707964f;
                                float abs2 = Math.abs(f);
                                if (abs2 < 0.08726647f) {
                                    fArr = uVar.bkY;
                                    fArr[i2] = fArr[i2] - f;
                                    uVar.bkZ[i2] = (uVar.bkZ[i2] + uVar.bkY[i2]) % 6.2831855f;
                                    if (uVar.bkZ[i2] < -3.1415927f) {
                                        uVar.bkZ[i2] = 6.2831855f + uVar.bkZ[i2];
                                    } else if (uVar.bkZ[i2] > 3.1415927f) {
                                        uVar.bkZ[i2] = uVar.bkZ[i2] - 6.2831855f;
                                    }
                                } else if (abs2 > 1.4835299f) {
                                    if (uVar.bkY[i2] > 0.0f) {
                                        uVar.bkY[i2] = (uVar.bkY[i2] - f) + 1.5707964f;
                                    } else {
                                        uVar.bkY[i2] = (uVar.bkY[i2] - f) - 1.5707964f;
                                    }
                                    uVar.bkZ[i2] = (uVar.bkZ[i2] + uVar.bkY[i2]) % 6.2831855f;
                                    if (uVar.bkZ[i2] < -3.1415927f) {
                                        uVar.bkZ[i2] = 6.2831855f + uVar.bkZ[i2];
                                    } else if (uVar.bkZ[i2] > 3.1415927f) {
                                        uVar.bkZ[i2] = uVar.bkZ[i2] - 6.2831855f;
                                    }
                                } else {
                                    uVar.bkZ[i2] = uVar.bkL[i2][0];
                                }
                                uVar.bkY[i2] = 0.0f;
                            }
                        }
                        obj2 = null;
                        fArr2 = uVar.bkX;
                        fArr2[i2] = fArr2[i2] - uVar.bla[i2][uVar.bkW[i2]];
                        obj = obj2;
                    }
                }
                a aVar = uVar.bld;
                float[] fArr3 = uVar.bkL[i2];
                float[] fArr4 = uVar.bkK[i2];
                float[] fArr5 = uVar.bkM[i2];
                if (i2 == 0 && aVar.ble != 0) {
                    aVar.blg++;
                    aVar.blt = aVar.blf / ((float) aVar.ble);
                    f2 = aVar.blt - aVar.blh;
                    f = Math.abs(f2);
                    f3 = aVar.blh;
                    f = (aVar.blh == 0.0f || aVar.blg <= 20 || f <= 1.25f) ? 1.0f : 1.25f / f;
                    aVar.blh = (f * (f2 / ((float) aVar.blg))) + f3;
                    aVar.bli = Math.abs(aVar.blt - aVar.blh) >= 1.25f;
                    if (aVar.bli) {
                        if (aVar.blj < 1200) {
                            aVar.blj++;
                        }
                    } else if (aVar.blj > 0) {
                        aVar.blj--;
                    }
                    aVar.ble = 0;
                    aVar.blf = 0.0f;
                    if (aVar.blt < aVar.blv) {
                        aVar.blv = aVar.blt;
                    }
                    if (aVar.blt > aVar.blu) {
                        aVar.blu = aVar.blt;
                    }
                    if (aVar.blg == 20 && Math.max(aVar.blu - aVar.blh, aVar.blh - aVar.blv) > 5.0f) {
                        aVar.reset();
                    }
                }
                float[] fArr6;
                if (aVar.blg <= 20) {
                    fArr6 = aVar.blq;
                    fArr2 = aVar.blr;
                    aVar.bls[i2] = 1.0f;
                    fArr2[i2] = 1.0f;
                    fArr6[i2] = 1.0f;
                    fArr6 = aVar.bln;
                    fArr2 = aVar.blo;
                    aVar.blp[i2] = 0.0f;
                    fArr2[i2] = 0.0f;
                    fArr6[i2] = 0.0f;
                } else if (aVar.bli || aVar.blw || obj != null) {
                    fArr6 = aVar.bln;
                    fArr2 = aVar.blo;
                    aVar.blp[i2] = 1.0f;
                    fArr2[i2] = 1.0f;
                    fArr6[i2] = 1.0f;
                    fArr6 = aVar.blq;
                    fArr2 = aVar.blr;
                    aVar.bls[i2] = 0.0f;
                    fArr2[i2] = 0.0f;
                    fArr6[i2] = 0.0f;
                } else {
                    if (aVar.blj > 0) {
                        aVar.blk[i2] = fArr5[0];
                        aVar.bll[i2] = fArr5[1];
                        aVar.blm[i2] = fArr5[2];
                    }
                    f = Math.abs(fArr5[0] - fArr3[0]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.blk[i2] - fArr4[0]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    aVar.bln[i2] = ((f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f) + aVar.bln[i2]) / 2.0f;
                    aVar.blq[i2] = 1.0f - aVar.bln[i2];
                    f = Math.abs(fArr5[1] - fArr3[1]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.bll[i2] - fArr4[1]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    aVar.blo[i2] = ((f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f) + aVar.blo[i2]) / 2.0f;
                    aVar.blr[i2] = 1.0f - aVar.blo[i2];
                    f = Math.abs(fArr5[2] - fArr3[2]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.blm[i2] - fArr4[2]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    float max = Math.max(abs, f);
                    aVar.blp[i2] = ((max != 0.0f ? (((abs - f) / max) + 1.0f) * 0.5f : 1.0f) + aVar.blp[i2]) / 2.0f;
                    aVar.bls[i2] = 1.0f - aVar.blp[i2];
                }
                aVar.blk[i2] = fArr4[0];
                aVar.bll[i2] = fArr4[1];
                aVar.blm[i2] = fArr4[2];
                f = uVar.bkK[i2][0] - uVar.bkL[i2][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bld.blq[i2]) + uVar.bkL[i2][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bkM[i2][0] = f;
                f = uVar.bkK[i2][1] - uVar.bkL[i2][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bld.blr[i2]) + uVar.bkL[i2][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bkM[i2][1] = f;
                f = uVar.bkK[i2][2] - uVar.bkL[i2][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bld.bls[i2]) + uVar.bkL[i2][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bkM[i2][2] = f;
                float[][] fArr7 = uVar.bkI;
                fArr2 = uVar.bkM[i2];
                fArr = new float[9];
                fArr3 = new float[9];
                fArr4 = new float[9];
                float sin = (float) Math.sin((double) fArr2[1]);
                f2 = (float) Math.cos((double) fArr2[1]);
                f3 = (float) Math.sin((double) fArr2[2]);
                float cos = (float) Math.cos((double) fArr2[2]);
                float sin2 = (float) Math.sin((double) fArr2[0]);
                abs = (float) Math.cos((double) fArr2[0]);
                fArr[0] = 1.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = f2;
                fArr[5] = sin;
                fArr[6] = 0.0f;
                fArr[7] = -sin;
                fArr[8] = f2;
                fArr3[0] = cos;
                fArr3[1] = 0.0f;
                fArr3[2] = f3;
                fArr3[3] = 0.0f;
                fArr3[4] = 1.0f;
                fArr3[5] = 0.0f;
                fArr3[6] = -f3;
                fArr3[7] = 0.0f;
                fArr3[8] = cos;
                fArr4[0] = abs;
                fArr4[1] = sin2;
                fArr4[2] = 0.0f;
                fArr4[3] = -sin2;
                fArr4[4] = abs;
                fArr4[5] = 0.0f;
                fArr4[6] = 0.0f;
                fArr4[7] = 0.0f;
                fArr4[8] = 1.0f;
                fArr7[i2] = b(fArr4, b(fArr, fArr3));
                System.arraycopy(uVar.bkM[i2], 0, uVar.bkL[i2], 0, 3);
                i = i2 + 1;
            }
        }
        b a = uVar.blb.a(uVar.bkE != null ? uVar.bkN : uVar.bkM);
        if (a != null) {
            uVar.blc.a(a);
        }
    }

    private static void a(float[] fArr, float[][] fArr2) {
        fArr2[0][0] = -fArr[1];
        fArr2[0][1] = fArr[0];
        fArr2[0][2] = fArr[2];
        fArr2[1][0] = fArr[1];
        fArr2[1][1] = -fArr[0];
        fArr2[1][2] = fArr[2];
        System.arraycopy(fArr, 0, fArr2[2], 0, 3);
        fArr2[3][0] = -fArr[0];
        fArr2[3][1] = -fArr[1];
        fArr2[3][2] = fArr[2];
        fArr2[4][0] = fArr[0];
        fArr2[4][1] = fArr[2];
        fArr2[4][2] = -fArr[1];
        fArr2[5][0] = fArr[0];
        fArr2[5][1] = -fArr[2];
        fArr2[5][2] = fArr[1];
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        float[] fArr;
        int i2;
        float[][] fArr2;
        switch (sensorEvent.sensor.getType()) {
            case 2:
                a(sensorEvent.values, this.bkQ);
                a aVar = this.bld;
                fArr = sensorEvent.values;
                if (fArr.length >= 3) {
                    aVar.ble++;
                    aVar.blf = (float) (Math.sqrt((double) (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2]))) + ((double) aVar.blf));
                    return;
                }
                return;
            case 4:
                if (this.bkK[2][0] != 0.0f || this.bkK[2][1] != 0.0f || this.bkK[2][2] != 0.0f) {
                    if (this.bkG) {
                        for (i2 = 0; i2 <= 5; i2++) {
                            this.bkI[i2] = b(this.bkI[i2], this.bkH[i2]);
                        }
                        this.bkG = false;
                    }
                    fArr2 = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 4});
                    if (this.bkF != 0) {
                        float f = 1.0E-9f * ((float) (sensorEvent.timestamp - this.bkF));
                        a(sensorEvent.values, this.bkP);
                        for (int i3 = 0; i3 <= 5; i3++) {
                            float[] fArr3 = this.bkP[i3];
                            float[] fArr4 = fArr2[i3];
                            float f2 = f / 2.0f;
                            float[] fArr5 = new float[3];
                            float sqrt = (float) Math.sqrt((double) (((fArr3[0] * fArr3[0]) + (fArr3[1] * fArr3[1])) + (fArr3[2] * fArr3[2])));
                            if (sqrt > 1.0E-9f) {
                                fArr5[0] = fArr3[0] / sqrt;
                                fArr5[1] = fArr3[1] / sqrt;
                                fArr5[2] = fArr3[2] / sqrt;
                            }
                            float f3 = sqrt * f2;
                            f2 = (float) Math.sin((double) f3);
                            f3 = (float) Math.cos((double) f3);
                            fArr4[0] = fArr5[0] * f2;
                            fArr4[1] = fArr5[1] * f2;
                            fArr4[2] = f2 * fArr5[2];
                            fArr4[3] = f3;
                        }
                    }
                    this.bkF = sensorEvent.timestamp;
                    while (i <= 5) {
                        fArr = new float[9];
                        try {
                            SensorManager.getRotationMatrixFromVector(fArr, fArr2[i]);
                        } catch (Exception e) {
                        }
                        this.bkI[i] = b(this.bkI[i], fArr);
                        i++;
                    }
                    a(this.bkI, this.bkL);
                    return;
                }
                return;
            case 9:
                a(sensorEvent.values, this.bkR);
                if (this.bkQ[2][0] != 0.0f || this.bkQ[2][1] != 0.0f || this.bkQ[2][2] != 0.0f) {
                    fArr2 = this.bkH;
                    float[][] fArr6 = this.bkR;
                    float[][] fArr7 = this.bkQ;
                    i2 = (SensorManager.getRotationMatrix(fArr2[0], null, fArr6[0], fArr7[0]) && SensorManager.getRotationMatrix(fArr2[1], null, fArr6[1], fArr7[1]) && SensorManager.getRotationMatrix(fArr2[2], null, fArr6[2], fArr7[2]) && SensorManager.getRotationMatrix(fArr2[3], null, fArr6[3], fArr7[3]) && SensorManager.getRotationMatrix(fArr2[4], null, fArr6[4], fArr7[4]) && SensorManager.getRotationMatrix(fArr2[5], null, fArr6[5], fArr7[5])) ? 1 : 0;
                    if (i2 != 0) {
                        a(this.bkH, this.bkK);
                        if (this.bkL[2][0] == 0.0f && this.bkL[2][1] == 0.0f && this.bkL[2][2] == 0.0f) {
                            fArr6 = this.bkK;
                            float[][] fArr8 = this.bkL;
                            for (i2 = 0; i2 <= 5; i2++) {
                                System.arraycopy(fArr6[i2], 0, fArr8[i2], 0, 3);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 10:
                fArr = new float[16];
                float[] fArr9 = (this.bkE != null ? this.bkJ : this.bkI)[2];
                float[] fArr10 = new float[16];
                if (fArr9.length == 9) {
                    fArr10[0] = fArr9[0];
                    fArr10[1] = fArr9[1];
                    fArr10[2] = fArr9[2];
                    fArr10[3] = 0.0f;
                    fArr10[4] = fArr9[3];
                    fArr10[5] = fArr9[4];
                    fArr10[6] = fArr9[5];
                    fArr10[7] = 0.0f;
                    fArr10[8] = fArr9[6];
                    fArr10[9] = fArr9[7];
                    fArr10[10] = fArr9[8];
                    fArr10[11] = 0.0f;
                    fArr10[12] = 0.0f;
                    fArr10[13] = 0.0f;
                    fArr10[14] = 0.0f;
                    fArr10[15] = 1.0f;
                }
                Matrix.invertM(fArr, 0, fArr10, 0);
                Matrix.multiplyMV(this.bkO, 0, fArr, 0, new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], 0.0f}, 0);
                this.blb.a(this.bkO, sensorEvent.values, this.bkR[2]);
                return;
            case 11:
                try {
                    SensorManager.getRotationMatrixFromVector(this.bkJ[2], sensorEvent.values);
                } catch (IllegalArgumentException e2) {
                    if (sensorEvent.values.length > 3) {
                        SensorManager.getRotationMatrixFromVector(this.bkJ[2], new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]});
                    }
                }
                SensorManager.remapCoordinateSystem(this.bkJ[2], 2, 129, this.bkJ[0]);
                SensorManager.remapCoordinateSystem(this.bkJ[2], 130, 1, this.bkJ[1]);
                SensorManager.remapCoordinateSystem(this.bkJ[2], 129, 130, this.bkJ[3]);
                SensorManager.remapCoordinateSystem(this.bkJ[2], 129, 3, this.bkJ[4]);
                SensorManager.remapCoordinateSystem(this.bkJ[2], 1, 3, this.bkJ[5]);
                while (i <= 5) {
                    SensorManager.getOrientation(this.bkJ[i], this.bkN[i]);
                    i++;
                }
                return;
            default:
                return;
        }
    }
}
