package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i {
    private static final c zY;
    private Object zX;

    interface c {
        boolean J(Object obj);

        void K(Object obj);

        boolean L(Object obj);

        Object Q(Context context);

        void a(Object obj, int i, int i2);

        boolean a(Object obj, float f);

        boolean a(Object obj, float f, float f2);

        boolean a(Object obj, Canvas canvas);

        boolean k(Object obj, int i);
    }

    static class a implements c {
        a() {
        }

        public final Object Q(Context context) {
            return null;
        }

        public final void a(Object obj, int i, int i2) {
        }

        public final boolean J(Object obj) {
            return true;
        }

        public final void K(Object obj) {
        }

        public final boolean a(Object obj, float f) {
            return false;
        }

        public final boolean L(Object obj) {
            return false;
        }

        public final boolean k(Object obj, int i) {
            return false;
        }

        public final boolean a(Object obj, Canvas canvas) {
            return false;
        }

        public final boolean a(Object obj, float f, float f2) {
            return false;
        }
    }

    static class b implements c {
        b() {
        }

        public final Object Q(Context context) {
            return new EdgeEffect(context);
        }

        public final void a(Object obj, int i, int i2) {
            ((EdgeEffect) obj).setSize(i, i2);
        }

        public final boolean J(Object obj) {
            return ((EdgeEffect) obj).isFinished();
        }

        public final void K(Object obj) {
            ((EdgeEffect) obj).finish();
        }

        public final boolean a(Object obj, float f) {
            return j.a(obj, f);
        }

        public final boolean L(Object obj) {
            EdgeEffect edgeEffect = (EdgeEffect) obj;
            edgeEffect.onRelease();
            return edgeEffect.isFinished();
        }

        public final boolean k(Object obj, int i) {
            ((EdgeEffect) obj).onAbsorb(i);
            return true;
        }

        public final boolean a(Object obj, Canvas canvas) {
            return ((EdgeEffect) obj).draw(canvas);
        }

        public boolean a(Object obj, float f, float f2) {
            return j.a(obj, f);
        }
    }

    static class d extends b {
        d() {
        }

        public final boolean a(Object obj, float f, float f2) {
            ((EdgeEffect) obj).onPull(f, f2);
            return true;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            zY = new d();
        } else if (VERSION.SDK_INT >= 14) {
            zY = new b();
        } else {
            zY = new a();
        }
    }

    public i(Context context) {
        this.zX = zY.Q(context);
    }

    public final void setSize(int i, int i2) {
        zY.a(this.zX, i, i2);
    }

    public final boolean isFinished() {
        return zY.J(this.zX);
    }

    public final void finish() {
        zY.K(this.zX);
    }

    public final boolean A(float f) {
        return zY.a(this.zX, f);
    }

    public final boolean s(float f, float f2) {
        return zY.a(this.zX, f, f2);
    }

    public final boolean cI() {
        return zY.L(this.zX);
    }

    public final boolean at(int i) {
        return zY.k(this.zX, i);
    }

    public final boolean draw(Canvas canvas) {
        return zY.a(this.zX, canvas);
    }
}
