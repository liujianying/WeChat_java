package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
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
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankRemitSelectPayeeUI extends BankRemitBaseUI implements d {
    private k gcQ;
    private ArrayList<String> mwA;
    private int mwB = -1;
    private int mwC = -1;
    private Intent mwD;
    private ListView mww;
    private b mwx;
    private List<TransferRecordParcel> mwy;
    private ArrayList<TransferRecordParcel> mwz;

    private class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, byte b) {
            this();
        }

        public final int getCount() {
            int size = BankRemitSelectPayeeUI.this.mwy.size();
            if (brc()) {
                size++;
            }
            if (brd()) {
                return size + 1;
            }
            return size;
        }

        public final Object getItem(int i) {
            if (i == BankRemitSelectPayeeUI.this.mwB || i == BankRemitSelectPayeeUI.this.mwC) {
                return null;
            }
            if (i < BankRemitSelectPayeeUI.this.mwC) {
                return BankRemitSelectPayeeUI.this.mwy.get(i - 1);
            }
            if (!brd() || i <= BankRemitSelectPayeeUI.this.mwC) {
                if (brc()) {
                    return BankRemitSelectPayeeUI.this.mwy.get(i - 1);
                }
                x.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(BankRemitSelectPayeeUI.this.mwB), Integer.valueOf(BankRemitSelectPayeeUI.this.mwC)});
                return null;
            } else if (brc()) {
                return BankRemitSelectPayeeUI.this.mwy.get(i - 2);
            } else {
                return BankRemitSelectPayeeUI.this.mwy.get(i - 1);
            }
        }

        public final boolean isEnabled(int i) {
            if (i == BankRemitSelectPayeeUI.this.mwB || i == BankRemitSelectPayeeUI.this.mwC) {
                return false;
            }
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            if (i == BankRemitSelectPayeeUI.this.mwB || i == BankRemitSelectPayeeUI.this.mwC) {
                return 0;
            }
            return 1;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (view == null) {
                if (itemViewType == 0) {
                    view = LayoutInflater.from(BankRemitSelectPayeeUI.this.mController.tml).inflate(g.bank_remit_select_payee_header_item, viewGroup, false);
                } else {
                    view = LayoutInflater.from(BankRemitSelectPayeeUI.this.mController.tml).inflate(g.bank_remit_select_payee_item, viewGroup, false);
                    a aVar = new a(BankRemitSelectPayeeUI.this, (byte) 0);
                    aVar.mwJ = (CdnImageView) view.findViewById(f.brsp_item_bank_icon_iv);
                    aVar.muy = (TextView) view.findViewById(f.brsp_item_payee_name_tv);
                    aVar.mwK = (TextView) view.findViewById(f.brsp_item_bank_info_tv);
                    view.setTag(aVar);
                }
            }
            switch (itemViewType) {
                case 0:
                    boolean z;
                    TextView textView = (TextView) view.findViewById(f.brsp_header_tv);
                    if (BankRemitSelectPayeeUI.this.mwB == i) {
                        itemViewType = 1;
                    } else {
                        z = false;
                    }
                    if (itemViewType == 0) {
                        if (BankRemitSelectPayeeUI.this.mwC == i) {
                            itemViewType = 1;
                        } else {
                            z = false;
                        }
                        if (itemViewType == 0) {
                            textView.setText("");
                            x.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[]{Integer.valueOf(i)});
                            break;
                        }
                        textView.setText(i.bank_remit_select_payee_other_title);
                        break;
                    }
                    textView.setText(i.bank_remit_select_payee_self_title);
                    break;
                case 1:
                    a aVar2 = (a) view.getTag();
                    TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
                    if (transferRecordParcel == null) {
                        aVar2.mwJ.setImageResource(a$c.transparent);
                        aVar2.muy.setText("");
                        aVar2.mwK.setText("");
                        x.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
                        break;
                    }
                    aVar2.mwJ.cS(transferRecordParcel.mug, a$c.transparent);
                    if (bi.oW(transferRecordParcel.muD)) {
                        aVar2.muy.setText(transferRecordParcel.muC);
                    } else {
                        aVar2.muy.setText(j.a(aVar2.mwE.mController.tml, aVar2.mwE.mController.tml.getString(i.bank_remit_select_payee_name_with_remark, new Object[]{transferRecordParcel.muC, transferRecordParcel.muD})));
                    }
                    aVar2.mwK.setText(aVar2.mwE.getString(i.bank_remit_select_payee_name_with_remark, new Object[]{transferRecordParcel.knE, transferRecordParcel.muB}));
                    break;
                default:
                    x.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", new Object[]{Integer.valueOf(itemViewType)});
                    break;
            }
            return view;
        }

        private boolean brc() {
            return BankRemitSelectPayeeUI.this.mwB >= 0;
        }

        private boolean brd() {
            return BankRemitSelectPayeeUI.this.mwC >= 0;
        }
    }

    static /* synthetic */ void a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str) {
        x.i("MicroMsg.BankRemitSelectPayeeUI", "do remove record");
        for (int size = bankRemitSelectPayeeUI.mwy.size() - 1; size >= 0; size--) {
            if (((TransferRecordParcel) bankRemitSelectPayeeUI.mwy.get(size)).muA.equals(str)) {
                bankRemitSelectPayeeUI.mwy.remove(size);
                break;
            }
        }
        bankRemitSelectPayeeUI.mwx.notifyDataSetChanged();
        if (bankRemitSelectPayeeUI.mwA == null) {
            bankRemitSelectPayeeUI.mwA = new ArrayList();
        }
        bankRemitSelectPayeeUI.mwA.add(str);
        bankRemitSelectPayeeUI.mwD.putStringArrayListExtra("key_delete_seq_no_list", bankRemitSelectPayeeUI.mwA);
        bankRemitSelectPayeeUI.setResult(0, bankRemitSelectPayeeUI.mwD);
    }

    static /* synthetic */ void a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        x.i("MicroMsg.BankRemitSelectPayeeUI", "do modify remark: %s", new Object[]{str2});
        bankRemitSelectPayeeUI.a(new com.tencent.mm.plugin.remittance.bankcard.a.j(str, str2), true, false);
    }

    static /* synthetic */ void b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        x.i("MicroMsg.BankRemitSelectPayeeUI", "do modify record");
        if (bankRemitSelectPayeeUI.mwz == null) {
            bankRemitSelectPayeeUI.mwz = new ArrayList();
        }
        for (int size = bankRemitSelectPayeeUI.mwy.size() - 1; size >= 0; size--) {
            TransferRecordParcel transferRecordParcel = (TransferRecordParcel) bankRemitSelectPayeeUI.mwy.get(size);
            if (transferRecordParcel.muA.equals(str)) {
                transferRecordParcel.muD = str2;
                bankRemitSelectPayeeUI.mwz.add(transferRecordParcel);
                break;
            }
        }
        bankRemitSelectPayeeUI.mwx.notifyDataSetChanged();
        bankRemitSelectPayeeUI.mwD.putParcelableArrayListExtra("key_modified_record_list", bankRemitSelectPayeeUI.mwz);
        bankRemitSelectPayeeUI.setResult(0, bankRemitSelectPayeeUI.mwD);
        h.mEJ.h(14673, new Object[]{Integer.valueOf(5)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Collection parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_self_transfer_record_list");
        Collection parcelableArrayListExtra2 = getIntent().getParcelableArrayListExtra("key_freq_transfer_record_list");
        this.mwy = new ArrayList();
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            this.mwB = 0;
            this.mwy.addAll(parcelableArrayListExtra);
        }
        if (!(parcelableArrayListExtra2 == null || parcelableArrayListExtra2.isEmpty())) {
            this.mwC = (this.mwy.size() + this.mwB) + 1;
            this.mwy.addAll(parcelableArrayListExtra2);
        }
        x.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[]{Integer.valueOf(this.mwB), Integer.valueOf(this.mwC)});
        for (TransferRecordParcel transferRecordParcel : this.mwy) {
            x.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[]{transferRecordParcel.muA, transferRecordParcel.muB, transferRecordParcel.mug, transferRecordParcel.knE, transferRecordParcel.lMV, transferRecordParcel.muC, transferRecordParcel.muD});
        }
        this.mwD = new Intent();
        initView();
        setMMTitle(i.bank_remit_select_payee_title);
        jr(1590);
        jr(1395);
    }

    public final void initView() {
        this.mww = (ListView) findViewById(f.brsp_lv);
        this.gcQ = new k(this);
        this.mwx = new b(this, (byte) 0);
        this.mww.setAdapter(this.mwx);
        this.mww.setOnItemClickListener(new 1(this));
        this.mww.setOnItemLongClickListener(new 3(this));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, i.bank_remit_select_payee_remark_text);
        contextMenu.add(0, 0, 0, i.bank_remit_select_payee_delete_text);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) this.mww.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (transferRecordParcel == null) {
            x.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
        } else if (itemId == 1) {
            a.a(this, getString(i.collect_main_add_desc_title), transferRecordParcel.muD, "", 32, new 4(this, transferRecordParcel), new 5(this));
        } else if (itemId == 0) {
            String str = transferRecordParcel.muA;
            x.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
            a(new com.tencent.mm.plugin.remittance.bankcard.a.f(str), true, false);
            h.mEJ.h(14673, new Object[]{Integer.valueOf(7)});
        } else {
            x.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[]{Integer.valueOf(itemId)});
        }
    }

    protected final int getLayoutId() {
        return g.bank_remit_select_payee_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1590);
        js(1395);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.j) {
            com.tencent.mm.plugin.remittance.bankcard.a.j jVar = (com.tencent.mm.plugin.remittance.bankcard.a.j) lVar;
            jVar.a(new 8(this, jVar)).b(new 7(this, jVar)).c(new 6(this));
        } else if (lVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.f) {
            final com.tencent.mm.plugin.remittance.bankcard.a.f fVar = (com.tencent.mm.plugin.remittance.bankcard.a.f) lVar;
            fVar.a(new com.tencent.mm.wallet_core.c.h.a() {
                public final void g(int i, int i2, String str, l lVar) {
                    BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, fVar.mtT);
                }
            }).b(new 10(this, fVar)).c(new 9(this));
        }
        return false;
    }
}
