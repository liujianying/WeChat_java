package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.s.d;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

public class GameMessageBubbleView extends LinearLayout implements OnClickListener {
    View kaM;
    private TextView kaN;
    private ImageView kaO;
    private s kaP;
    private final long kaQ = 500;
    private long kaR = 0;
    private Context mContext;
    private boolean mHasInit = false;

    public GameMessageBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.kaO = (ImageView) findViewById(e.game_msg_bubble_icon);
            this.kaN = (TextView) findViewById(e.game_msg_bubble_desc);
            this.kaM = findViewById(e.game_msg_bubble_layout);
            setVisibility(8);
            this.mHasInit = true;
        }
    }

    public final void aVb() {
        ((b) g.l(b.class)).aSi();
        this.kaP = v.aUb();
        if (this.kaP == null) {
            this.kaM.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.kaP.aTW();
        if (this.kaP.field_msgType == 100 && (bi.oW(this.kaP.jMv.cZG) || bi.oW(this.kaP.jMv.jNg) || bi.oW(this.kaP.jMv.jNh) || !this.kaP.jMw.containsKey(this.kaP.jMv.jNh))) {
            x.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
            this.kaM.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.kaN.setText(this.kaP.jMv.cZG);
        o.Pj().a(this.kaP.jMv.jNg, this.kaO);
        this.kaM.setOnClickListener(this);
        setVisibility(0);
    }

    public void onClick(View view) {
        if (System.currentTimeMillis() - this.kaR > 500 && this.kaP != null) {
            ((b) g.l(b.class)).aSi();
            v.aUc();
            int a;
            if (this.kaP.field_msgType == 100) {
                if (!bi.oW(this.kaP.jMv.jNh)) {
                    d dVar = (d) this.kaP.jMw.get(this.kaP.jMv.jNh);
                    if (dVar != null) {
                        a = t.a(this.mContext, this.kaP, dVar, this.kaP.field_appId, TXLiveConstants.PUSH_EVT_FIRST_FRAME_AVAILABLE);
                        if (a != 0) {
                            an.a(this.mContext, 10, TXLiveConstants.PUSH_EVT_FIRST_FRAME_AVAILABLE, 1, a, 0, this.kaP.field_appId, 0, this.kaP.jNa, this.kaP.field_gameMsgId, this.kaP.jNb, null);
                        }
                        if (dVar.jNj != 4) {
                            this.kaP.field_isRead = true;
                            ((c) g.l(c.class)).aSj().c(this.kaP, new String[0]);
                        }
                    }
                }
                this.kaR = System.currentTimeMillis();
                return;
            }
            if (!(this.kaP == null || this.kaP.jMy == 3)) {
                this.kaP.field_isRead = true;
                ((c) g.l(c.class)).aSj().c(this.kaP, new String[0]);
            }
            switch (this.kaP.jMy) {
                case 1:
                    String str = this.kaP.jMk;
                    if (!bi.oW(str)) {
                        a = com.tencent.mm.plugin.game.e.c.r(this.mContext, str, "game_center_bubble");
                        break;
                    } else {
                        a = 0;
                        break;
                    }
                case 2:
                    if (!bi.oW(this.kaP.field_appId)) {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", this.kaP.field_appId);
                        bundle.putInt("game_report_from_scene", TXLiveConstants.PUSH_EVT_FIRST_FRAME_AVAILABLE);
                        a = com.tencent.mm.plugin.game.e.c.b(this.mContext, this.kaP.field_appId, null, bundle);
                        break;
                    }
                    x.e("MicroMsg.GameMessageHeaderView", "message type : " + this.kaP.field_msgType + " ,message.field_appId is null.");
                    a = 0;
                    break;
                case 3:
                    Intent intent = new Intent(this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", TXLiveConstants.PUSH_EVT_FIRST_FRAME_AVAILABLE);
                    this.mContext.startActivity(intent);
                    a = 6;
                    break;
                default:
                    x.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.kaP.jMy);
                    return;
            }
            an.a(this.mContext, 10, TXLiveConstants.PUSH_EVT_FIRST_FRAME_AVAILABLE, 1, a, 0, this.kaP.field_appId, 0, this.kaP.field_msgType, this.kaP.field_gameMsgId, this.kaP.jNb, null);
            this.kaR = System.currentTimeMillis();
        }
    }
}
