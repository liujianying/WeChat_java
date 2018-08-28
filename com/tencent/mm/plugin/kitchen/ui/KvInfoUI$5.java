package com.tencent.mm.plugin.kitchen.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.kitchen.b.a;
import com.tencent.mm.plugin.kitchen.b.b;
import com.tencent.mm.plugin.report.service.d;

class KvInfoUI$5 extends ArrayAdapter {
    final /* synthetic */ KvInfoUI kAs;

    KvInfoUI$5(KvInfoUI kvInfoUI, Context context, int i, int i2) {
        this.kAs = kvInfoUI;
        super(context, i, i2);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        d dVar = (d) KvInfoUI.b(this.kAs).getItem(i);
        TextView textView = (TextView) view2.findViewById(b.kv_info_ui_tv);
        if (dVar == null || !dVar.mEq) {
            textView.setBackgroundResource(a.transparent);
        } else {
            textView.setBackgroundResource(a.wechat_green);
        }
        return view2;
    }
}
