package android.support.design.widget;

import android.support.v4.view.ViewPager.e;
import java.lang.ref.WeakReference;

public class TabLayout$e implements e {
    private final WeakReference<TabLayout> ic;
    int ie;
    int if;

    public TabLayout$e(TabLayout tabLayout) {
        this.ic = new WeakReference(tabLayout);
    }

    public final void N(int i) {
        this.ie = this.if;
        this.if = i;
    }

    public final void a(int i, float f, int i2) {
        boolean z = false;
        TabLayout tabLayout = (TabLayout) this.ic.get();
        if (tabLayout != null) {
            boolean z2 = this.if != 2 || this.ie == 1;
            if (!(this.if == 2 && this.ie == 0)) {
                z = true;
            }
            TabLayout.a(tabLayout, i, f, z2, z);
        }
    }

    public final void O(int i) {
        TabLayout tabLayout = (TabLayout) this.ic.get();
        if (tabLayout != null && tabLayout.getSelectedTabPosition() != i) {
            boolean z = this.if == 0 || (this.if == 2 && this.ie == 0);
            tabLayout.b(tabLayout.I(i), z);
        }
    }
}
