package com.tencent.mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.mm.a.o;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e$a;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.b;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy extends a {
    private p.a mdr;
    private p.a mee;
    private b mef;
    private c meg;
    private l meh = new 1(this);
    private i.a mei = new 2(this);

    public ReadMailProxy(d dVar, p.a aVar) {
        super(dVar);
        this.mdr = aVar;
        this.mee = new 3(this);
    }

    public ReadMailProxy(d dVar, p.a aVar, b bVar, c cVar) {
        super(dVar);
        this.mdr = aVar;
        this.mef = bVar;
        this.meg = cVar;
        this.mee = new 4(this);
    }

    @e
    public boolean onReady() {
        if (this.mdr == null) {
            return true;
        }
        return this.mdr.onReady();
    }

    @e
    public void onSuccess(String str, Map<String, String> map) {
        if (this.mdr != null) {
            this.mdr.onSuccess(str, map);
        }
    }

    @e
    public void onError(int i, String str) {
        if (this.mdr != null) {
            this.mdr.onError(i, str);
        }
    }

    @e
    public void onComplete() {
        if (this.mdr != null) {
            this.mdr.onComplete();
        }
    }

    @e
    public void onTaskStarted(long j, String str) {
        if (this.mef != null) {
            b bVar = this.mef;
            x.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", new Object[]{Long.valueOf(j), str});
            bVar.miD.duR = ad.getContext().getSharedPreferences("QQMAIL", 4);
            if (bVar.miD.duR != null) {
                bVar.miD.duR.edit().putString("qqmail_downloadpath", str).commit();
            }
        }
    }

    @e
    public void onTaskRemoved(long j) {
        if (this.mef != null) {
            x.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskPaused(long j) {
        if (this.mef != null) {
            x.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskFinished(long j) {
        if (this.mef != null) {
            x.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskFailed(long j) {
        if (this.mef != null) {
            x.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @f
    public long get(String str, Map map, Bundle bundle) {
        p.c cVar = new p.c();
        cVar.fromBundle(bundle);
        return w.bow().b(str, map, cVar, this.mee);
    }

    @f
    public long post(String str, Map map, Bundle bundle) {
        p.c cVar = new p.c();
        cVar.fromBundle(bundle);
        return w.bow().a(str, map, cVar, this.mee);
    }

    @f
    public void cancel(long j) {
        new ag().post(new 5(this, j));
    }

    @f
    public boolean isSDCardAvailable() {
        au.HU();
        return com.tencent.mm.model.c.isSDCardAvailable();
    }

    @f
    public String getMsgContent(long j) {
        au.HU();
        return com.tencent.mm.model.c.FT().dW(j).field_content;
    }

    @f
    public void replaceMsgContent(long j, String str) {
        new ag().post(new 6(this, j, str));
    }

    @f
    public Map getCookie() {
        return w.bow().getCookie();
    }

    @f
    public void deleteMsgById(long j) {
        au.HU();
        com.tencent.mm.model.c.FT().dX(j);
    }

    @f
    public String getUserBindEmail() {
        return q.getUserBindEmail();
    }

    @f
    public void addDownloadCallback() {
        com.tencent.mm.plugin.downloader.model.d.aCU();
        com.tencent.mm.plugin.downloader.model.b.c(this.meh);
    }

    @f
    public void removeDownloadCallback() {
        com.tencent.mm.plugin.downloader.model.d.aCU();
        com.tencent.mm.plugin.downloader.model.b.aCP();
    }

    @f
    public long downloadQQMailApp(String str, String str2) {
        try {
            URL url = new URL(str);
            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            e$a e_a = new e$a();
            e_a.yQ(toURL.toString());
            e_a.yS("qqmail.apk");
            e_a.yT(str2);
            e_a.ef(true);
            e_a.ox(1);
            return com.tencent.mm.plugin.downloader.model.d.aCU().a(e_a.ick);
        } catch (Throwable e) {
            x.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.ReadMailProxy", e, "", new Object[0]);
            return -1;
        }
    }

    @f
    public int removeDownloadQQMailAppTask(long j) {
        return com.tencent.mm.plugin.downloader.model.d.aCU().cl(j);
    }

    @f
    public String getBindUin() {
        au.HU();
        return new o(bi.f((Integer) com.tencent.mm.model.c.DT().get(9, null))).toString();
    }

    @f
    public Integer showMailAppRecommend() {
        if (com.tencent.mm.sdk.platformtools.e.bxk == 1) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(bi.getInt(g.AU().G("MailApp", "ShowMailAppRecommend"), 0));
    }

    @f
    public String getMailAppEnterUlAndroid() {
        return g.AU().getMailAppEnterUlAndroid();
    }

    @f
    public String getMailAppRedirectUrlAndroid() {
        return g.AU().AK();
    }

    @f
    public Integer getMailAppDownloadStatus(long j) {
        return Integer.valueOf(com.tencent.mm.plugin.downloader.model.d.aCU().cm(j).status);
    }

    @f
    public double getMailAppDownloadProgress(long j) {
        FileDownloadTaskInfo cm = com.tencent.mm.plugin.downloader.model.d.aCU().cm(j);
        if (cm.gTK <= 0) {
            return 0.0d;
        }
        return (1.0d * ((double) cm.icq)) / ((double) cm.gTK);
    }

    @f
    public void reportKvState(int i, int i2) {
        h.mEJ.h(i, new Object[]{Integer.valueOf(i2)});
    }

    @f
    public void reportKvStates(int i, int i2, int i3) {
        h.mEJ.h(i, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    @f
    public void getUnreadMailCount() {
        i.a(this.mei);
    }

    @f
    public Object getUneradMailCountFromConfig() {
        au.HU();
        return com.tencent.mm.model.c.DT().get(aa.a.sPF, Integer.valueOf(-1));
    }
}
