package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.b.b;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

final class l extends Drawable implements Animatable {
    private static final Interpolator Aa = new b();
    private static final Interpolator bL = new LinearInterpolator();
    private final int[] Ab = new int[]{-16777216};
    final a Ac;
    private View Ad;
    private float Ae;
    private double Af;
    private double Ag;
    boolean Ah;
    private float cY;
    private final ArrayList<Animation> jC = new ArrayList();
    private final Callback jy = new 3(this);
    private Animation mAnimation;
    private Resources mResources;

    static /* synthetic */ void b(float f, a aVar) {
        a(f, aVar);
        float floor = (float) (Math.floor((double) (aVar.At / 0.8f)) + 1.0d);
        float a = a(aVar);
        aVar.D((((aVar.As - a) - aVar.Ar) * f) + aVar.Ar);
        aVar.E(aVar.As);
        aVar.setRotation(((floor - aVar.At) * f) + aVar.At);
    }

    public l(Context context, View view) {
        this.Ad = view;
        this.mResources = context.getResources();
        this.Ac = new a(this.jy);
        this.Ac.setColors(this.Ab);
        au(1);
        a aVar = this.Ac;
        1 1 = new 1(this, aVar);
        1.setRepeatCount(-1);
        1.setRepeatMode(1);
        1.setInterpolator(bL);
        1.setAnimationListener(new 2(this, aVar));
        this.mAnimation = 1;
    }

    private void a(double d, double d2, double d3, double d4, float f, float f2) {
        a aVar = this.Ac;
        float f3 = this.mResources.getDisplayMetrics().density;
        this.Af = ((double) f3) * d;
        this.Ag = ((double) f3) * d2;
        float f4 = ((float) d4) * f3;
        aVar.jW = f4;
        aVar.cN.setStrokeWidth(f4);
        aVar.invalidateSelf();
        aVar.Ax = ((double) f3) * d3;
        aVar.av(0);
        f4 = f * f3;
        f3 *= f2;
        aVar.Ay = (int) f4;
        aVar.Az = (int) f3;
        f3 = (float) Math.min((int) this.Af, (int) this.Ag);
        f3 = (aVar.Ax <= 0.0d || f3 < 0.0f) ? (float) Math.ceil((double) (aVar.jW / 2.0f)) : (float) (((double) (f3 / 2.0f)) - aVar.Ax);
        aVar.Ao = f3;
    }

    public final void au(int i) {
        if (i == 0) {
            a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public final void A(boolean z) {
        this.Ac.B(z);
    }

    public final void B(float f) {
        a aVar = this.Ac;
        if (f != aVar.Aw) {
            aVar.Aw = f;
            aVar.invalidateSelf();
        }
    }

    public final void C(float f) {
        this.Ac.D(0.0f);
        this.Ac.E(f);
    }

    public final void setBackgroundColor(int i) {
        this.Ac.AC = i;
    }

    public final int getIntrinsicHeight() {
        return (int) this.Ag;
    }

    public final int getIntrinsicWidth() {
        return (int) this.Af;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.cY, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.Ac;
        RectF rectF = aVar.Ak;
        rectF.set(bounds);
        rectF.inset(aVar.Ao, aVar.Ao);
        float f = 360.0f * (aVar.Am + aVar.cY);
        float f2 = ((aVar.An + aVar.cY) * 360.0f) - f;
        aVar.cN.setColor(aVar.ru);
        canvas.drawArc(rectF, f, f2, false, aVar.cN);
        if (aVar.Au) {
            if (aVar.Av == null) {
                aVar.Av = new Path();
                aVar.Av.setFillType(FillType.EVEN_ODD);
            } else {
                aVar.Av.reset();
            }
            float f3 = ((float) (((int) aVar.Ao) / 2)) * aVar.Aw;
            float cos = (float) ((aVar.Ax * Math.cos(0.0d)) + ((double) bounds.exactCenterX()));
            float sin = (float) ((aVar.Ax * Math.sin(0.0d)) + ((double) bounds.exactCenterY()));
            aVar.Av.moveTo(0.0f, 0.0f);
            aVar.Av.lineTo(((float) aVar.Ay) * aVar.Aw, 0.0f);
            aVar.Av.lineTo((((float) aVar.Ay) * aVar.Aw) / 2.0f, ((float) aVar.Az) * aVar.Aw);
            aVar.Av.offset(cos - f3, sin);
            aVar.Av.close();
            aVar.Al.setColor(aVar.ru);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(aVar.Av, aVar.Al);
        }
        if (aVar.AA < com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE) {
            aVar.AB.setColor(aVar.AC);
            aVar.AB.setAlpha(255 - aVar.AA);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), aVar.AB);
        }
        canvas.restoreToCount(save);
    }

    public final void setAlpha(int i) {
        this.Ac.AA = i;
    }

    public final int getAlpha() {
        return this.Ac.AA;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        a aVar = this.Ac;
        aVar.cN.setColorFilter(colorFilter);
        aVar.invalidateSelf();
    }

    final void setRotation(float f) {
        this.cY = f;
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        ArrayList arrayList = this.jC;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        this.mAnimation.reset();
        this.Ac.cL();
        if (this.Ac.An != this.Ac.Am) {
            this.Ah = true;
            this.mAnimation.setDuration(666);
            this.Ad.startAnimation(this.mAnimation);
            return;
        }
        this.Ac.av(0);
        this.Ac.cM();
        this.mAnimation.setDuration(1332);
        this.Ad.startAnimation(this.mAnimation);
    }

    public final void stop() {
        this.Ad.clearAnimation();
        setRotation(0.0f);
        this.Ac.B(false);
        this.Ac.av(0);
        this.Ac.cM();
    }

    private static float a(a aVar) {
        return (float) Math.toRadians(((double) aVar.jW) / (6.283185307179586d * aVar.Ax));
    }

    private static void a(float f, a aVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int i = aVar.Ap[aVar.Aq];
            int i2 = aVar.Ap[aVar.cK()];
            i = Integer.valueOf(i).intValue();
            int i3 = (i >> 24) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE;
            int i4 = (i >> 16) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE;
            int i5 = (i >> 8) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE;
            i &= com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE;
            i2 = Integer.valueOf(i2).intValue();
            aVar.ru = (((int) (f2 * ((float) ((i2 & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE) - i)))) + i) | ((((i3 + ((int) (((float) (((i2 >> 24) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE) - i3)) * f2))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE) - i4)) * f2))) << 16)) | ((((int) (((float) (((i2 >> 8) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE) - i5)) * f2)) + i5) << 8));
        }
    }
}
