package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class RecyclerView$l {
    SparseArray<ArrayList<t>> Sk = new SparseArray();
    SparseIntArray Sl = new SparseIntArray();
    int Sm = 0;

    final void ge() {
        this.Sm++;
    }

    final void detach() {
        this.Sm--;
    }
}
