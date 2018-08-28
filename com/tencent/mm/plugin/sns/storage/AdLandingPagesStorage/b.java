package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.AsyncTask;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b extends AsyncTask<String, Void, String> {
    private static Set<String> nIe = Collections.synchronizedSet(new HashSet());
    private String filePath;
    private boolean nGl;
    private int nGm;
    private a nIf;
    private int scene = 0;

    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (((String) obj) == null) {
            this.nIf.bxp();
        } else {
            this.nIf.bxo();
        }
    }

    public b(String str, boolean z, int i, a aVar) {
        this.filePath = str;
        this.nGl = z;
        this.nGm = i;
        this.nIf = aVar;
    }

    private String z(String... strArr) {
        Exception e;
        Throwable th;
        if (FileOp.cn(this.filePath)) {
            return null;
        }
        if (nIe.contains(strArr[0])) {
            return "downloading";
        }
        long VF = bi.VF();
        int i = 0;
        int i2 = 0;
        nIe.add(strArr[0]);
        FileOp.mL(this.filePath.substring(0, this.filePath.lastIndexOf("/")));
        OutputStream outputStream = null;
        HttpURLConnection httpURLConnection = null;
        this.nIf.bzS();
        String str;
        String ce;
        int bzb;
        int bH;
        d dVar;
        InputStream inputStream;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(strArr[0]).openConnection();
            try {
                httpURLConnection2.connect();
                i = httpURLConnection2.getResponseCode();
                if (i != 200) {
                    this.nIf.bxo();
                    str = "Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage();
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    nIe.remove(strArr[0]);
                    ce = ac.ce(strArr[0]);
                    bzb = bzb();
                    bH = (int) bi.bH(VF);
                    dVar = new d();
                    dVar.r("20UrlMd5", ce + ",");
                    dVar.r("21MediaType", bzb + ",");
                    dVar.r("22IsPreload", (this.nGl ? 1 : 0) + ",");
                    dVar.r("23CostTime", bH + ",");
                    dVar.r("24RetCode", i + ",");
                    dVar.r("25Scene", this.scene + ",");
                    dVar.r("26Size", "0,");
                    dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                    h.mEJ.h(13572, new Object[]{dVar});
                    return str;
                }
                httpURLConnection2.getContentLength();
                inputStream = httpURLConnection2.getInputStream();
                try {
                    OutputStream fileOutputStream = new FileOutputStream(this.filePath);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            bzb = inputStream.read(bArr);
                            int bzb2;
                            d dVar2;
                            if (bzb == -1) {
                                try {
                                    fileOutputStream.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (IOException e2) {
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                nIe.remove(strArr[0]);
                                ce = ac.ce(strArr[0]);
                                bzb2 = bzb();
                                bzb = (int) bi.bH(VF);
                                dVar2 = new d();
                                dVar2.r("20UrlMd5", ce + ",");
                                dVar2.r("21MediaType", bzb2 + ",");
                                dVar2.r("22IsPreload", (this.nGl ? 1 : 0) + ",");
                                dVar2.r("23CostTime", bzb + ",");
                                dVar2.r("24RetCode", i + ",");
                                dVar2.r("25Scene", this.scene + ",");
                                dVar2.r("26Size", i2 + ",");
                                dVar2.r("27StartDownloadTime", (VF / 1000) + ",");
                                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar2.wF());
                                h.mEJ.h(13572, new Object[]{dVar2});
                                return null;
                            } else if (isCancelled()) {
                                inputStream.close();
                                try {
                                    fileOutputStream.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (IOException e3) {
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                nIe.remove(strArr[0]);
                                ce = ac.ce(strArr[0]);
                                bzb2 = bzb();
                                bzb = (int) bi.bH(VF);
                                dVar2 = new d();
                                dVar2.r("20UrlMd5", ce + ",");
                                dVar2.r("21MediaType", bzb2 + ",");
                                dVar2.r("22IsPreload", (this.nGl ? 1 : 0) + ",");
                                dVar2.r("23CostTime", bzb + ",");
                                dVar2.r("24RetCode", i + ",");
                                dVar2.r("25Scene", this.scene + ",");
                                dVar2.r("26Size", i2 + ",");
                                dVar2.r("27StartDownloadTime", (VF / 1000) + ",");
                                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar2.wF());
                                h.mEJ.h(13572, new Object[]{dVar2});
                                return null;
                            } else {
                                fileOutputStream.write(bArr, 0, bzb);
                                i2 += bzb;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        httpURLConnection = httpURLConnection2;
                        outputStream = fileOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        outputStream = fileOutputStream;
                    }
                } catch (Exception e5) {
                    e = e5;
                    httpURLConnection = httpURLConnection2;
                    try {
                        this.nIf.bxo();
                        FileOp.deleteFile(this.filePath);
                        i = -1;
                        str = e.toString();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                nIe.remove(strArr[0]);
                                ce = ac.ce(strArr[0]);
                                bzb = bzb();
                                bH = (int) bi.bH(VF);
                                dVar = new d();
                                dVar.r("20UrlMd5", ce + ",");
                                dVar.r("21MediaType", bzb + ",");
                                dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
                                dVar.r("23CostTime", bH + ",");
                                dVar.r("24RetCode", "-1,");
                                dVar.r("25Scene", this.scene + ",");
                                dVar.r("26Size", i2 + ",");
                                dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                                h.mEJ.h(13572, new Object[]{dVar});
                                return str;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        nIe.remove(strArr[0]);
                        ce = ac.ce(strArr[0]);
                        bzb = bzb();
                        bH = (int) bi.bH(VF);
                        dVar = new d();
                        dVar.r("20UrlMd5", ce + ",");
                        dVar.r("21MediaType", bzb + ",");
                        if (this.nGl) {
                        }
                        dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
                        dVar.r("23CostTime", bH + ",");
                        dVar.r("24RetCode", "-1,");
                        dVar.r("25Scene", this.scene + ",");
                        dVar.r("26Size", i2 + ",");
                        dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                        x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                        h.mEJ.h(13572, new Object[]{dVar});
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = httpURLConnection2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e7) {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            nIe.remove(strArr[0]);
                            ce = ac.ce(strArr[0]);
                            bzb = bzb();
                            bH = (int) bi.bH(VF);
                            dVar = new d();
                            dVar.r("20UrlMd5", ce + ",");
                            dVar.r("21MediaType", bzb + ",");
                            dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
                            dVar.r("23CostTime", bH + ",");
                            dVar.r("24RetCode", i + ",");
                            dVar.r("25Scene", this.scene + ",");
                            dVar.r("26Size", i2 + ",");
                            dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                            h.mEJ.h(13572, new Object[]{dVar});
                            throw th;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    nIe.remove(strArr[0]);
                    ce = ac.ce(strArr[0]);
                    bzb = bzb();
                    bH = (int) bi.bH(VF);
                    dVar = new d();
                    dVar.r("20UrlMd5", ce + ",");
                    dVar.r("21MediaType", bzb + ",");
                    if (this.nGl) {
                    }
                    dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
                    dVar.r("23CostTime", bH + ",");
                    dVar.r("24RetCode", i + ",");
                    dVar.r("25Scene", this.scene + ",");
                    dVar.r("26Size", i2 + ",");
                    dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                    h.mEJ.h(13572, new Object[]{dVar});
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e72) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        nIe.remove(strArr[0]);
                        ce = ac.ce(strArr[0]);
                        bzb = bzb();
                        bH = (int) bi.bH(VF);
                        dVar = new d();
                        dVar.r("20UrlMd5", ce + ",");
                        dVar.r("21MediaType", bzb + ",");
                        dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
                        dVar.r("23CostTime", bH + ",");
                        dVar.r("24RetCode", i + ",");
                        dVar.r("25Scene", this.scene + ",");
                        dVar.r("26Size", i2 + ",");
                        dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                        x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                        h.mEJ.h(13572, new Object[]{dVar});
                        throw th;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                nIe.remove(strArr[0]);
                ce = ac.ce(strArr[0]);
                bzb = bzb();
                bH = (int) bi.bH(VF);
                dVar = new d();
                dVar.r("20UrlMd5", ce + ",");
                dVar.r("21MediaType", bzb + ",");
                if (this.nGl) {
                }
                dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
                dVar.r("23CostTime", bH + ",");
                dVar.r("24RetCode", i + ",");
                dVar.r("25Scene", this.scene + ",");
                dVar.r("26Size", i2 + ",");
                dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                h.mEJ.h(13572, new Object[]{dVar});
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            inputStream = null;
            this.nIf.bxo();
            FileOp.deleteFile(this.filePath);
            i = -1;
            str = e.toString();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e62) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    nIe.remove(strArr[0]);
                    ce = ac.ce(strArr[0]);
                    bzb = bzb();
                    bH = (int) bi.bH(VF);
                    dVar = new d();
                    dVar.r("20UrlMd5", ce + ",");
                    dVar.r("21MediaType", bzb + ",");
                    dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
                    dVar.r("23CostTime", bH + ",");
                    dVar.r("24RetCode", "-1,");
                    dVar.r("25Scene", this.scene + ",");
                    dVar.r("26Size", i2 + ",");
                    dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                    h.mEJ.h(13572, new Object[]{dVar});
                    return str;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            nIe.remove(strArr[0]);
            ce = ac.ce(strArr[0]);
            bzb = bzb();
            bH = (int) bi.bH(VF);
            dVar = new d();
            dVar.r("20UrlMd5", ce + ",");
            dVar.r("21MediaType", bzb + ",");
            if (this.nGl) {
            }
            dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
            dVar.r("23CostTime", bH + ",");
            dVar.r("24RetCode", "-1,");
            dVar.r("25Scene", this.scene + ",");
            dVar.r("26Size", i2 + ",");
            dVar.r("27StartDownloadTime", (VF / 1000) + ",");
            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
            h.mEJ.h(13572, new Object[]{dVar});
            return str;
        } catch (Throwable th32) {
            th = th32;
            inputStream = null;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e722) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    nIe.remove(strArr[0]);
                    ce = ac.ce(strArr[0]);
                    bzb = bzb();
                    bH = (int) bi.bH(VF);
                    dVar = new d();
                    dVar.r("20UrlMd5", ce + ",");
                    dVar.r("21MediaType", bzb + ",");
                    dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
                    dVar.r("23CostTime", bH + ",");
                    dVar.r("24RetCode", i + ",");
                    dVar.r("25Scene", this.scene + ",");
                    dVar.r("26Size", i2 + ",");
                    dVar.r("27StartDownloadTime", (VF / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
                    h.mEJ.h(13572, new Object[]{dVar});
                    throw th;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            nIe.remove(strArr[0]);
            ce = ac.ce(strArr[0]);
            bzb = bzb();
            bH = (int) bi.bH(VF);
            dVar = new d();
            dVar.r("20UrlMd5", ce + ",");
            dVar.r("21MediaType", bzb + ",");
            if (this.nGl) {
            }
            dVar.r("22IsPreload", (this.nGl ? 0 : 1) + ",");
            dVar.r("23CostTime", bH + ",");
            dVar.r("24RetCode", i + ",");
            dVar.r("25Scene", this.scene + ",");
            dVar.r("26Size", i2 + ",");
            dVar.r("27StartDownloadTime", (VF / 1000) + ",");
            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.wF());
            h.mEJ.h(13572, new Object[]{dVar});
            throw th;
        }
    }

    private int bzb() {
        switch (this.nGm) {
            case s$l.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
            case s$l.AppCompatTheme_listDividerAlertDialog /*44*/:
            case s$l.AppCompatTheme_actionDropDownStyle /*45*/:
            case 1000000001:
                return 1;
            case s$l.AppCompatTheme_popupWindowStyle /*61*/:
                return 2;
            case s$l.AppCompatTheme_editTextColor /*62*/:
                return 3;
            default:
                return 0;
        }
    }
}
