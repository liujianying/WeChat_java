package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference extends Preference {
    private MMActivity bGc;
    private View ern;
    private TextView fAK;
    private boolean iAc = false;
    private ProgressBar lYF;
    boolean lYG = false;
    c lYt;
    int state = 1;

    public NewBizInfoLoadingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        this.iAc = false;
    }

    public NewBizInfoLoadingPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGc = (MMActivity) context;
        this.iAc = false;
    }

    public final void onBindView(View view) {
        this.ern = view.findViewById(R.h.new_bizinfo_container);
        this.fAK = (TextView) view.findViewById(R.h.new_bizinfo_desc_tv);
        this.lYF = (ProgressBar) view.findViewById(R.h.new_bizinfo_loading);
        this.iAc = true;
        initView();
    }

    final void initView() {
        if (!this.iAc) {
            return;
        }
        if (this.state == 1) {
            this.ern.setVisibility(0);
            this.lYF.setVisibility(0);
            this.fAK.setVisibility(8);
        } else if (this.state == 2) {
            this.ern.setVisibility(0);
            this.fAK.setText(j.a(this.bGc, this.lYt.field_banReason, (int) this.fAK.getTextSize(), 1));
            this.fAK.setMovementMethod(LinkMovementMethod.getInstance());
            this.fAK.setVisibility(0);
            this.lYF.setVisibility(8);
        } else if (this.state == 3) {
            this.ern.setVisibility(0);
            this.fAK.setText(this.bGc.getString(R.l.contact_info_time_expired));
            this.fAK.setVisibility(0);
            this.lYF.setVisibility(8);
        } else {
            this.ern.setVisibility(8);
        }
    }
}
