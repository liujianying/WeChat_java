package com.tencent.mm.ui.base;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class MMRadioGroupView$c implements OnHierarchyChangeListener {
    private OnHierarchyChangeListener eL;
    final /* synthetic */ MMRadioGroupView txc;

    private MMRadioGroupView$c(MMRadioGroupView mMRadioGroupView) {
        this.txc = mMRadioGroupView;
    }

    /* synthetic */ MMRadioGroupView$c(MMRadioGroupView mMRadioGroupView, byte b) {
        this(mMRadioGroupView);
    }

    public final void onChildViewAdded(View view, View view2) {
        if (view == this.txc && (view2 instanceof MMRadioImageButton)) {
            if (view2.getId() == -1) {
                int hashCode = view2.hashCode();
                if (hashCode < 0) {
                    hashCode &= Integer.MAX_VALUE;
                }
                view2.setId(hashCode);
            }
            ((MMRadioImageButton) view2).setOnOtherMMRadioButtonCheckedChangeListener(MMRadioGroupView.b(this.txc));
        }
        if (this.eL != null) {
            this.eL.onChildViewAdded(view, view2);
        }
    }

    public final void onChildViewRemoved(View view, View view2) {
        if (view == this.txc && (view2 instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) view2).setOnOtherMMRadioButtonCheckedChangeListener(null);
        }
        if (this.eL != null) {
            this.eL.onChildViewRemoved(view, view2);
        }
    }
}
