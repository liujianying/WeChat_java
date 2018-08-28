package com.tencent.mm.plugin.traceroute.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class NetworkDiagnoseReportUI extends MMActivity {
    private static String oDd;
    private boolean oDR = false;
    private Button oDS;
    private Button oDT;
    private ImageView oDU;
    private TextView oDV;
    private TextView oDW;
    private TextView oDX;

    static /* synthetic */ String a(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        String string = networkDiagnoseReportUI.getString(R.l.report_mail_subject);
        File file = new File(oDd);
        if (!file.exists()) {
            return string;
        }
        String name = file.getName();
        if (bi.oW(name)) {
            return string;
        }
        int indexOf = name.indexOf(".");
        StringBuilder append = new StringBuilder().append(string).append("_");
        if (indexOf <= 0) {
            indexOf = name.length();
        }
        return append.append(name.substring(0, indexOf)).toString();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle("");
        this.oDU = (ImageView) findViewById(R.h.report_result_iv);
        this.oDV = (TextView) findViewById(R.h.report_result_tv);
        this.oDW = (TextView) findViewById(R.h.report_result_tip_tv);
        this.oDR = getIntent().getBooleanExtra("diagnose_result", false);
        if (this.oDR) {
            this.oDU.setImageResource(R.g.net_connectreport_success);
            this.oDV.setText(getString(R.l.upload_report_success));
            this.oDW.setVisibility(0);
            addTextOptionMenu(0, getString(R.l.diagnose_finish), new 1(this));
            return;
        }
        setBackBtn(new 2(this));
        oDd = getIntent().getStringExtra("diagnose_log_file_path");
        this.oDU.setImageResource(R.g.net_connectreport_fail);
        this.oDV.setText(getString(R.l.upload_report_failed));
        if (oDd != null && e.cm(oDd) > 0) {
            this.oDX = (TextView) findViewById(R.h.report_result_on_sdcard);
            this.oDX.setText(getString(R.l.report_on_sdcard, new Object[]{oDd.replace("mnt/", "")}));
            findViewById(R.h.report_result_on_sdcard).setVisibility(0);
            findViewById(R.h.send_mail_tip).setVisibility(0);
            this.oDS = (Button) findViewById(R.h.send_report_by_email);
            this.oDS.setVisibility(0);
            this.oDS.setOnClickListener(new 3(this));
            this.oDT = (Button) findViewById(R.h.view_log);
            this.oDT.setVisibility(0);
            this.oDT.setOnClickListener(new 4(this));
        }
    }

    protected final int getLayoutId() {
        return R.i.network_diagnose_report;
    }
}
