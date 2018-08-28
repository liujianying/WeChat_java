package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoAllMessagePreference extends Preference {
    private MMActivity bGc;
    private TextView eBO;
    private TextView kxe;
    c lYt;
    private LinearLayout lYx;

    public NewBizInfoAllMessagePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
    }

    public NewBizInfoAllMessagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGc = (MMActivity) context;
    }

    public final void onBindView(View view) {
        this.lYx = (LinearLayout) view.findViewById(R.h.new_bizinfo_message_container);
        this.eBO = (TextView) view.findViewById(R.h.new_bizinfo_message_title);
        this.kxe = (TextView) view.findViewById(R.h.new_bizinfo_message_count);
        if (this.lYt == null || !this.lYt.bnO()) {
            this.lYx.setVisibility(8);
            return;
        }
        this.lYx.setVisibility(0);
        this.eBO.setText(this.bGc.getString(R.l.contact_info_biz_all_message_title));
        this.kxe.setText(this.lYt.field_allArticleWording);
    }
}
