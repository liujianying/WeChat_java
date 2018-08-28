package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class u extends i implements SensorEventListener {
    ImageView bOA;
    private SensorManager bgR;
    Sensor bkA;
    Sensor bkC;
    ProgressBar eVR;
    int nFm;
    final float nFn = 10.0f;
    final int nFo = 1;
    HorizontalScrollView nFp;
    float[] nFq;
    float[] nFr;
    private int nFs = 0;
    boolean nFt = true;

    public u(Context context, o oVar, ViewGroup viewGroup) {
        super(context, oVar, viewGroup);
    }

    protected final int getLayout() {
        return i$g.sns_ad_native_landing_pages_gyroscope_image_view;
    }

    public final View bzM() {
        View view = this.contentView;
        this.bgR = (SensorManager) this.context.getSystemService("sensor");
        this.bkA = this.bgR.getDefaultSensor(1);
        this.bkC = this.bgR.getDefaultSensor(2);
        this.nFp = (HorizontalScrollView) view.findViewById(i$f.activity_gyroscope_horizontalscrollview);
        this.bOA = (ImageView) view.findViewById(i$f.activity_gyroscope_img);
        this.eVR = (ProgressBar) view.findViewById(i$f.progressbar);
        this.eVR.setVisibility(8);
        return view;
    }

    protected final void bzQ() {
        if (!e.cn(d.eH("adId", ((o) this.nDt).nAL))) {
            this.nFt = false;
        }
        this.nFp.setLayoutParams(new LayoutParams(this.hmV, this.hmW));
        this.bOA.setLayoutParams(new LayoutParams(this.hmV, this.hmW));
        this.contentView.setLayoutParams(new LinearLayout.LayoutParams(this.hmV, this.hmW));
        this.contentView.setPadding(this.contentView.getPaddingLeft(), (int) ((o) this.nDt).nAY, this.contentView.getPaddingRight(), (int) ((o) this.nDt).nAZ);
        String str = ((o) this.nDt).nAL;
        Bitmap eK = d.eK("adId", str);
        if (eK != null) {
            x.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  " + str);
            setImage(eK);
            return;
        }
        startLoading();
        d.a(str, ((o) this.nDt).nAX, new 1(this));
    }

    public final void startLoading() {
        this.eVR.setVisibility(0);
    }

    public final void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
        } else if (this.bOA == null) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
        } else if (bitmap.getHeight() == 0) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
        } else {
            this.eVR.setVisibility(8);
            this.bOA.setImageBitmap(bitmap);
            this.bOA.setLayoutParams(new LayoutParams((bitmap.getWidth() * this.hmW) / bitmap.getHeight(), this.hmW));
            this.bOA.post(new Runnable() {
                public final void run() {
                    int measuredWidth = u.this.bOA.getMeasuredWidth();
                    if (measuredWidth > u.this.hmV) {
                        u.this.nFm = (measuredWidth - u.this.hmV) / 2;
                        u.this.nFp.scrollBy(u.this.nFm, 0);
                    }
                }
            });
            if (bitmap.getHeight() != 0) {
                this.contentView.setLayoutParams(new LinearLayout.LayoutParams((bitmap.getWidth() * this.hmW) / bitmap.getHeight(), this.hmW));
            }
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = -10.0f;
        if (sensorEvent.sensor.getType() == 1) {
            this.nFq = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.nFr = sensorEvent.values;
        }
        if (this.nFq != null && this.nFr != null) {
            float[] fArr = new float[9];
            if (SensorManager.getRotationMatrix(fArr, new float[9], this.nFq, this.nFr)) {
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                float f2 = fArr2[2];
                if (this.nFm != 0) {
                    if (f2 > 10.0f) {
                        f2 = 10.0f;
                    }
                    if (f2 >= -10.0f) {
                        f = f2;
                    }
                    this.nFp.scrollBy((int) ((f * ((float) this.nFm)) / 10.0f), 0);
                }
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void bzA() {
        super.bzA();
        this.bgR.registerListener(this, this.bkA, 1);
        this.bgR.registerListener(this, this.bkC, 1);
    }

    public final void bzB() {
        super.bzB();
        this.bgR.unregisterListener(this);
    }

    public final boolean aa(JSONObject jSONObject) {
        if (!super.aa(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("swipeCount", this.nFs);
            if (!this.nFt) {
                String ce = ac.ce(((o) this.nDt).nAL);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", ce);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", e, "", new Object[0]);
            return false;
        }
    }
}
