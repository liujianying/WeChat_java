package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;

public class SayHiEditUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private MMEditText uln;

    static /* synthetic */ String a(SayHiEditUI sayHiEditUI) {
        String trim = sayHiEditUI.uln.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(30, this);
        setMMTitle(R.l.nearby_friend_say_hi);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.say_hi;
    }

    public void onDestroy() {
        au.DF().b(30, this);
        super.onDestroy();
    }

    protected final void initView() {
        this.uln = (MMEditText) findViewById(R.h.say_hi_content);
        this.uln.addTextChangedListener(new a((byte) 0));
        c.d(this.uln).Gi(100).a(null);
        a(0, getString(R.l.app_send), new 1(this, getIntent().getStringExtra("Contact_User"), getIntent().getIntExtra("Contact_Scene", 18), getIntent().getStringExtra(a.ths)), b.tmX);
        setBackBtn(new 2(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        Object obj = 1;
        x.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            switch (i2) {
                case -34:
                case -24:
                    Toast.makeText(this, R.l.nearby_friend_say_hi_spam, 0).show();
                    break;
                case -22:
                    Toast.makeText(this, R.l.nearby_friend_say_hi_black_list, 0).show();
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj == null) {
                if (i == 0 && i2 == 0) {
                    h.bA(this, getString(R.l.confirm_dialog_sent));
                    finish();
                } else if (i == 4 && i2 == -24 && !ai.oW(str)) {
                    Toast.makeText(this, str, 1).show();
                } else if (i2 != -101 || ai.oW(str)) {
                    Toast.makeText(this, R.l.nearby_friend_say_hi_failed, 0).show();
                } else {
                    h.a(this, str, getString(R.l.app_tip), getString(R.l.app_ok), null);
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }
}
