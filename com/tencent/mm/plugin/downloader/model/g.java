package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

final class g extends h {
    al eOf = new al(new 2(this), false);
    DownloadManager ict = ((DownloadManager) this.mContext.getSystemService("download"));
    CopyOnWriteArraySet<Long> icu = new CopyOnWriteArraySet();
    private Context mContext = ad.getContext();

    public g(b bVar) {
        super(bVar);
    }

    public final long a(a aVar) {
        return aVar.field_downloadId;
    }

    public final long a(e eVar) {
        if (eVar == null || bi.oW(eVar.fhq)) {
            x.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
            return -1;
        } else if (eVar.icg) {
            x.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", new Object[]{eVar.mAppId});
            return -1;
        } else {
            String str = eVar.fhq;
            String str2 = "";
            a yN = c.yN(str);
            if (yN != null) {
                FileDownloadTaskInfo cy = cy(yN.field_sysDownloadId);
                if (cy.status == 1) {
                    return cy.id;
                }
                str2 = yN.field_filePath;
                this.ict.remove(new long[]{yN.field_sysDownloadId});
            }
            String absolutePath = h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (!bi.oW(absolutePath)) {
                File file = new File(absolutePath);
                if (!file.exists()) {
                    boolean mkdir = file.mkdir();
                    x.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", new Object[]{Boolean.valueOf(mkdir)});
                }
            }
            if (!bi.oW(str2)) {
                File file2 = new File(str2);
                if (file2.exists()) {
                    boolean delete = file2.delete();
                    x.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", new Object[]{Boolean.valueOf(delete)});
                }
            }
            c.yL(str);
            c.yM(eVar.mAppId);
            a c = f.c(eVar);
            c.field_downloadId = System.currentTimeMillis();
            c.field_status = 0;
            c.field_downloaderType = 1;
            c.field_filePath = h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + ac.ce(str);
            c.field_startTime = System.currentTimeMillis();
            c.d(c);
            com.tencent.mm.kernel.g.Em().H(new 1(this, eVar, c));
            return c.field_downloadId;
        }
    }

