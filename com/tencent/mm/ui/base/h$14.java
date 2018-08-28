package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.j;

class h$14 implements OnClickListener {
    final /* synthetic */ LinearLayout mRl;
    final /* synthetic */ a ttz;

    h$14(LinearLayout linearLayout, a aVar) {
        this.mRl = linearLayout;
        this.ttz = aVar;
    }

    public final void onClick(View view) {
        for (int i = 0; i < this.mRl.getChildCount(); i++) {
            TextView textView = (TextView) this.mRl.getChildAt(i);
            if (textView.getId() != g.tips_tv) {
                textView.setCompoundDrawablesWithIntrinsicBounds(j.radio_off, 0, 0, 0);
            }
        }
        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(j.radio_on, 0, 0, 0);
        view.post(new 1(this, ((Integer) view.getTag()).intValue()));
    }
}
