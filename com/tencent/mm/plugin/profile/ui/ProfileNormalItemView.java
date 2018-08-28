package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.bi;

public class ProfileNormalItemView extends ProfileItemView {
    private String cZH;
    private TextView gsY;
    TextView lSk;
    CharSequence lXS;
    OnClickListener lXT;

    public ProfileNormalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.ProfileNormalItemView);
        this.cZH = obtainStyledAttributes.getString(R.n.ProfileNormalItemView_title);
        obtainStyledAttributes.recycle();
    }

    public ProfileNormalItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return R.i.profile_normal_item_layout;
    }

    public final void init() {
        this.gsY = (TextView) findViewById(R.h.contact_normal_item_title);
        this.lSk = (TextView) findViewById(R.h.contact_normal_item_summary);
    }

    public final ProfileNormalItemView uM(int i) {
        this.cZH = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView uN(int i) {
        this.lXS = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView uO(int i) {
        this.lSk.setTextColor(i);
        return this;
    }

    public final boolean bnH() {
        this.gsY.setText(this.cZH);
        if (bi.K(this.lXS)) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.lSk.setText(this.lXS);
        setOnClickListener(this.lXT);
        return true;
    }
}
