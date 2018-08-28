package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    String iAb;
    String mName;
    OnClickListener mOnClickListener;
    private View mView = null;

    public d(Context context) {
        super(context);
        setLayoutResource(g.mall_order_biz_pref);
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
        ImageView imageView = (ImageView) view.findViewById(f.mall_order_biz_pref_icon);
        TextView textView = (TextView) view.findViewById(f.mall_order_biz_pref_name);
        imageView.setImageBitmap(null);
        if (!bi.oW(this.iAb)) {
            a aVar = new a();
            b.bmn();
            aVar.dXB = b.bav();
            aVar.dXy = true;
            aVar.dXV = true;
            aVar.dXW = true;
            o.Pj().a(this.iAb, imageView, aVar.Pt());
        }
        textView.setText(this.mName);
        view.findViewById(f.mall_order_biz_pref_container).setOnClickListener(this.mOnClickListener);
    }
}