    public final int cl(long j) {
        int remove;
        Exception e;
        d.aCU();
        if (d.cu(j)) {
            d.aCU();
            long cv = d.cv(j);
            return this.ict.remove(new long[]{cv});
        }
        a cs = c.cs(j);
        if (cs == null) {
            x.e("MicroMsg.FileDownloaderImpl23", "Invalid id");
            return 0;
        }
        try {
            remove = this.ict.remove(new long[]{cs.field_sysDownloadId});
            try {
                x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", new Object[]{Long.valueOf(j)});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", new Object[]{Long.valueOf(j), e.toString()});
                e.deleteFile(cs.field_filePath);
                x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", new Object[]{cs.field_filePath});
                cs.field_status = 5;
                c.e(cs);
                this.ibT.cp(j);
                this.icu.remove(Long.valueOf(j));
                return remove;
            }
        } catch (Exception e3) {
            e = e3;
            remove = 0;
        }
        e.deleteFile(cs.field_filePath);
        x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", new Object[]{cs.field_filePath});
        cs.field_status = 5;
        c.e(cs);
        this.ibT.cp(j);
        this.icu.remove(Long.valueOf(j));
        return remove;
    }

    public final FileDownloadTaskInfo cm(long j) {
        d.aCU();
        FileDownloadTaskInfo cy;
        if (d.cu(j)) {
            d.aCU();
            cy = cy(d.cv(j));
            cy.id = j;
            cy.bPG = 1;
            return cy;
        }
        a cs = c.cs(j);
        if (cs == null) {
            return new FileDownloadTaskInfo();
        }
        if (cs.field_status == 4 || cs.field_status == 2 || cs.field_status == 5 || cs.field_status == 3) {
            this.icu.remove(Long.valueOf(j));
        }
        cy = new FileDownloadTaskInfo();
        cy.id = cs.field_downloadId;
        cy.url = cs.field_downloadUrl;
        cy.status = cs.field_status;
        cy.path = cs.field_filePath;
        cy.bKg = cs.field_md5;
        cy.icr = cs.field_autoDownload;
        cy.bPG = cs.field_downloaderType;
        cy.icq = cs.field_downloadedSize;
        cy.gTK = cs.field_totalSize;
        return cy;
    }

    final long g(a aVar) {
        try {
            Request request = new Request(Uri.parse(aVar.field_downloadUrl));
            request.setAllowedNetworkTypes(3);
            request.setShowRunningNotification(aVar.field_showNotification);
            request.setVisibleInDownloadsUi(aVar.field_showNotification);
            if (!bi.oW(aVar.field_fileName)) {
                request.setTitle(aVar.field_fileName);
            }
            request.setDestinationUri(Uri.fromFile(new File(aVar.field_filePath)));
            long enqueue = this.ict.enqueue(request);
            if (enqueue > 0) {
                return enqueue;
            }
            x.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
            return -1;
        } catch (Exception e) {
            x.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", new Object[]{e.toString(), aVar.field_downloadUrl});
            return -1;
        }
    }

    private FileDownloadTaskInfo cy(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        Query query = new Query();
        query.setFilterById(new long[]{j});
        try {
            Cursor query2 = this.ict.query(query);
            if (query2 == null) {
                x.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
            } else {
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex("status");
                    int columnIndex2 = query2.getColumnIndex("uri");
                    int columnIndex3 = query2.getColumnIndex("local_uri");
                    int columnIndex4 = query2.getColumnIndex("bytes_so_far");
                    int columnIndex5 = query2.getColumnIndex("total_size");
                    if (columnIndex != -1) {
                        try {
                            switch (query2.getInt(columnIndex)) {
                                case 1:
                                case 2:
                                    fileDownloadTaskInfo.status = 1;
                                    break;
                                case 4:
                                    fileDownloadTaskInfo.status = 2;
                                    break;
                                case 8:
                                    fileDownloadTaskInfo.status = 3;
                                    break;
                                case 16:
                                    fileDownloadTaskInfo.status = 4;
                                    break;
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[]{e.toString()});
                            fileDownloadTaskInfo.status = 4;
                        }
                    }
                    if (columnIndex2 != -1) {
                        fileDownloadTaskInfo.url = query2.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        String string = query2.getString(columnIndex3);
                        if (bi.oW(string)) {
                            x.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
                        } else {
                            x.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", new Object[]{string});
                            fileDownloadTaskInfo.path = Uri.parse(string).getPath();
                            x.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", new Object[]{fileDownloadTaskInfo.path});
                        }
                    }
                    if (columnIndex4 != -1) {
                        fileDownloadTaskInfo.icq = query2.getLong(columnIndex4);
                    }
                    if (columnIndex5 != -1) {
                        fileDownloadTaskInfo.gTK = query2.getLong(columnIndex5);
                    }
                }
                query2.close();
                x.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", new Object[]{Long.valueOf(j), Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path});
            }
        } catch (Exception e2) {
            x.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[]{e2.toString(), Long.valueOf(j)});
        }
        return fileDownloadTaskInfo;
    }

    public final boolean cn(long j) {
        FileDownloadTaskInfo cm = cm(j);
        if (cm == null) {
            x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        }
        this.icu.remove(Long.valueOf(j));
        if (cm.status != 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", new Object[]{Long.valueOf(j)});
            return true;
        }
        x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", new Object[]{Long.valueOf(j), Integer.valueOf(cl(j))});
        if (cl(j) > 0) {
            return true;
        }
        return false;
    }

    public final boolean co(long j) {
        a cs = c.cs(j);
        if (cs == null) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (cs.field_downloaderType != 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", new Object[]{Long.valueOf(j)});
            e.deleteFile(cs.field_filePath);
            c.ct(j);
            return false;
        } else if (cs.field_status == 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", new Object[]{Long.valueOf(j)});
            return false;
        } else {
            this.ict.remove(new long[]{cs.field_sysDownloadId});
            long g = g(cs);
            if (g > 0) {
                this.icu.add(Long.valueOf(cs.field_downloadId));
                if (this.eOf.ciq()) {
                    this.eOf.J(100, 100);
                }
                cs.field_sysDownloadId = g;
                cs.field_status = 1;
                c.e(cs);
                return true;
            }
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
            return false;
        }
    }
}
