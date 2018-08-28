package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoDescPreference extends Preference {
    private MMActivity bGc;
    private LinearLayout gxf;
    private boolean iAc = false;
    private TextView lYA;
    private TextView lYB;
    private TextView lYC;
    private TextView lYD;
    c lYt;
    private LinearLayout lYy;
    private LinearLayout lYz;

    public NewBizInfoDescPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
    }

    public NewBizInfoDescPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGc = (MMActivity) context;
    }

    public final void onBindView(View view) {
        this.gxf = (LinearLayout) view.findViewById(R.h.bizinfo_desc_layout);
        this.lYy = (LinearLayout) view.findViewById(R.h.bizinfo_desc_layout_1);
        this.lYz = (LinearLayout) view.findViewById(R.h.bizinfo_desc_layout_2);
        this.lYA = (TextView) view.findViewById(R.h.bizinfo_desc_layout_title_1);
        this.lYB = (TextView) view.findViewById(R.h.bizinfo_desc_layout_title_2);
        this.lYC = (TextView) view.findViewById(R.h.bizinfo_desc_layout_desc_1);
        this.lYD = (TextView) view.findViewById(R.h.bizinfo_desc_layout_desc_2);
        this.iAc = true;
        if (!this.iAc) {
            x.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[]{Boolean.valueOf(this.iAc)});
        } else if (this.lYt == null) {
            this.gxf.setVisibility(4);
        } else {
            this.gxf.setVisibility(0);
            if (this.lYt.field_originalArticleCount > 0) {
                this.lYy.setVisibility(0);
                this.lYA.setText(this.lYt.field_originalArticleCount);
            } else {
                this.lYy.setVisibility(8);
            }
            if (this.lYt.field_friendSubscribeCount > 0) {
                this.lYz.setVisibility(0);
                this.lYB.setText(this.lYt.field_friendSubscribeCount);
                return;
            }
            this.lYz.setVisibility(8);
        }
    }
}
