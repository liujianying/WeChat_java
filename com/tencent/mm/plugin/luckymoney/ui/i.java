package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    private LayoutInflater Bc;
    String kLA;
    boolean kLB;
    int kLC = 1;
    private List<n> kLz = new LinkedList();
    OnClickListener kXt;
    b kXu = null;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
        this.Bc = LayoutInflater.from(context);
    }

    public final void bw(List<n> list) {
        if (list == null) {
            LinkedList linkedList = new LinkedList();
        } else {
            this.kLz = list;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.kLz.size();
    }

    private n sp(int i) {
        return (n) this.kLz.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = this.Bc.inflate(g.lucky_money_record_item, viewGroup, false);
            c cVar2 = new c(this);
            cVar2.ido = view.findViewById(f.root);
            cVar2.hVP = (ImageView) view.findViewById(f.lucky_money_record_avatar);
            cVar2.jYA = (TextView) view.findViewById(f.lucky_money_record_nickname);
            cVar2.kLE = (TextView) view.findViewById(f.lucky_money_record_time);
            cVar2.kLF = (TextView) view.findViewById(f.lucky_money_record_amount);
            cVar2.kLG = (TextView) view.findViewById(f.lucky_money_record_answer);
            cVar2.kLH = (TextView) view.findViewById(f.lucky_money_record_wish_btn);
            cVar2.kLI = (ImageView) view.findViewById(f.lucky_money_record_best_luck_icon);
            cVar2.kLJ = (TextView) view.findViewById(f.lucky_money_record_game_tips);
            if (this.kXu != null) {
                this.kXu.a(cVar2, this.mContext);
            }
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        n sp = sp(i);
        o.a(cVar.hVP, sp.kQD, sp.userName);
        if (bi.oV(sp.kPS).equals(this.kLA) && this.kLB) {
            cVar.kLH.setOnClickListener(this.kXt);
            cVar.kLH.setVisibility(0);
            cVar.kLG.setVisibility(8);
            cVar.kLE.setVisibility(8);
        } else {
            if (bi.oW(sp.kQE)) {
                cVar.kLG.setVisibility(8);
            } else {
                o.a(this.mContext, cVar.kLG, sp.kQE);
                cVar.kLG.setVisibility(0);
            }
            cVar.kLE.setText(o.i(this.mContext, bi.getLong(sp.kQq, 0) * 1000));
            cVar.kLE.setVisibility(0);
            cVar.kLH.setVisibility(8);
        }
        o.a(this.mContext, cVar.jYA, sp.kQC);
        cVar.kLF.setText(this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_receive_amount, new Object[]{e.A(((double) sp.kQp) / 100.0d)}));
        if (bi.oW(sp.kQF)) {
            cVar.kLI.setVisibility(8);
            cVar.kLJ.setVisibility(8);
        } else {
            cVar.kLJ.setText(sp.kQF);
            if (this.kLC == 2) {
                cVar.kLI.setImageResource(a.e.lucky_money_first_share_icon);
            } else {
                cVar.kLI.setImageResource(a.e.lucky_money_best_luck_icon);
            }
            cVar.kLI.setVisibility(0);
            cVar.kLJ.setVisibility(0);
        }
        return view;
    }
}
