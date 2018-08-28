package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends BaseAdapter implements Filterable {
    private static String TAG = "MicroMsg.MobileHistoryAdapter";
    private Context mContext;
    private AutoCompleteTextView mpd;
    private List<String[]> mpg;
    public List<a> mpm = new ArrayList();
    public boolean mpn = false;
    private List<a> mpo;
    private String mpq;
    private MallFormView mqP;
    private b mrC;
    public d mrD = null;
    public a mrE = null;

    private class b extends Filter {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }

        protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults;
            FilterResults filterResults2 = new FilterResults();
            List arrayList = new ArrayList();
            String pK = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.pK(charSequence.toString()) : "";
            if (!pK.equals(d.this.mpq) || pK.equals("")) {
                boolean z;
                d.this.mpq = pK;
                if (d.this.mqP.ZF()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    x.i(d.TAG, "performFiltering2 " + charSequence);
                    a bpX = com.tencent.mm.plugin.recharge.a.a.bpX();
                    if (bpX == null || !pK.equals(bpX.mov)) {
                        if (d.this.mpg == null || d.this.mpg.isEmpty()) {
                            d.this.mpg = com.tencent.mm.pluginsdk.a.cz(d.this.mContext);
                        }
                        if (d.this.mpg != null) {
                            for (String[] strArr : d.this.mpg) {
                                String pK2 = com.tencent.mm.plugin.recharge.model.b.pK(strArr[2]);
                                Object ej = ej(d.this.mpq, pK2);
                                if (a.mot.equals(ej)) {
                                    filterResults = filterResults2;
                                    break;
                                } else if (!a.mou.equals(ej) && arrayList.size() < 4) {
                                    a aVar = new a(pK2, strArr[1], 1);
                                    aVar.mox = ej;
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        for (a aVar2 : com.tencent.mm.plugin.recharge.a.a.bpV().bpW()) {
                            Object ej2 = ej(d.this.mpq, com.tencent.mm.plugin.recharge.model.b.pK(aVar2.mov));
                            if (a.mot.equals(ej2)) {
                                filterResults = filterResults2;
                                break;
                            } else if (!a.mou.equals(ej2) && arrayList.size() < 4) {
                                aVar2.mox = ej2;
                                arrayList.add(aVar2);
                            }
                        }
                        x.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else {
                        filterResults = filterResults2;
                    }
                } else if (bi.oW(d.this.mpq)) {
                    arrayList.addAll(d.this.mpo);
                    z = false;
                } else {
                    x.i(d.TAG, "performFiltering1 " + charSequence);
                    for (a aVar22 : d.this.mpo) {
                        if (aVar22.mov.startsWith(d.this.mpq)) {
                            arrayList.add(aVar22);
                        }
                    }
                    z = false;
                }
                filterResults2.count = arrayList.size();
                filterResults2.values = arrayList;
                d.this.mpn = z;
                if (arrayList.size() == 0) {
                    d.this.mqP.mrz = true;
                } else {
                    d.this.mqP.mrz = false;
                }
                filterResults = filterResults2;
            } else {
                d.this.mpd.post(new 1(this));
                filterResults = filterResults2;
            }
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults.values == null) {
                d.this.mpm = new ArrayList();
            } else {
                d.this.mpm = (List) filterResults.values;
            }
            if (filterResults.count == 0) {
                d.this.mqP.mrz = true;
            } else {
                d.this.mqP.mrz = false;
            }
            x.i(d.TAG, "results.count " + filterResults.count);
            if (filterResults.count > 0) {
                d.this.notifyDataSetChanged();
            }
        }

        private static int[] ej(String str, String str2) {
            if (str.equals(str2)) {
                return a.mot;
            }
            if (str2 != null && str.length() == str2.length()) {
                int i = 0;
                int[] iArr = new int[]{-1, -1};
                for (int length = str.length() - 1; length > 0; length--) {
                    if (str2.charAt(length) != str.charAt(length)) {
                        i++;
                        if (i > 2) {
                            break;
                        }
                        iArr[i - 1] = length;
                    }
                }
                if (i <= 2) {
                    return iArr;
                }
            }
            return a.mou;
        }
    }

    private class c {
        TextView eHU;
        TextView mpu;
        ImageView mrH;

        private c() {
        }

        /* synthetic */ c(d dVar, byte b) {
            this();
        }
    }

    public interface d {
    }

    public d(MallFormView mallFormView, List<String[]> list) {
        this.mContext = mallFormView.getContext();
        this.mqP = mallFormView;
        this.mpd = (AutoCompleteTextView) mallFormView.getContentEditText();
        this.mpg = list;
    }

    public final synchronized void bP(List<a> list) {
        this.mpo = list;
        this.mpm.clear();
        this.mpn = false;
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        x.d(TAG, "getFilter");
        if (this.mrC == null) {
            this.mrC = new b(this, (byte) 0);
        }
        return this.mrC;
    }

    public final int getCount() {
        if (this.mpn) {
            return this.mpm.size() + 2;
        }
        return this.mpm.size() > 0 ? this.mpm.size() + 1 : 0;
    }

    /* renamed from: vg */
    public final synchronized a getItem(int i) {
        a aVar = null;
        synchronized (this) {
            if (this.mpn) {
                if (i != 0) {
                    if (i <= this.mpm.size()) {
                        aVar = (a) this.mpm.get(i - 1);
                    }
                }
            } else if (i < this.mpm.size()) {
                aVar = (a) this.mpm.get(i);
            }
        }
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                c cVar;
                if (view == null) {
                    view = View.inflate(this.mContext, g.recharge_input_history_item, null);
                    c cVar2 = new c(this, (byte) 0);
                    cVar2.mpu = (TextView) view.findViewById(f.mall_input_record);
                    cVar2.eHU = (TextView) view.findViewById(f.mall_input_name);
                    cVar2.mrH = (ImageView) view.findViewById(f.top_divider);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!(cVar == null || cVar.mrH == null)) {
                    if (i == 0) {
                        cVar.mrH.setVisibility(0);
                    } else {
                        cVar.mrH.setVisibility(8);
                    }
                }
                a vg = getItem(i);
                if (vg == null || cVar == null || cVar.mpu == null || cVar.eHU == null) {
                    return view;
                }
                CharSequence Km = com.tencent.mm.plugin.recharge.model.b.Km(vg.mov);
                x.d(TAG, "record.record " + Km + ", record.name " + vg.name + "，record.location " + vg.mow);
                if (a.mot.equals(vg.mox)) {
                    cVar.mpu.setTextSize(16.0f);
                    cVar.mpu.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.hint_text_color));
                    cVar.eHU.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.hint_text_color));
                    cVar.mpu.setText(Km);
                } else {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(Km);
                    for (int i2 : vg.mox) {
                        int i22;
                        if (i22 >= 0) {
                            if (i22 >= 7) {
                                i22 += 2;
                            } else if (i22 >= 3) {
                                i22++;
                            }
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.recharge_wrong_number_span_color)), i22, i22 + 1, 34);
                        }
                    }
                    cVar.mpu.setTextSize(24.0f);
                    cVar.mpu.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_text_color));
                    cVar.eHU.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_text_color));
                    cVar.mpu.setText(spannableStringBuilder);
                }
                if (vg.name != null && !bi.oW(vg.name.trim())) {
                    if (bi.oW(vg.mow)) {
                        cVar.eHU.setText(vg.name);
                    } else {
                        cVar.eHU.setText(vg.name + this.mContext.getString(i.wallet_recharge_dest_wrapper, new Object[]{vg.mow}));
                    }
                    if (vg.name.equals(this.mContext.getString(i.wallet_recharge_me))) {
                        cVar.eHU.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.recharge_product_item_bg_clicked));
                        return view;
                    }
                    cVar.eHU.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_color));
                    return view;
                } else if (bi.oW(vg.mow)) {
                    cVar.eHU.setText(this.mContext.getString(i.wallet_recharge_not_in_contact));
                    return view;
                } else {
                    cVar.eHU.setText(this.mContext.getString(i.wallet_recharge_not_in_contact) + this.mContext.getString(i.wallet_recharge_dest_wrapper, new Object[]{vg.mow}));
                    return view;
                }
            case 1:
                view = View.inflate(this.mContext, g.recharge_input_history_last_item, null);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.plugin.recharge.a.a.bpV().bP(null);
                        d.this.mqP.bqn();
                        d.this.bP(new LinkedList());
                        if (d.this.mrE != null) {
                            d.this.mrE.bqe();
                        }
                    }
                });
                return view;
            case 2:
                view = View.inflate(this.mContext, g.recharge_input_history_first_item, null);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        d.this.mpd.dismissDropDown();
                    }
                });
                return view;
            case 3:
                view = View.inflate(this.mContext, g.recharge_input_history_last_item, null);
                ((TextView) view.findViewById(f.recharge_id_last_item_content)).setText(i.mall_recharge_close);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        d.this.mpd.dismissDropDown();
                        d.this.mqP.bqm();
                    }
                });
                return view;
            default:
                return view;
        }
    }

    public final int getItemViewType(int i) {
        if (this.mpn) {
            if (i == 0) {
                return 2;
            }
            if (i > this.mpm.size()) {
                return 3;
            }
            return 0;
        } else if (i >= this.mpm.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }
}
