package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;

public class LocationExtUI extends MMActivity {
    private ArrayList<String> irs = new ArrayList();
    private String kEA;
    private TextView kEy;
    private TextView kEz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bi.oW(stringExtra)) {
            findViewById(e.location_info_ll).setVisibility(8);
        } else {
            ((TextView) findViewById(e.location_text_tv)).setText(stringExtra);
        }
        this.kEy = (TextView) findViewById(e.tag_tv);
        this.kEz = (TextView) findViewById(e.remard_tv);
        this.kEy.setOnClickListener(new 1(this));
        this.kEz.setOnClickListener(new 2(this));
        a(0, getString(h.app_finish), new 3(this), b.tmX);
        setBackBtn(new 4(this));
    }

    protected final int getLayoutId() {
        return f.location_ext_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2 && intent != null) {
                CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                this.kEA = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                this.kEz.setText(this.kEA);
            }
        } else if (4098 != i) {
            super.onActivityResult(i, i2, intent);
        } else if (-1 == i2 && intent != null) {
            this.irs.clear();
            String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                CharSequence charSequence = stringArrayExtra[0];
                this.irs.add(stringArrayExtra[0]);
                String string = getResources().getString(h.favorite_tag_delimiter_1);
                for (int i3 = 1; i3 < stringArrayExtra.length; i3++) {
                    this.irs.add(stringArrayExtra[i3]);
                    charSequence = charSequence + string + stringArrayExtra[i3];
                }
                this.kEy.setText(charSequence);
            }
        }
    }
}
