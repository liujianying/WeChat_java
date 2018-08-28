package com.tencent.mm.plugin.soter.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.d.a.c.h;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.b;
import com.tencent.mm.ui.MMActivity;

public class SoterTestUI extends MMActivity {
    private Button onM = null;
    private Button onN = null;
    private Button onO = null;
    private Button onP = null;
    private Button onQ = null;
    private Button onR = null;
    private Button onS = null;
    private Button onT = null;
    private Button onU = null;
    private TextView onV = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.onM = (Button) findViewById(a.soter_test_support_soter);
        this.onN = (Button) findViewById(a.soter_test_gen_ask);
        this.onO = (Button) findViewById(a.soter_test_remove_ask);
        this.onP = (Button) findViewById(a.soter_test_get_ask_pub);
        this.onQ = (Button) findViewById(a.soter_test_gen_ak);
        this.onR = (Button) findViewById(a.soter_test_remove_ak);
        this.onS = (Button) findViewById(a.soter_test_get_ak_pub);
        this.onT = (Button) findViewById(a.soter_test_do_sign);
        this.onU = (Button) findViewById(a.soter_test_decrypt_import);
        this.onV = (TextView) findViewById(a.result_tv);
        this.onM.setOnClickListener(new 1(this));
        this.onN.setOnClickListener(new 2(this));
        this.onO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SoterTestUI.this.onV.setText(com.tencent.d.a.a.cFB().isSuccess() ? "passed" : "not passed");
            }
        });
        this.onP.setOnClickListener(new 4(this));
        this.onQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SoterTestUI.this.onV.setText(com.tencent.d.a.a.acy("sample_auth_key_name").isSuccess() ? "pass" : "not passed");
            }
        });
        this.onR.setOnClickListener(new 6(this));
        this.onS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h acB = com.tencent.d.a.a.acB("sample_auth_key_name");
                if (acB == null) {
                    SoterTestUI.this.onV.setText("not passed: no certificate");
                } else {
                    SoterTestUI.this.onV.setText("model available: " + acB.toString());
                }
            }
        });
        this.onT.setOnClickListener(new 8(this));
    }

    protected final int getLayoutId() {
        return b.soter_test_ui;
    }
}
