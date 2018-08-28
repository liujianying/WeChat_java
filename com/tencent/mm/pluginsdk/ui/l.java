package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public final class l extends Drawable {
    private Context context;
    private Paint fBa = new Paint(1);
    private ValueAnimator gGc = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
    private float jOI = 0.0f;
    private Drawable qGE = null;
    private int qGF = 0;
    private int qGG = 0;
    private Interpolator qGH = new LinearInterpolator();
    private Interpolator qGI = new AccelerateDecelerateInterpolator();
    private int qGJ;
    private int qGK;
    private int qGL;
    private int qGM;
    private int qGN;
    private int qGO;
    private int qGP;
    private int qGQ;
    private int qGR;
    private int qGS;
    private int qGT = 0;
    private float qGU = -90.0f;
    private float qGV = 0.0f;
    private float qGW = 0.0f;
    private float qGX = 5.0f;
    private boolean qGY = false;
    private int qGZ;
    private int qHa;
    private int qHb;
    private int qHc = 2;
    private RectF qHd;
    private Random random = new Random(System.currentTimeMillis());

    public l(Context context) {
        this.gGc.setInterpolator(this.qGH);
        this.gGc.addUpdateListener(new 1(this));
        this.qHd = new RectF();
        this.context = context;
        this.qGF = a.g(context, R.e.wechat_green);
        this.qGG = a.g(context, R.e.normal_color);
        this.qGE = context.getResources().getDrawable(R.k.voiceinput_icon_button);
        this.qGM = a.ae(context, R.f.voice_input_min_circle_radius);
        this.qGN = a.ae(context, R.f.voice_input_max_circle_radius);
        this.qGO = a.ae(context, R.f.voice_input_breathe_circle_radius);
        this.qGT = a.ae(context, R.f.voice_input_btn_radius);
        this.qGK = a.g(context, R.e.voice_input_btn_outer_color);
        this.qGL = a.ae(context, R.f.voice_input_btn_outer_radius);
        this.qGR = a.ae(context, R.f.voice_input_btn_inner_radius);
        this.qGS = a.g(context, R.e.voice_input_btn_pressed_mask);
        this.qGZ = this.qGR;
        this.qHa = this.qGZ;
        this.qHb = a.ae(context, R.f.voice_input_btn_outer_radius_minpressed);
        this.qGP = a.ae(context, R.f.voice_input_btn_outer_radius_minpressed);
        this.qGQ = a.ae(context, R.f.voice_input_btn_outer_radius_maxpressed);
        this.qGJ = a.ae(context, R.f.voice_input_paint_stroke_width);
    }

    public final void cdt() {
        x.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[]{Integer.valueOf(this.qHc)});
        this.qHc = 7;
        this.gGc.cancel();
        this.jOI = 0.0f;
        invalidateSelf();
    }

    public final void cdu() {
        x.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[]{Integer.valueOf(this.qHc)});
        this.qHc = 2;
        this.gGc.cancel();
        this.jOI = 0.0f;
        this.qGU = -90.0f;
        this.qGV = 0.0f;
        this.qGW = 0.0f;
        this.qGX = 5.0f;
        invalidateSelf();
    }

    public final void cdv() {
        x.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[]{Integer.valueOf(this.qHc)});
        this.qHc = 6;
        this.gGc.cancel();
        this.jOI = 0.0f;
        invalidateSelf();
    }

    public final void kE(boolean z) {
        x.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(z)});
        if (!z) {
            this.qHc = 3;
        }
        this.qGY = true;
        invalidateSelf();
    }

    public final void BU(int i) {
        boolean z = true;
        x.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[]{Integer.valueOf(i)});
        if (i >= 28) {
            z = false;
        }
        this.qGY = z;
        invalidateSelf();
    }

    public final void cdw() {
        x.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[]{Integer.valueOf(this.qHc)});
        this.qHc = 4;
        this.gGc.cancel();
        this.jOI = 0.0f;
        this.gGc.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gGc.setDuration(1000);
        this.gGc.setRepeatCount(-1);
        this.gGc.start();
    }

    public final void cdx() {
        x.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[]{Integer.valueOf(this.qHc)});
        this.qHc = 5;
        this.gGc.cancel();
        this.jOI = 0.0f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        int width;
        int height;
        if ((this.qHc == 6 || this.qHc == 7) && !i(canvas)) {
            width = canvas.getWidth() >> 1;
            height = canvas.getHeight() >> 1;
            this.fBa.setShader(null);
            this.fBa.setStyle(Style.FILL);
            this.fBa.setColor(this.qGK);
            if (this.qHc == 7) {
                if (this.qGY) {
                    this.qHb -= 4;
                } else {
                    this.qHb += 4;
                }
                this.qHb = Math.min(Math.max(this.qGP, this.qHb), this.qGQ);
                canvas.drawCircle((float) width, (float) height, (float) this.qHb, this.fBa);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.qGP, this.fBa);
            }
        }
        if (!(this.qGE == null || i(canvas))) {
            if (this.qHc == 5) {
                this.qGE.setColorFilter(this.qGG, Mode.SRC_ATOP);
            } else {
                this.qGE.setColorFilter(this.qGF, Mode.SRC_ATOP);
            }
            width = canvas.getWidth() / 2;
            height = canvas.getHeight() / 2;
            this.qGE.setBounds(width - this.qGT, height - this.qGT, width + this.qGT, height + this.qGT);
            this.qGE.draw(canvas);
        }
        if (this.qHc == 4 && canvas != null) {
            this.fBa.setColor(this.qGF);
            this.fBa.setStrokeWidth((float) this.qGJ);
            this.fBa.setStyle(Style.STROKE);
            this.fBa.clearShadowLayer();
            this.fBa.setShader(null);
            this.qHd.left = (float) ((canvas.getWidth() / 2) - this.qGR);
            this.qHd.top = (float) ((canvas.getHeight() / 2) - this.qGR);
            this.qHd.right = (float) ((canvas.getWidth() / 2) + this.qGR);
            this.qHd.bottom = (float) ((canvas.getHeight() / 2) + this.qGR);
            canvas.drawArc(this.qHd, this.qGU, this.qGW, false, this.fBa);
            this.qGU += this.qGV;
            this.qGW += this.qGX;
            if (this.qGW >= 360.0f) {
                this.qGX = -this.qGX;
                this.qGV = 5.0f;
            } else if (this.qGW <= 0.0f) {
                this.qGX = -this.qGX;
                this.qGV = 0.0f;
                this.qGU = -90.0f;
                this.qGW = 0.0f;
            }
        }
        if ((this.qHc == 6 || this.qHc == 7) && !i(canvas)) {
            this.fBa.setStyle(Style.FILL);
            this.fBa.setColor(this.qGS);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.qGT, this.fBa);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        if (this.context == null) {
            return 0;
        }
        return a.fk(this.context);
    }

    public final int getIntrinsicHeight() {
        return this.qGT * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    private static boolean i(Canvas canvas) {
        return canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0;
    }
}
