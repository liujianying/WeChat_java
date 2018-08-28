package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.h;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAddUI extends MMWizardActivity {
    private String eHp = null;
    private String eHq = "";
    private int eHr = 2;
    private ProgressDialog eHw = null;
    private String eHy;
    private ListView eIM;
    private i eLL;
    private View eLM;
    private TextView eLN = null;
    private TextView eLO = null;
    private TextView eLP = null;
    private TextView eLQ = null;
    private Button eLR = null;
    private int eLS;
    private List<String[]> eLT;
    private boolean eLU = true;
    private a eLV = new a() {
        public final void notifyDataSetChanged() {
            if (FindMContactAddUI.this.eHr == 2 || FindMContactAddUI.this.eHr != 1) {
                FindMContactAddUI.this.eLR.setText(FindMContactAddUI.this.getString(j.find_mcontact_add_all, new Object[]{Integer.valueOf(FindMContactAddUI.this.eLL.getCount())}));
            } else {
                FindMContactAddUI.this.eLR.setText(FindMContactAddUI.this.getString(j.find_mcontact_add_all_continue));
            }
            if (FindMContactAddUI.this.eLL.Xx()) {
                if (!(FindMContactAddUI.this.eHr == 1 || FindMContactAddUI.this.eLR.getVisibility() != 0 || FindMContactAddUI.this.eLQ == null)) {
                    FindMContactAddUI.this.eLR.setVisibility(8);
                    FindMContactAddUI.this.eLQ.setVisibility(0);
                }
            } else if (!(FindMContactAddUI.this.eHr == 1 || FindMContactAddUI.this.eLR.getVisibility() != 8 || FindMContactAddUI.this.eLQ == null)) {
                FindMContactAddUI.this.eLR.setVisibility(0);
                FindMContactAddUI.this.eLQ.setVisibility(8);
            }
            if (FindMContactAddUI.this.eLL.getSelectCount() <= 0 || FindMContactAddUI.this.eHr == 1) {
                FindMContactAddUI.this.eLN.setText(FindMContactAddUI.this.getResources().getQuantityString(h.find_mcontact_wechat_friend, FindMContactAddUI.this.eLL.getCount(), new Object[]{Integer.valueOf(FindMContactAddUI.this.eLL.getCount())}));
                return;
            }
            FindMContactAddUI.this.eLN.setText(FindMContactAddUI.this.getResources().getQuantityString(h.find_mcontact_already_add_count, FindMContactAddUI.this.eLL.getSelectCount(), new Object[]{Integer.valueOf(FindMContactAddUI.this.eLL.getSelectCount())}));
        }
    };
    private e ehD = null;
    private TextView emptyTipTv = null;

    static /* synthetic */ void i(FindMContactAddUI findMContactAddUI) {
        findMContactAddUI.YC();
        if (findMContactAddUI.eLL.getSelectCount() == 0) {
            com.tencent.mm.ui.base.h.a(findMContactAddUI, findMContactAddUI.getString(j.find_mcontact_sure_add_none), "", findMContactAddUI.getString(j.find_mcontact_add_alert_add), findMContactAddUI.getString(j.find_mcontact_add_alert_skip), new 12(findMContactAddUI), new 13(findMContactAddUI));
            return;
        }
        o DF = g.DF();
        2 2 = new 2(findMContactAddUI);
        findMContactAddUI.ehD = 2;
        DF.a(30, 2);
        ActionBarActivity actionBarActivity = findMContactAddUI.mController.tml;
        findMContactAddUI.getString(j.app_tip);
        findMContactAddUI.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity, findMContactAddUI.getString(j.find_mcontact_invite_friend_processing), true, new 3(findMContactAddUI));
        i iVar = findMContactAddUI.eLL;
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (int i = 0; i < iVar.eKc.size(); i++) {
            if (iVar.eIr[i] == 1) {
                linkedList.add(((arf) iVar.eKc.get(i)).hbL);
                linkedList2.add(Integer.valueOf(52));
            }
        }
        g.DF().a(new m(2, linkedList, linkedList2, "", ""), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.find_mcontact_add_title);
        com.tencent.mm.plugin.account.a.a.ezo.vo();
        this.eHp = getIntent().getStringExtra("regsetinfo_ticket");
        this.eHq = getIntent().getStringExtra("regsetinfo_NextStep");
        this.eHr = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.eLS = getIntent().getIntExtra("login_type", 0);
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        initView();
    }

    private void Yd() {
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(j.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(j.mobile_friend_loading), true, new 1(this));
        g.Em().a(new 6(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        WL();
        return true;
    }

    private void WL() {
        com.tencent.mm.plugin.c.a.pU(this.eHy);
        YC();
        DT(1);
    }

    protected void onResume() {
        super.onResume();
        this.eLL.notifyDataSetChanged();
        StringBuilder stringBuilder;
        if (this.eLS == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_300_QQ")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("R300_300_QQ");
        } else {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_300_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_300_phone")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("R300_300_phone");
        }
        if (this.eLU) {
            x.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                Yd();
            }
        }
    }

    public void onPause() {
        super.onPause();
        StringBuilder stringBuilder;
        if (this.eLS == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_300_QQ")).append(",2").toString());
            return;
        }
        stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_300_phone")).append(",2").toString());
    }

    public void onDestroy() {
        if (this.ehD != null) {
            g.DF().b(30, this.ehD);
            this.ehD = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.find_mcontact_add;
    }

    protected final void initView() {
        this.emptyTipTv = (TextView) findViewById(f.mobile_friend_empty_msg_tip_tv);
        this.emptyTipTv.setText(j.mobile_friend_empty_qmsg_tip);
        this.eIM = (ListView) findViewById(f.mobile_friend_lv);
        if (this.eHr == 2 || this.eHr != 1) {
            this.eLM = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.account.a.g.find_mcontact_header, null);
            this.eLN = (TextView) this.eLM.findViewById(f.findmcontact_count);
            this.eLO = (TextView) this.eLM.findViewById(f.findmcontact_tip);
            this.eLP = (TextView) this.eLM.findViewById(f.find_mcontact_title);
            this.eLR = (Button) this.eLM.findViewById(f.find_mcontact_addall);
            this.eLO.setText(getString(j.find_mcontact_your_friend));
            this.eLP.setText(getString(j.find_mcontact_your_friend_title));
            this.eLR.setText(getString(j.find_mcontact_add_all, new Object[]{Integer.valueOf(0)}));
            this.eLQ = (TextView) this.eLM.findViewById(f.mobile_all_unselect);
        } else {
            this.eLM = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.account.a.g.find_mcontact_header_style_two, null);
            this.eLN = (TextView) this.eLM.findViewById(f.findmcontact_count);
            this.eLO = (TextView) this.eLM.findViewById(f.findmcontact_tip);
            this.eLP = (TextView) this.eLM.findViewById(f.find_mcontact_title);
            this.eLR = (Button) this.eLM.findViewById(f.find_mcontact_addall);
            this.eLO.setText(getString(j.find_mcontact_your_friend));
            this.eLP.setText(getString(j.find_mcontact_your_friend_title));
            this.eLR.setText(getString(j.find_mcontact_add_all_continue));
        }
        this.eLL = new i(this, this.eLV, 1);
        this.eLR.setOnClickListener(new 8(this));
        if (this.eLQ != null) {
            this.eLQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    FindMContactAddUI.this.eLR.setVisibility(0);
                    FindMContactAddUI.this.eLQ.setVisibility(8);
                    FindMContactAddUI.this.eLL.ci(false);
                    FindMContactAddUI.this.eLL.notifyDataSetChanged();
                }
            });
            this.eLQ.setVisibility(8);
        }
        this.eIM.addHeaderView(this.eLM);
        this.eIM.setAdapter(this.eLL);
        addTextOptionMenu(0, getString(j.app_nextstep), new 10(this));
        11 11 = new 11(this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactAddUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    Yd();
                    return;
                }
                this.eLU = false;
                com.tencent.mm.ui.base.h.a(this, getString(j.permission_contacts_request_again_msg), getString(j.permission_tips_title), getString(j.jump_to_settings), getString(j.app_cancel), false, new 4(this), new 5(this));
                return;
            default:
                return;
        }
    }
}
