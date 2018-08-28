package com.tencent.mm.plugin.order.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.e;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI extends WalletBaseUI {
    public boolean acT = false;
    public MMLoadMoreListView hPi;
    public Dialog jhd = null;
    public boolean kUl = true;
    public a lPL = null;
    public List<i> lPM = new ArrayList();
    protected String lPN = null;
    public boolean lPO = false;
    protected Map<String, String> lPP = new HashMap();
    public int mCount = 0;
    public ag mHandler = null;
    public int tH = 0;

    private class b {
        TextView lPS;
        TextView lPT;
        TextView lPU;
        TextView lPV;
        TextView lPW;
        View lPX;
        TextView lPY;
        TextView lPZ;

        private b() {
        }

        /* synthetic */ b(MallOrderRecordListUI mallOrderRecordListUI, byte b) {
            this();
        }
    }

    protected final int getLayoutId() {
        return a$g.mall_order_list;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ag();
        bmA();
        initView();
        this.tH = 0;
        this.lPN = null;
    }

    public void bmA() {
        jr(388);
        jr(389);
    }

    public void bmB() {
        js(388);
        js(389);
    }

    public void onResume() {
        super.onResume();
        if (this.lPL != null) {
            this.lPL.notifyDataSetChanged();
        }
    }

    public void ed(String str, String str2) {
        a(new g(str, str2), true, true);
    }

    public void bmC() {
        a(new e(this.tH, this.lPN), true, true);
    }

    protected final void initView() {
        if (a.af(this) instanceof com.tencent.mm.plugin.order.a.a) {
            this.acT = true;
            bmC();
        }
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.mall_index_ui_my_msg);
        this.hPi = (MMLoadMoreListView) findViewById(a$f.mall_order_list_lv);
        this.lPL = new a(this);
        this.hPi.setAdapter(this.lPL);
        this.hPi.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MallOrderRecordListUI mallOrderRecordListUI = MallOrderRecordListUI.this;
                if (i < mallOrderRecordListUI.lPM.size()) {
                    i iVar = (i) mallOrderRecordListUI.lPM.get(i);
                    if (iVar != null) {
                        Bundle bundle = mallOrderRecordListUI.sy;
                        bundle.putString("key_trans_id", iVar.lOE);
                        bundle.putInt("key_pay_type", iVar.lOM);
                        bundle.putString("bill_id", iVar.lOX);
                        a.j(mallOrderRecordListUI, bundle);
                    }
                }
                com.tencent.mm.wallet_core.ui.e.He(26);
            }
        });
        this.hPi.setOnItemLongClickListener(new 2(this));
        this.hPi.setOnLoadMoreListener(new 3(this));
        sy syVar = new sy();
        syVar.cdO.buF = "6";
        syVar.bJX = new 4(this, syVar);
        com.tencent.mm.sdk.b.a.sFg.m(syVar);
        com.tencent.mm.plugin.order.a.b.bmn().auM();
        this.lPL.notifyDataSetChanged();
        h hVar = h.mEJ;
        Object[] objArr = new Object[1];
        com.tencent.mm.plugin.order.a.b.bmn();
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.order.a.b.bmq().bmv());
        hVar.h(11036, objArr);
    }

    public final void bE(List<i> list) {
        if (list != null && list.size() != 0) {
            if (this.lPM == null) {
                this.lPM = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    i iVar = (i) list.get(i2);
                    if (!Jv(iVar.lOE)) {
                        this.lPM.add(iVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private boolean Jv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.lPM.size(); i++) {
            i iVar = (i) this.lPM.get(i);
            if (iVar != null && str.equals(iVar.lOE)) {
                return true;
            }
        }
        return false;
    }

    public void onDestroy() {
        bmB();
        super.onDestroy();
    }

    public String uu(int i) {
        return com.tencent.mm.wallet_core.ui.e.Hd(i);
    }

    public final void bF(List<d> list) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    d dVar = (d) list.get(i2);
                    if (dVar != null) {
                        this.lPP.put(di(dVar.year, dVar.month), dVar.lOy);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static String di(int i, int i2) {
        return i + "-" + i2;
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof e) {
            if (this.jhd != null) {
                this.jhd.dismiss();
                this.jhd = null;
            }
            e eVar = (e) lVar;
            this.lPN = eVar.lOB;
            bE(eVar.lOz);
            bF(eVar.lOA);
            this.mCount = this.lPM.size();
            this.kUl = eVar.hUg > this.mCount;
            this.lPL.notifyDataSetChanged();
            x.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
            x.d("MicroMsg.WalletOrderListUI", "orders list total record: " + eVar.hUg);
            x.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.kUl);
            this.mHandler.post(new Runnable() {
                public final void run() {
                    if (MallOrderRecordListUI.this.kUl) {
                        x.v("MicroMsg.WalletOrderListUI", "has more");
                        if (!MallOrderRecordListUI.this.lPO) {
                            MallOrderRecordListUI.this.hPi.crC();
                            MallOrderRecordListUI.this.hPi.setAdapter(MallOrderRecordListUI.this.lPL);
                            MallOrderRecordListUI.this.lPO = true;
                        }
                    } else {
                        x.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
                        MallOrderRecordListUI.this.hPi.crD();
                    }
                    MallOrderRecordListUI.this.lPL.notifyDataSetChanged();
                }
            });
            this.acT = false;
        } else if (lVar instanceof g) {
            if (this.jhd != null) {
                this.jhd.dismiss();
                this.jhd = null;
            }
            g gVar = (g) lVar;
            if (gVar.bmw() == 2) {
                if (this.lPM != null) {
                    this.lPM.clear();
                }
                this.mCount = 0;
                this.kUl = false;
                this.hPi.crD();
            } else {
                String bmx = gVar.bmx();
                x.d("MicroMsg.WalletOrderListUI", "delete transId:" + bmx);
                if (!bi.oW(bmx)) {
                    for (i iVar : this.lPM) {
                        if (bmx.equals(iVar.lOE)) {
                            this.lPM.remove(iVar);
                            this.mCount = this.lPM.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable() {
                public final void run() {
                    MallOrderRecordListUI.this.lPL.notifyDataSetChanged();
                }
            });
        }
        if (this.mCount > 0 || this.lPM.size() != 0) {
            showOptionMenu(true);
            findViewById(a$f.empty_tip_layout).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(a$f.empty_tip_layout).setVisibility(0);
        }
        return true;
    }
}
