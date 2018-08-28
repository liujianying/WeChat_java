package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI extends MMActivity {
    private ListView eVT;
    private int[] uoE = new int[2];
    private List<String> urC;
    private a urD;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.wallet_conv_list_title);
        setBackBtn(new 1(this));
        this.eVT = (ListView) findViewById(R.h.conv_list);
        this.urC = getIntent().getStringArrayListExtra("key_conversation_list");
        if (this.urC != null && this.urC.size() > 0) {
            this.urD = new a(this);
            this.eVT.setAdapter(this.urD);
            this.eVT.setOnTouchListener(new 2(this));
            this.eVT.setOnItemClickListener(new 3(this));
            this.eVT.setOnItemLongClickListener(new 4(this));
        }
    }

    protected final int getLayoutId() {
        return R.i.setting_check_wallet_unprocess_conv_list;
    }
}
