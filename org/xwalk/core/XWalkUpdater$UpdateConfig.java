package org.xwalk.core;

public class XWalkUpdater$UpdateConfig {
    public int apkVer = -1;
    public boolean bUseCdn;
    public String downUrl;
    public String downloadFileMd5;
    public boolean isMatchMd5 = false;
    public boolean isPatchUpdate;
    public String patchEndFileMd5;
    public String versionDetail;

    public XWalkUpdater$UpdateConfig(String str, boolean z, int i) {
        this.isPatchUpdate = z;
        this.downUrl = str;
        this.apkVer = i;
        if (!checkValid()) {
            throw new RuntimeException("royle:UpdateConfig is not valid");
        }
    }

    public XWalkUpdater$UpdateConfig(String str, boolean z, String str2, String str3, int i) {
        this.downloadFileMd5 = str;
        this.isPatchUpdate = z;
        this.patchEndFileMd5 = str2;
        this.downUrl = str3;
        this.apkVer = i;
        if (!checkValid()) {
            throw new RuntimeException("royle:UpdateConfig is not valid");
        }
    }

    public String getDownloadPath() {
        if (!checkValid()) {
            throw new RuntimeException("royle:UpdateConfig is not valid");
        } else if (this.isPatchUpdate) {
            return XWalkEnvironment.getDownloadPatchPath(this.apkVer);
        } else {
            return XWalkEnvironment.getDownloadZipDir(this.apkVer);
        }
    }

    public int getUpdateBizType() {
        if (this.isPatchUpdate) {
            return 2;
        }
        return 1;
    }

    public boolean checkValid() {
        if ((this.isMatchMd5 && (this.downloadFileMd5 == null || this.downloadFileMd5.isEmpty())) || this.downUrl == null || this.downUrl.isEmpty() || this.apkVer == -1) {
            return false;
        }
        if (this.isMatchMd5 && this.isPatchUpdate && (this.patchEndFileMd5 == null || this.patchEndFileMd5.isEmpty())) {
            return false;
        }
        return true;
    }

    public String getLogSelf() {
        if (checkValid()) {
            return "UpdateConfig isMatchMd5:" + this.isMatchMd5 + " downloadFileMd5:" + this.downloadFileMd5 + ",isPatchUpdate:" + this.isPatchUpdate + ",downUrl:" + this.downUrl + ",apkVer:" + this.apkVer + ",downloadPath:" + getDownloadPath() + ".";
        }
        return "UpdateConfig is not valid";
    }
}
