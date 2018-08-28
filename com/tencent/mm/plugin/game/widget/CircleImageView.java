package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.game.f.k;

public class CircleImageView extends ImageView {
    private static final Config dvc = Config.ARGB_8888;
    private static final ScaleType kgL = ScaleType.CENTER_CROP;
    private boolean fCi;
    private float fPH;
    private int fPI;
    private final Paint fPJ;
    private int fg;
    private ColorFilter jN;
    private final RectF kgM;
    private final RectF kgN;
    private final Paint kgO;
    private float kgP;
    private boolean kgQ;
    private boolean kgR;
    private Bitmap mBitmap;
    private BitmapShader rB;
    private final Matrix rC;
    private int rH;
    private int rI;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgM = new RectF();
        this.kgN = new RectF();
        this.rC = new Matrix();
        this.kgO = new Paint();
        this.fPJ = new Paint();
        this.fPI = -16777216;
        this.fg = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.CircleImageView, i, 0);
        this.fg = obtainStyledAttributes.getDimensionPixelSize(k.CircleImageView_border_width, 0);
        this.fPI = obtainStyledAttributes.getColor(k.CircleImageView_border_color, -16777216);
        this.kgR = obtainStyledAttributes.getBoolean(k.CircleImageView_border_overlay, false);
        obtainStyledAttributes.recycle();
        super.setScaleType(kgL);
        this.fCi = true;
        if (this.kgQ) {
            setup();
            this.kgQ = false;
        }
    }

    public ScaleType getScaleType() {
        return kgL;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != kgL) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.kgP, this.kgO);
            if (this.fg != 0) {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.fPH, this.fPJ);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public int getBorderColor() {
        return this.fPI;
    }

    public void setBorderColor(int i) {
        if (i != this.fPI) {
            this.fPI = i;
            this.fPJ.setColor(this.fPI);
            invalidate();
        }
    }

    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.fg;
    }

    public void setBorderWidth(int i) {
        if (i != this.fg) {
            this.fg = i;
            setup();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.kgR) {
            this.kgR = z;
            setup();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = o(drawable);
        setup();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.mBitmap = o(getDrawable());
        setup();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.mBitmap = o(getDrawable());
        setup();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.jN) {
            this.jN = colorFilter;
            this.kgO.setColorFilter(this.jN);
            invalidate();
        }
    }

    private static Bitmap o(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, dvc);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), dvc);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void setup() {
        if (!this.fCi) {
            this.kgQ = true;
        } else if (this.mBitmap != null) {
            float height;
            float width;
            float f;
            this.rB = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.kgO.setAntiAlias(true);
            this.kgO.setShader(this.rB);
            this.fPJ.setStyle(Style.STROKE);
            this.fPJ.setAntiAlias(true);
            this.fPJ.setColor(this.fPI);
            this.fPJ.setStrokeWidth((float) this.fg);
            this.rI = this.mBitmap.getHeight();
            this.rH = this.mBitmap.getWidth();
            this.kgN.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.fPH = Math.min((this.kgN.height() - ((float) this.fg)) / 2.0f, (this.kgN.width() - ((float) this.fg)) / 2.0f);
            this.kgM.set(this.kgN);
            if (!this.kgR) {
                this.kgM.inset((float) this.fg, (float) this.fg);
            }
            this.kgP = Math.min(this.kgM.height() / 2.0f, this.kgM.width() / 2.0f);
            this.rC.set(null);
            if (((float) this.rH) * this.kgM.height() > this.kgM.width() * ((float) this.rI)) {
                height = this.kgM.height() / ((float) this.rI);
                width = (this.kgM.width() - (((float) this.rH) * height)) * 0.5f;
                f = 0.0f;
            } else {
                height = this.kgM.width() / ((float) this.rH);
                f = (this.kgM.height() - (((float) this.rI) * height)) * 0.5f;
                width = 0.0f;
            }
            this.rC.setScale(height, height);
            this.rC.postTranslate(((float) ((int) (width + 0.5f))) + this.kgM.left, ((float) ((int) (f + 0.5f))) + this.kgM.top);
            this.rB.setLocalMatrix(this.rC);
            invalidate();
        }
    }
}
