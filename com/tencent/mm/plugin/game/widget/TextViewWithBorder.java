package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.tencent.mm.plugin.game.f.b;

public class TextViewWithBorder extends AppCompatTextView {
    public TextViewWithBorder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setColor(getResources().getColor(b.game_title_hint));
        canvas.drawRoundRect(new RectF(2.0f, 2.0f, (float) (getWidth() - 2), (float) (getHeight() - 2)), 5.0f, 5.0f, paint);
        super.onDraw(canvas);
    }
}
