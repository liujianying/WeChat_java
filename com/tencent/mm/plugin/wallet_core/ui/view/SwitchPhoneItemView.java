package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;

public class SwitchPhoneItemView extends RelativeLayout {
    private TextView pzA;
    private TextView pzB;
    ImageView pzC;
    private int pzD;

    public SwitchPhoneItemView(Context context) {
        this(context, 0);
    }

    public SwitchPhoneItemView(Context context, int i) {
        super(context);
        this.pzD = 0;
        this.pzD = i;
        co(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pzD = 0;
        co(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pzD = 0;
        co(context);
    }

    private void co(Context context) {
        View inflate;
        if (this.pzD > 0) {
            inflate = inflate(context, this.pzD, this);
        } else {
            inflate = inflate(context, g.wallet_switch_verify_phone_item, this);
        }
        this.pzA = (TextView) inflate.findViewById(f.phone_number_tv);
        this.pzB = (TextView) inflate.findViewById(f.phone_desc_tv);
        this.pzC = (ImageView) inflate.findViewById(f.phone_check_iv);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        if (bi.K(charSequence)) {
            this.pzA.setVisibility(8);
        } else {
            this.pzA.setText(charSequence);
        }
        if (bi.K(charSequence2)) {
            this.pzB.setVisibility(8);
            return;
        }
        this.pzB.setMaxLines(2);
        this.pzB.setSelected(true);
        this.pzB.setEllipsize(TruncateAt.MIDDLE);
        this.pzB.setText(charSequence2);
        this.pzB.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
