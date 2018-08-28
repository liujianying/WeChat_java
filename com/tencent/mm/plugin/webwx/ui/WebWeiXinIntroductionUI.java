package com.tencent.mm.plugin.webwx.ui;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class WebWeiXinIntroductionUI extends MMActivity {
    private Button qmG;

    protected final int getLayoutId() {
        return R.i.web_weixin_introduction;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle("");
        this.qmG = (Button) findViewById(R.h.webwx_introduction_begin_btn);
        this.qmG.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }
}
