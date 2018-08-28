package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SnsLabelUI$1 implements OnGroupClickListener {
    final /* synthetic */ SnsLabelUI nXL;

    SnsLabelUI$1(SnsLabelUI snsLabelUI) {
        this.nXL = snsLabelUI;
    }

    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        int i2 = SnsLabelUI.a(this.nXL).nXR;
        x.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        if (i <= 1) {
            if (i2 > 1) {
                SnsLabelUI.g(this.nXL).Gx(i2);
            }
            SnsLabelUI.a(this.nXL).nXR = i;
            return false;
        } else if (SnsLabelUI.b(this.nXL) != null && SnsLabelUI.b(this.nXL).size() != 0 && SnsLabelUI.bDC() == 0) {
            SnsLabelUI.a(this.nXL, i);
            SnsLabelUI.c(this.nXL);
            x.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
            return true;
        } else if (SnsLabelUI.d(this.nXL)) {
            SnsLabelUI.e(this.nXL);
            SnsLabelUI.a(this.nXL, i);
            SnsLabelUI.a(this.nXL, h.a(this.nXL, this.nXL.getString(j.sns_label_is_transforming), false, null));
            x.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            return true;
        } else if (SnsLabelUI.a(this.nXL).nXQ == null || SnsLabelUI.a(this.nXL).nXQ.size() == 0) {
            SnsLabelUI.a(this.nXL, i);
            SnsLabelUI.f(this.nXL);
            x.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
            return true;
        } else {
            if (i2 != i) {
                if (i2 == 2) {
                    SnsLabelUI.g(this.nXL).collapseGroup(2);
                    SnsLabelUI.a(this.nXL).nXT.clear();
                    SnsLabelUI.a(this.nXL).nXV.clear();
                } else if (i2 == 3) {
                    SnsLabelUI.g(this.nXL).collapseGroup(3);
                    SnsLabelUI.a(this.nXL).nXU.clear();
                    SnsLabelUI.a(this.nXL).nXW.clear();
                }
                SnsLabelUI.g(this.nXL).post(new 1(this, i));
            } else if (SnsLabelUI.g(this.nXL).isGroupExpanded(i)) {
                SnsLabelUI.g(this.nXL).Gx(i);
            } else {
                SnsLabelUI.g(this.nXL).Gw(i);
            }
            SnsLabelUI.a(this.nXL).nXR = i;
            return true;
        }
    }
}
