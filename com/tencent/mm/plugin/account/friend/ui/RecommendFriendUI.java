package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private b eMW;
    private ListView eMX;
    private TextView eMY;
    private LinkedList<avz> eMZ = new LinkedList();
    private LinkedList<xp> eMb = new LinkedList();
    private boolean eMc;
    private int eNa = -1;
    private boolean eNb = false;

    static /* synthetic */ void c(RecommendFriendUI recommendFriendUI) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < recommendFriendUI.eMW.Ye().length) {
                anw anw = new anw();
                anw.hbL = bi.oV(recommendFriendUI.eMW.Ye()[i2]);
                anw.rQA = recommendFriendUI.eNa;
                ((i) g.l(i.class)).FQ().b(new a(22, anw));
                p pVar = new p();
                pVar.username = recommendFriendUI.eMW.Ye()[i2];
                pVar.eKy = recommendFriendUI.eNa;
                pVar.dLB = (int) bi.VE();
                ((q) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getInviteFriendOpenStg()).a(pVar);
                i = i2 + 1;
            } else {
                h.a(recommendFriendUI.mController.tml, j.inviteqqfriends_invite_success, j.app_tip, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RecommendFriendUI.this.finish();
                    }
                });
                return;
            }
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.inviteqqfriends;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eNa = bi.getInt(getIntent().getStringExtra("recommend_type"), 0);
        this.eMc = false;
        g.DF().a(135, this);
        initView();
    }

    protected final void initView() {
        this.eMY = (TextView) findViewById(f.empty_tip_tv);
        if (this.eNa == 1) {
            setMMTitle(j.settings_recommend_by_mb);
            this.eMY.setText(j.settings_recommend_no_mb_contact);
        } else if (this.eNa == 2) {
            setMMTitle(j.settings_recommend_by_mail);
            this.eMY.setText(j.settings_recommend_no_mail_contact);
        } else {
            setMMTitle(j.settings_invite_qq_friends);
            this.eMY.setText(j.settings_recommend_no_qq_contact);
        }
        this.eMW = new b(getLayoutInflater());
        this.eMX = (ListView) findViewById(f.inviteqqfriends_friend_lv);
        this.eMX.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 0;
                if (RecommendFriendUI.this.eMc) {
                    RecommendFriendUI recommendFriendUI = RecommendFriendUI.this;
                    b b = RecommendFriendUI.this.eMW;
                    if (b.eMc) {
                        i2 = ((xp) b.eMb.get(i)).rxW;
                    }
                    recommendFriendUI.ji(i2);
                    return;
                }
                RecommendFriendUI.this.eMW.jh(i);
                if (RecommendFriendUI.this.eMW.Ye().length > 0) {
                    RecommendFriendUI.this.showOptionMenu(true);
                } else {
                    RecommendFriendUI.this.showOptionMenu(false);
                }
            }
        });
        this.eMX.setAdapter(this.eMW);
        addTextOptionMenu(0, getString(j.inviteqqfriends_invite), new 2(this));
        showOptionMenu(false);
        this.eNb = true;
        aa aaVar = new aa(this.eNa);
        g.DF().a(aaVar, 0);
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(j.app_tip);
        this.eHw = h.a(actionBarActivity, getString(j.inviteqqfriends_loading_friends_info), true, new 5(this, aaVar));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RecommendFriendUI.this.goBack();
                return true;
            }
        });
        4 4 = new 4(this);
    }

    private void goBack() {
        if (this.eNa != 0) {
            finish();
        } else if (this.eMc || this.eNb) {
            finish();
        } else {
            Yg();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        g.DF().b(135, this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (i == 0 && i2 == 0 && lVar.getType() == 135) {
            this.eMZ = ((avw) ((aa) lVar).diG.dIE.dIL).jTa;
            this.eMb = ((avw) ((aa) lVar).diG.dIE.dIL).rcM;
            this.eNb = false;
            if (this.eMZ.size() <= 0) {
                Yf();
                return;
            } else if (this.eNa == 0 && this.eMb.size() <= 0) {
                Yf();
                return;
            } else if (this.eNa != 0) {
                ji(-1);
                return;
            } else {
                Yg();
                return;
            }
        }
        Yf();
    }

    private void Yf() {
        this.eMY.setVisibility(0);
        this.eMX.setVisibility(8);
    }

    private void ji(int i) {
        x.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.eMZ.size());
        this.eMW.a(this.eMZ, i);
        this.eMX.setAdapter(this.eMW);
        this.eMc = false;
        if (this.eNa == 0) {
            String str = "";
            int i2 = 0;
            while (i2 < this.eMb.size()) {
                String str2;
                if (i == ((xp) this.eMb.get(i2)).rxW) {
                    str2 = ((xp) this.eMb.get(i2)).rDt;
                } else {
                    str2 = str;
                }
                i2++;
                str = str2;
            }
            setMMTitle(str);
        }
        this.eMW.eMc = this.eMc;
        this.eMW.notifyDataSetChanged();
    }

    private void Yg() {
        Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", this.eNa == 0);
        x.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.eMb.size());
        this.eMW.eMb = this.eMb;
        this.eMX.setAdapter(this.eMW);
        showOptionMenu(false);
        this.eMc = true;
        setMMTitle(j.settings_invite_qq_friends);
        this.eMW.eMc = this.eMc;
        this.eMW.notifyDataSetChanged();
    }
}
