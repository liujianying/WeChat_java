package com.tencent.mm.ui.widget.sortlist;

import android.util.SparseIntArray;
import java.util.ArrayList;

class DragSortListView$j {
    int sKa;
    SparseIntArray uOJ;
    ArrayList<Integer> uOK;
    final /* synthetic */ DragSortListView uOr;

    /* synthetic */ DragSortListView$j(DragSortListView dragSortListView, byte b) {
        this(dragSortListView);
    }

    private DragSortListView$j(DragSortListView dragSortListView) {
        this.uOr = dragSortListView;
        this.uOJ = new SparseIntArray(3);
        this.uOK = new ArrayList(3);
        this.sKa = 3;
    }
}
