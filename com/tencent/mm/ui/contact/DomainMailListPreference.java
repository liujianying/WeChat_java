package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference extends Preference {
    private TextView eBO;
    private boolean iAc;
    private String title;
    private String ujp;
    private TextView ujq;
    private TextView ujr;
    private TextView ujs;

    public DomainMailListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DomainMailListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iAc = false;
        this.title = "";
        this.ujp = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_domainmaillist, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.eBO = (TextView) view.findViewById(R.h.title);
        this.ujq = (TextView) view.findViewById(R.h.firstDomainMail);
        this.ujr = (TextView) view.findViewById(R.h.secondDomainMail);
        this.ujs = (TextView) view.findViewById(R.h.thirdDomainMail);
        this.iAc = true;
        if (this.iAc) {
            this.eBO.setText(ai.oV(this.title));
            String[] split = this.ujp.split(";");
            if (ai.oV(this.ujp).length() <= 0) {
                this.ujq.setVisibility(8);
                this.ujr.setVisibility(8);
            } else {
                if (split.length > 0) {
                    this.ujq.setVisibility(0);
                    this.ujq.setText(ai.oV(split[0]));
                } else {
                    this.ujq.setVisibility(8);
                }
                if (split.length > 1) {
                    this.ujr.setVisibility(0);
                    this.ujr.setText(ai.oV(split[1]));
                } else {
                    this.ujr.setVisibility(8);
                }
                if (split.length > 2) {
                    this.ujs.setVisibility(0);
                    this.ujs.setText(ai.oV(split[2]));
                }
            }
            this.ujs.setVisibility(8);
        } else {
            x.e("MicroMsg.DomainMailPreference", "initView : unbind view");
        }
        super.onBindView(view);
    }
}
