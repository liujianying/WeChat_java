package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.amk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.wallet_core.c.h$a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankRemitHistoryUI extends BankRemitBaseUI implements d {
    private boolean eBY = false;
    private boolean eBZ = false;
    private k gcQ;
    private View ipW;
    private int limit = 20;
    private ListView mvF;
    private a mvG;
    private List<amk> mvH = new ArrayList();
    private int offset = 0;

    private class a extends BaseAdapter {
        private SimpleDateFormat mvL;

        private a() {
            this.mvL = new SimpleDateFormat(BankRemitHistoryUI.this.mController.tml.getString(i.bank_remit_history_date_format_pattern));
        }

        /* synthetic */ a(BankRemitHistoryUI bankRemitHistoryUI, byte b) {
            this();
        }

        public final int getCount() {
            return BankRemitHistoryUI.this.mvH.size();
        }

        public final Object getItem(int i) {
            return BankRemitHistoryUI.this.mvH.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            if (view == null) {
                view = LayoutInflater.from(BankRemitHistoryUI.this.mController.tml).inflate(g.bank_remit_history_item, viewGroup, false);
                view.setTag(new b(view));
            }
            b bVar = (b) view.getTag();
            amk amk = (amk) getItem(i);
            Object bx = bx(amk.rPc);
            if (i == 0) {
                z = true;
            } else if (bx.equals(bx(((amk) getItem(i - 1)).rPc))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                bVar.mvM.setText(bx);
                bVar.mvM.setVisibility(0);
            } else {
                bVar.mvM.setVisibility(8);
            }
            bVar.mvP.setUrl(amk.mug);
            bVar.fAK.setText(amk.title);
            bVar.mvN.setText(amk.rPd);
            bVar.eBP.setText(amk.rPb);
            if (bi.oW(amk.rPe)) {
                bVar.mvO.setVisibility(8);
            } else {
                if (!bi.oW(amk.rPf)) {
                    bVar.mvO.setTextColor(Color.parseColor(amk.rPf));
                }
                bVar.mvO.setText(amk.rPe);
                bVar.mvO.setVisibility(0);
            }
            return view;
        }

        private String bx(long j) {
            return this.mvL.format(new Date(1000 * j));
        }
    }

    private class b {
        TextView eBP;
        TextView fAK;
        TextView mvM;
        TextView mvN;
        TextView mvO;
        CdnImageView mvP;

        public b(View view) {
            this.mvM = (TextView) view.findViewById(f.brhi_header_tv);
            this.fAK = (TextView) view.findViewById(f.brhi_desc_tv);
            this.mvN = (TextView) view.findViewById(f.brhi_money_tv);
            this.eBP = (TextView) view.findViewById(f.brhi_date_tv);
            this.mvO = (TextView) view.findViewById(f.brhi_state_tv);
            this.mvP = (CdnImageView) view.findViewById(f.brhi_bank_icon_iv);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1511);
        jr(1737);
        setMMTitle(i.bank_remit_history_title);
        initView();
        bra();
    }

    protected final void initView() {
        this.mvF = (ListView) findViewById(f.brhu_lv);
        this.ipW = LayoutInflater.from(this).inflate(g.aa_record_list_loading_more, null);
        this.gcQ = new k(this);
        this.mvG = new a(this, (byte) 0);
        this.mvF.addFooterView(this.ipW);
        this.mvF.setAdapter(this.mvG);
        this.mvF.setOnItemLongClickListener(new 1(this));
        this.mvF.setOnScrollListener(new 2(this));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, i.bank_remit_select_payee_delete_text);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        amk amk = (amk) this.mvF.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (menuItem.getItemId() == 1 && amk != null) {
            x.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[]{amk.rlf});
            l eVar = new e(r0);
            eVar.m(this);
            a(eVar, true, true);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.i) {
            final com.tencent.mm.plugin.remittance.bankcard.a.i iVar = (com.tencent.mm.plugin.remittance.bankcard.a.i) lVar;
            iVar.a(new 5(this, iVar)).b(new h$a() {
                public final void g(int i, int i2, String str, l lVar) {
                    x.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", new Object[]{Integer.valueOf(iVar.mua.hUm), iVar.mua.hUn});
                }
            }).c(new 3(this));
            this.eBY = false;
        } else if (lVar instanceof e) {
            final e eVar = (e) lVar;
            eVar.a(new 8(this, eVar)).b(new h$a() {
                public final void g(int i, int i2, String str, l lVar) {
                    x.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", new Object[]{Integer.valueOf(eVar.mtW.hUm), eVar.mtW.hUn});
                }
            }).c(new 6(this));
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.bank_remit_history_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1511);
        js(1737);
    }

    private void bra() {
        x.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[]{Integer.valueOf(this.limit), Integer.valueOf(this.offset)});
        this.eBY = true;
        l iVar = new com.tencent.mm.plugin.remittance.bankcard.a.i(this.limit, this.offset);
        iVar.m(this);
        a(iVar, false, false);
    }
}
