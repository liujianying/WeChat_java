package com.tencent.mm.plugin.nearby.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;

public class NearbyFriendsIntroUI extends MMActivity {
    private Button eGn;
    private View lBE;
    private CheckBox lBF;
    private c lBH = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.nearby_friend_title);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.nearby_friend_intro;
    }

    protected final void initView() {
        this.lBE = View.inflate(this, R.i.lbs_open_dialog_view, null);
        this.lBF = (CheckBox) this.lBE.findViewById(R.h.lbs_open_dialog_cb);
        this.lBF.setChecked(false);
        this.eGn = (Button) findViewById(R.h.nearby_friend_intro_start_btn);
        this.eGn.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }
}
