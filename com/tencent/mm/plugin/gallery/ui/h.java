package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class h extends Drawable {
    private static final Paint dvs = new Paint();
    private static Rect rect = null;
    protected int bMT = 0;
    protected ImageView isa;
    protected String jAm = "";
    protected long jAn = 0;
    protected boolean jEI = false;
    public a jEJ;
    long jEK;
    boolean jEL = false;
    private Rect jEM = new Rect();
    private Bitmap mBitmap;
    protected String mFilePath = "";
    private int mWidth;

    static {
        dvs.setAntiAlias(true);
        dvs.setFilterBitmap(true);
    }

    private h(ImageView imageView) {
        this.isa = imageView;
        this.mFilePath = "";
    }

    public final int getIntrinsicWidth() {
        return TbsListener$ErrorCode.INFO_CODE_BASE;
    }

    public final int getIntrinsicHeight() {
        return TbsListener$ErrorCode.INFO_CODE_BASE;
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        x.v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.setBounds(i, i2, i3, i4);
    }

    public final void setBounds(Rect rect) {
        x.v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", new Object[]{rect.toString()});
        super.setBounds(rect);
    }

    public final void draw(Canvas canvas) {
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.jEK)) / 200.0f;
        if (this.jEK == 0) {
            x.d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", new Object[]{this.mFilePath});
            uptimeMillis = 0.0f;
        }
        x.d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", new Object[]{Integer.valueOf(hashCode()), this.mFilePath, Boolean.valueOf(this.jEL), Float.valueOf(uptimeMillis), Integer.valueOf((int) (255.0f * uptimeMillis))});
        if (!this.jEL) {
            d(canvas, 255);
            setAlpha(255);
        } else if (uptimeMillis >= 1.0f) {
            this.jEL = false;
            d(canvas, 255);
        } else if (d(canvas, (int) (uptimeMillis * 255.0f))) {
            invalidateSelf();
        }
    }

    private boolean d(Canvas canvas, int i) {
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            x.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.mFilePath);
            if (this.mBitmap != null && this.mBitmap.isRecycled()) {
                this.jEL = true;
                this.jEK = 0;
                this.mBitmap = c.aRe().b(this.mFilePath, this.bMT, this.jAm, this.jAn);
                if (!(this.jEJ == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.jEJ.aRO();
                }
            }
            return false;
        }
        x.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.mFilePath);
        Bitmap bitmap = this.mBitmap;
        Rect rect = this.jEM;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.top = 0;
            rect.bottom = bitmap.getHeight();
            rect.left = (bitmap.getWidth() - bitmap.getHeight()) >> 1;
            rect.right = bitmap.getHeight() + rect.left;
        } else {
            rect.left = 0;
            rect.right = bitmap.getWidth();
            rect.top = (bitmap.getHeight() - bitmap.getWidth()) >> 1;
            rect.bottom = bitmap.getWidth() + rect.top;
        }
        dvs.setAlpha(i);
        canvas.drawBitmap(this.mBitmap, this.jEM, getBounds(), dvs);
        x.v("MicroMsg.ThumbDrawable", "Bounts:%s", new Object[]{getBounds().toString()});
        return true;
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j) {
        a(imageView, i, str, str2, j, -1, null);
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j, int i2, a aVar) {
        Drawable hVar;
        String str3;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof h)) {
            hVar = new h(imageView);
        } else {
            hVar = (h) drawable;
        }
        if (i2 > 0) {
            hVar.mWidth = i2;
        }
        hVar.jEJ = aVar;
        if (bi.oW(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (bi.oW(str3)) {
            x.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
        } else {
            if (bi.oW(str)) {
                hVar.jEI = false;
            } else {
                hVar.jEI = true;
            }
            c.aRe().a(new c(hVar));
            String str4;
            String str5;
            Object[] objArr;
            if (!hVar.mFilePath.equals(str3) || hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                hVar.mFilePath = str3;
                hVar.jAm = str2;
                hVar.jAn = j;
                hVar.bMT = i;
                hVar.mBitmap = c.aRe().CQ(hVar.mFilePath);
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(hVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(hVar.mBitmap != null ? hVar.mBitmap.isRecycled() : false);
                x.d(str4, str5, objArr);
                if (hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                    hVar.jEL = true;
                    hVar.jEK = 0;
                    hVar.mBitmap = c.aRe().b(str3, i, str2, j);
                } else {
                    hVar.jEL = false;
                }
                if (!(hVar.jEJ == null || hVar.mBitmap == null || hVar.mBitmap.isRecycled())) {
                    hVar.jEJ.aRO();
                }
                hVar.isa.invalidate();
            } else {
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature fuck filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(hVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(hVar.mBitmap != null ? hVar.mBitmap.isRecycled() : false);
                x.d(str4, str5, objArr);
            }
        }
        imageView.setImageDrawable(hVar);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
