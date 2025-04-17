package io.cdap.wrangler.parser;

import io.cdap.wrangler.api.parser.ByteSize;
import io.cdap.wrangler.api.parser.TimeDuration;
import org.junit.Assert;
import org.junit.Test;

public class ByteSizeAndTimeDurationTest {

    @Test
    public void testByteSizeParsing() {
        Assert.assertEquals(1024L, new ByteSize("1KB").value());
        Assert.assertEquals(1536L, new ByteSize("1.5KB").value());
        Assert.assertEquals(1048576L, new ByteSize("1MB").value());
        Assert.assertEquals(1073741824L, new ByteSize("1GB").value());
    }

    @Test
    public void testTimeDurationParsing() {
        Assert.assertEquals(1000L, new TimeDuration("1s").value());
        Assert.assertEquals(1500L, new TimeDuration("1.5s").value());
        Assert.assertEquals(60000L, new TimeDuration("1min").value());
        Assert.assertEquals(180000L, new TimeDuration("3minutes").value());
    }
}
