package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.mm.plugin.game.f.b;

public class GameRoundImageView extends AppCompatImageView {
    private static final PorterDuffXfermode kbG = new PorterDuffXfermode(Mode.SRC_IN);
    private Bitmap bitmap;
    private RectF kbE;
    private Bitmap kbF;
    private Rect rect;

    public GameRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        if (this.rect == null) {
            this.rect = new Rect(0, 0, getWidth(), getHeight());
        }
        if (this.kbE == null) {
            this.kbE = new RectF(this.rect);
        }
        if (!(this.bitmap == null || this.kbF == null)) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            canvas.drawBitmap(this.kbF, this.rect, this.rect, paint);
            paint.setXfermode(kbG);
            canvas.drawBitmap(this.bitmap, null, this.rect, paint);
            canvas.restoreToCount(saveLayer);
            paint.setXfermode(null);
        }
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(getResources().getColor(b.game_image_stroke_color));
        canvas.drawRoundRect(this.kbE, 18.0f, 18.0f, paint);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.kbE = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        this.rect = new Rect(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawRoundRect(this.kbE, 18.0f, 18.0f, paint);
        this.kbF = createBitmap;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        super.setImageBitmap(bitmap);
    }
}
