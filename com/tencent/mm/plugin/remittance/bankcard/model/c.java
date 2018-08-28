package com.tencent.mm.plugin.remittance.bankcard.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<TransferRecordParcel> mur;
    private List<TransferRecordParcel> mus = new ArrayList();
    private List<Pair<Integer, Integer>> mut = new ArrayList();
    private Filter muu;

    public c(Context context, List<TransferRecordParcel> list) {
        this.mContext = context;
        this.mur = list;
    }

    public final int getCount() {
        return this.mus.size();
    }

    public final Object getItem(int i) {
        return this.mus.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(g.bank_remit_payee_name_item, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.mux = (CdnImageView) view.findViewById(f.brpn_bank_logo_iv);
            bVar.muy = (TextView) view.findViewById(f.brpn_payee_name_tv);
            bVar.muz = (TextView) view.findViewById(f.brpn_bank_name_tv);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
        Pair pair = (Pair) this.mut.get(i);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_text_color));
        CharSequence spannableString = new SpannableString(transferRecordParcel.muC);
        spannableString.setSpan(foregroundColorSpan, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 18);
        bVar2.mux.setUrl(transferRecordParcel.mug);
        bVar2.muy.setText(spannableString);
        bVar2.muz.setText(this.mContext.getString(a$i.bank_remit_select_payee_name_with_remark, new Object[]{transferRecordParcel.knE, transferRecordParcel.muB}));
        return view;
    }

    public final Filter getFilter() {
        if (this.muu == null) {
            this.muu = new a(this, (byte) 0);
        }
        return this.muu;
    }
}
