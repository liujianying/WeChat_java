package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class m {
    public static String yd(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CardViewUtil", "toApply is null");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if ((i + 1) % 4 == 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void a(ImageView imageView, String str, int i, int i2, boolean z) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                imageView.setImageResource(i2);
                return;
            }
            a aVar = new a();
            aVar.dXB = e.bnE;
            o.Pk();
            aVar.dXU = null;
            aVar.dXA = com.tencent.mm.plugin.card.model.m.xr(str);
            aVar.dXy = true;
            aVar.dXW = z;
            aVar.dXw = true;
            aVar.dXF = i;
            aVar.dXE = i;
            aVar.dXN = i2;
            o.Pj().a(str, imageView, aVar.Pt());
        }
    }

    public static void a(final Context context, final ImageView imageView, String str, int i, final int i2, final int i3) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                a(imageView, i2, i3);
                return;
            }
            a aVar = new a();
            aVar.dXB = e.bnE;
            o.Pk();
            aVar.dXU = null;
            aVar.dXA = com.tencent.mm.plugin.card.model.m.xr(str);
            aVar.dXy = true;
            aVar.dXW = false;
            aVar.dXw = true;
            aVar.dXF = i;
            aVar.dXE = i;
            aVar.dXN = i2;
            o.Pj().a(str, imageView, aVar.Pt(), new g() {
                public final void me(String str) {
                }

                public final Bitmap a(String str, b bVar) {
                    return null;
                }

                public final void a(String str, View view, b bVar) {
                    if (bVar.bitmap != null) {
                        ah.A(new 1(this, bVar.bitmap));
                    } else {
                        m.a(imageView, i2, i3);
                    }
                }
            });
        }
    }

    public static void a(ImageView imageView, int i, int i2) {
        ah.A(new 2(imageView, i, i2));
    }

    public static void a(MMActivity mMActivity, com.tencent.mm.plugin.card.base.b bVar) {
        mMActivity.lF(l.xV(bVar.awm().dxh));
    }

    public static void d(MMActivity mMActivity) {
        mMActivity.lF(mMActivity.getResources().getColor(com.tencent.mm.plugin.card.a.a.white));
    }

    public static void b(TextView textView, int i) {
        switch (i) {
            case 0:
                textView.setText(com.tencent.mm.plugin.card.a.g.card_state_normal);
                return;
            case 1:
                textView.setText(com.tencent.mm.plugin.card.a.g.card_state_consumed);
                return;
            case 2:
                textView.setText(com.tencent.mm.plugin.card.a.g.card_state_expire);
                return;
            case 3:
                textView.setText(com.tencent.mm.plugin.card.a.g.card_state_donation);
                return;
            case 4:
                textView.setText(com.tencent.mm.plugin.card.a.g.card_state_received);
                return;
            case 5:
                textView.setText(com.tencent.mm.plugin.card.a.g.card_state_timeout);
                return;
            case 6:
                textView.setText(com.tencent.mm.plugin.card.a.g.card_state_deleted);
                return;
            case 7:
                textView.setText(com.tencent.mm.plugin.card.a.g.card_state_lapsed);
                return;
            default:
                return;
        }
    }
}
