package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.w.a.j;

public class IconSwitchKeyValuePreference extends IconPreference {
    private TextView lWL;
    private int status;

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.lWL = (TextView) view.findViewById(16908304);
        aL();
    }

    public final void Ey(int i) {
        this.status = i;
        aL();
    }

    private void aL() {
        if (this.lWL != null) {
            int b = b.b(this.mContext, 2.0f);
            this.lWL.setTextColor(q.hc(this.mContext));
            if (this.status == 0) {
                this.lWL.setCompoundDrawablesWithIntrinsicBounds(j.status_accountunkey, 0, 0, 0);
                this.lWL.setCompoundDrawablePadding(b);
            } else if (this.status == 1) {
                this.lWL.setCompoundDrawablesWithIntrinsicBounds(j.status_accountkey, 0, 0, 0);
                this.lWL.setCompoundDrawablePadding(b);
            } else if (this.status == 2) {
                this.lWL.setCompoundDrawablesWithIntrinsicBounds(j.status_accountkey_off, 0, 0, 0);
                this.lWL.setCompoundDrawablePadding(b);
            } else {
                this.lWL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
    }
}
