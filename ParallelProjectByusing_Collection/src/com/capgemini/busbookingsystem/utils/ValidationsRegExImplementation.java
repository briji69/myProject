package com.capgemini.busbookingsystem.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationsRegExImplementation implements ValidationsRegEx {
	@Override
	public Integer regex(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if(mat.matches()) {
			return Integer.parseInt(id);
		}else {
			return null;
		}
	}

	@Override
	public String regexemail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if(mat.matches()) {
			return email;
		}else {
			return null;
		}
	}

	@Override
	public String regexcontact(String contact) {
		Pattern pat = Pattern.compile("\\d{10}");
		Matcher mat = pat.matcher(contact);
		if(mat.matches()) {
			return contact;
		}else {
			return null;
		}
	}
}
