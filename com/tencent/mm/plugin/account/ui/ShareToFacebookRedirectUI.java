package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.widget.a.e$a;

@a(3)
public class ShareToFacebookRedirectUI extends MMActivity implements e {
    private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
    private String eXa;
    private String eXb;
    private String eXc;
    private String eXd;
    private p eXe;

    static /* synthetic */ void a(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        x.e(TAG, "dealWithRefreshTokenFail");
        shareToFacebookRedirectUI.aM(shareToFacebookRedirectUI.mController.tml.getString(q$e.app_tip), shareToFacebookRedirectUI.mController.tml.getString(q$e.facebook_friend_need_rebind));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(433, this);
        this.eXa = getIntent().getStringExtra("title");
        this.eXb = getIntent().getStringExtra("digest");
        this.eXc = getIntent().getStringExtra("img");
        this.eXd = getIntent().getStringExtra("link");
        x.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[]{this.eXa, this.eXb, this.eXc, this.eXd});
        if (q.Hg()) {
            Zp();
            YP();
            return;
        }
        Intent intent = new Intent(this, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        startActivityForResult(intent, 0);
    }

    protected void onDestroy() {
        g.DF().b(433, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i(TAG, "type:%d, code:%d, msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        YC();
        this.eXe.dismiss();
        if (i == 4 && i2 == -68) {
            if (bi.oW(str)) {
                str = "error";
            }
            aM(getString(q$e.app_tip), str);
        } else if (i == 0 && i2 == 0) {
            String string = getString(q$e.share_ok);
            1 1 = new 1(this);
            h.bA(this, string);
            finish();
        } else {
            h.a(this.mController.tml, "err(" + i2 + "," + i + ")", getString(q$e.app_tip), new 2(this), null);
        }
    }

    private void Zp() {
        x.i(TAG, "refreshFacebookToken");
        long c = bi.c((Long) g.Ei().DT().get(65831, null));
        String oV = bi.oV((String) g.Ei().DT().get(65830, null));
        if (bi.bH(c) <= 86400000 || oV.length() <= 0) {
            YP();
            return;
        }
        c cVar = new c("290293790992170");
        cVar.aaT(oV);
        new com.tencent.mm.plugin.account.model.g(cVar, new 3(this)).Yl();
    }

    private void YP() {
        x.i(TAG, "doSend");
        e$a e_a = new e$a(this);
        e$a abz = e_a.abz(this.eXa);
        abz.qIF.abv(this.eXc);
        CharSequence charSequence = this.eXb;
        int fromDPToPix = ap.fromDPToPix(abz.mContext, (int) (14.0f * ap.fe(abz.mContext)));
        if (charSequence != null && charSequence.length() > 0) {
            abz.qIF.S((SpannableString) b.c(charSequence.toString(), fromDPToPix));
        }
        abz.qIF.S(charSequence);
        abz.qIF.abw(getString(q$e.app_comment));
        abz.Gv(q$e.app_share).a(new 4(this, e_a)).eIW.show();
    }

    private void aM(String str, String str2) {
        h.a(this.mController.tml, str2, str, new 5(this), null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i == 0 && i2 == -1 && intent != null) {
            x.i(TAG, "bind facebooksucc %b", new Object[]{Boolean.valueOf(intent.getBooleanExtra("bind_facebook_succ", false))});
            if (intent.getBooleanExtra("bind_facebook_succ", false)) {
                Zp();
                YP();
                return;
            }
        }
        finish();
    }
}
