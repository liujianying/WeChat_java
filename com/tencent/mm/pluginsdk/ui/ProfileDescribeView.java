package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bq;

public class ProfileDescribeView extends ProfileItemView {
    public TextView qGg;
    public TextView qGh;

    public ProfileDescribeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return R.i.profile_describe_layout;
    }

    public final void init() {
        this.qGg = (TextView) findViewById(R.h.contact_info_describe);
        this.qGh = (TextView) findViewById(R.h.contact_info_describe_title);
        setClickable(true);
    }

    public final boolean bnH() {
        if (this.qGh != null) {
            LayoutParams layoutParams = this.qGh.getLayoutParams();
            layoutParams.width = a.ad(getContext(), R.f.FixedTitleWidth);
            this.qGh.setLayoutParams(layoutParams);
        }
        if (this.ipd == null) {
            setVisibility(8);
            return false;
        }
        String str = this.ipd.csT;
        if (bi.oW(this.ipd.csU)) {
            boolean z = false;
        } else {
            int z2 = 1;
        }
        Drawable drawable;
        CharSequence spannableString;
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
            if (Hh == null || bi.oW(Hh.field_conDescription)) {
                setVisibility(8);
                return false;
            }
            this.qGg.setText(j.a(getContext(), bi.oV(Hh.field_conDescription), this.qGg.getTextSize()));
            return true;
        } else if (!bi.oW(str) && z2 != 0) {
            drawable = getContext().getResources().getDrawable(R.k.card_photoicon);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
            aVar.uFY = (int) ((((float) drawable.getIntrinsicHeight()) - this.qGg.getTextSize()) / 2.0f);
            spannableString = new SpannableString("  " + str);
            spannableString.setSpan(aVar, 0, 1, 33);
            this.qGg.setText(j.a(getContext(), spannableString, this.qGg.getTextSize()));
            return true;
        } else if (!bi.oW(str) && z2 == 0) {
            this.qGg.setText(j.a(getContext(), bi.oV(str), this.qGg.getTextSize()));
            return true;
        } else if (bi.oW(str) && z2 != 0) {
            drawable = getContext().getResources().getDrawable(R.k.card_photoicon);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            com.tencent.mm.ui.widget.a aVar2 = new com.tencent.mm.ui.widget.a(drawable);
            aVar2.uFY = (int) ((((float) drawable.getIntrinsicHeight()) - this.qGg.getTextSize()) / 2.0f);
            spannableString = new SpannableString("  " + getContext().getString(R.l.contact_info_remark_info_with_image));
            spannableString.setSpan(aVar2, 0, 1, 33);
            this.qGg.setText(j.a(getContext(), spannableString, this.qGg.getTextSize()));
            return true;
        } else if (bi.oW(str) && z2 == 0) {
            setVisibility(8);
            return false;
        } else {
            setVisibility(8);
            return false;
        }
    }
}
