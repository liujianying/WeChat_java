package org.b.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.b.b.b;
import org.b.d.i;
import org.b.g.c;
import org.b.g.d;

public final class g implements a, f {
    private static final Pattern vKr = Pattern.compile("oauth_token=([^&]+)");
    private static final Pattern vKs = Pattern.compile("oauth_token_secret=([^&]*)");

    public final i adT(String str) {
        d.gE(str, "Response body is incorrect. Can't extract a token from an empty string");
        return new i(g(str, vKr), g(str, vKs), str);
    }

    private static String g(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() > 0) {
            return c.decode(matcher.group(1));
        }
        throw new b("Response body is incorrect. Can't extract token and secret from this: '" + str + "'", null);
    }
}
