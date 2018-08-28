package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.c;
import com.tencent.mm.plugin.address.model.h;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.plugin.address.ui.AddrEditView.b;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

public class WalletAddAddressUI extends MMActivity implements e, b {
    private String bXd = "";
    private Dialog eXG = null;
    private int eYg = 0;
    private AddrEditView eZJ;
    private AddrEditView eZK;
    private AddrEditView eZL;
    private AddrEditView eZM;
    private AddrEditView eZN;
    private com.tencent.mm.plugin.address.d.b eZO = null;
    private com.tencent.mm.plugin.address.d.b eZP = new com.tencent.mm.plugin.address.d.b();

    static /* synthetic */ void o(WalletAddAddressUI walletAddAddressUI) {
        if (walletAddAddressUI.eYg != 0) {
            x.d("MicroMsg.WalletAddAddressUI", "modify save addr " + walletAddAddressUI.eZP.toString());
            a.Zx().Zz();
            au.DF().a(new h(walletAddAddressUI.eZP), 0);
            walletAddAddressUI.eXG = com.tencent.mm.ui.base.h.a(walletAddAddressUI, "", true, new 2(walletAddAddressUI));
            return;
        }
        x.d("MicroMsg.WalletAddAddressUI", "add save addr " + walletAddAddressUI.eZP.toString());
        au.DF().a(new c(walletAddAddressUI.eZP), 0);
        walletAddAddressUI.eXG = com.tencent.mm.ui.base.h.a(walletAddAddressUI, "", true, new 3(walletAddAddressUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(415, this);
        au.DF().a(418, this);
        x.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
        x.Da(0);
        this.eYg = getIntent().getIntExtra("address_id", 0);
        if (this.eYg == 0) {
            setMMTitle(R.l.address_add_title);
        } else {
            setMMTitle(R.l.address_modify_title);
        }
        initView();
    }

    public final void initView() {
        a.Zx().Zy();
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.wallet_sv);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.eZJ = (AddrEditView) findViewById(R.h.address_name);
        this.eZK = (AddrEditView) findViewById(R.h.address_country);
        this.eZL = (AddrEditView) findViewById(R.h.address_detail_area);
        this.eZM = (AddrEditView) findViewById(R.h.addresss_post);
        this.eZN = (AddrEditView) findViewById(R.h.address_phone);
        this.eZJ.setOnInputValidChangeListener(this);
        this.eZK.setOnInputValidChangeListener(this);
        this.eZL.setOnInputValidChangeListener(this);
        this.eZM.setOnInputValidChangeListener(this);
        this.eZN.setOnInputValidChangeListener(this);
        this.eZJ.setInfoIvOnClickListener(new 1(this));
        this.eZK.setInfoIvOnClickListener(new 8(this));
        this.eZK.setOnClickListener(new 9(this));
        if (this.eYg != 0) {
            this.eZO = a.Zx().jq(this.eYg);
            this.eZJ.setValStr(this.eZO.eYd);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(this.eZO.eXY)) {
                stringBuilder.append(this.eZO.eXY);
            }
            if (!TextUtils.isEmpty(this.eZO.eXZ)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.eZO.eXZ);
            }
            if (!TextUtils.isEmpty(this.eZO.eYa)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.eZO.eYa);
            }
            this.eZK.setValStr(stringBuilder.toString());
            this.eZL.setValStr(this.eZO.eYc);
            this.eZM.setValStr(this.eZO.eYb);
            this.eZN.setValStr(this.eZO.eYe);
        }
        setBackBtn(new 10(this));
        a(0, getString(R.l.app_save), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (WalletAddAddressUI.this.ZB()) {
                    if (WalletAddAddressUI.this.eYg != 0) {
                        WalletAddAddressUI.this.eZO = a.Zx().jq(WalletAddAddressUI.this.eYg);
                        x.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.this.eZO.toString());
                        WalletAddAddressUI.a(WalletAddAddressUI.this.eZO, WalletAddAddressUI.this.eZP);
                    } else {
                        WalletAddAddressUI.this.eZO = new com.tencent.mm.plugin.address.d.b();
                    }
                    String text = WalletAddAddressUI.this.eZJ.getText();
                    String text2 = WalletAddAddressUI.this.eZK.getText();
                    String text3 = WalletAddAddressUI.this.eZL.getText();
                    String text4 = WalletAddAddressUI.this.eZM.getText();
                    String text5 = WalletAddAddressUI.this.eZN.getText();
                    String[] split = text2.split(" ");
                    if (split.length > 0) {
                        WalletAddAddressUI.this.eZP.eXY = split[0];
                    }
                    if (split.length >= 2) {
                        WalletAddAddressUI.this.eZP.eXZ = split[1];
                    }
                    if (split.length >= 3) {
                        WalletAddAddressUI.this.eZP.eYa = split[2];
                    } else {
                        WalletAddAddressUI.this.eZP.eYa = "";
                    }
                    WalletAddAddressUI.this.eZP.eYc = text3;
                    WalletAddAddressUI.this.eZP.eYd = text;
                    WalletAddAddressUI.this.eZP.eYe = text5;
                    WalletAddAddressUI.this.eZP.eYb = text4;
                    if (!bi.oW(WalletAddAddressUI.this.bXd)) {
                        WalletAddAddressUI.this.eZP.eYf = WalletAddAddressUI.this.bXd;
                    }
                    WalletAddAddressUI.o(WalletAddAddressUI.this);
                }
                return true;
            }
        }, s.b.tmX);
        ZB();
    }

    public void onDestroy() {
        super.onDestroy();
        au.DF().b(415, this);
        au.DF().b(418, this);
        l Zx = a.Zx();
        x.i("MicroMsg.WalletAddrMgr", "clean data");
        for (List clear : Zx.eXQ.values()) {
            clear.clear();
        }
        for (List clear2 : Zx.eXR.values()) {
            clear2.clear();
        }
        Zx.eXP.clear();
        Zx.eXQ.clear();
        Zx.eXR.clear();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("karea_result");
                    if (!bi.oW(stringExtra)) {
                        x.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:" + stringExtra);
                        this.eZK.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bi.oW(stringExtra)) {
                        x.d("MicroMsg.WalletAddAddressUI", "post:" + stringExtra);
                        this.eZM.setValStr(stringExtra);
                    }
                    this.bXd = intent.getStringExtra("kwcode");
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        x.d("MicroMsg.WalletAddAddressUI", "uri == null");
                        return;
                    }
                    String str;
                    String[] d = com.tencent.mm.pluginsdk.a.d(getBaseContext(), data);
                    if (d == null || d.length != 2) {
                        com.tencent.mm.ui.base.h.b(this, getString(R.l.addressui_mall_recharge_pick_contact_error), "", true);
                        stringExtra = null;
                        str = null;
                    } else {
                        stringExtra = d[0];
                        str = d[1];
                    }
                    this.eZJ.setValStr(stringExtra);
                    this.eZN.setValStr(str);
                    if (PhoneNumberUtils.isGlobalPhoneNumber(str)) {
                        ZB();
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.b(this, getString(R.l.addressui_mall_recharge_pick_contact_error), "", true);
                        return;
                    }
                }
                return;
            case 3:
                if (i2 == -1) {
                    Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                    if (addr != null) {
                        x.d("MicroMsg.WalletAddAddressUI", "addr: " + addr.toString());
                        if (addr != null) {
                            StringBuilder stringBuilder;
                            if (a.Zx().y(addr.dRI, addr.dRK, addr.dRL)) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(addr.dRI);
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.dRK);
                                if (!TextUtils.isEmpty(addr.dRL)) {
                                    stringBuilder.append(" ");
                                    stringBuilder.append(addr.dRL);
                                }
                                this.eZK.setValStr(stringBuilder.toString());
                            } else {
                                this.eZK.setValStr("");
                            }
                            stringBuilder = new StringBuilder();
                            if (!TextUtils.isEmpty(addr.dRM)) {
                                stringBuilder.append(addr.dRM);
                            }
                            if (!TextUtils.isEmpty(addr.dRN)) {
                                stringBuilder.append(addr.dRN);
                            }
                            if (!TextUtils.isEmpty(addr.dRO)) {
                                stringBuilder.append(addr.dRO);
                            }
                            if (!TextUtils.isEmpty(addr.dRQ)) {
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.dRQ);
                            }
                            if (!bi.oW(addr.dRQ) || bi.oW(addr.dRH)) {
                                this.eZL.setValStr(stringBuilder.toString());
                            } else {
                                this.eZL.setValStr(addr.dRH);
                            }
                            RcptItem x = a.Zx().x(addr.dRI, addr.dRK, addr.dRL);
                            if (x != null) {
                                this.eZM.setValStr(x.eXM);
                                this.bXd = x.code;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.wallet_add_address_ui;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (this.eXG != null) {
            this.eXG.dismiss();
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.address.d.a aVar = a.Zx().eXO;
            if (aVar.eXW.size() > 0) {
                a(this.eZP, this.eZO);
                com.tencent.mm.plugin.address.d.b bVar = (com.tencent.mm.plugin.address.d.b) aVar.eXW.getFirst();
                if (bVar != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
                } else {
                    setResult(0);
                }
            } else {
                setResult(0);
            }
            finish();
            return;
        }
        switch (i2) {
            case -3104:
            case -3103:
            case -3102:
                com.tencent.mm.ui.base.h.a(this, str, "", new 13(this));
                return;
            case -3100:
                com.tencent.mm.ui.base.h.a(this, R.l.address_add_limit_tips, 0, false, new 12(this));
                return;
            default:
                com.tencent.mm.ui.base.h.a(this, R.l.address_add_fail_tips, 0, false, new 14(this));
                return;
        }
    }

    private boolean ZB() {
        boolean z = false;
        boolean z2 = true;
        if (!this.eZJ.ZF()) {
            z2 = false;
        }
        if (!this.eZL.ZF()) {
            z2 = false;
        }
        if (!this.eZK.ZF()) {
            z2 = false;
        }
        if (!this.eZM.ZF()) {
            z2 = false;
        }
        if (this.eZN.ZF()) {
            z = z2;
        }
        enableOptionMenu(z);
        return z;
    }

    public final void ZC() {
        ZB();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        ZD();
        return true;
    }

    private void ZD() {
        int i;
        int i2 = 1;
        int i3 = R.l.address_back_modify_tip;
        if (this.eYg == 0) {
            i3 = R.l.address_back_add_tip;
        }
        if (this.eZJ.ZG()) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.eZL.ZG()) {
            i = 1;
        }
        if (this.eZK.ZG()) {
            i = 1;
        }
        if (this.eZM.ZG()) {
            i = 1;
        }
        if (!this.eZN.ZG()) {
            i2 = i;
        }
        if (i2 != 0) {
            com.tencent.mm.ui.base.h.a(this, i3, R.l.app_tip, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletAddAddressUI.this.setResult(0);
                    WalletAddAddressUI.this.finish();
                }
            }, null);
            return;
        }
        setResult(0);
        finish();
    }

    private void ZJ() {
        startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 2);
    }

    private void ZK() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.eZK.getText())) {
            stringBuilder.append(this.eZK.getText());
        }
        if (!TextUtils.isEmpty(this.eZL.getText())) {
            stringBuilder.append(this.eZL.getText());
        }
        Intent intent = new Intent();
        intent.putExtra("wallet_address", stringBuilder.toString());
        intent.putExtra("map_view_type", 8);
        d.b(this, "location", ".ui.RedirectUI", intent, 3);
    }

    private static void a(com.tencent.mm.plugin.address.d.b bVar, com.tencent.mm.plugin.address.d.b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.id = bVar.id;
            bVar2.eXY = bVar.eXY;
            bVar2.eXZ = bVar.eXZ;
            bVar2.eYa = bVar.eYa;
            bVar2.eYc = bVar.eYc;
            bVar2.eYd = bVar.eYd;
            bVar2.eYe = bVar.eYe;
            bVar2.eYb = bVar.eYb;
            bVar2.eYf = bVar.eYf;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.WalletAddAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case a$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    ZJ();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 4(this), new 5(this));
                    return;
                }
            case a$k.AppCompatTheme_imageButtonStyle /*64*/:
                if (iArr[0] == 0) {
                    ZK();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 6(this), new 7(this));
                    return;
                }
            default:
                return;
        }
    }
}
