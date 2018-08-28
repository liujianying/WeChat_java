package com.tencent.mm.plugin.music.c.a;

import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.f;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.BitSet;
import java.util.Map;

public final class a implements IMediaHTTPConnection {
    private com.tencent.mm.plugin.music.cache.a lAg;
    public URL lAh = null;
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private String mMimeType = "";
    private long mTotalSize = -1;
    private URL mURL = null;

    public final boolean connect(URL url, Map<String, String> map) {
        String mv;
        Logger.i("MicroMsg.MMMediaHTTPConnection", "connect");
        Logger.i("MicroMsg.MMMediaHTTPConnection", "connect: uri=" + url + ", headers=" + map);
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.lAh = url;
        this.mHeaders = map;
        this.mTotalSize = -1;
        this.mMimeType = "";
        if (ad.cic()) {
            mv = ((com.tencent.mm.an.a.a) g.l(com.tencent.mm.an.a.a.class)).mv(this.mURL.toString());
            if (!(TextUtils.isEmpty(mv) || mv.equalsIgnoreCase(this.mURL.toString()))) {
                x.i("MicroMsg.MMMediaHTTPConnection", "use temp shake music url to play:%s", new Object[]{mv});
                try {
                    this.mURL = new URL(mv);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMMediaHTTPConnection", e, "playUrl", new Object[0]);
                }
            }
        }
        if (this.mURL != null) {
            e.k(this.mURL.toString(), map);
            Logger.i("MicroMsg.MMMediaHTTPConnection", "headers=" + map);
        }
        this.lAg = new com.tencent.mm.plugin.music.cache.a(this);
        com.tencent.mm.plugin.music.cache.a aVar = this.lAg;
        String url2 = aVar.lxo.lAh.toString();
        aVar.lxp = new c(url2);
        aVar.lxp.eyz = aVar.lxo.getSize();
        c cVar = aVar.lxp;
        x.i("MicroMsg.IndexBitMgr", "initData");
        if (cVar.eyz <= 0) {
            x.e("MicroMsg.IndexBitMgr", "fileLength is invalid!");
        } else {
            if (cVar.eyz % 8192 == 0 || cVar.eyz < 8192) {
                cVar.count = (int) (cVar.eyz / 8192);
            } else {
                cVar.count = ((int) (cVar.eyz / 8192)) + 1;
            }
            if (cVar.eyz <= 8192) {
                x.i("MicroMsg.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                cVar.count = 1;
            }
            x.i("MicroMsg.IndexBitMgr", "fileLength:%d, count:%d", new Object[]{Long.valueOf(cVar.eyz), Integer.valueOf(cVar.count)});
            cVar.lxw = new BitSet(cVar.count);
            cVar.lxx = e.Ij(cVar.mUrl);
            if (TextUtils.isEmpty(cVar.lxx)) {
                x.e("MicroMsg.IndexBitMgr", "initData musicId is null!'");
            } else {
                x.i("MicroMsg.IndexBitMgr", "musicId:%s", new Object[]{cVar.lxx});
                IPCAudioParamResponse iPCAudioParamResponse = (IPCAudioParamResponse) XIPCInvoker.a("com.tencent.mm", new IPCString(cVar.lxx), com.tencent.mm.plugin.music.cache.ipc.a.c.class);
                if (iPCAudioParamResponse == null) {
                    x.e("MicroMsg.IndexBitMgr", "initData pMusic is null!'");
                } else {
                    x.i("MicroMsg.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[]{Integer.valueOf(iPCAudioParamResponse.lxK)});
                    if (iPCAudioParamResponse.lxI == null || iPCAudioParamResponse.lxI.length == 0) {
                        x.e("MicroMsg.IndexBitMgr", "initData field_indexBitData is null!'");
                    } else {
                        cVar.lxw = com.tencent.mm.plugin.music.cache.c.a.aC(iPCAudioParamResponse.lxI);
                        if (cVar.lxw == null) {
                            x.e("MicroMsg.IndexBitMgr", "initData bitSet is null");
                            cVar.lxw = new BitSet(cVar.count);
                        } else if (cVar.count < cVar.lxw.cardinality()) {
                            x.e("MicroMsg.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[]{Integer.valueOf(cVar.count), Integer.valueOf(cVar.lxw.cardinality())});
                            cVar.clearCache();
                        }
                        x.i("MicroMsg.IndexBitMgr", "initData bitSet:" + cVar.lxw.toString());
                        x.i("MicroMsg.IndexBitMgr", "initData bitSet count %d, cardinality:" + cVar.count + "," + cVar.lxw.cardinality());
                    }
                }
            }
        }
        aVar.lxq = new f(url2);
        if (!new File(aVar.lxq.fileName).exists()) {
            x.i("MicroMsg.FileBytesCacheMgr", "piece file not exist, clear cache!");
            aVar.lxp.clearCache();
        } else if (aVar.lxq.bhM() != aVar.lxo.getSize() && aVar.lxo.getSize() != -1) {
            x.i("MicroMsg.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
            aVar.lxp.clearCache();
            f fVar = aVar.lxq;
            Logger.i("MicroMsg.PieceFileCache", "deleteFile");
            f.deleteFile(fVar.fileName);
        } else if (aVar.lxo.getSize() == -1) {
            x.i("MicroMsg.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
        } else {
            x.i("MicroMsg.FileBytesCacheMgr", "piece file exist!");
        }
        long size = aVar.lxo.getSize();
        f fVar2 = aVar.lxq;
        Logger.i("MicroMsg.PieceFileCache", "open");
        try {
            File file = new File(fVar2.fileName);
            if (!file.exists()) {
                x.i("MicroMsg.PieceFileCache", "create file:%b", new Object[]{Boolean.valueOf(file.createNewFile())});
            }
            fVar2.randomAccessFile = new RandomAccessFile(file, "rws");
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[]{fVar2.fileName});
        } catch (Throwable e2) {
            Logger.e("MicroMsg.PieceFileCache", "file not found", e2);
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[]{fVar2.fileName});
        } catch (Throwable e22) {
            Logger.e("MicroMsg.PieceFileCache", "io ", e22);
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[]{fVar2.fileName});
        } catch (Throwable th) {
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[]{fVar2.fileName});
        }
        aVar.lxq.setLength(size);
        e.Z(url2, size);
        x.i("MicroMsg.FileBytesCacheMgr", "attach() fileLength is " + size + ",pieceFileCache length is " + aVar.lxq.getLength());
        mv = aVar.lxo.getMIMEType();
        if (!(TextUtils.isEmpty(mv) || "application/octet-stream".equalsIgnoreCase(mv))) {
            e.dR(url2, mv);
            e.dS(url2, mv);
        }
        aVar.tH = -1;
        aVar.fi = 0;
        aVar.lxr = -1;
        aVar.lxs = 0;
        return true;
    }

    public final void disconnect() {
        Logger.i("MicroMsg.MMMediaHTTPConnection", "disconnect");
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
        if (this.lAg != null) {
            com.tencent.mm.plugin.music.cache.a aVar = this.lAg;
            aVar.bhI();
            aVar.lxp.bhK();
            aVar.lxq.close();
            aVar.lxo = null;
            x.i("MicroMsg.FileBytesCacheMgr", "detach()");
            this.lAg = null;
        }
    }

    private void teardownConnection() {
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
    }

    private static final boolean isLocalHost(URL url) {
        if (url == null) {
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", new Object[]{String.valueOf(e)});
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekTo(long r12) {
        /*
        r11 = this;
        r11.teardownConnection();
        r1 = 0;
        r2 = 0;
        r0 = r11.mURL;	 Catch:{ IOException -> 0x0114 }
        r6 = isLocalHost(r0);	 Catch:{ IOException -> 0x0114 }
        r5 = r2;
        r4 = r1;
    L_0x000d:
        if (r6 == 0) goto L_0x0065;
    L_0x000f:
        r1 = java.net.Proxy.NO_PROXY;	 Catch:{ IOException -> 0x006e }
        r0 = r0.openConnection(r1);	 Catch:{ IOException -> 0x006e }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x006e }
        r11.mConnection = r0;	 Catch:{ IOException -> 0x006e }
    L_0x0019:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x006e }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setConnectTimeout(r1);	 Catch:{ IOException -> 0x006e }
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x006e }
        r1 = r11.mAllowCrossDomainRedirect;	 Catch:{ IOException -> 0x006e }
        r0.setInstanceFollowRedirects(r1);	 Catch:{ IOException -> 0x006e }
        r7 = "Accept-Encoding";
        r3 = 0;
        r0 = r11.mHeaders;	 Catch:{ IOException -> 0x006e }
        if (r0 == 0) goto L_0x00a6;
    L_0x002f:
        r0 = r11.mHeaders;	 Catch:{ IOException -> 0x006e }
        r0 = r0.entrySet();	 Catch:{ IOException -> 0x006e }
        r8 = r0.iterator();	 Catch:{ IOException -> 0x006e }
    L_0x0039:
        r0 = r8.hasNext();	 Catch:{ IOException -> 0x006e }
        if (r0 == 0) goto L_0x00a6;
    L_0x003f:
        r0 = r8.next();	 Catch:{ IOException -> 0x006e }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ IOException -> 0x006e }
        r9 = r11.mConnection;	 Catch:{ IOException -> 0x006e }
        r1 = r0.getKey();	 Catch:{ IOException -> 0x006e }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x006e }
        r2 = r0.getValue();	 Catch:{ IOException -> 0x006e }
        r2 = (java.lang.String) r2;	 Catch:{ IOException -> 0x006e }
        r9.setRequestProperty(r1, r2);	 Catch:{ IOException -> 0x006e }
        if (r3 != 0) goto L_0x0229;
    L_0x0058:
        r0 = r0.getKey();	 Catch:{ IOException -> 0x006e }
        r0 = r7.equals(r0);	 Catch:{ IOException -> 0x006e }
        if (r0 == 0) goto L_0x0229;
    L_0x0062:
        r0 = 1;
    L_0x0063:
        r3 = r0;
        goto L_0x0039;
    L_0x0065:
        r0 = r0.openConnection();	 Catch:{ IOException -> 0x006e }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x006e }
        r11.mConnection = r0;	 Catch:{ IOException -> 0x006e }
        goto L_0x0019;
    L_0x006e:
        r0 = move-exception;
        r1 = r4;
    L_0x0070:
        r2 = -1;
        r11.mTotalSize = r2;
        r2 = 0;
        r11.mInputStream = r2;
        r2 = 0;
        r11.mConnection = r2;
        r2 = -1;
        r11.mCurrentOffset = r2;
        r2 = "MicroMsg.MMMediaHTTPConnection";
        r3 = "seekTo exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r0);
        r7 = ", response:";
        r6 = r6.append(r7);
        r1 = r6.append(r1);
        r1 = r1.toString();
        r4[r5] = r1;
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r2, r3, r4);
        throw r0;
    L_0x00a6:
        r0 = 0;
        r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00cb;
    L_0x00ac:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x006e }
        r1 = "Range";
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x006e }
        r8 = "bytes=";
        r2.<init>(r8);	 Catch:{ IOException -> 0x006e }
        r2 = r2.append(r12);	 Catch:{ IOException -> 0x006e }
        r8 = "-";
        r2 = r2.append(r8);	 Catch:{ IOException -> 0x006e }
        r2 = r2.toString();	 Catch:{ IOException -> 0x006e }
        r0.setRequestProperty(r1, r2);	 Catch:{ IOException -> 0x006e }
    L_0x00cb:
        if (r3 != 0) goto L_0x00d5;
    L_0x00cd:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x006e }
        r1 = "";
        r0.setRequestProperty(r7, r1);	 Catch:{ IOException -> 0x006e }
    L_0x00d5:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x006e }
        r1 = r0.getResponseCode();	 Catch:{ IOException -> 0x006e }
        r0 = r11.lAh;	 Catch:{ IOException -> 0x006e }
        r0 = r0.toString();	 Catch:{ IOException -> 0x006e }
        com.tencent.mm.plugin.music.cache.e.bL(r0, r1);	 Catch:{ IOException -> 0x006e }
        r0 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r1 == r0) goto L_0x00f8;
    L_0x00e8:
        r0 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r1 == r0) goto L_0x00f8;
    L_0x00ec:
        r0 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r1 == r0) goto L_0x00f8;
    L_0x00f0:
        r0 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r1 == r0) goto L_0x00f8;
    L_0x00f4:
        r0 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r1 != r0) goto L_0x01be;
    L_0x00f8:
        r2 = r5 + 1;
        r0 = 20;
        if (r2 <= r0) goto L_0x0117;
    L_0x00fe:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0114 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0114 }
        r4 = "Too many redirects: ";
        r3.<init>(r4);	 Catch:{ IOException -> 0x0114 }
        r2 = r3.append(r2);	 Catch:{ IOException -> 0x0114 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0114 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0114 }
        throw r0;	 Catch:{ IOException -> 0x0114 }
    L_0x0114:
        r0 = move-exception;
        goto L_0x0070;
    L_0x0117:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x0114 }
        r0 = r0.getRequestMethod();	 Catch:{ IOException -> 0x0114 }
        r3 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r1 != r3) goto L_0x013c;
    L_0x0121:
        r3 = "GET";
        r3 = r0.equals(r3);	 Catch:{ IOException -> 0x0114 }
        if (r3 != 0) goto L_0x013c;
    L_0x012a:
        r3 = "HEAD";
        r0 = r0.equals(r3);	 Catch:{ IOException -> 0x0114 }
        if (r0 != 0) goto L_0x013c;
    L_0x0133:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0114 }
        r2 = "Invalid redirect";
        r0.<init>(r2);	 Catch:{ IOException -> 0x0114 }
        throw r0;	 Catch:{ IOException -> 0x0114 }
    L_0x013c:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x0114 }
        r3 = "Location";
        r3 = r0.getHeaderField(r3);	 Catch:{ IOException -> 0x0114 }
        if (r3 != 0) goto L_0x0150;
    L_0x0147:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0114 }
        r2 = "Invalid redirect";
        r0.<init>(r2);	 Catch:{ IOException -> 0x0114 }
        throw r0;	 Catch:{ IOException -> 0x0114 }
    L_0x0150:
        r0 = new java.net.URL;	 Catch:{ IOException -> 0x0114 }
        r4 = r11.mURL;	 Catch:{ IOException -> 0x0114 }
        r0.<init>(r4, r3);	 Catch:{ IOException -> 0x0114 }
        r3 = r0.getProtocol();	 Catch:{ IOException -> 0x0114 }
        r4 = "https";
        r3 = r3.equals(r4);	 Catch:{ IOException -> 0x0114 }
        if (r3 != 0) goto L_0x017a;
    L_0x0164:
        r3 = r0.getProtocol();	 Catch:{ IOException -> 0x0114 }
        r4 = "http";
        r3 = r3.equals(r4);	 Catch:{ IOException -> 0x0114 }
        if (r3 != 0) goto L_0x017a;
    L_0x0171:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0114 }
        r2 = "Unsupported protocol redirect";
        r0.<init>(r2);	 Catch:{ IOException -> 0x0114 }
        throw r0;	 Catch:{ IOException -> 0x0114 }
    L_0x017a:
        r3 = r11.mURL;	 Catch:{ IOException -> 0x0114 }
        r3 = r3.getProtocol();	 Catch:{ IOException -> 0x0114 }
        r4 = r0.getProtocol();	 Catch:{ IOException -> 0x0114 }
        r3 = r3.equals(r4);	 Catch:{ IOException -> 0x0114 }
        r4 = r11.mAllowCrossProtocolRedirect;	 Catch:{ IOException -> 0x0114 }
        if (r4 != 0) goto L_0x0197;
    L_0x018c:
        if (r3 != 0) goto L_0x0197;
    L_0x018e:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0114 }
        r2 = "Cross-protocol redirects are disallowed";
        r0.<init>(r2);	 Catch:{ IOException -> 0x0114 }
        throw r0;	 Catch:{ IOException -> 0x0114 }
    L_0x0197:
        r3 = r11.mURL;	 Catch:{ IOException -> 0x0114 }
        r3 = r3.getHost();	 Catch:{ IOException -> 0x0114 }
        r4 = r0.getHost();	 Catch:{ IOException -> 0x0114 }
        r3 = r3.equals(r4);	 Catch:{ IOException -> 0x0114 }
        r4 = r11.mAllowCrossDomainRedirect;	 Catch:{ IOException -> 0x0114 }
        if (r4 != 0) goto L_0x01b4;
    L_0x01a9:
        if (r3 != 0) goto L_0x01b4;
    L_0x01ab:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0114 }
        r2 = "Cross-domain redirects are disallowed";
        r0.<init>(r2);	 Catch:{ IOException -> 0x0114 }
        throw r0;	 Catch:{ IOException -> 0x0114 }
    L_0x01b4:
        r3 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r1 == r3) goto L_0x01ba;
    L_0x01b8:
        r11.mURL = r0;	 Catch:{ IOException -> 0x0114 }
    L_0x01ba:
        r5 = r2;
        r4 = r1;
        goto L_0x000d;
    L_0x01be:
        r0 = r11.mAllowCrossDomainRedirect;	 Catch:{ IOException -> 0x0114 }
        if (r0 == 0) goto L_0x01ca;
    L_0x01c2:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x0114 }
        r0 = r0.getURL();	 Catch:{ IOException -> 0x0114 }
        r11.mURL = r0;	 Catch:{ IOException -> 0x0114 }
    L_0x01ca:
        r0 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r1 != r0) goto L_0x0203;
    L_0x01ce:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x0114 }
        r2 = "Content-Range";
        r0 = r0.getHeaderField(r2);	 Catch:{ IOException -> 0x0114 }
        r2 = -1;
        r11.mTotalSize = r2;	 Catch:{ IOException -> 0x0114 }
        if (r0 == 0) goto L_0x01f3;
    L_0x01dd:
        r2 = 47;
        r2 = r0.lastIndexOf(r2);	 Catch:{ IOException -> 0x0114 }
        if (r2 < 0) goto L_0x01f3;
    L_0x01e5:
        r2 = r2 + 1;
        r0 = r0.substring(r2);	 Catch:{ IOException -> 0x0114 }
        r2 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.getLong(r0, r2);	 Catch:{ NumberFormatException -> 0x0227 }
        r11.mTotalSize = r2;	 Catch:{ NumberFormatException -> 0x0227 }
    L_0x01f3:
        r2 = 0;
        r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0217;
    L_0x01f9:
        r0 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r1 == r0) goto L_0x0217;
    L_0x01fd:
        r0 = new java.net.ProtocolException;	 Catch:{ IOException -> 0x0114 }
        r0.<init>();	 Catch:{ IOException -> 0x0114 }
        throw r0;	 Catch:{ IOException -> 0x0114 }
    L_0x0203:
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 == r0) goto L_0x020d;
    L_0x0207:
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x0114 }
        r0.<init>();	 Catch:{ IOException -> 0x0114 }
        throw r0;	 Catch:{ IOException -> 0x0114 }
    L_0x020d:
        r0 = r11.mConnection;	 Catch:{ IOException -> 0x0114 }
        r0 = r0.getContentLength();	 Catch:{ IOException -> 0x0114 }
        r2 = (long) r0;	 Catch:{ IOException -> 0x0114 }
        r11.mTotalSize = r2;	 Catch:{ IOException -> 0x0114 }
        goto L_0x01f3;
    L_0x0217:
        r0 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0114 }
        r2 = r11.mConnection;	 Catch:{ IOException -> 0x0114 }
        r2 = r2.getInputStream();	 Catch:{ IOException -> 0x0114 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0114 }
        r11.mInputStream = r0;	 Catch:{ IOException -> 0x0114 }
        r11.mCurrentOffset = r12;	 Catch:{ IOException -> 0x0114 }
        return;
    L_0x0227:
        r0 = move-exception;
        goto L_0x01f3;
    L_0x0229:
        r0 = r3;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.c.a.a.seekTo(long):void");
    }

    public final int readAt(byte[] bArr, int i, int i2) {
        try {
            int size;
            if (this.lAg != null) {
                com.tencent.mm.plugin.music.cache.a aVar = this.lAg;
                if (bArr == null || i < 0 || i2 < 0) {
                    x.e("MicroMsg.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (aVar.lxo.getSize() <= 0) {
                    x.e("MicroMsg.FileBytesCacheMgr", "read()，fileLength is error, file length is " + aVar.lxo.getSize());
                } else {
                    if (((long) (i + i2)) > aVar.lxo.getSize()) {
                        x.e("MicroMsg.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(i + i2), Long.valueOf(aVar.lxo.getSize())});
                        size = ((int) aVar.lxo.getSize()) - i;
                    } else {
                        size = i2;
                    }
                    if (aVar.lxp.cV(i, size)) {
                        size = aVar.lxq.b(bArr, (long) i, size);
                        if (size > 0) {
                            if (size == i2) {
                                return size;
                            }
                            Logger.i("MicroMsg.MMMediaHTTPConnection", "read from cache, n%d, size %d " + size + "," + i2);
                            return size;
                        }
                    }
                }
                size = -1;
                if (size > 0) {
                    if (size == i2) {
                        return size;
                    }
                    Logger.i("MicroMsg.MMMediaHTTPConnection", "read from cache, n%d, size %d " + size + "," + i2);
                    return size;
                }
            }
            if (this.mTotalSize <= 0 || ((long) i) < this.mTotalSize || i2 <= 0) {
                Logger.d("MicroMsg.MMMediaHTTPConnection", "read from network");
                if (((long) i) != this.mCurrentOffset) {
                    seekTo((long) i);
                }
                size = this.mInputStream.read(bArr, 0, i2);
                if (size == -1) {
                    size = 0;
                }
                this.mCurrentOffset += (long) size;
                if (this.lAg == null) {
                    return size;
                }
                com.tencent.mm.plugin.music.cache.a aVar2 = this.lAg;
                if (bArr == null || i < 0 || size < 0) {
                    x.e("MicroMsg.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(size)});
                    return size;
                } else if (aVar2.lxo.getSize() <= 0) {
                    x.e("MicroMsg.FileBytesCacheMgr", "write() fileLength is error, file length is " + aVar2.lxo.getSize());
                    return size;
                } else {
                    int i3 = i + size;
                    if (((long) i3) > aVar2.lxo.getSize()) {
                        x.e("MicroMsg.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(aVar2.lxo.getSize())});
                        return size;
                    }
                    if (((long) i3) == aVar2.lxo.getSize()) {
                        aVar2.bhI();
                        aVar2.tt(i);
                        aVar2.p(bArr, i, size);
                        aVar2.bhI();
                        aVar2.tt(i);
                        return size;
                    } else if (!aVar2.tr(i) || !aVar2.tr(i3)) {
                        aVar2.bhI();
                        aVar2.tt(i);
                        aVar2.p(bArr, i, size);
                        return size;
                    } else if (aVar2.ts(i) && aVar2.ts(i3)) {
                        return size;
                    } else {
                        if (aVar2.ts(i)) {
                            aVar2.p(bArr, i, size);
                            return size;
                        }
                        aVar2.bhI();
                        aVar2.tt(i);
                        aVar2.p(bArr, i, size);
                        return size;
                    }
                }
            }
            x.e("MicroMsg.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", new Object[]{Long.valueOf(this.mTotalSize), Integer.valueOf(i), Integer.valueOf(i2)});
            return 0;
        } catch (ProtocolException e) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e);
            e.bM(this.lAh.toString(), 750);
            return -1010;
        } catch (NoRouteToHostException e2) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e2);
            e.bM(this.lAh.toString(), 751);
            return -1010;
        } catch (UnknownServiceException e3) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e3);
            e.bM(this.lAh.toString(), 752);
            return -1010;
        } catch (IOException e4) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => -1 " + e4);
            e.bM(this.lAh.toString(), 753);
            return -1;
        } catch (Exception e5) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "unknown exception " + e5);
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => -1");
            e.bM(this.lAh.toString(), 754);
            return -1;
        }
    }

    public final long getSize() {
        if (this.mTotalSize > 0) {
            return this.mTotalSize;
        }
        if (e.In(this.lAh.toString()) > 0) {
            this.mTotalSize = e.In(this.lAh.toString());
            return this.mTotalSize;
        }
        if (this.mConnection == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                seekTo(0);
                x.d("MicroMsg.MMMediaHTTPConnection", "getSize cost time :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            } catch (IOException e) {
                Logger.e("MicroMsg.MMMediaHTTPConnection", "getSize exception:%s", new Object[]{String.valueOf(e)});
                this.mTotalSize = -1;
            }
        }
        if (this.mTotalSize > 0) {
            return this.mTotalSize;
        }
        if (e.Io(this.lAh.toString()) <= 0) {
            return -1;
        }
        this.mTotalSize = e.Io(this.lAh.toString());
        return this.mTotalSize;
    }

    public final String getMIMEType() {
        if (TextUtils.isEmpty(this.mMimeType)) {
            String Im = e.Im(this.lAh.toString());
            if (TextUtils.isEmpty(Im)) {
                long currentTimeMillis;
                if (this.mConnection == null) {
                    try {
                        currentTimeMillis = System.currentTimeMillis();
                        seekTo(0);
                        Im = this.mConnection.getContentType();
                        x.d("MicroMsg.MMMediaHTTPConnection", "getMIMEType cost time :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    } catch (IOException e) {
                        Logger.e("MicroMsg.MMMediaHTTPConnection", "getMIMEType exception:%s", new Object[]{String.valueOf(e)});
                        Im = "";
                    }
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                    Im = this.mConnection.getContentType();
                    Logger.i("MicroMsg.MMMediaHTTPConnection", "getMIMEType mimeType:" + Im);
                    x.d("MicroMsg.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
                this.mMimeType = Im;
                if (!TextUtils.isEmpty(Im)) {
                    return Im;
                }
                Im = e.Il(this.lAh.toString());
                this.mMimeType = Im;
                return TextUtils.isEmpty(Im) ? "application/octet-stream" : Im;
            } else {
                this.mMimeType = Im;
                return Im;
            }
        }
        Logger.i("MicroMsg.MMMediaHTTPConnection", "getMIMEType mimeType:" + this.mMimeType);
        return this.mMimeType;
    }

    public final String getUri() {
        return this.mURL.toString();
    }
}
