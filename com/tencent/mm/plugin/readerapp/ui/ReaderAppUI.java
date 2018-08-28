package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.readerapp.a.f;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class ReaderAppUI extends MMActivity {
    private static float density;
    private int bXq = 0;
    private View eLM;
    private d hqV = new 2(this);
    private a hql;
    private String kGv = "";
    private ListView laZ;
    private MMPullDownView lbd;
    private a<Long> mnL;
    private e mnM = null;
    private int mnN = 0;
    private b mnO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bXq = getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
        density = com.tencent.mm.bp.a.getDensity(this);
        this.mnO = new b();
        initView();
        this.kGv = bi.he(this.bXq);
        if (20 == this.bXq && t.M("newsapp", null) > 0) {
            h.mEJ.h(13440, new Object[]{Integer.valueOf(2)});
        }
    }

    public void onDestroy() {
        if (this.mnL != null) {
            this.mnL.aYc();
            this.mnL.tlG = null;
        }
        if (this.mnO != null) {
            b bVar = this.mnO;
            if (!bVar.moh.isEmpty()) {
                for (Entry entry : bVar.moh.entrySet()) {
                    String str = (String) entry.getKey();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String str2 : (Set) entry.getValue()) {
                        if (stringBuilder.length() <= 0) {
                            stringBuilder.append(str2);
                        } else {
                            stringBuilder.append("||").append(str2);
                        }
                    }
                    h.mEJ.h(15413, new Object[]{Integer.valueOf(9), str, stringBuilder.toString()});
                }
                bVar.moh.clear();
            }
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.readerapp.a.e.reader_app;
    }

    protected void onResume() {
        super.onResume();
        if (this.bXq == 20) {
            setMMTitle(g.hardcode_plugin_readerappnews_nick);
        } else {
            setMMTitle(g.hardcode_plugin_readerappweibo_nick);
        }
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().eJ(this.kGv);
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.kGv);
        ((i) com.tencent.mm.kernel.g.l(i.class)).FW().Ys(this.kGv);
        com.tencent.mm.plugin.readerapp.c.g.bpT().c(this.mnL);
        this.mnL.a(null, null);
        refresh();
    }

    protected void onPause() {
        super.onPause();
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().eJ("");
        com.tencent.mm.plugin.readerapp.c.g.bpT().d(this.mnL);
        ((i) com.tencent.mm.kernel.g.l(i.class)).FW().Ys(this.kGv);
    }

    public final void refresh() {
        TextView textView = (TextView) findViewById(com.tencent.mm.plugin.readerapp.a.d.empty_msg_tip_tv);
        textView.setText(this.bXq == 20 ? g.readerapp_news_intro : g.readerapp_weibo_intro);
        if (this.mnL.getCount() == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    protected final void initView() {
        try {
            this.mnM = new e(com.tencent.mm.sdk.platformtools.bi.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
        }
        this.laZ = (ListView) findViewById(com.tencent.mm.plugin.readerapp.a.d.reader_history_lv);
        this.lbd = (MMPullDownView) findViewById(com.tencent.mm.plugin.readerapp.a.d.reader_pull_down_view);
        this.eLM = getLayoutInflater().inflate(com.tencent.mm.plugin.readerapp.a.e.reader_app_header, null);
        this.laZ.addHeaderView(this.eLM);
        ((TextView) findViewById(com.tencent.mm.plugin.readerapp.a.d.empty_msg_tip_tv)).setText(g.readerapp_empty_msg_tip);
        if (this.bXq == 20) {
            this.mnL = new a(this, this, Long.valueOf(0));
        } else if (this.bXq == 11) {
            this.mnL = new c(this, this, Long.valueOf(0));
        }
        this.laZ.setOnScrollListener(this.mnL);
        this.laZ.setAdapter(this.mnL);
        this.laZ.setTranscriptMode(0);
        registerForContextMenu(this.laZ);
        this.hql = new a(this);
        if (this.mnL.getCount() == 0) {
            Intent intent = new Intent(this, ReaderAppIntroUI.class);
            intent.putExtra(DownloadSettingTable$Columns.TYPE, this.bXq);
            startActivity(intent);
            finish();
            return;
        }
        this.lbd.setOnTopLoadDataListener(new 3(this));
        this.lbd.setTopViewVisible(true);
        this.lbd.setAtBottomCallBack(new 4(this));
        this.lbd.setAtTopCallBack(new 5(this));
        this.lbd.setIsBottomShowAll(true);
        this.mnL.tlG = new 6(this);
        setBackBtn(new 7(this));
        addIconOptionMenu(0, g.actionbar_setting, f.actionbar_setting_icon, new 8(this));
        this.laZ.setSelection((this.mnL.bpU() - 1) + this.laZ.getHeaderViewsCount());
    }

    public final OnClickListener a(bi biVar, int i, int i2, String str) {
        b bVar = this.mnO;
        String title = biVar.getTitle();
        if (!com.tencent.mm.sdk.platformtools.bi.oW(str)) {
            Set set;
            if (bVar.moh.containsKey(str)) {
                set = (Set) bVar.moh.get(str);
            } else {
                set = new HashSet();
                bVar.moh.put(str, set);
            }
            if (!com.tencent.mm.sdk.platformtools.bi.oW(title)) {
                set.add(title);
            }
        }
        return new 9(this, i, str, biVar, i2);
    }

    private PackageInfo Kl(String str) {
        PackageInfo packageInfo = null;
        if (str.length() == 0) {
            return packageInfo;
        }
        try {
            return this.mController.tml.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
            return packageInfo;
        }
    }
}
