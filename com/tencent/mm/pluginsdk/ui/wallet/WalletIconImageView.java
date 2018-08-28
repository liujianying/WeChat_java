package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;

public class WalletIconImageView extends ImageView {
    private int jp;
    private int qUD;
    private OnClickListener qUE;

    public WalletIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.qUD = -1;
        this.jp = 4;
        this.qUE = null;
    }

    public WalletIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setImageResource(int i) {
        this.qUD = i;
        super.setImageResource(i);
    }

    public void setVisibility(int i) {
        this.jp = i;
        super.setVisibility(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.qUE = onClickListener;
    }

    public void setToClearState(OnClickListener onClickListener) {
        super.setVisibility(0);
        super.setImageResource(e.list_clear);
        super.setContentDescription(getContext().getString(i.clear_btn));
        super.setOnClickListener(onClickListener);
    }

    public final void cfD() {
        super.setVisibility(this.jp);
        super.setImageResource(this.qUD);
        super.setOnClickListener(this.qUE);
    }
}
