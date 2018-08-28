package com.tencent.mm.plugin.order.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.b;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;

class MallOrderDetailInfoUI$a extends BaseAdapter {
    final /* synthetic */ MallOrderDetailInfoUI lPC;

    private MallOrderDetailInfoUI$a(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        this.lPC = mallOrderDetailInfoUI;
    }

    /* synthetic */ MallOrderDetailInfoUI$a(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b) {
        this(mallOrderDetailInfoUI);
    }

    public final int getCount() {
        return MallOrderDetailInfoUI.e(this.lPC).size();
    }

    private a us(int i) {
        return (a) MallOrderDetailInfoUI.e(this.lPC).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a us = us(i);
        View findViewById;
        switch (us.type) {
            case 1:
                view = View.inflate(this.lPC, a$g.mall_order_action_list_item_to_be_reted, null);
                findViewById = view.findViewById(a$f.order_action_item_content_layout);
                MallOrderDetailInfoUI.a(this.lPC, (CheckedTextView) view.findViewById(a$f.order_action_item_good_tv));
                MallOrderDetailInfoUI.b(this.lPC, (CheckedTextView) view.findViewById(a$f.order_action_item_bad_tv));
                MallOrderDetailInfoUI.f(this.lPC).setOnClickListener(this.lPC.lPB);
                MallOrderDetailInfoUI.g(this.lPC).setOnClickListener(this.lPC.lPB);
                if (i + 1 < getCount()) {
                    MallOrderDetailInfoUI.b(findViewById, us(i + 1));
                    break;
                }
                break;
            case 2:
                view = View.inflate(this.lPC, a$g.mall_order_action_list_item_reted, null);
                TextView textView = (TextView) view.findViewById(a$f.order_action_item_bad_tv);
                findViewById = view.findViewById(a$f.order_action_item_content_layout);
                if (bi.getInt(us.value, 0) >= 0) {
                    textView.setText(i.mall_order_detail_rated_good);
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a$h.mall_order_detail_good, 0);
                } else {
                    textView.setText(i.mall_order_detail_rated_bad);
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a$h.mall_order_detail_bad, 0);
                }
                if (i + 1 < getCount()) {
                    MallOrderDetailInfoUI.b(findViewById, us(i + 1));
                    break;
                }
                break;
            default:
                b bVar;
                if (view == null) {
                    view = View.inflate(this.lPC, a$g.mall_order_action_list_item, null);
                    b bVar2 = new b(this.lPC, (byte) 0);
                    bVar2.hFW = (TextView) view.findViewById(a$f.order_action_item_title_tv);
                    bVar2.hGY = (TextView) view.findViewById(a$f.order_action_item_subtitle_tv);
                    bVar2.hGZ = (TextView) view.findViewById(a$f.order_action_item_divider_tv);
                    bVar2.gYR = view.findViewById(a$f.order_action_item_content_layout);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.hFW.setText(us.name);
                if (TextUtils.isEmpty(us.value)) {
                    bVar.hGY.setVisibility(4);
                } else {
                    bVar.hGY.setVisibility(0);
                    bVar.hGY.setText(us.value);
                }
                if (us.hvi) {
                    bVar.hGZ.setVisibility(0);
                } else {
                    bVar.hGZ.setVisibility(8);
                }
                if (i + 1 < getCount()) {
                    MallOrderDetailInfoUI.b(bVar.gYR, us(i + 1));
                    break;
                }
                break;
        }
        return view;
    }

    public final int getItemViewType(int i) {
        return us(i).type;
    }

    public final int getViewTypeCount() {
        return 3;
    }
}
