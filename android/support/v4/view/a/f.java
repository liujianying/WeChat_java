package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public final class f {
    public static final c xX;
    public final Object xY;

    interface c {
        Object cx();

        void d(Object obj, int i);

        void e(Object obj, int i);

        void f(Object obj, int i);

        void g(Object obj, int i);

        void g(Object obj, boolean z);

        void h(Object obj, int i);

        void i(Object obj, int i);

        void j(Object obj, int i);
    }

    static class e implements c {
        e() {
        }

        public Object cx() {
            return null;
        }

        public void d(Object obj, int i) {
        }

        public void e(Object obj, int i) {
        }

        public void i(Object obj, int i) {
        }

        public void j(Object obj, int i) {
        }

        public void f(Object obj, int i) {
        }

        public void g(Object obj, int i) {
        }

        public void g(Object obj, boolean z) {
        }

        public void h(Object obj, int i) {
        }
    }

    static class a extends e {
        a() {
        }

        public final Object cx() {
            return AccessibilityRecord.obtain();
        }

        public final void d(Object obj, int i) {
            ((AccessibilityRecord) obj).setFromIndex(i);
        }

        public final void e(Object obj, int i) {
            ((AccessibilityRecord) obj).setItemCount(i);
        }

        public final void f(Object obj, int i) {
            ((AccessibilityRecord) obj).setScrollX(i);
        }

        public final void g(Object obj, int i) {
            ((AccessibilityRecord) obj).setScrollY(i);
        }

        public final void g(Object obj, boolean z) {
            ((AccessibilityRecord) obj).setScrollable(z);
        }

        public final void h(Object obj, int i) {
            ((AccessibilityRecord) obj).setToIndex(i);
        }
    }

    static class b extends a {
        b() {
        }

        public final void i(Object obj, int i) {
            ((AccessibilityRecord) obj).setMaxScrollX(i);
        }

        public final void j(Object obj, int i) {
            ((AccessibilityRecord) obj).setMaxScrollY(i);
        }
    }

    static class d extends b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            xX = new d();
        } else if (VERSION.SDK_INT >= 15) {
            xX = new b();
        } else if (VERSION.SDK_INT >= 14) {
            xX = new a();
        } else {
            xX = new e();
        }
    }

    public f(Object obj) {
        this.xY = obj;
    }

    public static f cw() {
        return new f(xX.cx());
    }

    public final void setScrollable(boolean z) {
        xX.g(this.xY, z);
    }

    public final void setItemCount(int i) {
        xX.e(this.xY, i);
    }

    public final void setFromIndex(int i) {
        xX.d(this.xY, i);
    }

    public final void setToIndex(int i) {
        xX.h(this.xY, i);
    }

    public final int hashCode() {
        return this.xY == null ? 0 : this.xY.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.xY == null) {
            if (fVar.xY != null) {
                return false;
            }
            return true;
        } else if (this.xY.equals(fVar.xY)) {
            return true;
        } else {
            return false;
        }
    }
}
