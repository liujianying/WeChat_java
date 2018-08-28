package android.support.design.widget;

import android.support.design.widget.AppBarLayout.a;
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams;
import android.support.v4.view.z;
import android.view.View;

class CollapsingToolbarLayout$a implements a {
    final /* synthetic */ CollapsingToolbarLayout el;

    private CollapsingToolbarLayout$a(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.el = collapsingToolbarLayout;
    }

    /* synthetic */ CollapsingToolbarLayout$a(CollapsingToolbarLayout collapsingToolbarLayout, byte b) {
        this(collapsingToolbarLayout);
    }

    public final void a(AppBarLayout appBarLayout, int i) {
        int systemWindowInsetTop;
        boolean z = false;
        CollapsingToolbarLayout.b(this.el, i);
        if (CollapsingToolbarLayout.a(this.el) != null) {
            systemWindowInsetTop = CollapsingToolbarLayout.a(this.el).getSystemWindowInsetTop();
        } else {
            systemWindowInsetTop = 0;
        }
        int totalScrollRange = appBarLayout.getTotalScrollRange();
        int childCount = this.el.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.el.getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            z k = CollapsingToolbarLayout.k(childAt);
            switch (layoutParams.em) {
                case 1:
                    if ((this.el.getHeight() - systemWindowInsetTop) + i < childAt.getHeight()) {
                        break;
                    }
                    k.p(-i);
                    break;
                case 2:
                    k.p(Math.round(layoutParams.en * ((float) (-i))));
                    break;
                default:
                    break;
            }
        }
        if (!(CollapsingToolbarLayout.b(this.el) == null && CollapsingToolbarLayout.c(this.el) == null)) {
            CollapsingToolbarLayout collapsingToolbarLayout = this.el;
            if (this.el.getHeight() + i < this.el.getScrimTriggerOffset() + systemWindowInsetTop) {
                z = true;
            }
            collapsingToolbarLayout.setScrimsShown(z);
        }
        if (CollapsingToolbarLayout.c(this.el) != null && systemWindowInsetTop > 0) {
            z.E(this.el);
        }
        CollapsingToolbarLayout.d(this.el).h(((float) Math.abs(i)) / ((float) ((this.el.getHeight() - z.T(this.el)) - systemWindowInsetTop)));
        if (Math.abs(i) == totalScrollRange) {
            z.g(appBarLayout, appBarLayout.getTargetElevation());
        } else {
            z.g(appBarLayout, 0.0f);
        }
    }
}
