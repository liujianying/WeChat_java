package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.br.g;
import com.tencent.mm.ui.MMActivity;

public class RetransmitPreviewUI extends MMActivity {
    private TextView ih = null;
    private String text = null;

    protected final int getLayoutId() {
        return R.i.chatting_item_full_screen;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        this.text = getIntent().getStringExtra("Retr_Msg_content");
        this.ih = (TextView) findViewById(R.h.full_screen_text);
        TextView textView = this.ih;
        g cjL = g.cjL();
        ActionBarActivity actionBarActivity = this.mController.tml;
        textView.setText(cjL.a(this.text, this.ih.getTextSize()));
        setBackBtn(new 1(this));
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
