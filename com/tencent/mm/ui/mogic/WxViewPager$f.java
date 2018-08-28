package com.tencent.mm.ui.mogic;

import android.view.View;
import com.tencent.mm.ui.mogic.WxViewPager.LayoutParams;
import java.util.Comparator;

class WxViewPager$f implements Comparator<View> {
    WxViewPager$f() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
        if (layoutParams.wX != layoutParams2.wX) {
            return layoutParams.wX ? 1 : -1;
        } else {
            return layoutParams.position - layoutParams2.position;
        }
    }
}
