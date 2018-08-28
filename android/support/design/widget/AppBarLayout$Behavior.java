package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout.LayoutParams;
import android.support.design.widget.AppBarLayout.a;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppBarLayout$Behavior extends HeaderBehavior<AppBarLayout> {
    private int bZ;
    private boolean ca;
    private boolean cb;
    private u cc;
    private int cd = -1;
    private boolean ce;
    private float cf;
    private WeakReference<View> cg;
    private a ch;

    final /* synthetic */ boolean S() {
        if (this.ch != null) {
            return this.ch.U();
        }
        if (this.cg != null) {
            View view = (View) this.cg.get();
            if (view == null || !view.isShown() || z.h(view, -1)) {
                return false;
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ int T() {
        return super.T();
    }

    public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        if (((d) appBarLayout.getLayoutParams()).height != -2) {
            return super.a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }
        coordinatorLayout.a(appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
        return true;
    }

    final /* synthetic */ int b(View view) {
        return ((AppBarLayout) view).getTotalScrollRange();
    }

    public final /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, View view) {
        boolean z = false;
        AppBarLayout appBarLayout = (AppBarLayout) view;
        Parcelable b = super.b(coordinatorLayout, appBarLayout);
        int T = super.T();
        int childCount = appBarLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = appBarLayout.getChildAt(i);
            int bottom = childAt.getBottom() + T;
            if (childAt.getTop() + T > 0 || bottom < 0) {
                i++;
            } else {
                SavedState savedState = new SavedState(b);
                savedState.cl = i;
                if (bottom == z.T(childAt)) {
                    z = true;
                }
                savedState.cn = z;
                savedState.cm = ((float) bottom) / ((float) childAt.getHeight());
                return savedState;
            }
        }
        return b;
    }

    public final /* synthetic */ void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        if (i < 0) {
            b(coordinatorLayout, appBarLayout, i, -AppBarLayout.d(appBarLayout), 0);
            this.ca = true;
            return;
        }
        this.ca = false;
    }

    final /* synthetic */ int c(View view) {
        return -AppBarLayout.d((AppBarLayout) view);
    }

    public final /* bridge */ /* synthetic */ boolean p(int i) {
        return super.p(i);
    }

    public AppBarLayout$Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        int R = R();
        if (R != i) {
            if (this.cc == null) {
                this.cc = aa.aP();
                this.cc.setInterpolator(a.bP);
                this.cc.a(new 1(this, coordinatorLayout, appBarLayout));
            } else {
                this.cc.iO.cancel();
            }
            this.cc.setDuration(Math.round(((((float) Math.abs(R - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
            this.cc.i(R, i);
            this.cc.iO.start();
        } else if (this.cc != null && this.cc.iO.isRunning()) {
            this.cc.iO.cancel();
        }
    }

    private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        int i;
        View view;
        int R = R();
        int childCount = appBarLayout.getChildCount();
        for (i = 0; i < childCount; i++) {
            View childAt = appBarLayout.getChildAt(i);
            if (childAt.getTop() <= (-R) && childAt.getBottom() >= (-R)) {
                view = childAt;
                break;
            }
        }
        view = null;
        if (view != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if ((layoutParams.co & 17) == 17) {
                int T;
                childCount = -view.getTop();
                i = -view.getBottom();
                if ((layoutParams.co & 2) == 2) {
                    T = z.T(view) + i;
                } else {
                    T = i;
                }
                if (R >= (T + childCount) / 2) {
                    T = childCount;
                }
                a(coordinatorLayout, appBarLayout, n.e(T, -appBarLayout.getTotalScrollRange(), 0));
            }
        }
    }

    private void j(AppBarLayout appBarLayout) {
        List h = AppBarLayout.h(appBarLayout);
        int size = h.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) h.get(i);
            if (aVar != null) {
                aVar.a(appBarLayout, super.T());
            }
        }
    }

    final int R() {
        return super.T() + this.bZ;
    }
}
