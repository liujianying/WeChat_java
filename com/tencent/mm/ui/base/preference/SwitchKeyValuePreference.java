package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.w.a.h;

public class SwitchKeyValuePreference extends Preference {
    public boolean bKe;
    private TextView lWL;

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKe = true;
        setLayoutResource(h.mm_preference);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.lWL = (TextView) view.findViewById(16908304);
        aL();
    }

    public final void aL() {
        if (this.lWL != null) {
            if (this.bKe) {
                this.lWL.setTextColor(q.hb(this.mContext));
            } else {
                this.lWL.setTextColor(q.hc(this.mContext));
            }
        }
    }
}
