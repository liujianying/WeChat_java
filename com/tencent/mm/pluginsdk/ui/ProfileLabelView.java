package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;

public class ProfileLabelView extends ProfileItemView {
    public TextView lVq;
    public TextView qGq;

    public ProfileLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return R.i.profile_label_layout;
    }

    public final void init() {
        this.lVq = (TextView) findViewById(R.h.contact_info_label);
        this.qGq = (TextView) findViewById(R.h.contact_info_label_title);
        setClickable(true);
    }

    public final boolean bnH() {
        if (this.qGq != null) {
            LayoutParams layoutParams = this.qGq.getLayoutParams();
            layoutParams.width = a.ad(getContext(), R.f.FixedTitleWidth);
            this.qGq.setLayoutParams(layoutParams);
        }
        String str;
        ArrayList arrayList;
        if (!com.tencent.mm.l.a.gd(this.ipd.field_type)) {
            bq Hh;
            String str2 = this.ipd.field_encryptUsername;
            if (bi.oW(str2)) {
                au.HU();
                Hh = c.FS().Hh(this.ipd.field_username);
            } else {
                au.HU();
                Hh = c.FS().Hh(str2);
            }
            if (Hh != null) {
                str = Hh.field_contactLabels;
                arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aYK().FB(str);
                if (!(bi.oW(str) || arrayList == null || arrayList.size() <= 0)) {
                    this.lVq.setText(j.a(getContext(), bi.c(arrayList, getContext().getResources().getString(R.l.comma))));
                    return true;
                }
            }
            setVisibility(8);
            return false;
        } else if (q.gQ(this.ipd.field_username)) {
            setVisibility(8);
            return false;
        } else {
            str = this.ipd.field_contactLabelIds;
            arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aYK().FC(str);
            if (bi.oW(str) || arrayList == null || arrayList.size() <= 0) {
                setVisibility(8);
                return false;
            }
            this.lVq.setText(j.a(getContext(), bi.c(arrayList, getContext().getResources().getString(R.l.comma))));
            return true;
        }
    }
}
