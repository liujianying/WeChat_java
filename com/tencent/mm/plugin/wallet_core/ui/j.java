package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m.b;
import com.tencent.mm.plugin.wxpay.a$j;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.i;
import java.util.LinkedList;
import java.util.List;

public final class j extends i {
    private LayoutInflater Bc;
    private View hyK;
    private a pgk;
    private MaxListView pvr = ((MaxListView) this.hyK.findViewById(f.wallet_favor_list));
    private TextView pvs = ((TextView) this.hyK.findViewById(f.wallet_favor_discount));
    private a pvt = new a();
    private b pvu;

    class a extends BaseAdapter {
        int pvw = -1;
        List<q> pvx = new LinkedList();
        h pvy = null;
        m<String> pvz = new 1(this);

        public final int getCount() {
            return this.pvx.size();
        }

        public final Object getItem(int i) {
            return this.pvx.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            e eVar;
            CharSequence charSequence;
            CharSequence charSequence2;
            if (view == null) {
                view = j.this.Bc.inflate(g.wallet_coupon_item, viewGroup, false);
                c cVar2 = new c();
                cVar2.pvB = view.findViewById(f.wallet_coupon_section_title);
                cVar2.gsY = (TextView) view.findViewById(f.wallet_coupon_item_title);
                cVar2.hBv = (TextView) view.findViewById(f.wallet_coupon_item_subtitle);
                cVar2.hVS = (TextView) view.findViewById(f.wallet_coupon_item_desc);
                cVar2.pvD = (CheckBox) view.findViewById(f.wallet_coupon_item_checkbox);
                cVar2.pvC = (ImageView) view.findViewById(f.wallet_coupon_divider);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            q qVar = (q) getItem(i);
            if (i != this.pvw || this.pvw <= 0) {
                cVar.pvB.setVisibility(8);
                cVar.pvC.setVisibility(0);
            } else {
                cVar.pvB.setVisibility(0);
                cVar.pvC.setVisibility(8);
            }
            if (bi.oW(qVar.peM)) {
                cVar.gsY.setVisibility(8);
            } else {
                cVar.gsY.setText(qVar.peM);
                cVar.gsY.setVisibility(0);
            }
            String str = qVar.pdS;
            if (!(this.pvy == null || this.pvy.peo == null)) {
                List list = this.pvy.peo;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (str.equals(((e) list.get(i2)).pdS)) {
                        eVar = (e) list.get(i2);
                        break;
                    }
                }
            }
            eVar = null;
            String str2 = qVar.pdT;
            str = qVar.pdU;
            if (eVar != null) {
                charSequence = eVar.pdT;
                charSequence2 = eVar.pdU;
            } else {
                Object charSequence3 = str2;
                Object charSequence22 = str;
            }
            if (bi.oW(charSequence3)) {
                cVar.hBv.setVisibility(8);
            } else {
                cVar.hBv.setText(charSequence3);
                cVar.hBv.setVisibility(0);
            }
            if (bi.oW(charSequence22)) {
                cVar.hVS.setVisibility(8);
            } else {
                cVar.hVS.setText(charSequence22);
                cVar.hVS.setVisibility(0);
            }
            int i3 = ((b) this.pvz.poq.get(i)).poz;
            if (i3 == com.tencent.mm.plugin.wallet_core.model.m.a.pou) {
                cVar.pvD.setChecked(false);
                cVar.pvD.setEnabled(false);
            } else {
                cVar.pvD.setEnabled(true);
                if (i3 == com.tencent.mm.plugin.wallet_core.model.m.a.pov) {
                    cVar.pvD.setChecked(true);
                } else {
                    cVar.pvD.setChecked(false);
                }
            }
            return view;
        }
    }

    private j(Context context) {
        super(context, a$j.mmpwddialog);
        this.Bc = LayoutInflater.from(context);
        this.hyK = LayoutInflater.from(context).inflate(g.wallet_favor_dialog, null);
        this.pvr.setAdapter(this.pvt);
        this.hyK.findViewById(f.wallet_favor_footer).setOnClickListener(new 1(this));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.hyK);
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    public static j a(Context context, Orders orders, String str, b bVar) {
        j jVar = new j(context);
        jVar.setOnCancelListener(null);
        jVar.setCancelable(true);
        jVar.pgk = b.psB.a(orders);
        if (jVar.pgk == null) {
            x.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
            jVar.dismiss();
        } else {
            int i;
            Object obj;
            a aVar = jVar.pvt;
            com.tencent.mm.plugin.wallet.a.f fVar = aVar.pvv.pgk.psv;
            String Pr = aVar.pvv.pgk.Pr(str);
            aVar.pvx = aVar.pvv.pgk.bPV();
            aVar.pvy = aVar.pvv.pgk.Pn(Pr);
            aVar.pvw = -1;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= aVar.pvx.size()) {
                    break;
                }
                if ((((q) aVar.pvx.get(i)).peQ != 0 ? 1 : null) != null) {
                    aVar.pvw = i;
                    break;
                }
                i2 = i + 1;
            }
            List linkedList = new LinkedList();
            if (aVar.pvx != null) {
                i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= aVar.pvx.size()) {
                        break;
                    }
                    linkedList.add(((q) aVar.pvx.get(i)).pdS);
                    i2 = i + 1;
                }
                List linkedList2 = new LinkedList();
                if (fVar != null && fVar.pdZ != null) {
                    i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= fVar.pdZ.size()) {
                            break;
                        }
                        String str2 = ((q) fVar.pdZ.get(i)).pdS;
                        if (!linkedList.contains(str2)) {
                            linkedList2.add(str2);
                        }
                        i2 = i + 1;
                    }
                }
                List linkedList3 = new LinkedList();
                if (fVar == null || fVar.pea == null || fVar.pea.pek == null) {
                    x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
                    obj = null;
                } else {
                    List list = fVar.pea.pek;
                    i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        String str3 = ((h) list.get(i)).pem;
                        i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= linkedList2.size()) {
                                obj = null;
                                break;
                            } else if (str3.contains((CharSequence) linkedList2.get(i3))) {
                                obj = 1;
                                break;
                            } else {
                                i2 = i3 + 1;
                            }
                        }
                        if (obj == null) {
                            linkedList3.add(str3);
                        }
                        i2 = i + 1;
                    }
                    List linkedList4 = new LinkedList();
                    if (!(bi.oW(Pr) || Pr.equals("0"))) {
                        String[] split = Pr.split("-");
                        if (split != null) {
                            for (Object add : split) {
                                linkedList4.add(add);
                            }
                        } else {
                            x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
                            obj = null;
                        }
                    }
                    aVar.pvz.c(linkedList, linkedList4, linkedList3);
                    obj = 1;
                }
            } else {
                x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
                obj = null;
            }
            if (obj == null) {
                x.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
                jVar.dismiss();
            } else {
                jVar.pvs.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_favor_dialog_title);
                jVar.pvr.setOnItemClickListener(new 2(jVar));
            }
        }
        jVar.pvu = bVar;
        jVar.show();
        com.tencent.mm.ui.base.h.a(context, jVar);
        return jVar;
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    private void bQj() {
        x.d("MicroMsg.WalletFavorDialog", "On selection done");
        if (this.pvt != null) {
            m mVar = this.pvt.pvz;
            this.pvu.a(this.pgk.Pq(mVar.a(mVar.poq, -1)));
        }
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bQj();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
