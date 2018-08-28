package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class LyricView extends View {
    public static int lAo = a.fromDPToPix(ad.getContext(), 16);
    public static int lAp = a.fromDPToPix(ad.getContext(), 10);
    private long dDQ;
    private int height;
    private GestureDetector iEv;
    private float kuY;
    private com.tencent.mm.plugin.music.model.a lAi;
    private TextPaint lAj;
    private TextPaint lAk;
    private int lAl;
    private int lAm;
    private int lAn = -1;
    private int lAq = (lAo + lAp);
    private int lAr = this.lAq;
    private boolean lAs;
    private boolean lAt;
    private int lAu;
    private float lgk;
    private int width;

    static /* synthetic */ String a(LyricView lyricView, float f, float f2) {
        x.i("MicroMsg.Music.LyricView", "getSentenceByXY %f, %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        if (lyricView.lAi != null && lyricView.lAi.lxL.size() > 0) {
            int i = (lyricView.height / 2) - lyricView.lAr;
            int i2 = i - ((lAo + lAp) / 2);
            i += (lAo + lAp) / 2;
            if (f2 >= ((float) i2) && f2 <= ((float) i)) {
                return lyricView.lAi.tx(lyricView.lAn).content;
            }
            if (f2 < ((float) i2)) {
                i = (lyricView.lAn - (((int) (((float) i2) - f2)) / (lAo + lAp))) - 1;
                if (i < lyricView.lAi.lxL.size() && i >= 0) {
                    return lyricView.lAi.tx(i).content;
                }
            } else if (f2 > ((float) i)) {
                i = ((((int) (f2 - ((float) i))) / (lAo + lAp)) + lyricView.lAn) + 1;
                if (i < lyricView.lAi.lxL.size() && i >= 0) {
                    return lyricView.lAi.tx(i).content;
                }
            }
        }
        return "";
    }

    public void setLyricObj(com.tencent.mm.plugin.music.model.a aVar) {
        this.lAi = aVar;
        invalidate();
    }

    public void setCurrentTime(long j) {
        if (this.dDQ != j) {
            this.dDQ = j;
            if (this.lAi != null && this.lAi.lxL.size() != 0) {
                int i = -1;
                int i2 = 0;
                while (i2 < this.lAi.lxL.size() && this.lAi.tx(i2).timestamp < j) {
                    if (!this.lAi.tx(i2).lxR) {
                        i = i2;
                    }
                    i2++;
                }
                if (!this.lAt && i != this.lAn) {
                    this.lAn = i;
                    this.lAl = (lAo + lAp) * this.lAn;
                    this.lAm = (lAo + lAp) * ((this.lAi.lxL.size() - this.lAn) - 1);
                    if (this.lAr == 0) {
                        this.lAr = -this.lAq;
                    }
                    this.lAs = true;
                    invalidate();
                }
            }
        }
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public LyricView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.lAj = new TextPaint();
        this.lAj.setTextSize((float) lAo);
        this.lAj.setColor(-1);
        this.lAj.setAntiAlias(true);
        this.lAj.setTextAlign(Align.CENTER);
        this.lAk = new TextPaint();
        this.lAk.setTextSize((float) lAo);
        this.lAk.setColor(-1);
        this.lAk.setAlpha(127);
        this.lAk.setAntiAlias(true);
        this.lAk.setTextAlign(Align.CENTER);
        this.iEv = new GestureDetector(getContext(), new a(this, (byte) 0));
    }

    public void setLyricColor(int i) {
        this.lAj.setColor(i);
        this.lAj.setAlpha(255);
        this.lAk.setColor(i);
        this.lAk.setAlpha(127);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.lAi == null) {
            x.v("MicroMsg.Music.LyricView", "lyricObj is null");
            return;
        }
        if (this.height == 0 || this.width == 0) {
            this.height = getMeasuredHeight();
            this.width = getMeasuredWidth();
        }
        if (this.lAn >= 0) {
            int i = this.lAr;
            if (this.lAi != null && this.lAi.lxL.size() > this.lAn) {
                int i2;
                int i3 = (this.height / 2) - i;
                if (i3 < this.height && i3 > 0) {
                    canvas.drawText(this.lAi.tx(this.lAn).content, (float) (this.width / 2), (float) i3, this.lAj);
                }
                for (i = this.lAn - 1; i >= 0; i--) {
                    i2 = i3 - ((this.lAn - i) * (lAo + lAp));
                    if (i2 > 0 && i2 < this.height) {
                        canvas.drawText(this.lAi.tx(i).content, (float) (this.width / 2), (float) i2, this.lAk);
                    }
                }
                i = this.lAn;
                while (true) {
                    i++;
                    if (i >= this.lAi.lxL.size()) {
                        break;
                    }
                    i2 = ((i - this.lAn) * (lAo + lAp)) + i3;
                    if (i2 < this.height && i2 > 0) {
                        canvas.drawText(this.lAi.tx(i).content, (float) (this.width / 2), (float) i2, this.lAk);
                    }
                }
            }
            if (this.lAs) {
                if ((this.lAr != 0 ? 1 : null) != null) {
                    this.lAr = (int) (((float) this.lAr) * 0.9f);
                    invalidate();
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.height = i2;
        this.width = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.iEv.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.kuY = motionEvent.getY();
                this.lgk = motionEvent.getX();
                this.lAu = this.lAr;
                this.lAt = true;
                this.lAs = false;
                break;
            case 1:
                this.lAt = false;
                break;
            case 2:
                int x = (int) (motionEvent.getX() - this.lgk);
                int y = this.lAu - ((int) (motionEvent.getY() - this.kuY));
                if (y > 0) {
                    this.lAr = y > this.lAm ? this.lAm : y;
                } else {
                    this.lAr = y < (-this.lAl) ? -this.lAl : y;
                }
                invalidate();
                x.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[]{Integer.valueOf(x), Integer.valueOf(r3), Integer.valueOf(y), Integer.valueOf(this.lAu)});
                break;
        }
        return true;
    }
}
