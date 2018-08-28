package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.modeltools.f.c;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.k;
import com.tencent.xweb.WebView.b;

public final class h implements OnCreateContextMenuListener {
    private MMActivity fcq;
    public k gcQ;
    String gcR;
    public int gcS;
    public int gcT;
    public f gcU;
    b gcV;
    b gcW;
    private c gda = new 1(this);
    private com.tencent.mm.plugin.game.gamewebview.e.b jIZ;
    private e jJi;

    static /* synthetic */ String c(h hVar) {
        return hVar.jIZ != null ? hVar.jIZ.getUrl() : "";
    }

    public h(MMActivity mMActivity, com.tencent.mm.plugin.game.gamewebview.e.b bVar, e eVar) {
        this.fcq = mMActivity;
        this.jIZ = bVar;
        this.jJi = eVar;
        this.gcQ = new k(mMActivity);
        this.gcQ.a(this.jIZ, this, null);
        this.gcQ.d(new 2(this));
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        x.d("MicroMsg.GameWebViewMenuListHelper", "onCreateContextMenu");
        b hitTestResult;
        if (view instanceof WebView) {
            hitTestResult = this.jIZ.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                    return;
                }
                return;
            }
            return;
        }
        hitTestResult = this.jIZ.getHitTestResult();
        if (hitTestResult == null) {
            return;
        }
        if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
            a(contextMenu, hitTestResult);
        }
    }

    private boolean a(ContextMenu contextMenu, String str) {
        if (com.tencent.mm.compatible.util.f.zZ()) {
            boolean aSn = d.aSn();
            contextMenu.setHeaderTitle(R.l.wv_image);
            x.i("MicroMsg.GameWebViewMenuListHelper", "hasSetAcc = %b", Boolean.valueOf(aSn));
            if (aSn) {
                contextMenu.add(0, 0, 0, this.fcq.getString(R.l.readerapp_alert_retransmit)).setOnMenuItemClickListener(new 4(this, str));
            }
            contextMenu.add(0, 0, 0, this.fcq.getString(R.l.save_to_local)).setOnMenuItemClickListener(new 5(this, str));
            if (aSn) {
                contextMenu.add(0, 0, 0, this.fcq.getString(R.l.plugin_favorite_opt)).setOnMenuItemClickListener(new 6(this, str));
            }
            if (this.gcR == null) {
                return false;
            }
            CharSequence string;
            String str2 = this.gcR;
            if (this.gcS == 22) {
                string = this.fcq.getString(R.l.recog_wxcode_of_image_file);
            } else {
                string = this.fcq.getString(R.l.recog_qbar_of_image_file);
            }
            contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new 7(this, str2));
            this.gcR = null;
            return true;
        }
        x.e("MicroMsg.GameWebViewMenuListHelper", "SD card unavailable");
        return true;
    }

    final void a(ContextMenu contextMenu, b bVar) {
        if (!a(contextMenu, bVar.mExtra) && this.jJi.bVS().cgh() && aTg()) {
            this.gcW = bVar;
            this.gcU = new f();
            this.gcU.a(this.jIZ, this.gda);
        }
    }

    final void b(ContextMenu contextMenu, b bVar) {
        if (!a(contextMenu, bVar.mExtra) && this.jJi.bVS().cgh() && aTg()) {
            this.gcV = bVar;
            this.gcU = new f();
            this.gcU.a(this.jIZ, this.gda);
        }
    }

    private static boolean aTg() {
        CommonLogicTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 5;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.jfZ.getBoolean("allow_webview_scan", false);
    }
}
