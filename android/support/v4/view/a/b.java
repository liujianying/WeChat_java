package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class b {
    public static final e xr;
    public final Object xs;

    public static class a {
        public static final a xA = new a((int) FileUtils.S_IWUSR);
        public static final a xB = new a(256);
        public static final a xC = new a(512);
        public static final a xD = new a(1024);
        public static final a xE = new a(2048);
        public static final a xF = new a(4096);
        public static final a xG = new a(8192);
        public static final a xH = new a(16384);
        public static final a xI = new a(32768);
        public static final a xJ = new a(65536);
        public static final a xK = new a(131072);
        public static final a xL = new a(262144);
        public static final a xM = new a((int) SQLiteGlobal.journalSizeLimit);
        public static final a xN = new a(1048576);
        public static final a xO = new a(2097152);
        public static final a xt = new a(1);
        public static final a xu = new a(2);
        public static final a xv = new a(4);
        public static final a xw = new a(8);
        public static final a xx = new a(16);
        public static final a xy = new a(32);
        public static final a xz = new a(64);
        private final Object xP;

        private a(int i) {
            this(b.xr.ap(i));
        }

        private a(Object obj) {
            this.xP = obj;
        }
    }

    interface e {
        boolean A(Object obj);

        boolean B(Object obj);

        void C(Object obj);

        int D(Object obj);

        boolean E(Object obj);

        boolean F(Object obj);

        String G(Object obj);

        void H(Object obj);

        void a(Object obj, Rect rect);

        void a(Object obj, CharSequence charSequence);

        Object ap(int i);

        Object b(int i, int i2, int i3, int i4, boolean z);

        void b(Object obj, int i);

        void b(Object obj, Rect rect);

        void b(Object obj, CharSequence charSequence);

        void b(Object obj, boolean z);

        void c(Object obj, int i);

        void c(Object obj, Rect rect);

        void c(Object obj, View view);

        void c(Object obj, CharSequence charSequence);

        void c(Object obj, boolean z);

        void d(Object obj, Rect rect);

        void d(Object obj, View view);

        void d(Object obj, CharSequence charSequence);

        void d(Object obj, boolean z);

        void e(Object obj, View view);

        void e(Object obj, CharSequence charSequence);

        void e(Object obj, boolean z);

        void f(Object obj, View view);

        void f(Object obj, boolean z);

        boolean f(Object obj, Object obj2);

        void g(Object obj, Object obj2);

        void g(Object obj, boolean z);

        void h(Object obj, Object obj2);

        void h(Object obj, boolean z);

        void i(Object obj, boolean z);

        void j(Object obj, boolean z);

        Object m(Object obj);

        int n(Object obj);

        CharSequence o(Object obj);

        CharSequence p(Object obj);

        CharSequence q(Object obj);

        CharSequence r(Object obj);

        Object r(int i, int i2);

        boolean s(Object obj);

        boolean t(Object obj);

        boolean u(Object obj);

        boolean v(Object obj);

        boolean w(Object obj);

        boolean x(Object obj);

        boolean y(Object obj);

        boolean z(Object obj);
    }

    public static class k {
        public final Object xs;

        public k(Object obj) {
            this.xs = obj;
        }
    }

    public static class l {
        final Object xs;

        public static l c(int i, int i2, int i3, int i4, boolean z) {
            return new l(b.xr.b(i, i2, i3, i4, z));
        }

        private l(Object obj) {
            this.xs = obj;
        }
    }

    static class j implements e {
        j() {
        }

        public Object ap(int i) {
            return null;
        }

        public Object m(Object obj) {
            return null;
        }

        public void b(Object obj, int i) {
        }

        public boolean f(Object obj, Object obj2) {
            return false;
        }

        public void c(Object obj, View view) {
        }

        public int n(Object obj) {
            return 0;
        }

        public void a(Object obj, Rect rect) {
        }

        public void b(Object obj, Rect rect) {
        }

        public CharSequence o(Object obj) {
            return null;
        }

        public CharSequence p(Object obj) {
            return null;
        }

        public CharSequence q(Object obj) {
            return null;
        }

        public CharSequence r(Object obj) {
            return null;
        }

        public boolean s(Object obj) {
            return false;
        }

        public boolean t(Object obj) {
            return false;
        }

        public boolean u(Object obj) {
            return false;
        }

        public boolean v(Object obj) {
            return false;
        }

        public boolean w(Object obj) {
            return false;
        }

        public boolean x(Object obj) {
            return false;
        }

        public boolean E(Object obj) {
            return false;
        }

        public boolean F(Object obj) {
            return false;
        }

        public boolean y(Object obj) {
            return false;
        }

        public boolean z(Object obj) {
            return false;
        }

        public boolean A(Object obj) {
            return false;
        }

        public boolean B(Object obj) {
            return false;
        }

        public void c(Object obj, int i) {
        }

        public int D(Object obj) {
            return 0;
        }

        public void c(Object obj, Rect rect) {
        }

        public void d(Object obj, Rect rect) {
        }

        public void b(Object obj, CharSequence charSequence) {
        }

        public void b(Object obj, boolean z) {
        }

        public void c(Object obj, CharSequence charSequence) {
        }

        public void c(Object obj, boolean z) {
        }

        public void d(Object obj, boolean z) {
        }

        public void e(Object obj, boolean z) {
        }

        public void i(Object obj, boolean z) {
        }

        public void j(Object obj, boolean z) {
        }

        public void f(Object obj, boolean z) {
        }

        public void d(Object obj, CharSequence charSequence) {
        }

        public void d(Object obj, View view) {
        }

        public void g(Object obj, boolean z) {
        }

        public void h(Object obj, boolean z) {
        }

        public void e(Object obj, View view) {
        }

        public void e(Object obj, CharSequence charSequence) {
        }

        public void C(Object obj) {
        }

        public String G(Object obj) {
            return null;
        }

        public void g(Object obj, Object obj2) {
        }

        public void h(Object obj, Object obj2) {
        }

        public Object r(int i, int i2) {
            return null;
        }

        public Object b(int i, int i2, int i3, int i4, boolean z) {
            return null;
        }

        public void H(Object obj) {
        }

        public void a(Object obj, CharSequence charSequence) {
        }

        public void f(Object obj, View view) {
        }
    }

    static class d extends j {
        d() {
        }

        public final Object m(Object obj) {
            return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
        }

        public final void b(Object obj, int i) {
            ((AccessibilityNodeInfo) obj).addAction(i);
        }

        public final void c(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).addChild(view);
        }

        public final int n(Object obj) {
            return ((AccessibilityNodeInfo) obj).getActions();
        }

        public final void a(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
        }

        public final void b(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
        }

        public final CharSequence o(Object obj) {
            return ((AccessibilityNodeInfo) obj).getClassName();
        }

        public final CharSequence p(Object obj) {
            return ((AccessibilityNodeInfo) obj).getContentDescription();
        }

        public final CharSequence q(Object obj) {
            return ((AccessibilityNodeInfo) obj).getPackageName();
        }

        public final CharSequence r(Object obj) {
            return ((AccessibilityNodeInfo) obj).getText();
        }

        public final boolean s(Object obj) {
            return ((AccessibilityNodeInfo) obj).isCheckable();
        }

        public final boolean t(Object obj) {
            return ((AccessibilityNodeInfo) obj).isChecked();
        }

        public final boolean u(Object obj) {
            return ((AccessibilityNodeInfo) obj).isClickable();
        }

        public final boolean v(Object obj) {
            return ((AccessibilityNodeInfo) obj).isEnabled();
        }

        public final boolean w(Object obj) {
            return ((AccessibilityNodeInfo) obj).isFocusable();
        }

        public final boolean x(Object obj) {
            return ((AccessibilityNodeInfo) obj).isFocused();
        }

        public final boolean y(Object obj) {
            return ((AccessibilityNodeInfo) obj).isLongClickable();
        }

        public final boolean z(Object obj) {
            return ((AccessibilityNodeInfo) obj).isPassword();
        }

        public final boolean A(Object obj) {
            return ((AccessibilityNodeInfo) obj).isScrollable();
        }

        public final boolean B(Object obj) {
            return ((AccessibilityNodeInfo) obj).isSelected();
        }

        public final void c(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
        }

        public final void d(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
        }

        public final void b(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setClassName(charSequence);
        }

        public final void b(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setClickable(z);
        }

        public final void c(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
        }

        public final void c(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setEnabled(z);
        }

        public final void d(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setFocusable(z);
        }

        public final void e(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setFocused(z);
        }

        public final void f(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setLongClickable(z);
        }

        public final void d(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
        }

        public final void d(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setParent(view);
        }

        public final void g(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setScrollable(z);
        }

        public final void h(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setSelected(z);
        }

        public final void e(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setSource(view);
        }

        public final void e(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setText(charSequence);
        }

        public final void C(Object obj) {
            ((AccessibilityNodeInfo) obj).recycle();
        }
    }

    static class f extends d {
        f() {
        }

        public final boolean E(Object obj) {
            return ((AccessibilityNodeInfo) obj).isVisibleToUser();
        }

        public final void i(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
        }

        public final boolean F(Object obj) {
            return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
        }

        public final void j(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
        }

        public final void c(Object obj, int i) {
            ((AccessibilityNodeInfo) obj).setMovementGranularities(i);
        }

        public final int D(Object obj) {
            return ((AccessibilityNodeInfo) obj).getMovementGranularities();
        }
    }

    static class g extends f {
        g() {
        }

        public final void f(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setLabelFor(view);
        }
    }

    static class h extends g {
        h() {
        }

        public final String G(Object obj) {
            return ((AccessibilityNodeInfo) obj).getViewIdResourceName();
        }
    }

    static class i extends h {
        i() {
        }

        public final void g(Object obj, Object obj2) {
            ((AccessibilityNodeInfo) obj).setCollectionInfo((CollectionInfo) obj2);
        }

        public Object r(int i, int i2) {
            return CollectionInfo.obtain(i, i2, false);
        }

        public Object b(int i, int i2, int i3, int i4, boolean z) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        public final void h(Object obj, Object obj2) {
            ((AccessibilityNodeInfo) obj).setCollectionItemInfo((CollectionItemInfo) obj2);
        }

        public final void H(Object obj) {
            ((AccessibilityNodeInfo) obj).setContentInvalid(true);
        }
    }

    static class b extends i {
        b() {
        }

        public final Object ap(int i) {
            return new AccessibilityAction(i, null);
        }

        public final Object r(int i, int i2) {
            return CollectionInfo.obtain(i, i2, false, 0);
        }

        public final boolean f(Object obj, Object obj2) {
            return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityAction) obj2);
        }

        public final Object b(int i, int i2, int i3, int i4, boolean z) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z, false);
        }

        public final void a(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setError(charSequence);
        }
    }

    static class c extends b {
        c() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 22) {
            xr = new c();
        } else if (VERSION.SDK_INT >= 21) {
            xr = new b();
        } else if (VERSION.SDK_INT >= 19) {
            xr = new i();
        } else if (VERSION.SDK_INT >= 18) {
            xr = new h();
        } else if (VERSION.SDK_INT >= 17) {
            xr = new g();
        } else if (VERSION.SDK_INT >= 16) {
            xr = new f();
        } else if (VERSION.SDK_INT >= 14) {
            xr = new d();
        } else {
            xr = new j();
        }
    }

    public b(Object obj) {
        this.xs = obj;
    }

    public static b a(b bVar) {
        Object m = xr.m(bVar.xs);
        return m != null ? new b(m) : null;
    }

    public final void setSource(View view) {
        xr.e(this.xs, view);
    }

    public final void addChild(View view) {
        xr.c(this.xs, view);
    }

    public final int getActions() {
        return xr.n(this.xs);
    }

    public final void addAction(int i) {
        xr.b(this.xs, i);
    }

    public final boolean a(a aVar) {
        return xr.f(this.xs, aVar.xP);
    }

    public final void setParent(View view) {
        xr.d(this.xs, view);
    }

    public final void getBoundsInParent(Rect rect) {
        xr.a(this.xs, rect);
    }

    public final void setBoundsInParent(Rect rect) {
        xr.c(this.xs, rect);
    }

    public final void getBoundsInScreen(Rect rect) {
        xr.b(this.xs, rect);
    }

    public final void setBoundsInScreen(Rect rect) {
        xr.d(this.xs, rect);
    }

    public final boolean isFocusable() {
        return xr.w(this.xs);
    }

    public final void setFocusable(boolean z) {
        xr.d(this.xs, z);
    }

    public final boolean isFocused() {
        return xr.x(this.xs);
    }

    public final void setFocused(boolean z) {
        xr.e(this.xs, z);
    }

    public final boolean isVisibleToUser() {
        return xr.E(this.xs);
    }

    public final void setVisibleToUser(boolean z) {
        xr.i(this.xs, z);
    }

    public final boolean isAccessibilityFocused() {
        return xr.F(this.xs);
    }

    public final void setAccessibilityFocused(boolean z) {
        xr.j(this.xs, z);
    }

    public final boolean isSelected() {
        return xr.B(this.xs);
    }

    public final void setSelected(boolean z) {
        xr.h(this.xs, z);
    }

    public final boolean isClickable() {
        return xr.u(this.xs);
    }

    public final void setClickable(boolean z) {
        xr.b(this.xs, z);
    }

    public final boolean isLongClickable() {
        return xr.y(this.xs);
    }

    public final void setLongClickable(boolean z) {
        xr.f(this.xs, z);
    }

    public final boolean isEnabled() {
        return xr.v(this.xs);
    }

    public final void setEnabled(boolean z) {
        xr.c(this.xs, z);
    }

    public final void setScrollable(boolean z) {
        xr.g(this.xs, z);
    }

    public final CharSequence getPackageName() {
        return xr.q(this.xs);
    }

    public final void setPackageName(CharSequence charSequence) {
        xr.d(this.xs, charSequence);
    }

    public final CharSequence getClassName() {
        return xr.o(this.xs);
    }

    public final void setClassName(CharSequence charSequence) {
        xr.b(this.xs, charSequence);
    }

    public final void setText(CharSequence charSequence) {
        xr.e(this.xs, charSequence);
    }

    public final CharSequence getContentDescription() {
        return xr.p(this.xs);
    }

    public final void setContentDescription(CharSequence charSequence) {
        xr.c(this.xs, charSequence);
    }

    public final void recycle() {
        xr.C(this.xs);
    }

    public final void l(Object obj) {
        xr.h(this.xs, ((l) obj).xs);
    }

    public final int hashCode() {
        return this.xs == null ? 0 : this.xs.hashCode();
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
        b bVar = (b) obj;
        if (this.xs == null) {
            if (bVar.xs != null) {
                return false;
            }
            return true;
        } else if (this.xs.equals(bVar.xs)) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(getPackageName());
        stringBuilder.append("; className: ").append(getClassName());
        stringBuilder.append("; text: ").append(xr.r(this.xs));
        stringBuilder.append("; contentDescription: ").append(getContentDescription());
        stringBuilder.append("; viewId: ").append(xr.G(this.xs));
        stringBuilder.append("; checkable: ").append(xr.s(this.xs));
        stringBuilder.append("; checked: ").append(xr.t(this.xs));
        stringBuilder.append("; focusable: ").append(isFocusable());
        stringBuilder.append("; focused: ").append(isFocused());
        stringBuilder.append("; selected: ").append(isSelected());
        stringBuilder.append("; clickable: ").append(isClickable());
        stringBuilder.append("; longClickable: ").append(isLongClickable());
        stringBuilder.append("; enabled: ").append(isEnabled());
        stringBuilder.append("; password: ").append(xr.z(this.xs));
        stringBuilder.append("; scrollable: " + xr.A(this.xs));
        stringBuilder.append("; [");
        int actions = getActions();
        while (actions != 0) {
            String str;
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            int i = (numberOfTrailingZeros ^ -1) & actions;
            switch (numberOfTrailingZeros) {
                case 1:
                    str = "ACTION_FOCUS";
                    break;
                case 2:
                    str = "ACTION_CLEAR_FOCUS";
                    break;
                case 4:
                    str = "ACTION_SELECT";
                    break;
                case 8:
                    str = "ACTION_CLEAR_SELECTION";
                    break;
                case 16:
                    str = "ACTION_CLICK";
                    break;
                case 32:
                    str = "ACTION_LONG_CLICK";
                    break;
                case 64:
                    str = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                case FileUtils.S_IWUSR /*128*/:
                    str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                case 256:
                    str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                case 512:
                    str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                case 1024:
                    str = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                case 2048:
                    str = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                case 4096:
                    str = "ACTION_SCROLL_FORWARD";
                    break;
                case 8192:
                    str = "ACTION_SCROLL_BACKWARD";
                    break;
                case 16384:
                    str = "ACTION_COPY";
                    break;
                case 32768:
                    str = "ACTION_PASTE";
                    break;
                case 65536:
                    str = "ACTION_CUT";
                    break;
                case 131072:
                    str = "ACTION_SET_SELECTION";
                    break;
                default:
                    str = "ACTION_UNKNOWN";
                    break;
            }
            stringBuilder.append(str);
            if (i != 0) {
                stringBuilder.append(", ");
            }
            actions = i;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
