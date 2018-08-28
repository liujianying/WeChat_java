package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.az.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ba;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI extends MMActivity {
    ImageView eCl;
    String lBK = "";
    View lBL = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.nearby_friend_title);
        initView();
    }

    protected void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(R.h.say_hi_count);
        int axd = d.SG().axd();
        if (axd == 0) {
            this.lBL.setVisibility(4);
            return;
        }
        textView.setText(getResources().getQuantityString(R.j.say_hi_count_text_quantity, axd, new Object[]{Integer.valueOf(axd)}));
        this.eCl = (ImageView) findViewById(R.h.match_dlg_img);
        ba clZ = d.SG().clZ();
        if (clZ != null) {
            this.lBK = clZ.field_sayhiuser;
            b.a(this.eCl, this.lBK);
        }
    }

    public void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.nearby_friend_show_sayhi;
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        ((Button) findViewById(R.h.nearby_friend_intro_start_btn)).setOnClickListener(new 2(this));
        this.lBL = findViewById(R.h.goto_sayhi_btn);
        this.lBL.setVisibility(0);
        this.lBL.setOnClickListener(new 3(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2009 && i2 == -1) {
            finish();
        }
    }
}
