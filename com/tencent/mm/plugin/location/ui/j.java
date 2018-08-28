package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.map.a$e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class j {
    TextView Dm;
    Context context;
    private String hOr;
    boolean kFQ = false;
    private ViewGroup kFS;
    ArrayList<String> kFT;
    private final int kFU = 100;
    private final int kFV = 1;
    private final int kFW = 2;
    private final int kFX = 3;
    private final int kFY = 4;
    private final int kFZ = 5;
    private final int kGa = 6;
    private final int kGb = 7;
    private final int kGc = 8;
    private final int kGd = 9;
    private final int kGe = 10;
    boolean kGf = true;
    private int kGg = Color.parseColor("#44FEBB");
    int kGh = Color.parseColor("#FFFFFF");
    int kGi = Color.parseColor("#E54646");
    int kGj = Color.parseColor("#FFC90C");
    boolean kGk = false;
    String kGl = "";
    ag mHandler = new 1(this, Looper.getMainLooper());

    static /* synthetic */ void a(j jVar) {
        jVar.Dm.setTextColor(jVar.kGg);
        jVar.Dm.invalidate();
    }

    static /* synthetic */ void b(j jVar) {
        jVar.mHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        jVar.mHandler.sendMessageDelayed(obtain, 100);
    }

    public j(Context context, ViewGroup viewGroup, String str) {
        this.context = context;
        this.kFS = viewGroup;
        this.Dm = (TextView) this.kFS.findViewById(a$e.title);
        this.hOr = str;
        init();
    }

    private void init() {
        x.d("MicroMsg.ShareHeaderMsgMgr", "init");
        this.Dm.invalidate();
        this.kFT = new ArrayList();
        for (String add : l.aZj().ns(this.hOr)) {
            this.kFT.add(add);
        }
        gh(false);
    }

    final void gh(boolean z) {
        this.mHandler.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Integer.valueOf(this.kFT.size());
        x.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[]{Integer.valueOf(this.kFT.size()), Boolean.valueOf(z)});
        if (z) {
            this.mHandler.sendMessageDelayed(obtain, 100);
        } else {
            this.mHandler.sendMessage(obtain);
        }
    }
}
