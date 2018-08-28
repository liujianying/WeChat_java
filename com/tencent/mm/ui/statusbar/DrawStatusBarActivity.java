package com.tencent.mm.ui.statusbar;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.MMActivity;

public abstract class DrawStatusBarActivity extends MMActivity {
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

    public int getStatusBarColor() {
        return this.mController.cqm();
    }

    public final void lF(int i) {
        super.lF(i);
        if (VERSION.SDK_INT >= 21 && getWindow() != null) {
            a.c(this.mController.contentView, getWindow().getStatusBarColor(), d.c(getWindow()));
        }
    }
}
