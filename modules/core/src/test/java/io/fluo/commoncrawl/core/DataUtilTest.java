package io.fluo.commoncrawl.core;

import org.junit.Assert;
import org.junit.Test;

public class DataUtilTest {

  @Test
  public void testBasic() throws Exception {

    Assert.assertEquals("http://a.b.example.com/page?1&2", DataUtil.toUrl("com.example.b.a/page?1&2"));
    Assert.assertEquals("https://a.b.example.com/page?1&2", DataUtil.toUrl("com.example.b.a:443/page?1&2"));
    Assert.assertEquals("http://a.b.example.com:8080/page?1&2", DataUtil.toUrl("com.example.b.a:8080/page?1&2"));
    Assert.assertEquals("http://b.example.com", DataUtil.toUrl("com.example.b"));
    Assert.assertEquals("http://b.example.com/", DataUtil.toUrl("com.example.b/"));

    Assert.assertEquals("com.example.b.a/page?1&2", DataUtil.toUri("http://a.b.example.com/page?1&2"));
    Assert.assertEquals("1.2.3.4:443/page?1&2", DataUtil.toUri("https://1.2.3.4/page?1&2"));
    Assert.assertEquals("1.2.3.4/page?1&2", DataUtil.toUri("http://1.2.3.4/page?1&2"));
    Assert.assertEquals("com.example/1/2/3?c&d&e", DataUtil.toUri("http://example.com/1/2/3?c&d&e"));
    Assert.assertEquals("com.example.b.a", DataUtil.toUri("http://a.b.example.com"));
    Assert.assertEquals("com.example.b.a:443/", DataUtil.toUri("https://a.b.example.com:443/"));
    Assert.assertEquals("com.example:443/", DataUtil.toUri("https://example.com/"));
    Assert.assertEquals("com.example?b", DataUtil.toUri("http://example.com?b"));
    Assert.assertEquals("com.example:80/b", DataUtil.toUri("http://example.com:80/b"));
    Assert.assertEquals("com.example/b?1#2&3#4", DataUtil.toUri("http://example.com/b?1#2&3#4"));
    Assert.assertEquals("com.example:8080/b", DataUtil.toUri("http://example.com:8080/b"));
    Assert.assertEquals("1.2.3.4////c", DataUtil.toUri("http://1.2.3.4////c"));
  }
}
