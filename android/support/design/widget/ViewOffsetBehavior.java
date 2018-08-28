package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    private z jg;
    private int jh = 0;
    private int ji = 0;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        d(coordinatorLayout, v, i);
        if (this.jg == null) {
            this.jg = new z(v);
        }
        this.jg.aS();
        if (this.jh != 0) {
            this.jg.p(this.jh);
            this.jh = 0;
        }
        if (this.ji != 0) {
            z zVar = this.jg;
            int i2 = this.ji;
            if (zVar.jm != i2) {
                zVar.jm = i2;
                zVar.aT();
            }
            this.ji = 0;
        }
        return true;
    }

    protected void d(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.e(v, i);
    }

    public boolean p(int i) {
        if (this.jg != null) {
            return this.jg.p(i);
        }
        this.jh = i;
        return false;
    }

    public int T() {
        return this.jg != null ? this.jg.jl : 0;
    }
}
