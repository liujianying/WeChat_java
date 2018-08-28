package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem;
import android.view.View;
import java.util.ArrayList;

class StaggeredGridLayoutManager$b {
    final /* synthetic */ StaggeredGridLayoutManager Vc;
    ArrayList<View> Vp;
    int Vq;
    int Vr;
    int Vs;
    final int mIndex;

    final int bL(int i) {
        if (this.Vq != Integer.MIN_VALUE) {
            return this.Vq;
        }
        if (this.Vp.size() == 0) {
            return i;
        }
        gT();
        return this.Vq;
    }

    private void gT() {
        View view = (View) this.Vp.get(0);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        this.Vq = this.Vc.UO.aU(view);
        if (layoutParams.Vf) {
            FullSpanItem bJ = this.Vc.UT.bJ(layoutParams.Sh.gl());
            if (bJ != null && bJ.Vh == -1) {
                this.Vq -= bJ.bK(this.mIndex);
            }
        }
    }

    final int gU() {
        if (this.Vq != Integer.MIN_VALUE) {
            return this.Vq;
        }
        gT();
        return this.Vq;
    }

    final int bM(int i) {
        if (this.Vr != Integer.MIN_VALUE) {
            return this.Vr;
        }
        if (this.Vp.size() == 0) {
            return i;
        }
        gV();
        return this.Vr;
    }

    private void gV() {
        View view = (View) this.Vp.get(this.Vp.size() - 1);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        this.Vr = this.Vc.UO.aV(view);
        if (layoutParams.Vf) {
            FullSpanItem bJ = this.Vc.UT.bJ(layoutParams.Sh.gl());
            if (bJ != null && bJ.Vh == 1) {
                this.Vr = bJ.bK(this.mIndex) + this.Vr;
            }
        }
    }

    final int gW() {
        if (this.Vr != Integer.MIN_VALUE) {
            return this.Vr;
        }
        gV();
        return this.Vr;
    }

    final void bp(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.Ve = this;
        this.Vp.add(0, view);
        this.Vq = Integer.MIN_VALUE;
        if (this.Vp.size() == 1) {
            this.Vr = Integer.MIN_VALUE;
        }
        if (layoutParams.Sh.isRemoved() || layoutParams.Sh.gz()) {
            this.Vs += this.Vc.UO.aW(view);
        }
    }

    final void bq(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.Ve = this;
        this.Vp.add(view);
        this.Vr = Integer.MIN_VALUE;
        if (this.Vp.size() == 1) {
            this.Vq = Integer.MIN_VALUE;
        }
        if (layoutParams.Sh.isRemoved() || layoutParams.Sh.gz()) {
            this.Vs += this.Vc.UO.aW(view);
        }
    }

    final void clear() {
        this.Vp.clear();
        this.Vq = Integer.MIN_VALUE;
        this.Vr = Integer.MIN_VALUE;
        this.Vs = 0;
    }

    final void bN(int i) {
        this.Vq = i;
        this.Vr = i;
    }

    final void gX() {
        int size = this.Vp.size();
        View view = (View) this.Vp.remove(size - 1);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.Ve = null;
        if (layoutParams.Sh.isRemoved() || layoutParams.Sh.gz()) {
            this.Vs -= this.Vc.UO.aW(view);
        }
        if (size == 1) {
            this.Vq = Integer.MIN_VALUE;
        }
        this.Vr = Integer.MIN_VALUE;
    }

    final void gY() {
        View view = (View) this.Vp.remove(0);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.Ve = null;
        if (this.Vp.size() == 0) {
            this.Vr = Integer.MIN_VALUE;
        }
        if (layoutParams.Sh.isRemoved() || layoutParams.Sh.gz()) {
            this.Vs -= this.Vc.UO.aW(view);
        }
        this.Vq = Integer.MIN_VALUE;
    }

    final void bO(int i) {
        if (this.Vq != Integer.MIN_VALUE) {
            this.Vq += i;
        }
        if (this.Vr != Integer.MIN_VALUE) {
            this.Vr += i;
        }
    }

    public final View an(int i, int i2) {
        View view = null;
        int size;
        View view2;
        if (i2 == -1) {
            size = this.Vp.size();
            int i3 = 0;
            while (i3 < size) {
                view2 = (View) this.Vp.get(i3);
                if (!view2.isFocusable()) {
                    break;
                }
                boolean z;
                if (StaggeredGridLayoutManager.bd(view2) > i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z != StaggeredGridLayoutManager.b(this.Vc)) {
                    break;
                }
                i3++;
                view = view2;
            }
            return view;
        }
        for (size = this.Vp.size() - 1; size >= 0; size--) {
            view2 = (View) this.Vp.get(size);
            if (!view2.isFocusable()) {
                break;
            }
            Object obj;
            if (StaggeredGridLayoutManager.bd(view2) > i) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != (!StaggeredGridLayoutManager.b(this.Vc) ? 1 : null)) {
                break;
            }
            view = view2;
        }
        return view;
    }
}
