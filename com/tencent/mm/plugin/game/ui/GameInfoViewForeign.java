package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.x;

public class GameInfoViewForeign extends RelativeLayout {
    private int cYz = 0;
    private int jNv = 0;
    private TextView jYY;
    private int jYZ = 2;
    private OnClickListener jZa = new 1(this);
    private Context mContext;

    public GameInfoViewForeign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this.jZa);
        this.jYY = (TextView) findViewById(e.game_msg_unread_count);
        aUW();
        x.i("MicroMsg.GameInfoViewForeign", "initView finished");
    }

    public final void aUW() {
        this.cYz = ((c) g.l(c.class)).aSj().aUf();
        if (this.cYz > 0 && this.cYz <= 99) {
            this.jYY.setVisibility(0);
            this.jYY.setText(this.cYz);
        } else if (this.cYz > 99) {
            this.jYY.setVisibility(0);
            this.jYY.setText("99+");
            this.jYY.setTextSize(1, 9.0f);
        } else {
            this.jYY.setVisibility(4);
        }
    }

    public void setSourceScene(int i) {
        this.jNv = i;
    }
}
