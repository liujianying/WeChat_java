package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.e.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class g extends BaseAdapter {
    private Orders mCZ = null;
    private Context mContext;
    public ArrayList<Bankcard> oZG;
    private a pcA;
    private int pfw;
    private int puM = -1;
    public String puN = "";
    public boolean puO = true;
    private boolean puP = false;

    public g(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        this.mContext = context;
        this.oZG = arrayList;
        this.pfw = i;
        this.mCZ = orders;
        this.pcA = new a();
        this.pcA.b(this.mContext, this.oZG);
        if (orders != null && orders.ppn == 1) {
            this.puP = true;
        }
    }

    public int getCount() {
        int i = 0;
        if (!this.puP) {
            if (this.mCZ == null || !this.mCZ.ppb.equals("CFT")) {
                i = 1;
            }
            return this.oZG != null ? i + this.oZG.size() : i;
        } else if (this.oZG == null) {
            return 0;
        } else {
            return this.oZG.size();
        }
    }

    /* renamed from: ze */
    public Bankcard getItem(int i) {
        if (this.puP) {
            return (Bankcard) this.oZG.get(i);
        }
        int count = getCount();
        if (this.mCZ == null || !this.mCZ.ppb.equals("CFT")) {
            count--;
        }
        if (i < count) {
            return (Bankcard) this.oZG.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        Bankcard ze = getItem(i);
        if (ze == null || ze.a(this.pfw, this.mCZ) == 0) {
            return true;
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, com.tencent.mm.plugin.wxpay.a.g.wallet_change_bankcard_item, null);
            aVar = new a(this);
            aVar.eBO = (TextView) view.findViewById(f.title);
            aVar.lWL = (TextView) view.findViewById(f.summary);
            aVar.puS = (CheckedTextView) view.findViewById(f.check);
            aVar.puT = (CdnImageView) view.findViewById(f.bank_logo);
            aVar.puR = (FavourLayout) view.findViewById(f.favour_tip);
            aVar.lWL.setText("");
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lWL.setTextColor(ad.getResources().getColor(c.hint_text_color));
        aVar.puR.setVisibility(8);
        Bankcard ze = getItem(i);
        LinkedList linkedList;
        if (ze == null) {
            aVar.puS.setVisibility(4);
            aVar.lWL.setVisibility(8);
            aVar.eBO.setText(i.wallet_pay_bankcard_add);
            aVar.puT.setVisibility(8);
            LinkedList linkedList2 = new LinkedList();
            if (!(this.mCZ == null || this.mCZ.ppg == null || this.mCZ.ppg.pej == null)) {
                k kVar = this.mCZ.ppg.pej.pdO;
                if (kVar != null) {
                    Iterator it = kVar.pet.iterator();
                    while (it.hasNext()) {
                        linkedList2.add(((l) it.next()).mwP);
                    }
                    linkedList = linkedList2;
                    if (this.puO && linkedList.size() > 0) {
                        aVar.puR.setVisibility(0);
                        aVar.lWL.setVisibility(8);
                        aVar.puR.setWording(linkedList);
                    }
                }
            }
            linkedList = linkedList2;
            aVar.puR.setVisibility(0);
            aVar.lWL.setVisibility(8);
            aVar.puR.setWording(linkedList);
        } else {
            aVar.puT.setVisibility(0);
            aVar.puS.setVisibility(0);
            aVar.lWL.setVisibility(0);
            aVar.lWL.setText("");
            if (ze.bOw()) {
                aVar.eBO.setText(j.a(this.mContext, ze.field_desc, aVar.eBO.getTextSize()));
            } else {
                aVar.eBO.setText(ze.field_desc);
            }
            if (ze.bOs()) {
                Bankcard bankcard = o.bOW().paw;
                if (!bi.oW(bankcard.plW)) {
                    aVar.eBO.setText(bankcard.plW);
                } else if (bankcard.plV >= 0.0d) {
                    aVar.eBO.setText(this.mContext.getString(q.GS() ? i.wallet_change_bankcard_balance_left_payu : i.wallet_change_bankcard_balance_left, new Object[]{e.B(bankcard.plV)}));
                } else {
                    aVar.eBO.setText(this.mContext.getText(i.wallet_index_ui_default_balance));
                }
            } else if (ze.bOt()) {
                Bankcard bankcard2 = o.bOW().prG;
                if (!bi.oW(bankcard2.plW)) {
                    aVar.eBO.setText(bankcard2.plW);
                } else if (bankcard2.plV >= 0.0d) {
                    aVar.eBO.setText(this.mContext.getString(i.wallet_lqt_change_bankcard_balance_left, new Object[]{e.B(bankcard2.plV)}));
                } else {
                    aVar.eBO.setText(this.mContext.getText(i.wallet_index_ui_default_balance));
                }
            }
            aVar.lWL.setVisibility(0);
            switch (ze.a(this.pfw, this.mCZ)) {
                case 1:
                    aVar.lWL.setText(i.wallet_pay_bankcard_expired);
                    break;
                case 2:
                    aVar.lWL.setText(i.wallet_pay_bankcard_maintenance);
                    break;
                case 3:
                    aVar.lWL.setText(i.wallet_pay_bankcard_quota);
                    break;
                case 4:
                    aVar.lWL.setText(i.wallet_pay_bankcard_insufficient_balance);
                    break;
                case 5:
                    aVar.lWL.setText(i.wallet_pay_bankcard_domestic);
                    break;
                case 6:
                    aVar.lWL.setText(i.wallet_pay_bankcard_international);
                    break;
                case 7:
                    aVar.lWL.setText(i.wallet_pay_bankcard_not_support_bankcard);
                    break;
                case 8:
                    aVar.lWL.setText(ze.field_forbidWord);
                    break;
                default:
                    if (!bi.oW(ze.field_tips)) {
                        aVar.lWL.setText(ze.field_tips);
                        break;
                    }
                    aVar.lWL.setVisibility(8);
                    break;
            }
            String charSequence = aVar.lWL.getText().toString();
            aVar.eBO.setTextColor(this.mContext.getResources().getColor(c.normal_text_color));
            if (this.puN.equalsIgnoreCase(ze.field_bindSerial)) {
                aVar.puS.setChecked(true);
                aVar.puS.setEnabled(true);
            } else if (isEnabled(i)) {
                aVar.puS.setChecked(false);
                aVar.puS.setEnabled(true);
            } else {
                aVar.puS.setEnabled(false);
                aVar.puS.setChecked(false);
                aVar.eBO.setTextColor(this.mContext.getResources().getColor(c.hint_text_color));
            }
            aVar.puT.setTag(f.wallet_core_bankcard_logo_helper_tag, null);
            aVar.puT.setTag(null);
            aVar.puT.setImageDrawable(null);
            aVar.lWL.setOnClickListener(null);
            if (ze.bOs()) {
                ImageView imageView = aVar.puT;
                if (imageView != null) {
                    imageView.setTag(f.wallet_core_bankcard_logo_helper_tag, null);
                    imageView.setImageResource(com.tencent.mm.plugin.wxpay.a.e.wallet_balance_manager_logo_small);
                }
            } else if (ze.bOt()) {
                this.pcA.a(ze, aVar.puT);
            } else if (ze.bOw()) {
                aVar.puT.setImageDrawable(com.tencent.mm.svg.a.a.c(ad.getResources(), h.honey_pay_bank_logo));
                if (!bi.oW(ze.pmk)) {
                    aVar.puT.setUseSdcardCache(true);
                    aVar.puT.setImgSavedPath(b.bPR());
                    aVar.puT.cS(ze.pmk, h.honey_pay_bank_logo);
                }
            } else {
                this.pcA.a(this.mContext, ze, aVar.puT);
            }
            if (!bi.oW(ze.field_forbid_title) && !bi.oW(ze.field_forbid_url)) {
                charSequence = charSequence + "  ";
                CharSequence spannableString = new SpannableString(charSequence + ze.field_forbid_title);
                aVar.lWL.setOnClickListener(new 1(this));
                spannableString.setSpan(new ForegroundColorSpan(ad.getResources().getColor(c.wallet_forbid_card_link_color)), charSequence.length(), charSequence.length() + ze.field_forbid_title.length(), 34);
                aVar.lWL.setText(spannableString);
                aVar.lWL.setTag(ze.field_forbid_url);
            } else if (this.puO && bi.oW(ze.field_forbidWord) && bi.oW(charSequence)) {
                linkedList = f(ze);
                if (linkedList.size() > 0) {
                    aVar.puR.setVisibility(0);
                    aVar.lWL.setVisibility(8);
                    aVar.puR.setWording(linkedList);
                }
            }
        }
        return view;
    }

    private LinkedList<String> f(Bankcard bankcard) {
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.mCZ == null || this.mCZ.ppg == null || this.mCZ.ppg.pej == null)) {
            Iterator it = this.mCZ.ppg.pej.pdN.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.lMW.equals(bankcard.field_bindSerial)) {
                    it = bVar.pdP.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((com.tencent.mm.plugin.wallet.a.c) it.next()).mwP);
                    }
                    return linkedList;
                }
            }
        }
        return linkedList;
    }

    public final void e(ArrayList<Bankcard> arrayList, boolean z) {
        if (arrayList == null) {
            this.oZG = new ArrayList();
        } else {
            this.oZG = arrayList;
        }
        this.puO = z;
        if (this.oZG.size() > 0) {
            this.pcA.b(this.mContext, this.oZG);
        }
        notifyDataSetChanged();
    }
}
