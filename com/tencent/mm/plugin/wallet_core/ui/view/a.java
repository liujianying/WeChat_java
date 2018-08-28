package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h$b;
import com.tencent.mm.ui.widget.a.c;

public final class a {
    public static c a(Context context, String str, String str2, String str3, int i, h$b h_b, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.mF(false);
        aVar.mG(true);
        aVar.Gu(i.app_cancel).b(onClickListener);
        aVar.abt(str);
        View inflate = View.inflate(context, g.wallet_alert_input_with_mmedittext, null);
        EditText editText = (EditText) inflate.findViewById(f.edittext);
        if (!bi.oW(str2)) {
            editText.append(j.a(context, str2, editText.getTextSize()));
        }
        TextView textView = (TextView) inflate.findViewById(f.tips_tv);
        if (bi.oW(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.Gt(i.app_ok).a(false, new 1(h_b, editText, context));
        if (i > 0) {
            com.tencent.mm.ui.tools.a.c.d(editText).Gi(i).a(null);
        }
        aVar.dR(inflate);
        Dialog anj = aVar.anj();
        anj.show();
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(anj);
        }
        if (context instanceof MMActivity) {
            inflate.post(new 2(context));
        }
        return anj;
    }
}
