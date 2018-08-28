package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.a.o;
import com.tencent.mm.ak.a.b.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

class a$a {
    private static u b(String str, b bVar) {
        u a = com.tencent.mm.network.b.a(str, bVar);
        String str2 = "";
        if (au.HX()) {
            r2 = new Object[4];
            au.HU();
            r2[1] = o.getString(c.Df());
            r2[2] = Integer.valueOf(ao.getNetTypeForStat(ad.getContext()));
            r2[3] = Integer.valueOf(ao.getStrength(ad.getContext()));
            str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r2);
        }
        x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", new Object[]{str2});
        a.setRequestMethod("GET");
        a.setRequestProperty("referer", str2);
        a.setConnectTimeout(15000);
        a.setReadTimeout(20000);
        return a;
    }

    public static com.tencent.mm.ak.a.d.b c(String str, b bVar) {
        Throwable e;
        u b = b(str, bVar);
        if (b == null) {
            x.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "open connection failed.");
        }
        if (b.getResponseCode() == 302) {
            try {
                x.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "302 redirect: %s", new Object[]{str});
                String headerField = b.getHeaderField("location");
                if (!bi.oW(headerField)) {
                    b bVar2 = new b(headerField);
                    try {
                        b.aBv.disconnect();
                        b = b(headerField, bVar2);
                        bVar = bVar2;
                    } catch (Exception e2) {
                        e = e2;
                        bVar = bVar2;
                        x.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", e, "httpURLConnectionGet 302 redirect", new Object[0]);
                        if (com.tencent.mm.network.b.a(b) != 0) {
                            InputStream inputStream = b.getInputStream();
                            if (inputStream == null) {
                                x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", new Object[]{str});
                                return null;
                            }
                            String contentType = b.aBv.getContentType();
                            byte[] a = e.a(inputStream, false);
                            b.aBv.disconnect();
                            return new com.tencent.mm.ak.a.d.b(a, contentType);
                        }
                        x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", new Object[]{str, bVar.ip, bVar.ip, Integer.valueOf(bVar.erZ), Integer.valueOf(b.getResponseCode())});
                        switch (b.getResponseCode()) {
                            case 404:
                                h.mEJ.a(315, 8, 1, false);
                                break;
                            case 502:
                                h.mEJ.a(315, 9, 1, false);
                                break;
                            case 503:
                                h.mEJ.a(315, 10, 1, false);
                                break;
                            case 504:
                                h.mEJ.a(315, 11, 1, false);
                                break;
                            default:
                                h.mEJ.a(315, 12, 1, false);
                                break;
                        }
                        return null;
                    }
                }
            } catch (Throwable e3) {
                e = e3;
                x.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", e, "httpURLConnectionGet 302 redirect", new Object[0]);
                if (com.tencent.mm.network.b.a(b) != 0) {
                    x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", new Object[]{str, bVar.ip, bVar.ip, Integer.valueOf(bVar.erZ), Integer.valueOf(b.getResponseCode())});
                    switch (b.getResponseCode()) {
                        case 404:
                            h.mEJ.a(315, 8, 1, false);
                            break;
                        case 502:
                            h.mEJ.a(315, 9, 1, false);
                            break;
                        case 503:
                            h.mEJ.a(315, 10, 1, false);
                            break;
                        case 504:
                            h.mEJ.a(315, 11, 1, false);
                            break;
                        default:
                            h.mEJ.a(315, 12, 1, false);
                            break;
                    }
                    return null;
                }
                InputStream inputStream2 = b.getInputStream();
                if (inputStream2 == null) {
                    x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", new Object[]{str});
                    return null;
                }
                String contentType2 = b.aBv.getContentType();
                byte[] a2 = e.a(inputStream2, false);
                b.aBv.disconnect();
                return new com.tencent.mm.ak.a.d.b(a2, contentType2);
            }
        }
        if (com.tencent.mm.network.b.a(b) != 0) {
            x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", new Object[]{str, bVar.ip, bVar.ip, Integer.valueOf(bVar.erZ), Integer.valueOf(b.getResponseCode())});
            switch (b.getResponseCode()) {
                case 404:
                    h.mEJ.a(315, 8, 1, false);
                    break;
                case 502:
                    h.mEJ.a(315, 9, 1, false);
                    break;
                case 503:
                    h.mEJ.a(315, 10, 1, false);
                    break;
                case 504:
                    h.mEJ.a(315, 11, 1, false);
                    break;
                default:
                    h.mEJ.a(315, 12, 1, false);
                    break;
            }
            return null;
        }
        InputStream inputStream22 = b.getInputStream();
        if (inputStream22 == null) {
            x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", new Object[]{str});
            return null;
        }
        String contentType22 = b.aBv.getContentType();
        byte[] a22 = e.a(inputStream22, false);
        b.aBv.disconnect();
        return new com.tencent.mm.ak.a.d.b(a22, contentType22);
    }
}
