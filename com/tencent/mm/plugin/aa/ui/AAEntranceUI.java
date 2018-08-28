package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class AAEntranceUI extends MMActivity {
    private Button eBJ;
    private TextView eBK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.launch_aa_title);
        this.eBJ = (Button) findViewById(a$f.launch_btn);
        this.eBK = (TextView) findViewById(a$f.check_aa_record_tv);
        this.eBJ.setOnClickListener(new 1(this));
        this.eBK.setClickable(true);
        this.eBK.setOnTouchListener(new m(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(i.check_aa_record));
        spannableStringBuilder.setSpan(new a(new 2(this)), 0, spannableStringBuilder.length(), 18);
        this.eBK.setText(spannableStringBuilder);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AAEntranceUI.this.finish();
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return a$g.aa_entrance_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                x.i("MicroMsg.AAEntranceUI", "select chatroom：%s", new Object[]{stringExtra});
                if (!bi.oW(stringExtra)) {
                    Intent intent2 = new Intent(this.mController.tml, LaunchAAUI.class);
                    intent2.putExtra("enter_scene", 2);
                    intent2.putExtra("chatroom_name", stringExtra);
                    startActivity(intent2);
                }
            }
            super.onActivityResult(i, i2, intent);
        }
    }
}
