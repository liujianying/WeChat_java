package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView extends View {
    private static SoftReference<Bitmap> mVD = null;
    private int djl = 0;
    private float hlo = 0.0f;
    private float jUm = 0.0f;
    private int lAr = 0;
    private List<b> mVE = new ArrayList(4);
    private int mVF = 0;
    private int mVG = 0;
    private int mVH = 0;
    private int mVI = 0;
    private int mVK = 0;
    private boolean mVN = false;
    private boolean mVO = false;
    private a qkB = null;
    private int topOffset = 0;

    public FontChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        bul();
        this.mVE.clear();
        setClickable(true);
        this.mVF = a.fromDPToPix(getContext(), 50);
        this.topOffset = a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.lAr = (getHeight() / 2) + this.topOffset;
        this.djl = (width - (this.mVF * 2)) / 3;
        Bitmap bitmap = (Bitmap) mVD.get();
        for (int i5 = 0; i5 < 4; i5++) {
            b bVar = new b((byte) 0);
            bVar.left = (this.mVF + (this.djl * i5)) - (bitmap.getWidth() / 2);
            bVar.top = this.lAr - (bitmap.getHeight() / 2);
            bVar.right = (this.mVF + (this.djl * i5)) + (bitmap.getWidth() / 2);
            bVar.bottom = this.lAr + (bitmap.getHeight() / 2);
            this.mVE.add(bVar);
        }
        this.mVG = this.mVK;
        this.mVH = ((b) this.mVE.get(this.mVG)).left;
        this.mVI = ((b) this.mVE.get(this.mVG)).top;
        invalidate();
    }

    private void bul() {
        if (mVD == null || mVD.get() == null) {
            mVD = new SoftReference(BitmapFactory.decodeResource(getResources(), R.g.font_chooser_slider));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bul();
        Paint paint = new Paint();
        paint.setARGB(255, 152, 152, 152);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.mVF, (float) this.lAr, (float) (width - this.mVF), (float) this.lAr, paint);
        width = 0;
        while (true) {
            int i = width;
            if (i < 4) {
                canvas.drawLine((float) (this.mVF + (this.djl * i)), (float) (this.lAr - fromDPToPix), (float) (this.mVF + (this.djl * i)), (float) (this.lAr + fromDPToPix), paint);
                width = i + 1;
            } else {
                Bitmap bitmap = (Bitmap) mVD.get();
                canvas.drawBitmap(bitmap, (float) this.mVH, (float) this.mVI, null);
                String string = getResources().getString(R.l.webview_font_chooser_small);
                String string2 = getResources().getString(R.l.webview_font_chooser_standar);
                String string3 = getResources().getString(R.l.webview_font_chooser_big);
                String string4 = getResources().getString(R.l.webview_font_chooser_bigger);
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.font_chooser_small_text_size);
                Paint paint2 = new Paint();
                paint2.setTextSize((float) dimensionPixelSize);
                fromDPToPix = (int) paint2.measureText(string);
                dimensionPixelSize = Bi(dimensionPixelSize);
                paint2.setColor(getResources().getColor(R.e.web_view_font_chooser_font_color));
                paint2.setAntiAlias(true);
                canvas.drawText(string, (float) (this.mVF - (fromDPToPix / 2)), (float) ((this.lAr - dimensionPixelSize) - (bitmap.getHeight() / 3)), paint2);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.font_chooser_standar_text_size);
                paint2.setTextSize((float) dimensionPixelSize2);
                canvas.drawText(string2, (float) ((this.mVF + (this.djl * 1)) - (((int) paint2.measureText(string2)) / 2)), (float) ((this.lAr - Bi(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
                dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.font_chooser_big_text_size);
                paint2.setTextSize((float) dimensionPixelSize2);
                canvas.drawText(string3, (float) ((this.mVF + (this.djl * 2)) - (((int) paint2.measureText(string3)) / 2)), (float) ((this.lAr - Bi(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
                dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.font_chooser_bigger_text_size);
                paint2.setTextSize((float) dimensionPixelSize2);
                canvas.drawText(string4, (float) ((this.mVF + (this.djl * 3)) - (((int) paint2.measureText(string4)) / 2)), (float) ((this.lAr - Bi(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
                return;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        b bVar;
        b bVar2;
        float y;
        switch (motionEvent.getAction()) {
            case 0:
                this.jUm = motionEvent.getX();
                this.hlo = motionEvent.getY();
                bVar = (b) this.mVE.get(this.mVG);
                if (this.jUm >= ((float) bVar.left) && this.jUm <= ((float) bVar.right) && this.hlo >= ((float) bVar.top) && this.hlo <= ((float) bVar.bottom)) {
                    i = 1;
                }
                if (i == 0) {
                    this.mVO = true;
                    break;
                }
                this.mVN = true;
                return true;
            case 1:
                if (this.mVN) {
                    int i2 = 0;
                    while (i2 < 3) {
                        bVar = (b) this.mVE.get(i2);
                        bVar2 = (b) this.mVE.get(i2 + 1);
                        if (this.mVH <= bVar.left + (this.djl / 2) && this.mVH >= bVar.left) {
                            this.mVG = i2;
                            this.mVH = bVar.left;
                            this.mVK = this.mVG;
                            if (this.qkB != null) {
                                this.qkB.vM(this.mVG);
                            }
                            invalidate();
                            this.mVN = false;
                            return true;
                        } else if (this.mVH < bVar2.left - (this.djl / 2) || this.mVH > bVar2.left) {
                            i2++;
                        } else {
                            this.mVG = i2 + 1;
                            this.mVH = bVar2.left;
                            this.mVK = this.mVG;
                            if (this.qkB != null) {
                                this.qkB.vM(this.mVG);
                            }
                            invalidate();
                            this.mVN = false;
                            return true;
                        }
                    }
                    this.mVK = this.mVG;
                    if (this.qkB != null) {
                        this.qkB.vM(this.mVG);
                    }
                    invalidate();
                    this.mVN = false;
                    return true;
                } else if (this.mVO) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.jUm) <= 10.0f && Math.abs(y - this.hlo) <= 10.0f) {
                        int i3 = 0;
                        while (i3 < 4) {
                            bVar = (b) this.mVE.get(i3);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i3++;
                            } else {
                                this.mVG = i3;
                                this.mVK = this.mVG;
                                this.mVH = bVar.left;
                                if (this.qkB != null) {
                                    this.qkB.vM(this.mVG);
                                }
                            }
                        }
                    }
                    this.mVO = false;
                    invalidate();
                    return true;
                }
                break;
            case 2:
                if (!this.mVN) {
                    return super.onTouchEvent(motionEvent);
                }
                y = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.mVH += (int) (y - this.jUm);
                this.jUm = y;
                this.hlo = y2;
                bVar = (b) this.mVE.get(0);
                bVar2 = (b) this.mVE.get(3);
                if (this.mVH <= bVar.left) {
                    this.mVH = bVar.left;
                } else if (this.mVH >= bVar2.left) {
                    this.mVH = bVar2.left;
                } else {
                    while (i < 4) {
                        bVar = (b) this.mVE.get(i);
                        if (this.mVH < bVar.left - 5 || this.mVH > bVar.right + 5) {
                            i++;
                        } else {
                            this.mVG = i;
                            this.mVK = this.mVG;
                            if (this.qkB != null) {
                                this.qkB.vM(this.mVG);
                            }
                        }
                    }
                }
                invalidate();
                return true;
            default:
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private static int Bi(int i) {
        Paint paint = new Paint();
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }

    public void setOnChangeListener(a aVar) {
        this.qkB = aVar;
    }

    public void setSliderIndex(int i) {
        this.mVK = i;
    }
}
