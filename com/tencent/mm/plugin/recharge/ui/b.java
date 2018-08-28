package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.y;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    ArrayList<n> mpv = null;
    a mpw = null;

    public final int getCount() {
        return this.mpv == null ? 0 : this.mpv.size();
    }

    public final Object getItem(int i) {
        return this.mpv.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        n nVar = (n) getItem(i);
        if (view == null) {
            view = y.gq(viewGroup.getContext()).inflate(g.recharge_product_item, viewGroup, false);
            b bVar2 = new b(this, (byte) 0);
            bVar2.fAK = (TextView) view.findViewById(f.desc);
            bVar2.eHU = (TextView) view.findViewById(f.name);
            bVar2.mpz = (TextView) view.findViewById(f.product_attr);
            bVar2.mpA = (ImageView) view.findViewById(f.recommend_iv);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eHU.setText(nVar.name);
        if (bi.oW(nVar.desc)) {
            bVar.fAK.setVisibility(8);
        } else {
            bVar.fAK.setVisibility(0);
            bVar.fAK.setText(nVar.desc);
        }
        if (bi.oW(nVar.pev)) {
            bVar.mpz.setVisibility(8);
        } else {
            bVar.mpz.setVisibility(0);
            bVar.mpz.setText(nVar.pev);
        }
        if (nVar.status == 1) {
            view.setEnabled(true);
            bVar.fAK.setEnabled(true);
            bVar.eHU.setEnabled(true);
        } else {
            view.setEnabled(false);
            bVar.fAK.setEnabled(false);
            bVar.eHU.setEnabled(false);
        }
        if (nVar.pez == 1) {
            bVar.mpA.setVisibility(0);
        }
        if (nVar.type == 1 && nVar.pew.equals("1") && !nVar.pex.equals("0")) {
            Context context = viewGroup.getContext();
            int parseColor = Color.parseColor(nVar.pex);
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) a.fromDPToPix(context, 2));
            gradientDrawable.setColor(parseColor);
            Drawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) a.fromDPToPix(context, 2));
            gradientDrawable2.setStroke(2, a.g(context, c.recharge_product_item_bg_disable));
            Drawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) a.fromDPToPix(context, 2));
            gradientDrawable3.setColor(a.g(context, c.recharge_product_item_bg));
            gradientDrawable3.setStroke(2, parseColor);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable3);
            Context context2 = viewGroup.getContext();
            int parseColor2 = Color.parseColor(nVar.pex);
            r6 = new int[3][];
            r6[0] = new int[]{16842919};
            r6[1] = new int[]{-16842910};
            r6[2] = new int[0];
            ColorStateList colorStateList = new ColorStateList(r6, new int[]{a.g(context2, c.white), a.g(context2, c.recharge_item_text_color_disabled), parseColor2});
            bVar.fAK.setTextColor(colorStateList);
            bVar.eHU.setTextColor(colorStateList);
            view.setBackground(stateListDrawable);
        }
        view.setOnClickListener(new 1(this, nVar));
        return view;
    }
}
