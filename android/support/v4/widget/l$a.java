package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

class l$a {
    int AA;
    final Paint AB = new Paint(1);
    int AC;
    final RectF Ak = new RectF();
    final Paint Al = new Paint();
    float Am = 0.0f;
    float An = 0.0f;
    float Ao = 2.5f;
    int[] Ap;
    int Aq;
    float Ar;
    float As;
    float At;
    boolean Au;
    Path Av;
    float Aw;
    double Ax;
    int Ay;
    int Az;
    final Paint cN = new Paint();
    float cY = 0.0f;
    float jW = 5.0f;
    private final Callback jy;
    int ru;

    public l$a(Callback callback) {
        this.jy = callback;
        this.cN.setStrokeCap(Cap.SQUARE);
        this.cN.setAntiAlias(true);
        this.cN.setStyle(Style.STROKE);
        this.Al.setStyle(Style.FILL);
        this.Al.setAntiAlias(true);
    }

    public final void setColors(int[] iArr) {
        this.Ap = iArr;
        av(0);
    }

    public final void av(int i) {
        this.Aq = i;
        this.ru = this.Ap[this.Aq];
    }

    final int cK() {
        return (this.Aq + 1) % this.Ap.length;
    }

    public final void D(float f) {
        this.Am = f;
        invalidateSelf();
    }

    public final void E(float f) {
        this.An = f;
        invalidateSelf();
    }

    public final void setRotation(float f) {
        this.cY = f;
        invalidateSelf();
    }

    public final void B(boolean z) {
        if (this.Au != z) {
            this.Au = z;
            invalidateSelf();
        }
    }

    public final void cL() {
        this.Ar = this.Am;
        this.As = this.An;
        this.At = this.cY;
    }

    public final void cM() {
        this.Ar = 0.0f;
        this.As = 0.0f;
        this.At = 0.0f;
        D(0.0f);
        E(0.0f);
        setRotation(0.0f);
    }

    final void invalidateSelf() {
        this.jy.invalidateDrawable(null);
    }
}
