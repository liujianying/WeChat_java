package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b extends BaseAdapter {
    private LayoutInflater Bc;
    private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    private int kLC = 1;
    List<a> kLz = new ArrayList();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        this.Bc = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.kLz.size();
    }

    private a wn(int i) {
        return (a) this.kLz.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.Bc.inflate(g.sns_lucky_money_record_item, viewGroup, false);
            aVar = new a(this);
            aVar.hVP = (ImageView) view.findViewById(f.lucky_money_record_avatar);
            aVar.jYA = (TextView) view.findViewById(f.lucky_money_record_nickname);
            aVar.kLE = (TextView) view.findViewById(f.lucky_money_record_time);
            aVar.kLF = (TextView) view.findViewById(f.lucky_money_record_amount);
            aVar.kLJ = (TextView) view.findViewById(f.lucky_money_record_game_tips);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a wn = wn(i);
        com.tencent.mm.kernel.g.Ek();
        ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(wn.gtX);
        if (wn.gtX != null) {
            com.tencent.mm.pluginsdk.ui.a.b.n(aVar.hVP, wn.gtX);
        } else {
            x.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[]{wn.gtX});
        }
        TextView textView = aVar.kLE;
        Context context = this.mContext;
        long j = ((long) wn.kKD) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                Time time = new Time();
                time.set(j);
                charSequence = com.tencent.mm.pluginsdk.f.g.a(context.getString(com.tencent.mm.plugin.wxpay.a.i.fmt_datetime, new Object[]{" "}), time).toString();
            } else {
                charSequence = new SimpleDateFormat("HH:mm").format(new Date(j));
            }
        }
        textView.setText(charSequence);
        aVar.kLE.setVisibility(0);
        if (Yg != null) {
            o.a(this.mContext, aVar.jYA, Yg.BL());
        } else {
            x.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[]{wn.gtX});
        }
        amh amh = new amh();
        try {
            if (wn.kKE == null || wn.kKE.siI <= 0) {
                aVar.kLF.setVisibility(8);
                aVar.kLJ.setVisibility(0);
                return view;
            }
            amh.aG(com.tencent.mm.platformtools.ab.a(wn.kKE));
            if (amh.cfh > 0) {
                aVar.kLF.setText(this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_receive_amount, new Object[]{e.A(((double) amh.cfh) / 100.0d)}));
                aVar.kLJ.setVisibility(8);
            } else {
                aVar.kLF.setVisibility(8);
                aVar.kLJ.setVisibility(0);
            }
            return view;
        } catch (Exception e) {
            x.e("SnsLuckyMoneyReceivedRecordListAdapter", e.getMessage() + "hbBuffer is error");
            aVar.kLF.setVisibility(8);
            aVar.kLJ.setVisibility(8);
            aVar.hVP.setVisibility(8);
            aVar.jYA.setVisibility(8);
            aVar.kLE.setVisibility(8);
        }
    }
}
