package com.tencent.mm.plugin.downloader.d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.support.v4.app.z.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends h {
    private byte[] dsN = new byte[0];
    HashMap<String, Long> ibD = new HashMap();
    HashMap<String, Long> ibE = new HashMap();
    private HashMap<String, Long> icE = new HashMap();
    HashMap<String, Long> icF = new HashMap();
    private ConcurrentHashMap<String, Integer> icG = new ConcurrentHashMap();
    HashSet<Long> icH = new HashSet();
    Map<String, String> icI = null;
    al icJ = new al(Looper.getMainLooper(), new 4(this), false);
    private ITMAssistantDownloadSDKClientListener icK = new 5(this);
    private TMAssistantDownloadSDKClient mClient = null;
    Context mContext = ad.getContext();

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        com.tencent.mm.plugin.downloader.c.a yN = c.yN(str);
        if (yN == null) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification failed: null task info");
        } else if (yN.field_showNotification) {
            d dVar = new d(aVar.mContext);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.icE.put(str, Long.valueOf(currentTimeMillis));
                dVar.g(currentTimeMillis);
            } else {
                Long l = (Long) aVar.icE.get(str);
                if (l != null) {
                    dVar.g(l.longValue());
                }
            }
            dVar.b(yN.field_fileName);
            switch (i) {
                case 1:
                case 2:
                case 3:
                    dVar.Y(17301633);
                    dVar.b(100, i2, i2 == 0);
                    dVar.c(aVar.mContext.getString(b.c.file_downloader_download_running));
                    dVar.j(2, true);
                    long j = yN.field_downloadId;
                    Intent intent = new Intent(aVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    dVar.pu = PendingIntent.getActivity(aVar.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 4:
                case 6:
                    aVar.cancelNotification(str);
                    return;
                case 5:
                    dVar.Y(17301634);
                    dVar.u(true);
                    dVar.pu = PendingIntent.getActivity(ad.getContext(), 0, new Intent(), 0);
                    dVar.c(aVar.mContext.getString(b.c.file_downloader_download_failed));
                    break;
            }
            synchronized (aVar.dsN) {
                if (z) {
                    aVar.icG.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build())));
                } else {
                    Integer num = (Integer) aVar.icG.get(str);
                    if (num != null) {
                        ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), dVar.build());
                    }
                }
            }
        }
    }

    public a(com.tencent.mm.plugin.downloader.model.b bVar) {
        super(bVar);
        Map hashMap = new HashMap();
        String property = System.getProperty("http.agent");
        x.i("MicroMsg.FileDownloaderImplTMAssistant", property);
        if (bi.oW(property)) {
            property = "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)";
        }
        property = property + " MicroMessenger";
        PackageInfo packageInfo = getPackageInfo(this.mContext, ad.getPackageName());
        if (packageInfo != null) {
            property = ((property + "/") + packageInfo.versionName) + packageInfo.versionCode;
        }
        x.i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", new Object[]{property + " NetType/" + ao.getNetTypeString(ad.getContext())});
        hashMap.put("User-Agent", property);
        this.icI = hashMap;
    }

    public final long a(com.tencent.mm.plugin.downloader.c.a aVar) {
        g.Em().H(new 1(this, aVar));
        return aVar.field_downloadId;
    }

    public final long a(e eVar) {
        if (eVar == null || bi.oW(eVar.fhq)) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
            return -1;
        }
        String str = eVar.fhq;
        String str2 = eVar.mAppId;
        com.tencent.mm.plugin.downloader.c.a yN = c.yN(str);
        if (yN != null) {
            FileDownloadTaskInfo cm = cm(yN.field_downloadId);
            if (cm.status == 1) {
                return cm.id;
            }
        }
        if (yN == null) {
            yN = c.yK(str2);
        }
        aDf();
        c.yL(str);
        c.yM(str2);
        com.tencent.mm.plugin.downloader.c.a c = f.c(eVar);
        if (!eVar.ici || yN == null) {
            c.field_downloadId = System.currentTimeMillis();
        } else {
            c.field_downloadId = yN.field_downloadId;
        }
        c.field_status = 0;
        c.field_downloaderType = 2;
        c.field_startTime = System.currentTimeMillis();
        if (yN == null) {
            c.field_startState = 0;
        } else if (yN.field_status == 2) {
            c.field_startState = com.tencent.mm.plugin.downloader.a.b.ibt;
        } else if (yN.field_status == 4) {
            c.field_startState = com.tencent.mm.plugin.downloader.a.b.ibt;
        } else {
            c.field_startState = com.tencent.mm.plugin.downloader.a.b.ibs;
        }
        if (eVar.icf) {
            c.field_md5 = f.yV(c.field_downloadUrl);
        }
        c.d(c);
        if (!eVar.fGM || ao.isWifi(ad.getContext())) {
            return a(c);
        }
        x.i("MicroMsg.FileDownloaderImplTMAssistant", "downloadInWifi, not wifi");
        return c.field_downloadId;
    }

    public final int cl(long j) {
        g.Em().H(new 2(this, j));
        return 1;
    }

    public final FileDownloadTaskInfo cm(long j) {
        final FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        final com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs == null || bi.oW(cs.field_downloadUrl)) {
            return fileDownloadTaskInfo;
        }
        fileDownloadTaskInfo.url = cs.field_downloadUrl;
        fileDownloadTaskInfo.status = cs.field_status;
        fileDownloadTaskInfo.path = cs.field_filePath;
        fileDownloadTaskInfo.icq = cs.field_downloadedSize;
        fileDownloadTaskInfo.gTK = cs.field_totalSize;
        fileDownloadTaskInfo.bKg = cs.field_md5;
        return (FileDownloadTaskInfo) new bd<FileDownloadTaskInfo>(fileDownloadTaskInfo) {
            private FileDownloadTaskInfo aDg() {
                try {
                    TMAssistantDownloadTaskInfo downloadTaskState = a.a(a.this).getDownloadTaskState(fileDownloadTaskInfo.url);
                    if (downloadTaskState == null) {
                        if (fileDownloadTaskInfo.status == 1) {
                            fileDownloadTaskInfo.status = 0;
                        }
                        return fileDownloadTaskInfo;
                    }
                    switch (downloadTaskState.mState) {
                        case 1:
                        case 2:
                            fileDownloadTaskInfo.status = 1;
                            break;
                        case 3:
                            fileDownloadTaskInfo.status = 2;
                            break;
                        default:
                            if (fileDownloadTaskInfo.status == 1) {
                                fileDownloadTaskInfo.status = 0;
                                break;
                            }
                            break;
                    }
                    fileDownloadTaskInfo.path = downloadTaskState.mSavePath;
                    fileDownloadTaskInfo.icq = downloadTaskState.mReceiveDataLen;
                    fileDownloadTaskInfo.gTK = downloadTaskState.mTotalDataLen;
                    x.i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: appId: %s, status: %d, url: %s, path: %s", new Object[]{cs.field_appId, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path});
                    return fileDownloadTaskInfo;
                } catch (Exception e) {
                    x.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + e.toString());
                }
            }
        }.a(g.Em().cil());
    }

    final boolean aDe() {
        if (this.icH == null || this.icH.size() == 0) {
            TMAssistantDownloadSDKManager.getInstance(this.mContext).releaseDownloadSDKClient("WechatDownloadClient");
            if (this.mClient != null) {
                this.mClient.unRegisterDownloadTaskListener(this.icK);
            }
            this.mClient = null;
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
            try {
                this.mContext.stopService(new Intent(this.mContext, TMAssistantDownloadSDKService.class));
            } catch (Exception e) {
                x.e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + e.toString());
            }
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
            return true;
        }
        x.i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
        return false;
    }

    final void cancelNotification(String str) {
        synchronized (this.dsN) {
            Integer num = (Integer) this.icG.get(str);
            if (num == null) {
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
                return;
            }
            ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = " + num);
            this.icG.remove(str);
        }
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
            return packageInfo;
        }
    }

    private static void aDf() {
        if (!new File(TMAssistantFile.getSavePathRootDir() + "/.tmp/").exists()) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", new Object[]{Boolean.valueOf(new File(TMAssistantFile.getSavePathRootDir() + "/.tmp/").mkdirs())});
        }
    }

    public final boolean cn(long j) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs == null || bi.oW(cs.field_downloadUrl)) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (cs.field_downloaderType != 2) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", new Object[]{Long.valueOf(j)});
            com.tencent.mm.a.e.deleteFile(cs.field_filePath);
            c.ct(j);
            return false;
        } else {
            g.Em().H(new 6(this, cs, j));
            return true;
        }
    }

    public final boolean co(long j) {
        x.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: id = " + j);
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs == null || bi.oW(cs.field_downloadUrl)) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (cs.field_downloaderType != 2) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", new Object[]{Long.valueOf(j)});
            com.tencent.mm.a.e.deleteFile(cs.field_filePath);
            c.ct(j);
            return false;
        } else {
            cs.field_startTime = System.currentTimeMillis();
            if (cs.field_status == 2) {
                cs.field_startState = com.tencent.mm.plugin.downloader.a.b.ibt;
            } else if (cs.field_status == 4) {
                cs.field_startState = com.tencent.mm.plugin.downloader.a.b.ibu;
            } else {
                cs.field_startState = com.tencent.mm.plugin.downloader.a.b.ibs;
            }
            cs.field_startSize = cs.field_downloadedSize;
            cs.field_errCode = 0;
            aDf();
            if (!cs.field_downloadInWifi || ao.isWifi(ad.getContext())) {
                g.Em().H(new 7(this, cs, j));
                return true;
            }
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask downloadInWifi, not wifi");
            return true;
        }
    }
}
