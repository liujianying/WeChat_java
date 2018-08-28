package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.z;
import android.view.View;
import java.util.List;

public class FloatingActionButton$a extends Behavior<FloatingActionButton> {
    private static final boolean fp = (VERSION.SDK_INT >= 11);
    private Rect ea;
    private u fq;
    private float fr;

    public final /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        if (view2 instanceof SnackbarLayout) {
            float min;
            float f = 0.0f;
            List m = coordinatorLayout.m(floatingActionButton);
            int size = m.size();
            int i = 0;
            while (i < size) {
                View view3 = (View) m.get(i);
                if (view3 instanceof SnackbarLayout) {
                    boolean z;
                    if (floatingActionButton.getVisibility() == 0 && view3.getVisibility() == 0) {
                        Rect rect = coordinatorLayout.ex;
                        coordinatorLayout.a((View) floatingActionButton, floatingActionButton.getParent() != coordinatorLayout, rect);
                        Rect rect2 = coordinatorLayout.ey;
                        coordinatorLayout.a(view3, view3.getParent() != coordinatorLayout, rect2);
                        z = rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
                    } else {
                        z = false;
                    }
                    if (z) {
                        min = Math.min(f, z.R(view3) - ((float) view3.getHeight()));
                        i++;
                        f = min;
                    }
                }
                min = f;
                i++;
                f = min;
            }
            if (this.fr != f) {
                min = z.R(floatingActionButton);
                if (this.fq != null && this.fq.iO.isRunning()) {
                    this.fq.iO.cancel();
                }
                if (!floatingActionButton.isShown() || Math.abs(min - f) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                    z.c(floatingActionButton, f);
                } else {
                    if (this.fq == null) {
                        this.fq = aa.aP();
                        this.fq.setInterpolator(a.bM);
                        this.fq.a(new 1(this, floatingActionButton));
                    }
                    this.fq.p(min, f);
                    this.fq.iO.start();
                }
                this.fr = f;
            }
        } else if (view2 instanceof AppBarLayout) {
            a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ boolean d(View view) {
        return fp && (view instanceof SnackbarLayout);
    }

    private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
        if (((d) floatingActionButton.getLayoutParams()).eR != appBarLayout.getId()) {
            return false;
        }
        if (floatingActionButton.getUserSetVisibility() != 0) {
            return false;
        }
        if (this.ea == null) {
            this.ea = new Rect();
        }
        Rect rect = this.ea;
        x.a(coordinatorLayout, appBarLayout, rect);
        if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
            FloatingActionButton.a(floatingActionButton);
        } else {
            FloatingActionButton.b(floatingActionButton);
        }
        return true;
    }
}
