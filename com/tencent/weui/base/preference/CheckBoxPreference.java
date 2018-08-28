package com.tencent.weui.base.preference;

import android.content.Context;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.bw.a$g;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class CheckBoxPreference extends Preference {
    private MMSwitchBtn kAq;
    private TextView piP;
    private int piQ;
    private String piR;
    private int piS;
    boolean qpJ;

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qpJ = false;
        this.piQ = -1;
        this.piR = "";
        this.piS = 8;
        setLayoutResource(a$g.mm_preference_summary_checkbox);
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.kAq = (MMSwitchBtn) view.findViewById(f.checkbox);
        this.kAq.setSwitchListener(new 1(this));
        this.kAq.setCheck(this.qpJ);
        if (!isEnabled()) {
            this.kAq.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(c.black_text_color_disabled));
        }
        this.piP = (TextView) view.findViewById(f.tipicon);
        String str = this.piR;
        int i = this.piQ;
        this.piQ = i;
        this.piR = str;
        if (this.piP != null) {
            if (i > 0) {
                this.piP.setBackgroundResource(this.piQ);
            }
            if (!TextUtils.isEmpty(this.piR)) {
                this.piP.setText(this.piR);
            }
        }
        this.piS = this.piS;
        if (this.piP != null) {
            this.piP.setVisibility(this.piS);
        }
    }

    public final boolean isChecked() {
        if (this.kAq != null) {
            return this.kAq.uGQ;
        }
        return this.qpJ;
    }
}
