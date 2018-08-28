package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class k {
    public static Dialog a(Context context, String str, String str2, List<String> list, String str3, int i, String str4, String str5, String str6, String str7) {
        View inflate = LayoutInflater.from(context).inflate(g.wallet_id_card_tip, null);
        ImageView imageView = (ImageView) inflate.findViewById(f.close_icon);
        int b = b.b(context, 15.0f);
        bi.j(imageView, b, b, b, b);
        TextView textView = (TextView) inflate.findViewById(f.main_tip);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.main_tip_wording);
        Button button = (Button) inflate.findViewById(f.upload_btn);
        TextView textView2 = (TextView) inflate.findViewById(f.main_protocol_wording);
        ((TextView) inflate.findViewById(f.main_title)).setText(str);
        textView.setText(str2);
        linearLayout.removeAllViews();
        for (String str8 : list) {
            View inflate2 = LayoutInflater.from(context).inflate(g.wallet_id_card_wordingtip, null);
            ((TextView) inflate2.findViewById(f.wording_tip)).setText(str8);
            linearLayout.addView(inflate2);
        }
        button.setText(str3);
        if (i > 0) {
            b = str4.length();
            int length = (str4 + str5).length();
            CharSequence spannableString = new SpannableString(str4 + str5);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(c.wallet_offline_link_color)), b, length, 33);
            textView2.setText(spannableString);
        } else {
            textView2.setText("");
        }
        textView2.setOnClickListener(new 1(str6, context));
        Dialog dialog = new Dialog(context, j.mmalertdialog);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new 3(dialog));
        imageView.setOnClickListener(new 4(dialog));
        button.setOnClickListener(new 5(str7, context, dialog));
        dialog.show();
        return dialog;
    }
}
