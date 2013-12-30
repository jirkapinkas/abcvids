package cz.jiripinkas.abcvids.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityHelper {

	public static String getPrincipalName() {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		}
		return null;
	}
}