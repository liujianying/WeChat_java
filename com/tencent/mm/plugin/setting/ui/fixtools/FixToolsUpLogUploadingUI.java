package com.tencent.mm.plugin.setting.ui.fixtools;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.a$a;
import com.tencent.mm.plugin.setting.model.a.1;
import com.tencent.mm.plugin.setting.model.a.2;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FixToolsUpLogUploadingUI extends MMWizardActivity {
    private Button joh;
    public a$a mOG = new 3(this);
    private TextView mPo;
    private ImageView mPp;
    protected ProgressBar mPq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            setMMTitle(i.fix_tools_uplog);
            this.mPo = (TextView) findViewById(f.fix_tools_uplog_uploading);
            this.mPp = (ImageView) findViewById(f.fix_tools_uplog_logo);
            this.joh = (Button) findViewById(f.fix_tools_uplog_finish);
            this.mPq = (ProgressBar) findViewById(f.fix_tools_uplog_progress);
            this.mPp.setImageResource(h.fix_tools_uplog);
            this.mPo.setText(i.fix_tools_uplog_uploading);
            this.joh.setOnClickListener(new 1(this));
            setBackBtn(new 2(this));
            this.mPq.setVisibility(0);
            this.joh.setVisibility(8);
            String stringExtra = getIntent().getStringExtra("date");
            com.tencent.mm.plugin.setting.model.a btq = com.tencent.mm.plugin.setting.model.a.btq();
            com.tencent.mm.plugin.setting.model.a.mOG = this.mOG;
            x.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", new Object[]{stringExtra, Boolean.valueOf(btq.egv)});
            if (!btq.egv) {
                btq.egv = true;
                String str = "weixin";
                if (g.Eg().Dx()) {
                    str = q.GF();
                }
                x.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", new Object[]{Long.valueOf(com.tencent.mm.plugin.setting.model.a.wy(new StringBuffer(stringExtra).append("000000").toString())), Integer.valueOf((int) ((((((bi.VF() / 86400000) * 86400000) + 57600000) - 1) - com.tencent.mm.plugin.setting.model.a.wy(new StringBuffer(stringExtra).append("000000").toString())) / 86400000))});
                g.DF().a(new bg(new 1(btq, str, r1)), 0);
                b.a(new 2(btq));
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DT(1);
        return true;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.setting.a.g.fix_tools_uplog_uploading;
    }
}
