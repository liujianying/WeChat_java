package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.ui.x;
import com.tencent.mm.w.a.h;

public abstract class i extends x {
    private SharedPreferences duR;
    private boolean iWf = false;
    private ListView kww;
    private boolean oyq = false;
    private long pSG;
    public h tCL;
    public boolean tDd;

    public abstract int Ys();

    public abstract boolean a(f fVar, Preference preference);

    protected int getLayoutId() {
        return h.mm_preference_fragment_list_content;
    }

    protected View getLayoutView() {
        return b.EY().a(getContext(), "R.layout.mm_preference_fragment_list_content", h.mm_preference_fragment_list_content);
    }

    public void onResume() {
        super.onResume();
        this.tCL.notifyDataSetChanged();
        this.pSG = System.currentTimeMillis();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.tDd = false;
        this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.tCL = new h(getContext(), this.duR);
        this.kww = (ListView) findViewById(16908298);
        this.tCL.b(new 1(this));
        this.kww.setAdapter(this.tCL);
        this.kww.setOnItemClickListener(new 2(this));
        this.kww.setOnItemLongClickListener(new 3(this));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public static boolean csm() {
        return false;
    }
}
