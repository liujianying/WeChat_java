package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference extends Preference implements OnClickListener {
    private LayoutInflater Bc;
    OnClickListener mVS;
    private TextView qxk;
    private TextView qxl;

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(g.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        this.Bc.inflate(g.wallet_wxcredit_detail_footer_pref, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.qxk = (TextView) view.findViewById(f.wallet_wxcredit_detail_username_tv);
        this.qxl = (TextView) view.findViewById(f.wallet_wxcredit_detail_help_tv);
        this.qxk.setOnClickListener(this);
        this.qxl.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.mVS != null) {
            this.mVS.onClick(view);
        }
    }
}
