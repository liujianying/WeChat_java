package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI extends MMPreference {
    private f eOE;
    private String kCs;
    private boolean mgR;
    private String name;

    public final int Ys() {
        return R.o.mail_receiver_info;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.name = getIntent().getStringExtra("name");
        this.kCs = getIntent().getStringExtra("addr");
        this.mgR = getIntent().getBooleanExtra("can_compose", false);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.invite_friend_title);
        this.eOE = this.tCL;
        ((KeyValuePreference) this.eOE.ZZ("mail_receiver_info_name")).setSummary(this.name);
        ((KeyValuePreference) this.eOE.ZZ("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
        Preference ZZ = this.eOE.ZZ("mail_compose_btn");
        if (!this.mgR) {
            this.eOE.c(ZZ);
        }
        setBackBtn(new 1(this));
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.mKey.equals("mail_compose_btn")) {
            Intent intent = new Intent(this, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{this.name + " " + this.kCs});
            startActivity(intent);
            finish();
        }
        return false;
    }
}
