package android.support.v4.view;

import android.view.WindowInsets;

final class aq extends ap {
    final WindowInsets xp;

    aq(WindowInsets windowInsets) {
        this.xp = windowInsets;
    }

    public final int getSystemWindowInsetLeft() {
        return this.xp.getSystemWindowInsetLeft();
    }

    public final int getSystemWindowInsetTop() {
        return this.xp.getSystemWindowInsetTop();
    }

    public final int getSystemWindowInsetRight() {
        return this.xp.getSystemWindowInsetRight();
    }

    public final int getSystemWindowInsetBottom() {
        return this.xp.getSystemWindowInsetBottom();
    }

    public final boolean isConsumed() {
        return this.xp.isConsumed();
    }

    public final ap co() {
        return new aq(this.xp.consumeSystemWindowInsets());
    }

    public final ap f(int i, int i2, int i3, int i4) {
        return new aq(this.xp.replaceSystemWindowInsets(i, i2, i3, i4));
    }
}
