package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R;

public class RoundCornerImageView extends ImageView {
    private int roundHeight = 8;
    private int roundWidth = 8;

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.RoundCornerImageView);
            this.roundWidth = obtainStyledAttributes.getDimensionPixelSize(R.n.RoundCornerImageView_roundWidth, this.roundWidth);
            this.roundHeight = obtainStyledAttributes.getDimensionPixelSize(R.n.RoundCornerImageView_roundHeight, this.roundHeight);
            obtainStyledAttributes.recycle();
            return;
        }
        float f = context.getResources().getDisplayMetrics().density;
        this.roundWidth = (int) (((float) this.roundWidth) * f);
        this.roundHeight = (int) (f * ((float) this.roundHeight));
    }

    public void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        if (createBitmap.isRecycled()) {
            createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
            canvas2 = new Canvas(createBitmap);
        }
        super.draw(canvas2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) this.roundWidth, (float) this.roundHeight, Direction.CW);
        path.setFillType(FillType.INVERSE_WINDING);
        canvas2.drawPath(path, paint);
        Paint paint2 = new Paint();
        paint2.setXfermode(null);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
        createBitmap.recycle();
    }
}
