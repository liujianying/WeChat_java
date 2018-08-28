package com.tencent.sqlitelint.behaviour.alert;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.d.b;
import com.tencent.sqlitelint.d.c;
import com.tencent.sqlitelint.d.d;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public class IssueDetailActivity extends SQLiteLintBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final SQLiteLintIssue sQLiteLintIssue = (SQLiteLintIssue) getIntent().getParcelableExtra("issue");
        if (sQLiteLintIssue != null) {
            LinearLayout linearLayout;
            setTitle(getString(d.diagnosis_detail_title));
            TextView textView = (TextView) findViewById(b.diagnosis_level_tv);
            ((TextView) findViewById(b.time_tv)).setText(SQLiteLintUtil.h("yyyy-MM-dd HH:mm", sQLiteLintIssue.createTime));
            textView.setText(SQLiteLintIssue.getLevelText(sQLiteLintIssue.level, getBaseContext()));
            if (!SQLiteLintUtil.oW(sQLiteLintIssue.desc)) {
                linearLayout = (LinearLayout) findViewById(b.desc_layout);
                ((TextView) findViewById(b.desc_tv)).setText(sQLiteLintIssue.desc);
                linearLayout.setVisibility(0);
                linearLayout.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        SLog.v("MicroMsg.IssueDetailActivity", sQLiteLintIssue.desc.replace("%", "###"), new Object[0]);
                    }
                });
            }
            if (!SQLiteLintUtil.oW(sQLiteLintIssue.detail)) {
                linearLayout = (LinearLayout) findViewById(b.detail_layout);
                textView = (TextView) findViewById(b.detail_tv);
                textView.setText(sQLiteLintIssue.detail);
                linearLayout.setVisibility(0);
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        SLog.v("MicroMsg.IssueDetailActivity", sQLiteLintIssue.detail.replace("%", "###"), new Object[0]);
                    }
                });
            }
            if (!SQLiteLintUtil.oW(sQLiteLintIssue.advice)) {
                linearLayout = (LinearLayout) findViewById(b.advice_layout);
                ((TextView) findViewById(b.advice_tv)).setText(sQLiteLintIssue.advice);
                linearLayout.setVisibility(0);
            }
            if (!SQLiteLintUtil.oW(sQLiteLintIssue.extInfo)) {
                linearLayout = (LinearLayout) findViewById(b.ext_info_layout);
                ((TextView) findViewById(b.ext_info_tv)).setText(getString(d.diagnosis_ext_info_title, new Object[]{sQLiteLintIssue.extInfo}));
                linearLayout.setVisibility(0);
            }
        }
    }

    protected final int getLayoutId() {
        return c.activity_diagnosis_detail;
    }
}
