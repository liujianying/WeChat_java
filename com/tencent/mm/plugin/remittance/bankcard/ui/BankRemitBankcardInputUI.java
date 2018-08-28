package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.widget.Button;
import android.widget.Filter.FilterListener;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.a.m;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(1)
public class BankRemitBankcardInputUI extends BankRemitBaseUI {
    private Button eWk;
    private d laa;
    private WalletFormView muE;
    private WalletFormView muF;
    private WalletFormView muG;
    private WalletFormView muH;
    private ListPopupWindow muI;
    private c muJ;
    private FilterListener muK;
    private ArrayList<TransferRecordParcel> muL;
    private ArrayList<TransferRecordParcel> muM;
    private String muN;
    private String muO;
    private String muP;
    private String muQ;
    private String muR;
    private String muS;
    private EnterTimeParcel muT;
    private BankcardElemParcel muU;
    private TransferRecordParcel muV;
    private boolean muW = true;
    private boolean muX = false;
    private boolean muY = false;
    private boolean muZ = false;
    private CdnImageView mux;
    private g mva = null;
    private boolean mvb = false;
    private boolean mvc = false;
    private boolean mvd = true;

    static /* synthetic */ void D(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        x.d("MicroMsg.BankRemitBankcardInputUI", "init popup window");
        bankRemitBankcardInputUI.muI = new ListPopupWindow(bankRemitBankcardInputUI);
        bankRemitBankcardInputUI.muI.MU = com.tencent.mm.bp.a.fk(bankRemitBankcardInputUI) - com.tencent.mm.bp.a.fromDPToPix(bankRemitBankcardInputUI, 30);
        bankRemitBankcardInputUI.muI.PM = com.tencent.mm.bp.a.fromDPToPix(bankRemitBankcardInputUI, 136);
        bankRemitBankcardInputUI.muI.setBackgroundDrawable(new ColorDrawable(0));
        bankRemitBankcardInputUI.muI.setVerticalOffset(1);
        ListPopupWindow listPopupWindow = bankRemitBankcardInputUI.muI;
        listPopupWindow.PK.setAnimationStyle(j.DropMenuAnimation);
        bankRemitBankcardInputUI.muI.PW = bankRemitBankcardInputUI.muE;
        bankRemitBankcardInputUI.muI.setModal(false);
        bankRemitBankcardInputUI.muI.PY = new 18(bankRemitBankcardInputUI);
        bankRemitBankcardInputUI.muK = new 19(bankRemitBankcardInputUI);
        List arrayList = new ArrayList();
        if (bankRemitBankcardInputUI.muL != null) {
            arrayList.addAll(bankRemitBankcardInputUI.muL);
        }
        if (bankRemitBankcardInputUI.muM != null) {
            arrayList.addAll(bankRemitBankcardInputUI.muM);
        }
        bankRemitBankcardInputUI.muJ = new c(bankRemitBankcardInputUI, arrayList);
        bankRemitBankcardInputUI.muI.setAdapter(bankRemitBankcardInputUI.muJ);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2) {
        g gVar;
        x.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by cardNo");
        if (bankRemitBankcardInputUI.mva != null) {
            x.i("MicroMsg.BankRemitBankcardInputUI", "cancel pre scene");
            gVar = bankRemitBankcardInputUI.mva;
            i iVar = bankRemitBankcardInputUI.uYO;
            x.i("MicroMsg.WalletNetSceneMgr", "cancel scene: %s %s", new Object[]{iVar, gVar});
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.c(gVar);
            iVar.eXF.remove(gVar);
            iVar.eXE.remove(gVar);
            if (iVar.eXF.isEmpty() && iVar.eXE.isEmpty() && iVar.eXG != null && iVar.eXG.isShowing()) {
                iVar.eXG.dismiss();
            }
        }
        bankRemitBankcardInputUI.mvd = false;
        gVar = new g(str, str2);
        bankRemitBankcardInputUI.mva = gVar;
        bankRemitBankcardInputUI.a(gVar, true, false);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2, String str3, String str4) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", new Object[]{str3, str4});
        x.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", new Object[]{str, str2});
        bankRemitBankcardInputUI.a(new com.tencent.mm.plugin.remittance.bankcard.a.d(str, str2, str3, str4), true, true);
    }

    static /* synthetic */ void c(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        bankRemitBankcardInputUI.muF.setContentEnabled(true);
        bankRemitBankcardInputUI.muY = false;
    }

    static /* synthetic */ void d(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        bankRemitBankcardInputUI.muG.setClickable(true);
        bankRemitBankcardInputUI.muZ = false;
    }

    static /* synthetic */ void j(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        bankRemitBankcardInputUI.muF.bqn();
        bankRemitBankcardInputUI.muG.bqn();
        bankRemitBankcardInputUI.mux.setImageBitmap(null);
        bankRemitBankcardInputUI.muH.bqn();
        bankRemitBankcardInputUI.muH.setVisibility(8);
        bankRemitBankcardInputUI.bqX();
        bankRemitBankcardInputUI.muP = "";
        bankRemitBankcardInputUI.muQ = "";
        bankRemitBankcardInputUI.muN = "";
        bankRemitBankcardInputUI.muU = null;
        bankRemitBankcardInputUI.muT = null;
    }

    static /* synthetic */ boolean r(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        if (bankRemitBankcardInputUI.muU == null) {
            return false;
        }
        if (bi.oW(bankRemitBankcardInputUI.muU.mul)) {
            return false;
        }
        x.i("MicroMsg.BankRemitBankcardInputUI", "show alert text: %s", new Object[]{bankRemitBankcardInputUI.muU.mul});
        h.a(bankRemitBankcardInputUI, bankRemitBankcardInputUI.muU.mul, "", false, new 21(bankRemitBankcardInputUI));
        return true;
    }

    static /* synthetic */ void v(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        Intent intent = new Intent(bankRemitBankcardInputUI.mController.tml, BankRemitMoneyInputUI.class);
        if (bankRemitBankcardInputUI.muX) {
            intent.putExtra("key_bank_card_seqno", bankRemitBankcardInputUI.muV.muA);
            intent.putExtra("key_bank_card_tailno", bankRemitBankcardInputUI.muV.muB);
            intent.putExtra("key_payee_name", bankRemitBankcardInputUI.muV.muC);
            intent.putExtra("key_input_type", 1);
        } else {
            intent.putExtra("key_bank_card_seqno", bankRemitBankcardInputUI.muP);
            intent.putExtra("key_bank_card_tailno", bankRemitBankcardInputUI.muQ);
            intent.putExtra("key_payee_name", bankRemitBankcardInputUI.muR);
            intent.putExtra("key_input_type", 0);
        }
        intent.putExtra("key_enter_time_scene", bankRemitBankcardInputUI.muT.mun);
        intent.putExtra("key_encrypt_data", bankRemitBankcardInputUI.muN);
        intent.putExtra("key_bank_card_elem_parcel", bankRemitBankcardInputUI.muU);
        bankRemitBankcardInputUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cqh();
        initView();
        sy syVar = new sy();
        syVar.cdO.buF = "12";
        syVar.bJX = new 1(this, syVar);
        com.tencent.mm.sdk.b.a.sFg.m(syVar);
        jr(1348);
        jr(1542);
        jr(1378);
        jr(1349);
        jr(1280);
        this.muS = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sZk, "");
        ho(false);
        x.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
        a(new k(), false, false);
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.bank_remit_title);
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.h.actionbar_icon_dark_more, new 12(this));
        com.tencent.mm.plugin.report.service.h.mEJ.h(14673, new Object[]{Integer.valueOf(1)});
    }

    protected final void initView() {
        this.muE = (WalletFormView) findViewById(f.brbi_name_et);
        this.muF = (WalletFormView) findViewById(f.brbi_card_et);
        this.muG = (WalletFormView) findViewById(f.brbi_bank_name_et);
        this.mux = (CdnImageView) this.muG.findViewById(f.wallet_left_icon);
        this.muH = (WalletFormView) findViewById(f.brbi_arrive_time_et);
        this.eWk = (Button) findViewById(f.brbi_next_btn);
        this.muE.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        this.muE.a(new 22(this));
        this.muE.setOnEditorActionListener(new 23(this));
        this.muE.cDV();
        com.tencent.mm.wallet_core.ui.formview.a.b(this.muF);
        a(this.muF, 2, false, true);
        this.muF.a(new 24(this));
        this.muG.setOnClickListener(new 25(this));
        this.muH.setOnClickListener(new 26(this));
        this.eWk.setOnClickListener(new 27(this));
        this.muE.getInfoIv().setVisibility(0);
        this.muE.getInfoIv().setClickable(true);
        this.muE.getInfoIv().setEnabled(true);
        this.muE.getInfoIv().setOnClickListener(new 20(this));
        bqY();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.a) {
            com.tencent.mm.plugin.remittance.bankcard.a.a aVar = (com.tencent.mm.plugin.remittance.bankcard.a.a) lVar;
            if (aVar.mtT.equals(this.muV.muA)) {
                aVar.a(new 3(this, aVar)).b(new 2(this, aVar)).c(new 28(this));
            } else {
                x.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[]{aVar.mtT, this.muP});
                return true;
            }
        } else if (lVar instanceof g) {
            g gVar = (g) lVar;
            if (gVar == this.mva) {
                x.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
                this.mva = null;
            }
            if (gVar.bKg.equals(this.muF.getMD5Value())) {
                gVar.a(new 6(this, gVar)).b(new 5(this, gVar)).c(new 4(this));
            } else {
                x.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[]{gVar.bKg, this.muF.getMD5Value()});
                return true;
            }
        } else if (lVar instanceof m) {
            final m mVar = (m) lVar;
            this.mvc = true;
            mVar.a(new 9(this, mVar)).b(new com.tencent.mm.wallet_core.c.h.a() {
                public final void g(int i, int i2, String str, l lVar) {
                    x.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[]{Integer.valueOf(mVar.mue.hUm), mVar.mue.hUn});
                    if (!bi.oW(mVar.mue.hUn)) {
                        Toast.makeText(BankRemitBankcardInputUI.this, mVar.mue.hUn, 1).show();
                    }
                    BankRemitBankcardInputUI.this.mvb = true;
                }
            }).c(new 7(this));
        } else if (lVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.d) {
            com.tencent.mm.plugin.remittance.bankcard.a.d dVar = (com.tencent.mm.plugin.remittance.bankcard.a.d) lVar;
            dVar.a(new 13(this, dVar)).b(new 11(this, dVar)).c(new com.tencent.mm.wallet_core.c.h.a() {
                public final void g(int i, int i2, String str, l lVar) {
                    x.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[]{lVar});
                }
            });
        } else if (lVar instanceof k) {
            k kVar = (k) lVar;
            kVar.a(new 16(this, kVar)).b(new 15(this, kVar)).c(new 14(this));
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.bank_remit_bankcard_input_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1348);
        js(1542);
        js(1378);
        js(1349);
        js(1280);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Iterator it;
        if (i == 1) {
            TransferRecordParcel transferRecordParcel;
            if (i2 == -1) {
                this.muW = false;
                this.muP = intent.getStringExtra("key_bank_card_seqno");
                String str = this.muP;
                if (this.muL != null) {
                    it = this.muL.iterator();
                    while (it.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it.next();
                        if (transferRecordParcel.muA.equals(str)) {
                            break;
                        }
                    }
                }
                if (this.muM != null) {
                    it = this.muM.iterator();
                    while (it.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it.next();
                        if (transferRecordParcel.muA.equals(str)) {
                            break;
                        }
                    }
                }
                transferRecordParcel = null;
                this.muV = transferRecordParcel;
                bqU();
                bqY();
                if (this.muV != null) {
                    U(this.muV.muA, this.muO, this.muV.lMV);
                }
                ah.i(new 17(this), 50);
            }
            x.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", new Object[]{Integer.valueOf(i2)});
            if (intent != null) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_delete_seq_no_list");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_modified_record_list");
                if (stringArrayListExtra != null) {
                    it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        m(str2, this.muL);
                        m(str2, this.muM);
                    }
                }
                if (parcelableArrayListExtra != null) {
                    Iterator it2 = parcelableArrayListExtra.iterator();
                    while (it2.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it2.next();
                        a(transferRecordParcel, this.muL);
                        a(transferRecordParcel, this.muM);
                    }
                }
            }
        } else if (i == 3) {
            if (i2 == -1) {
                int intExtra = intent.getIntExtra("key_enter_time_scene", -1);
                if (!(this.muU == null || this.muU.mum == null)) {
                    it = this.muU.mum.iterator();
                    while (it.hasNext()) {
                        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) it.next();
                        if (enterTimeParcel.mun == intExtra) {
                            this.muT = enterTimeParcel;
                            break;
                        }
                    }
                }
                x.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", new Object[]{Integer.valueOf(intExtra)});
                bqW();
                bqY();
            }
        } else if (i != 2) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            this.muU = (BankcardElemParcel) intent.getParcelableExtra("key_bank_card_elem_parcel");
            bqV();
            bqZ();
            bqW();
            bqX();
            bqY();
        }
    }

    private static void a(TransferRecordParcel transferRecordParcel, List<TransferRecordParcel> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel2 = (TransferRecordParcel) list.get(size);
                if (transferRecordParcel2.muA.equals(transferRecordParcel.muA)) {
                    transferRecordParcel2.muD = transferRecordParcel.muD;
                    return;
                }
            }
        }
    }

    private static void m(String str, List<TransferRecordParcel> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel = (TransferRecordParcel) list.get(size);
                if (transferRecordParcel.muA.equals(str)) {
                    list.remove(transferRecordParcel);
                    return;
                }
            }
        }
    }

    private void U(String str, String str2, String str3) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[]{str});
        a(new com.tencent.mm.plugin.remittance.bankcard.a.a(str, str2, str3), false, false);
    }

    private void ho(boolean z) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            a(new m(), true, false);
        } else {
            a(new m(), false, false);
        }
    }

    private void bqU() {
        if (this.muV != null) {
            this.muE.setText(this.muV.muC);
            this.muX = true;
            this.muF.setText(getString(com.tencent.mm.plugin.wxpay.a.i.bank_remit_bank_card_mask_text, new Object[]{this.muV.muB}));
            this.muG.setText(this.muV.knE);
            this.mux.setUrl(this.muV.mug);
            this.muF.bqm();
            this.muF.setContentEnabled(false);
            this.muY = true;
            this.muG.setClickable(false);
            this.muZ = true;
        }
    }

    private void bqV() {
        if (this.muU != null) {
            this.muG.setText(this.muU.knE);
            this.mux.setUrl(this.muU.mug);
        }
    }

    private void bqW() {
        if (this.muT != null) {
            if (bi.oW(this.muT.dxh)) {
                this.muH.setContentTextColorRes(a$c.black);
            } else {
                this.muH.setContentTextColor(Color.parseColor(this.muT.dxh));
            }
            this.muH.setText(this.muT.muo);
            this.muH.setVisibility(0);
        } else if (bi.oW(this.muU.muj)) {
            this.muH.setVisibility(8);
        } else {
            this.muH.setText(this.muU.muj);
            if (bi.oW(this.muU.muk)) {
                this.muH.setContentTextColorRes(a$c.black);
            } else {
                this.muH.setContentTextColor(Color.parseColor(this.muU.muk));
            }
            this.muH.setVisibility(0);
        }
    }

    private void bqX() {
        if (this.muH.getVisibility() == 0) {
            this.muG.setBackground(getResources().getDrawable(e.wallet_clickable_bg));
        } else {
            this.muG.setBackground(getResources().getDrawable(e.bank_remit_form_item_corner_bg));
        }
    }

    private void bqY() {
        if (bi.oW(this.muE.getText()) || this.muE.getText().trim().isEmpty() || bi.oW(this.muF.getText()) || this.muF.getText().trim().isEmpty() || !this.muF.ZF() || bi.oW(this.muG.getText()) || this.muH.getVisibility() != 0 || bi.oW(this.muH.getText()) || this.muU == null || !bi.oW(this.muU.mul)) {
            this.eWk.setEnabled(false);
        } else {
            this.eWk.setEnabled(true);
        }
    }

    private void bqZ() {
        if (this.muU != null && !bi.oW(this.muU.muj)) {
            this.muT = null;
        } else if (this.muU != null && this.muU.mum != null) {
            Iterator it = this.muU.mum.iterator();
            while (it.hasNext()) {
                EnterTimeParcel enterTimeParcel = (EnterTimeParcel) it.next();
                if (enterTimeParcel.muq > 0) {
                    this.muT = enterTimeParcel;
                    return;
                }
            }
        }
    }
}
