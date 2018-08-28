package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference extends CheckBoxPreference {
    private TextView piP;
    private int piQ;
    private String piR;
    private int piS;

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piQ = -1;
        this.piR = "";
        this.piS = 8;
        setLayoutResource(a$g.mm_preference_summary_icontip_checkbox);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.piP = (TextView) view.findViewById(a$f.tipicon);
        cq(this.piR, this.piQ);
        zi(this.piS);
    }

    public final void cq(String str, int i) {
        this.piQ = i;
        this.piR = str;
        if (this.piP != null) {
            if (this.piQ > 0) {
                this.piP.setBackgroundResource(this.piQ);
            }
            if (!TextUtils.isEmpty(this.piR)) {
                this.piP.setText(this.piR);
            }
        }
    }

    public final void zi(int i) {
        this.piS = i;
        if (this.piP != null) {
            this.piP.setVisibility(i);
        }
    }
}
