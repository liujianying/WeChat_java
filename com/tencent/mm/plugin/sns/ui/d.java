package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends BaseAdapter {
    public int fHo = 0;
    private String kCA = null;
    private final Context mContext;
    public b nKA = null;

    public d(Context context, b bVar) {
        this.mContext = context;
        this.nKA = bVar;
        this.kCA = w.fD(ad.getContext());
    }

    public final int getCount() {
        if (this.fHo == 1) {
            return this.nKA.nkH.ohp.nyo.bzl().size();
        }
        int i = 0;
        if (this.nKA.nkH.oho.nzw != null) {
            i = this.nKA.nkH.oho.nzw.list.size();
        }
        return i + 1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.mContext, g.ad_unlike_reason_item, null);
        }
        view.setTag(this.nKA);
        CharSequence charSequence = "";
        if (this.fHo == 1) {
            a aVar = (a) getItem(i);
            if ("zh_CN".equals(this.kCA)) {
                charSequence = aVar.nyy;
            } else if ("zh_TW".equals(this.kCA) || "zh_HK".equals(this.kCA)) {
                charSequence = aVar.nyz;
            } else {
                charSequence = aVar.nyA;
            }
            if (bi.oW(charSequence)) {
                charSequence = aVar.nyA;
            }
        } else if (i != 0) {
            com.tencent.mm.plugin.sns.storage.b.a aVar2 = this.nKA.nkH.oho.nzw;
            if (aVar2 != null && i <= aVar2.list.size()) {
                com.tencent.mm.plugin.sns.storage.b.b bVar = (com.tencent.mm.plugin.sns.storage.b.b) aVar2.list.get(i - 1);
                if ("zh_CN".equals(this.kCA)) {
                    charSequence = bVar.nzz;
                } else if ("zh_TW".equals(this.kCA) || "zh_HK".equals(this.kCA)) {
                    charSequence = bVar.nzA;
                } else {
                    charSequence = bVar.ntt;
                }
                if (bi.oW(charSequence)) {
                    charSequence = bVar.ntt;
                }
            }
        } else if (!(this.nKA == null || this.nKA.nkH.oho == null)) {
            String str;
            com.tencent.mm.plugin.sns.storage.a aVar3 = this.nKA.nkH.ohp;
            if ("zh_CN".equals(this.kCA)) {
                str = aVar3.nyp;
            } else if ("zh_TW".equals(this.kCA) || "zh_HK".equals(this.kCA)) {
                str = aVar3.nyr;
            } else {
                str = aVar3.nyq;
            }
            if (bi.oW(str)) {
                charSequence = this.mContext.getString(j.sns_ad_unlike);
            } else {
                Object charSequence2 = str;
            }
        }
        TextView textView = (TextView) view.findViewById(f.ad_unlike_reason_tv);
        if (this.nKA.nkH.ohp.nys) {
            textView.setTextColor(Color.parseColor("#3A3A3A"));
        } else {
            textView.setTextColor(Color.parseColor("#576B95"));
        }
        textView.setText(charSequence2);
        view.findViewById(f.ad_unlike_reason_sep).setVisibility(i == getCount() + -1 ? 8 : 0);
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final Object getItem(int i) {
        return this.nKA.nkH.ohp.nyo.bzl().get(i);
    }
}
