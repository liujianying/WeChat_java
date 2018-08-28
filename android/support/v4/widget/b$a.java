package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

class b$a extends OvalShape {
    private RadialGradient yH;
    private Paint yI = new Paint();
    private int yJ;
    final /* synthetic */ b yK;

    public b$a(b bVar, int i, int i2) {
        this.yK = bVar;
        b.a(bVar, i);
        this.yJ = i2;
        this.yH = new RadialGradient((float) (this.yJ / 2), (float) (this.yJ / 2), (float) b.a(bVar), new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.yI.setShader(this.yH);
    }

    public final void draw(Canvas canvas, Paint paint) {
        int width = this.yK.getWidth();
        int height = this.yK.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.yJ / 2) + b.a(this.yK)), this.yI);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.yJ / 2), paint);
    }
}
