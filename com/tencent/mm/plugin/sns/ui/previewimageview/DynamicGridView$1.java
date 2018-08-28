package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class DynamicGridView$1 implements OnItemClickListener {
    final /* synthetic */ DynamicGridView omz;

    DynamicGridView$1(DynamicGridView dynamicGridView) {
        this.omz = dynamicGridView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.omz.iDm && this.omz.isEnabled() && DynamicGridView.a(this.omz) != null) {
            DynamicGridView.a(this.omz).onItemClick(adapterView, view, i, j);
        }
    }
}
