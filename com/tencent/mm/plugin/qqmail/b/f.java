package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.h.a;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.plugin.qqmail.b.h.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.File;
import java.security.InvalidParameterException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public final class f extends h {
    private static final String BOUNDARY = ("WEIXIN" + System.currentTimeMillis());
    private HttpPost mco;

    public final c a(String str, String str2, b bVar, a aVar) {
        c cVar;
        int i = 0;
        x.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + bVar);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            String a = a(bVar);
            String str3 = bVar.mcA.filePath;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\r\n");
            stringBuilder.append("------" + BOUNDARY + "--\r\n");
            a aVar2 = new a(this, a, str3, stringBuilder.toString());
            this.mco = new HttpPost(h.b(str, str2, bVar.mcy));
            this.mco.setHeader("User-Agent", aBr);
            this.mco.setHeader("Host", host);
            this.mco.setHeader("Connection", "Keep-Alive");
            this.mco.setHeader("Accept-Charset", "utf-8");
            this.mco.setHeader("Cookie", h.J(bVar.mcz));
            this.mco.setEntity(aVar2);
            HttpResponse execute = defaultHttpClient.execute(this.mco);
            i = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            str3 = execute.getFirstHeader("set-cookie").getValue();
            cVar = new c(i, h.JR(str3), EntityUtils.toString(entity));
            x.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + cVar);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.HttpClientUtil", e, "", new Object[0]);
            if (i == 0) {
                i = TbsListener$ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS;
            }
            cVar = new c(i, null, null);
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
        return cVar;
    }

    public final void cancel() {
        x.d("MicroMsg.HttpClientUtil", "cancel conection.");
        if (this.mco != null && !this.mco.isAborted()) {
            this.mco.abort();
        }
    }

    private static String a(b bVar) {
        String name;
        StringBuilder stringBuilder = new StringBuilder();
        for (String name2 : bVar.mcy.keySet()) {
            stringBuilder.append("------" + BOUNDARY + "\r\n");
            stringBuilder.append("Content-Disposition: form-data; name=\"" + name2 + "\"\r\n");
            stringBuilder.append("\r\n");
            stringBuilder.append((String) bVar.mcy.get(name2));
            stringBuilder.append("\r\n");
        }
        File file = new File(bVar.mcA.filePath);
        if (file.isFile()) {
            name2 = file.getName();
            stringBuilder.append("------" + BOUNDARY + "\r\n");
            stringBuilder.append("Content-Disposition: form-data; name=\"" + bVar.mcA.bPE + "\"; filename=\"" + name2 + "\"\r\n");
            stringBuilder.append("\r\n");
            return stringBuilder.toString();
        }
        throw new InvalidParameterException("The path to upload isnot a file.");
    }
}
