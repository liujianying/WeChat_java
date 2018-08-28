package com.tencent.sqlitelint.behaviour.alert;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.d.c;
import com.tencent.sqlitelint.d.d;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.Collection;
import java.util.List;

public class CheckResultActivity extends SQLiteLintBaseActivity {
    private a vnA;
    private String vny;
    private List<SQLiteLintIssue> vnz;

    class a extends BaseAdapter {
        private final LayoutInflater Bc;

        a() {
            this.Bc = LayoutInflater.from(CheckResultActivity.this);
        }

        public final int getCount() {
            if (CheckResultActivity.this.vnz == null) {
                return 0;
            }
            return CheckResultActivity.this.vnz.size();
        }

        private SQLiteLintIssue Ht(int i) {
            return (SQLiteLintIssue) CheckResultActivity.this.vnz.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = this.Bc.inflate(c.view_check_result_item, viewGroup, false);
                b bVar2 = new b();
                bVar2.vnC = (TextView) view.findViewById(com.tencent.sqlitelint.d.b.result_tv);
                bVar2.vnD = (TextView) view.findViewById(com.tencent.sqlitelint.d.b.diagnosis_level_tv);
                bVar2.hrV = (TextView) view.findViewById(com.tencent.sqlitelint.d.b.time_tv);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            SQLiteLintIssue Ht = Ht(i);
            bVar.vnC.setText(String.format("%d、%s", new Object[]{Integer.valueOf(i + 1), Ht.desc}));
            bVar.hrV.setText(SQLiteLintUtil.h("yyyy-MM-dd HH:mm", Ht.createTime));
            bVar.vnD.setText(SQLiteLintIssue.getLevelText(Ht.level, CheckResultActivity.this.getBaseContext()));
            return view;
        }
    }

    static class b {
        public TextView hrV;
        public TextView vnC;
        public TextView vnD;

        b() {
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vny = getIntent().getStringExtra("db_label");
        String acM = SQLiteLintUtil.acM(this.vny);
        setTitle(getString(d.check_result_title, new Object[]{acM}));
        ListView listView = (ListView) findViewById(com.tencent.sqlitelint.d.b.list);
        this.vnA = new a();
        listView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SQLiteLintIssue sQLiteLintIssue = (SQLiteLintIssue) adapterView.getItemAtPosition(i);
                Intent intent = new Intent();
                intent.putExtra("issue", sQLiteLintIssue);
                intent.setClass(CheckResultActivity.this.getBaseContext(), IssueDetailActivity.class);
                CheckResultActivity.this.startActivity(intent);
            }
        });
        listView.setAdapter(this.vnA);
        this.vnA.notifyDataSetChanged();
        cCe();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        cCe();
    }

    private void cCe() {
        Collection acK = com.tencent.sqlitelint.behaviour.a.a.acK(this.vny);
        if (this.vnz == null) {
            this.vnz = acK;
        } else {
            this.vnz.clear();
            this.vnz.addAll(acK);
        }
        SLog.d("MpApp.CheckResultActivity", "refreshData size %d", Integer.valueOf(this.vnz.size()));
        this.vnA.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return c.activity_check_result;
    }
}
