package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class p implements q {
    final RectF Nx = new RectF();

    p() {
    }

    public void eN() {
        af.Ts = new af$a() {
            public final void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    p.this.Nx.set(-f3, -f3, f3, f3);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(p.this.Nx, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.Nx, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.Nx, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.Nx, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, 1.0f + (rectF.bottom - f3), 1.0f + (rectF.right - f3), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, Math.max(0.0f, f - 1.0f) + rectF.top, rectF.right, 1.0f + (rectF.bottom - f), paint);
            }
        };
    }

    public final void a(o oVar, Context context, int i, float f, float f2, float f3) {
        af afVar = new af(context.getResources(), i, f, f2, f3);
        afVar.U(oVar.getPreventCornerOverlap());
        oVar.setBackgroundDrawable(afVar);
        h(oVar);
    }

    private void h(o oVar) {
        Rect rect = new Rect();
        i(oVar).getPadding(rect);
        oVar.E((int) Math.ceil((double) b(oVar)), (int) Math.ceil((double) c(oVar)));
        oVar.d(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void f(o oVar) {
    }

    public final void g(o oVar) {
        i(oVar).U(oVar.getPreventCornerOverlap());
        h(oVar);
    }

    public final void a(o oVar, int i) {
        af i2 = i(oVar);
        i2.cN.setColor(i);
        i2.invalidateSelf();
    }

    public final void a(o oVar, float f) {
        af i = i(oVar);
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (i.go != f2) {
            i.go = f2;
            i.gu = true;
            i.invalidateSelf();
        }
        h(oVar);
    }

    public final float d(o oVar) {
        return i(oVar).go;
    }

    public final void c(o oVar, float f) {
        af i = i(oVar);
        i.o(f, i.gr);
    }

    public final float e(o oVar) {
        return i(oVar).gt;
    }

    public final void b(o oVar, float f) {
        af i = i(oVar);
        i.o(i.gt, f);
        h(oVar);
    }

    public final float a(o oVar) {
        return i(oVar).gr;
    }

    public final float b(o oVar) {
        af i = i(oVar);
        return ((((float) i.Tr) + i.gr) * 2.0f) + (Math.max(i.gr, (i.go + ((float) i.Tr)) + (i.gr / 2.0f)) * 2.0f);
    }

    public final float c(o oVar) {
        af i = i(oVar);
        return ((((float) i.Tr) + (i.gr * 1.5f)) * 2.0f) + (Math.max(i.gr, (i.go + ((float) i.Tr)) + ((i.gr * 1.5f) / 2.0f)) * 2.0f);
    }

    private static af i(o oVar) {
        return (af) oVar.getBackground();
    }
}
