package android.support.v7.widget;

import android.view.animation.Interpolator;

public class RecyclerView$p$a {
    private int SA;
    private int SB;
    int SC;
    private boolean SD;
    private int SE;
    private int mDuration;
    private Interpolator mInterpolator;

    static /* synthetic */ void a(RecyclerView$p$a recyclerView$p$a, RecyclerView recyclerView) {
        if (recyclerView$p$a.SC >= 0) {
            int i = recyclerView$p$a.SC;
            recyclerView$p$a.SC = -1;
            RecyclerView.d(recyclerView, i);
            recyclerView$p$a.SD = false;
        } else if (!recyclerView$p$a.SD) {
            recyclerView$p$a.SE = 0;
        } else if (recyclerView$p$a.mInterpolator != null && recyclerView$p$a.mDuration <= 0) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (recyclerView$p$a.mDuration <= 0) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        } else {
            if (recyclerView$p$a.mInterpolator != null) {
                RecyclerView.x(recyclerView).b(recyclerView$p$a.SA, recyclerView$p$a.SB, recyclerView$p$a.mDuration, recyclerView$p$a.mInterpolator);
            } else if (recyclerView$p$a.mDuration == Integer.MIN_VALUE) {
                RecyclerView.x(recyclerView).smoothScrollBy(recyclerView$p$a.SA, recyclerView$p$a.SB);
            } else {
                RecyclerView.x(recyclerView).o(recyclerView$p$a.SA, recyclerView$p$a.SB, recyclerView$p$a.mDuration);
            }
            recyclerView$p$a.SE++;
            recyclerView$p$a.SD = false;
        }
    }

    public RecyclerView$p$a() {
        this((byte) 0);
    }

    private RecyclerView$p$a(byte b) {
        this.SC = -1;
        this.SD = false;
        this.SE = 0;
        this.SA = 0;
        this.SB = 0;
        this.mDuration = Integer.MIN_VALUE;
        this.mInterpolator = null;
    }

    public final void a(int i, int i2, int i3, Interpolator interpolator) {
        this.SA = i;
        this.SB = i2;
        this.mDuration = i3;
        this.mInterpolator = interpolator;
        this.SD = true;
    }
}
