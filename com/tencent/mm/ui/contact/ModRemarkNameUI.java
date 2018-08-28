package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;

public class ModRemarkNameUI extends MMActivity implements e {
    private String bWJ;
    private int eLK = 9;
    private String fky = "";
    private ab guS;
    private ArrayList<String> lUN;
    private String lVt;
    private MMTagPanel lYe;
    private bq mkY;
    private TextView uiO;
    private View uiP;
    private View uiQ;
    private TextView uiY;
    private EditText ukN;
    private int ukO;
    private String ukP = "";
    private TextView ukQ = null;
    private EditText ukR = null;
    private TextView ukS = null;
    private String ukT = "";
    private boolean ukU = false;
    private a ukV = new a(this, (byte) 0);
    private View ukW;

    static /* synthetic */ void c(ModRemarkNameUI modRemarkNameUI) {
        if (!au.HX()) {
            x.e("MiroMsg.ModRemarkName", "!MMCore.hasSetUin()");
        } else if (modRemarkNameUI.ukN == null) {
            x.e("MiroMsg.ModRemarkName", "remarkName == null in dealModNickName(), return");
        } else {
            String trim = modRemarkNameUI.ukN.getText().toString().trim();
            x.i("MiroMsg.ModRemarkName", "Set New RemarkName : " + trim + ", Report kvStat, addContactScene = " + modRemarkNameUI.eLK);
            h.mEJ.h(10448, new Object[]{Integer.valueOf(modRemarkNameUI.eLK)});
            if (modRemarkNameUI.ukU) {
                modRemarkNameUI.guS.dv(trim);
                bq bqVar = new bq(modRemarkNameUI.guS.field_username, trim);
                bqVar.field_conDescription = modRemarkNameUI.ukR.getText().toString().trim();
                if (!ai.oW(modRemarkNameUI.lVt)) {
                    bqVar.field_contactLabels = modRemarkNameUI.lVt;
                }
                au.HU();
                c.FS().a(bqVar);
                if (modRemarkNameUI.guS != null) {
                    au.HU();
                    c.FR().a(modRemarkNameUI.guS.field_username, modRemarkNameUI.guS);
                }
            }
            modRemarkNameUI.finish();
        }
    }

