package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;

public final class b extends i implements OnClickListener {
    private int fdx;
    protected View hyK;
    private OnClickListener mBI;

    private b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        super(context, j.mmpwddialog);
        this.fdx = 0;
        int i = a$g.remittance_fee_tip_dialog;
        if (i > 0) {
            this.hyK = View.inflate(context, i, null);
        }
        setContentView(this.hyK);
        ((Button) this.hyK.findViewById(a$f.cancel_btn)).setOnClickListener(this);
        ((Button) this.hyK.findViewById(a$f.iknow)).setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (view.getId() != a$f.ok_btn) {
            x.i("RemittanceChargeDialog", "click cancel");
            dismiss();
        }
        if (view.getId() != a$f.cancel_btn) {
            return;
        }
        if (this.fdx == 1) {
            h.mEJ.h(12689, new Object[]{Integer.valueOf(11), Integer.valueOf(1)});
            return;
        }
        h.mEJ.h(12689, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
    }

    public static void a(Context context, int i, String str, double d) {
        x.i("RemittanceChargeDialog", "showAlert");
        Object bVar = new b(context);
        bVar.fdx = i;
        x.i("RemittanceChargeDialog", "showTips");
        TextView textView = (TextView) bVar.findViewById(a$f.remittance_explain);
        if (bi.oW(str)) {
            x.e("RemittanceChargeDialog", "desc is null");
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        ((TextView) bVar.findViewById(a$f.infomsg)).setText(context.getResources().getString(a.i.remittance_free_limit, new Object[]{e.B(d)}));
        bVar.findViewById(a$f.tip_button_know).setVisibility(0);
        bVar.findViewById(a$f.infomsg_container).setVisibility(0);
        bVar.show();
        com.tencent.mm.ui.base.h.a(context, bVar);
    }

    public static b a(Context context, int i, double d, double d2, double d3, String str, OnClickListener onClickListener) {
        x.i("RemittanceChargeDialog", "showCostDetail");
        b bVar = new b(context);
        bVar.fdx = i;
        if (d == 0.0d) {
            x.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
        }
        ((TextView) bVar.findViewById(a$f.remittance_used_fee)).setText(e.B(d));
        ((TextView) bVar.findViewById(a$f.excess)).setText(e.B(d2));
        if (d3 == 0.0d) {
            x.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
        }
        ((TextView) bVar.findViewById(a$f.transaction_costs)).setText(e.B(d3));
        bVar.findViewById(a$f.remittance_cost_detail_view).setVisibility(0);
        if (!bi.oW(str)) {
            TextView textView = (TextView) bVar.findViewById(a$f.remittance_explain);
            textView.setText(str);
            textView.setVisibility(0);
        }
        bVar.findViewById(a$f.tip_pay_buttons).setVisibility(0);
        bVar.mBI = onClickListener;
        bVar.findViewById(a$f.ok_btn).setOnClickListener(new 1(bVar));
        bVar.show();
        com.tencent.mm.ui.base.h.a(context, bVar);
        if (i == 1) {
            h.mEJ.h(12689, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
        } else {
            h.mEJ.h(12689, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        }
        return bVar;
    }
}
