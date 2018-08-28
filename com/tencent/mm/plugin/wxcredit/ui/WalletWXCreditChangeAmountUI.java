package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI extends WalletBaseUI implements OnClickListener {
    private List<l> qwQ;
    private List<l> qwR = new ArrayList();
    private l qwS;
    private l qwT;
    private int qwU = -1;
    private boolean qwV;
    private boolean qwW;
    private TextView qwX;
    private TextView qwY;
    private TextView qwZ;
    private TextView qxa;
    private TextView qxb;
    private TextView qxc;
    private EditText qxd;
    private EditText qxe;
    private EditText qxf;
    private EditText qxg;
    private BaseAdapter qxh = new BaseAdapter() {
        public final int getCount() {
            return WalletWXCreditChangeAmountUI.this.qwR != null ? WalletWXCreditChangeAmountUI.this.qwR.size() : 0;
        }

        private l Bz(int i) {
            return (l) WalletWXCreditChangeAmountUI.this.qwR.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, g.wallet_list_dialog_item_singlechoice, null);
            l Bz = Bz(i);
            checkedTextView.setText(Bz.desc);
            checkedTextView.setChecked(Bz.qwH != 0);
            return checkedTextView;
        }
    };
    private BaseAdapter qxi = new 2(this);

    static /* synthetic */ void a(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        walletWXCreditChangeAmountUI.qwR.clear();
        if (walletWXCreditChangeAmountUI.qwV) {
            for (l lVar : walletWXCreditChangeAmountUI.qwQ) {
                if (lVar.qwH != 2) {
                    walletWXCreditChangeAmountUI.qwR.add(lVar);
                }
            }
            return;
        }
        for (l lVar2 : walletWXCreditChangeAmountUI.qwQ) {
            if (lVar2.qwH != 1) {
                walletWXCreditChangeAmountUI.qwR.add(lVar2);
            }
        }
    }

    static /* synthetic */ boolean b(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        if (walletWXCreditChangeAmountUI.qwS == null || walletWXCreditChangeAmountUI.qwT == null) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.qxd.getVisibility() == 0 && bi.oW(walletWXCreditChangeAmountUI.qxd.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.qxe.getVisibility() == 0 && bi.oW(walletWXCreditChangeAmountUI.qxe.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.qxb.getVisibility() == 0 && bi.oW(walletWXCreditChangeAmountUI.qxb.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.qxf.getVisibility() == 0 && bi.oW(walletWXCreditChangeAmountUI.qxf.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.qxg.getVisibility() == 0 && bi.oW(walletWXCreditChangeAmountUI.qxg.getText().toString())) {
            return false;
        }
        return (walletWXCreditChangeAmountUI.qxc.getVisibility() == 0 && bi.oW(walletWXCreditChangeAmountUI.qxc.getText().toString())) ? false : true;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        View inflate;
        ListViewInScrollView listViewInScrollView;
        a aVar;
        switch (i) {
            case 1:
                inflate = getLayoutInflater().inflate(g.wallet_list_dialog, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.address_contactlist);
                listViewInScrollView.setAdapter(this.qxh);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        WalletWXCreditChangeAmountUI.this.dismissDialog(1);
                        if (WalletWXCreditChangeAmountUI.this.qwV) {
                            WalletWXCreditChangeAmountUI.this.qwS.qwH = 0;
                            WalletWXCreditChangeAmountUI.this.qwS = (l) WalletWXCreditChangeAmountUI.this.qwR.get(i);
                            WalletWXCreditChangeAmountUI.this.qwS.qwH = 1;
                        } else {
                            WalletWXCreditChangeAmountUI.this.qwT.qwH = 0;
                            WalletWXCreditChangeAmountUI.this.qwT = (l) WalletWXCreditChangeAmountUI.this.qwR.get(i);
                            WalletWXCreditChangeAmountUI.this.qwT.qwH = 2;
                        }
                        WalletWXCreditChangeAmountUI.this.aL();
                    }
                });
                aVar = new a(this);
                aVar.Gq(i.wallet_wxcredit_qustion_qustion);
                aVar.dR(inflate);
                aVar.e(null);
                return aVar.anj();
            case 2:
                inflate = getLayoutInflater().inflate(g.wallet_list_dialog, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.address_contactlist);
                listViewInScrollView.setAdapter(this.qxi);
                listViewInScrollView.setOnItemClickListener(new 8(this));
                aVar = new a(this);
                aVar.Gq(i.wallet_wxcredit_qustion_answer);
                aVar.dR(inflate);
                aVar.e(null);
                return aVar.anj();
            case 3:
                String string = getString(i.wallet_wxcredit_qustion_no_chance_finish_confirm);
                if (this.qwU > 0) {
                    string = getString(i.wallet_wxcredit_qustion_finish_confirm, new Object[]{Integer.valueOf(this.qwU)});
                }
                return h.a(this, string, null, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c af = com.tencent.mm.wallet_core.a.af(WalletWXCreditChangeAmountUI.this);
                        if (af != null) {
                            af.b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.sy);
                        } else {
                            WalletWXCreditChangeAmountUI.this.finish();
                        }
                    }
                }, new 10(this));
            default:
                return h.b(this, "", "", true);
        }
    }

    public final int getLayoutId() {
        return g.wallet_wxcredit_change_amount_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        aL();
    }

    protected final void initView() {
        setMMTitle(i.wallet_wxcredit_qustion_title);
        this.qwX = (TextView) findViewById(f.wallet_wxcredit_question_1);
        this.qwZ = (TextView) findViewById(f.wallet_wxcredit_question_1_next);
        this.qwY = (TextView) findViewById(f.wallet_wxcredit_question_2);
        this.qxa = (TextView) findViewById(f.wallet_wxcredit_question_2_next);
        this.qxd = (EditText) findViewById(f.wallet_wxcredit_answer_1);
        this.qxe = (EditText) findViewById(f.wallet_wxcredit_answer_1_next);
        this.qxf = (EditText) findViewById(f.wallet_wxcredit_answer_2);
        this.qxg = (EditText) findViewById(f.wallet_wxcredit_answer_2_next);
        this.qxb = (TextView) findViewById(f.wallet_wxcredit_answer_select_1);
        this.qxc = (TextView) findViewById(f.wallet_wxcredit_answer_select_2);
        this.qxb.setOnClickListener(this);
        this.qxc.setOnClickListener(this);
        this.qwX.setOnClickListener(new 1(this));
        this.qwY.setOnClickListener(new 4(this));
        setBackBtn(new 5(this));
        findViewById(f.next_btn).setOnClickListener(new 6(this));
    }

    private void aL() {
        if (this.qwS != null) {
            this.qwX.setText(this.qwS.desc);
            if (this.qwS.qwK != null) {
                this.qxb.setVisibility(0);
                this.qxd.setVisibility(8);
                this.qwZ.setText(this.qwS.qwK.desc);
                this.qxe.setHint(this.qwS.qwK.hyz);
                if ("Y".equals(this.qwS.kQE)) {
                    this.qwZ.setVisibility(0);
                    this.qxe.setVisibility(0);
                    this.qxb.setText(i.app_yes);
                } else {
                    this.qwZ.setVisibility(8);
                    this.qxe.setVisibility(8);
                    if ("N".equals(this.qwS.kQE)) {
                        this.qxb.setText(i.app_no);
                    }
                }
            } else {
                this.qxb.setVisibility(8);
                this.qxd.setVisibility(0);
                this.qxd.setHint(this.qwS.hyz);
                this.qwZ.setVisibility(8);
                this.qxe.setVisibility(8);
            }
        }
        if (this.qwT != null) {
            this.qwY.setText(this.qwT.desc);
            if (this.qwT.qwK != null) {
                this.qxc.setVisibility(0);
                this.qxf.setVisibility(8);
                this.qxa.setText(this.qwT.qwK.desc);
                this.qxg.setHint(this.qwT.qwK.hyz);
                if ("Y".equals(this.qwT.kQE)) {
                    this.qxa.setVisibility(0);
                    this.qxg.setVisibility(0);
                    this.qxc.setText(i.app_yes);
                    return;
                }
                this.qxa.setVisibility(8);
                this.qxg.setVisibility(8);
                if ("N".equals(this.qwT.kQE)) {
                    this.qxc.setText(i.app_no);
                    return;
                }
                return;
            }
            this.qxc.setVisibility(8);
            this.qxf.setVisibility(0);
            this.qxf.setHint(this.qwT.hyz);
            this.qxa.setVisibility(8);
            this.qxg.setVisibility(8);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof e) {
                this.qwQ = ((e) lVar).qwo;
                this.qwU = ((e) lVar).qwp;
                if (this.qwQ != null && this.qwQ.size() >= 2) {
                    this.qwS = (l) this.qwQ.get(0);
                    this.qwT = (l) this.qwQ.get(1);
                    this.qwS.qwH = 1;
                    this.qwT.qwH = 2;
                }
                aL();
                return true;
            }
        } else if (lVar instanceof com.tencent.mm.plugin.wxcredit.a.c) {
            h.a(this, str, null, false, new 3(this));
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        if (view.getId() == f.wallet_wxcredit_answer_select_1) {
            this.qwW = true;
            showDialog(2);
        } else if (view.getId() == f.wallet_wxcredit_answer_select_2) {
            this.qwW = false;
            showDialog(2);
        }
    }
}
