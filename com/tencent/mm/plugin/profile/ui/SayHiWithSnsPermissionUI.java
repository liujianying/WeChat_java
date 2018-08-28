package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.openim.b.g;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SayHiWithSnsPermissionUI extends MMActivity implements e {
    private String bgn;
    private String bgo;
    private String chatroomName;
    private ProgressDialog eHw = null;
    private int eLK;
    private int[] eRw = new int[8];
    private String kBP;
    private String lBn;
    private EditText lXV;
    private EditText lXW;
    private View lXX;
    private TextView lXY;
    private MMSwitchBtn lXZ;
    private boolean lYa;
    private boolean lYb;
    private boolean lYc;
    private TextView lYd;
    private MMTagPanel lYe;
    private List<String> lYf;
    private b lYg = new 1(this);
    private CharSequence lYh = null;
    private String userName;

    static /* synthetic */ void c(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", sayHiWithSnsPermissionUI.kBP);
        if (sayHiWithSnsPermissionUI.lYf != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) sayHiWithSnsPermissionUI.lYf);
        }
        intent.putExtra("label_username", sayHiWithSnsPermissionUI.userName);
        intent.putExtra("is_stranger", true);
        d.b(sayHiWithSnsPermissionUI, "label", ".ui.ContactLabelUI", intent);
    }

    static /* synthetic */ String h(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        String trim = sayHiWithSnsPermissionUI.lXV.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.say_hi_with_sns_permission;
    }

    protected void onResume() {
        if (this.lYc) {
            au.HU();
            c.FR().a(this.lYg);
            bnI();
        }
        au.DF().a(30, this);
        au.DF().a(243, this);
        au.DF().a(853, this);
        super.onResume();
    }

    public void onStop() {
        au.DF().b(30, this);
        au.DF().b(243, this);
        au.DF().b(853, this);
        if (this.lYc) {
            au.HU();
            c.FR().b(this.lYg);
        }
        super.onStop();
    }

    protected void onDestroy() {
        h.mEJ.h(14036, new Object[]{Integer.valueOf(this.eRw[0]), Integer.valueOf(this.eRw[1]), Integer.valueOf(this.eRw[2]), Integer.valueOf(this.eRw[3]), Integer.valueOf(this.eRw[4]), Integer.valueOf(this.eRw[5]), Integer.valueOf(this.eRw[6]), Integer.valueOf(this.eRw[7])});
        super.onDestroy();
    }

    protected final void initView() {
        String str;
        String string;
        this.lXZ = (MMSwitchBtn) findViewById(R.h.not_allow_see_permission).findViewById(R.h.checkbox);
        this.lXZ.setCheck(false);
        this.lYa = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
        this.lYb = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
        this.lYc = getIntent().getBooleanExtra("sayhi_with_sns_perm_set_label", false);
        this.userName = getIntent().getStringExtra("Contact_User");
        this.eLK = getIntent().getIntExtra("Contact_Scene", 9);
        this.chatroomName = getIntent().getStringExtra("room_name");
        this.bgo = getIntent().getStringExtra("Contact_RemarkName");
        this.bgn = getIntent().getStringExtra("Contact_Nick");
        this.lBn = getIntent().getStringExtra("Contact_RoomNickname");
        this.lXX = findViewById(R.h.mod_remark_recommend_name_area);
        this.lXY = (TextView) findViewById(R.h.mod_remark_recommend_tip);
        setMMTitle(getString(R.l.app_name));
        if (ab.XR(this.userName)) {
            View findViewById = findViewById(R.h.not_allow_see_permission_layout);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        if (this.lYa) {
            setMMTitle(getString(R.l.sendrequest_title));
            this.lXV = (EditText) findViewById(R.h.say_hi_content);
            this.lXV.setMinHeight(this.mController.tml.getResources().getDimensionPixelSize(R.f.MMClearEditTextMinHeight));
            com.tencent.mm.ui.tools.a.c.d(this.lXV).Gi(100).a(null);
            this.lXV.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.qTb);
            ((LinearLayout) this.lXV.getParent()).setVisibility(0);
            au.HU();
            str = (String) c.DT().get(294913, null);
            String GH = q.GH();
            if (GH == null) {
                GH = "";
            }
            string = getString(R.l.sendgreeting_content);
            if (string.length() + GH.length() > 50) {
                GH = GH.substring(0, 50 - string.length());
            }
            this.lYh = j.a(this.mController.tml, String.format(string, new Object[]{GH}), this.lXV.getTextSize());
            if (bi.oW(str)) {
                this.lXV.setText(this.lYh);
            } else {
                this.lXV.setText(j.a(this.mController.tml, str, this.lXV.getTextSize()));
            }
            this.lXV.requestFocus();
            this.lXV.postDelayed(new 2(this), 100);
        }
        if (this.lYb) {
            this.lXW = (EditText) findViewById(R.h.say_hi_remark);
            ((LinearLayout) this.lXW.getParent()).setVisibility(0);
            if (!this.lYa) {
                this.lXW.clearFocus();
            }
            this.lXW.setMinHeight(this.mController.tml.getResources().getDimensionPixelSize(R.f.MMClearEditTextMinHeight));
            com.tencent.mm.ui.tools.a.c.d(this.lXW).Gi(100).a(null);
            this.lXW.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.qTb);
            if (!this.lYa) {
                this.eRw[0] = 1;
                setMMTitle(getString(R.l.contact_verify_title));
                LayoutParams layoutParams = (LayoutParams) ((View) this.lXW.getParent()).getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            if (bi.oW(this.bgo)) {
                k kVar;
                if (!bi.oW(this.bgn)) {
                    this.lXW.setHint(j.a(this.mController.tml, this.bgn, this.lXW.getTextSize()));
                    this.lXW.setOnFocusChangeListener(new 3(this));
                }
                boolean z;
                switch (this.eLK) {
                    case 8:
                    case 14:
                        if (!bi.oW(this.lBn) && !this.lBn.equals(this.lXW.getText().toString())) {
                            this.lXX.setVisibility(0);
                            this.lXY.setText(j.a(this, bi.oV(getString(R.l.contact_info_set_reamrk_chatroom_name, new Object[]{this.lBn})), this.lXY.getTextSize()));
                            k kVar2 = new k(getString(R.l.write_contact_remark));
                            kVar2.setSpan(new a(this, this.lBn), 0, kVar2.length(), 17);
                            this.lXY.append(" ");
                            this.lXY.append(kVar2);
                            this.lXY.setMovementMethod(LinkMovementMethod.getInstance());
                            this.eRw[3] = 2;
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                        break;
                    case 10:
                    case 11:
                    case 13:
                        a pp = com.tencent.mm.plugin.account.b.getAddrUploadStg().pp(this.userName);
                        if (pp != null && !bi.oW(pp.Xj()) && !pp.Xj().equals(this.lXW.getText().toString())) {
                            this.lXX.setVisibility(0);
                            this.lXY.setText(j.a(this, bi.oV(getString(R.l.contact_info_set_reamrk_mobile_name, new Object[]{pp.Xj()})), this.lXY.getTextSize()));
                            kVar = new k(getString(R.l.write_contact_remark));
                            kVar.setSpan(new a(this, pp.Xj()), 0, kVar.length(), 17);
                            this.lXY.append(" ");
                            this.lXY.append(kVar);
                            this.lXY.setMovementMethod(LinkMovementMethod.getInstance());
                            this.eRw[3] = 1;
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (!(this.lYa || z)) {
                    at YO = com.tencent.mm.az.d.SE().YO(this.userName);
                    if (YO != null) {
                        com.tencent.mm.pluginsdk.ui.preference.b a = com.tencent.mm.pluginsdk.ui.preference.b.a(this, YO);
                        if (!(bi.oW(a.dzA) || a.dzA.equals(getString(R.l.fmessage_from_verify_digest_tip)))) {
                            string = getString(R.l.sendgreeting_content).substring(0, getString(R.l.sendgreeting_content).indexOf("%s"));
                            str = a.dzA;
                            if (a.dzA.startsWith(string)) {
                                str = a.dzA.substring(string.length());
                            }
                            this.lXX.setVisibility(0);
                            this.lXY.setText(j.a(this, bi.oV(getString(R.l.contact_info_set_remark_verify_info, new Object[]{a.dzA})), this.lXY.getTextSize()));
                            kVar = new k(getString(R.l.write_contact_remark));
                            kVar.setSpan(new a(this, str), 0, kVar.length(), 17);
                            this.lXY.append(" ");
                            this.lXY.append(kVar);
                            this.lXY.setMovementMethod(LinkMovementMethod.getInstance());
                            this.eRw[3] = 3;
                        }
                    }
                }
            } else {
                this.lXW.setText(j.a(this.mController.tml, this.bgo, this.lXW.getTextSize()));
                this.eRw[6] = 1;
            }
        }
        if (ab.XR(this.userName)) {
            this.lYc = false;
        }
        if (this.lYc) {
            this.lYd = (TextView) findViewById(R.h.mod_label_edit_text);
            this.lYe = (MMTagPanel) findViewById(R.h.contact_label_display_panel);
            this.lYe.setPanelClickable(false);
            ((LinearLayout) ((FrameLayout) this.lYe.getParent()).getParent()).setVisibility(0);
            this.lYd.setOnClickListener(new 4(this));
            this.lYe.setOnClickListener(new 5(this));
        }
        bnI();
        if (!bi.oW(this.kBP)) {
            this.eRw[7] = 1;
        }
        str = getString(R.l.app_send);
        if (!this.lYa) {
            str = getString(R.l.app_finish);
        }
        a(0, str, new 6(this), s.b.tmX);
        setBackBtn(new 7(this));
    }

    private void bnI() {
        au.HU();
        bq Hh = c.FS().Hh(this.userName);
        if (Hh != null) {
            this.kBP = Hh.field_contactLabels;
            this.lYf = (ArrayList) com.tencent.mm.plugin.label.a.a.aYK().FB(this.kBP);
        }
        if (!this.lYc) {
            return;
        }
        if (bi.oW(this.kBP)) {
            this.lYe.setVisibility(4);
            this.lYd.setVisibility(0);
            return;
        }
        this.lYe.setVisibility(0);
        this.lYd.setVisibility(4);
        this.lYe.a(this.lYf, this.lYf);
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 1;
        int i4 = 0;
        x.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (this.lYa) {
                String trim = this.lXV.getText().toString().trim();
                if (bi.oW(trim) || trim.equals(this.lYh)) {
                    au.HU();
                    c.DT().set(294913, "");
                } else {
                    au.HU();
                    c.DT().set(294913, trim);
                }
                switch (i2) {
                    case -34:
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        Toast.makeText(this, R.l.fmessage_request_too_offen, 0).show();
                        break;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                if (i3 != 0) {
                    return;
                }
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.h.bA(this, getString(R.l.sendrequest_send_success));
                if (this.lYb) {
                    String str2 = "";
                    if (this.lXW.getText() != null) {
                        str2 = this.lXW.getText().toString();
                    }
                    if (!bi.oW(str2) && str2.length() > 50) {
                        str2 = str2.substring(0, 50);
                    }
                    if (!bi.oW(str2)) {
                        au.HU();
                        ab Yg = c.FR().Yg(this.userName);
                        Yg.dv(str2);
                        au.HU();
                        bq Hh = c.FS().Hh(this.userName);
                        Hh.field_encryptUsername = this.userName;
                        Hh.field_conRemark = str2;
                        au.HU();
                        c.FS().a(Hh);
                        au.HU();
                        c.FR().S(Yg);
                        this.eRw[2] = 1;
                        if (!(bi.oW(this.bgn) || str2.equals(this.bgn))) {
                            this.eRw[5] = 1;
                        }
                    } else if (bi.oW(this.bgn)) {
                        this.eRw[2] = 2;
                    } else {
                        this.eRw[2] = 0;
                    }
                    List linkedList = new LinkedList();
                    if (lVar instanceof m) {
                        i4 = ((m) lVar).bOh;
                        linkedList = ((m) lVar).qyZ;
                    } else if (lVar instanceof g) {
                        linkedList.add(((g) lVar).eup);
                    }
                    if (i4 == 3 || (lVar instanceof g)) {
                        at YO = com.tencent.mm.az.d.SE().YO(this.userName);
                        au.HU();
                        ab Yg2 = c.FR().Yg(this.userName);
                        if (linkedList != null && linkedList.contains(this.userName)) {
                            if (((int) Yg2.dhP) == 0) {
                                Yg2 = com.tencent.mm.pluginsdk.ui.preference.b.a(YO);
                                au.HU();
                                if (!c.FR().T(Yg2)) {
                                    x.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
                                }
                            }
                            com.tencent.mm.model.s.p(Yg2);
                            au.getNotification().xR();
                            com.tencent.mm.az.d.SF().db(this.userName, 1);
                            com.tencent.mm.pluginsdk.ui.preference.b.aU(this.userName, this.eLK);
                        }
                        au.HU();
                        Yg2 = c.FR().Yg(this.userName);
                        qg qgVar = new qg();
                        qgVar.caP.caR = true;
                        qgVar.caP.caQ = false;
                        qgVar.caP.username = this.userName;
                        com.tencent.mm.sdk.b.a.sFg.m(qgVar);
                        if (this.lXZ.uGQ) {
                            com.tencent.mm.model.s.j(Yg2);
                        } else {
                            com.tencent.mm.model.s.k(Yg2);
                        }
                        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false)) {
                            Intent intent = new Intent();
                            intent.putExtra("friend_message_transfer_username", this.userName);
                            intent.setAction("friend_message_accept_" + this.userName);
                            intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.slide_right_in);
                            intent.putExtra("MMActivity.OverrideExitAnimation", R.a.slide_left_out);
                            d.b(this, "subapp", ".ui.friend.FMessageTransferUI", intent);
                        }
                    }
                }
                setResult(-1, getIntent());
                finish();
            } else if (i == 4 && i2 == -24 && !bi.oW(str)) {
                Toast.makeText(this, str, 1).show();
            } else if (i != 4 || (!(i2 == -2 || i2 == -101) || bi.oW(str))) {
                Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
            } else {
                com.tencent.mm.ui.base.h.a(this, str, getString(R.l.app_tip), getString(R.l.app_ok), null);
            }
        } catch (Exception e) {
            x.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.eRw[0] = 1;
        finish();
        return true;
    }
}
