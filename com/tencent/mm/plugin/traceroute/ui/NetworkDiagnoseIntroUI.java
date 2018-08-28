package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

public class NetworkDiagnoseIntroUI extends MMActivity {
    private Button oDO;
    private TextView oDP;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.oDO = (Button) findViewById(R.h.start_diagnose);
        this.oDO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                au.HU();
                if (!c.isSDCardAvailable()) {
                    s.gH(NetworkDiagnoseIntroUI.this);
                } else if (au.DF().Lg() == 0) {
                    Toast.makeText(NetworkDiagnoseIntroUI.this, NetworkDiagnoseIntroUI.this.getString(R.l.fmt_iap_err), 0).show();
                } else {
                    NetworkDiagnoseIntroUI.this.startActivity(new Intent(NetworkDiagnoseIntroUI.this, NetworkDiagnoseUI.class));
                    NetworkDiagnoseIntroUI.this.finish();
                }
            }
        });
        this.oDP = (TextView) findViewById(R.h.net_diagnose_privacy_intro);
        this.oDP.setOnClickListener(new 2(this));
        setMMTitle("");
        setBackBtn(new 3(this));
    }

    protected final int getLayoutId() {
        return R.i.network_diagnose_ready;
    }
}
