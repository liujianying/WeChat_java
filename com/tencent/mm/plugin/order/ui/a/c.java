package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    Bitmap dHf = null;
    private TextView lLw;
    private ImageView lQj;
    String lQk = "";
    OnClickListener mOnClickListener;
    private View mView = null;

    public c(Context context) {
        super(context);
        setLayoutResource(g.mall_order_barcode_pref);
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
        this.lLw = (TextView) view.findViewById(f.mall_order_barcode_num);
        this.lQj = (ImageView) view.findViewById(f.mall_order_barcode_iv);
        this.lLw.setText(this.lQk);
        this.lQj.setImageBitmap(this.dHf);
        this.lQj.setOnClickListener(this.mOnClickListener);
        if (this.lQk != null && this.lQk.length() > 48) {
            this.lLw.setTextSize(0, (float) a.ad(this.mContext, d.HintTextSize));
        }
    }
}
