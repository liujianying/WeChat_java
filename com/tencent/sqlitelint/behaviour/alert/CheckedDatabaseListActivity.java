package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
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
import com.tencent.sqlitelint.d.c;
import com.tencent.sqlitelint.d.d;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckedDatabaseListActivity extends SQLiteLintBaseActivity {
    private ListView CU;
    private a vnE;

    private static class a extends BaseAdapter {
        private final LayoutInflater Bc;
        List<String> vnG;

        a(Context context) {
            this.Bc = LayoutInflater.from(context);
        }

        public final int getCount() {
            if (this.vnG == null) {
                return 0;
            }
            return this.vnG.size();
        }

        private String jl(int i) {
            return (String) this.vnG.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = this.Bc.inflate(c.view_checked_database_item, viewGroup, false);
                b bVar2 = new b();
                bVar2.vnH = (TextView) view.findViewById(com.tencent.sqlitelint.d.b.db_path);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.vnH.setText(jl(i));
            return view;
        }
    }

    static class b {
        public TextView vnH;

        b() {
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.sqlitelint.behaviour.a.c.vnS.initialize(this);
        setTitle(getString(d.checked_database_list_title));
        this.CU = (ListView) findViewById(com.tencent.sqlitelint.d.b.list);
        this.vnE = new a(this);
        this.CU.setAdapter(this.vnE);
        this.CU.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) adapterView.getItemAtPosition(i);
                if (!SQLiteLintUtil.oW(str)) {
                    Intent intent = new Intent();
                    intent.setClass(CheckedDatabaseListActivity.this, CheckResultActivity.class);
                    intent.putExtra("db_label", str);
                    CheckedDatabaseListActivity.this.startActivity(intent);
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
        SLog.i("SQLiteLint.CheckedDatabaseListActivity", "refreshView defectiveDbList is %d", Integer.valueOf(com.tencent.sqlitelint.behaviour.a.a.cGh().size()));
        a aVar = this.vnE;
        aVar.vnG = r0;
        aVar.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return c.activity_checked_database_list;
    }
}
