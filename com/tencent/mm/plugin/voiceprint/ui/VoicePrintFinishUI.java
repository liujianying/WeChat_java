package com.tencent.mm.plugin.voiceprint.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI extends MMActivity {
    private TextView gsY;
    private TextView oGm;
    private Button oGn;
    private ImageView oGo;
    private int oGp;

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.oGp = getIntent().getIntExtra("kscene_type", 73);
        x.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", Integer.valueOf(this.oGp));
        this.gsY = (TextView) findViewById(R.h.voice_print_title);
        this.oGm = (TextView) findViewById(R.h.voice_print_title_tip);
        this.oGn = (Button) findViewById(R.h.right_btn);
        this.oGo = (ImageView) findViewById(R.h.voice_print_sucesss_icon);
        switch (this.oGp) {
            case 72:
                this.gsY.setText(R.l.voice_regeist_finish);
                this.oGm.setText(R.l.voice_regeist_finish_tip);
                this.oGo.setVisibility(0);
                this.oGn.setText(R.l.settings_voiceprint_unlock);
                break;
            case 73:
                this.gsY.setVisibility(8);
                this.oGm.setText(R.l.voice_unlock_ok_tip);
                this.oGo.setVisibility(0);
                this.oGn.setText(R.l.settings_voiceprint_unlock_finish);
                break;
        }
        this.oGn.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.voice_print_finish;
    }
}