    static /* synthetic */ void d(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.ukN.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("k_sns_tag_name", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
    }

    static /* synthetic */ void e(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.ukN.getText().toString().trim();
        if (trim.length() > 50) {
            com.tencent.mm.ui.base.h.a(modRemarkNameUI.mController.tml, modRemarkNameUI.getString(R.l.room_chartting_room_nick_max_len_tip), modRemarkNameUI.getString(R.l.room_setting), modRemarkNameUI.getString(R.l.app_cancel), null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Nick", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        a.sFg.m(new sh());
    }

    static /* synthetic */ void j(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.ukR.getText().toString().trim();
        boolean z = (modRemarkNameUI.ukT == null || !modRemarkNameUI.ukT.equals(trim)) && !(ai.oW(modRemarkNameUI.ukT) && ai.oW(trim));
        if (!z) {
            trim = modRemarkNameUI.ukN.getText().toString().trim();
            z = (modRemarkNameUI.ukN == null || !modRemarkNameUI.ukN.equals(trim)) && !(ai.oW(modRemarkNameUI.fky) && ai.oW(trim));
            if (!z) {
                modRemarkNameUI.enableOptionMenu(false);
                return;
            }
        }
        modRemarkNameUI.enableOptionMenu(true);
    }

    static /* synthetic */ void k(ModRemarkNameUI modRemarkNameUI) {
        Intent intent = new Intent();
        if (modRemarkNameUI.lUN != null) {
            intent.putStringArrayListExtra("label_str_list", modRemarkNameUI.lUN);
        }
        intent.putExtra("is_stranger", true);
        intent.putExtra("label_username", modRemarkNameUI.bWJ);
        d.b(modRemarkNameUI, "label", ".ui.ContactLabelUI", intent);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        int i = 0;
        super.onCreate(bundle);
        this.eLK = getIntent().getIntExtra("Contact_Scene", 9);
        this.ukO = getIntent().getIntExtra("Contact_mode_name_type", 0);
        this.ukP = ai.oV(getIntent().getStringExtra("Contact_Nick"));
        this.fky = ai.oV(getIntent().getStringExtra("Contact_RemarkName"));
        this.ukU = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
        initView();
        this.ukW = findViewById(R.h.contact_info_mod_label_con);
        if (this.ukO != 0) {
            this.ukW.setVisibility(8);
        } else {
            this.ukW.setVisibility(0);
        }
        this.lYe = (MMTagPanel) findViewById(R.h.contact_info_mod_label_et);
        this.lYe.setPanelClickable(false);
        this.uiY = (TextView) findViewById(R.h.contact_info_label_tv);
        this.uiY.setText(R.l.mod_label_hint);
        this.lYe.setOnClickListener(this.ukV);
        this.uiY.setOnClickListener(this.ukV);
        if (this.guS == null || !ab.XR(this.guS.field_username)) {
            z = false;
        } else {
            z = true;
        }
        if (z && this.ukN != null) {
            ViewGroup viewGroup = (ViewGroup) this.ukN.getParent();
            int childCount = viewGroup.getChildCount();
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                int id = childAt.getId();
                if (!(id == R.h.contact_info_mod_remark_name_hint_tv || id == R.h.contact_info_mod_remark_name_et)) {
                    childAt.setVisibility(8);
                }
                i++;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.mod_remark_name;
    }

    protected final void initView() {
        this.bWJ = getIntent().getStringExtra("Contact_User");
        if (this.bWJ != null && this.bWJ.length() > 0) {
            au.HU();
            this.guS = c.FR().Yg(this.bWJ);
            au.HU();
            this.mkY = c.FS().Hh(this.bWJ);
            if (this.guS == null || ai.oW(this.guS.field_username)) {
                this.guS = new ab(this.bWJ);
                this.guS.dx(ai.oV(this.ukP));
                this.guS.dv(ai.oV(this.fky));
            }
        }
        this.ukN = (EditText) findViewById(R.h.contact_info_mod_remark_name_et);
        AnonymousClass1 anonymousClass1 = new b() {
            public final void Yr() {
                if (ModRemarkNameUI.this.ukN.getText().toString().trim().length() > 0) {
                    ModRemarkNameUI.this.enableOptionMenu(true);
                }
            }
        };
        com.tencent.mm.pluginsdk.ui.tools.h.a aVar = new com.tencent.mm.pluginsdk.ui.tools.h.a();
        aVar.qTc = anonymousClass1;
        this.ukN.addTextChangedListener(aVar);
        com.tencent.mm.ui.tools.a.c.d(this.ukN).Gi(100).a(null);
        if (!(this.guS == null || this.ukO == 3)) {
            if (this.ukO == 4) {
                this.ukN.setText(j.a(this, ai.oV(this.ukP), this.ukN.getTextSize()));
            } else if (!ai.oW(this.guS.field_conRemark)) {
                this.ukN.setText(j.a(this, ai.oV(this.guS.field_conRemark), this.ukN.getTextSize()));
            } else if (!ai.oW(this.fky)) {
                this.ukN.setText(j.a(this, ai.oV(this.fky), this.ukN.getTextSize()));
            } else if (!ai.oW(this.guS.field_nickname)) {
                this.ukN.setText(j.a(this, ai.oV(this.guS.field_nickname), this.ukN.getTextSize()));
            } else if (ai.oW(this.ukP)) {
                boolean z;
                String str = this.guS.field_nickname;
                if (ai.oW(str) || str.length() > 50) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.ukN.setText(j.a(this, ai.oV(this.guS.BL()), this.ukN.getTextSize()));
                } else {
                    this.ukN.setText("");
                }
            } else {
                this.ukN.setText(j.a(this, ai.oV(this.ukP), this.ukN.getTextSize()));
            }
            this.ukN.setSelection(this.ukN.getText().length());
        }
        TextView textView;
        if (this.ukO == 0) {
            setMMTitle(R.l.contact_info_mod_remarkname);
            com.tencent.mm.plugin.account.friend.a.a pp = com.tencent.mm.plugin.account.b.getAddrUploadStg().pp(this.guS.field_username);
            if (!(pp == null || ai.oW(pp.Xj()) || pp.Xj().equals(this.ukN.getText()))) {
                this.uiO = (TextView) findViewById(R.h.mode_remark_mobile_name);
                this.uiP = findViewById(R.h.mod_remark_mobile_name_area);
                this.uiP.setVisibility(0);
                this.uiO.setText(ai.oV(getString(R.l.contact_info_set_reamrk_mobile_name, new Object[]{pp.Xj()})));
                k kVar = new k(getString(R.l.write_contact_remark));
                kVar.setSpan(new c(this, pp.Xj()), 0, kVar.length(), 17);
                this.uiO.append(" ");
                this.uiO.append(kVar);
                this.uiO.setMovementMethod(LinkMovementMethod.getInstance());
            }
        } else if (this.ukO == 3) {
            setMMTitle(R.l.tag_rename);
            this.ukN.setHint("");
            if (!ai.oW(this.ukP)) {
                this.ukN.setText(this.ukP);
            }
            textView = (TextView) findViewById(R.h.contact_info_mod_remark_name_hint_tv);
            textView.setText(R.l.set_tag_name);
            textView.setVisibility(0);
            findViewById(R.h.mod_remark_name_desc).setVisibility(8);
        } else if (this.ukO == 4) {
            setMMTitle(R.l.room_my_displayname);
            this.ukN.setHint("");
            textView = (TextView) findViewById(R.h.contact_info_mod_remark_name_hint_tv);
            textView.setText(R.l.room_self_nick_name_tip);
            textView.setVisibility(0);
        }
        addTextOptionMenu(0, getString(R.l.app_save), new 2(this));
        if (this.ukN == null || this.ukN.getText().toString().trim().length() <= 0) {
            enableOptionMenu(false);
        } else {
            enableOptionMenu(true);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ModRemarkNameUI.this.finish();
                return true;
            }
        });
        this.ukQ = (TextView) findViewById(R.h.contact_info_remark_desc_tv);
        this.ukR = (EditText) findViewById(R.h.contact_info_mod_remark_desc_et);
        this.ukS = (TextView) findViewById(R.h.wordcount);
        this.uiQ = findViewById(R.h.contact_info_mod_remark_desc_container);
        com.tencent.mm.ui.tools.a.c.d(this.ukR).Gi(800).a(null);
        this.ukS.setText(g.be(800, this.ukR.getEditableText().toString()));
        this.ukR.append(j.a(this, ai.oV(this.ukT), this.ukR.getTextSize()));
        this.ukQ.append(j.a(this, ai.oV(this.ukT), this.ukQ.getTextSize()));
        if (this.mkY != null) {
            this.ukR.setText(j.a(this, ai.oV(this.mkY.field_conDescription), this.ukR.getTextSize()));
            this.ukQ.setText(j.a(this, ai.oV(this.mkY.field_conDescription), this.ukR.getTextSize()));
        }
        this.ukR.addTextChangedListener(new b(this, (byte) 0));
        this.ukQ.setOnClickListener(new 4(this));
    }

    protected void onResume() {
        super.onResume();
        au.HU();
        this.mkY = c.FS().Hh(this.bWJ);
        if (this.mkY != null) {
            this.lVt = this.mkY.field_contactLabels;
            this.lUN = (ArrayList) com.tencent.mm.plugin.label.a.a.aYK().FB(this.lVt);
        }
        if (ai.oW(this.lVt)) {
            this.lYe.setVisibility(8);
            this.uiY.setVisibility(0);
            return;
        }
        this.lYe.setVisibility(0);
        this.uiY.setVisibility(8);
        if (this.lUN != null && !this.lUN.isEmpty()) {
            this.lYe.a(this.lUN, this.lUN);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() == 44) {
            if (i != 0 && i2 < 0) {
                x.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
                Toast.makeText(this, getString(R.l.room_save_to_group_card_fail, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            finish();
        }
    }
}
