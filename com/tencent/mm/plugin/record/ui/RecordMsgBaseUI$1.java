package com.tencent.mm.plugin.record.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.sdk.b.a;

class RecordMsgBaseUI$1 implements OnScrollListener {
    final /* synthetic */ RecordMsgBaseUI msV;

    RecordMsgBaseUI$1(RecordMsgBaseUI recordMsgBaseUI) {
        this.msV = recordMsgBaseUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            rz rzVar = new rz();
            rzVar.ccO.type = 5;
            rzVar.ccO.ccP = this.msV.eVT.getFirstVisiblePosition();
            rzVar.ccO.ccQ = this.msV.eVT.getLastVisiblePosition();
            rzVar.ccO.ccR = this.msV.eVT.getHeaderViewsCount();
            a.sFg.m(rzVar);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
