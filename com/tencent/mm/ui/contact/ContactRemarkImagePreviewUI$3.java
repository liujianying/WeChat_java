package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ContactRemarkImagePreviewUI$3 implements OnItemClickListener {
    final /* synthetic */ ContactRemarkImagePreviewUI uiD;

    ContactRemarkImagePreviewUI$3(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        this.uiD = contactRemarkImagePreviewUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.uiD.mController.isTitleShowing()) {
            this.uiD.mController.hideTitleView();
        } else {
            this.uiD.mController.showTitleView();
        }
    }
}
