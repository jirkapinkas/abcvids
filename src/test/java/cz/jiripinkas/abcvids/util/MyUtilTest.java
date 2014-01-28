package cz.jiripinkas.abcvids.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyUtilTest {

	@Test
	public void test() {
		assertEquals("mochten", MyUtil.transformNameToShortName("möchten"));
		assertEquals("mussen", MyUtil.transformNameToShortName("müssen"));
		assertEquals("nahen", MyUtil.transformNameToShortName("nähen"));
		assertEquals("hinreissen", MyUtil.transformNameToShortName("hinreißen"));
		assertEquals("stromen", MyUtil.transformNameToShortName("strömen"));
	}

}
