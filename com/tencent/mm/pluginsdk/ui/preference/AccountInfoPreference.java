package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;

public class AccountInfoPreference extends Preference {
    public SpannableString qOo;
    public String qOp;
    private int qOq;
    public OnClickListener qOr;
    public String userName;

    public AccountInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qOr = null;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.h.avatar_iv);
        if (!(this.userName == null || imageView == null || !g.Eg().Dx())) {
            b.a(imageView, this.userName);
        }
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) view.findViewById(R.h.nick_name_tv);
        if (!(this.userName == null || noMeasuredTextView == null)) {
            noMeasuredTextView.setShouldEllipsize(true);
            noMeasuredTextView.setTextSize(0, (float) a.ad(this.mContext, R.f.NormalTextSize));
            noMeasuredTextView.setTextColor(a.ac(this.mContext, R.e.normal_text_color));
            noMeasuredTextView.setText(this.qOo == null ? this.userName : this.qOo);
        }
        TextView textView = (TextView) view.findViewById(R.h.user_name_tv);
        if (this.qOp != null && textView != null) {
            textView.setText(view.getResources().getString(R.l.app_account, new Object[]{this.qOp}));
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        textView = (TextView) view.findViewById(R.h.right_prospect);
        if (textView != null) {
            if (this.qOq > 99) {
                textView.setText(this.mContext.getString(R.l.tab_msg_tip_over));
                textView.setBackgroundResource(r.hd(this.mContext));
                textView.setVisibility(0);
            } else if (this.qOq > 0) {
                textView.setText(this.qOq);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        if (this.qOr != null) {
            ((ImageView) view.findViewById(R.h.account_info_qr_code)).setOnClickListener(this.qOr);
        }
    }
}
