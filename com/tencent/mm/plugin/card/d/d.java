package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class d {
    public static void a(MMActivity mMActivity, String str, String str2, b bVar) {
        String string;
        if (TextUtils.isEmpty(str2)) {
            string = mMActivity.getString(a$g.app_delete_tips);
        } else {
            string = str2;
        }
        h.a(mMActivity, true, string, mMActivity.getString(a$g.app_tip), mMActivity.getString(a$g.app_ok), mMActivity.getString(a$g.app_cancel), new 1(bVar, str), new 3());
    }

    public static void a(MMActivity mMActivity, b bVar) {
        h.a(mMActivity, true, mMActivity.getString(a$g.card_clear_list_tip), "", mMActivity.getString(a$g.app_ok), mMActivity.getString(a$g.app_cancel), new 4(bVar), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public static void b(MMActivity mMActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(a$g.card_wallet_unknown_err);
        }
        a(mMActivity, str, false);
    }

    public static void b(MMActivity mMActivity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = "errcode = " + i;
        }
        a(mMActivity, str, false);
    }

    public static void a(MMActivity mMActivity, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(a$g.card_wallet_unknown_err);
        }
        h.a(mMActivity, str, null, false, new 6(z, mMActivity));
    }

    public static void c(Context context, int i, int i2, String str) {
        if (i != -1) {
            c a;
            String string;
            TextView textView;
            if (i == a$e.card_show_share_card_entrance_tips) {
                string = context.getResources().getString(i2);
                String string2 = context.getResources().getString(a$g.card_iknow);
                9 9 = new 9();
                View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
                if (i == a$e.card_show_accepted_tips_for_share) {
                    textView = (TextView) inflate.findViewById(com.tencent.mm.plugin.card.a.d.card_show_accepted_tips_tv);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(a$g.card_coupon);
                    }
                    textView.setText(context.getResources().getString(a$g.card_accepted_tips_for_share, new Object[]{str}));
                } else if (i == a$e.card_show_accepted_tips) {
                    textView = (TextView) inflate.findViewById(com.tencent.mm.plugin.card.a.d.card_show_accepted_tips_tv);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(a$g.card_coupon);
                    }
                    textView.setText(context.getResources().getString(a$g.card_accepted_tips, new Object[]{str}));
                }
                a = h.a(context, string, string2, inflate, 9);
            } else {
                string = context.getResources().getString(i2);
                String string3 = context.getResources().getString(a$g.card_jump_to_card_entrance_tips_btn);
                String string4 = context.getResources().getString(a$g.card_iknow);
                10 10 = new 10(context);
                2 2 = new 2();
                View inflate2 = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
                if (i == a$e.card_show_accepted_tips_for_share) {
                    textView = (TextView) inflate2.findViewById(com.tencent.mm.plugin.card.a.d.card_show_accepted_tips_tv);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(a$g.card_coupon);
                    }
                    textView.setText(context.getResources().getString(a$g.card_accepted_tips_for_share, new Object[]{str}));
                } else if (i == a$e.card_show_accepted_tips) {
                    textView = (TextView) inflate2.findViewById(com.tencent.mm.plugin.card.a.d.card_show_accepted_tips_tv);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(a$g.card_coupon);
                    }
                    textView.setText(context.getResources().getString(a$g.card_accepted_tips, new Object[]{str}));
                }
                a = h.a(context, string, inflate2, string3, string4, 10, 2);
            }
            if (a != null) {
                a.show();
            }
        }
    }
}
