package android.support.design.widget;

import android.support.design.widget.TabLayout.d;
import android.support.v4.view.ViewPager;

public class TabLayout$g implements TabLayout$a {
    private final ViewPager hE;

    public TabLayout$g(ViewPager viewPager) {
        this.hE = viewPager;
    }

    public final void a(d dVar) {
        this.hE.setCurrentItem(dVar.mPosition);
    }
}
