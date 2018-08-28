package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.ui.q.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.o;

@Deprecated
public class FacebookFriendUI extends MMActivity implements c, e {
    private ProgressDialog eHw = null;
    private ListView eIM;
    private View eIO;
    String eIQ;
    private TextView eIR = null;
    private boolean eMT = false;
    d eQl;

    static /* synthetic */ void f(FacebookFriendUI facebookFriendUI) {
        x.e("MicroMsg.FacebookFriendUI", "dealWithRefreshTokenFail");
        facebookFriendUI.aM(facebookFriendUI.getString(q.e.app_tip), facebookFriendUI.getString(q.e.facebook_friend_need_rebind));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(q.e.find_friends_by_facebook);
        g.DF().a(32, this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        q.Kp().d(this);
        this.eQl.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
        q.Kp().e(this);
    }

    public void onDestroy() {
        g.DF().b(32, this);
        this.eQl.aYc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return q$c.fb_friend;
    }

    protected final void initView() {
        this.eIM = (ListView) findViewById(b.mobile_friend_lv);
        this.eIR = (TextView) findViewById(b.empty_facebook_friend_search_tip_tv);
        this.eIR.setText(q.e.facebook_friend_search_no_friend);
        TextView textView = (TextView) findViewById(b.empty_msg_tip_tv);
        textView.setText(q.e.facebook_empty_friend_tip);
        o oVar = new o((byte) 0);
        oVar.uBw = new 1(this);
        a(oVar);
        this.eQl = new d(this, new 5(this, textView));
        this.eQl.eQh = new 6(this);
        this.eIM.setAdapter(this.eQl);
        this.eIO = findViewById(b.mobile_friend_mobile_not_bind_ll);
        this.eIM.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.plugin.account.friend.a.g gVar = (com.tencent.mm.plugin.account.friend.a.g) FacebookFriendUI.this.eQl.getItem(i - FacebookFriendUI.this.eIM.getHeaderViewsCount());
                if (gVar.status == 100 || gVar.status == 101) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", gVar.getUsername());
                    intent.putExtra("Contact_Nick", gVar.Xm());
                    intent.putExtra("Contact_KFacebookId", gVar.csC);
                    intent.putExtra("Contact_KFacebookName", gVar.Xv());
                    intent.putExtra("Contact_Scene", 31);
                    a.ezn.d(intent, FacebookFriendUI.this);
                }
                if (gVar.status != 102) {
                }
            }
        });
        x.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + com.tencent.mm.model.q.Hg());
        if (com.tencent.mm.model.q.Hg()) {
            this.eIM.setVisibility(0);
            this.eIO.setVisibility(8);
            long c = bi.c((Long) g.Ei().DT().get(65831, null));
            String oV = bi.oV((String) g.Ei().DT().get(65830, null));
            if (bi.bH(c) > 86400000 && oV.length() > 0) {
                com.tencent.mm.ui.f.a.c cVar = new com.tencent.mm.ui.f.a.c("290293790992170");
                cVar.aaT(oV);
                new com.tencent.mm.plugin.account.model.g(cVar, new 8(this)).Yl();
            }
            ab abVar = new ab();
            abVar.XO();
            al alVar = new al(new 9(this, abVar), false);
            if (bi.f((Integer) g.Ei().DT().get(65829, null)) > 0) {
                g.Ei().DT().set(65829, Integer.valueOf(1));
                g.DF().a(abVar, 0);
            } else {
                alVar.J(5000, 5000);
            }
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(q.e.app_tip);
            this.eHw = h.a(actionBarActivity, getString(q.e.qq_friend_loading), true, new 10(this, alVar, abVar));
            addTextOptionMenu(0, getString(q.e.find_friends_by_facebook_invite), new 11(this));
        } else {
            this.eIM.setVisibility(8);
            this.eIO.setVisibility(0);
            ((TextView) findViewById(b.mobile_friend_mobile_not_bind_tv)).setText(q.e.fb_friend_not_bind);
            this.eIO.setOnClickListener(new 12(this));
        }
        setBackBtn(new 2(this));
        3 3 = new 3(this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() == 32) {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (i == 4 && i2 == -68) {
                if (bi.oW(str)) {
                    str = "error";
                }
                aM(getString(q.e.app_tip), str);
            } else if (i == 0 && i2 == 0) {
                this.eQl.a(null, null);
            } else {
                Toast.makeText(this, q.e.mobile_friend_err, 0).show();
            }
        }
    }

    private void aM(String str, String str2) {
        h.a(this, str2, str, new 4(this), null);
    }

    public final void jX(String str) {
        this.eQl.notifyDataSetChanged();
    }
}
