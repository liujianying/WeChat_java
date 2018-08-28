package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.ui.MMActivity;

public class SnsSettingIntroduceUI extends MMActivity {
    private Button oaP;
    private Button oaQ;
    private Intent oaR;

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        this.mController.hideTitleView();
        this.oaR = getIntent();
        this.oaP = (Button) findViewById(f.back_btn);
        this.oaP.setOnClickListener(new 1(this));
        h.mEJ.h(14090, new Object[]{Integer.valueOf(1)});
        this.oaQ = (Button) findViewById(f.go_btn);
        this.oaQ.setOnClickListener(new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        h.mEJ.h(14090, new Object[]{Integer.valueOf(3)});
        return true;
    }

    protected final int getLayoutId() {
        return g.sns_setting_introduce_ui;
    }
}
