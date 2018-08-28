package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference extends Preference {
    String bgn;
    private final Context context;
    String mGD;
    private ImageView mMu;
    private TextView mMv;
    private TextView mMw;
    private TextView mMx;
    private TextView mMy;
    String mMz;
    String title;

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        x.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
        this.mMu = (ImageView) view.findViewById(R.h.vcontact_info_avatar_iv);
        this.mMv = (TextView) view.findViewById(R.h.vcontact_info_name_tv);
        if (this.mMz != null) {
            this.mMv.setText(this.mMz);
        }
        this.mMw = (TextView) view.findViewById(R.h.vcontact_info_nickname_tv);
        if (this.bgn != null) {
            this.mMw.setText(this.context.getString(R.l.v_contact_nick_name, new Object[]{this.bgn}));
            this.mMw.setVisibility(0);
        }
        this.mMx = (TextView) view.findViewById(R.h.vcontact_info_role_tv);
        if (this.mGD != null) {
            this.mMx.setText(this.context.getString(R.l.v_contact_role, new Object[]{this.mGD}));
            this.mMx.setVisibility(0);
        }
        this.mMy = (TextView) view.findViewById(R.h.vcontact_info_title_tv);
        if (this.title != null) {
            this.mMy.setText(this.context.getString(R.l.v_contact_tile, new Object[]{this.title}));
            this.mMy.setVisibility(0);
        }
    }
}
