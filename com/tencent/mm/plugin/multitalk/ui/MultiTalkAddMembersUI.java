package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.b;

public class MultiTalkAddMembersUI extends MultiTalkSelectContactUI {
    protected final void initView() {
        super.initView();
        this.lbw.setBackgroundResource(R.e.default_bg_color);
        this.lbw.setPadding(b.lvi, b.lvi, b.lvi, 0);
    }
}
