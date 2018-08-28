package android.support.design.widget;

import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.u.c;

class AppBarLayout$Behavior$1 implements c {
    final /* synthetic */ CoordinatorLayout ci;
    final /* synthetic */ AppBarLayout cj;
    final /* synthetic */ Behavior ck;

    AppBarLayout$Behavior$1(Behavior behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.ck = behavior;
        this.ci = coordinatorLayout;
        this.cj = appBarLayout;
    }

    public final void a(u uVar) {
        this.ck.c(this.ci, this.cj, uVar.iO.aQ());
    }
}
