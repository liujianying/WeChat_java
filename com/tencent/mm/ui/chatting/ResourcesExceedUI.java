package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class ResourcesExceedUI extends MMActivity {
    private TextView tMH;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("clean_view_type", 0);
        setMMTitle("");
        initView();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.tMH = (TextView) findViewById(R.h.download_fail_text);
        switch (this.type) {
            case 0:
                this.tMH.setText(R.l.video_fail_or_clean);
                return;
            case 1:
                this.tMH.setText(R.l.imgdownload_fail_or_cleaned);
                return;
            case 2:
                this.tMH.setText(R.l.file_fail_or_clean);
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.resources_exceed_ui;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
