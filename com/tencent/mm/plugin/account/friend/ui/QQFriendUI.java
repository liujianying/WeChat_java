package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.a.f;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.o;

public class QQFriendUI extends MMActivity implements e {
    private int GG;
    private ProgressDialog eHw = null;
    private ListView eIM;
    String eIQ;
    private TextView eIR = null;
    d eMR;
    private o eMS;
    private boolean eMT = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(143, this);
        String stringExtra = getIntent().getStringExtra("qqgroup_name");
        this.GG = getIntent().getIntExtra("qqgroup_id", -1);
        ap apVar = (ap) ((a) g.n(a.class)).getQQListStg();
        int i = this.GG;
        x.d("MicroMsg.QQListStorage", "delete: GroupID:" + i);
        apVar.dCZ.fV("qqlist", "update qqlist set reserved4=0 where groupid=" + i);
        if (l.je(this.GG)) {
            ac acVar = new ac(this.GG);
            g.DF().a(acVar, 0);
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(j.app_tip);
            this.eHw = h.a(actionBarActivity, getString(j.qq_friend_loading), true, new 1(this, acVar));
        }
        setMMTitle(stringExtra);
        initView();
    }

    protected void onResume() {
        super.onResume();
        q.Kp().d(this.eMR);
        this.eMR.notifyDataSetChanged();
    }

    public void onDestroy() {
        f.iU("2");
        ((ap) ((a) g.n(a.class)).getQQListStg()).b(this.eMR);
        g.DF().b(143, this);
        this.eMR.aYc();
        q.KJ().cancel();
        super.onDestroy();
    }

    public void onPause() {
        q.Kp().e(this.eMR);
        super.onPause();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.qq_friend;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        x.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        byte b;
        this.eIM = (ListView) findViewById(com.tencent.mm.plugin.account.a.f.qq_friend_lv);
        this.eIR = (TextView) findViewById(com.tencent.mm.plugin.account.a.f.empty_qq_search_tip_tv);
        this.eIR.setText(j.qq_search_no_friend);
        this.eMS = new o((byte) 0);
        this.eMS.uBw = new 2(this);
        a(this.eMS);
        if (com.tencent.mm.model.a.g.IW().iP("2") != null) {
            String str = com.tencent.mm.model.a.g.IW().iP("2").value;
            if (str.equals("0")) {
                b = (byte) 0;
            } else if (str.equals("1")) {
                b = (byte) 1;
            } else {
                b = (byte) 1;
            }
            f.iT("2");
        } else {
            b = (byte) 1;
        }
        if (b == (byte) 0) {
            this.eMR = new e(this, this.GG);
        } else {
            this.eMR = new f(this, this.GG);
        }
        this.eMR.a(new 3(this));
        this.eIM.setAdapter(this.eMR);
        this.eIM.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.plugin.account.friend.a.j jVar = null;
                if (i >= QQFriendUI.this.eIM.getHeaderViewsCount()) {
                    x.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[]{Integer.valueOf(i - QQFriendUI.this.eIM.getHeaderViewsCount()), Integer.valueOf(QQFriendUI.this.eIM.getHeaderViewsCount())});
                    ao aoVar = (ao) QQFriendUI.this.eMR.getItem(r0);
                    Intent intent;
                    if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false)) {
                        mc mcVar = new mc();
                        mcVar.bWF.opType = 0;
                        mcVar.bWF.bWH = aoVar.eLw + "@qqim";
                        mcVar.bWF.bWI = aoVar.getDisplayName();
                        com.tencent.mm.sdk.b.a.sFg.m(mcVar);
                        if (mcVar.bWG.bJm) {
                            intent = new Intent();
                            intent.putExtra("Chat_User", aoVar.eLw + "@qqim");
                            intent.putExtra("key_need_send_video", false);
                            com.tencent.mm.plugin.account.a.a.ezn.e(intent, QQFriendUI.this);
                        }
                    } else if (aoVar.eLx == 1 || aoVar.eLx == 2) {
                        ab Yg = ((i) g.l(i.class)).FR().Yg(aoVar.getUsername());
                        if (Yg != null && Yg.ckW()) {
                            com.tencent.mm.plugin.report.service.h.mEJ.k(10298, aoVar.getUsername() + ",12");
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", aoVar.getUsername());
                        intent2.putExtra("Contact_Nick", aoVar.wO());
                        intent2.putExtra("Contact_Uin", aoVar.eLw);
                        intent2.putExtra("Contact_QQNick", aoVar.getDisplayName());
                        intent2.putExtra("Contact_Scene", 12);
                        intent2.putExtra("Contact_RemarkName", aoVar.XZ());
                        k kVar = (k) ((a) g.n(a.class)).getFrdExtStg();
                        Cursor b = kVar.dCZ.b("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bi.oU(aoVar.getUsername()) + "\"", null, 2);
                        if (b != null) {
                            com.tencent.mm.plugin.account.friend.a.j jVar2;
                            if (b.moveToFirst()) {
                                jVar2 = new com.tencent.mm.plugin.account.friend.a.j();
                                jVar2.username = b.getString(0);
                                jVar2.sex = b.getInt(1);
                                jVar2.csJ = b.getInt(2);
                                jVar2.csK = b.getString(3);
                                jVar2.csL = b.getString(4);
                                jVar2.signature = b.getString(5);
                            } else {
                                jVar2 = null;
                            }
                            b.close();
                            jVar = jVar2;
                        }
                        if (jVar != null) {
                            intent2.putExtra("Contact_Sex", jVar.sex);
                        }
                        intent2.putExtra("Contact_ShowUserName", false);
                        if (bi.oW(aoVar.getUsername())) {
                            x.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[]{aoVar.toString()});
                            return;
                        }
                        com.tencent.mm.plugin.account.a.a.ezn.d(intent2, QQFriendUI.this);
                    } else if (aoVar.eLx == 0) {
                        intent = new Intent(QQFriendUI.this, InviteFriendUI.class);
                        intent.putExtra("friend_type", 0);
                        intent.putExtra("friend_user_name", aoVar.getUsername());
                        intent.putExtra("friend_num", aoVar.eLw);
                        intent.putExtra("friend_nick", aoVar.getDisplayName());
                        intent.putExtra("friend_weixin_nick", aoVar.wO());
                        intent.putExtra("friend_scene", 12);
                        QQFriendUI.this.startActivity(intent);
                    }
                }
            }
        });
        ((ap) ((a) g.n(a.class)).getQQListStg()).a(this.eMR);
        setBackBtn(new 5(this));
        6 6 = new 6(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        x.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((agu) ((ac) lVar).diG.dID.dIL).jRb == 1) {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (i == 0 && i2 == 0) {
                this.eMR.WT();
            } else {
                Toast.makeText(this, j.qq_friend_load_err, 0).show();
            }
        }
    }
}
