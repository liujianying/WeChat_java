package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.bp.a;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public class InviteFriendUI extends MMActivity implements c {
    private ImageView eKk;
    private String eMl;
    private int eMm;
    private String eMn;
    private String eMo;
    private String eMp;
    private Button eMq;
    private int eMr;
    private int eMs;
    private String eMt = null;
    private String eMu = null;

    static /* synthetic */ void c(InviteFriendUI inviteFriendUI) {
        if (inviteFriendUI.eMr > 0 && inviteFriendUI.eMs > 0) {
            h.mEJ.h(10991, new Object[]{Integer.valueOf(inviteFriendUI.eMr), Integer.valueOf(7), Integer.valueOf(inviteFriendUI.eMs)});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$j.invite_friend_title);
        Intent intent = getIntent();
        this.eMm = intent.getIntExtra("friend_type", -1);
        this.eMn = intent.getStringExtra("friend_nick");
        this.eMl = intent.getStringExtra("friend_num");
        this.eMo = intent.getStringExtra("friend_googleID");
        this.eMp = intent.getStringExtra("friend_googleItemID");
        this.eMl = bi.oV(this.eMl);
        this.eMt = intent.getStringExtra("friend_linkedInID");
        this.eMu = intent.getStringExtra("friend_linkedInPicUrl");
        initView();
        this.eMr = intent.getIntExtra("search_kvstat_scene", 0);
        this.eMs = intent.getIntExtra("search_kvstat_position", 0);
    }

    protected void onPause() {
        super.onPause();
        q.Kp().e(this);
    }

    protected void onResume() {
        super.onResume();
        q.Kp().d(this);
    }

    protected final int getLayoutId() {
        return g.invite_friend;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        Bitmap b;
        this.eKk = (ImageView) findViewById(f.invite_friend_avatar_iv);
        TextView textView = (TextView) findViewById(f.invite_friend_nickname_tv);
        TextView textView2 = (TextView) findViewById(f.invite_friend_num_tv);
        TextView textView3 = (TextView) findViewById(f.invite_friend_not_reg);
        this.eMq = (Button) findViewById(f.invite_friend_invite_btn);
        Button button = (Button) findViewById(f.invite_friend_send_qq_message);
        textView.setText(this.eMn);
        textView3.setText(getString(a$j.invite_friend_not_reg, new Object[]{this.eMn}));
        if (this.eMm == 1) {
            this.eKk.setBackgroundDrawable(a.f(this, i.default_mobile_avatar));
            textView2.setText(getString(a$j.app_field_mobile) + this.eMl);
            String u = com.tencent.mm.a.g.u(this.eMl.getBytes());
            if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                com.tencent.mm.plugin.account.friend.a.a pq = ((b) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pq(u);
                b = pq != null ? l.b(pq.Xi(), this) : null;
            } else {
                b = q.Kp().bJ(ad.getContext());
            }
            if (b != null) {
                this.eKk.setImageBitmap(b);
            } else {
                this.eKk.setImageDrawable(a.f(this, i.default_mobile_avatar));
            }
        }
        if (this.eMm == 0) {
            this.eKk.setBackgroundDrawable(a.f(this, i.default_qq_avatar));
            textView2.setText(getString(a$j.app_field_qquin) + this.eMl);
            long cx = (long) o.cx(this.eMl);
            if (cx != 0) {
                b = com.tencent.mm.aa.c.aY(cx);
            } else {
                b = null;
            }
            if (b == null) {
                this.eKk.setImageDrawable(a.f(this, i.default_qq_avatar));
            } else {
                this.eKk.setImageBitmap(b);
            }
            button.setVisibility(0);
        }
        if (this.eMm == 2) {
            Bitmap jF;
            this.eMq.setText(a$j.gcontact_send_invite);
            this.eKk.setBackgroundDrawable(a.f(this, e.default_google_avatar));
            textView2.setText(getString(a$j.app_field_email) + this.eMl);
            if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                jF = com.tencent.mm.aa.c.jF(this.eMo);
            } else {
                jF = q.Kp().bJ(ad.getContext());
            }
            if (jF != null) {
                this.eKk.setImageBitmap(jF);
            } else {
                this.eKk.setImageDrawable(a.f(this, e.default_google_avatar));
            }
            if (TextUtils.isEmpty(this.eMn)) {
                textView.setText(bi.Xe(this.eMl));
                textView3.setText(getString(a$j.invite_friend_not_reg, new Object[]{bi.Xe(this.eMl)}));
            }
        }
        if (this.eMm == 3) {
            this.eMq.setText(a$j.invite_friend_linkedin_invite);
            Bitmap a = y.a(new d(this.eMu, this.eMu));
            if (a != null) {
                this.eKk.setImageBitmap(a);
            } else {
                this.eKk.setImageResource(i.default_avatar);
            }
            button.setVisibility(8);
        }
        this.eMq.setOnClickListener(new 1(this));
        button.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
    }

    public final void jX(String str) {
        if (this.eMl != null && !this.eMl.equals("")) {
            long jK = com.tencent.mm.aa.c.jK(str);
            if (jK > 0 && this.eMl.equals(String.valueOf(jK)) && this.eMm == 0) {
                this.eKk.setImageBitmap(com.tencent.mm.aa.c.a(str, false, -1));
            }
        }
    }
}
