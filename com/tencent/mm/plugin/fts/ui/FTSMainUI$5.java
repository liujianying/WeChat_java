package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.FTSMainUI.4;
import com.tencent.mm.plugin.websearch.api.i;
import org.json.JSONObject;

class FTSMainUI$5 implements OnClickListener {
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$5(FTSMainUI fTSMainUI) {
        this.jxp = fTSMainUI;
    }

    public final void onClick(View view) {
        int optInt;
        int i;
        try {
            if (view.getTag() != null) {
                optInt = ((JSONObject) view.getTag()).optInt("businessType");
                if (optInt == 0) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (charSequence.equals(this.jxp.getString(n$g.search_education_article))) {
                        i = 2;
                    } else if (charSequence.equals(this.jxp.getString(n$g.search_education_timeline))) {
                        i = 8;
                    } else if (charSequence.equals(this.jxp.getString(n$g.search_education_biz_contact))) {
                        i = 1;
                    }
                    if (i == 0) {
                        FTSMainUI fTSMainUI = this.jxp;
                        ((i) g.l(i.class)).a(fTSMainUI, new 4(fTSMainUI, i));
                    }
                }
                i = optInt;
                if (i == 0) {
                    FTSMainUI fTSMainUI2 = this.jxp;
                    ((i) g.l(i.class)).a(fTSMainUI2, new 4(fTSMainUI2, i));
                }
            }
        } catch (Exception e) {
        }
        optInt = 0;
        if (optInt == 0) {
            String charSequence2 = ((TextView) view).getText().toString();
            if (charSequence2.equals(this.jxp.getString(n$g.search_education_article))) {
                i = 2;
            } else if (charSequence2.equals(this.jxp.getString(n$g.search_education_timeline))) {
                i = 8;
            } else if (charSequence2.equals(this.jxp.getString(n$g.search_education_biz_contact))) {
                i = 1;
            }
            if (i == 0) {
                FTSMainUI fTSMainUI22 = this.jxp;
                ((i) g.l(i.class)).a(fTSMainUI22, new 4(fTSMainUI22, i));
            }
        }
        i = optInt;
        if (i == 0) {
            FTSMainUI fTSMainUI222 = this.jxp;
            ((i) g.l(i.class)).a(fTSMainUI222, new 4(fTSMainUI222, i));
        }
    }
}
