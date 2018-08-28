package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.ui.q.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.o;

public class InviteFacebookFriendsUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private ListView eIM;
    private View eIO;
    String eIQ;
    private final int eNa = 5;
    a eQA;

    static /* synthetic */ void c(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        x.e("MicroMsg.InviteFacebookFriendsUI", "dealWithRefreshTokenFail");
        inviteFacebookFriendsUI.aM(inviteFacebookFriendsUI.getString(q.e.app_tip), inviteFacebookFriendsUI.getString(q.e.facebook_friend_need_rebind));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(q.e.facebook_invitefriends_title);
        g.DF().a(32, this);
        initView();
    }

    protected void onDestroy() {
        g.DF().b(32, this);
        this.eQA.aYc();
        super.onDestroy();
    }

    protected final void initView() {
        this.eIM = (ListView) findViewById(b.mobile_friend_lv);
        final TextView textView = (TextView) findViewById(b.empty_msg_tip_tv);
        textView.setText(q.e.facebook_empty_friend_tip);
        o oVar = new o((byte) 0);
        oVar.uBw = new o.b() {
            public final boolean pj(String str) {
                return false;
            }

            public final void pk(String str) {
                InviteFacebookFriendsUI.this.eIQ = bi.oU(str);
                InviteFacebookFriendsUI inviteFacebookFriendsUI = InviteFacebookFriendsUI.this;
                if (inviteFacebookFriendsUI.eQA != null) {
                    a aVar = inviteFacebookFriendsUI.eQA;
                    aVar.eIs = bi.oU(inviteFacebookFriendsUI.eIQ.trim());
                    aVar.aYc();
                    aVar.WT();
                }
            }

            public final void WW() {
            }

            public final void WX() {
            }

            public final void WY() {
            }

            public final void WZ() {
            }
        };
        a(oVar);
        this.eQA = new a(this, new a() {
            public final void Xb() {
                if (!q.Hg()) {
                    return;
                }
                if (InviteFacebookFriendsUI.this.eQA.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }

            public final void Xa() {
            }
        });
        this.eIM.setAdapter(this.eQA);
        this.eIO = findViewById(b.mobile_friend_mobile_not_bind_ll);
        this.eIM.setOnItemClickListener(new 4(this));
        x.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + q.Hg());
        if (q.Hg()) {
            this.eIM.setVisibility(0);
            this.eIO.setVisibility(8);
            long c = bi.c((Long) g.Ei().DT().get(65831, null));
            String oV = bi.oV((String) g.Ei().DT().get(65830, null));
            if (bi.bH(c) > 86400000 && oV.length() > 0) {
                c cVar = new c("290293790992170");
                cVar.aaT(oV);
                new com.tencent.mm.plugin.account.model.g(cVar, new 5(this)).Yl();
            }
            final ab abVar = new ab();
            abVar.XO();
            final al alVar = new al(new 6(this, abVar), false);
            if (bi.f((Integer) g.Ei().DT().get(65829, null)) > 0) {
                g.Ei().DT().set(65829, Integer.valueOf(1));
                g.DF().a(abVar, 0);
            } else {
                alVar.J(5000, 5000);
            }
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(q.e.app_tip);
            this.eHw = h.a(actionBarActivity, getString(q.e.qq_friend_loading), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    alVar.SO();
                    g.DF().c(abVar);
                }
            });
        }
        setBackBtn(new 8(this));
        9 9 = new 9(this);
        addTextOptionMenu(0, getString(q.e.facebook_invitefriends_sendinvite), new 10(this));
        showOptionMenu(false);
    }

    private void aM(String str, String str2) {
        h.a(this, str2, str, new 2(this), null);
    }

    protected final int getLayoutId() {
        return q$c.fb_friend;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
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
                this.eQA.a(null, null);
            } else {
                Toast.makeText(this, q.e.mobile_friend_err, 0).show();
            }
        }
    }
}
