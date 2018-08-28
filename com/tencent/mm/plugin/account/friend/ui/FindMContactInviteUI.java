package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.a$i;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactInviteUI extends MMWizardActivity {
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
    private a eLV = new 6(this);
    private String eLX = null;
    private e ehD = null;
    private TextView emptyTipTv = null;

    static /* synthetic */ void h(FindMContactInviteUI findMContactInviteUI) {
        findMContactInviteUI.YC();
        if (findMContactInviteUI.eLL.getSelectCount() == 0) {
            findMContactInviteUI.WL();
        } else {
            h.a((Context) findMContactInviteUI, findMContactInviteUI.getString(a$j.find_mcontact_invite_alert_content), "", new 12(findMContactInviteUI), new 2(findMContactInviteUI));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$j.find_mcontact_invite_title);
        com.tencent.mm.plugin.account.a.a.ezo.vo();
        this.eLX = getIntent().getStringExtra("regsetinfo_ticket");
        this.eLS = getIntent().getIntExtra("login_type", 0);
        this.eHr = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        initView();
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
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_400_QQ")).append(",1").toString());
        } else {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_400_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_400_phone")).append(",1").toString());
        }
        if (this.eLU) {
            x.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                Yd();
            }
        }
    }

    private void Yd() {
        Context context = this.mController.tml;
        getString(a$j.app_tip);
        this.eHw = h.a(context, getString(a$j.mobile_friend_loading), true, new 1(this));
        g.Em().a(new ah.a() {
            public final boolean Ks() {
                if (FindMContactInviteUI.this.eHw != null) {
                    FindMContactInviteUI.this.eHw.dismiss();
                    FindMContactInviteUI.this.eHw = null;
                }
                FindMContactInviteUI.this.eLL.notifyDataSetChanged();
                return false;
            }

            public final boolean Kr() {
                try {
                    FindMContactInviteUI.this.eLT = com.tencent.mm.pluginsdk.a.cz(FindMContactInviteUI.this);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FindMContactInviteUI", e, "", new Object[0]);
                }
                FindMContactInviteUI.this.eLL.eHv = FindMContactInviteUI.this.eLT;
                FindMContactInviteUI.this.eLL.p(((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
                return true;
            }

            public final String toString() {
                return super.toString() + "|listMFriendData";
            }
        });
    }

    public void onPause() {
        super.onPause();
        StringBuilder stringBuilder;
        if (this.eLS == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_400_QQ")).append(",2").toString());
            return;
        }
        stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_400_phone")).append(",2").toString());
    }

    public void onDestroy() {
        if (this.ehD != null) {
            g.DF().b(432, this.ehD);
            this.ehD = null;
        }
        if (this.eLL != null) {
            i iVar = this.eLL;
            if (iVar.eKg != null) {
                iVar.eKg.detach();
                iVar.eKg = null;
            }
        }
        ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).clearFriendData();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.find_mcontact_add;
    }

    protected final void initView() {
        this.emptyTipTv = (TextView) findViewById(f.mobile_friend_empty_msg_tip_tv);
        this.emptyTipTv.setText(a$j.mobile_friend_empty_qmsg_tip);
        this.eIM = (ListView) findViewById(f.mobile_friend_lv);
        if (this.eHr == 2 || this.eHr != 1) {
            this.eLM = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.account.a.g.find_mcontact_header, null);
            this.eLN = (TextView) this.eLM.findViewById(f.findmcontact_count);
            this.eLO = (TextView) this.eLM.findViewById(f.findmcontact_tip);
            this.eLP = (TextView) this.eLM.findViewById(f.find_mcontact_title);
            this.eLR = (Button) this.eLM.findViewById(f.find_mcontact_addall);
            this.eLO.setText(getString(a$j.find_mcontact_invite_your_friend));
            this.eLP.setText(getString(a$j.find_mcontact_invite_friend));
            this.eLR.setText(getString(a$j.find_mcontact_invite_all, new Object[]{Integer.valueOf(0)}));
            this.eLQ = (TextView) this.eLM.findViewById(f.mobile_all_unselect);
        } else {
            this.eLM = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.account.a.g.find_mcontact_header_style_two, null);
            this.eLN = (TextView) this.eLM.findViewById(f.findmcontact_count);
            this.eLO = (TextView) this.eLM.findViewById(f.findmcontact_tip);
            this.eLP = (TextView) this.eLM.findViewById(f.find_mcontact_title);
            this.eLR = (Button) this.eLM.findViewById(f.find_mcontact_addall);
            this.eLO.setText(getString(a$j.find_mcontact_invite_friend));
            this.eLP.setText(getString(a$j.find_mcontact_invite_friend));
            this.eLR.setText(getString(a$j.find_mcontact_invite_all_continue));
        }
        this.eLL = new i(this, this.eLV, 2);
        this.eLR.setOnClickListener(new 7(this));
        if (this.eLQ != null) {
            this.eLQ.setOnClickListener(new 8(this));
            this.eLQ.setVisibility(8);
        }
        this.eIM.addHeaderView(this.eLM);
        this.eIM.setAdapter(this.eLL);
        this.eIM.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        this.eIM.setOnTouchListener(new 9(this));
        addTextOptionMenu(0, getString(a$j.app_finish), new 10(this));
        11 11 = new 11(this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactInviteUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case a$i.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    Yd();
                    return;
                }
                this.eLU = false;
                h.a((Context) this, getString(a$j.permission_contacts_request_again_msg), getString(a$j.permission_tips_title), getString(a$j.jump_to_settings), getString(a$j.app_cancel), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FindMContactInviteUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        FindMContactInviteUI.this.eLU = true;
                        FindMContactInviteUI.this.finish();
                    }
                }, new 4(this));
                return;
            default:
                return;
        }
    }
}
