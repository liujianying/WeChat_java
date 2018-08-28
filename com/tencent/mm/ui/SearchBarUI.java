package com.tencent.mm.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.mm.bw.a.e;
import com.tencent.mm.bw.a.i;
import com.tencent.mm.ui.BaseActivity.6;
import com.tencent.mm.ui.BaseActivity.c;
import com.tencent.mm.ui.ag.a;

public abstract class SearchBarUI extends BaseActivity implements a {
    ag tpU;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = c.tgS;
        1 1 = new 1(this);
        String str = "";
        BaseActivity$b baseActivity$b = new BaseActivity$b();
        baseActivity$b.tgH = 0;
        baseActivity$b.tgI = 0;
        baseActivity$b.text = str;
        baseActivity$b.eOJ = 1;
        baseActivity$b.jcS = null;
        baseActivity$b.tgM = i;
        if (baseActivity$b.tgI == e.actionbar_icon_dark_more && str.length() <= 0) {
            baseActivity$b.text = getString(i.actionbar_more);
        }
        int i2 = baseActivity$b.tgH;
        for (int i3 = 0; i3 < this.tgz.size(); i3++) {
            if (((BaseActivity$b) this.tgz.get(i3)).tgH == i2) {
                ao.s("match menu, id ：" + i2 + ", remove it", new Object[0]);
                this.tgz.remove(i3);
                break;
            }
        }
        this.tgz.add(baseActivity$b);
        new Handler().postDelayed(new 6(this), 200);
        setBackBtn(new 2(this));
    }

    public void onClickBackBtn(View view) {
        finish();
    }
}
