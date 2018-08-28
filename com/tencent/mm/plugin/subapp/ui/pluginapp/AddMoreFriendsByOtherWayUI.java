package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddMoreFriendsByOtherWayUI extends MMPreference {
    private f eOE;

    public final int Ys() {
        return R.o.add_more_friends_by_other_way;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        if (((IconPreference) this.eOE.ZZ("find_friends_by_google_account")) != null) {
            if (((q.GQ() & 8388608) == 0 ? 1 : null) == null || !bi.fU(this)) {
                this.eOE.aaa("find_friends_by_google_account");
            }
        }
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 0;
        x.d("MicroMsg.AddMoreFriendsByOthersUI", "click %s", new Object[]{preference.mKey});
        Intent intent;
        if ("find_friends_by_mobile".equals(preference.mKey)) {
            if (l.XC() != l$a.SUCC) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.D(this, intent);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            return true;
        } else if (!"find_friends_by_google_account".equals(preference.mKey)) {
            return false;
        } else {
            if (!TextUtils.isEmpty((String) g.Ei().DT().get(208903, null))) {
                i = 1;
            }
            if (i == 0) {
                intent = new Intent(this, BindGoogleContactUI.class);
                intent.putExtra("enter_scene", 1);
                MMWizardActivity.D(this, intent);
                return true;
            }
            intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", 1);
            startActivity(intent);
            return true;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.add_more_friends_title);
        this.eOE = this.tCL;
        setBackBtn(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
