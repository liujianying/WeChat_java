package android.support.design.widget;

import android.view.animation.Interpolator;

final class u {
    final e iO;

    /* renamed from: android.support.design.widget.u$2 */
    class AnonymousClass2 implements a {
        final /* synthetic */ a iR;

        AnonymousClass2(a aVar) {
            this.iR = aVar;
        }

        public final void onAnimationEnd() {
            this.iR.aK();
        }
    }

    interface a {
        void aK();
    }

    u(e eVar) {
        this.iO = eVar;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.iO.setInterpolator(interpolator);
    }

    public final void a(final c cVar) {
        this.iO.a(new b() {
            public final void aO() {
                cVar.a(u.this);
            }
        });
    }

    public final void i(int i, int i2) {
        this.iO.i(i, i2);
    }

    public final void p(float f, float f2) {
        this.iO.p(f, f2);
    }

    public final void setDuration(int i) {
        this.iO.setDuration(i);
    }
}
