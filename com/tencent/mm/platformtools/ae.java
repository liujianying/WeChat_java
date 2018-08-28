package com.tencent.mm.platformtools;

import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class ae {
    public static boolean a(String str, String str2, boolean z, boolean z2, int i, int i2) {
        if (!z2) {
            return a(str, str2, z, i2);
        }
        e.b(new 1(str, str2, z, i2), "StackReportUploader_uploadFileDirect", i);
        return true;
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        return a(str, str2, z, z2, 1, 20003);
    }

    static boolean a(String str, String str2, boolean z, int i) {
        Throwable e;
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.StackReportUploader", "uploadFile param err file:%s  user:%s", new Object[]{str, str2});
            return false;
        }
        int cm = com.tencent.mm.a.e.cm(str);
        byte[] f;
        if (cm <= 0) {
            x.e("MicroMsg.StackReportUploader", "uploadFile err len file:%s len:%d", new Object[]{str, Integer.valueOf(cm)});
            return false;
        } else if (cm <= 128000) {
            f = com.tencent.mm.a.e.f(str, 0, -1);
            boolean a = a(f, str, str2, i);
            String str3 = "MicroMsg.StackReportUploader";
            String str4 = "uploadFile ret:%b size:%d file:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(a);
            objArr[1] = Integer.valueOf(f != null ? f.length : -1);
            objArr[2] = str;
            x.d(str3, str4, objArr);
            if (a && z) {
                com.tencent.mm.a.e.k(new File(str));
            }
            return a;
        } else {
            int i2 = (cm / 127988) + 1;
            byte[] bArr = new byte[128000];
            int VF = (int) bi.VF();
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                int i3 = 0;
                while (i3 < i2) {
                    try {
                        int read = fileInputStream.read(bArr, 12, 127988);
                        if (read < 0) {
                            x.e("MicroMsg.StackReportUploader", "uploadFile read failed file:%s", new Object[]{str});
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                            }
                            return false;
                        }
                        boolean a2;
                        c(VF, bArr, 0);
                        c(i3, bArr, 4);
                        c(read, bArr, 8);
                        if (read < 127988) {
                            f = new byte[(read + 12)];
                            System.arraycopy(bArr, 0, f, 0, f.length);
                            a2 = a(f, str, str2, i);
                        } else {
                            a2 = a(bArr, str, str2, i);
                        }
                        x.d("MicroMsg.StackReportUploader", "uploadFile idx:%d(%d) read:%d ret:%b size:%d file:%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(read), Boolean.valueOf(a2), Integer.valueOf(cm), str});
                        i3++;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            x.e("MicroMsg.StackReportUploader", "exception:%s", new Object[]{bi.i(e)});
                            x.e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", new Object[]{str});
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e5) {
                                }
                            }
                            throw e;
                        }
                    }
                }
                if (z) {
                    com.tencent.mm.a.e.k(new File(str));
                }
                try {
                    fileInputStream.close();
                } catch (Exception e6) {
                }
                return true;
            } catch (Exception e7) {
                e = e7;
                fileInputStream = null;
                x.e("MicroMsg.StackReportUploader", "exception:%s", new Object[]{bi.i(e)});
                x.e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", new Object[]{str});
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e42) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e52) {
                    }
                }
                throw e;
            }
        }
    }

    private static boolean c(int i, byte[] bArr, int i2) {
        if (128000 < i2 + 4) {
            return false;
        }
        bArr[i2] = (byte) ((i >> 24) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 1] = (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 2] = (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 3] = (byte) (i & WebView.NORMAL_MODE_ALPHA);
        return true;
    }

    private static boolean a(byte[] bArr, String str, String str2, int i) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.StackReportUploader", "read file failed:%s", new Object[]{str});
            return false;
        } else if (bArr.length > 128000) {
            x.e("MicroMsg.StackReportUploader", "file :%s data len error:%d", new Object[]{str, Integer.valueOf(bArr.length)});
            return false;
        } else {
            String toLowerCase = g.u(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.qVN), Integer.valueOf(bArr.length)}).getBytes()).toLowerCase();
            byte[] r = q.r(bArr);
            if (bi.bC(r)) {
                x.e("MicroMsg.StackReportUploader", "zip data failed file:%s", new Object[]{str});
                return false;
            }
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, r, toLowerCase.getBytes());
            r = pByteArray.value;
            if (bi.bC(r)) {
                x.e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", new Object[]{str});
            }
            String str3 = "http://" + ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str3 + "/cgi-bin/mmsupport-bin/stackreport?version=");
            stringBuffer.append(Integer.toHexString(d.qVN));
            stringBuffer.append("&devicetype=");
            stringBuffer.append(d.DEVICE_TYPE);
            stringBuffer.append("&filelength=");
            stringBuffer.append(r2);
            stringBuffer.append("&sum=");
            stringBuffer.append(toLowerCase);
            stringBuffer.append("&reporttype=");
            stringBuffer.append(i);
            stringBuffer.append("&reportvalue=");
            stringBuffer.append(bi.VF() + ".0.1");
            if (!(str2 == null || str2.equals(""))) {
                stringBuffer.append("&username=");
                stringBuffer.append(str2);
            }
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpPost = new HttpPost(stringBuffer.toString());
            try {
                HttpEntity byteArrayEntity = new ByteArrayEntity(r);
                byteArrayEntity.setContentType("binary/octet-stream");
                httpPost.setEntity(byteArrayEntity);
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                if (execute == null || execute.getStatusLine() == null) {
                    x.e("MicroMsg.StackReportUploader", "execute http failed resp null");
                    return false;
                } else if (execute.getStatusLine().getStatusCode() == 200) {
                    return true;
                } else {
                    x.e("MicroMsg.StackReportUploader", "error response code:%d ", new Object[]{Integer.valueOf(execute.getStatusLine().getStatusCode())});
                    return false;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.StackReportUploader", "exception:%s", new Object[]{bi.i(e)});
                x.d("MicroMsg.StackReportUploader", "execute post failed msg:%s", new Object[]{e.getMessage()});
                return false;
            }
        }
    }
}
