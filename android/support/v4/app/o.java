package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;

public abstract class o extends u {
    private final m ou;
    private q ov = null;
    private Fragment ow = null;

    public abstract Fragment V(int i);

    public o(m mVar) {
        this.ou = mVar;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.ov == null) {
            this.ov = this.ou.bk();
        }
        long j = (long) i;
        Fragment J = this.ou.J(b(viewGroup.getId(), j));
        if (J != null) {
            this.ov.d(J);
        } else {
            J = V(i);
            this.ov.a(viewGroup.getId(), J, b(viewGroup.getId(), j));
        }
        if (J != this.ow) {
            J.setMenuVisibility(false);
            J.setUserVisibleHint(false);
        }
        return J;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.ov == null) {
            this.ov = this.ou.bk();
        }
        this.ov.c((Fragment) obj);
    }

    public final void e(Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.ow) {
            if (this.ow != null) {
                this.ow.setMenuVisibility(false);
                this.ow.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.ow = fragment;
        }
    }

    public final void bo() {
        if (this.ov != null) {
            this.ov.commitAllowingStateLoss();
            this.ov = null;
            this.ou.executePendingTransactions();
        }
    }

    public final boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public final Parcelable bp() {
        return null;
    }

    public final void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    private static String b(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
