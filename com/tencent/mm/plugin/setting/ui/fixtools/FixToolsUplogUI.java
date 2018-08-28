package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class FixToolsUplogUI extends MMWizardActivity {
    private static String mPv;
    private SimpleDateFormat gVk = new SimpleDateFormat("yyyyMMdd");
    private Button mPs;
    private LinearLayout mPt;
    private TextView mPu;
    private SimpleDateFormat mPw = new SimpleDateFormat("yyyy.MM.dd");

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            h.mEJ.a(873, (long) getIntent().getIntExtra("entry_fix_tools_uplog", 5), 1, false);
            h.mEJ.a(873, 8, 1, false);
            initView();
        }
    }

    protected final int getLayoutId() {
        return g.fix_tools_uplog;
    }

    protected Dialog onCreateDialog(int i) {
        Calendar instance = Calendar.getInstance();
        long VF = bi.VF();
        instance.setTimeInMillis(VF);
        long j = (((VF / 86400000) * 86400000) + 57600000) - 1;
        long j2 = (((VF / 86400000) * 86400000) + 57600000) - 864000000;
        d dVar = new d(this.mController.tml, new 1(this, i, j), instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), (byte) 0);
        dVar.setCanceledOnTouchOutside(false);
        dVar.gP(j);
        dVar.gQ(j2 > 0 ? j2 : 0);
        return dVar;
    }

    protected final void initView() {
        setMMTitle(i.fix_tools_uplog);
        this.mPs = (Button) findViewById(f.fix_tools_uplog_upload);
        this.mPt = (LinearLayout) findViewById(f.choose_time);
        this.mPu = (TextView) findViewById(f.fix_tools_log_time);
        this.mPu.setText(this.mPw.format(new Date()));
        mPv = this.gVk.format(new Date());
        this.mPs.setOnClickListener(new 2(this));
        this.mPt.setOnClickListener(new 3(this));
        setBackBtn(new 4(this));
    }
}
