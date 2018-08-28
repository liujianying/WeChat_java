package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;

public class TestTimeForChatting extends DrawedCallBackLinearLayout {
    public final String TAG = "MicroMsg.TestTimeForChatting";
    public int dtL = 0;
    a uCt;
    public int uCu = 0;
    public int uCv = 0;

    public TestTimeForChatting(Context context) {
        super(context);
    }

    public TestTimeForChatting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onDraw(canvas);
        x.i("MicroMsg.TestTimeForChatting", (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void czV() {
        x.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[]{Integer.valueOf(this.dtL)});
        h.mEJ.h(11198, new Object[]{Integer.valueOf(this.dtL)});
    }

    protected void dispatchDraw(Canvas canvas) {
        this.dtL++;
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.TestTimeForChatting", th, "dispatchDraw", new Object[0]);
        }
        g.vv(9);
        g.vv(18);
        g.vv(25);
        g.vv(24);
        g.vv(20);
        g.vv(18);
        if (this.uCt != null) {
            this.uCt.cqP();
        }
    }

    public void setOndispatchDraw(a aVar) {
        this.uCt = aVar;
    }

    public boolean fitSystemWindows(Rect rect) {
        x.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[]{rect.toString(), Integer.valueOf(this.uCu), Integer.valueOf(this.uCv)});
        rect.bottom += this.uCu;
        rect.right += this.uCv;
        return super.fitSystemWindows(rect);
    }
}
