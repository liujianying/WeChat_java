package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j extends Preference {
    List<HelpCenter> lNv = new LinkedList();
    String lQD;
    OnClickListener lQE = null;
    OnClickListener mOnClickListener = null;
    private View mView = null;

    public j(Context context) {
        super(context);
        setLayoutResource(g.mall_order_multi_button_pref);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(f.mall_order_multi_button);
        linearLayout.removeAllViews();
        if (this.lNv != null) {
            int size;
            int i;
            View view2;
            if (bi.oW(this.lQD) || this.lQE == null) {
                size = this.lNv.size() - 1;
            } else {
                size = this.lNv.size();
            }
            if (size == 0) {
                i = -1;
            } else {
                i = size;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.lNv.size(); i3++) {
                HelpCenter helpCenter = (HelpCenter) this.lNv.get(i3);
                View textView = new TextView(this.mContext);
                textView.setTextColor(this.mContext.getResources().getColor(c.black));
                textView.setTextSize(0, (float) a.ad(this.mContext, d.NormalTextSize));
                textView.setIncludeFontPadding(false);
                textView.setText(helpCenter.name);
                textView.setTag(helpCenter);
                textView.setGravity(17);
                textView.setOnClickListener(this.mOnClickListener);
                if (i2 == i) {
                    textView.setTextColor(this.mContext.getResources().getColor(c.green_text_color));
                }
                linearLayout.addView(textView, new LayoutParams(0, -2, 1.0f));
                if (i2 < i) {
                    view2 = new View(this.mContext);
                    view2.setBackgroundColor(this.mContext.getResources().getColor(c.small_line_color));
                    linearLayout.addView(view2, new LayoutParams(a.ad(this.mContext, d.DividerSmallHeight), -1));
                }
                i2++;
            }
            if (!bi.oW(this.lQD) && this.lQE != null) {
                view2 = new TextView(this.mContext);
                view2.setTextColor(this.mContext.getResources().getColor(c.black));
                view2.setTextSize(0, (float) a.ad(this.mContext, d.NormalTextSize));
                view2.setIncludeFontPadding(false);
                view2.setText(this.lQD);
                view2.setGravity(17);
                view2.setOnClickListener(this.lQE);
                if (i2 == i) {
                    view2.setTextColor(this.mContext.getResources().getColor(c.green_text_color));
                }
                linearLayout.addView(view2, new LayoutParams(0, -2, 1.0f));
            }
        }
    }
}
