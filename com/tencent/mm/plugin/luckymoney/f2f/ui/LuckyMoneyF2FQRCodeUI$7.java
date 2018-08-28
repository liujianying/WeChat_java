package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyF2FQRCodeUI$7 implements SensorEventListener {
    float hlo;
    float kOA = ((float) a.ad(ad.getContext(), d.MiddlePadding));
    int kOB;
    ValueAnimator kOC;
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;
    final int kOz = 3;

    LuckyMoneyF2FQRCodeUI$7(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = -3.0f;
        if (sensorEvent.sensor.getType() == 1 && LuckyMoneyF2FQRCodeUI.g(this.kOv) > 0) {
            if (this.kOB == 0) {
                this.kOB = e.cM(this.kOv) + ((int) this.kOA);
            }
            float f2 = sensorEvent.values[1];
            if (((double) Math.abs(f2 - this.hlo)) >= 0.05d) {
                this.hlo = f2;
                x.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[]{Float.valueOf(f2)});
                if (f2 >= -3.0f) {
                    if (f2 > 0.0f) {
                        f = 0.0f;
                    } else {
                        f = f2;
                    }
                }
                f = ((f / 3.0f) * ((float) this.kOB)) + ((float) this.kOB);
                x.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[]{Float.valueOf(f), Integer.valueOf(LuckyMoneyF2FQRCodeUI.N(this.kOv).getPaddingTop())});
                if (this.kOC != null) {
                    this.kOC.cancel();
                }
                this.kOC = ValueAnimator.ofFloat(new float[]{(float) LuckyMoneyF2FQRCodeUI.N(this.kOv).getPaddingTop(), f}).setDuration(200);
                this.kOC.addUpdateListener(new 1(this));
                this.kOC.start();
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
        x.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
    }
}
