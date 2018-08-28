package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public abstract class MMPreference extends MMActivity {
    public SharedPreferences duR;
    private boolean iWf = false;
    public ListView kww;
    private boolean oyq = false;
    public h tCL;
    protected RelativeLayout tCM;
    protected TextView tCN;
    protected ImageView tCO;

    public abstract int Ys();

    public abstract boolean a(f fVar, Preference preference);

    public int getLayoutId() {
        return h.mm_preference_list_content;
    }

    public boolean Yy() {
        return true;
    }

    public void onResume() {
        if (Yy()) {
            this.tCL.notifyDataSetChanged();
        }
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.tCL = a(this.duR);
        this.kww = (ListView) findViewById(16908298);
        this.tCM = (RelativeLayout) findViewById(g.preference_tips_banner_view);
        this.tCN = (TextView) findViewById(g.preference_tips_banner_tv);
        this.tCO = (ImageView) findViewById(g.preference_tips_banner_close);
        int auY = auY();
        if (auY != -1) {
            this.kww.addHeaderView(getLayoutInflater().inflate(auY, null));
        }
        View ayg = ayg();
        if (ayg != null) {
            if (ayg.getLayoutParams() != null) {
                ayg.setLayoutParams(new LayoutParams(ayg.getLayoutParams()));
            } else {
                x.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
            }
            this.kww.addFooterView(ayg);
        }
        View btw = btw();
        if (btw != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(g.preference_bottom);
            frameLayout.addView(btw);
            frameLayout.setVisibility(0);
        }
        this.tCL.b(new 1(this));
        auY = Ys();
        if (auY != -1) {
            this.tCL.addPreferencesFromResource(auY);
        }
        this.kww.setAdapter(this.tCL);
        this.kww.setOnItemClickListener(new 2(this));
        this.kww.setOnItemLongClickListener(new 3(this));
        this.kww.setOnScrollListener(new 4(this));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public static boolean csm() {
        return false;
    }

    public final void setSelection(int i) {
        this.kww.setSelection(i);
    }

    public int auY() {
        return -1;
    }

    public View ayg() {
        return null;
    }

    public View btw() {
        return null;
    }

    public h a(SharedPreferences sharedPreferences) {
        return new h(this, sharedPreferences);
    }
}
