package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.MMActivity;

public class ShowNonWeixinFriendUI extends MMActivity implements c {
    private long eXi = 0;
    private String eXj = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.invite_friend_title);
        this.eXi = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.eXj = getIntent().getStringExtra("Contact_KFacebookName");
        initView();
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
        return g.facebookapp_show_non_weixin_friend;
    }

    protected final void initView() {
        ImageView imageView = (ImageView) findViewById(f.invite_friend_avatar_iv);
        TextView textView = (TextView) findViewById(f.invite_friend_nickname_tv);
        TextView textView2 = (TextView) findViewById(f.invite_friend_not_reg);
        imageView.setBackgroundDrawable(a.f(this, i.default_mobile_avatar));
        imageView.setImageBitmap(com.tencent.mm.aa.c.jI(this.eXi));
        textView.setText(this.eXj);
        textView2.setText(getString(j.invite_friend_not_reg, new Object[]{this.eXj}));
        setBackBtn(new 1(this));
        ((Button) findViewById(f.invite_friend_invite_btn)).setOnClickListener(new 2(this));
    }

    public final void jX(String str) {
        initView();
    }
}
