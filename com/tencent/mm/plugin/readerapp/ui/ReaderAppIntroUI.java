package com.tencent.mm.plugin.readerapp.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.f;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppIntroUI extends MMActivity {
    private int bXq = 0;

    protected final int getLayoutId() {
        return e.readerapp_intro;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        ImageView imageView = (ImageView) findViewById(d.readerapp_intro_iv);
        TextView textView = (TextView) findViewById(d.readerapp_intro_tv);
        this.bXq = getIntent().getIntExtra("type", 0);
        if (this.bXq == 20) {
            setMMTitle(g.hardcode_plugin_readerappnews_nick);
            imageView.setImageResource(c.readerapp_news_intro);
            textView.setText(g.contact_info_readerappnews_tip);
        }
        setBackBtn(new 1(this));
        addIconOptionMenu(0, f.actionbar_setting_icon, new 2(this));
    }
}
