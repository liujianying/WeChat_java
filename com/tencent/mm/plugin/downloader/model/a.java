package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.z.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends h {
    private static final String ibz = (b.bnE + "BigFile");
    private byte[] dsN;
    private com.tencent.mm.plugin.cdndownloader.c.b hKd;
    private HashMap<String, Long> ibA;
    private HashMap<String, Long> ibB;
    private ConcurrentHashMap<String, Integer> ibC;
    private HashMap<String, Long> ibD;
    private HashMap<String, Long> ibE;
    private Context mContext;

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        x.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        com.tencent.mm.plugin.downloader.c.a yN = c.yN(str);
        if (yN == null) {
            x.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
        } else if (yN.field_showNotification) {
            d dVar = new d(aVar.mContext);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.ibA.put(str, Long.valueOf(currentTimeMillis));
                dVar.g(currentTimeMillis);
            } else {
                Long l = (Long) aVar.ibA.get(str);
                if (l != null) {
                    dVar.g(l.longValue());
                }
            }
            dVar.b(yN.field_fileName);
            switch (i) {
                case 1:
                    dVar.Y(17301633);
                    dVar.b(100, i2, i2 == 0);
                    dVar.c(aVar.mContext.getString(c.file_downloader_download_running));
                    dVar.j(2, true);
                    long j = yN.field_downloadId;
                    Intent intent = new Intent(aVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    dVar.pu = PendingIntent.getActivity(aVar.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 4:
                    dVar.Y(17301634);
                    dVar.u(true);
                    dVar.pu = PendingIntent.getActivity(ad.getContext(), 0, new Intent(), 0);
                    dVar.c(aVar.mContext.getString(c.file_downloader_download_failed));
                    break;
                default:
                    aVar.cancelNotification(str);
                    return;
            }
            synchronized (aVar.dsN) {
                Integer num = (Integer) aVar.ibC.get(str);
                if (num == null) {
                    aVar.ibC.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build())));
                } else {
                    ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), dVar.build());
                }
                if (i == 4) {
                    aVar.ibC.remove(str);
                }
            }
        }
    }

    public a(b bVar) {
        super(bVar);
        this.dsN = new byte[0];
        this.ibD = new HashMap();
        this.ibE = new HashMap();
        this.hKd = new 1(this);
        this.mContext = ad.getContext();
        this.ibA = new HashMap();
        this.ibB = new HashMap();
        this.ibC = new ConcurrentHashMap();
        com.tencent.mm.plugin.cdndownloader.c.a.aAk().hKd = this.hKd;
    }

    public final long a(com.tencent.mm.plugin.downloader.c.a aVar) {
        new Thread(new 2(this, aVar)).start();
        return aVar.field_downloadId;
    }

    public final long a(e eVar) {
        if (eVar == null || bi.oW(eVar.fhq)) {
            x.e("MicroMsg.FileCDNDownloader", "Invalid Request");
            return -1;
        }
        String str = eVar.fhq;
        com.tencent.mm.plugin.downloader.c.a yN = c.yN(str);
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        if (yN != null) {
            fileDownloadTaskInfo = cm(yN.field_downloadId);
            x.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + fileDownloadTaskInfo.status);
            if (fileDownloadTaskInfo.status == 1) {
                return fileDownloadTaskInfo.id;
            }
        }
        if (yN == null) {
            yN = c.yK(eVar.mAppId);
        }
        File file = new File(ibz);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdirs()) {
                    file2.renameTo(parentFile);
                } else {
                    x.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", new Object[]{parentFile.getAbsolutePath()});
                }
            }
            x.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", new Object[]{Boolean.valueOf(file.mkdirs())});
        }
        c.yL(str);
        c.yM(eVar.mAppId);
        com.tencent.mm.plugin.downloader.c.a c = f.c(eVar);
        if (!eVar.ici || yN == null) {
            c.field_downloadId = System.currentTimeMillis();
        } else {
            c.field_downloadId = yN.field_downloadId;
        }
        c.field_downloaderType = 3;
        c.field_filePath = ibz + "/" + ac.ce(str);
        if (fileDownloadTaskInfo == null || !c.field_filePath.equals(fileDownloadTaskInfo.path)) {
            c.field_startState = 0;
        } else {
            String str2 = c.field_filePath;
            str = fileDownloadTaskInfo.path;
            if (!(str2 == null || str == null || str2.equals(str))) {
                if (new File(str).exists()) {
                    x.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", new Object[]{Boolean.valueOf(new File(str).delete())});
                }
            }
            if (fileDownloadTaskInfo.status == 2) {
                c.field_startState = com.tencent.mm.plugin.downloader.a.b.ibt;
            } else if (fileDownloadTaskInfo.status == 4) {
                c.field_startState = com.tencent.mm.plugin.downloader.a.b.ibu;
            } else {
                c.field_startState = com.tencent.mm.plugin.downloader.a.b.ibs;
            }
            c.field_startSize = fileDownloadTaskInfo.icq;
            x.d("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + fileDownloadTaskInfo.icq);
        }
        c.field_startTime = System.currentTimeMillis();
        if (!eVar.fGM || ao.isWifi(ad.getContext())) {
            return a(c);
        }
        x.i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        c.field_status = 0;
        c.d(c);
        return c.field_downloadId;
    }

    private static CDNTaskInfo b(com.tencent.mm.plugin.downloader.c.a aVar) {
        CDNTaskInfo cDNTaskInfo = new CDNTaskInfo();
        cDNTaskInfo.dQc = true;
        cDNTaskInfo.mediaId = aVar.field_downloadUrl;
        cDNTaskInfo.downloadUrl = aVar.field_downloadUrl;
        cDNTaskInfo.filePath = aVar.field_filePath;
        cDNTaskInfo.hKj = aVar.field_secondaryUrl;
        cDNTaskInfo.hKl = 15;
        cDNTaskInfo.hKm = 3600;
        cDNTaskInfo.hKn = true;
        cDNTaskInfo.hKo = aVar.field_downloadInWifi;
        JSONObject jSONObject = new JSONObject();
        try {
            if (aVar.field_fileSize > 0) {
                jSONObject.put("Content-Length", aVar.field_fileSize);
            }
            cDNTaskInfo.hKk = jSONObject.toString();
        } catch (JSONException e) {
            x.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + e.getMessage());
        }
        return cDNTaskInfo;
    }

    public final int cl(long j) {
        new Thread(new 3(this, j)).start();
        return 1;
    }

    public final FileDownloadTaskInfo cm(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs != null) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
            CDNTaskState yl = com.tencent.mm.plugin.cdndownloader.c.a.aAk().yl(cs.field_downloadUrl);
            if (yl != null) {
                switch (yl.taskState) {
                    case s$l.AppCompatTheme_buttonStyle /*100*/:
                    case s$l.AppCompatTheme_buttonStyleSmall /*101*/:
                        fileDownloadTaskInfo.status = 1;
                        break;
                    case s$l.AppCompatTheme_checkboxStyle /*102*/:
                        fileDownloadTaskInfo.status = 2;
                        break;
                    default:
                        if (cs.field_status != 1) {
                            fileDownloadTaskInfo.status = cs.field_status;
                            break;
                        }
                        fileDownloadTaskInfo.status = 0;
                        break;
                }
                fileDownloadTaskInfo.icq = (long) yl.completeSize;
                fileDownloadTaskInfo.gTK = (long) yl.fileTotalSize;
                if (!(fileDownloadTaskInfo.status == 0 || fileDownloadTaskInfo.status == 5)) {
                    cs.field_downloadedSize = fileDownloadTaskInfo.icq;
                    cs.field_totalSize = fileDownloadTaskInfo.gTK;
                    c.e(cs);
                }
            } else {
                if (cs.field_status == 1) {
                    fileDownloadTaskInfo.status = 0;
                } else {
                    fileDownloadTaskInfo.status = cs.field_status;
                }
                fileDownloadTaskInfo.icq = cs.field_downloadedSize;
                fileDownloadTaskInfo.gTK = cs.field_totalSize;
            }
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.bPG = cs.field_downloaderType;
            fileDownloadTaskInfo.icr = cs.field_autoDownload;
            fileDownloadTaskInfo.path = cs.field_filePath;
            fileDownloadTaskInfo.url = cs.field_downloadUrl;
            fileDownloadTaskInfo.bKg = cs.field_md5;
        }
        return fileDownloadTaskInfo;
    }

    public final boolean cn(long j) {
        new Thread(new 4(this, j)).start();
        return true;
    }

    public final boolean co(long j) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs == null) {
            return false;
        }
        if (!cs.field_downloadInWifi || ao.isWifi(ad.getContext())) {
            new Thread(new 5(this, cs, j)).start();
            return true;
        }
        x.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask, downloadInWifi, not wifi");
        return true;
    }

    private void cancelNotification(String str) {
        synchronized (this.dsN) {
            Integer num = (Integer) this.ibC.get(str);
            if (num == null) {
                x.i("MicroMsg.FileCDNDownloader", "No notification id found");
                return;
            }
            ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
            x.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = " + num);
            this.ibC.remove(str);
        }
    }
}
