package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c$a;

public final class i {
    public static c a(Context context, b bVar, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (bVar == null || (TextUtils.isEmpty(bVar.plA) && (bVar.plB == null || bVar.plB.isEmpty()))) {
            x.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
            return null;
        }
        c$a c_a = new c$a(context);
        c_a.mF(false);
        c_a.Gu(a$i.app_cancel).b(onClickListener2);
        if (z) {
            c_a.Gt(a$i.wallet_balance_fetch_all_btn).a(onClickListener);
        } else {
            c_a.Gq(a$i.wallet_balance_fetch_dialog_title);
            c_a.Gt(a$i.wallet_balance_fetch_go_on_btn).a(onClickListener);
        }
        View inflate = View.inflate(context, g.wallet_fetch_info_dialog, null);
        if (bVar.plB == null || bVar.plB.isEmpty()) {
            x.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
        } else {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.container);
            linearLayout.removeAllViews();
            int i = 0;
            while (i < bVar.plB.size() && i < bVar.plB.size()) {
                View inflate2 = View.inflate(context, g.wallet_fetch_fee_list_item, null);
                TextView textView = (TextView) inflate2.findViewById(f.subtitle);
                ((TextView) inflate2.findViewById(f.title)).setText(((b.b) bVar.plB.get(i)).aAL);
                textView.setText(((b.b) bVar.plB.get(i)).value);
                linearLayout.addView(inflate2, i);
                i++;
            }
        }
        ((TextView) inflate.findViewById(f.title)).setText(bVar.plA);
        if (z) {
            TextView textView2 = (TextView) inflate.findViewById(f.tips);
            textView2.setVisibility(0);
            textView2.setText(context.getString(a$i.wallet_balance_fetch_all_tips));
        }
        c_a.dR(inflate);
        c anj = c_a.anj();
        anj.show();
        h.a(context, anj);
        return anj;
    }
}
