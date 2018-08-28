package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q {
    static Pattern qUr = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    String ben;
    String fFQ;
    String qUo;
    String qUp;
    int qUq;

    public q(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.qUo = "";
        this.qUp = "";
        this.qUq = -1;
        this.ben = "/";
        this.fFQ = "";
        Matcher matcher = qUr.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.qUo = group.toLowerCase();
            }
            group = matcher.group(2);
            if (group != null) {
                this.fFQ = group;
            }
            group = matcher.group(3);
            if (group != null) {
                this.qUp = group;
            }
            group = matcher.group(4);
            if (group != null && group.length() > 0) {
                try {
                    this.qUq = Integer.parseInt(group);
                } catch (NumberFormatException e) {
                    throw new Exception("Bad port");
                }
            }
            String group2 = matcher.group(5);
            if (group2 != null && group2.length() > 0) {
                if (group2.charAt(0) == '/') {
                    this.ben = group2;
                } else {
                    this.ben = "/" + group2;
                }
            }
            if (this.qUq == JsApiPauseDownloadTask.CTRL_INDEX && this.qUo.equals("")) {
                this.qUo = "https";
            } else if (this.qUq == -1) {
                if (this.qUo.equals("https")) {
                    this.qUq = JsApiPauseDownloadTask.CTRL_INDEX;
                } else {
                    this.qUq = 80;
                }
            }
            if (this.qUo.equals("")) {
                this.qUo = "http";
                return;
            }
            return;
        }
        throw new Exception("Bad address");
    }

    public final String toString() {
        String str = "";
        if ((this.qUq != JsApiPauseDownloadTask.CTRL_INDEX && this.qUo.equals("https")) || (this.qUq != 80 && this.qUo.equals("http"))) {
            str = ":" + Integer.toString(this.qUq);
        }
        String str2 = "";
        if (this.fFQ.length() > 0) {
            str2 = this.fFQ + "@";
        }
        return this.qUo + "://" + str2 + this.qUp + str + this.ben;
    }
}
