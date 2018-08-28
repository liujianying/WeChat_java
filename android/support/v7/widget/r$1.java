package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.af.a;

class r$1 implements a {
    final /* synthetic */ r Nz;

    r$1(r rVar) {
        this.Nz = rVar;
    }

    public final void a(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
