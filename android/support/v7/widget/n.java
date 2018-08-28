package android.support.v7.widget;

import android.content.Context;
import android.view.View;

final class n implements q {
    n() {
    }

    public final void a(o oVar, Context context, int i, float f, float f2, float f3) {
        oVar.setBackgroundDrawable(new ae(i, f));
        View view = (View) oVar;
        view.setClipToOutline(true);
        view.setElevation(f2);
        b(oVar, f3);
    }

    public final void a(o oVar, float f) {
        ae aeVar = (ae) oVar.getBackground();
        if (f != aeVar.Tl) {
            aeVar.Tl = f;
            aeVar.h(null);
            aeVar.invalidateSelf();
        }
    }

    public final void eN() {
    }

    public final void b(o oVar, float f) {
        ae aeVar = (ae) oVar.getBackground();
        boolean useCompatPadding = oVar.getUseCompatPadding();
        boolean preventCornerOverlap = oVar.getPreventCornerOverlap();
        if (!(f == aeVar.To && aeVar.Tp == useCompatPadding && aeVar.Tq == preventCornerOverlap)) {
            aeVar.To = f;
            aeVar.Tp = useCompatPadding;
            aeVar.Tq = preventCornerOverlap;
            aeVar.h(null);
            aeVar.invalidateSelf();
        }
        if (oVar.getUseCompatPadding()) {
            float a = a(oVar);
            float d = d(oVar);
            int ceil = (int) Math.ceil((double) af.d(a, d, oVar.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) af.c(a, d, oVar.getPreventCornerOverlap()));
            oVar.d(ceil, ceil2, ceil, ceil2);
            return;
        }
        oVar.d(0, 0, 0, 0);
    }

    public final float a(o oVar) {
        return ((ae) oVar.getBackground()).To;
    }

    public final float b(o oVar) {
        return d(oVar) * 2.0f;
    }

    public final float c(o oVar) {
        return d(oVar) * 2.0f;
    }

    public final float d(o oVar) {
        return ((ae) oVar.getBackground()).Tl;
    }

    public final void c(o oVar, float f) {
        ((View) oVar).setElevation(f);
    }

    public final float e(o oVar) {
        return ((View) oVar).getElevation();
    }

    public final void f(o oVar) {
        b(oVar, a(oVar));
    }

    public final void g(o oVar) {
        b(oVar, a(oVar));
    }

    public final void a(o oVar, int i) {
        ae aeVar = (ae) oVar.getBackground();
        aeVar.cN.setColor(i);
        aeVar.invalidateSelf();
    }
}
