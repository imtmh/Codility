
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class AllCombOfString {
	
	public static void main(String[] args) {
		String s="kincenvizh";
		//s = s.substring(0,0);
		String st = null;
		Set<String> set = new HashSet<String>();
		for(int i = s.length();i>0;i--){
			
			//System.out.println(s);
			System.out.println(i);
			st = s.substring(0, i);
			System.out.println(st);
			//System.out.println(st);
			for (int j = st.length(); j >0; j--) {
				set.add(st.substring(0, j));				
			}
			s = s.substring(1, s.length());
			System.out.println(s);
		}
		//populate set

		System.out.println(set.size());
	}
	

}
