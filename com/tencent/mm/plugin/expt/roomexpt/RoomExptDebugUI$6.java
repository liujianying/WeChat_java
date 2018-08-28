package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.expt.b$a;
import com.tencent.mm.plugin.expt.b.b;

class RoomExptDebugUI$6 extends ArrayAdapter {
    final /* synthetic */ RoomExptDebugUI iIF;

    RoomExptDebugUI$6(RoomExptDebugUI roomExptDebugUI, Context context, int i, int i2) {
        this.iIF = roomExptDebugUI;
        super(context, i, i2);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        TextView textView = (TextView) view2.findViewById(b.room_expt_ui_tv);
        if (i % 2 == 0) {
            textView.setBackgroundResource(b$a.wechat_green);
        } else {
            textView.setBackgroundResource(b$a.transparent);
        }
        return view2;
    }
}
