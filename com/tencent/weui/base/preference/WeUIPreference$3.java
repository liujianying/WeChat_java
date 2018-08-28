package com.tencent.weui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.ao;

class WeUIPreference$3 implements OnItemLongClickListener {
    final /* synthetic */ WeUIPreference vzA;

    WeUIPreference$3(WeUIPreference weUIPreference) {
        this.vzA = weUIPreference;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= WeUIPreference.e(this.vzA).getHeaderViewsCount()) {
            int headerViewsCount = i - WeUIPreference.e(this.vzA).getHeaderViewsCount();
            if (headerViewsCount >= WeUIPreference.d(this.vzA).getCount()) {
                ao.v("itemlongclick, outofindex, %d, %d", new Object[]{Integer.valueOf(headerViewsCount), Integer.valueOf(WeUIPreference.d(this.vzA).getCount())});
            } else {
                WeUIPreference.d(this.vzA).getItem(headerViewsCount);
            }
        }
        return false;
    }
}
