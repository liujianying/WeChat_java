package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import java.util.List;

class LinearLayoutManager$c {
    boolean OG = true;
    int OH;
    int OI;
    int OJ;
    int OK;
    boolean OP;
    int Pv;
    int Pw = 0;
    boolean Px = false;
    int Py;
    List<t> Pz = null;
    int tH;

    LinearLayoutManager$c() {
    }

    final boolean k(q qVar) {
        return this.OI >= 0 && this.OI < qVar.getItemCount();
    }

    final View a(RecyclerView$m recyclerView$m) {
        if (this.Pz != null) {
            int size = this.Pz.size();
            int i = 0;
            while (i < size) {
                View view = ((t) this.Pz.get(i)).SU;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.Sh.isRemoved() || this.OI != layoutParams.Sh.gl()) {
                    i++;
                } else {
                    aT(view);
                    return view;
                }
            }
            return null;
        }
        View bt = recyclerView$m.bt(this.OI);
        this.OI += this.OJ;
        return bt;
    }

    public final void aT(View view) {
        View view2;
        int size = this.Pz.size();
        View view3 = null;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            int gl;
            view2 = ((t) this.Pz.get(i2)).SU;
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (!(view2 == view || layoutParams.Sh.isRemoved())) {
                gl = (layoutParams.Sh.gl() - this.OI) * this.OJ;
                if (gl >= 0 && gl < i) {
                    if (gl == 0) {
                        break;
                    }
                    i2++;
                    i = gl;
                    view3 = view2;
                }
            }
            gl = i;
            view2 = view3;
            i2++;
            i = gl;
            view3 = view2;
        }
        view2 = view3;
        if (view2 == null) {
            this.OI = -1;
        } else {
            this.OI = ((LayoutParams) view2.getLayoutParams()).Sh.gl();
        }
    }
}
