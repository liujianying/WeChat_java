package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.ak.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class a implements b {
    public final com.tencent.mm.ak.a.d.b mb(String str) {
        int i;
        Throwable e;
        String str2 = "";
        String str3 = "";
        try {
            com.tencent.mm.network.b.b bVar = new com.tencent.mm.network.b.b(str);
            if (!bi.oW(bVar.ip)) {
                str2 = bVar.ip;
            }
            str3 = bVar.ip;
            i = bVar.erZ;
            try {
                return a.c(str, bVar);
            } catch (ProtocolException e2) {
                e = e2;
            } catch (InterruptedException e3) {
                e = e3;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
                h.mEJ.a(315, 0, 1, false);
                return new com.tencent.mm.ak.a.d.b(null, null);
            } catch (UnknownHostException e4) {
                e = e4;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
                h.mEJ.a(315, 1, 1, false);
                return new com.tencent.mm.ak.a.d.b(null, null);
            } catch (SSLHandshakeException e5) {
                e = e5;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
                h.mEJ.a(315, 2, 1, false);
                return new com.tencent.mm.ak.a.d.b(null, null);
            } catch (SocketException e6) {
                e = e6;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
                h.mEJ.a(315, 3, 1, false);
                return new com.tencent.mm.ak.a.d.b(null, null);
            } catch (SocketTimeoutException e7) {
                e = e7;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
                h.mEJ.a(315, 4, 1, false);
                return new com.tencent.mm.ak.a.d.b(null, null);
            } catch (IOException e8) {
                e = e8;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
                h.mEJ.a(315, 5, 1, false);
                return new com.tencent.mm.ak.a.d.b(null, null);
            } catch (Exception e9) {
                e = e9;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bi.i(e)});
                h.mEJ.a(315, 6, 1, false);
                return new com.tencent.mm.ak.a.d.b(null, null);
            }
        } catch (ProtocolException e10) {
            e = e10;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bi.i(e)});
            h.mEJ.a(315, 7, 1, false);
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (InterruptedException e11) {
            e = e11;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
            h.mEJ.a(315, 0, 1, false);
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (UnknownHostException e12) {
            e = e12;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
            h.mEJ.a(315, 1, 1, false);
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (SSLHandshakeException e13) {
            e = e13;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
            h.mEJ.a(315, 2, 1, false);
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (SocketException e14) {
            e = e14;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
            h.mEJ.a(315, 3, 1, false);
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (SocketTimeoutException e15) {
            e = e15;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
            h.mEJ.a(315, 4, 1, false);
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (IOException e16) {
            e = e16;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, r3, r2, Integer.valueOf(i), bi.i(e)});
            h.mEJ.a(315, 5, 1, false);
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (Exception e17) {
            e = e17;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bi.i(e)});
            h.mEJ.a(315, 6, 1, false);
            return new com.tencent.mm.ak.a.d.b(null, null);
        }
    }
}
