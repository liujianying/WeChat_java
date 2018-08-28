package com.tencent.mm.plugin.chatroom.a;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mm.plugin.chatroom.ui.b;
import com.tencent.mm.plugin.chatroom.ui.b$a;

public class b$b extends t {
    final b hKR;

    public b$b(View view, b$a b_a) {
        super(view);
        this.hKR = (b) view;
        this.hKR.setLayoutParams(new LayoutParams(-1, -1));
        this.hKR.setClickable(true);
        this.hKR.setOnDayClickListener(b_a);
    }
}
