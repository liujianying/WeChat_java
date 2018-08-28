package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

class SnsLabelUI$3 implements OnChildClickListener {
    final /* synthetic */ SnsLabelUI nXL;

    SnsLabelUI$3(SnsLabelUI snsLabelUI) {
        this.nXL = snsLabelUI;
    }

    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        if (i2 == SnsLabelUI.a(this.nXL).getChildrenCount(i) - 1) {
            SnsLabelUI.a(this.nXL, i);
            SnsLabelUI.f(this.nXL);
        } else {
            String str = (String) SnsLabelUI.a(this.nXL).getChild(i, i2);
            SnsLabelUI.a(this.nXL);
            aq.NW(str);
            if (i == 2) {
                SnsLabelUI.a(this.nXL, 1, SnsLabelUI.a(this.nXL).nXT, str, view);
            } else if (i == 3) {
                SnsLabelUI.a(this.nXL, 2, SnsLabelUI.a(this.nXL).nXU, str, view);
            }
        }
        return false;
    }
}
