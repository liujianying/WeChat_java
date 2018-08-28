package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

class PagerTabStrip$1 implements OnClickListener {
    final /* synthetic */ PagerTabStrip vo;

    PagerTabStrip$1(PagerTabStrip pagerTabStrip) {
        this.vo = pagerTabStrip;
    }

    public final void onClick(View view) {
        this.vo.vp.setCurrentItem(this.vo.vp.getCurrentItem() - 1);
    }
}
