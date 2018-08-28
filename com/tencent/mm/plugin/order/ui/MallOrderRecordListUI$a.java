package com.tencent.mm.plugin.order.ui;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.b;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

protected class MallOrderRecordListUI$a extends BaseAdapter {
    final /* synthetic */ MallOrderRecordListUI lPQ;

    protected MallOrderRecordListUI$a(MallOrderRecordListUI mallOrderRecordListUI) {
        this.lPQ = mallOrderRecordListUI;
    }

    public final int getCount() {
        return this.lPQ.lPM.size();
    }

    private i uv(int i) {
        return (i) this.lPQ.lPM.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        String dj;
        if (view == null) {
            view = View.inflate(this.lPQ, g.mall_order_list_item, null);
            bVar = new b(this.lPQ, (byte) 0);
            bVar.lPS = (TextView) view.findViewById(f.order_list_item_title_tv);
            bVar.lPU = (TextView) view.findViewById(f.order_list_item_time_tv);
            bVar.lPT = (TextView) view.findViewById(f.order_list_item_status_tv);
            bVar.lPV = (TextView) view.findViewById(f.order_list_item_product_price_tv);
            bVar.lPX = view.findViewById(f.order_list_item_month_view);
            bVar.lPY = (TextView) view.findViewById(f.order_list_item_month_view_date);
            bVar.lPZ = (TextView) view.findViewById(f.order_list_item_month_view_amount);
            bVar.lPW = (TextView) view.findViewById(f.order_list_item_product_real_pay_tv);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        i uv = uv(i);
        Object obj = null;
        if (i == 0) {
            obj = 1;
            i uv2 = uv(0);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(((long) uv2.lOH) * 1000);
            dj = MallOrderRecordListUI.dj(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1);
        } else {
            i uv3 = uv(i);
            i uv4 = uv(i - 1);
            if (uv3.lOH > 0 && uv4.lOH > 0) {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                gregorianCalendar2.setTimeInMillis(((long) uv4.lOH) * 1000);
                GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                gregorianCalendar3.setTimeInMillis(((long) uv3.lOH) * 1000);
                if (!(gregorianCalendar2.get(1) == gregorianCalendar3.get(1) && gregorianCalendar2.get(2) == gregorianCalendar3.get(2))) {
                    obj = 1;
                    dj = MallOrderRecordListUI.dj(gregorianCalendar3.get(1), gregorianCalendar3.get(2) + 1);
                }
            }
            dj = null;
        }
        if (obj != null) {
            bVar.lPY.setText(new SimpleDateFormat(this.lPQ.getString(a.i.fmt_year_month, new Object[]{""})).format(new Date(((long) uv(i).lOH) * 1000)));
            if (!(bi.oW(dj) || bi.oW((String) this.lPQ.lPP.get(dj)))) {
                bVar.lPZ.setText((CharSequence) this.lPQ.lPP.get(dj));
            }
            bVar.lPX.setVisibility(0);
        } else {
            bVar.lPX.setVisibility(8);
        }
        bVar.lPS.setText(uv.lOG);
        bVar.lPT.setText(uv.lOI);
        int color = this.lPQ.mController.tml.getResources().getColor(c.mall_order_detail_item_subtitle_color);
        if (!bi.oW(uv.lOU)) {
            try {
                color = Color.parseColor(uv.lOU);
            } catch (Exception e) {
                x.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bi.oV(uv.lOU));
            }
        }
        bVar.lPT.setTextColor(color);
        bVar.lPU.setText(this.lPQ.uu(uv.lOH));
        color = this.lPQ.mController.tml.getResources().getColor(c.mall_order_detail_item_title_color);
        if (!bi.oW(uv.lOV)) {
            try {
                color = Color.parseColor(uv.lOV);
            } catch (Exception e2) {
                x.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bi.oV(uv.lOV));
            }
        }
        if (uv.lOF != uv.lOW) {
            Object e3 = e.e(uv.lOF / 100.0d, uv.lOK);
            CharSequence spannableString = new SpannableString(e3);
            spannableString.setSpan(new StrikethroughSpan(), 0, e3.length(), 33);
            bVar.lPV.setText(spannableString);
        } else {
            bVar.lPV.setText("");
        }
        bVar.lPW.setTextColor(color);
        bVar.lPW.setText(e.e(uv.lOW / 100.0d, uv.lOK));
        return view;
    }
}
