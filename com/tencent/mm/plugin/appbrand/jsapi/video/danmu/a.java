package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;

public final class a implements d {
    private static int gbJ;
    private static int gbK;
    private int Jg;
    private int Jq;
    private StaticLayout duh;
    private SpannableString gbL;
    private int gbM;
    private int gbN;
    private int gbO = -1;
    private int gbP;
    private int gbQ;
    private float gbR;
    private Context mContext;
    private int vD = -1;

    public a(Context context, SpannableString spannableString, int i, int i2) {
        this.mContext = context;
        this.gbL = spannableString;
        this.gbP = b.y(this.mContext, b.gbS);
        this.vD = i;
        this.gbR = 3.0f;
        this.gbQ = i2;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.vD);
        textPaint.setTextSize((float) this.gbP);
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.Jq = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
        this.duh = new StaticLayout(this.gbL, textPaint, ((int) Layout.getDesiredWidth(this.gbL, 0, this.gbL.length(), textPaint)) + 1, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.Jg = this.duh.getWidth();
    }

    public final void b(Canvas canvas, boolean z) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (!(width == gbJ && height == gbK)) {
            gbJ = width;
            gbK = height;
        }
        canvas.save();
        canvas.translate((float) this.gbM, (float) this.gbN);
        this.duh.draw(canvas);
        canvas.restore();
        if (!z) {
            this.gbM = (int) (((float) this.gbM) - (((float) b.akf()) * this.gbR));
        }
    }

    public final void bN(int i, int i2) {
        this.gbM = i;
        this.gbN = i2;
    }

    public final float akc() {
        return this.gbR;
    }

    public final boolean akd() {
        return this.gbM < 0 && Math.abs(this.gbM) > this.Jg;
    }

    public final int getWidth() {
        return this.Jg;
    }

    public final int getCurrX() {
        return this.gbM;
    }

    public final int ake() {
        return this.gbQ;
    }

    public final boolean kX(int i) {
        if (i >= this.gbQ && i - this.gbQ <= b.gbT) {
            return true;
        }
        return false;
    }

    public final boolean kY(int i) {
        return i - this.gbQ > b.gbT;
    }

    public final boolean a(d dVar) {
        if (dVar.getWidth() + dVar.getCurrX() > gbJ) {
            return true;
        }
        if (this.gbO < 0) {
            this.gbO = b.y(this.mContext, 20);
        }
        if (dVar.akc() >= this.gbR) {
            if (dVar.akc() != this.gbR || ((float) (gbJ - (dVar.getCurrX() + dVar.getWidth()))) >= ((float) this.gbO)) {
                return false;
            }
            return true;
        } else if (((double) (((((float) (dVar.getCurrX() + dVar.getWidth())) / (dVar.akc() * ((float) b.akf()))) * this.gbR) * ((float) b.akf()))) <= ((double) gbJ) - (((double) this.gbO) * 1.5d)) {
            return false;
        } else {
            return true;
        }
    }
}
