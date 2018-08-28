package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class LuckyAvatarParticleView extends View {
    public static DisplayMetrics ewi;
    private long duration;
    private Paint fBa = new Paint();
    private ValueAnimator gGc;
    private int kNA;
    private int kNB;
    private int kNt;
    private int kNu;
    private List<Rect> kNv = new ArrayList();
    private List<Integer> kNw = new ArrayList();
    private List<Integer> kNx = new ArrayList();
    private int kNy;
    private int kNz;

    static /* synthetic */ void a(LuckyAvatarParticleView luckyAvatarParticleView, int i) {
        Rect rect = (Rect) luckyAvatarParticleView.kNv.get(i);
        int width = rect.width();
        if (Math.abs(luckyAvatarParticleView.kNt - rect.left) <= ((Integer) luckyAvatarParticleView.kNw.get(i)).intValue()) {
            rect.left = luckyAvatarParticleView.kNt;
        } else if (luckyAvatarParticleView.kNt > rect.left) {
            rect.left = ((Integer) luckyAvatarParticleView.kNw.get(i)).intValue() + rect.left;
        } else if (luckyAvatarParticleView.kNt < rect.left) {
            rect.left -= ((Integer) luckyAvatarParticleView.kNw.get(i)).intValue();
        }
        rect.right = rect.left + width;
        if (Math.abs(luckyAvatarParticleView.kNu - rect.top) <= ((Integer) luckyAvatarParticleView.kNx.get(i)).intValue()) {
            rect.top = luckyAvatarParticleView.kNu;
        } else if (luckyAvatarParticleView.kNu > rect.top) {
            rect.top = ((Integer) luckyAvatarParticleView.kNx.get(i)).intValue() + rect.top;
        } else if (luckyAvatarParticleView.kNu < rect.top) {
            rect.top -= ((Integer) luckyAvatarParticleView.kNx.get(i)).intValue();
        }
        rect.bottom = rect.top + width;
    }

    static /* synthetic */ void d(LuckyAvatarParticleView luckyAvatarParticleView) {
        int i;
        int random;
        int i2 = 20;
        for (i = 0; i < 20; i++) {
            random = (int) (Math.random() * ((double) luckyAvatarParticleView.getHeight()));
            int randomRectWidth = luckyAvatarParticleView.getRandomRectWidth();
            luckyAvatarParticleView.kNv.add(new Rect(0, random, randomRectWidth, random + randomRectWidth));
            randomRectWidth = luckyAvatarParticleView.getRandomVelocity();
            luckyAvatarParticleView.kNw.add(Integer.valueOf(randomRectWidth));
            random = (int) (((double) ((((float) Math.abs(random - luckyAvatarParticleView.kNu)) * (((float) randomRectWidth) * 1.0f)) / ((float) Math.abs(luckyAvatarParticleView.kNt)))) + 0.5d);
            if (random == 0) {
                random = 1;
            }
            luckyAvatarParticleView.kNx.add(Integer.valueOf(random));
        }
        while (i2 < 40) {
            random = (int) (Math.random() * ((double) luckyAvatarParticleView.getHeight()));
            i = luckyAvatarParticleView.getRandomRectWidth();
            luckyAvatarParticleView.kNv.add(new Rect(ewi.widthPixels, random, ewi.widthPixels + i, i + random));
            i = luckyAvatarParticleView.getRandomVelocity();
            luckyAvatarParticleView.kNw.add(Integer.valueOf(i));
            random = (int) (((double) ((((float) Math.abs(random - luckyAvatarParticleView.kNu)) * (((float) i) * 1.0f)) / ((float) Math.abs(ewi.widthPixels - luckyAvatarParticleView.kNt)))) + 0.5d);
            if (random == 0) {
                random = 1;
            }
            luckyAvatarParticleView.kNx.add(Integer.valueOf(random));
            i2++;
        }
    }

    public LuckyAvatarParticleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int getRandomVelocity() {
        return this.kNy + ((int) (Math.random() * ((double) (this.kNz - this.kNy))));
    }

    private int getRandomRectWidth() {
        return this.kNA + ((int) (Math.random() * ((double) (this.kNB - this.kNA))));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kNv.size()) {
                canvas.drawRect((Rect) this.kNv.get(i2), this.fBa);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setDuration(long j) {
        this.duration = j;
        this.gGc = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.duration);
        this.gGc.addUpdateListener(new 1(this));
    }

    public void setColor(int i) {
        this.fBa.setColor(i);
        this.fBa.setStyle(Style.FILL);
    }
}
