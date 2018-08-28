package com.tencent.mm.plugin.setting.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView extends View {
    private static SoftReference<Bitmap> mVD = null;
    private static int mVM = 8;
    private int djl = 0;
    private float hlo = 0.0f;
    private float jUm = 0.0f;
    private int lAr = 0;
    private List<b> mVE = new ArrayList(8);
    private int mVF = 0;
    private int mVG = 0;
    private int mVH = 0;
    private int mVI = 0;
    private int mVJ = 0;
    private int mVK = 0;
    private a mVL = null;
    private boolean mVN = false;
    private boolean mVO = false;
    private int topOffset = 0;

    public interface a {
        void vM(int i);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        bul();
        this.mVE.clear();
        setClickable(true);
        this.mVF = com.tencent.mm.bp.a.fromDPToPix(getContext(), 30);
        this.topOffset = com.tencent.mm.bp.a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.lAr = (getHeight() / 2) + this.topOffset;
        mVM = 8;
        this.djl = (width - (this.mVF * 2)) / (mVM - 1);
        Bitmap bitmap = (Bitmap) mVD.get();
        for (int i5 = 0; i5 < mVM; i5++) {
            b bVar = new b((byte) 0);
            bVar.left = (this.mVF + (this.djl * i5)) - (bitmap.getWidth() / 2);
            bVar.top = this.lAr - (bitmap.getHeight() / 2);
            bVar.right = (this.mVF + (this.djl * i5)) + (bitmap.getWidth() / 2);
            bVar.bottom = this.lAr + (bitmap.getHeight() / 2);
            this.mVE.add(bVar);
        }
        this.mVG = this.mVK;
        if (this.mVJ >= 0) {
            this.mVH = ((b) this.mVE.get(this.mVG)).left;
        } else if (this.mVH <= ((b) this.mVE.get(this.mVG)).right - (this.djl / 2)) {
            this.mVH = ((b) this.mVE.get(this.mVG)).left;
        } else {
            this.mVH = ((b) this.mVE.get(this.mVG)).right;
        }
        this.mVI = ((b) this.mVE.get(this.mVG)).top;
        invalidate();
    }

    public static void buk() {
        mVM = 8;
    }

    private void bul() {
        if (mVD == null || mVD.get() == null) {
            mVD = new SoftReference(BitmapFactory.decodeResource(getResources(), e.font_chooser_slider));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bul();
        Paint paint = new Paint();
        paint.setARGB(WebView.NORMAL_MODE_ALPHA, 152, 152, 152);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.mVF, (float) this.lAr, (float) (width - this.mVF), (float) this.lAr, paint);
        width = 0;
        while (true) {
            int i = width;
            if (i < mVM) {
                canvas.drawLine((float) (this.mVF + (this.djl * i)), (float) (this.lAr - fromDPToPix), (float) (this.mVF + (this.djl * i)), (float) (this.lAr + fromDPToPix), paint);
                width = i + 1;
            } else {
                Bitmap bitmap = (Bitmap) mVD.get();
                canvas.drawBitmap(bitmap, (float) this.mVH, (float) this.mVI, null);
                String str = "A";
                String string = getResources().getString(i.setting_text_size_normal);
                getResources().getString(i.setting_text_size_large);
                getResources().getString(i.setting_text_size_super);
                String str2 = "A";
                float aq = aq(SetTextSizeUI.ao(0.875f));
                paint = new Paint();
                paint.setTextSize(aq);
                i = (int) paint.measureText(str);
                int ar = ar(aq);
                paint.setColor(getResources().getColor(c.black));
                paint.setAntiAlias(true);
                canvas.drawText(str, (float) (this.mVF - (i / 2)), (float) ((this.lAr - ar) - (bitmap.getHeight() / 3)), paint);
                float aq2 = aq(SetTextSizeUI.ao(1.0f));
                paint.setTextSize(aq2);
                canvas.drawText(string, (float) ((this.mVF + (this.djl * 1)) - (((int) paint.measureText(string)) / 2)), (float) ((this.lAr - ar(aq2)) - (bitmap.getHeight() / 3)), paint);
                aq2 = aq(SetTextSizeUI.ao(2.025f));
                paint.setTextSize(aq2);
                canvas.drawText(str2, (float) ((this.mVF + (this.djl * (mVM - 1))) - (((int) paint.measureText(str2)) / 2)), (float) ((this.lAr - ar(aq2)) - (bitmap.getHeight() / 3)), paint);
                return;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        b bVar;
        b bVar2;
        float y;
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                this.jUm = motionEvent.getX();
                this.hlo = motionEvent.getY();
                bVar = (b) this.mVE.get(this.mVG);
                if (this.jUm >= ((float) bVar.left) && this.jUm <= ((float) bVar.right) && this.hlo >= ((float) bVar.top) && this.hlo <= ((float) bVar.bottom)) {
                    z = true;
                }
                if (!z) {
                    this.mVO = true;
                    break;
                }
                this.mVN = true;
                return true;
            case 1:
                if (this.mVN) {
                    int i2 = 0;
                    while (i2 < mVM - 1) {
                        bVar = (b) this.mVE.get(i2);
                        bVar2 = (b) this.mVE.get(i2 + 1);
                        if (this.mVH <= bVar.left + (this.djl / 2) && this.mVH >= bVar.left) {
                            this.mVG = i2;
                            this.mVH = bVar.left;
                            this.mVK = this.mVG;
                            if (this.mVL != null) {
                                this.mVL.vM(this.mVG);
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
                            if (this.mVL != null) {
                                this.mVL.vM(this.mVG);
                            }
                            invalidate();
                            this.mVN = false;
                            return true;
                        }
                    }
                    this.mVK = this.mVG;
                    if (this.mVL != null) {
                        this.mVL.vM(this.mVG);
                    }
                    invalidate();
                    this.mVN = false;
                    return true;
                } else if (this.mVO) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.jUm) <= 10.0f && Math.abs(y - this.hlo) <= 10.0f) {
                        i = 0;
                        while (i < mVM) {
                            bVar = (b) this.mVE.get(i);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i++;
                            } else {
                                this.mVG = i;
                                this.mVK = this.mVG;
                                this.mVH = bVar.left;
                                if (this.mVL != null) {
                                    this.mVL.vM(this.mVG);
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
                this.mVJ = (int) (y - this.jUm);
                this.mVH += this.mVJ;
                this.jUm = y;
                this.hlo = y2;
                bVar = (b) this.mVE.get(0);
                bVar2 = (b) this.mVE.get(mVM - 1);
                if (this.mVH <= bVar.left) {
                    this.mVH = bVar.left;
                } else if (this.mVH >= bVar2.left) {
                    this.mVH = bVar2.left;
                } else {
                    i = 0;
                    while (i < mVM) {
                        bVar = (b) this.mVE.get(i);
                        if (this.mVH < bVar.left - 5 || this.mVH > bVar.right + 5) {
                            i++;
                        } else {
                            this.mVG = i;
                            this.mVK = this.mVG;
                            if (this.mVL != null) {
                                this.mVL.vM(this.mVG);
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

    private float aq(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private static int ar(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }

    public void setOnChangeListener(a aVar) {
        this.mVL = aVar;
    }

    public void setSliderIndex(int i) {
        this.mVK = i;
    }
}
