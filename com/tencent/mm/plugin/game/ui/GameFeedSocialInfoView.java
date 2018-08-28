package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedSocialInfoView extends LinearLayout {
    private TextView hVS;
    private LinearLayout jYt;
    private GameSmallAvatarList jYu;
    private TextView jYv;
    private LinearLayout jYw;

    public GameFeedSocialInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jYt = (LinearLayout) findViewById(e.avatar_layout);
        this.jYu = (GameSmallAvatarList) findViewById(e.avatar_list);
        this.jYv = (TextView) findViewById(e.avatar_desc);
        this.jYw = (LinearLayout) findViewById(e.desc);
        this.hVS = (TextView) findViewById(e.desc_text);
    }

    public void setData(w wVar) {
        if (bi.cX(wVar.jQg) && wVar.jQh == null) {
            this.jYt.setVisibility(8);
        } else {
            this.jYt.setVisibility(0);
            this.jYu.setData(wVar.jQg);
            if (wVar.jQh != null) {
                this.jYv.setText(wVar.jQh);
                this.jYv.setVisibility(0);
            } else {
                this.jYv.setVisibility(8);
            }
        }
        if (wVar.jOS != null) {
            this.jYw.setVisibility(0);
            this.hVS.setText(wVar.jOS);
            return;
        }
        this.jYw.setVisibility(8);
    }
}
