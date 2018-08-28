package android.support.v7.widget;

import android.util.SparseArray;

public class RecyclerView$q {
    int SF = 1;
    private SparseArray<Object> SG;
    int SH = 0;
    int SI = 0;
    int SJ = 0;
    boolean SK = false;
    boolean SL = false;
    boolean SM = false;
    boolean SN = false;
    boolean SO = false;
    boolean SP = false;
    int Sv = -1;

    final void bx(int i) {
        if ((this.SF & i) == 0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.SF));
        }
    }

    public final int getItemCount() {
        return this.SL ? this.SI - this.SJ : this.SH;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.Sv + ", mData=" + this.SG + ", mItemCount=" + this.SH + ", mPreviousLayoutItemCount=" + this.SI + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.SJ + ", mStructureChanged=" + this.SK + ", mInPreLayout=" + this.SL + ", mRunSimpleAnimations=" + this.SM + ", mRunPredictiveAnimations=" + this.SN + '}';
    }
}
