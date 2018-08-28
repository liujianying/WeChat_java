package com.tencent.mm.ui.statusbar;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class DrawStatusBarPreference extends MMPreference {
    private b gue = null;

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.gue = new b(this);
            this.gue.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.gue);
            getSwipeBackLayout().setContentView(this.gue);
        }
    }

    public int Ys() {
        return 0;
    }

    public boolean a(f fVar, Preference preference) {
        return false;
    }
}
