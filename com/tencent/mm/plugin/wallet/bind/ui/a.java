package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseAdapter {
    private final Context mContext;
    private int mCount = 0;
    com.tencent.mm.plugin.wallet_core.e.a pcA;
    List<String> pcB;
    private ArrayList<Bankcard> pcy;
    private int pcz;

    public a(Context context, ArrayList<Bankcard> arrayList) {
        this.mContext = context;
        this.pcy = arrayList;
        this.pcz = 0;
        this.pcA = new com.tencent.mm.plugin.wallet_core.e.a();
        this.pcA.b(this.mContext, this.pcy);
        bNf();
    }

    public final void P(ArrayList<Bankcard> arrayList) {
        this.pcy = arrayList;
        if (arrayList != null) {
            this.mCount = arrayList.size();
        } else {
            this.mCount = 0;
        }
        if (this.mCount > 0) {
            this.pcA.b(this.mContext, this.pcy);
        }
        bNf();
    }

    private void bNf() {
        g.Ek();
        this.pcB = bi.F(((String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sYg, "")).split(","));
    }

    public int getCount() {
        return this.mCount;
    }

    private Bankcard ze(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return (Bankcard) this.pcy.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        Bankcard ze = ze(i);
        if (ze == null) {
            return 4;
        }
        if (ze.field_bankcardState == 9) {
            if (ze.field_wxcreditState == 0) {
                return 2;
            }
            return 3;
        } else if (ze.bOr() && "CITIC_CREDIT".equals(ze.field_bankcardType)) {
            return 5;
        } else {
            if (ze.bOw()) {
                return 6;
            }
            if (!ze.bOv() || q.GS()) {
                return 1;
            }
            return 0;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Bankcard ze = ze(i);
        if (ze == null) {
            return view;
        }
        boolean z;
        int itemViewType = getItemViewType(i);
        if (this.pcB == null || this.pcB.isEmpty() || ze == null) {
            z = false;
        } else {
            for (String equals : this.pcB) {
                if (equals.equals(ze.field_bindSerial)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        x.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[]{Integer.valueOf(i), ze.field_card_bottom_wording, Boolean.valueOf(z)});
        int i2;
        a aVar;
        a aVar2;
        switch (itemViewType) {
            case 0:
                return b.a(this.mContext, view, ze, com.tencent.mm.plugin.wxpay.a.g.wallet_bankcard, this.pcA, z, itemViewType);
            case 1:
                return b.a(this.mContext, view, ze, com.tencent.mm.plugin.wxpay.a.g.wallet_bankcard_international, this.pcA, z, itemViewType);
            case 2:
                i2 = com.tencent.mm.plugin.wxpay.a.g.wallet_bankcard_wait_2_open;
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, i2, null);
                    aVar = new a(this);
                    aVar.pcH = (ImageView) view.findViewById(f.bank_logo);
                    aVar.pcD = (TextView) view.findViewById(f.bank_name);
                    aVar.pcK = (TextView) view.findViewById(f.new_msg_tip);
                    aVar.pcL = (ImageView) view.findViewById(f.bankcard_id_mask1);
                    aVar.pcM = (ImageView) view.findViewById(f.bankcard_id_mask2);
                    aVar.pcN = (ImageView) view.findViewById(f.bankcard_id_mask3);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                aVar2.pcD.setText(this.mContext.getString(i.wallet_index_ui_open_wxcredit, new Object[]{ze.field_bankName}));
                if (b.a(ze)) {
                    aVar2.pcK.setVisibility(0);
                    return view;
                }
                aVar2.pcK.setVisibility(8);
                return view;
            case 3:
                i2 = com.tencent.mm.plugin.wxpay.a.g.wallet_bankcard_wxcredit_err;
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, i2, null);
                    aVar = new a(this);
                    aVar.pcH = (ImageView) view.findViewById(f.bank_logo);
                    aVar.pcD = (TextView) view.findViewById(f.bank_name);
                    aVar.pcI = (TextView) view.findViewById(f.bankcard_expired);
                    aVar.pcL = (ImageView) view.findViewById(f.bankcard_id_mask1);
                    aVar.pcM = (ImageView) view.findViewById(f.bankcard_id_mask2);
                    aVar.pcN = (ImageView) view.findViewById(f.bankcard_id_mask3);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                switch (ze.field_wxcreditState) {
                    case 1:
                        aVar2.pcI.setBackgroundResource(e.wallet_bankcard_verify);
                        aVar2.pcI.setVisibility(0);
                        break;
                    case 3:
                        aVar2.pcI.setBackgroundResource(e.wallet_bankcard_fail);
                        aVar2.pcI.setVisibility(0);
                        break;
                    default:
                        aVar2.pcI.setVisibility(8);
                        break;
                }
                aVar2.pcD.setText(ze.field_bankName);
                this.pcA.a(this.mContext, ze, aVar2.pcH);
                return view;
            case 4:
                return View.inflate(this.mContext, com.tencent.mm.plugin.wxpay.a.g.wallet_bankcard_add, null);
            case 5:
                return b.a(this.mContext, view, ze, com.tencent.mm.plugin.wxpay.a.g.wallet_bankcard_white, this.pcA, z, itemViewType);
            case 6:
                i2 = com.tencent.mm.plugin.wxpay.a.g.wallet_bankcard_honey_pay;
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, i2, null);
                    aVar = new a(this);
                    aVar.pcH = (ImageView) view.findViewById(f.bank_logo);
                    aVar.pcD = (TextView) view.findViewById(f.bank_name);
                    aVar.pcE = (TextView) view.findViewById(f.bankcard_type);
                    aVar.pcI = (TextView) view.findViewById(f.bankcard_expired);
                    aVar.pcO = (WalletTextView) view.findViewById(f.wallet_bankcard_honeypay_quota_tv);
                    aVar.pcG = (ImageView) view.findViewById(f.bankcard_mask);
                    aVar.pcP = (TextView) view.findViewById(f.wallet_bankcard_honeypay_remain_quota_desc_tv);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.pcH.setImageDrawable(com.tencent.mm.svg.a.a.c(this.mContext.getResources(), h.honey_pay_bank_logo));
                if ((aVar.pcH instanceof CdnImageView) && !bi.oW(ze.pmk)) {
                    ((CdnImageView) aVar.pcH).setUseSdcardCache(true);
                    ((CdnImageView) aVar.pcH).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.bPR());
                    ((CdnImageView) aVar.pcH).cS(ze.pmk, h.honey_pay_bank_logo);
                }
                aVar.pcD.setText(j.a(this.mContext, com.tencent.mm.wallet_core.ui.e.dx(com.tencent.mm.wallet_core.ui.e.gT(ze.pmg), 10), aVar.pcD.getTextSize()));
                aVar.pcE.setText(ze.pmj);
                if (ze.pmh == 0) {
                    CharSequence bigDecimal = com.tencent.mm.wallet_core.ui.e.b(ze.pmf, "100", RoundingMode.HALF_UP).toString();
                    aVar.pcO.setPrefix(v.cDm());
                    aVar.pcO.setText(bigDecimal);
                    aVar.pcO.setVisibility(0);
                    aVar.pcP.setVisibility(0);
                    return view;
                }
                aVar.pcO.setVisibility(4);
                aVar.pcP.setVisibility(4);
                return view;
            default:
                return view;
        }
    }
}
