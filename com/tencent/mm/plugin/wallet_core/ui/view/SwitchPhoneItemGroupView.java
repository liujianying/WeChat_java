package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView extends LinearLayout {
    List<SwitchPhoneItemView> pzw = new ArrayList();
    private a pzx;
    private OnClickListener pzy = new 1(this);

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnItemSelectListener(a aVar) {
        this.pzx = aVar;
    }

    public final void a(SwitchPhoneItemView switchPhoneItemView, int i) {
        addView(switchPhoneItemView, i);
        this.pzw.add(switchPhoneItemView);
        switchPhoneItemView.setOnClickListener(this.pzy);
    }
}
