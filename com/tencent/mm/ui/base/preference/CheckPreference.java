package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class CheckPreference extends Preference {
    private TextView piP;
    private int piQ;
    private String piR;
    private int piS;
    public boolean qpJ;
    private CheckBox tBF;
    public int tBG;

    public CheckPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qpJ = false;
        this.piQ = -1;
        this.piR = "";
        this.piS = 8;
        this.tBG = -1;
        setLayoutResource(h.mm_preference_summary_check);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.tBF = (CheckBox) view.findViewById(g.checkbox);
        this.tBF.setChecked(this.qpJ);
        this.piP = (TextView) view.findViewById(g.tipicon);
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
        LayoutParams layoutParams = (LayoutParams) this.tBF.getLayoutParams();
        if (-1 != this.tBG) {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, this.tBG, layoutParams.bottomMargin);
        }
    }
}
