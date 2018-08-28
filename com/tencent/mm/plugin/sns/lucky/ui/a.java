package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static Dialog e(Context context, final View view) {
        View inflate = LayoutInflater.from(context).inflate(g.lucky_comment_dialog, null);
        String str = w.chM() ? "font_1.otf" : w.chN() ? "font_2.otf" : null;
        TextView textView = (TextView) inflate.findViewById(f.lucky_money_title_tv);
        if (!bi.oW(str)) {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        }
        if (!w.chL()) {
            textView.setTextSize(1, 10.0f);
        }
        final Dialog dialog = new Dialog(context, k.mmalertdialog);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new 1(dialog));
        ((TextView) inflate.findViewById(f.go_shake_lucky_btn)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                View view2 = view;
                if (view2 != null) {
                    view2.performClick();
                }
            }
        });
        View findViewById = inflate.findViewById(f.tips_dialog_close_btn);
        int b = b.b(context, 10.0f);
        bi.j(findViewById, b, b, b, b);
        findViewById.setOnClickListener(new 3(dialog));
        dialog.show();
        return dialog;
    }
}
