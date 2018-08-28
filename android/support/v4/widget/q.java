package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;

public final class q {
    Object Bd;
    a Be;

    interface a {
        boolean J(Object obj);

        int M(Object obj);

        int N(Object obj);

        float O(Object obj);

        boolean P(Object obj);

        void Q(Object obj);

        int R(Object obj);

        int S(Object obj);

        void a(Object obj, int i, int i2, int i3);

        void a(Object obj, int i, int i2, int i3, int i4, int i5);

        void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7);

        Object b(Context context, Interpolator interpolator);

        void b(Object obj, int i, int i2, int i3, int i4, int i5);

        boolean b(Object obj, int i, int i2, int i3);
    }

    static class b implements a {
        b() {
        }

        public final Object b(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public final boolean J(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public final int M(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public final int N(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public final float O(Object obj) {
            return 0.0f;
        }

        public final boolean P(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public final void a(Object obj, int i, int i2, int i3) {
            ((Scroller) obj).startScroll(i, i2, 0, i3);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            ((Scroller) obj).fling(0, i, i2, i3, i4, i5, i6, i7);
        }

        public final void b(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).fling(i, i2, 0, i3, 0, 0, 0, i4);
        }

        public final void Q(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public final int R(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public final int S(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        public final boolean b(Object obj, int i, int i2, int i3) {
            return false;
        }
    }

    static class c implements a {
        c() {
        }

        public final Object b(Context context, Interpolator interpolator) {
            return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
        }

        public final boolean J(Object obj) {
            return ((OverScroller) obj).isFinished();
        }

        public final int M(Object obj) {
            return ((OverScroller) obj).getCurrX();
        }

        public final int N(Object obj) {
            return ((OverScroller) obj).getCurrY();
        }

        public float O(Object obj) {
            return 0.0f;
        }

        public final boolean P(Object obj) {
            return ((OverScroller) obj).computeScrollOffset();
        }

        public final void a(Object obj, int i, int i2, int i3) {
            ((OverScroller) obj).startScroll(i, i2, 0, i3);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            ((OverScroller) obj).fling(0, i, i2, i3, i4, i5, i6, i7);
        }

        public final void b(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((OverScroller) obj).fling(i, i2, 0, i3, 0, 0, 0, i4, 0, i5);
        }

        public final void Q(Object obj) {
            ((OverScroller) obj).abortAnimation();
        }

        public final int R(Object obj) {
            return ((OverScroller) obj).getFinalX();
        }

        public final int S(Object obj) {
            return ((OverScroller) obj).getFinalY();
        }

        public final boolean b(Object obj, int i, int i2, int i3) {
            return ((OverScroller) obj).springBack(i, i2, 0, 0, 0, i3);
        }
    }

    static class d extends c {
        d() {
        }

        public final float O(Object obj) {
            return ((OverScroller) obj).getCurrVelocity();
        }
    }

    public static q a(Context context, Interpolator interpolator) {
        return new q(VERSION.SDK_INT, context, interpolator);
    }

    private q(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.Be = new d();
        } else if (i >= 9) {
            this.Be = new c();
        } else {
            this.Be = new b();
        }
        this.Bd = this.Be.b(context, interpolator);
    }

    public final boolean isFinished() {
        return this.Be.J(this.Bd);
    }

    public final int getCurrX() {
        return this.Be.M(this.Bd);
    }

    public final int getCurrY() {
        return this.Be.N(this.Bd);
    }

    public final int getFinalX() {
        return this.Be.R(this.Bd);
    }

    public final int getFinalY() {
        return this.Be.S(this.Bd);
    }

    public final float getCurrVelocity() {
        return this.Be.O(this.Bd);
    }

    public final boolean computeScrollOffset() {
        return this.Be.P(this.Bd);
    }

    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.Be.a(this.Bd, i, i2, i3, i4, i5);
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.Be.a(this.Bd, i, i2, i3, i4, i5, i6, i7);
    }

    public final boolean i(int i, int i2, int i3) {
        return this.Be.b(this.Bd, i, i2, i3);
    }

    public final void abortAnimation() {
        this.Be.Q(this.Bd);
    }
}
