package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;

class SnsInfoFlip$4 implements OnItemSelectedListener {
    final /* synthetic */ SnsInfoFlip nXg;

    SnsInfoFlip$4(SnsInfoFlip snsInfoFlip) {
        this.nXg = snsInfoFlip;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (SnsInfoFlip.d(this.nXg) != null) {
            if (SnsInfoFlip.e(this.nXg) && SnsInfoFlip.d(this.nXg).getCount() > 1) {
                SnsInfoFlip.f(this.nXg).setVisibility(0);
                SnsInfoFlip.f(this.nXg).setPage(i);
            }
            SnsInfoFlip.a(this.nXg, ((b) SnsInfoFlip.d(this.nXg).getItem(i)).caK, i, ((b) SnsInfoFlip.d(this.nXg).getItem(i)).nuP);
            if (view instanceof MultiTouchImageView) {
                ((MultiTouchImageView) view).crm();
            }
            if ((SnsInfoFlip.g(this.nXg) instanceof MMGestureGallery) && (SnsInfoFlip.h(this.nXg) instanceof SnsBrowseUI)) {
                ((SnsBrowseUI) SnsInfoFlip.h(this.nXg)).bCZ();
            }
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
