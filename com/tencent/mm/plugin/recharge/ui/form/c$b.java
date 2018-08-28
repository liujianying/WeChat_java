package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class c$b {
    public List<String[]> mpg;
    public a mph = null;
    public MallFormView mqP = null;
    public d mqQ;
    boolean mqR = false;

    public c$b(MallFormView mallFormView) {
        this.mqP = mallFormView;
    }

    public final void setInput(a aVar) {
        this.mph = aVar;
        if (aVar != null) {
            if (bi.oW(this.mqP.getText()) || !this.mqP.getText().equals(aVar.mov)) {
                this.mqP.getContentEditText().setText(b.Km(aVar.mov));
            }
            this.mqP.getContentEditText().setSelection(this.mqP.getContentEditText().getText().length());
            x.d(c.bP(), "editTv.setText %s, name: %s, location: %s, type: %s", new Object[]{aVar.mov, aVar.name, aVar.mow, Integer.valueOf(aVar.bJt)});
            Context context = this.mqP.getContext();
            if (this.mph.bJt == 3) {
                this.mqP.getTipsTv().setText(this.mph.name);
                this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.recharge_product_item_bg_clicked));
                return;
            } else if (this.mph.bJt == 1) {
                CharSequence string;
                if (bi.oW(this.mph.name)) {
                    string = context.getString(i.wallet_recharge_not_in_contact);
                    if (!bi.oW(this.mph.mow)) {
                        string = string + context.getString(i.wallet_recharge_dest_wrapper, new Object[]{this.mph.mow});
                    }
                    this.mqP.getTipsTv().setText(string);
                    this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.recharge_err_text_color));
                    return;
                }
                string = this.mph.name;
                if (!bi.oW(this.mph.mow)) {
                    string = string + context.getString(i.wallet_recharge_dest_wrapper, new Object[]{this.mph.mow});
                }
                this.mqP.getTipsTv().setText(string);
                this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.normal_text_color));
                return;
            } else if (this.mph.bJt == 2) {
                if (bi.oW(this.mph.mow)) {
                    this.mqP.getTipsTv().setText("");
                    this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.recharge_err_text_color));
                    return;
                }
                this.mqP.getTipsTv().setText(this.mph.mow);
                this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.normal_text_color));
                return;
            } else if (this.mph.bJt != 0) {
                return;
            } else {
                if (bi.oW(this.mph.mow)) {
                    if (bi.oW(this.mph.name)) {
                        this.mqP.getTipsTv().setText("");
                        this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.normal_text_color));
                        return;
                    }
                    this.mqP.getTipsTv().setText(this.mph.name);
                    this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.recharge_err_text_color));
                    return;
                } else if (bi.oW(this.mph.name)) {
                    this.mqP.getTipsTv().setText(this.mph.mow);
                    this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.normal_text_color));
                    return;
                } else {
                    this.mqP.getTipsTv().setText(this.mph.name + context.getString(i.wallet_recharge_dest_wrapper, new Object[]{this.mph.mow}));
                    this.mqP.getTipsTv().setTextColor(context.getResources().getColor(c.recharge_err_text_color));
                    return;
                }
            }
        }
        this.mqP.getContentEditText().setText("");
        x.d(c.bP(), "editTv.setText null");
        this.mqP.getTipsTv().setText("");
    }

    public final void hn(boolean z) {
        List arrayList;
        x.d(c.bP(), "needSetInput: %s", new Object[]{Boolean.valueOf(z)});
        List bpW = com.tencent.mm.plugin.recharge.a.a.bpV().bpW();
        a bpX;
        if (bpW == null) {
            arrayList = new ArrayList();
            bpX = com.tencent.mm.plugin.recharge.a.a.bpX();
            if (bpX != null) {
                arrayList.add(bpX);
                com.tencent.mm.plugin.recharge.a.a.bpV().a(bpX);
            }
        } else {
            String str = (String) g.Ei().DT().get(6, null);
            for (int i = 0; i < bpW.size(); i++) {
                bpX = (a) bpW.get(i);
                if (bi.oW(bpX.mov) || !bpX.mov.equals(str)) {
                    if (!(bi.oW(bpX.mov) || !bi.oW(bpX.name) || this.mpg == null)) {
                        for (String[] strArr : this.mpg) {
                            if (bpX.mov.equals(b.pK(strArr[2]))) {
                                bpX.name = strArr[1];
                                x.i(c.bP(), "add name: %s", new Object[]{strArr[1]});
                                break;
                            }
                        }
                    }
                } else if (bi.oW(bpX.name) || !bpX.name.equals(this.mqP.getContext().getString(i.wallet_recharge_me))) {
                    bpX.name = this.mqP.getContext().getString(i.wallet_recharge_me);
                } else {
                }
                com.tencent.mm.plugin.recharge.a.a.bpV().bP(bpW);
            }
            arrayList = bpW;
        }
        this.mqQ.bP(arrayList);
        if (arrayList != null && arrayList.size() > 0 && z) {
            this.mph = (a) arrayList.get(0);
            setInput(this.mph);
        }
    }
}
