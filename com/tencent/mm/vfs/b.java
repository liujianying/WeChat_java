package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.mm.vfs.FileSystem.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public final class b implements Comparable<b> {
    public final Uri aMJ;
    private c uSo;

    public final /* synthetic */ int compareTo(Object obj) {
        return this.aMJ.toString().compareTo(((b) obj).aMJ.toString());
    }

    public final c cBU() {
        this.uSo = a.cBR().a(this.aMJ, this.uSo);
        return this.uSo;
    }

    public b(String str) {
        this(a.abO(str));
    }

    public b(Uri uri) {
        this.uSo = null;
        if (uri == null) {
            throw new NullPointerException("uri == null");
        }
        String path = uri.getPath();
        if (path != null) {
            path = d.i(path, false, false);
            if (!uri.getPath().equals(path)) {
                uri = uri.buildUpon().path(path).build();
            }
        }
        this.aMJ = uri;
    }

    public b(b bVar, String str) {
        this(bVar == null ? null : bVar.aMJ, str);
    }

    public b(File file, String str) {
        this(a.abO(file.getPath()), str);
    }

    private b(Uri uri, String str) {
        this.uSo = null;
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        Builder path;
        if (uri == null) {
            path = new Builder().path(str);
        } else {
            path = uri.buildUpon();
            if (!str.isEmpty()) {
                path.appendPath(str);
            }
        }
        Uri build = path.build();
        if (build.getPath() != null) {
            String i = d.i(build.getPath(), false, false);
            if (!build.getPath().equals(i)) {
                build = build.buildUpon().path(i).build();
            }
        }
        this.aMJ = build;
    }

    public final String getName() {
        String path = this.aMJ.getPath();
        int lastIndexOf = path.lastIndexOf("/");
        return lastIndexOf < 0 ? path : path.substring(lastIndexOf + 1, path.length());
    }

    public final Uri cBV() {
        String path = this.aMJ.getPath();
        int length = path.length();
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf == -1 || path.charAt(length - 1) == '/') {
            return null;
        }
        if (path.indexOf(47) == lastIndexOf && path.charAt(0) == '/') {
            path = path.substring(0, lastIndexOf + 1);
        } else {
            path = path.substring(0, lastIndexOf);
        }
        return this.aMJ.buildUpon().path(path).build();
    }

    public final b cBW() {
        Uri cBV = cBV();
        return cBV == null ? null : new b(cBV);
    }

    public final boolean canRead() {
        c cBU = cBU();
        if (!cBU.valid()) {
            return false;
        }
        FileSystem fileSystem = cBU.uSi;
        String abM = fileSystem.abM(cBU.path);
        if (abM != null) {
            return new File(abM).canRead();
        }
        return fileSystem.abJ(cBU.path);
    }

    public final boolean exists() {
        c cBU = cBU();
        if (cBU.valid()) {
            return cBU.uSi.abJ(cBU.path);
        }
        return false;
    }

    public final Uri cBX() {
        int i = 0;
        String path = this.aMJ.getPath();
        if (path.length() > 0 && path.charAt(0) == '/') {
            i = 1;
        }
        if (i != 0) {
            return this.aMJ;
        }
        path = this.aMJ.getPath();
        String property = System.getProperty("user.dir");
        if (!path.isEmpty()) {
            property = property + '/' + path;
        }
        return this.aMJ.buildUpon().path(property).build();
    }

    public final boolean isDirectory() {
        c cBU = cBU();
        if (!cBU.valid()) {
            return false;
        }
        a abK = cBU.uSi.abK(cBU.path);
        if (abK == null || !abK.uRT) {
            return false;
        }
        return true;
    }

    public final boolean isFile() {
        c cBU = cBU();
        if (!cBU.valid()) {
            return false;
        }
        a abK = cBU.uSi.abK(cBU.path);
        if (abK == null || abK.uRT) {
            return false;
        }
        return true;
    }

    public final long lastModified() {
        c cBU = cBU();
        if (!cBU.valid()) {
            return 0;
        }
        a abK = cBU.uSi.abK(cBU.path);
        if (abK != null) {
            return abK.uRS;
        }
        return 0;
    }

    public final long length() {
        c cBU = cBU();
        if (!cBU.valid()) {
            return 0;
        }
        a abK = cBU.uSi.abK(cBU.path);
        if (abK != null) {
            return abK.size;
        }
        return 0;
    }

    public final b[] cBY() {
        c cBU = cBU();
        if (!cBU.valid()) {
            return null;
        }
        List<a> abL = cBU.uSi.abL(cBU.path);
        if (abL == null) {
            return null;
        }
        b[] bVarArr = new b[abL.size()];
        int i = 0;
        for (a aVar : abL) {
            int i2 = i + 1;
            bVarArr[i] = new b(this, aVar.name);
            i = i2;
        }
        return bVarArr;
    }

    public final boolean mkdirs() {
        c cBU = cBU();
        if (cBU.valid()) {
            return cBU.uSi.mL(cBU.path);
        }
        return false;
    }

    public final boolean createNewFile() {
        c cBU = cBU();
        if (!cBU.valid()) {
            throw new FileNotFoundException("Cannot resolve path or URI: " + this.aMJ);
        } else if (cBU.uSi.abJ(cBU.path)) {
            return false;
        } else {
            cBU.uSi.mG(cBU.path).close();
            return true;
        }
    }

    public final boolean a(b bVar) {
        c cBU = cBU();
        c cBU2 = bVar.cBU();
        if (cBU.valid() && cBU2.valid() && cBU.uSi == cBU2.uSi) {
            return cBU.uSi.gl(cBU.path, cBU2.path);
        }
        return false;
    }

    public final boolean delete() {
        c cBU = cBU();
        return cBU.valid() && cBU.uSi.jy(cBU.path);
    }

    public final int hashCode() {
        return this.aMJ.toString().hashCode() ^ 1234321;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.aMJ.equals(((b) obj).aMJ);
        }
        return false;
    }
}
