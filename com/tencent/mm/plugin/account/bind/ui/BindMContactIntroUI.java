package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.al.b$a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class BindMContactIntroUI extends MMWizardActivity implements e {
    private String bTi;
    private ImageView eFS;
    private TextView eFT;
    private TextView eFU;
    private Button eFV;
    private Button eFW;
    private a eFX;
    private i eFY;
    private String eFZ = null;
    private boolean eFl = false;
    private String eGa = null;
    private boolean eGb = false;
    private boolean eGc = false;
    private int eGd = 0;
    private p tipDialog = null;

    static /* synthetic */ void WM() {
        int GJ = q.GJ();
        l.Xz();
        g.Ei().DT().set(7, Integer.valueOf(GJ & -131073));
        com.tencent.mm.plugin.account.a.a.ezo.vl();
    }

    static /* synthetic */ void a(BindMContactIntroUI bindMContactIntroUI) {
        boolean z = false;
        switch (20.eGg[bindMContactIntroUI.eFX.ordinal()]) {
            case 1:
                bindMContactIntroUI.cg(false);
                return;
            case 2:
                String str = bindMContactIntroUI.bTi;
                if (bindMContactIntroUI.eFY == null) {
                    bindMContactIntroUI.eFY = new i(b.eNI, bindMContactIntroUI, new 25(bindMContactIntroUI, str));
                    bindMContactIntroUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactIntroUI.eFY);
                }
                i iVar = bindMContactIntroUI.eFY;
                if (!(bindMContactIntroUI.eGb || bindMContactIntroUI.eGc)) {
                    z = true;
                }
                iVar.eND = z;
                bindMContactIntroUI.eFY.pE(str);
                return;
            case 3:
                g.Ei().DT().set(12322, Boolean.valueOf(false));
                ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).showAddrBookUploadConfirm(bindMContactIntroUI, new 18(bindMContactIntroUI), true, bindMContactIntroUI.eGd);
                return;
            case 4:
                bindMContactIntroUI.startActivity(new Intent(bindMContactIntroUI, MobileFriendUI.class));
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void b(BindMContactIntroUI bindMContactIntroUI) {
        switch (20.eGg[bindMContactIntroUI.eFX.ordinal()]) {
            case 2:
                l.XD();
                bindMContactIntroUI.initView();
                return;
            case 3:
                bindMContactIntroUI.cg(true);
                return;
            case 4:
                bindMContactIntroUI.cg(true);
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.bindmcontact_intro;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(132, this);
        g.DF().a(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE, this);
        g.DF().a(254, this);
        setMMTitle(j.bind_mcontact_title_setting);
    }

    public void onDestroy() {
        g.DF().b(132, this);
        g.DF().b(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE, this);
        g.DF().b(254, this);
        if (this.eFY != null) {
            getContentResolver().unregisterContentObserver(this.eFY);
            this.eFY.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final void initView() {
        this.eGb = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.eGc = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.eFl = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.eGd = getIntent().getIntExtra("key_upload_scene", 0);
        this.eFX = l.XC();
        x.d("MicroMsg.BindMContactIntroUI", "state " + this.eFX);
        this.bTi = (String) g.Ei().DT().get(6, null);
        if (this.bTi == null || this.bTi.equals("")) {
            this.bTi = (String) g.Ei().DT().get(4097, null);
        }
        this.eFS = (ImageView) findViewById(f.setting_bind_moblie_state_icon);
        this.eFT = (TextView) findViewById(f.setting_bind_mobile_msg_title);
        this.eFU = (TextView) findViewById(f.setting_bind_mobile_msg_hit);
        this.eFV = (Button) findViewById(f.setting_bind_mobile_main_btn);
        this.eFW = (Button) findViewById(f.setting_bind_mobile_sub_btn);
        this.eFV.setOnClickListener(new 1(this));
        this.eFW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BindMContactIntroUI.b(BindMContactIntroUI.this);
            }
        });
        if (getIntent().getBooleanExtra("skip", false)) {
            addTextOptionMenu(0, getString(j.app_ignore_it), new 21(this));
        } else {
            setBackBtn(new 22(this));
        }
        if (this.eFX == a.eKu || this.eFX == a.eKt) {
            String value = com.tencent.mm.k.g.AT().getValue("ShowUnbindPhone");
            int i = 2;
            if (!bi.oW(value)) {
                i = bi.WU(value);
            }
            if (i != 0) {
                addIconOptionMenu(1, com.tencent.mm.plugin.account.a.e.mm_title_btn_menu, new 23(this, i));
            }
        }
        switch (20.eGg[this.eFX.ordinal()]) {
            case 1:
                showOptionMenu(1, false);
                this.eFS.setImageResource(com.tencent.mm.plugin.account.a.i.mobile_unbind_icon);
                this.eFU.setVisibility(0);
                this.eFW.setVisibility(8);
                this.eFT.setText(j.bind_mcontact_hint_title);
                this.eFU.setText(j.bind_mcontact_hint);
                this.eFV.setText(j.bind_mcontact_bind_btn_text);
                return;
            case 2:
                showOptionMenu(1, false);
                this.eFS.setImageResource(com.tencent.mm.plugin.account.a.i.mobile_unbind_icon);
                this.eFU.setVisibility(0);
                this.eFW.setVisibility(0);
                this.eFT.setText(String.format(getString(j.bind_mcontact_verify_mobile), new Object[]{this.bTi}));
                this.eFU.setText(j.bind_mcontact_unverify_mobile);
                this.eFV.setText(j.bind_mcontact_verify_btn_text);
                this.eFW.setText(j.bind_mcontact_del_btn_text);
                return;
            case 3:
                showOptionMenu(1, true);
                this.eFS.setImageResource(com.tencent.mm.plugin.account.a.i.mobile_binded_icon);
                this.eFU.setVisibility(0);
                this.eFW.setVisibility(0);
                this.eFT.setText(String.format(getString(j.bind_mcontact_verify_mobile), new Object[]{this.bTi}));
                this.eFU.setText(j.bind_mcontact_change_hint);
                this.eFV.setText(j.bind_mcontact_upload_btn_text);
                this.eFW.setText(j.bind_mcontact_change_mobile_text);
                return;
            case 4:
                showOptionMenu(1, true);
                this.eFS.setImageResource(com.tencent.mm.plugin.account.a.i.mobile_binded_icon);
                this.eFU.setVisibility(0);
                this.eFW.setVisibility(0);
                this.eFT.setText(String.format(getString(j.bind_mcontact_verify_mobile), new Object[]{this.bTi}));
                this.eFU.setText(j.bind_mcontact_change_hint);
                this.eFV.setText(j.bind_mcontact_friend_btn_text);
                this.eFW.setText(j.bind_mcontact_change_mobile_text);
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        WL();
        return true;
    }

    private void WL() {
        YC();
        if (this.eGc) {
            cancel();
            finish();
            return;
        }
        DT(1);
    }

    private void cg(boolean z) {
        Intent intent = new Intent(this, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", this.eGb);
        intent.putExtra("is_bind_for_contact_sync", this.eGc);
        intent.putExtra("is_bind_for_change_mobile", z);
        String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
        if (!bi.oW(simCountryIso)) {
            b$a j = com.tencent.mm.al.b.j(this, simCountryIso, getString(j.country_code));
            if (j != null) {
                intent.putExtra("country_name", j.dYy);
                intent.putExtra("couttry_code", j.dYx);
            }
        }
        MMWizardActivity.D(this, intent);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + lVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() == 132 && i == 0 && i2 == 0) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() == 3) {
                ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).removeSelfAccount(this);
                if (bi.oW(this.eGa)) {
                    MMWizardActivity.D(this, new Intent(this, BindMContactStatusUI.class));
                    return;
                } else {
                    h.a(this, this.eGa, "", getString(j.app_i_known), new 26(this));
                    return;
                }
            }
            return;
        }
        Object obj;
        if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str)) {
            obj = null;
            switch (i2) {
                case -214:
                    com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this, null, null);
                    }
                    obj = 1;
                    break;
                case -43:
                    Toast.makeText(this, j.bind_mcontact_err_binded, 0).show();
                    obj = 1;
                    break;
                case -41:
                    Toast.makeText(this, j.bind_mcontact_err_format, 0).show();
                    obj = 1;
                    break;
                case -36:
                    Toast.makeText(this, j.bind_mcontact_err_unbinded_notbinded, 0).show();
                    obj = 1;
                    break;
                case -35:
                    Toast.makeText(this, j.bind_mcontact_err_binded_by_other, 0).show();
                    obj = 1;
                    break;
                case -34:
                    Toast.makeText(this, j.bind_mcontact_err_freq_limit, 0).show();
                    obj = 1;
                    break;
            }
        }
        obj = 1;
        if (obj == null) {
            com.tencent.mm.plugin.account.friend.a.x xVar;
            ActionBarActivity actionBarActivity;
            if (lVar.getType() == 254) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i == 0 && i2 == 0) {
                    this.eGa = ((y) lVar).XM().rsV;
                    this.eFZ = ((y) lVar).XL();
                    if (bi.oW(this.eGa)) {
                        g.DF().a(new r(2), 0);
                        return;
                    }
                    xVar = new com.tencent.mm.plugin.account.friend.a.x(this.bTi, 3, "", 0, "");
                    g.DF().a(xVar, 0);
                    actionBarActivity = this.mController.tml;
                    getString(j.app_tip);
                    this.tipDialog = h.a(actionBarActivity, getString(j.bind_mcontact_unbinding), true, new 27(this, xVar));
                    return;
                } else if (i2 == -3) {
                    x.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    h.a(this.mController.tml, getString(j.settings_unbind_tips_set_user_password), null, getString(j.settings_unbind_tips_unbind_btn), getString(j.settings_unbind_tips_cancel_btn), true, new 2(this), new 3(this));
                } else if (i2 == -81) {
                    h.a(this, j.setting_unbind_qq_err_norbindqq, j.app_tip, new 4(this));
                } else if (i2 == -82) {
                    h.a(this, j.setting_unbind_qq_err_one_left, j.app_tip, new 5(this));
                } else if (i2 == -83) {
                    h.a(this, j.setting_unbind_qq_err_has_unbind, j.app_tip, new 6(this));
                } else if (i2 == -84) {
                    h.a(this, j.setting_unbind_qq_err_hasbinded, j.app_tip, new 7(this));
                } else if (i2 == -85) {
                    h.a(this, j.setting_unbind_mobile_err_bindedbyother, j.app_tip, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -86) {
                    h.a(this, j.setting_unbind_qq_err_qmail, j.app_tip, new 9(this));
                }
            }
            if (lVar.getType() == com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i2 == 0) {
                    xVar = new com.tencent.mm.plugin.account.friend.a.x(this.bTi, 3, "", 0, "");
                    g.DF().a(xVar, 0);
                    actionBarActivity = this.mController.tml;
                    getString(j.app_tip);
                    this.tipDialog = h.a(actionBarActivity, getString(j.bind_mcontact_unbinding), true, new 10(this, xVar));
                } else {
                    x.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
                    h.a(this.mController.tml, getString(j.settings_unbind_tips_set_user_password), null, getString(j.settings_unbind_tips_unbind_btn), getString(j.settings_unbind_tips_cancel_btn), true, new 11(this), new 13(this));
                }
            }
            if (lVar.getType() == 132) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() != 3) {
                    return;
                }
                if (i2 == -82) {
                    h.a(this, j.setting_unbind_qq_err_one_left, j.app_tip, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    h.a(this, j.setting_unbind_qq_err_has_unbind, j.app_tip, new 15(this));
                } else if (i2 == -84) {
                    h.a(this, j.setting_unbind_qq_err_hasbinded, j.app_tip, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    h.a(this, j.setting_unbind_mobile_err_bindedbyother, j.app_tip, new 17(this));
                } else {
                    Toast.makeText(this, getString(j.bind_mcontact_unbind_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.bTi);
                    g.DF().a(new y(y.eKQ), 0);
                    getString(j.app_tip);
                    this.tipDialog = h.a(this, getString(j.app_loading), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.BindMContactIntroUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 128:
                if (iArr[0] == 0 && this.eFY != null) {
                    this.eFY.Yh();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
