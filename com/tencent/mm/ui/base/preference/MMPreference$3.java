package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class MMPreference$3 implements OnItemLongClickListener {
    final /* synthetic */ MMPreference tCP;

    MMPreference$3(MMPreference mMPreference) {
        this.tCP = mMPreference;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < MMPreference.e(this.tCP).getHeaderViewsCount()) {
            return false;
        }
        int headerViewsCount = i - MMPreference.e(this.tCP).getHeaderViewsCount();
        if (headerViewsCount >= MMPreference.d(this.tCP).getCount()) {
            x.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(MMPreference.d(this.tCP).getCount()));
            return false;
        }
        MMPreference.d(this.tCP).getItem(headerViewsCount);
        MMPreference.d(this.tCP);
        MMPreference.e(this.tCP);
        return MMPreference.csm();
    }
}
