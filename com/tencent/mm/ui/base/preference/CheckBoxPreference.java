package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class CheckBoxPreference extends Preference {
    private MMSwitchBtn kAq;
    private TextView piP;
    private int piQ;
    private String piR;
    private int piS;
    public boolean qpJ;

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qpJ = false;
        this.piQ = -1;
        this.piR = "";
        this.piS = 8;
        setLayoutResource(h.mm_preference_summary_checkbox);
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.kAq = (MMSwitchBtn) view.findViewById(g.checkbox);
        this.kAq.setSwitchListener(new 1(this));
        this.kAq.setCheck(this.qpJ);
        if (!isEnabled()) {
            this.kAq.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(d.black_text_color_disabled));
        }
        this.piP = (TextView) view.findViewById(g.tipicon);
        cq(this.piR, this.piQ);
        zi(this.piS);
    }

    public final boolean isChecked() {
        if (this.kAq != null) {
            return this.kAq.uGQ;
        }
        return this.qpJ;
    }

    public final void lM(boolean z) {
        if (this.kAq != null) {
            this.qpJ = z;
            this.kAq.setCheck(z);
        }
    }

    public void cq(String str, int i) {
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
    }

    public void zi(int i) {
        this.piS = i;
        if (this.piP != null) {
            this.piP.setVisibility(this.piS);
        }
    }
}
