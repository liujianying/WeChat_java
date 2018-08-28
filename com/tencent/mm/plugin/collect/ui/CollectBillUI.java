package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.b.j;
import com.tencent.mm.plugin.collect.b.p;
import com.tencent.mm.plugin.collect.b.r;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class CollectBillUI extends WalletBaseUI {
    private boolean dDR = false;
    private String eBd;
    private int fromScene;
    private k gcQ;
    private View hFL;
    private long hUf;
    private ListView hWR;
    private boolean hWZ = false;
    private a hXn;
    private LinearLayout hXo;
    private CollectBillHeaderView hXp;
    private ImageView hXq;
    private MMSwitchBtn hXr;
    private ImageView hXs;
    private MMSwitchBtn hXt;
    private TextView hXu;
    private boolean hXv = false;
    private boolean hXw = true;
    private long hXx;
    private e hXy = new 1(this);
    private d hXz = new 7(this);
    private int limit = 20;
    private int type;

    static /* synthetic */ void a(CollectBillUI collectBillUI, String str, long j) {
        x.i("MicroMsg.CollectBillUI", "do delete, billid: %s, timestamp: %s", new Object[]{str, Long.valueOf(j)});
        p pVar = new p(str, collectBillUI.type, j);
        collectBillUI.hXw = true;
        collectBillUI.a(pVar, true, false);
    }

    static /* synthetic */ void f(CollectBillUI collectBillUI) {
        if (!collectBillUI.hXv) {
            x.d("MicroMsg.CollectBillUI", "show loading");
            collectBillUI.hWR.addFooterView(collectBillUI.hFL, null, false);
            collectBillUI.hXv = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hXx = q.GK();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        this.type = getIntent().getIntExtra("key_type", 0);
        this.hUf = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000);
        aCf();
        initView();
        setMMTitle(i.collect_bill_title);
        g.Ek();
        g.Eh().dpP.a(1256, this.hXy);
        j jVar = new j();
        g.Ek();
        g.Eh().dpP.a(jVar, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        g.Ek();
        g.Eh().dpP.b(1256, this.hXy);
    }

    protected final void initView() {
        this.hWR = (ListView) findViewById(f.collect_bill_lv);
        this.hXo = (LinearLayout) findViewById(f.collect_bill_empty_ll);
        this.hXu = (TextView) findViewById(f.collect_banner_tips);
        this.hFL = y.gq(this).inflate(a.g.collect_bill_loading_view, this.hWR, false);
        this.hXp = new CollectBillHeaderView(this);
        this.hWR.addHeaderView(this.hXp, null, false);
        this.hXn = new a(this);
        this.hWR.setAdapter(this.hXn);
        this.hWR.setOnScrollListener(new 2(this));
        this.gcQ = new k(this);
        this.hWR.setOnItemClickListener(new 3(this));
        this.hWR.setOnItemLongClickListener(new 4(this));
        if (this.fromScene != 2) {
            addTextOptionMenu(0, getString(i.collect_bill_list_title), new 5(this));
        }
        if (this.fromScene == 2) {
            View findViewById = this.hXp.findViewById(f.collect_rint_switch_layout);
            View findViewById2 = this.hXo.findViewById(f.collect_ring_switch_empty_layout);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        this.hXq = (ImageView) this.hXp.findViewById(f.collect_ring_icon_iv);
        this.hXr = (MMSwitchBtn) this.hXp.findViewById(f.collect_ring_switch_btn);
        this.hXs = (ImageView) this.hXo.findViewById(f.collect_ring_icon_iv);
        this.hXt = (MMSwitchBtn) this.hXo.findViewById(f.collect_ring_switch_btn);
        com.tencent.mm.plugin.collect.a.a.aBC();
        if (com.tencent.mm.plugin.collect.a.a.aBE()) {
            this.hXr.setCheck(true);
            this.hXt.setCheck(true);
            this.hXq.setImageResource(h.collect_sound_on);
            this.hXs.setImageResource(h.collect_sound_on);
        } else {
            this.hXr.setCheck(false);
            this.hXt.setCheck(false);
            this.hXq.setImageResource(h.collect_sound_off);
            this.hXs.setImageResource(h.collect_sound_off);
        }
        6 6 = new 6(this);
        this.hXr.setSwitchListener(6);
        this.hXt.setSwitchListener(6);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, i.collect_bill_menu_item_del_text);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof r) {
            r rVar = (r) lVar;
            if (this.hXv) {
                this.hWR.removeFooterView(this.hFL);
                this.hXv = false;
            }
            if (i == 0 && i2 == 0) {
                this.dDR = rVar.dDR;
                this.type = rVar.type;
                this.hUf = rVar.hUf;
                e(rVar.hUg, rVar.hUh, rVar.hUf);
                if (rVar.hUJ.isEmpty()) {
                    this.dDR = true;
                    if (bi.oW(this.eBd)) {
                        x.i("MicroMsg.CollectBillUI", "no record, show empty view");
                        ajx();
                    }
                } else {
                    if (bi.oW(this.eBd)) {
                        x.d("MicroMsg.CollectBillUI", "first query, hide block view");
                        this.hWR.setVisibility(0);
                        this.hXo.setVisibility(8);
                    }
                    a aVar = this.hXn;
                    aVar.hWN.addAll(rVar.hUJ);
                    aVar.notifyDataSetChanged();
                    this.eBd = ((com.tencent.mm.plugin.collect.b.a) rVar.hUJ.get(rVar.hUJ.size() - 1)).hTH;
                }
                this.hWZ = false;
                return true;
            }
            x.i("MicroMsg.CollectBillUI", "net error!");
            this.hWZ = false;
            Toast.makeText(this, i.collect_bill_item_load_fail_text, 1).show();
            if (bi.oW(this.eBd)) {
                x.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
            }
            return true;
        } else if (!(lVar instanceof p)) {
            return false;
        } else {
            p pVar = (p) lVar;
            if (i == 0 && i2 == 0) {
                a aVar2 = this.hXn;
                String str2 = pVar.hTH;
                for (com.tencent.mm.plugin.collect.b.a aVar3 : aVar2.hWN) {
                    if (aVar3.hTH.equals(str2)) {
                        aVar2.hWN.remove(aVar3);
                        aVar2.notifyDataSetChanged();
                        break;
                    }
                }
                if (this.hXn.getCount() <= 0) {
                    x.i("MicroMsg.CollectBillUI", "delete all records");
                    ajx();
                } else {
                    e(pVar.hUg, pVar.hUh, this.hUf);
                }
                return false;
            }
            x.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, pVar.hTH});
            Toast.makeText(this, i.collect_bill_item_del_fail_text, 1).show();
            return false;
        }
    }

    protected final int getLayoutId() {
        return a.g.collect_bill;
    }

    private void e(int i, int i2, long j) {
        if (this.hXw) {
            CollectBillHeaderView collectBillHeaderView = this.hXp;
            collectBillHeaderView.hWO.setText(com.tencent.mm.plugin.collect.b.e.a(collectBillHeaderView.getContext(), j, this.type));
            collectBillHeaderView.hWP.setText(com.tencent.mm.plugin.collect.b.e.os(i2));
            collectBillHeaderView.hVS.setText(collectBillHeaderView.getContext().getString(i.collect_bill_total_num_text, new Object[]{Integer.valueOf(i)}));
            this.hXw = false;
        }
    }

    private void aCf() {
        if (!this.dDR) {
            a(new r(this.type, this.hUf, this.eBd, this.limit), true, false);
            this.hWZ = true;
        }
    }

    private void ajx() {
        this.hWR.setVisibility(8);
        this.hXo.setVisibility(0);
        findViewById(f.collect_bill_empty_tv).setVisibility(0);
    }
}
