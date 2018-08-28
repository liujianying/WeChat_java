package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SettingsModifyEmailAddrUI extends MMActivity implements e, b {
    private String eFZ = null;
    private String eGa = null;
    private ProgressDialog eHw;
    private EditText mSI;
    private String mSJ;
    private String mSK;
    private TextView mSL;
    private TextView mSM;
    private boolean mSN;
    private boolean mSO;
    private boolean mSP;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        g.DF().a(138, this);
        g.DF().a(254, this);
        g.DF().a(GLIcon.TOP, this);
        g.DF().a(108, this);
        g.DF().a(255, this);
        g.Ei().DT().a(this);
    }

    protected final int getLayoutId() {
        return a.g.settings_modify_email_addr;
    }

    public void onDestroy() {
        g.DF().b(138, this);
        g.DF().b(254, this);
        g.DF().b(GLIcon.TOP, this);
        g.DF().b(108, this);
        g.DF().b(255, this);
        g.Ei().DT().b(this);
        super.onDestroy();
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(bi.p(obj, 0)), mVar});
        if (mVar != g.Ei().DT() || r0 <= 0) {
            x.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(r0), mVar});
            return;
        }
        boolean z;
        Integer num = (Integer) g.Ei().DT().get(7, null);
        this.mSJ = (String) g.Ei().DT().get(5, null);
        if (num == null || (num.intValue() & 2) == 0) {
            z = false;
        } else {
            z = true;
        }
        this.mSN = z;
        this.mSP = this.mSN;
        if (this.mSO) {
            btJ();
        }
    }

    protected final void initView() {
        setMMTitle(i.settings_modify_email_addr);
        this.mSI = (EditText) findViewById(f.settings_modify_email_new_email_et);
        this.mSL = (TextView) findViewById(f.unbind_btn);
        this.mSM = (TextView) findViewById(f.modify_email_warning_tv);
        this.mSJ = (String) g.Ei().DT().get(5, null);
        this.mSI.setText(this.mSJ);
        Integer num = (Integer) g.Ei().DT().get(7, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        this.mSN = z;
        setBackBtn(new 1(this));
        this.mSO = true;
        btJ();
    }

    private void btJ() {
        if (this.mSN) {
            this.mSL.setVisibility(0);
            this.mSL.setText(getString(i.settings_unbind));
            this.mSM.setText(getString(i.settings_modify_email_addr_warning));
            this.mSM.setTextColor(getResources().getColor(c.account_info_email_warn_color));
            this.mSI.setEnabled(false);
            this.mSI.setFilters(new InputFilter[]{new 12(this)});
            this.mSL.setOnClickListener(new 22(this));
            hideVKB(this.mSI);
        } else if (bi.oW(this.mSJ)) {
            btK();
        } else {
            this.mSL.setVisibility(0);
            this.mSL.setText(getString(i.setting_resend_verifyemail));
            this.mSM.setText(getString(i.setting_email_not_verify_tip));
            this.mSM.setTextColor(getResources().getColor(c.red));
            this.mSI.setEnabled(false);
            this.mSI.setFilters(new InputFilter[]{new 23(this)});
            this.mSL.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    final aj ajVar = new aj((String) g.Ei().DT().get(2, null));
                    g.DF().a(ajVar, 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                    ActionBarActivity actionBarActivity = SettingsModifyEmailAddrUI.this.mController.tml;
                    SettingsModifyEmailAddrUI.this.getString(i.app_tip);
                    settingsModifyEmailAddrUI.eHw = h.a(actionBarActivity, SettingsModifyEmailAddrUI.this.getString(i.settings_confirm_email_tip), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            g.DF().c(ajVar);
                        }
                    });
                    SettingsModifyEmailAddrUI.this.YC();
                }
            });
            addTextOptionMenu(0, getString(i.app_edit), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    SettingsModifyEmailAddrUI.this.btK();
                    return true;
                }
            });
            hideVKB(this.mSI);
        }
    }

    private void btK() {
        this.mSL.setVisibility(8);
        this.mSL.setText(getString(i.settings_unbind));
        this.mSM.setText(getString(i.settings_modify_email_addr_warning));
        this.mSM.setTextColor(getResources().getColor(c.account_info_email_warn_color));
        this.mSI.setEnabled(true);
        this.mSI.setFilters(new InputFilter[]{new 26(this)});
        addTextOptionMenu(0, getString(i.app_save), new 27(this));
    }

    private void goBack() {
        YC();
        finish();
        if (this.mSP) {
            setResult(-1);
        } else {
            setResult(0);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + lVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (!com.tencent.mm.plugin.setting.b.ezo.a(this.mController.tml, i, i2, str)) {
            if (lVar.getType() == 254) {
                if (i == 0 && i2 == 0) {
                    this.eGa = ((y) lVar).XM().rsV;
                    this.eFZ = ((y) lVar).XL();
                    if (bi.oW(this.eGa)) {
                        g.DF().a(new r(2), 0);
                        return;
                    }
                    g.DF().a(new d(d.eNY, this.mSI.getText().toString().trim()), 0);
                    return;
                }
                if (this.eHw != null) {
                    this.eHw.dismiss();
                    this.eHw = null;
                }
                if (i2 == -3) {
                    x.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    h.a(this.mController.tml, getString(i.settings_unbind_tips_set_user_password), null, getString(i.settings_unbind_tips_unbind_btn), getString(i.settings_unbind_tips_cancel_btn), true, new 28(this), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -82) {
                    h.a(this, i.setting_unbind_qq_err_one_left, i.app_tip, new 3(this));
                } else if (i2 == -83) {
                    h.a(this, i.setting_unbind_qq_err_has_unbind, i.app_tip, new 4(this));
                } else if (i2 == -84) {
                    h.a(this, i.setting_unbind_qq_err_hasbinded, i.app_tip, new 5(this));
                } else if (i2 == -85) {
                    h.a(this, i.setting_unbind_email_err_bindedbyother, i.app_tip, new 6(this));
                }
            } else if (lVar.getType() == GLIcon.TOP) {
                com.tencent.mm.plugin.setting.b.ezo.vl();
                if (((d) lVar).Oh() == d.eNX) {
                    if (i == 0 && i2 == 0) {
                        h.a(this.mController.tml, i.settings_confirm_email_success_tip, i.app_tip, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    if (this.eHw != null) {
                        this.eHw.dismiss();
                        this.eHw = null;
                    }
                    if (i2 == -82) {
                        h.a(this, i.setting_unbind_qq_err_one_left, i.app_tip, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -83) {
                        h.a(this, i.setting_unbind_qq_err_has_unbind, i.app_tip, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -84) {
                        h.a(this, i.setting_unbind_qq_err_hasbinded, i.app_tip, new 10(this));
                    } else if (i2 == -85) {
                        h.a(this, i.setting_unbind_email_err_bindedbyother, i.app_tip, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -86) {
                        h.a(this, i.setting_unbind_qq_err_qmail, i.app_tip, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        h.a(this.mController.tml, getString(i.settings_confirm_email_fail_tip, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(i.app_tip), new 14(this));
                    }
                } else if (((d) lVar).Oh() == d.eNY) {
                    if (this.eHw != null) {
                        this.eHw.dismiss();
                        this.eHw = null;
                    }
                    if (i == 0 && i2 == 0) {
                        g.Ei().DT().set(7, Integer.valueOf(((Integer) g.Ei().DT().get(7, null)).intValue() | 2));
                        if (bi.oW(this.eGa)) {
                            h.a(this.mController.tml, i.setting_unbind_email_succ, i.app_tip, new 16(this));
                        } else {
                            h.a(this.mController.tml, this.eGa, "", getString(i.app_i_known), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    }
                }
            } else if (lVar.getType() == 138) {
            } else {
                if (lVar.getType() == 108) {
                    if (this.eHw != null) {
                        this.eHw.dismiss();
                        this.eHw = null;
                    }
                    if (i == 0 && i2 == 0) {
                        h.a(this.mController.tml, i.settings_confirm_email_success_tip, i.app_tip, new 17(this));
                        return;
                    }
                    h.a(this.mController.tml, getString(i.settings_confirm_email_fail_tip, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(i.app_tip), new 18(this));
                } else if (lVar.getType() != 255) {
                } else {
                    if (i2 == 0) {
                        g.DF().a(new d(d.eNY, this.mSI.getText().toString().trim()), 0);
                        return;
                    }
                    if (this.eHw != null) {
                        this.eHw.dismiss();
                        this.eHw = null;
                    }
                    h.a(this.mController.tml, getString(i.settings_unbind_tips_set_user_password), null, getString(i.settings_unbind_tips_unbind_btn), getString(i.settings_unbind_tips_cancel_btn), true, new 19(this), new 20(this));
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.mSJ + " newEmail: " + this.mSK);
                    g.DF().a(new y(y.eKS), 0);
                    getString(i.app_tip);
                    this.eHw = h.a(this, getString(i.settings_loading), true, new 21(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
