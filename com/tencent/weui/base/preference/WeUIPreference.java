package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.ui.BaseActivity;

public abstract class WeUIPreference extends BaseActivity {
    private SharedPreferences duR;
    private boolean iWf = false;
    private ListView kww;
    private boolean oyq = false;
    protected RelativeLayout tCM;
    protected TextView tCN;
    protected ImageView tCO;
    private b vzz;

    public abstract int Ys();

    protected void onResume() {
        this.vzz.notifyDataSetChanged();
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.vzz = new b(this, this.duR);
        this.kww = (ListView) findViewById(16908298);
        this.tCM = (RelativeLayout) findViewById(f.preference_tips_banner_view);
        this.tCN = (TextView) findViewById(f.preference_tips_banner_tv);
        this.tCO = (ImageView) findViewById(f.preference_tips_banner_close);
        b bVar = this.vzz;
        bVar.vzC = new 1(this);
        bVar.notifyDataSetChanged();
        int Ys = Ys();
        if (Ys != -1) {
            b bVar2 = this.vzz;
            bVar2.tDb = true;
            bVar2.vzB.a(Ys, bVar2);
            bVar2.tDb = false;
            bVar2.notifyDataSetChanged();
        }
        this.kww.setAdapter(this.vzz);
        this.kww.setOnItemClickListener(new 2(this));
        this.kww.setOnItemLongClickListener(new 3(this));
        this.kww.setOnScrollListener(new 4(this));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }
}
