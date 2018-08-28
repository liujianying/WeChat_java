package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {

    static class a implements com.tencent.mm.platformtools.y.a {
        public TextView pcC = null;
        public TextView pcD = null;
        public TextView pcE = null;
        public ImageView pcG = null;
        public ImageView pcH = null;
        public TextView pcI = null;
        public TextView pcJ = null;
        public TextView pcK = null;
        public ViewGroup pzn = null;
        public e pzo;
        public ViewGroup pzp = null;
        public TextView pzq = null;
        public ImageView pzr = null;

        a() {
        }

        public final void m(String str, Bitmap bitmap) {
            x.d("MicroMsg.BankcardListAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.pzo != null) {
                if (str.equals(this.pzo.lCU)) {
                    this.pcH.post(new 1(this, bitmap));
                }
                if (str.equals(this.pzo.pmo) && this.pcG != null) {
                    this.pcG.post(new 2(this, bitmap));
                }
            }
        }
    }

    public static View a(Context context, View view, Bankcard bankcard, int i, com.tencent.mm.plugin.wallet_core.e.a aVar, boolean z, int i2) {
        a aVar2;
        if (view == null || view.getTag() == null) {
            view = View.inflate(context, i, null);
            a aVar3 = new a();
            aVar3.pcH = (ImageView) view.findViewById(f.bank_logo);
            aVar3.pcD = (TextView) view.findViewById(f.bank_name);
            aVar3.pcE = (TextView) view.findViewById(f.bankcard_type);
            aVar3.pcC = (TextView) view.findViewById(f.bankcard_id);
            aVar3.pcI = (TextView) view.findViewById(f.bankcard_expired);
            aVar3.pzn = (ViewGroup) view.findViewById(f.wallet_bankcard_rl);
            aVar3.pcG = (ImageView) view.findViewById(f.bankcard_mask);
            aVar3.pcJ = (TextView) view.findViewById(f.bankcard_default);
            aVar3.pzp = (ViewGroup) view.findViewById(f.bankcard_desc_ll);
            aVar3.pzq = (TextView) view.findViewById(f.bankcard_bottom_desc_tv);
            aVar3.pzr = (ImageView) view.findViewById(f.bankcard_new);
            view.setTag(aVar3);
            aVar2 = aVar3;
        } else {
            aVar2 = (a) view.getTag();
        }
        if (bankcard.field_bankcardState == 1) {
            aVar2.pcI.setVisibility(0);
        } else {
            aVar2.pcI.setVisibility(8);
        }
        if (aVar2.pzr != null) {
            if (z) {
                aVar2.pzr.setVisibility(0);
            } else {
                aVar2.pzr.setVisibility(8);
            }
        }
        if (1 == i2) {
            aVar2.pcD.setVisibility(8);
        } else {
            aVar2.pcD.setVisibility(0);
            aVar2.pcD.setText(bankcard.field_bankName);
        }
        if (q.GS()) {
            aVar2.pcE.setVisibility(8);
        } else if (!bi.oW(bankcard.field_bankcardTypeName)) {
            aVar2.pcE.setText(bankcard.field_bankcardTypeName);
        } else if (bankcard.bOr()) {
            aVar2.pcE.setText(i.wallet_wxcredit_card);
        } else if (bankcard.bOu()) {
            aVar2.pcE.setText(i.wallet_credit_card);
        } else {
            aVar2.pcE.setText(i.wallet_deposit_card);
        }
        if (aVar2.pcC != null) {
            aVar2.pcC.setText(bankcard.field_bankcardTail);
        }
        if (bi.oW(bankcard.field_card_bottom_wording) || aVar2.pzq == null) {
            aVar2.pzp.setVisibility(8);
        } else {
            aVar2.pzq.setText(bankcard.field_card_bottom_wording);
            aVar2.pzp.setVisibility(0);
        }
        aVar.a(context, bankcard, aVar2.pcH, aVar2.pzn, aVar2.pcG);
        if (aVar2.pcJ != null) {
            o.bOW();
            String str = bankcard.field_bindSerial;
            aVar2.pcJ.setVisibility(8);
        }
        return view;
    }

    public static Drawable c(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            if (!NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new BitmapDrawable(bitmap);
            }
            Drawable ninePatchDrawable = new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, new Rect(), null);
            ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            return ninePatchDrawable;
        } catch (Throwable e) {
            x.f("MicroMsg.BankcardListAdapter", e.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardListAdapter", e, "", new Object[0]);
            return null;
        }
    }
}
