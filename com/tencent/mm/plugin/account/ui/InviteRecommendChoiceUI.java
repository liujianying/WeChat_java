package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.a.k;
import com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class InviteRecommendChoiceUI extends MMPreference {
    private f eOE;

    protected final boolean Yy() {
        return false;
    }

    public final int Ys() {
        return k.invite_recommend_friend;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        Intent intent;
        if (str.equals("settings_invite_qq_friends")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(0));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mail")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(2));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mb")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(1));
            startActivity(intent);
        } else if (str.equals("settings_invite_mobile_friends")) {
            intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("sms_body", getString(j.invite_sms, new Object[]{g.Ei().DT().get(2, null)}));
            intent.setType("vnd.android-dir/mms-sms");
            if (bi.k(this, intent)) {
                startActivity(intent);
            } else {
                Toast.makeText(this, j.selectsmsapp_none, 1).show();
            }
        } else if (str.equals("settings_invite_facebook_friends")) {
            startActivity(new Intent(this, InviteFacebookFriendsUI.class));
        }
        return false;
    }

    protected final void initView() {
        setMMTitle(j.send_card_to_microblog);
        this.eOE = this.tCL;
        this.eOE.c((IconPreference) this.eOE.ZZ("settings_invite_facebook_friends"));
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_invite_qq_friends");
        if (q.GE() == 0) {
            this.eOE.c(iconPreference);
        }
        iconPreference = (IconPreference) this.eOE.ZZ("settings_recommend_by_mail");
        if (q.GE() == 0) {
            this.eOE.c(iconPreference);
        }
        iconPreference = (IconPreference) this.eOE.ZZ("settings_recommend_by_mb");
        if (((i) g.l(i.class)).FZ().Hg("@t.qq.com") == null) {
            this.eOE.c(iconPreference);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                InviteRecommendChoiceUI.this.YC();
                InviteRecommendChoiceUI.this.finish();
                return true;
            }
        });
    }
}
