package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class c extends BaseAdapter {
    private LayoutInflater Bc;
    private String kLA = null;
    boolean kLB = false;
    private int kLC = 1;
    private a kLD = null;
    List<alo> kLz = new LinkedList();
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.Bc = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.kLz.size();
    }

    private alo rX(int i) {
        return (alo) this.kLz.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.Bc.inflate(g.lucky_money_record_item, viewGroup, false);
            b bVar2 = new b(this);
            bVar2.ido = view.findViewById(f.root);
            bVar2.hVP = (ImageView) view.findViewById(f.lucky_money_record_avatar);
            bVar2.jYA = (TextView) view.findViewById(f.lucky_money_record_nickname);
            bVar2.kLE = (TextView) view.findViewById(f.lucky_money_record_time);
            bVar2.kLF = (TextView) view.findViewById(f.lucky_money_record_amount);
            bVar2.kLG = (TextView) view.findViewById(f.lucky_money_record_answer);
            bVar2.kLH = (TextView) view.findViewById(f.lucky_money_record_wish_btn);
            bVar2.kLI = (ImageView) view.findViewById(f.lucky_money_record_best_luck_icon);
            bVar2.kLJ = (TextView) view.findViewById(f.lucky_money_record_game_tips);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        alo rX = rX(i);
        o.a(bVar.hVP, rX.kLc, rX.username);
        bVar.kLG.setVisibility(8);
        o.a(this.mContext, bVar.jYA, rX.nickname);
        bVar.kLF.setText(this.mContext.getString(i.lucky_money_receive_amount, new Object[]{e.A(((double) rX.rNZ) / 100.0d)}));
        bVar.kLE.setText(o.i(this.mContext, rX.rOa * 1000));
        bVar.kLE.setVisibility(0);
        bVar.kLH.setVisibility(8);
        if (bi.oW(rX.rOc)) {
            bVar.kLI.setVisibility(8);
            bVar.kLJ.setVisibility(8);
        } else {
            bVar.kLJ.setText(rX.rOc);
            if (this.kLC == 2) {
                bVar.kLI.setImageResource(a.e.lucky_money_first_share_icon);
            } else {
                bVar.kLI.setImageResource(a.e.lucky_money_best_luck_icon);
            }
            bVar.kLI.setVisibility(0);
            bVar.kLJ.setVisibility(0);
        }
        return view;
    }
}
